package controller.form.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.component.CCOptionBox;
import model.bo.dmp.DmpDocumentBo;
import model.obj.dmp.DmpDocument;
import model.obj.dmp.DmpTag;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDocumentCtrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private DmpDocumentBo documentBo;
    private CCOptionBox optTag;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return DmpDocument.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }

    @Override
    protected void _initObject() {
        super._initObject();
        documentBo.load((DmpDocument) objEntity);
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        _addChildScreen("document", new PnlDocumentReferenceListCtrl(), "pnlDocumentReference");
    }

    @Override
    protected void _initEditor() {
        super._initEditor();
        optTag.initList(false, DmpTag.class, "name");
        optTag.setColumnCount(1);
        optTag.autoList();
    }

    @Override
    protected boolean _doSaveEntity() {
        return documentBo.saveOrUpdate(_getEntityChilds());
    }

    @Override
    protected void _doUpdateEditor() {
        super._doUpdateEditor();
        optTag.setSelectedItem(true, documentBo.getSelectedTags().toArray());
    }

    @Override
    protected void _getValueFromEditor() {
        super._getValueFromEditor();
        documentBo.setSelectedTags(optTag.getSelectedItems());
    }
}