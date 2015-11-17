package model.obj.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "dmp_document_document_tags")
@CCTypeConfig(label = "Tag", uniqueKey = "tag.name")
public class DmpDocumentTag extends CCEntity {

    @ManyToOne
    @CCFieldConfig(componentId = "bndDocument", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "number", visible = false)
    private DmpDocument document;
    @ManyToOne
    @CCFieldConfig(componentId = "bndTag", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name", requestFocus = true)
    private DmpTag tag;

//<editor-fold defaultstate="collapsed" desc=" DmpDocumentTag ">
    public DmpDocumentTag() {
    }

    public DmpDocumentTag(DmpDocument document, DmpTag tag) {
        this.document = document;
        this.tag = tag;
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public DmpDocument getNote() {
        return document;
    }

    public void setNote(DmpDocument document) {
        this.document = document;
    }

    public DmpTag getTag() {
        return tag;
    }

    public void setTag(DmpTag tag) {
        this.tag = tag;
    }
//</editor-fold>
}