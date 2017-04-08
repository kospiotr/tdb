/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/Entity.java.e.vm
 */
package pl.xperios.tdb.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "scientists")
public class Scientists implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Scientists.class.getName());

    // Raw attributes
    private Integer id;
    private String firstname;
    private String lastname;
    private String sciencetitle;
    private String department;
    private String phone;
    private String departmentunit;
    private String email;
    private String specializations;
    private String homepage;
    private String experience;
    private String implementations;
    private String researches;
    private String grants;
    private String evaluations;
    private String publications;
    private String ownInventions;
    private String password;
    private Boolean validated;
    private Integer activated;
    private String uniquestamp;
    private Boolean admin;
    private String photo;

    @Override
    public String entityClassName() {
        return Scientists.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @Column(name = "id", precision = 10)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public Scientists id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [firstname] ------------------------

    @NotEmpty
    @Size(max = 128)
    @Column(name = "firstname", nullable = false, length = 128)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public Scientists firstname(String firstname) {
        setFirstname(firstname);
        return this;
    }
    // -- [lastname] ------------------------

    @NotEmpty
    @Size(max = 128)
    @Column(name = "lastname", nullable = false, length = 128)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Scientists lastname(String lastname) {
        setLastname(lastname);
        return this;
    }
    // -- [sciencetitle] ------------------------

    @Size(max = 500)
    @Column(name = "sciencetitle", length = 500)
    public String getSciencetitle() {
        return sciencetitle;
    }

    public void setSciencetitle(String sciencetitle) {
        this.sciencetitle = sciencetitle;
    }

    public Scientists sciencetitle(String sciencetitle) {
        setSciencetitle(sciencetitle);
        return this;
    }
    // -- [department] ------------------------

    @Size(max = 500)
    @Column(name = "department", length = 500)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Scientists department(String department) {
        setDepartment(department);
        return this;
    }
    // -- [phone] ------------------------

    @NotEmpty
    @Size(max = 128)
    @Column(name = "phone", nullable = false, length = 128)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Scientists phone(String phone) {
        setPhone(phone);
        return this;
    }
    // -- [departmentunit] ------------------------

    @Size(max = 500)
    @Column(name = "departmentunit", length = 500)
    public String getDepartmentunit() {
        return departmentunit;
    }

    public void setDepartmentunit(String departmentunit) {
        this.departmentunit = departmentunit;
    }

    public Scientists departmentunit(String departmentunit) {
        setDepartmentunit(departmentunit);
        return this;
    }
    // -- [email] ------------------------

    @Email
    @NotEmpty
    @Size(max = 128)
    @Column(name = "email", nullable = false, length = 128)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Scientists email(String email) {
        setEmail(email);
        return this;
    }
    // -- [specializations] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "specializations", nullable = false, length = 1024)
    public String getSpecializations() {
        return specializations;
    }

    public void setSpecializations(String specializations) {
        this.specializations = specializations;
    }

    public Scientists specializations(String specializations) {
        setSpecializations(specializations);
        return this;
    }
    // -- [homepage] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "homepage", nullable = false, length = 1024)
    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Scientists homepage(String homepage) {
        setHomepage(homepage);
        return this;
    }
    // -- [experience] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "experience", nullable = false, length = 1024)
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Scientists experience(String experience) {
        setExperience(experience);
        return this;
    }
    // -- [implementations] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "implementations", nullable = false, length = 1024)
    public String getImplementations() {
        return implementations;
    }

    public void setImplementations(String implementations) {
        this.implementations = implementations;
    }

    public Scientists implementations(String implementations) {
        setImplementations(implementations);
        return this;
    }
    // -- [researches] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "researches", nullable = false, length = 1024)
    public String getResearches() {
        return researches;
    }

    public void setResearches(String researches) {
        this.researches = researches;
    }

    public Scientists researches(String researches) {
        setResearches(researches);
        return this;
    }
    // -- [grants] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "grants", nullable = false, length = 1024)
    public String getGrants() {
        return grants;
    }

    public void setGrants(String grants) {
        this.grants = grants;
    }

    public Scientists grants(String grants) {
        setGrants(grants);
        return this;
    }
    // -- [evaluations] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "evaluations", nullable = false, length = 1024)
    public String getEvaluations() {
        return evaluations;
    }

    public void setEvaluations(String evaluations) {
        this.evaluations = evaluations;
    }

    public Scientists evaluations(String evaluations) {
        setEvaluations(evaluations);
        return this;
    }
    // -- [publications] ------------------------

    @Size(max = 512)
    @Column(name = "publications", length = 512)
    public String getPublications() {
        return publications;
    }

    public void setPublications(String publications) {
        this.publications = publications;
    }

    public Scientists publications(String publications) {
        setPublications(publications);
        return this;
    }
    // -- [ownInventions] ------------------------

    @Size(max = 512)
    @Column(name = "own_inventions", length = 512)
    public String getOwnInventions() {
        return ownInventions;
    }

    public void setOwnInventions(String ownInventions) {
        this.ownInventions = ownInventions;
    }

    public Scientists ownInventions(String ownInventions) {
        setOwnInventions(ownInventions);
        return this;
    }
    // -- [password] ------------------------

    @NotEmpty
    @Size(max = 512)
    @Column(name = "\"password\"", nullable = false, length = 512)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Scientists password(String password) {
        setPassword(password);
        return this;
    }
    // -- [validated] ------------------------

    @NotNull
    @Column(name = "validated", nullable = false, length = 0)
    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Scientists validated(Boolean validated) {
        setValidated(validated);
        return this;
    }
    // -- [activated] ------------------------

    @Digits(integer = 3, fraction = 0)
    @NotNull
    @Column(name = "activated", nullable = false, precision = 3)
    public Integer getActivated() {
        return activated;
    }

    public void setActivated(Integer activated) {
        this.activated = activated;
    }

    public Scientists activated(Integer activated) {
        setActivated(activated);
        return this;
    }
    // -- [uniquestamp] ------------------------

    @NotEmpty
    @Size(max = 32)
    @Column(name = "uniquestamp", nullable = false, unique = true, length = 32)
    public String getUniquestamp() {
        return uniquestamp;
    }

    public void setUniquestamp(String uniquestamp) {
        this.uniquestamp = uniquestamp;
    }

    public Scientists uniquestamp(String uniquestamp) {
        setUniquestamp(uniquestamp);
        return this;
    }
    // -- [admin] ------------------------

    @NotNull
    @Column(name = "\"admin\"", nullable = false, length = 0)
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Scientists admin(Boolean admin) {
        setAdmin(admin);
        return this;
    }
    // -- [photo] ------------------------

    @Size(max = 40)
    @Column(name = "photo", length = 40)
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Scientists photo(String photo) {
        setPhoto(photo);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Scientists withDefaults() {
        setActivated(0);
        setAdmin(false);
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Scientists && hashCode() == other.hashCode());
    }

    private volatile int previousHashCode = 0;

    @Override
    public int hashCode() {
        int hashCode = Objects.hashCode(getUniquestamp());

        if (previousHashCode != 0 && previousHashCode != hashCode) {
            log.warning("DEVELOPER: hashCode has changed!." //
                    + "If you encounter this message you should take the time to carefuly review equals/hashCode for: " //
                    + getClass().getCanonicalName());
        }

        previousHashCode = hashCode;
        return hashCode;
    }

    /**
     * Construct a readable string representation for this Scientists instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("firstname", getFirstname()) //
                .add("lastname", getLastname()) //
                .add("sciencetitle", getSciencetitle()) //
                .add("department", getDepartment()) //
                .add("phone", getPhone()) //
                .add("departmentunit", getDepartmentunit()) //
                .add("email", getEmail()) //
                .add("specializations", getSpecializations()) //
                .add("homepage", getHomepage()) //
                .add("experience", getExperience()) //
                .add("implementations", getImplementations()) //
                .add("researches", getResearches()) //
                .add("grants", getGrants()) //
                .add("evaluations", getEvaluations()) //
                .add("publications", getPublications()) //
                .add("ownInventions", getOwnInventions()) //
                .add("password", "XXXX") //
                .add("validated", getValidated()) //
                .add("activated", getActivated()) //
                .add("uniquestamp", getUniquestamp()) //
                .add("admin", getAdmin()) //
                .add("photo", getPhoto()) //
                .toString();
    }
}