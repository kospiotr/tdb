/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(UserGroup.class)
public abstract class UserGroup_ {

    // Raw attributes
    public static volatile SingularAttribute<UserGroup, Long> id;
    public static volatile SingularAttribute<UserGroup, String> name;
    public static volatile SingularAttribute<UserGroup, Long> version;

    // Many to many
    public static volatile ListAttribute<UserGroup, User> users;
    public static volatile ListAttribute<UserGroup, Permission> permissions;
}