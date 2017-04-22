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
@ToString(of = { "id", "name", })
@Entity
@Table(name = "department_unit")
public class DepartmentUnit implements Identifiable<Long>, Serializable {

    // Raw attributes
    @Column(name = "id", precision = 19)
    @GeneratedValue(strategy = IDENTITY)
    @Id
    private Long id;

    @Size(max = 255)
    @Column(name = "name")
    private String name;

    // Many to one
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: DepartmentUnit.department ==> Department.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    @JoinColumn(name = "department_id")
    @ManyToOne
    private Department department;

    // -----------------------------------------------------------------
    // Many to One support
    // -----------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: DepartmentUnit.department ==> Department.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * Set the {@link #department} without adding this DepartmentUnit instance on the passed {@link #department}
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    public DepartmentUnit department(Department department) {
        setDepartment(department);
        return this;
    }

}