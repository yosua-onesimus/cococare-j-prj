package model.bo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCFormat.parseInt;
import cococare.database.CCHibernateBo;
import model.dao.DragonDao;
import model.dao.HabitatDao;
import model.obj.Habitat;
//</editor-fold>

public class HabitatBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private HabitatDao habitatDao;
    private DragonDao dragonDao;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" public method ">
    public synchronized boolean saveOrUpdate(Habitat habitat) {
        habitat.setTotalDragon(parseInt(dragonDao.countBy(habitat)));
        habitat.setTotalRevenues(dragonDao.sumRevenuesBy(habitat));
        return habitatDao.saveOrUpdate(habitat);
    }
//</editor-fold>
}