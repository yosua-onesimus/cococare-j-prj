package model.mdl.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernateModule;
import java.util.Arrays;
import java.util.List;
import model.obj.dmp.DmpDocument;
import model.obj.dmp.DmpDocumentReference;
import model.obj.dmp.DmpDocumentTag;
import model.obj.dmp.DmpTag;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class DmpModule extends CCHibernateModule {

    public static DmpModule INSTANCE = new DmpModule();

//<editor-fold defaultstate="collapsed" desc=" public method ">
    @Override
    protected List<Class> _getAnnotatedClasses() {
        return (List) Arrays.asList(
                DmpTag.class,
                DmpDocument.class,
                DmpDocumentTag.class,
                DmpDocumentReference.class);
    }
//</editor-fold>
}