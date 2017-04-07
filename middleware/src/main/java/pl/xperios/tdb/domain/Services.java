/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/domain/Entity.java.e.vm
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
@Table(name = "services")
public class Services implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Services.class.getName());

    // Raw attributes
    private Integer id;
    private Integer scientistId;
    private String units;
    private String name;
    private String department;
    private String description;
    private String contact;
    private LocalDate modificationdate;
    private Boolean published;
    private String state;

    @Override
    public String entityClassName() {
        return Services.class.getSimpleName();
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

    public Services id(Integer id) {
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

    public Services scientistId(Integer scientistId) {
        setScientistId(scientistId);
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

    public Services units(String units) {
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

    public Services name(String name) {
        setName(name);
        return this;
    }
    // -- [department] ------------------------

    @Size(max = 1024)
    @Column(name = "department", length = 1024)
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Services department(String department) {
        setDepartment(department);
        return this;
    }
    // -- [description] ------------------------

    @NotEmpty
    @Size(max = 5000)
    @Column(name = "description", nullable = false, length = 5000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Services description(String description) {
        setDescription(description);
        return this;
    }
    // -- [contact] ------------------------

    @NotEmpty
    @Size(max = 512)
    @Column(name = "contact", nullable = false, length = 512)
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Services contact(String contact) {
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

    public Services modificationdate(LocalDate modificationdate) {
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

    public Services published(Boolean published) {
        setPublished(published);
        return this;
    }
    // -- [state] ------------------------

    @NotEmpty
    @Size(max = 10)
    @Column(name = "`state`", nullable = false, length = 10)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Services state(String state) {
        setState(state);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Services withDefaults() {
        setState("waiting");
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Services && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Services instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("scientistId", getScientistId()) //
                .add("units", getUnits()) //
                .add("name", getName()) //
                .add("department", getDepartment()) //
                .add("description", getDescription()) //
                .add("contact", getContact()) //
                .add("modificationdate", getModificationdate()) //
                .add("published", getPublished()) //
                .add("state", getState()) //
                .toString();
    }
}