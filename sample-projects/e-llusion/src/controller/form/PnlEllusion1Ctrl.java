package controller.form;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFormat;
import cococare.framework.swing.CFSwingCtrl;
import cococare.swing.CCSwing;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import model.bo.Ellusion1Bo;
//</editor-fold>

public class PnlEllusion1Ctrl extends CFSwingCtrl {

//<editor-fold defaultstate="collapsed" desc=" private object ">
    //
    private int step = 0;
    private int question = 0;
    private int answer = 0;
    private Object[] aryQuestion;
    //Navi Step
    private JTabbedPane tabStep;
    private JButton btnBack;
    private JButton btnNext;
    private JSpinner spnMax;
    private JLabel lblStep1BLeft;
    private JLabel lblStep1BRight;
    private JLabel lblStep2;
    private JLabel lblAnswer;
    private JLabel lblQuestion;
    private JButton btnYes;
    private JButton btnNo;
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
        CCSwing.addListener(spnMax, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doSpnMax();
            }
        });
        CCSwing.addListener(btnYes, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doYes();
            }
        });
        CCSwing.addListener(btnNo, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                _doNo();
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

    private void _doSpnMax() {
        if (CCFormat.parseInt(spnMax.getValue()) < 1) {
            spnMax.setValue(1);
        } else if (CCFormat.parseInt(spnMax.getValue()) > 500) {
            spnMax.setValue(500);
        } else {
            lblStep1BLeft.setText("<html>If you are sure, please select a number from 0 up to " + CCFormat.getString(spnMax.getValue()) + ", remember these numbers.<br><br>Click [Next] to continue the game.</html>");
            lblStep1BRight.setText("<html>Jika Anda sudah yakin, silahkan pilih bilangan dari 0 sampai dengan " + CCFormat.getString(spnMax.getValue()) + ", ingat bilangan tersebut.<br><br>Klik [Next] untuk melanjutkan permainan.</html>");
        }
    }

    private void _doYes() {
        answer += CCFormat.parseInt(aryQuestion[question].toString().split(",")[0]);
        _doNo();
    }

    private void _doNo() {
        question++;
        _doUpdateQuestion();
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
        if (step == 2) {
            question = 0;
            answer = 0;
            aryQuestion = Ellusion1Bo.shuffle(Ellusion1Bo.getBinaryGroup(CCFormat.parseInt(spnMax.getValue())));
            lblStep2.setText("<html>Are there numbers that you choose among the following set of numbers?<br/><hr>Apakah bilangan yang Anda pilih terdapat di antara kumpulan bilangan berikut ini?</html>");
            _doUpdateQuestion();
        }
    }

    private void _doUpdateQuestion() {
        int max = CCFormat.parseInt(spnMax.getValue());
        if (question < aryQuestion.length) {
            lblQuestion.setText("<html>" + aryQuestion[question].toString() + "</html>");
        } else if (answer >= 0 && answer <= max) {
            lblStep2.setText("<html>What number you choose is<br><hr>Bilangan yang Anda pilih adalah</html>");
            lblAnswer.setText(CCFormat.getString(answer));
        } else {
            lblStep2.setText("<html>Sorry, but your choice can not be identified.<br><hr>Maaf, pilihan anda tidak dapat dikenali.</html>");
        }
        boolean visible = question < aryQuestion.length;
        lblAnswer.setVisible(!visible);
        lblQuestion.setVisible(visible);
        btnYes.setVisible(visible);
        btnNo.setVisible(visible);
    }
}