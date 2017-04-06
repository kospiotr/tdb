/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Scientists.class)
public abstract class Scientists_ {

    // Raw attributes
    public static volatile SingularAttribute<Scientists, Integer> id;
    public static volatile SingularAttribute<Scientists, String> firstname;
    public static volatile SingularAttribute<Scientists, String> lastname;
    public static volatile SingularAttribute<Scientists, String> sciencetitle;
    public static volatile SingularAttribute<Scientists, String> department;
    public static volatile SingularAttribute<Scientists, String> phone;
    public static volatile SingularAttribute<Scientists, String> departmentunit;
    public static volatile SingularAttribute<Scientists, String> email;
    public static volatile SingularAttribute<Scientists, String> specializations;
    public static volatile SingularAttribute<Scientists, String> homepage;
    public static volatile SingularAttribute<Scientists, String> experience;
    public static volatile SingularAttribute<Scientists, String> implementations;
    public static volatile SingularAttribute<Scientists, String> researches;
    public static volatile SingularAttribute<Scientists, String> grants;
    public static volatile SingularAttribute<Scientists, String> evaluations;
    public static volatile SingularAttribute<Scientists, String> publications;
    public static volatile SingularAttribute<Scientists, String> ownInventions;
    public static volatile SingularAttribute<Scientists, String> password;
    public static volatile SingularAttribute<Scientists, Boolean> validated;
    public static volatile SingularAttribute<Scientists, Integer> activated;
    public static volatile SingularAttribute<Scientists, String> uniquestamp;
    public static volatile SingularAttribute<Scientists, Boolean> admin;
    public static volatile SingularAttribute<Scientists, String> photo;
}