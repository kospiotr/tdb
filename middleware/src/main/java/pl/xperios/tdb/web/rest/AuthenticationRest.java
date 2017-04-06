package pl.xperios.tdb.web.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rest/authentication")
@Api(value = "/rest/authentication")
@Slf4j
public class AuthenticationRest {

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Current Authentication", response = String.class)
    public Authentication current() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
