/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Services.class)
public abstract class Services_ {

    // Raw attributes
    public static volatile SingularAttribute<Services, Integer> id;
    public static volatile SingularAttribute<Services, Integer> scientistId;
    public static volatile SingularAttribute<Services, String> units;
    public static volatile SingularAttribute<Services, String> name;
    public static volatile SingularAttribute<Services, String> department;
    public static volatile SingularAttribute<Services, String> description;
    public static volatile SingularAttribute<Services, String> contact;
    public static volatile SingularAttribute<Services, LocalDate> modificationdate;
    public static volatile SingularAttribute<Services, Boolean> published;
    public static volatile SingularAttribute<Services, String> state;
}