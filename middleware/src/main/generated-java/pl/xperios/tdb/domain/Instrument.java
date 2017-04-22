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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = { "id", "contact", "description", "indexNo", "name", })
@Entity
@Table(name = "instrument")
public class Instrument implements Identifiable<Long>, Serializable {

    // Raw attributes
    @Column(name = "id", precision = 19)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Size(max = 255)
    @Column(name = "contact")
    private String contact;

    @Size(max = 2147483647)
    @Column(name = "description", length = 2147483647)
    private String description;

    @Size(max = 255)
    @Column(name = "index_no")
    private String indexNo;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    // Many to one
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Instrument.departmentUnit ==> DepartmentUnit.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @JoinColumn(name = "department_unit_id")
    @ManyToOne
    private DepartmentUnit departmentUnit;

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Instrument.departmentUnit ==> DepartmentUnit.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * Set the {@link #departmentUnit} without adding this Instrument instance on the passed {@link #departmentUnit}
     */
    public void setDepartmentUnit(DepartmentUnit departmentUnit) {
        this.departmentUnit = departmentUnit;
    }

    public Instrument departmentUnit(DepartmentUnit departmentUnit) {
        setDepartmentUnit(departmentUnit);
        return this;
    }

}