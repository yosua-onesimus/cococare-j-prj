package console;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.database.CCEntityBo;
import cococare.database.CCHibernate;
import cococare.datafile.CCFile;
import cococare.datafile.jxl.CCExcel;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.mdl.note.NotesModule;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.model.mdl.wf.WorkflowModule;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.*;
import java.io.File;
//</editor-fold>

public class TestFunction {

    private static CCHibernate hibernate;
    private static Class[] eximClasses = new Class[]{UtilUserGroup.class, UtilUser.class,
        WfScript.class, WfProcess.class, WfActivity.class, WfAction.class, WfTransition.class};

//<editor-fold defaultstate="collapsed" desc=" _initHibernate() ">
    private static void _initHibernate() {
        CFApplCtrl.APPL_CODE = "cccr-nts";
        hibernate = new CCHibernate();
        hibernate.loadDatabaseConfig(CCFile.getFileSystConfFile("dtbs.conf"));
        UtilityModule.INSTANCE.init(hibernate);
        NotesModule.INSTANCE.init(hibernate);
        WorkflowModule.INSTANCE.init(hibernate);
        hibernate.buildSessionFactories();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" _exim() ">
    private static void _exim() {
        File excelFile = new File("D:\\workflow.xls");
        CCExcel excel = new CCExcel();
        if (true) {
            //export
            excel.newWorkbook();
            for (Class eximClass : eximClasses) {
                excel.newSheet(eximClass.getSimpleName());
                excel.initEntity(eximClass, false);
                excel.writeRowEntityHeader();
                excel.writeRowEntity(CCEntityBo.INSTANCE.getListBy(eximClass, "", "", "", 0, null));
            }
            excel.saveAndCloseWorkbook(excelFile);
        }
        if (false) {
            //import
            excel.openWorkbook(excelFile);
            for (Class eximClass : eximClasses) {
                excel.getSheet(eximClass.getSimpleName());
                excel.initEntity(eximClass, false);
                hibernate.restore(excel.readRowEntity(1, excel.getRowCount() - 1));
            }
            excel.closeWorkbook();
        }
    }
//</editor-fold>

    public static void main(String[] args) {
        _initHibernate();
        _exim();
    }
}