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
import javax.persistence.Version;
import javax.validation.constraints.Size;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = { "id", "name", "version", })
@Entity
@Table(name = "user_group")
public class UserGroup implements Identifiable<Long>, Serializable {

    // Raw attributes
    @Column(name = "id", precision = 19)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Size(max = 255)
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "version", precision = 19)
    @Version
    private Long version;

    // Many to many
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: userGroup ==> users
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @JoinTable(name = "user_group_user", joinColumns = @JoinColumn(name = "user_group_id") , inverseJoinColumns = @JoinColumn(name = "user_id") )
    @ManyToMany
    private List<User> users = new ArrayList<User>();
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: userGroup ==> permissions
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @JoinTable(name = "user_group_permission", joinColumns = @JoinColumn(name = "user_group_id") , inverseJoinColumns = @JoinColumn(name = "permission_id") )
    @ManyToMany
    private List<Permission> permissions = new ArrayList<Permission>();

    // -----------------------------------------------------------------
    // Many to Many
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: userGroup ==> users
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * Set the {@link #users} list.
     *
     * @param users the list of User
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }

    /**
     * Helper method to add the passed {@link User} to the {@link #users} list.
     */
    public boolean addUser(User user) {
        return getUsers().add(user);
    }

    /**
     * Helper method to remove the passed {@link User} from the {@link #users} list.
     */
    public boolean removeUser(User user) {
        return getUsers().remove(user);
    }

    /**
     * Helper method to determine if the passed {@link User} is present in the {@link #users} list.
     */
    public boolean containsUser(User user) {
        return getUsers() != null && getUsers().contains(user);
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: userGroup ==> permissions
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