/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/dto/EntityDTO.java.e.vm
 */
package pl.xperios.tdb.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple DTO for Laboratories.
 */
public class LaboratoriesDTO {
    public Integer id;
    public Integer scientistId;
    public String departments;
    public String units;
    public String name;
    public String description;
    public String contact;
    public LocalDate modificationdate;
    public Boolean published;
    public String state;

    @JsonIgnore
    public boolean isIdSet() {
        return id != null;
    }
}