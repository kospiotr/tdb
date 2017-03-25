package pl.xperios.tdb.web.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

import static pl.xperios.tdb.config.GlobalValues.Principals.GUEST;
import static pl.xperios.tdb.web.security.SecurityService.mapAuthorities;

@Component
@Slf4j
public class GuestSecurityService extends AnonymousAuthenticationFilter {

	@Autowired
	private SecurityService securityService;

	public GuestSecurityService() {
		super(GUEST);
		log.debug("GuestSecurityService created");

	}

	@Override
	protected Authentication createAuthentication(HttpServletRequest request) {
		log.debug("Creating anonymous authentication");
		Optional<UserPrincipal> user = securityService.findUser(GUEST);
		return user
				.flatMap(this::map)
				.orElseThrow(() -> new UsernameNotFoundException("Username " + GUEST + " not found"));
	}

	private Optional<Authentication> map(UserPrincipal user) {
		AnonymousAuthenticationToken out = new AnonymousAuthenticationToken(
				GUEST,
				GUEST,
				mapAuthorities(user.getAuthorities()));
		return Optional.of(out);
	}

}

