/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/support/Identifiable.java.p.vm
 */
package pl.xperios.tdb.domain;

import java.io.Serializable;

/**
 * By making entities implement this interface we can easily retrieve from the
 * {@link com.jaxio.jpa.querybyexample.GenericRepository} the identifier property of the entity.
 */
public interface Identifiable<PK extends Serializable> {

    String entityClassName();

    /**
     * @return the primary key
     */
    PK getId();

    /**
     * Sets the primary key
     *
     * @param id primary key
     */
    void setId(PK id);

    /**
     * Helper method to know whether the primary key is set or not.
     *
     * @return true if the primary key is set, false otherwise
     */
    boolean isIdSet();
}