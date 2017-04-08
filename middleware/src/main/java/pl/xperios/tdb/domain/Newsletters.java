/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/Entity.java.e.vm
 */
package pl.xperios.tdb.domain;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "newsletters")
public class Newsletters implements Identifiable<String>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Newsletters.class.getName());

    // Raw attributes
    private String id;
    private Boolean technologies;
    private Boolean projects;
    private Boolean messages;
    private Boolean admin;

    @Override
    public String entityClassName() {
        return Newsletters.class.getSimpleName();
    }

    // -- [id] ------------------------

    @Override
    @NotEmpty
    @Size(max = 512)
    @Column(name = "email", length = 512)
    @Id
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public Newsletters id(String id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null && !id.isEmpty();
    }
    // -- [technologies] ------------------------

    @NotNull
    @Column(name = "technologies", nullable = false, length = 0)
    public Boolean getTechnologies() {
        return technologies;
    }

    public void setTechnologies(Boolean technologies) {
        this.technologies = technologies;
    }

    public Newsletters technologies(Boolean technologies) {
        setTechnologies(technologies);
        return this;
    }
    // -- [projects] ------------------------

    @NotNull
    @Column(name = "projects", nullable = false, length = 0)
    public Boolean getProjects() {
        return projects;
    }

    public void setProjects(Boolean projects) {
        this.projects = projects;
    }

    public Newsletters projects(Boolean projects) {
        setProjects(projects);
        return this;
    }
    // -- [messages] ------------------------

    @NotNull
    @Column(name = "messages", nullable = false, length = 0)
    public Boolean getMessages() {
        return messages;
    }

    public void setMessages(Boolean messages) {
        this.messages = messages;
    }

    public Newsletters messages(Boolean messages) {
        setMessages(messages);
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

    public Newsletters admin(Boolean admin) {
        setAdmin(admin);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Newsletters withDefaults() {
        setTechnologies(false);
        setProjects(false);
        setMessages(false);
        setAdmin(false);
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Newsletters && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Newsletters instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("technologies", getTechnologies()) //
                .add("projects", getProjects()) //
                .add("messages", getMessages()) //
                .add("admin", getAdmin()) //
                .toString();
    }
}