package model.mdl;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCLoginInfo;
import cococare.datafile.CCImage;
import cococare.framework.swing.CFSwingMap;
import cococare.framework.swing.CFSwingUae;
import cococare.swing.CCSwing;
import controller.form.PnlEllusion1Ctrl;
import controller.form.PnlEllusion2Ctrl;
import controller.form.PnlEllusion3Ctrl;
import controller.form.PnlExitCtrl;
import view.form.FrmEllusion;
//</editor-fold>

public class EllusionMain {

    public static void main(String[] args) {
        //initial log default handler
        //CCMessage.initLogHandler();
        //set login info for without-login purpose
        CCLoginInfo.INSTANCE = null;
        //initial main screen
        CFSwingMap.initMainScreen(FrmEllusion.class.getName());
        //compile menubar
        CFSwingUae swingUae = new CFSwingUae();
        swingUae.initMenuBar(CFSwingMap.getMenubarH());
        swingUae.addMenuParent("(e)llusion I", "/cococare/resource/icon-menu-child.png", PnlEllusion1Ctrl.class);
        swingUae.addMenuParent("(e)llusion II", "/cococare/resource/icon-menu-child.png", PnlEllusion2Ctrl.class);
        swingUae.addMenuParent("(e)llusion III", "/cococare/resource/icon-menu-child.png", PnlEllusion3Ctrl.class);
        swingUae.changeMenuSide();
        swingUae.addMenuParent("Keluar", "/cococare/resource/icon-menu-log-out.png", PnlExitCtrl.class);
        swingUae.compileMenu();
        //put main screen to center
        CCSwing.centerScreen(CFSwingMap.getMainScreen());
        //set icon
        CFSwingMap.getMainScreen().setIconImage(CCImage.readImage("/cococare/resource/icon-cococare.jpg"));
        //show main screen
        CFSwingMap.getMainScreen().setVisible(true);
    }
}