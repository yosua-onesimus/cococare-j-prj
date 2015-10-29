package controller.form.stk;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.PnlReportDefaultListCtrl;
import model.obj.stk.StkReport;
import model.obj.stk.StkReport.Report;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlReportListCtrl extends PnlReportDefaultListCtrl {

    @Override
    protected Class _getEntity() {
        return StkReport.class;
    }

    @Override
    protected Class _getReportEnum() {
        return Report.class;
    }
}