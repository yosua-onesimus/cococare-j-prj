package controller.form.stk;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.PnlDefaultListCtrl;
import model.obj.stk.StkItemStock;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlItemStockListCtrl extends PnlDefaultListCtrl {

    @Override
    protected Class _getEntity() {
        return StkItemStock.class;
    }
}