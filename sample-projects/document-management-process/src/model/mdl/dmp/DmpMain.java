package model.mdl.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCConfig.*;
import cococare.framework.common.CFApplUae;
import cococare.framework.swing.CFSwingMain;
import cococare.framework.swing.controller.form.wf.PnlApplicationListCtrl;
import cococare.framework.swing.controller.form.wf.PnlPortfolioListCtrl;
import controller.form.dmp.PnlDocumentListCtrl;
import model.obj.dmp.DmpDocument;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class DmpMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_CODE = "document-management-process";
        APPL_NAME = "Document Management Process";
        APPL_UTIL_INCLUDED_PERSON_ENTITIES = true;
        APPL_UTIL_SHOW_WORKFLOW_MODULE = true;
        WF_DOCUMENT_CLASS = DmpDocument.class;
        super._loadInternalSetting();
    }

    @Override
    protected void _loadExternalSetting() {
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        DmpModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected boolean _initInitialData() {
        return super._initInitialData();
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuRoot(
                PnlDocumentListCtrl.class,
                PnlPortfolioListCtrl.class,
                PnlApplicationListCtrl.class);
        uae.addMenuParent("Normal Way", "/cococare/resource/icon-menu-parent.png", null);
        uae.addMenuChild("Document", "/cococare/resource/icon-menu-child.png", PnlDocumentListCtrl.class);
        uae.addMenuParent("Workflow Way", "/cococare/resource/icon-menu-parent.png", null);
        uae.addMenuChild("Portfolio", "/cococare/resource/icon-menu-child.png", PnlPortfolioListCtrl.class);
        uae.addMenuChild("Application", "/cococare/resource/icon-menu-child.png", PnlApplicationListCtrl.class);
    }

    public static void main(String[] args) {
        new DmpMain().showScreen();
    }
}