/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Laboratories.class)
public abstract class Laboratories_ {

    // Raw attributes
    public static volatile SingularAttribute<Laboratories, Integer> id;
    public static volatile SingularAttribute<Laboratories, Integer> scientistId;
    public static volatile SingularAttribute<Laboratories, String> departments;
    public static volatile SingularAttribute<Laboratories, String> units;
    public static volatile SingularAttribute<Laboratories, String> name;
    public static volatile SingularAttribute<Laboratories, String> description;
    public static volatile SingularAttribute<Laboratories, String> contact;
    public static volatile SingularAttribute<Laboratories, LocalDate> modificationdate;
    public static volatile SingularAttribute<Laboratories, Boolean> published;
    public static volatile SingularAttribute<Laboratories, String> state;
}