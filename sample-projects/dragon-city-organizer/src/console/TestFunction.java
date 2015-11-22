package console;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCClass;
import cococare.database.CCEntityBo;
import cococare.database.CCHibernate;
import cococare.datafile.CCFile;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.mdl.util.UtilityModule;
import java.util.List;
import model.mdl.DragonCityOrganizerModule;
import model.obj.Habitat;
//</editor-fold>

public class TestFunction {

    private static CCHibernate hibernate;

//<editor-fold defaultstate="collapsed" desc=" _initHibernate() ">
    private static void _initHibernate() {
        CFApplCtrl.APPL_CODE = "dragon-city-organizer";
        hibernate = new CCHibernate();
        hibernate.loadDatabaseConfig(CCFile.getFileSystConfFile("dtbs.conf"));
        UtilityModule.INSTANCE.init(hibernate);
        DragonCityOrganizerModule.INSTANCE.init(hibernate);
        hibernate.buildSessionFactories();
    }
//</editor-fold>

    public static void main(String[] args) {
        _initHibernate();
        List<Habitat> habitats = CCEntityBo.INSTANCE.getListBy(Habitat.class, "", "", "");
        for (Habitat habitat : habitats) {
            System.out.println(habitat.getNo() + ": " + CCClass.getCCField(habitat, "dragons").getValue());
        }
    }
}