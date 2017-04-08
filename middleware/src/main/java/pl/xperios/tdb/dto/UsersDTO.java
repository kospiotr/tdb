/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/dto/EntityDTO.java.e.vm
 */
package pl.xperios.tdb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple DTO for Users.
 */
public class UsersDTO {
    public Integer id;
    public String email;
    public String password;
    public String industry;
    public String name;
    public String address;
    public String phone;
    public String nip;
    public String size;
    public Boolean connection;
    public Boolean validated;
    public Boolean activated;
    public String uniquestamp;

    @JsonIgnore
    public boolean isIdSet() {
        return id != null;
    }
}