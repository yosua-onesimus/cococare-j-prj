package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "fb_items")
@CCTypeConfig(label = "Item", uniqueKey = "name", parameter = true)
public class FbItem extends CCEntity {

    @Column(length = 12)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, requestFocus = true, unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, unique = true)
    private String name;
    @ManyToOne
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FbItemType itemType;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FbItemType getItemType() {
        return itemType;
    }

    public void setItemType(FbItemType itemType) {
        this.itemType = itemType;
    }
//</editor-fold>
}