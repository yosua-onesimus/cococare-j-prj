package model.obj;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getAssociativeArray;
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.*;
import model.dao.DragonDao;
//</editor-fold>

@Entity
@Table(name = "dco_habitats")
@CCTypeConfig(label = "Habitat", uniqueKey = "@habitatType.name #@no", parameter = true, controllerClass = "controller.pseudo.HabitatCtrl")
public class Habitat extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 4, sequence = "H000", unique = true, requestFocus = true)
    private String code;
    @ManyToOne
    @CCFieldConfig(accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private HabitatType habitatType;
    @Column(name = "no_")
    @CCFieldConfig(accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer no;
    @CCFieldConfig(label = "Dragons", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMERIC, maxLength = 1)
    private Integer totalDragon = 0;
    @CCFieldConfig(label = "Revenues", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMERIC, maxLength = 3)
    private Integer totalRevenues = 0;
    @Transient
    @CCFieldConfig(label = "Dragons", visible2 = false)
    private String dragons;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    @Override
    protected void preProcess() {
        if (!isNewEntity()) {
            dragons = getAssociativeArray(new DragonDao().getListUnlimitedBy(this), "customName");
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public HabitatType getHabitatType() {
        return habitatType;
    }

    public void setHabitatType(HabitatType habitatType) {
        this.habitatType = habitatType;
    }

    public Integer getNo() {
        return no;
    }

    public void setNo(Integer no) {
        this.no = no;
    }

    public Integer getTotalDragon() {
        return totalDragon;
    }

    public void setTotalDragon(Integer totalDragon) {
        this.totalDragon = totalDragon;
    }

    public Integer getTotalRevenues() {
        return totalRevenues;
    }

    public void setTotalRevenues(Integer totalRevenues) {
        this.totalRevenues = totalRevenues;
    }

    public String getDragons() {
        return dragons;
    }
//</editor-fold>
}