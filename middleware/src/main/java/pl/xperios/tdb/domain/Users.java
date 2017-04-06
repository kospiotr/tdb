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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

@Entity
@Table(name = "`users`")
public class Users implements Identifiable<Integer>, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Users.class.getName());

    // Raw attributes
    private Integer id;
    private String email;
    private String password;
    private String industry;
    private String name;
    private String address;
    private String phone;
    private String nip;
    private String size;
    private Boolean connection;
    private Boolean validated;
    private Boolean activated;
    private String uniquestamp;

    @Override
    public String entityClassName() {
        return Users.class.getSimpleName();
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

    public Users id(Integer id) {
        setId(id);
        return this;
    }

    @Override
    @Transient
    public boolean isIdSet() {
        return id != null;
    }
    // -- [email] ------------------------

    @Email
    @NotEmpty
    @Size(max = 256)
    @Column(name = "email", nullable = false, length = 256)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users email(String email) {
        setEmail(email);
        return this;
    }
    // -- [password] ------------------------

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "`password`", nullable = false, length = 1024)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users password(String password) {
        setPassword(password);
        return this;
    }
    // -- [industry] ------------------------

    @NotEmpty
    @Size(max = 256)
    @Column(name = "industry", nullable = false, length = 256)
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public Users industry(String industry) {
        setIndustry(industry);
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

    public Users name(String name) {
        setName(name);
        return this;
    }
    // -- [address] ------------------------

    @NotEmpty
    @Size(max = 256)
    @Column(name = "address", nullable = false, length = 256)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Users address(String address) {
        setAddress(address);
        return this;
    }
    // -- [phone] ------------------------

    @NotEmpty
    @Size(max = 256)
    @Column(name = "phone", nullable = false, length = 256)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Users phone(String phone) {
        setPhone(phone);
        return this;
    }
    // -- [nip] ------------------------

    @NotEmpty
    @Size(max = 256)
    @Column(name = "nip", nullable = false, length = 256)
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public Users nip(String nip) {
        setNip(nip);
        return this;
    }
    // -- [size] ------------------------

    @Size(max = 32)
    @Column(name = "`size`", length = 32)
    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Users size(String size) {
        setSize(size);
        return this;
    }
    // -- [connection] ------------------------

    @NotNull
    @Column(name = "`connection`", nullable = false, length = 0)
    public Boolean getConnection() {
        return connection;
    }

    public void setConnection(Boolean connection) {
        this.connection = connection;
    }

    public Users connection(Boolean connection) {
        setConnection(connection);
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

    public Users validated(Boolean validated) {
        setValidated(validated);
        return this;
    }
    // -- [activated] ------------------------

    @NotNull
    @Column(name = "activated", nullable = false, length = 0)
    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
    }

    public Users activated(Boolean activated) {
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

    public Users uniquestamp(String uniquestamp) {
        setUniquestamp(uniquestamp);
        return this;
    }

    /**
     * Apply the default values.
     */
    public Users withDefaults() {
        setActivated(false);
        return this;
    }

    /**
     * Equals implementation using a business key.
     */
    @Override
    public boolean equals(Object other) {
        return this == other || (other instanceof Users && hashCode() == other.hashCode());
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
     * Construct a readable string representation for this Users instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this) //
                .add("id", getId()) //
                .add("email", getEmail()) //
                .add("password", "XXXX") //
                .add("industry", getIndustry()) //
                .add("name", getName()) //
                .add("address", getAddress()) //
                .add("phone", getPhone()) //
                .add("nip", getNip()) //
                .add("size", getSize()) //
                .add("connection", getConnection()) //
                .add("validated", getValidated()) //
                .add("activated", getActivated()) //
                .add("uniquestamp", getUniquestamp()) //
                .toString();
    }
}