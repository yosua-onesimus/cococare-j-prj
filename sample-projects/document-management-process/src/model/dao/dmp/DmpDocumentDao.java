package model.dao.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import model.mdl.dmp.DmpDao;
import model.obj.dmp.DmpDocument;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class DmpDocumentDao extends DmpDao {

    @Override
    protected Class getEntity() {
        return DmpDocument.class;
    }
}