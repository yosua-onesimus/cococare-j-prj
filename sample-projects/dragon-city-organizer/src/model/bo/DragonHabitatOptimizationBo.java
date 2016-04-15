package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.getString;
import static cococare.common.CCFormat.pack;
import cococare.database.CCHibernateBo;
import java.util.List;
import model.dao.DragonDao;
import model.dao.HabitatDao;
import model.dao.HabitatTypeDao;
import model.obj.Dragon;
import model.obj.Habitat;
import model.obj.HabitatType;
//</editor-fold>

public class DragonHabitatOptimizationBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private HabitatTypeDao habitatTypeDao;
    private HabitatDao habitatDao;
    private DragonDao dragonDao;
    //
    private HabitatBo habitatBo = new HabitatBo();
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized boolean execute() {
        boolean success = true;
        //1. update habitat to null
        success &= dragonDao.updateHabitatToNull() > -1;
        //2. delete all habitat
        success &= habitatDao.deleteAll() > -1;
        //3. optimization begin
        List<HabitatType> habitatTypes = habitatTypeDao.getListUnlimited();
        for (int index = habitatTypes.size() - 1; index >= 0; index--) {
            HabitatType habitatType = habitatTypes.get(index);
            List<Dragon> dragons = dragonDao.getListUnlimitedBy(habitatType, false);
            if (!dragons.isEmpty()) {
                //3.1. create habitat
                double habitatCount = Math.ceil((double) dragons.size() / (double) (habitatType.getMaxDragons() - 1));
                for (int i = 0; i < habitatCount; i++) {
                    Habitat habitat = new Habitat();
                    habitat.setCode("H" + pack(habitatType.getId().toString(), "0", 2) + pack(getString(i + 1), "0", 2));
                    habitat.setHabitatType(habitatType);
                    habitat.setNo(i + 1);
                    success &= habitatDao.saveOrUpdate(habitat);
                }
                //3.2. distribute dragon
                for (Dragon dragon : dragons) {
                    Habitat habitat = habitatDao.getMinTotalRevenuesBy(habitatType);
                    dragon.setHabitat(habitat);
                    success &= dragonDao.saveOrUpdate(dragon);
                    success &= habitatBo.saveOrUpdate(habitat);
                }
            }
        }
        return success;
    }
//</editor-fold>
}