package model.mdl.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCHibernate;
import cococare.database.CCHibernateModule;
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
    public void init(CCHibernate hibernate) {
        super.init(hibernate);
        //
        hibernate.addAnnotatedClass(DmpTag.class);
        hibernate.addAnnotatedClass(DmpDocument.class);
        hibernate.addAnnotatedClass(DmpDocumentTag.class);
        hibernate.addAnnotatedClass(DmpDocumentReference.class);
    }
//</editor-fold>
}