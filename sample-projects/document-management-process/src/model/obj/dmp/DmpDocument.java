package model.obj.dmp;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import static cococare.common.CCFormat.getBoolean;
import cococare.common.CCTypeConfig;
import cococare.framework.model.obj.wf.WfDocument;
import javax.persistence.Column;
import javax.persistence.Entity;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@CCTypeConfig(label = "Document", uniqueKey = "number")
public class DmpDocument extends WfDocument {

    @Column(length = 32)
    @CCFieldConfig(componentId = "txtTitle", accessible = Accessible.MANDATORY)
    private String title;
    @Column(length = Short.MAX_VALUE)
    @CCFieldConfig(componentId = "txtContent", maxLength = Short.MAX_VALUE, visible = false)
    private String content;
    @CCFieldConfig(label = "PP", tooltiptext = "Parallel Process", componentId = "chkParallelProcess", maxLength = 4, visible2 = false)
    private Boolean parallelProcess = false;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getParallelProcess() {
        return parallelProcess;
    }

    public boolean isParallelProcess() {
        return getBoolean(parallelProcess);
    }

    public void setParallelProcess(Boolean parallelProcess) {
        this.parallelProcess = parallelProcess;
    }
//</editor-fold>
}