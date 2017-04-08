/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Newsletters.class)
public abstract class Newsletters_ {

    // Raw attributes
    public static volatile SingularAttribute<Newsletters, String> id;
    public static volatile SingularAttribute<Newsletters, Boolean> technologies;
    public static volatile SingularAttribute<Newsletters, Boolean> projects;
    public static volatile SingularAttribute<Newsletters, Boolean> messages;
    public static volatile SingularAttribute<Newsletters, Boolean> admin;
}