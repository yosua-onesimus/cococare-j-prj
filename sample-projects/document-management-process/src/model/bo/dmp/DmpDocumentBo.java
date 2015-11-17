package model.bo.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCLogic.*;
import cococare.database.CCHibernate.Transaction;
import cococare.database.CCHibernateBo;
import java.util.ArrayList;
import java.util.List;
import model.dao.dmp.DmpDocumentDao;
import model.dao.dmp.DmpDocumentTagDao;
import model.dao.dmp.DmpTagDao;
import model.obj.dmp.DmpDocument;
import model.obj.dmp.DmpDocumentTag;
import model.obj.dmp.DmpTag;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class DmpDocumentBo extends CCHibernateBo {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private DmpTagDao tagDao;
    private DmpDocumentDao documentDao;
    private DmpDocumentTagDao documentTagDao;
    private DmpDocument document;
    private List<DmpTag> selectedTags;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" crud ">
    public synchronized void load(DmpDocument document) {
        this.document = document;
        if (isNull(document.getId())) {
            selectedTags = new ArrayList();
        } else {
            selectedTags = documentTagDao.getListUnlimitedBy(document);
        }
    }

    public synchronized List<DmpTag> getSelectedTags() {
        return selectedTags;
    }

    public synchronized void setSelectedTags(List<DmpTag> selectedTags) {
        this.selectedTags = selectedTags;
    }

    public synchronized boolean saveOrUpdate(List entityChilds) {
        Transaction transaction = documentDao.newTransaction();
        transaction.
                saveOrUpdate(document).
                saveOrUpdate(entityChilds);
        List<DmpTag> tags = tagDao.getListUnlimited();
        for (DmpTag tag : tags) {
            DmpDocumentTag documentTag = coalesce(documentTagDao.getBy(document, tag), new DmpDocumentTag(document, tag));
            boolean selected = false;
            for (DmpTag selectedTag : selectedTags) {
                if (selectedTag.getId().equals(documentTag.getTag().getId())) {
                    selected = true;
                    break;
                }
            }
            if (selected && isNull(documentTag.getId())) {
                transaction.saveOrUpdate(documentTag);
            } else if (!selected && isNotNull(documentTag.getId())) {
                transaction.delete(documentTag);
            }
        }
        return transaction.execute();
    }
//</editor-fold>
}