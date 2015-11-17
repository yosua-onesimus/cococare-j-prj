package model.dao.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import java.util.List;
import model.mdl.dmp.DmpDao;
import model.obj.dmp.DmpDocument;
import model.obj.dmp.DmpDocumentTag;
import model.obj.dmp.DmpTag;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class DmpDocumentTagDao extends DmpDao {

//<editor-fold defaultstate="collapsed" desc=" private method ">
    @Override
    protected Class getEntity() {
        return DmpDocumentTag.class;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public List<DmpTag> getListUnlimitedBy(DmpDocument document) {
        hql.start().
                alias("nt").
                select("nt.tag").
                where("nt.document = :document");
        parameters.start().
                set("document", document);
        return getListUnlimitedBy(hql.value(), parameters.value());
    }

    public DmpDocumentTag getBy(DmpDocument document, DmpTag tag) {
        hql.start().
                where("document = :document").
                where("tag = :tag");
        parameters.start().
                set("document", document).
                set("tag", tag);
        return getBy(hql.value(), parameters.value());
    }
//</editor-fold>
}