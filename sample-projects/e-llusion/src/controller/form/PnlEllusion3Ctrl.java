package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.bo.Ellusion1Bo;
import model.bo.Ellusion3Bo;
//</editor-fold>

public class PnlEllusion3Ctrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    private int step = 0;
    private Object[][] todayDict;
    private int todayDictIndex = 0;
    private Object[] todayWords;
    private int aryButton3Index = -1;
    private int method = 0;
    private int methodStep = 0;
    private int left = 5;
    private String sDisabled;
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
    private JButton[] aryButton1;
    private JButton[] aryButton2;
    private JButton[] aryButton3;
    private JButton btnShuffle;
    private JComboBox cmbMethod;
    private JButton btnOk;
    private Timer timer;
    private JLabel lblStep1BLeft;
    private JLabel lblStep1BRight;
    private JLabel lblDisabled;
    private JLabel lblEnabled;
    private JLabel lblDisabled1;
    private JLabel lblEnabled1;
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
    protected void _initObject() {
        super._initObject();
        todayDict = Ellusion3Bo.getTodayDict();
    }

    @Override
    protected void _initComponent() {
        super._initComponent();
        aryButton1 = new JButton[]{btn1, btn5, btn7};
        aryButton2 = new JButton[]{btn3, btn4, btn6, btn8, btn9};
        aryButton3 = new JButton[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do {
                    aryButton3Index++;
                    if (aryButton3Index >= aryButton3.length) {
                        aryButton3Index = 0;
                    }
                } while (!aryButton3[aryButton3Index].isEnabled());
                if (aryButton3[aryButton3Index].isEnabled()) {
                    _doUpdateBackgroundButton();
                    methodStep++;
                }
                if (method == methodStep) {
                    sDisabled += aryButton3[aryButton3Index].getText();
                    aryButton3[aryButton3Index].setEnabled(false);
                    left--;
                    methodStep = 0;
                }
                if (left == 0) {
                    aryButton3Index = -1;
                    _doUpdateBackgroundButton();
                    lblStep1BLeft.setVisible(true);
                    lblStep1BRight.setVisible(true);
                    btnNext.setVisible(true);
                    timer.stop();
                }
            }
        });
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
        CCSwing.addListener(btnShuffle, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doShuffle();
            }
        });
        CCSwing.addListener(btnOk, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doOk();
            }
        });
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

    private void _doShuffle(JButton[] aryButton, Object[] word) {
        int i = 0;
        for (JButton jButton : aryButton) {
            while (i < word.length && word[i].toString().length() == 0) {
                i++;
            }
            if (i >= word.length) {
                break;
            }
            jButton.setText(word[i].toString());
            i++;
        }
    }

    private void _doShuffle() {
        _doShuffle(aryButton1, Ellusion1Bo.shuffle(todayWords[0].toString().split("")));
        _doShuffle(aryButton2, Ellusion1Bo.shuffle(todayWords[1].toString().split("")));
    }

    private void _doOk() {
        btnShuffle.setVisible(false);
        cmbMethod.setVisible(false);
        btnOk.setVisible(false);
        method = Integer.parseInt(cmbMethod.getSelectedItem().toString());
        methodStep = 0;
        if (method == 3 || method == 4) {
            left = 5;
        } else if (method == 5) {
            left = 3;
        }
        sDisabled = "";
        timer.start();
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
        if (step == 0) {
            timer.stop();
        } else if (step == 1) {
            todayWords = todayDict[todayDictIndex];
            todayDictIndex++;
            if (todayDictIndex >= todayDict.length) {
                todayDictIndex = 0;
            }
            _doShuffle();
            aryButton3Index = -1;
            _doUpdateBackgroundButton();
            for (JButton jButton : aryButton3) {
                jButton.setEnabled(true);
            }
            btnShuffle.setVisible(true);
            cmbMethod.setVisible(true);
            btnOk.setVisible(true);
            lblStep1BLeft.setVisible(false);
            lblStep1BRight.setVisible(false);
            btnNext.setVisible(false);
        } else if (step == 2) {
            String sEnabled = "";
            if (method == 3 || method == 4) {
                for (JButton jButton : aryButton1) {
                    sEnabled += jButton.getText();
                }
                lblDisabled1.setText(todayWords[1].toString());
                lblEnabled1.setText(todayWords[0].toString());
            } else if (method == 5) {
                for (JButton jButton : aryButton2) {
                    sEnabled += jButton.getText();
                }
                lblDisabled1.setText(todayWords[0].toString());
                lblEnabled1.setText(todayWords[1].toString());
            }
            lblDisabled.setText(sDisabled);
            lblEnabled.setText(sEnabled);
        }
    }

    private void _doUpdateBackgroundButton() {
        for (int i = 0; i < aryButton3.length; i++) {
            aryButton3[i].setBackground(i == aryButton3Index ? Color.RED : null);
        }
    }
}