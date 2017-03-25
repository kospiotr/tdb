package pl.xperios.tdb.web.rest;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.xperios.tdb.models.DepartmentUnit;
import pl.xperios.tdb.repositories.DepartmentUnitRepository;

@RestController
@RequestMapping(value = "/rest/departmentUnit")
@Api(value = "/rest/departmentUnit")
@Slf4j
//@PreAuthorize("hasAuthority('TDB.departmentUnit.read')")
public class DepartmentUnitRest {

    @Autowired
    private DepartmentUnitRepository departmentUnitRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Query for department units")
    public Page<DepartmentUnit> query(@QuerydslPredicate(root = DepartmentUnit.class) Predicate predicate, Pageable pageable) {
        Page<DepartmentUnit> out = departmentUnitRepository.findAll(predicate, pageable);
        return out;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get department unit")
    public DepartmentUnit query(@PathVariable("id") Long id) {
        return departmentUnitRepository.findOne(id);
    }

}
