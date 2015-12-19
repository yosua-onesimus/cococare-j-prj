package model.obj.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCFormat.getString;
import cococare.common.CCResponse;
import cococare.common.CCTypeConfig;
import cococare.database.CCHibernate.Transaction;
import cococare.framework.model.obj.wf.WfMethodConfig;
import cococare.framework.model.obj.wf.WfMethodConfig.ScriptType;
import cococare.framework.model.obj.wf.WfWorkflow;
import java.util.Date;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
public class DmpScript {

    @CCTypeConfig(label = "SubmitToReviewerParallel")
    public static class SubmitToReviewerParallel {

        @CCFieldConfig(group = "Parallel Flow")
        private Boolean toReviewer1 = false;
        @CCFieldConfig(group = "Parallel Flow")
        private Boolean toReviewer2 = false;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
        public Boolean getToReviewer1() {
            return toReviewer1;
        }

        public boolean isToReviewer1() {
            return getBoolean(toReviewer1);
        }

        public void setToReviewer1(Boolean toReviewer1) {
            this.toReviewer1 = toReviewer1;
        }

        public Boolean getToReviewer2() {
            return toReviewer2;
        }

        public boolean isToReviewer2() {
            return getBoolean(toReviewer2);
        }

        public void setToReviewer2(Boolean toReviewer2) {
            this.toReviewer2 = toReviewer2;
        }

        public boolean isSelected() {
            return isToReviewer1() || isToReviewer2();
        }
//</editor-fold>
    }

    @CCTypeConfig(label = "ReviewerDecision")
    public static class ReviewerDecision {

        @CCFieldConfig
        private Boolean documentValid = false;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
        public Boolean getDocumentValid() {
            return documentValid;
        }

        public void setDocumentValid(Boolean documentValid) {
            this.documentValid = documentValid;
        }
//</editor-fold>
    }

    @WfMethodConfig(scriptName = "visibleOnSerial", scriptType = ScriptType.ACTION_VISIBILITY)
    public static boolean visibleOnSerial(WfWorkflow workflow) {
        DmpDocument document = (DmpDocument) workflow.getDocument();
        return !document.isParallelProcess();
    }

    @WfMethodConfig(scriptName = "visibleOnParallel", scriptType = ScriptType.ACTION_VISIBILITY)
    public static boolean visibleOnParallel(WfWorkflow workflow) {
        DmpDocument document = (DmpDocument) workflow.getDocument();
        return document.isParallelProcess();
    }

    @WfMethodConfig(scriptName = "atLeastOneReviewerSelected", scriptType = ScriptType.ROUTE_VALIDATION)
    public static CCResponse atLeastOneReviewerSelected(WfWorkflow workflow) {
        SubmitToReviewerParallel submitToReviewerParallel = workflow.getRouting().getAdditionalInput();
        return CCResponse.newResponse(submitToReviewerParallel.isSelected(), "Please select at least one Reviewer.");
    }

    @WfMethodConfig(scriptName = "isSubmitToReviewer1", scriptType = ScriptType.ROUTE_AVAILABILITY)
    public static boolean isSubmitToReviewer1(WfWorkflow workflow) {
        SubmitToReviewerParallel submitToReviewerParallel = workflow.getRouting().getAdditionalInput();
        return submitToReviewerParallel.getToReviewer1();
    }

    @WfMethodConfig(scriptName = "isSubmitToReviewer2", scriptType = ScriptType.ROUTE_AVAILABILITY)
    public static boolean isSubmitToReviewer2(WfWorkflow workflow) {
        SubmitToReviewerParallel submitToReviewerParallel = workflow.getRouting().getAdditionalInput();
        return submitToReviewerParallel.getToReviewer2();
    }

    @WfMethodConfig(scriptName = "updateDocumentNumber", scriptType = ScriptType.POST_ROUTE_PROCESS)
    public static void updateDocumentNumber(Transaction transaction, WfWorkflow workflow) {
        workflow.getDocument().setNumber(workflow.getDocument().getNumber() + "-" + getString(new Date(), "yyMMdd"));
    }

    @WfMethodConfig(scriptName = "updateParallelProcessToFalse", scriptType = ScriptType.POST_ROUTE_PROCESS)
    public static void updateParallelProcessToFalse(Transaction transaction, WfWorkflow workflow) {
        DmpDocument document = (DmpDocument) workflow.getDocument();
        if (document.isParallelProcess()) {
            document.setParallelProcess(false);
            transaction.saveOrUpdate(document);
        }
    }

    @WfMethodConfig(scriptName = "updateParallelProcessToTrue", scriptType = ScriptType.POST_ROUTE_PROCESS)
    public static void updateParallelProcessToTrue(Transaction transaction, WfWorkflow workflow) {
        DmpDocument document = (DmpDocument) workflow.getDocument();
        if (!document.isParallelProcess()) {
            document.setParallelProcess(true);
            transaction.saveOrUpdate(document);
        }
    }
}