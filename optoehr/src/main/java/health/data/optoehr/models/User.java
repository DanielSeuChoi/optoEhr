package health.data.optoehr.models;

import java.util.List;
import java.util.Date;
import javax.persistence.Transient;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 4)
    private String firstName;
    @Size(min = 4)
    private String lastName;
    @Size(min = 4)
    private String username;
    @Size(min = 5)
    private String password;
    @Transient
    private String pwConfirmation;
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roles;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Patient> patients;

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPwConfirmation() {
        return pwConfirmation;
    }

    public void setPwConfirmation(String pwConfirmation) {
        this.pwConfirmation = pwConfirmation;
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

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Patient> getPatients() {
        return this.patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    // public Long getId() {
    // return id;
    // }

    // public void setId(Long id) {
    // this.id = id;
    // }

    // public String getLastName() {
    // return lastName;
    // }

    // public void setLastname(String lastName) {
    // this.lastName = lastName;
    // }

    // public String getPassword() {
    // return password;
    // }

    // public void setPassword(String password) {
    // this.password = password;
    // }

    // public String getPwConfirmation() {
    // return pwConfirmation;
    // }

    // public void setPwConfirmation(String pwConfirmation) {
    // this.pwConfirmation = pwConfirmation;
    // }

    // public Date getCreatedAt() {
    // return createdAt;
    // }

    // public void setCreatedAt(Date createdAt) {
    // this.createdAt = createdAt;
    // }

    // public Date getUpdatedAt() {
    // return updatedAt;
    // }

    // public void setUpdatedAt(Date updatedAt) {
    // this.updatedAt = updatedAt;
    // }

    // public List<Role> getRoles() {
    // return roles;
    // }

    // public void setRoles(List<Role> roles) {
    // this.roles = roles;
    // }

}
