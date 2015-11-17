package controller.form.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig.Accessible;
import cococare.framework.swing.controller.form.PnlDefaultCtrl;
import static cococare.swing.CCSwing.addListener;
import static cococare.swing.CCSwing.setVisible;
import cococare.swing.component.CCAttachment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.obj.dmp.DmpDocumentReference;
import model.obj.dmp.DmpEnum.ReferenceType;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class PnlDocumentReferenceCtrl extends PnlDefaultCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    private JComboBox cmbType;
    private JLabel xByteA;
    private CCAttachment attByteA;
    private JLabel xValue;
    private JTextField txtValue;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return DmpDocumentReference.class;
    }

    @Override
    protected void _initListener() {
        super._initListener();
        addListener(cmbType, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doUpdateVisibility();
            }
        });
    }

    private void _doUpdateVisibility() {
        ReferenceType referenceType = ReferenceType.values()[cmbType.getSelectedIndex()];
        edtEntity.setAccessible(attByteA, ReferenceType.ATTACHMENT.equals(referenceType) ? Accessible.MANDATORY : Accessible.NORMAL);
        edtEntity.setAccessible(txtValue, !ReferenceType.ATTACHMENT.equals(referenceType) ? Accessible.MANDATORY : Accessible.NORMAL);
        setVisible(ReferenceType.ATTACHMENT.equals(referenceType), xByteA, attByteA);
        setVisible(!ReferenceType.ATTACHMENT.equals(referenceType), xValue, txtValue);
    }

    @Override
    protected void _getValueFromEditor() {
        super._getValueFromEditor();
        ReferenceType referenceType = ReferenceType.values()[cmbType.getSelectedIndex()];
        if (ReferenceType.ATTACHMENT.equals(referenceType)) {
            ((DmpDocumentReference) objEntity).setValue(attByteA.getFileName());
        }
    }
}