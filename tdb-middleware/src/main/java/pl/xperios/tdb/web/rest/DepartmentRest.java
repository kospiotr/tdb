package pl.xperios.tdb.web.rest;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.xperios.tdb.models.Department;
import pl.xperios.tdb.repositories.DepartmentRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/department")
@Api(value = "/rest/department")
@Slf4j
@PreAuthorize("hasAuthority('TDB.department.read')")
public class DepartmentRest {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private DepartmentRepository departmentRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find")
    public Page<Department> find(@QuerydslPredicate(root = Department.class) Predicate predicate, Pageable pageable) {
        return departmentRepository.findAll(predicate, pageable);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get single")
    public Department get(@PathVariable("id") Long id) {
        return departmentRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update")
    public Department update(@PathVariable Long id, @RequestBody Department department) {
        department.setId(id);
        department.setCode(department.getCode() + "upd");
        return departmentRepository.save(department);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create")
    public Department create(@RequestBody Department department) {
        department.setCode(department.getCode() + "new");
        return departmentRepository.save(department);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete")
    public void update(@PathVariable Long id) {
        departmentRepository.delete(id);
    }

    @RequestMapping(value = "/batch", method = RequestMethod.POST)
    @ApiOperation(value = "Batch processing")
    public void batch(@RequestBody BatchProcessing<Department, Long> operations) {
        List<Department> toDelete = departmentRepository.findAll(operations.getDelete());
        departmentRepository.delete(toDelete);

        log.debug("Removed {} records", toDelete.size());
    }

}
