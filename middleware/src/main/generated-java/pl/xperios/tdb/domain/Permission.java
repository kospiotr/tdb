/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/domain/Entity.java.e.vm
 */
package pl.xperios.tdb.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.Size;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = { "id", "name", "version", })
@Entity
@Table(name = "permission")
public class Permission implements Identifiable<Long>, Serializable {

    // Raw attributes
    @Column(name = "id", precision = 19)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Size(max = 255)
    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "version", precision = 19)
    @Version
    private Long version;

}