package controller.form.sale;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import model.obj.sale.SCustomerPhone;
//</editor-fold>

public class PnlCustomerPhoneCtrl extends CFSwingCtrl {

    @Override
    protected Class _getEntity() {
        return SCustomerPhone.class;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.FORM_FUNCTION;
    }
}