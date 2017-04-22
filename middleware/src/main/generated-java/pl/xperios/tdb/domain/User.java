/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/Entity.java.e.vm
 */
package pl.xperios.tdb.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = { "id", "password", "status", "username", "version", })
@Entity
@Table(name = "\"user\"")
public class User implements Identifiable<Long>, Serializable {

    // Raw attributes
    @Column(name = "id", precision = 19)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Size(max = 255)
    @Column(name = "\"password\"")
    private String password;

    @Digits(integer = 10, fraction = 0)
    @Column(name = "status", precision = 10)
    private Integer status;

    @Size(max = 255)
    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "version", precision = 19)
    @Version
    private Long version;

    // Many to many
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: user ==> userGroups
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @ManyToMany(mappedBy = "users")
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: user ==> permissions
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @JoinTable(name = "user_permission", joinColumns = @JoinColumn(name = "user_id") , inverseJoinColumns = @JoinColumn(name = "permission_id") )
    @ManyToMany
    private List<Permission> permissions = new ArrayList<Permission>();

    // -------------------------------
    // Role names support
    // -------------------------------

    /**
     * Default implementation returns hard coded granted authorities for this account (i.e. "ROLE_USER" and "ROLE_ADMIN").
     * TODO: You should override this method to provide your own custom authorities using your own logic.
     * Or you can follow Celerio Account Table convention. Please refer to Celerio Documentation.
     */
    @Transient
    public List<String> getRoleNames() {
        List<String> roleNames = new ArrayList<String>();
        if ("user".equalsIgnoreCase(getUsername())) {
            roleNames.add("ROLE_USER");
        } else if ("admin".equalsIgnoreCase(getUsername())) {
            roleNames.add("ROLE_USER");
            roleNames.add("ROLE_ADMIN");
        }

        log.warn("Returning hard coded role names. TODO: get the real role names");
        return roleNames;
    }

    // -----------------------------------------------------------------
    // Many to Many
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: user ==> userGroups
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * Set the {@link #userGroups} list.
     *
     * @param userGroups the list of UserGroup
     */
    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    /**
     * Helper method to add the passed {@link UserGroup} to the {@link #userGroups} list.
     */
    public boolean addUserGroup(UserGroup userGroup) {
        return getUserGroups().add(userGroup);
    }

    /**
     * Helper method to remove the passed {@link UserGroup} from the {@link #userGroups} list.
     */
    public boolean removeUserGroup(UserGroup userGroup) {
        return getUserGroups().remove(userGroup);
    }

    /**
     * Helper method to determine if the passed {@link UserGroup} is present in the {@link #userGroups} list.
     */
    public boolean containsUserGroup(UserGroup userGroup) {
        return getUserGroups() != null && getUserGroups().contains(userGroup);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: user ==> permissions
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * Set the {@link #permissions} list.
     *
     * @param permissions the list of Permission
     */
    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

    /**
     * Helper method to add the passed {@link Permission} to the {@link #permissions} list.
     */
    public boolean addPermission(Permission permission) {
        return getPermissions().add(permission);
    }

    /**
     * Helper method to remove the passed {@link Permission} from the {@link #permissions} list.
     */
    public boolean removePermission(Permission permission) {
        return getPermissions().remove(permission);
    }

    /**
     * Helper method to determine if the passed {@link Permission} is present in the {@link #permissions} list.
     */
    public boolean containsPermission(Permission permission) {
        return getPermissions() != null && getPermissions().contains(permission);
    }

}