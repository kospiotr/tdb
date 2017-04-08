/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/dto/EntityDTO.java.e.vm
 */
package pl.xperios.tdb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple DTO for Newsletters.
 */
public class NewslettersDTO {
    public String id;
    public Boolean technologies;
    public Boolean projects;
    public Boolean messages;
    public Boolean admin;

    @JsonIgnore
    public boolean isIdSet() {
        return id != null && !id.isEmpty();
    }
}