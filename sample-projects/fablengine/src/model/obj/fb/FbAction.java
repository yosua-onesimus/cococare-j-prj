package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCLogic.isNotNullAndNotEmpty;
import static cococare.common.CCLogic.isNullOrEmpty;
import static cococare.common.CCMath.manipulate;
import static cococare.common.CCMath.solved;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Random;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "fb_actions")
@CCTypeConfig(label = "Action", uniqueKey = "name", parameter = true)
public class FbAction extends CCEntity {

    @Column(length = 6)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, requestFocus = true, unique = true)
    private String code;
    @ManyToOne
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, maxLength = 16, uniqueKey = "name")
    private FbActionType actionType;
    @Column(length = 16)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY)
    private String name;
    @Column(length = 255)
    @CCFieldConfig(group = "General", maxLength = Short.MAX_VALUE)
    private String description;
    @CCFieldConfig(group = "General", label = "AP Cost", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2)
    private Integer apCost = 1;
    @CCFieldConfig(group = "General", label = "Hit%", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3, visible = false)
    private Integer hitRate = 90;
    @CCFieldConfig(group = "General", label = "Crt%", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3, visible = false)
    private Integer crtRate = 10;
    @CCFieldConfig(group = "General", label = "Var%", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 3, visible = false)
    private Integer variance = 10;
    //
    @Column(length = 255)
    @CCFieldConfig(group = "Effect", label = "Precondition", maxLength = Short.MAX_VALUE, visible = false)
    private String effectPrecondition;
    @Column(length = 255)
    @CCFieldConfig(group = "Effect", label = "Power", maxLength = Short.MAX_VALUE, visible = false)
    private String effectPower = "power=caster.essence";
    @Column(length = 255)
    @CCFieldConfig(group = "Effect", label = "Formula", maxLength = Short.MAX_VALUE, visible = false)
    private String effectFormula = "target.hp-=power";
    //
    @CCFieldConfig(visible = false, visible2 = false)
    transient private FbActor caster;
    @CCFieldConfig(visible = false, visible2 = false)
    transient private FbActor target;
    @CCFieldConfig(visible = false, visible2 = false)
    transient private Integer power = 0;
    @CCFieldConfig(visible = false, visible2 = false)
    transient private Integer temp = 0;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public FbActionType getActionType() {
        return actionType;
    }

    public void setActionType(FbActionType actionType) {
        this.actionType = actionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getApCost() {
        return apCost;
    }

    public void setApCost(Integer apCost) {
        this.apCost = apCost;
    }

    public Integer getHitRate() {
        return hitRate;
    }

    public void setHitRate(Integer hitRate) {
        this.hitRate = hitRate;
    }

    public Integer getCrtRate() {
        return crtRate;
    }

    public void setCrtRate(Integer crtRate) {
        this.crtRate = crtRate;
    }

    public Integer getVariance() {
        return variance;
    }

    public void setVariance(Integer variance) {
        this.variance = variance;
    }

    public String getEffectPrecondition() {
        return effectPrecondition;
    }

    public void setEffectPrecondition(String effectPrecondition) {
        this.effectPrecondition = effectPrecondition;
    }

    public String getEffectPower() {
        return effectPower;
    }

    public void setEffectPower(String effectPower) {
        this.effectPower = effectPower;
    }

    public String getEffectFormula() {
        return effectFormula;
    }

    public void setEffectFormula(String effectFormula) {
        this.effectFormula = effectFormula;
    }

    public FbActor getCaster() {
        return caster;
    }

    public void setCaster(FbActor caster) {
        this.caster = caster;
    }

    public FbActor getTarget() {
        return target;
    }

    public void setTarget(FbActor target) {
        this.target = target;
    }

    public Integer getPower() {
        return power;
    }

    public void setPower(Integer power) {
        this.power = power;
    }

    public Integer getTemp() {
        return temp;
    }

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public void execute(FbActor caster, FbActor target) {
        setCaster(caster);
        setTarget(target);
        if (isNullOrEmpty(getEffectPrecondition())
                || solved(this, getEffectPrecondition())) {
            caster.setAp(caster.getAp() - getApCost());
            //does the action hit?
            //did the target evade the action?
            if ((((getCaster().getHitRate() + getHitRate()) / 2) > new Random().nextInt(100))
                    && !(getTarget().getEvaRate() > new Random().nextInt(100))) {
                //then evaluate the damage formula :: step 1
                if (isNotNullAndNotEmpty(getEffectPower())) {
                    //apply power formula
                    manipulate(this, getEffectPower());
                    //apply element rate

                    //apply modifiers

                    //apply crtRate
                    if ((((getCaster().getCrtRate() + getCrtRate()) / 2) - getTarget().getEvaRate()) > new Random().nextInt(100)) {
                        power *= 3;
                    }
                    //apply variance
                    power -= getVariance();
                    power += new Random().nextInt(2 * getVariance() + 1);
                    //apply guard
                    if (getTarget().isGuard()) {
                    }
                }
                //then evaluate the damage formula :: step 2
                if (isNotNullAndNotEmpty(getEffectFormula())) {
                    manipulate(this, getEffectFormula());
                }
            }
        }
    }
//</editor-fold>
}