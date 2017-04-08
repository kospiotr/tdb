/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/dto/EntityDTO.java.e.vm
 */
package pl.xperios.tdb.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple DTO for Research.
 */
public class ResearchDTO {
    public Integer id;
    public Integer scientistId;
    public String departments;
    public String unit;
    public String name;
    public String type;
    public String projecttarget;
    public String description;
    public String projecttime;
    public Integer cost;
    public String foundingsources;
    public String partners;
    public String results;
    public String industries;
    public String keywords;
    public String benefits;
    public String injBenefits;
    public String scientists;
    public LocalDate modificationdate;
    public Boolean published;
    public String state;

    @JsonIgnore
    public boolean isIdSet() {
        return id != null;
    }
}