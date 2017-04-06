/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/dto/EntityDTO.java.e.vm
 */
package pl.xperios.tdb.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Simple DTO for Assets.
 */
public class AssetsDTO {
    public Integer id;
    public Integer relatedid;
    public String type;
    public String name;
    public String realname;

    @JsonIgnore
    public boolean isIdSet() {
        return id != null;
    }
}