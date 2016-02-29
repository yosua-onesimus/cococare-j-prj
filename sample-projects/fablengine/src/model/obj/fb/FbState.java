package model.obj.fb;

//<editor-fold defaultstate="collapsed" desc=" import ">
import static cococare.common.CCClass.getCCFields;
import cococare.common.CCField;
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.AccessValue;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import static cococare.common.CCFormat.getBoolean;
import static cococare.common.CCFormat.parseInt;
import static cococare.common.CCLogic.isNotNullAndNotEmpty;
import static cococare.common.CCLogic.isNullOrEmpty;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//</editor-fold>

@Entity
@Table(name = "fb_states")
@CCTypeConfig(label = "State", uniqueKey = "name", parameter = true)
public class FbState extends CCEntity {

    @Column(length = 4)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, requestFocus = true, unique = true)
    private String code;
    @Column(length = 16)
    @CCFieldConfig(group = "General", accessible = Accessible.MANDATORY, unique = true)
    private String name;
    //
    @CCFieldConfig(group = "Affected Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer a = 0;
    @CCFieldConfig(group = "Affected Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer b = 20;
    @CCFieldConfig(group = "Affected Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer c = 40;
    @CCFieldConfig(group = "Affected Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer d = 60;
    @CCFieldConfig(group = "Affected Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer e = 80;
    @CCFieldConfig(group = "Affected Chance", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer f = 100;
    //
    @Column(length = 255)
    @CCFieldConfig(group = "Behavior Change", maxLength = Short.MAX_VALUE, visible = false)
    private String parameterChange;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean canCauseGameOver = false;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean canNotChangeEquip = false;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean noGeneralAction = false;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean noPsychicAction = false;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean noPsionicAction = false;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean attackAlliesRandomly = false;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean attackEnemiesRandomly = false;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean nullifyDamage = false;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean counterDamage = false;
    @CCFieldConfig(group = "Behavior Change", visible = false)
    private Boolean reflectDamage = false;
    //
    @Column(length = 255)
    @CCFieldConfig(group = "Effect", label = "Precondition", maxLength = Short.MAX_VALUE, visible = false)
    private String effectPrecondition;
    @Column(length = 255)
    @CCFieldConfig(group = "Effect", label = "Formula", maxLength = Short.MAX_VALUE, visible = false)
    private String effectFormula;
    @CCFieldConfig(group = "Effect", label = "Trigger On Affect", visible = false)
    private Boolean effectTriggerOnAffect = false;
    @CCFieldConfig(group = "Effect", label = "Trigger Each Turn", visible = false)
    private Boolean effectTriggerEachTurn = false;
    @CCFieldConfig(group = "Effect", label = "Trigger On Cancel", visible = false)
    private Boolean effectTriggerOnCancel = false;
    //
    @CCFieldConfig(group = "Cancel Chance", label = "By Action (%)", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer cancelByAction = 0;
    @CCFieldConfig(group = "Cancel Chance", label = "After ? Turn", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer cancelAfterTurn = 0;
    @CCFieldConfig(group = "Cancel Chance", label = "By Turn (%)", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 4, visible = false)
    private Integer cancelByTurn = 0;
    @CCFieldConfig(group = "Cancel Chance", label = "At Battle End", visible = false)
    private Boolean cancelAtBattleEnd = false;
    //
    @CCFieldConfig(accessValue = AccessValue.METHOD, maxLength = Short.MAX_VALUE, visible2 = false)
    transient private String description = "";

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

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getD() {
        return d;
    }

    public void setD(Integer d) {
        this.d = d;
    }

    public Integer getE() {
        return e;
    }

    public void setE(Integer e) {
        this.e = e;
    }

    public Integer getF() {
        return f;
    }

    public void setF(Integer f) {
        this.f = f;
    }

    public String getParameterChange() {
        return parameterChange;
    }

    public void setParameterChange(String parameterChange) {
        this.parameterChange = parameterChange;
    }

    public Boolean getCanCauseGameOver() {
        return canCauseGameOver;
    }

    public void setCanCauseGameOver(Boolean canCauseGameOver) {
        this.canCauseGameOver = canCauseGameOver;
    }

    public Boolean getCanNotChangeEquip() {
        return canNotChangeEquip;
    }

    public void setCanNotChangeEquip(Boolean canNotChangeEquip) {
        this.canNotChangeEquip = canNotChangeEquip;
    }

    public Boolean getNoGeneralAction() {
        return noGeneralAction;
    }

    public void setNoGeneralAction(Boolean noGeneralAction) {
        this.noGeneralAction = noGeneralAction;
    }

    public Boolean getNoPsychicAction() {
        return noPsychicAction;
    }

    public void setNoPsychicAction(Boolean noPsychicAction) {
        this.noPsychicAction = noPsychicAction;
    }

    public Boolean getNoPsionicAction() {
        return noPsionicAction;
    }

    public void setNoPsionicAction(Boolean noPsionicAction) {
        this.noPsionicAction = noPsionicAction;
    }

    public Boolean getAttackAlliesRandomly() {
        return attackAlliesRandomly;
    }

    public void setAttackAlliesRandomly(Boolean attackAlliesRandomly) {
        this.attackAlliesRandomly = attackAlliesRandomly;
    }

    public Boolean getAttackEnemiesRandomly() {
        return attackEnemiesRandomly;
    }

    public void setAttackEnemiesRandomly(Boolean attackEnemiesRandomly) {
        this.attackEnemiesRandomly = attackEnemiesRandomly;
    }

    public Boolean getNullifyDamage() {
        return nullifyDamage;
    }

    public void setNullifyDamage(Boolean nullifyDamage) {
        this.nullifyDamage = nullifyDamage;
    }

    public Boolean getCounterDamage() {
        return counterDamage;
    }

    public void setCounterDamage(Boolean counterDamage) {
        this.counterDamage = counterDamage;
    }

    public Boolean getReflectDamage() {
        return reflectDamage;
    }

    public void setReflectDamage(Boolean reflectDamage) {
        this.reflectDamage = reflectDamage;
    }

    public String getEffectPrecondition() {
        return effectPrecondition;
    }

    public void setEffectPrecondition(String effectPrecondition) {
        this.effectPrecondition = effectPrecondition;
    }

    public String getEffectFormula() {
        return effectFormula;
    }

    public void setEffectFormula(String effectFormula) {
        this.effectFormula = effectFormula;
    }

    public Boolean getEffectTriggerOnAffect() {
        return effectTriggerOnAffect;
    }

    public void setEffectTriggerOnAffect(Boolean effectTriggerOnAffect) {
        this.effectTriggerOnAffect = effectTriggerOnAffect;
    }

    public Boolean getEffectTriggerEachTurn() {
        return effectTriggerEachTurn;
    }

    public void setEffectTriggerEachTurn(Boolean effectTriggerEachTurn) {
        this.effectTriggerEachTurn = effectTriggerEachTurn;
    }

    public Boolean getEffectTriggerOnCancel() {
        return effectTriggerOnCancel;
    }

    public void setEffectTriggerOnCancel(Boolean effectTriggerOnCancel) {
        this.effectTriggerOnCancel = effectTriggerOnCancel;
    }

    public Integer getCancelByAction() {
        return cancelByAction;
    }

    public void setCancelByAction(Integer cancelByAction) {
        this.cancelByAction = cancelByAction;
    }

    public Integer getCancelAfterTurn() {
        return cancelAfterTurn;
    }

    public void setCancelAfterTurn(Integer cancelAfterTurn) {
        this.cancelAfterTurn = cancelAfterTurn;
    }

    public Integer getCancelByTurn() {
        return cancelByTurn;
    }

    public void setCancelByTurn(Integer cancelByTurn) {
        this.cancelByTurn = cancelByTurn;
    }

    public Boolean getCancelAtBattleEnd() {
        return cancelAtBattleEnd;
    }

    public void setCancelAtBattleEnd(Boolean cancelAtBattleEnd) {
        this.cancelAtBattleEnd = cancelAtBattleEnd;
    }

    public String getDescription() {
        if (isNullOrEmpty(description)) {
            boolean isDescription = false;
            for (CCField field : getCCFields(this)) {
                if ("parameterChange".equalsIgnoreCase(field.getFieldName())) {
                    isDescription = true;
                }
                if (isDescription) {
                    if (Boolean.class.equals(field.getType())) {
                        boolean value = getBoolean(field.getValue());
                        if (value) {
                            if ("cancelAtBattleEnd".equalsIgnoreCase(field.getFieldName())) {
                                description += "Cancel At Battle End;";
                            } else {
                                description += field.getLabel() + "; ";
                            }
                        }
                    } else if (Integer.class.equals(field.getType())) {
                        int value = parseInt(field.getValue());
                        if (value > 0) {
                        }
                    } else if (String.class.equals(field.getType())) {
                        Object value = field.getValue();
                        description += isNotNullAndNotEmpty(value) ? value + "; " : "";
                    }
                }
                if ("cancelAtBattleEnd".equalsIgnoreCase(field.getFieldName())) {
                    break;
                }
            }
        }
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
//</editor-fold>
}