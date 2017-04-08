/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/dto/EntityDTO.java.e.vm
 */
package pl.xperios.tdb.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple DTO for Technologies.
 */
public class TechnologiesDTO {
    public Integer id;
    public String unit;
    public String department;
    public String type;
    public String name;
    public String targets;
    public String description;
    public String goodsInnovation;
    public String goodsConcurency;
    public String benefits;
    public String keywords;
    public String requestnumber;
    public LocalDate requestdate;
    public String requestcountries;
    public String patentnumber;
    public LocalDate patentdate;
    public String patentcountries;
    public String scientists;
    public LocalDate modificationdate;
    public Integer scientistId;
    public Boolean published;
    public String state;
    public String info;

    @JsonIgnore
    public boolean isIdSet() {
        return id != null;
    }
}