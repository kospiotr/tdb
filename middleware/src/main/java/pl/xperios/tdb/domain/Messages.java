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
@Table(name = "messages")
public class Messages implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Messages.class.getName());

    // Raw attributes
    private Integer id;
    private Integer userId;
    private Integer scientistId;
    private String type;
    private String name;
    private String description;
    private LocalDate modificationdate;
    private Boolean published;
    private String state;

    @Override
    public String entityClassName() {
        return Messages.class.getSimpleName();
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

    public Messages id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [userId] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "user_id", precision = 10)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Messages userId(Integer userId) {
        setUserId(userId);
        return this;
    }
    // -- [scientistId] ------------------------

    @Digits(integer = 10, fraction = 0)
    @Column(name = "scientist_id", precision = 10)
    public Integer getScientistId() {
        return scientistId;
    }

    public void setScientistId(Integer scientistId) {
        this.scientistId = scientistId;
    }

    public Messages scientistId(Integer scientistId) {
        setScientistId(scientistId);
        return this;
    }
    // -- [type] ------------------------

    @NotEmpty
    @Size(max = 512)
    @Column(name = "`type`", nullable = false, length = 512)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Messages type(String type) {
        setType(type);
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

    public Messages name(String name) {
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

    public Messages description(String description) {
        setDescription(description);
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

    public Messages modificationdate(LocalDate modificationdate) {
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

    public Messages published(Boolean published) {
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

    public Messages state(String state) {
        setState(state);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Messages withDefaults() {
        setState("waiting");
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Messages && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Messages instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("userId", getUserId()) //
                .add("scientistId", getScientistId()) //
                .add("type", getType()) //
                .add("name", getName()) //
                .add("description", getDescription()) //
                .add("modificationdate", getModificationdate()) //
                .add("published", getPublished()) //
                .add("state", getState()) //
                .toString();
    }
}