/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Messages.class)
public abstract class Messages_ {

    // Raw attributes
    public static volatile SingularAttribute<Messages, Integer> id;
    public static volatile SingularAttribute<Messages, Integer> userId;
    public static volatile SingularAttribute<Messages, Integer> scientistId;
    public static volatile SingularAttribute<Messages, String> type;
    public static volatile SingularAttribute<Messages, String> name;
    public static volatile SingularAttribute<Messages, String> description;
    public static volatile SingularAttribute<Messages, LocalDate> modificationdate;
    public static volatile SingularAttribute<Messages, Boolean> published;
    public static volatile SingularAttribute<Messages, String> state;
}