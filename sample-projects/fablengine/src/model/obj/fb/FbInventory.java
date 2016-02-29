package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import javax.persistence.ManyToOne;
//</editor-fold>

public class FbInventory {

    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FbItem item;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMERIC)
    private Integer quantity;
}