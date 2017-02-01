package console;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCConfig;
import cococare.database.CCEntityBo;
import cococare.database.CCHibernate;
import cococare.datafile.CCDom;
import cococare.datafile.CCFile;
import cococare.framework.common.CFApplCtrl;
import cococare.framework.model.mdl.util.UtilityModule;
import cococare.framework.model.mdl.wf.WorkflowModule;
import cococare.framework.model.obj.util.UtilUser;
import cococare.framework.model.obj.util.UtilUserGroup;
import cococare.framework.model.obj.wf.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
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
        File xmlFile = CCFile.getFileSystArchFile("document-management-process-example.xml");
        if (false) {
            //export
            List list = new ArrayList();
            for (Class eximClass : eximClasses) {
                list.addAll(CCEntityBo.INSTANCE.getListBy(eximClass, "", "", "", 0, null));
            }
            CCDom dom = new CCDom();
            dom.writeEntity("root", list);
            dom.transform(xmlFile);
        }
        if (true) {
            //import  -->  init initial data example
            CCDom dom = new CCDom();
            dom.read(xmlFile);
            for (Class eximClass : eximClasses) {
                hibernate.restore(dom.readEntity(eximClass));
            }
        }
    }
//</editor-fold>

    public static void main(String[] args) {
        _initHibernate();
        _exim();
    }
}