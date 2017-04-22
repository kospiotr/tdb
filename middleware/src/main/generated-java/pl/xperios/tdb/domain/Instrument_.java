/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Instrument.class)
public abstract class Instrument_ {

    // Raw attributes
    public static volatile SingularAttribute<Instrument, Long> id;
    public static volatile SingularAttribute<Instrument, String> contact;
    public static volatile SingularAttribute<Instrument, String> description;
    public static volatile SingularAttribute<Instrument, String> indexNo;
    public static volatile SingularAttribute<Instrument, String> name;

    // Many to one
    public static volatile SingularAttribute<Instrument, DepartmentUnit> departmentUnit;
}