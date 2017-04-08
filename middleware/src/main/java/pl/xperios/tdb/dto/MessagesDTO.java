/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/dto/EntityDTO.java.e.vm
 */
package pl.xperios.tdb.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple DTO for Messages.
 */
public class MessagesDTO {
    public Integer id;
    public Integer userId;
    public Integer scientistId;
    public String type;
    public String name;
    public String description;
    public LocalDate modificationdate;
    public Boolean published;
    public String state;

    @JsonIgnore
    public boolean isIdSet() {
        return id != null;
    }
}