package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
import model.bo.DragonHabitatOptimizationBo;
//</editor-fold>

public class PnlDragonHabitatOptimizationCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private DragonHabitatOptimizationBo dragonHabitatOptimizationBo;
//</editor-fold>

    @Override
    public boolean init() {
        if (_isSureSave()) {
            _showSaved(updateCaller = dragonHabitatOptimizationBo.execute());
        }
        return updateCaller;
    }
}