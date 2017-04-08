/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/Entity.java.e.vm
 */
package pl.xperios.tdb.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;
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

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "laboratories")
public class Laboratories implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Laboratories.class.getName());

    // Raw attributes
    private Integer id;
    private Integer scientistId;
    private String departments;
    private String units;
    private String name;
    private String description;
    private String contact;
    private LocalDate modificationdate;
    private Boolean published;
    private String state;

    @Override
    public String entityClassName() {
        return Laboratories.class.getSimpleName();
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

    public Laboratories id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [scientistId] ------------------------

    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "scientist_id", nullable = false, precision = 10)
    public Integer getScientistId() {
        return scientistId;
    }

    public void setScientistId(Integer scientistId) {
        this.scientistId = scientistId;
    }

    public Laboratories scientistId(Integer scientistId) {
        setScientistId(scientistId);
        return this;
    }
    // -- [departments] ------------------------

    @Size(max = 1024)
    @Column(name = "departments", length = 1024)
    public String getDepartments() {
        return departments;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public Laboratories departments(String departments) {
        setDepartments(departments);
        return this;
    }
    // -- [units] ------------------------

    @Size(max = 1024)
    @Column(name = "units", length = 1024)
    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Laboratories units(String units) {
        setUnits(units);
        return this;
    }
    // -- [name] ------------------------

    @NotEmpty
    @Size(max = 512)
    @Column(name = "name", nullable = false, length = 512)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Laboratories name(String name) {
        setName(name);
        return this;
    }
    // -- [description] ------------------------

    @NotEmpty
    @Size(max = 10000)
    @Column(name = "description", nullable = false, length = 10000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Laboratories description(String description) {
        setDescription(description);
        return this;
    }
    // -- [contact] ------------------------

    @Size(max = 2000)
    @Column(name = "contact", length = 2000)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Laboratories contact(String contact) {
        setContact(contact);
        return this;
    }
    // -- [modificationdate] ------------------------

    @NotNull
    @Column(name = "modificationdate", nullable = false, length = 10)
    public LocalDate getModificationdate() {
        return modificationdate;
    }

    public void setModificationdate(LocalDate modificationdate) {
        this.modificationdate = modificationdate;
    }

    public Laboratories modificationdate(LocalDate modificationdate) {
        setModificationdate(modificationdate);
        return this;
    }
    // -- [published] ------------------------

    @NotNull
    @Column(name = "published", nullable = false, length = 0)
    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Laboratories published(Boolean published) {
        setPublished(published);
        return this;
    }
    // -- [state] ------------------------

    @NotEmpty
    @Size(max = 10)
    @Column(name = "\"state\"", nullable = false, length = 10)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Laboratories state(String state) {
        setState(state);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Laboratories withDefaults() {
        setState("waiting");
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Laboratories && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Laboratories instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("scientistId", getScientistId()) //
                .add("departments", getDepartments()) //
                .add("units", getUnits()) //
                .add("name", getName()) //
                .add("description", getDescription()) //
                .add("contact", getContact()) //
                .add("modificationdate", getModificationdate()) //
                .add("published", getPublished()) //
                .add("state", getState()) //
                .toString();
    }
}