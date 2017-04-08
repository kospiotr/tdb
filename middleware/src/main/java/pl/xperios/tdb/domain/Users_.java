/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Users.class)
public abstract class Users_ {

    // Raw attributes
    public static volatile SingularAttribute<Users, Integer> id;
    public static volatile SingularAttribute<Users, String> email;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> industry;
    public static volatile SingularAttribute<Users, String> name;
    public static volatile SingularAttribute<Users, String> address;
    public static volatile SingularAttribute<Users, String> phone;
    public static volatile SingularAttribute<Users, String> nip;
    public static volatile SingularAttribute<Users, String> size;
    public static volatile SingularAttribute<Users, Boolean> connection;
    public static volatile SingularAttribute<Users, Boolean> validated;
    public static volatile SingularAttribute<Users, Boolean> activated;
    public static volatile SingularAttribute<Users, String> uniquestamp;
}