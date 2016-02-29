package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCMath.manipulate;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "fb_classes")
@CCTypeConfig(label = "Class", uniqueKey = "name", parameter = true, controllerClass = "controller.pseudo.fb.FbClassCtrl")
public class FbClass extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, requestFocus = true, unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, unique = true)
    private String name;
    //
    @CCFieldConfig(group = "Parameter", label = "HP", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3)
    private Integer hp = 10;
    @CCFieldConfig(group = "Parameter", label = "AP", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer ap = 1;
    @CCFieldConfig(group = "Parameter", label = "OFF", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer offense = 1;
    @CCFieldConfig(group = "Parameter", label = "DEF", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer defense = 1;
    @CCFieldConfig(group = "Parameter", label = "ESS", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer essence = 1;
    @CCFieldConfig(group = "Parameter", label = "VEL", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer velense = 1;
    @CCFieldConfig(group = "Parameter", label = "Balance", accessible = Accessible.MANDATORY_READONLY, type = Type.NUMERIC, maxLength = 3)
    private Integer balance = 1;
    @CCFieldConfig(group = "Parameter", label = "Hit%", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer hitRate = 90;
    @CCFieldConfig(group = "Parameter", label = "Eva%", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer evaRate = 10;
    @CCFieldConfig(group = "Parameter", label = "Crt%", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer crtRate = 10;
    //
    @ManyToOne
    @CCFieldConfig(group = "Special", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FbActionType command;

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

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAp() {
        return ap;
    }

    public void setAp(Integer ap) {
        this.ap = ap;
    }

    public Integer getOffense() {
        return offense;
    }

    public void setOffense(Integer offense) {
        this.offense = offense;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getEssence() {
        return essence;
    }

    public void setEssence(Integer essence) {
        this.essence = essence;
    }

    public Integer getVelense() {
        return velense;
    }

    public void setVelense(Integer velense) {
        this.velense = velense;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getHitRate() {
        return hitRate;
    }

    public void setHitRate(Integer hitRate) {
        this.hitRate = hitRate;
    }

    public Integer getEvaRate() {
        return evaRate;
    }

    public void setEvaRate(Integer evaRate) {
        this.evaRate = evaRate;
    }

    public Integer getCrtRate() {
        return crtRate;
    }

    public void setCrtRate(Integer crtRate) {
        this.crtRate = crtRate;
    }

    public FbActionType getCommand() {
        return command;
    }

    public void setCommand(FbActionType command) {
        this.command = command;
    }

    public void calculate() {
        manipulate(this, "balance=hp/10+ap+offense+defense+essence+velense");
        manipulate(this, "crtRate=(10-offense)*10");
    }
//</editor-fold>
}