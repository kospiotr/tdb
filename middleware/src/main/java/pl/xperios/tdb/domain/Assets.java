/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/domain/Entity.java.e.vm
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

import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "assets")
public class Assets implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Assets.class.getName());

    // Raw attributes
    private Integer id;
    private Integer relatedid;
    private String type;
    private String name;
    private String realname;

    @Override
    public String entityClassName() {
        return Assets.class.getSimpleName();
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

    public Assets id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [relatedid] ------------------------

    @Digits(integer = 10, fraction = 0)
    @NotNull
    @Column(name = "relatedid", nullable = false, precision = 10)
    public Integer getRelatedid() {
        return relatedid;
    }

    public void setRelatedid(Integer relatedid) {
        this.relatedid = relatedid;
    }

    public Assets relatedid(Integer relatedid) {
        setRelatedid(relatedid);
        return this;
    }
    // -- [type] ------------------------

    @NotEmpty
    @Size(max = 64)
    @Column(name = "`type`", nullable = false, length = 64)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Assets type(String type) {
        setType(type);
        return this;
    }
    // -- [name] ------------------------

    @NotEmpty
    @Size(max = 256)
    @Column(name = "name", nullable = false, length = 256)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Assets name(String name) {
        setName(name);
        return this;
    }
    // -- [realname] ------------------------

    @Size(max = 11)
    @Column(name = "realname", length = 11)
    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Assets realname(String realname) {
        setRealname(realname);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Assets withDefaults() {
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Assets && hashCode() == other.hashCode());
    }

    private IdentifiableHashBuilder identifiableHashBuilder = new IdentifiableHashBuilder();

    @Override
    public int hashCode() {
        return identifiableHashBuilder.hash(log, this);
    }

    /**
     * Construct a readable string representation for this Assets instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("relatedid", getRelatedid()) //
                .add("type", getType()) //
                .add("name", getName()) //
                .add("realname", getRealname()) //
                .toString();
    }
}