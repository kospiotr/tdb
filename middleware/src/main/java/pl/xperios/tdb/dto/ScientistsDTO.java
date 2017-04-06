/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/dto/EntityDTO.java.e.vm
 */
package pl.xperios.tdb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple DTO for Scientists.
 */
public class ScientistsDTO {
    public Integer id;
    public String firstname;
    public String lastname;
    public String sciencetitle;
    public String department;
    public String phone;
    public String departmentunit;
    public String email;
    public String specializations;
    public String homepage;
    public String experience;
    public String implementations;
    public String researches;
    public String grants;
    public String evaluations;
    public String publications;
    public String ownInventions;
    public String password;
    public Boolean validated;
    public Integer activated;
    public String uniquestamp;
    public Boolean admin;
    public String photo;

    @JsonIgnore
    public boolean isIdSet() {
        return id != null;
    }
}