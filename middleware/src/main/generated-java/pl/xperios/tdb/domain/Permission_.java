/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Permission.class)
public abstract class Permission_ {

    // Raw attributes
    public static volatile SingularAttribute<Permission, Long> id;
    public static volatile SingularAttribute<Permission, String> name;
    public static volatile SingularAttribute<Permission, Long> version;
}