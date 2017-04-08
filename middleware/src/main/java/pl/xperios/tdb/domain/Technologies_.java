/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Technologies.class)
public abstract class Technologies_ {

    // Raw attributes
    public static volatile SingularAttribute<Technologies, Integer> id;
    public static volatile SingularAttribute<Technologies, String> unit;
    public static volatile SingularAttribute<Technologies, String> department;
    public static volatile SingularAttribute<Technologies, String> type;
    public static volatile SingularAttribute<Technologies, String> name;
    public static volatile SingularAttribute<Technologies, String> targets;
    public static volatile SingularAttribute<Technologies, String> description;
    public static volatile SingularAttribute<Technologies, String> goodsInnovation;
    public static volatile SingularAttribute<Technologies, String> goodsConcurency;
    public static volatile SingularAttribute<Technologies, String> benefits;
    public static volatile SingularAttribute<Technologies, String> keywords;
    public static volatile SingularAttribute<Technologies, String> requestnumber;
    public static volatile SingularAttribute<Technologies, LocalDate> requestdate;
    public static volatile SingularAttribute<Technologies, String> requestcountries;
    public static volatile SingularAttribute<Technologies, String> patentnumber;
    public static volatile SingularAttribute<Technologies, LocalDate> patentdate;
    public static volatile SingularAttribute<Technologies, String> patentcountries;
    public static volatile SingularAttribute<Technologies, String> scientists;
    public static volatile SingularAttribute<Technologies, LocalDate> modificationdate;
    public static volatile SingularAttribute<Technologies, Integer> scientistId;
    public static volatile SingularAttribute<Technologies, Boolean> published;
    public static volatile SingularAttribute<Technologies, String> state;
    public static volatile SingularAttribute<Technologies, String> info;
}