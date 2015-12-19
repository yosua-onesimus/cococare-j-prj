package controller.form.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.framework.model.obj.wf.WfFilter.isDocumentStatusIsPortfolio;
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
import model.obj.dmp.DmpDocument;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDocumentListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getClass() {
        return _getClassBySwingView();
    }

    @Override
    protected Class _getEntity() {
        return DmpDocument.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initTable() {
        super._initTable();
        tblEntity.setHqlFilters(isDocumentStatusIsPortfolio);
    }
}