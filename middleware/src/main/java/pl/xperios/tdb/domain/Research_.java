/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import java.time.LocalDate;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Research.class)
public abstract class Research_ {

    // Raw attributes
    public static volatile SingularAttribute<Research, Integer> id;
    public static volatile SingularAttribute<Research, Integer> scientistId;
    public static volatile SingularAttribute<Research, String> departments;
    public static volatile SingularAttribute<Research, String> unit;
    public static volatile SingularAttribute<Research, String> name;
    public static volatile SingularAttribute<Research, String> type;
    public static volatile SingularAttribute<Research, String> projecttarget;
    public static volatile SingularAttribute<Research, String> description;
    public static volatile SingularAttribute<Research, String> projecttime;
    public static volatile SingularAttribute<Research, Integer> cost;
    public static volatile SingularAttribute<Research, String> foundingsources;
    public static volatile SingularAttribute<Research, String> partners;
    public static volatile SingularAttribute<Research, String> results;
    public static volatile SingularAttribute<Research, String> industries;
    public static volatile SingularAttribute<Research, String> keywords;
    public static volatile SingularAttribute<Research, String> benefits;
    public static volatile SingularAttribute<Research, String> injBenefits;
    public static volatile SingularAttribute<Research, String> scientists;
    public static volatile SingularAttribute<Research, LocalDate> modificationdate;
    public static volatile SingularAttribute<Research, Boolean> published;
    public static volatile SingularAttribute<Research, String> state;
}