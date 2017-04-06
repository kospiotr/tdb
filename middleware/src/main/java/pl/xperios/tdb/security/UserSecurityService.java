package pl.xperios.tdb.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static pl.xperios.tdb.security.SecurityService.mapAuthorities;

@Service
public class UserSecurityService implements UserDetailsService {

    @Autowired
    private SecurityService securityService;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserPrincipal> user = securityService.findUser(username);
        return user.flatMap(this::map).orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }

    private Optional<UserDetails> map(UserPrincipal user) {
        User out = new User(user.getUsername(), user.getPassword(), true, true, true, true, mapAuthorities(user.getAuthorities()));
        return Optional.of(out);
    }

}
