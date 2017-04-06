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
import pl.xperios.tdb.domain.User;
import pl.xperios.tdb.repository.UserRepository;

@RestController
@RequestMapping(value = "/rest/user")
@Slf4j
//@PreAuthorize("hasAuthority('TDB.user.read')")
public class UserRest {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Page<User> query(@QuerydslPredicate(root = User.class) Predicate predicate, Pageable pageable) throws Exception {
//        Thread.sleep(5000);
        return userRepository.findAll(predicate, pageable);
    }
}
