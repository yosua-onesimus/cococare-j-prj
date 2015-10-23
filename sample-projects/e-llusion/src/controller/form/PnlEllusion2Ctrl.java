package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import model.bo.Ellusion2Bo;
//</editor-fold>

public class PnlEllusion2Ctrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    private int step = 0;
    private int click = 0;
    private String[] aryChosen = new String[4];
    //Navi Step
    private JTabbedPane tabStep;
    private JButton btnBack;
    private JButton btnNext;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btn10;
    private JButton btn11;
    private JButton btn12;
    private JButton btn13;
    private JButton btn14;
    private JButton btn15;
    private JButton btn16;
    private JButton[][] aryButton;
    private JLabel lblStep1BLeft;
    private JLabel lblStep1BRight;
    private JLabel lblAnswer1;
    private JLabel lblAnswer2;
    private JLabel lblAnswer3;
//</editor-fold>

    @Override
    protected Class _getEntity() {
        return null;
    }

    @Override
    protected BaseFunction _getBaseFunction() {
        return BaseFunction.LIST_FUNCTION;
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        aryButton = new JButton[][]{
            {btn1, btn2, btn3, btn4},
            {btn5, btn6, btn7, btn8},
            {btn9, btn10, btn11, btn12},
            {btn13, btn14, btn15, btn16}
        };
    }

    @Override
    protected void _initListener() {
        super._initListener();
        CCSwing.addListener(btnBack, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doBack();
            }
        });
        CCSwing.addListener(btnNext, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doNext();
            }
        });
        ActionListener alSelectButton = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doSelectButton(actionEvent);
            }
        };
        for (JButton[] buttons : aryButton) {
            for (JButton button : buttons) {
                CCSwing.addListener(button, alSelectButton);
            }
        }
    }

    private void _doBack() {
        step--;
        if (step < 0) {
            step = 0;
        }
        _doUpdateTabStep();
    }

    private void _doNext() {
        step++;
        if (step > tabStep.getTabCount() - 1) {
            step = tabStep.getTabCount() - 1;
        }
        _doUpdateTabStep();
    }

    private void _doSelectButton(ActionEvent actionEvent) {
        click++;
        _doUpdateVisibleButton((JButton) actionEvent.getSource());
    }

    @Override
    protected void _doUpdateComponent() {
        super._doUpdateComponent();
        _doUpdateTabStep();
    }

    private void _doUpdateTabStep() {
        tabStep.setSelectedIndex(step);
        btnBack.setVisible(step > 0);
        btnNext.setVisible(step < tabStep.getTabCount() - 1);
        if (step == 1) {
            click = 0;
            Object[][] todayMatrix = Ellusion2Bo.horizontalShuffle(Ellusion2Bo.verticalShuffle(Ellusion2Bo.getTodayMatrix()));
            for (int index1 = 0; index1 < 4; index1++) {
                for (int index2 = 0; index2 < 4; index2++) {
                    aryButton[index1][index2].setEnabled(true);
                    aryButton[index1][index2].setVisible(true);
                    aryButton[index1][index2].setText(todayMatrix[index1][index2].toString());
                }
            }
            _doUpdateVisibleButton(null);
        } else if (step == 2) {
            String string1 = "";
            String string2 = "<html>";
            int total = 0;
            for (String string : aryChosen) {
                if (string1.length() > 0) {
                    string1 += ", ";
                    string2 += "<br>";
                }
                string1 += string;
                string2 += string;
                total += Integer.parseInt(string);
            }
            lblAnswer1.setText(string1);
            string2 += " +<br><hr>" + total;
            lblAnswer2.setText(string2);
            lblAnswer3.setText(CCFormat.getString(Ellusion2Bo.TODAY, "MMMM, dd"));
        }
    }

    private void _doUpdateVisibleButton(JButton button) {
        //
        int row = -1;
        int column = -1;
        for (int index1 = 0; index1 < 4; index1++) {
            for (int index2 = 0; index2 < 4; index2++) {
                if (aryButton[index1][index2].equals(button)) {
                    row = index1;
                    column = index2;
                    aryChosen[click - 1] = (aryButton[index1][index2].getText());
                    aryButton[index1][index2].setEnabled(false);
                    break;
                }
            }
        }
        //
        for (int index1 = 0; index1 < 4; index1++) {
            for (int index2 = 0; index2 < 4; index2++) {
                if (index1 == row && index2 == column) {
                    continue;
                }
                if (index1 == row || index2 == column) {
                    aryButton[index1][index2].setVisible(false);
                }
            }
        }
        //
        lblStep1BLeft.setVisible(click >= 4);
        lblStep1BRight.setVisible(click >= 4);
        btnNext.setVisible(click >= 4);
    }
}