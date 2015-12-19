package console;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCConfig;
import cococare.database.CCEntityBo;
import cococare.database.CCHibernate;
import cococare.datafile.CCFile;
import cococare.datafile.jxl.CCExcel;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.model.mdl.wf.WorkflowModule;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
//</editor-fold>

public class TestFunction {

    private static CCHibernate hibernate;
    private static Class[] eximClasses = new Class[]{UtilUserGroup.class, UtilUser.class,
        WfScript.class, WfProcess.class, WfActivity.class, WfAction.class, WfTransition.class};

//<editor-fold defaultstate="collapsed" desc=" _initHibernate() ">
    private static void _initHibernate() {
        CCConfig.APPL_UTIL_SHOW_WORKFLOW_MODULE = true;
        CFApplCtrl.APPL_CODE = "document-management-process";
        hibernate = new CCHibernate();
        hibernate.loadDatabaseConfig(CCFile.getFileSystConfFile("dtbs.conf"));
        UtilityModule.INSTANCE.init(hibernate);
        WorkflowModule.INSTANCE.init(hibernate);
        hibernate.buildSessionFactories();
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc=" _exim() ">
    private static void _exim() {
        File excelFile = CCFile.getFileSystArchFile("document-management-process-example.xls");
        CCExcel excel = new CCExcel();
        if (false) {
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
        if (true) {
            //import  -->  init initial data example
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
        //_exim();
        UtilUserGroup userGroup1 = hibernate.get(UtilUserGroup.class, 1L);
        UtilUserGroup userGroup2 = hibernate.get(UtilUserGroup.class, 2L);
        UtilUser user1 = hibernate.get(UtilUser.class, 1L);
        UtilUser user1b = hibernate.get(UtilUser.class, 1L);
        UtilUser user1c = new UtilUser();
        user1c.setId(1L);
        UtilUser user2 = hibernate.get(UtilUser.class, 2L);

//        System.out.println(userGroup1.equals(userGroup2));
//        System.out.println(userGroup1.equals(user1));
//        System.out.println(userGroup2.equals(user2));
//        System.out.println(user1.equals(user2));
//        System.out.println(user1.equals(user1b));
//        System.out.println(user1.equals(user1c));

        Set<UtilUser> users = new HashSet<UtilUser>();
        users.add(user1);
        users.add(user1b);
        users.add(user1c);
        users.add(user2);
        for (UtilUser u : users) {
            System.out.println(u.getUsername());
        }
    }
}