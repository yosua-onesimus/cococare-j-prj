package model.obj.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import java.util.Date;
import javax.persistence.*;
import model.obj.lib.LibEnum.Gender;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "lib_members")
@CCTypeConfig(label = "Member", uniqueKey = "fullName")
public class LibMember extends CCEntity {

    @Column(length = 12)
    @CCFieldConfig(accessible = Accessible.MANDATORY, sequence = "[yyMMdd]/000", unique = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(accessible = Accessible.MANDATORY, requestFocus = true)
    private String fullName;
    @Temporal(value = TemporalType.DATE)
    @CCFieldConfig(componentId = "dtpBirthDate", accessible = Accessible.MANDATORY, type = Type.DATE_PAST, visible = false)
    private Date birthDate;
    @CCFieldConfig(componentId = "cmbGender", accessible = Accessible.MANDATORY, optionSource = "model.obj.lib.LibEnum$Gender", optionReflectKey = "gender", visible = false)
    private Integer genderIndex;
    @Column(length = 8)
    @CCFieldConfig(visible = false, visible2 = false)
    private String gender;
    @Column(length = 255)
    @CCFieldConfig(visible = false)
    private String address;
    @Column(length = 48)
    @CCFieldConfig(tooltiptext = "Kabupaten", componentId = "cmbRegency", optionSource = "IndonesiaCities.txt", optionReflectKey = "regency", visible = false)
    private String regency;
    @Column(length = 48)
    @CCFieldConfig(tooltiptext = "Propinsi", componentId = "cmbProvince", optionSource = "IndonesiaProvinces.txt", optionReflectKey = "province", visible = false)
    private String province;
    @Column(length = 16)
    @CCFieldConfig(type = Type.PHONE_NUMBER)
    private String phone;
    @Column(length = 32)
    @CCFieldConfig(type = Type.EMAIL, visible = false)
    private String email;
    @Lob
    @Column(length = Integer.MAX_VALUE)
    @CCFieldConfig(componentId = "attPhoto", type = Type.THUMB_FILE, optionReflectKey = "photoName", visible = false)
    private byte[] photo;
    @Column(length = 255)
    @CCFieldConfig(visible = false, visible2 = false)
    private String photoName;
    @Column(length = 16)
    @CCFieldConfig()
    private String ktp;
    @CCFieldConfig(label = "S", tooltiptext = "Suspend", componentId = "chkSuspend", maxLength = 4)
    private Boolean suspend = false;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getGenderIndex() {
        return genderIndex;
    }

    public void setGenderIndex(Integer genderIndex) {
        this.genderIndex = genderIndex;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setGender(Gender gender) {
        setGenderIndex(gender.ordinal());
        setGender(gender.toString());
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegency() {
        return regency;
    }

    public void setRegency(String regency) {
        this.regency = regency;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public Boolean getSuspend() {
        return suspend;
    }

    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }
//</editor-fold>
}