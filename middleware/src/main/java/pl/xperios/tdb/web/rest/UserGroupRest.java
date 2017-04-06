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
import pl.xperios.tdb.domain.UserGroup;
import pl.xperios.tdb.repository.UserGroupRepository;

@RestController
@RequestMapping(value = "/rest/usergroup")
@Slf4j
//@PreAuthorize("hasAuthority('TDB.user.read')")
public class UserGroupRest {

    @Autowired
    private UserGroupRepository userGroupRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Page<UserGroup> query(@QuerydslPredicate(root = UserGroup.class) Predicate predicate, Pageable pageable) {
        return userGroupRepository.findAll(predicate, pageable);
    }
}
