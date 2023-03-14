package health.data.optoehr.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
@Table(name = "prescriptions")
public class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3)
    private String sph;
    private String cyl;
    private String axis;
    private String addPower;
    private String prism;
    private String baseCurve;
    private String notes;
    private String pd;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private String expirDate;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date createdAt;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patientRx;

    public Prescription() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSph() {
        return this.sph;
    }

    public void setSph(String sph) {
        this.sph = sph;
    }

    public String getCyl() {
        return this.cyl;
    }

    public void setCyl(String cyl) {
        this.cyl = cyl;
    }

    public String getAxis() {
        return this.axis;
    }

    public void setAxis(String axis) {
        this.axis = axis;
    }

    public String getAddPower() {
        return this.addPower;
    }

    public void setAddPower(String addPower) {
        this.addPower = addPower;
    }

    public String getPrism() {
        return this.prism;
    }

    public void setPrism(String prism) {
        this.prism = prism;
    }

    public String getBaseCurve() {
        return this.baseCurve;
    }

    public void setBaseCurve(String baseCurve) {
        this.baseCurve = baseCurve;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPd() {
        return this.pd;
    }

    public void setPd(String pd) {
        this.pd = pd;
    }

    public Patient getPatientRx() {
        return this.patientRx;
    }

    public void setPatientRx(Patient patientRx) {
        this.patientRx = patientRx;
    }

    public String getExpirDate() {
        return this.expirDate;
    }

    public void setExpirDate(String expirDate) {
        this.expirDate = expirDate;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}
