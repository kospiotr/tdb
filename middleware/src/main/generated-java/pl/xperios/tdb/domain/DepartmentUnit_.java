/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(DepartmentUnit.class)
public abstract class DepartmentUnit_ {

    // Raw attributes
    public static volatile SingularAttribute<DepartmentUnit, Long> id;
    public static volatile SingularAttribute<DepartmentUnit, String> name;

    // Many to one
    public static volatile SingularAttribute<DepartmentUnit, Department> department;
}