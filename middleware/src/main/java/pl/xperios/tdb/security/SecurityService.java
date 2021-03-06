package pl.xperios.tdb.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.xperios.tdb.config.GlobalValues;
import pl.xperios.tdb.domain.Permission;
import pl.xperios.tdb.domain.User;
import pl.xperios.tdb.domain.UserGroup;
import pl.xperios.tdb.repository.UserGroupRepository;
import pl.xperios.tdb.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;
import static pl.xperios.tdb.config.GlobalValues.Principals.GUEST;

@Slf4j
@Service
public class SecurityService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGroupRepository userGroupRepository;

    @Transactional(readOnly = true)
    @Cacheable(cacheNames = "UserPrincipal", key = "#username")
    public Optional<UserPrincipal> findUser(String username) {
        User user = userRepository.getByUsername(username);
        if (user == null) {
            return Optional.empty();
        }
        UserPrincipal userPrincipal = mapUserToUserPrincipal(user);

        return Optional.of(userPrincipal);
    }

    public UserPrincipal mapUserToUserPrincipal(User user) {
        List<String> authorities = new ArrayList<>();

        List<Permission> userPermissions = user.getPermissions();
        List<UserGroup> userGroups = new ArrayList<>();
        userGroups.addAll(user.getUserGroups());
        userGroups.add(getAnybodyUserGroup());
        userGroups.add(getDefaultUserGroup(user.getUsername()));

        List<String> directPermissions = extractPermissions(userPermissions);
        List<String> permissionsViaUserGroup = extractPermissionsFromUserGroups(userGroups);
        List<String> rolesViaUserGroup = extractRolesFromUserGroups(userGroups);

        authorities.addAll(directPermissions);
        authorities.addAll(permissionsViaUserGroup);
        authorities.addAll(rolesViaUserGroup);

        UserPrincipal userPrincipal = new UserPrincipal(user.getUsername(), user.getPassword(), authorities);
        log.debug("UserPrincipal: {}", userPrincipal);
        return userPrincipal;
    }

    private UserGroup getAnybodyUserGroup() {
        Optional<UserGroup> out = Optional.ofNullable(userGroupRepository.getByName(GlobalValues.UserGroups.ANYBODY));
        return out.isPresent() ?
                out.get() :
                out.orElseThrow(() -> new IllegalStateException("Can't find user group 'anybody'"));
    }

    private UserGroup getDefaultUserGroup(String username) {
        Optional<UserGroup> out;
        if (username == null || GUEST.equalsIgnoreCase(username)) {
            out = Optional.ofNullable(userGroupRepository.getByName(GlobalValues.UserGroups.ANONYMOUS));
        } else {
            out = Optional.ofNullable(userGroupRepository.getByName(GlobalValues.UserGroups.USER));
        }

        return out.isPresent() ?
                out.get() :
                out.orElseThrow(() -> new IllegalStateException("Can't find default user group for username: " + username));
    }


    private List<String> extractPermissions(List<Permission> permissions) {
        return permissions.stream()
                .map(Permission::getName)
                .collect(toList());
    }

    private List<String> extractPermissionsFromUserGroups(List<UserGroup> userGroups) {
        return userGroups.stream()
                .map(UserGroup::getPermissions)
                .flatMap(Collection::stream)
                .map(Permission::getName)
                .collect(toList());
    }

    private List<String> extractRolesFromUserGroups(List<UserGroup> userGroups) {
        return userGroups.stream()
                .map(this::mapUserGroupToRole)
                .collect(toList());
    }

    String mapUserGroupToRole(UserGroup ug) {
        return GlobalValues.Roles.userGroupToRole(ug.getName());
    }

    public static List<? extends GrantedAuthority> mapAuthorities(List<String> authorities) {
        return authorities.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(toList());
    }

}
