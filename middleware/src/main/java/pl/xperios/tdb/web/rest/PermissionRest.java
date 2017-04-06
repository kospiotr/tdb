package pl.xperios.tdb.web.rest;

import com.querydsl.core.types.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.xperios.tdb.domain.Permission;
import pl.xperios.tdb.repository.PermissionRepository;

@RestController
@RequestMapping(value = "/rest/permission")
@Slf4j
//@PreAuthorize("hasAuthority('TDB.user.read')")
public class PermissionRest {

    @Autowired
    private PermissionRepository permissionRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Permission> query(@QuerydslPredicate(root = Permission.class) Predicate predicate, Pageable pageable) {
        return permissionRepository.findAll(predicate, pageable);
    }
}
