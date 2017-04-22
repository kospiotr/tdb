/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/rest/EntityResource.java.e.vm
 */
package pl.xperios.tdb.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.*;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import com.querydsl.core.types.Predicate;

import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import pl.xperios.tdb.domain.Department;
import pl.xperios.tdb.repository.DepartmentRepository;

@Slf4j
@RestController
@RequestMapping("/api/departments")
public class DepartmentResource {

    @Inject
    private DepartmentRepository departmentRepository;

    /**
    * Find by id Department.
    */
    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Department> findOne(@PathVariable Long id) {

        log.debug("Find by id Department : {}", id);

        Department record = departmentRepository.findOne(id);

        ResponseEntity<Department> result = Optional.ofNullable(record).map(existingRecord -> new ResponseEntity<>(existingRecord, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        return result;
    }

    /**
     * Find a Page of Department using query by example.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find")
    public Page<Department> findAll(@QuerydslPredicate(root = Department.class) Predicate predicate, Pageable pageable) {
        return departmentRepository.findAll(predicate, pageable);
    }

    /**
    * Save Department.
    */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Save")
    public ResponseEntity<Department> save(@RequestBody Department department) {

        log.debug("Save Department : {}", department);
        Department result = departmentRepository.save(department);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Delete by id Department.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        log.debug("Delete by id Department : {}", id);

        try {
            departmentRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}