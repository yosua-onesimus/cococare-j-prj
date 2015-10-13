package model.obj.lib;

//<editor-fold defaultstate="collapsed" desc=" import ">
import cococare.common.CCFieldConfig;
import cococare.common.CCFieldConfig.Accessible;
import cococare.common.CCFieldConfig.Type;
import cococare.common.CCTypeConfig;
import cococare.database.CCEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
//</editor-fold>

/**
 * @author Yosua Onesimus
 * @since 13.03.17
 * @version 13.03.17
 */
@Entity
@Table(name = "lib_books")
@CCTypeConfig(label = "Book", uniqueKey = "title")
public class LibBook extends CCEntity {

    @Column(length = 6)
    @CCFieldConfig(componentId = "txtCode", accessible = Accessible.MANDATORY, maxLength = 6, sequence = "B000", unique = true, requestFocus = true)
    private String code;
    @Column(length = 32)
    @CCFieldConfig(componentId = "txtTitle", accessible = Accessible.MANDATORY, maxLength = 32)
    private String title;
    @Column(length = 255)
    @CCFieldConfig(componentId = "txtRemarks", visible = false)
    private String remarks;
    @ManyToOne
    @CCFieldConfig(componentId = "bndBookType", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private LibBookType bookType;
    @ManyToOne
    @CCFieldConfig(componentId = "bndAuthor", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private LibAuthor author;
    @ManyToOne
    @CCFieldConfig(componentId = "bndPublisher", accessible = Accessible.MANDATORY, maxLength = 32, uniqueKey = "name")
    private LibPublisher publisher;
    @CCFieldConfig(label = "Cost", tooltiptext = "Borrowing Cost", componentId = "txtBorrowingCost", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24, visible = false)
    private Double borrowingCost;
    @CCFieldConfig(label = "Limit", tooltiptext = "Borrowing Limit", componentId = "txtBorrowingLimit", accessible = Accessible.MANDATORY, type = Type.NUMERIC, maxLength = 2, visible = false)
    private Integer borrowingLimit;
    @CCFieldConfig(label = "Fine", tooltiptext = "Borrowing Fine", componentId = "txtBorrowingFine", accessible = Accessible.MANDATORY, type = Type.NUMBER_FORMAT, maxLength = 24, visible = false)
    private Double borrowingFine;
    @CCFieldConfig(label = "B", tooltiptext = "Borrowed", componentId = "chkBorrowed", maxLength = 4)
    private Boolean borrowed = false;
    @CCFieldConfig(label = "S", tooltiptext = "Suspend", componentId = "chkSuspend", maxLength = 4)
    private Boolean suspend = false;

//<editor-fold defaultstate="collapsed" desc=" getter-setter ">
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LibBookType getBookType() {
        return bookType;
    }

    public void setBookType(LibBookType bookType) {
        this.bookType = bookType;
    }

    public LibAuthor getAuthor() {
        return author;
    }

    public void setAuthor(LibAuthor author) {
        this.author = author;
    }

    public LibPublisher getPublisher() {
        return publisher;
    }

    public void setPublisher(LibPublisher publisher) {
        this.publisher = publisher;
    }

    public Double getBorrowingCost() {
        return borrowingCost;
    }

    public void setBorrowingCost(Double borrowingCost) {
        this.borrowingCost = borrowingCost;
    }

    public Integer getBorrowingLimit() {
        return borrowingLimit;
    }

    public void setBorrowingLimit(Integer borrowingLimit) {
        this.borrowingLimit = borrowingLimit;
    }

    public Double getBorrowingFine() {
        return borrowingFine;
    }

    public void setBorrowingFine(Double borrowingFine) {
        this.borrowingFine = borrowingFine;
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    public Boolean getSuspend() {
        return suspend;
    }

    public void setSuspend(Boolean suspend) {
        this.suspend = suspend;
    }
//</editor-fold>
}