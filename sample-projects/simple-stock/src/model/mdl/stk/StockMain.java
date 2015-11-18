package model.mdl.stk;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCLanguage;
import static cococare.common.CCLanguage.Report;
import cococare.framework.common.CFApplUae;
import cococare.framework.swing.CFSwingMain;
import controller.form.stk.PnlItemStockListCtrl;
import controller.form.stk.PnlReportListCtrl;
import static model.mdl.stk.StockLanguage.Item_Stock;
import static model.mdl.stk.StockLanguage.Stk;
import model.obj.stk.StkReport;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class StockMain extends CFSwingMain {

    @Override
    protected void _loadInternalSetting() {
        APPL_ID = "simple-stock";
        APPL_CODE = "simple-stock";
        APPL_LOGO = "/cococare/resource/icon-cococare.jpg";
        APPL_NAME = "Simple Stock";
        APPL_VER = "2.0.151118";
        super._loadInternalSetting();
        StkReport.setupReportFile(StkReport.Report.class);
    }

    @Override
    protected void _loadExternalSetting() {
        CCLanguage.init(false, StockLanguage.class);
        super._loadExternalSetting();
    }

    @Override
    protected void _initDatabaseEntity() {
        super._initDatabaseEntity();
        StockModule.INSTANCE.init(HIBERNATE);
    }

    @Override
    protected void _initInitialUaeBody(CFApplUae uae) {
        uae.reg(Stk, Item_Stock, PnlItemStockListCtrl.class);
        uae.reg(Stk, Report, PnlReportListCtrl.class);
    }

    @Override
    protected void _applyUserConfigUaeBody(CFApplUae uae) {
        uae.addMenuParent(Item_Stock, "/cococare/resource/icon-menu-child.png", PnlItemStockListCtrl.class);
        uae.addMenuParent(Report, "/cococare/resource/icon-menu-report.png", PnlReportListCtrl.class);
    }

    @Override
    protected boolean _showHomeScreen() {
        return new PnlItemStockListCtrl().init();
    }

    public static void main(String[] args) {
        new StockMain().showScreen();
    }
}