/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/domain/EntityMeta_.java.e.vm
 */
package pl.xperios.tdb.domain;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Assets.class)
public abstract class Assets_ {

    // Raw attributes
    public static volatile SingularAttribute<Assets, Integer> id;
    public static volatile SingularAttribute<Assets, Integer> relatedid;
    public static volatile SingularAttribute<Assets, String> type;
    public static volatile SingularAttribute<Assets, String> name;
    public static volatile SingularAttribute<Assets, String> realname;
}