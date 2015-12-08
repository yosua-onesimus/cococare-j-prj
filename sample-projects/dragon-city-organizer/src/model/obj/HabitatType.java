package model.obj;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.AccessValue;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCLogic.isNull;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import model.dao.HabitatDao;
//</editor-fold>

@Entity
@Table(name = "dco_habitat_types")
@CCTypeConfig(label = "Habitat Type", uniqueKey = "name", parameter = true)
public class HabitatType extends CCEntity {

    @Column(length = 5)
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 5, sequence = "HT00", unique = true, requestFocus = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 16)
    private String name;
    @CCFieldConfig(label = "MD", tooltiptext = "Max Dragons", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 1)
    private Integer maxDragons = 4;
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 10)
    private Double maxGold = 0d;
    @CCFieldConfig(accessValue = AccessValue.METHOD, label = "TH", tooltiptext = "Total Habitat", type = Type.NUMERIC, maxLength = 2, visible2 = false)
    transient private Long totalHabitat;

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

    public Integer getMaxDragons() {
        return maxDragons;
    }

    public void setMaxDragons(Integer maxDragons) {
        this.maxDragons = maxDragons;
    }

    public Double getMaxGold() {
        return maxGold;
    }

    public void setMaxGold(Double maxGold) {
        this.maxGold = maxGold;
    }

    public Long getTotalHabitat() {
        if (isNull(totalHabitat) && !isNewEntity()) {
            totalHabitat = new HabitatDao().countBy(this);
        }
        return totalHabitat;
    }
//</editor-fold>
}