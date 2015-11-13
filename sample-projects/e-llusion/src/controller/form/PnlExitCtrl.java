package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
//</editor-fold>

public class PnlExitCtrl extends PnlDefaultCtrl {

    @Override
    public boolean init() {
        System.exit(0);
        return true;
    }
}