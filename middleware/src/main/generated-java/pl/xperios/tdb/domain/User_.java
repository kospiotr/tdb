/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(User.class)
public abstract class User_ {

    // Raw attributes
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Integer> status;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, Long> version;

    // Many to many
    public static volatile ListAttribute<User, UserGroup> userGroups;
    public static volatile ListAttribute<User, Permission> permissions;
}