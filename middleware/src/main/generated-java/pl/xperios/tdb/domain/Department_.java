/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Department.class)
public abstract class Department_ {

    // Raw attributes
    public static volatile SingularAttribute<Department, Long> id;
    public static volatile SingularAttribute<Department, String> code;
    public static volatile SingularAttribute<Department, String> name;
}