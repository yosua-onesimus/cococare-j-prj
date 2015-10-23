package controller.pseudo;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getValue;
import static cococare.common.CCFormat.*;
import cococare.framework.swing.controller.form.util.PnlParameterCtrl;
import static cococare.swing.CCSwing.addListener;
import static cococare.swing.CCSwing.addListener2;
import cococare.swing.component.CCBandBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import model.bo.DragonBo;
//</editor-fold>

public class DragonCtrl extends PnlParameterCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private DragonBo dragonBo;
    private String code;
    private String customName;
    private JTextField txtCode;
    private JTextField txtCustomName;
    private CCBandBox txtHabitatType1;
    private CCBandBox txtHabitatType2;
    private CCBandBox txtHabitatType3;
    private CCBandBox txtHabitatType4;
    private JTextField txtRevenues;
    private JTextField txtRevenuesPercent;
    private JTextField txtRevenuesTotal;
//</editor-fold>

    @Override
    protected void _initListener() {
        super._initListener();
        ActionListener alUpdateTxtCodeAndTxtName = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateTxtCodeAndTxtCustomName();
            }
        };
        addListener(txtHabitatType1, alUpdateTxtCodeAndTxtName);
        addListener(txtHabitatType2, alUpdateTxtCodeAndTxtName);
        addListener(txtHabitatType3, alUpdateTxtCodeAndTxtName);
        addListener(txtHabitatType4, alUpdateTxtCodeAndTxtName);
        ActionListener alUpdateTxtRevenuesTotal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateTxtRevenuesTotal();
            }
        };
        addListener2(txtRevenues, alUpdateTxtRevenuesTotal);
        addListener2(txtRevenuesPercent, alUpdateTxtRevenuesTotal);
    }

    private void _fillCodeAndCustomName(CCBandBox bandBox) {
        String habitatTypeCode = getStringOrBlank(getValue(bandBox.getObject(), "code"));
        code += getDigit(habitatTypeCode);
        customName += getNonDigit(habitatTypeCode);
    }

    private void _doUpdateTxtCodeAndTxtCustomName() {
        code = "";
        customName = "";
        _fillCodeAndCustomName(txtHabitatType1);
        _fillCodeAndCustomName(txtHabitatType2);
        _fillCodeAndCustomName(txtHabitatType3);
        _fillCodeAndCustomName(txtHabitatType4);
        txtCode.setText("D" + code);
        txtCustomName.setText(customName + "Gon");
    }

    private void _doUpdateTxtRevenuesTotal() {
        txtRevenuesTotal.setText(
                formatNumeric(dragonBo.countRevenuesTotal(
                unformatNumber(txtRevenues.getText()),
                unformatNumber(txtRevenuesPercent.getText()))));
    }
}