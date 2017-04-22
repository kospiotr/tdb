/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/repository/EntityRepository.java.e.vm
 */
package pl.xperios.tdb.repository;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

import pl.xperios.tdb.domain.QUserGroup;
import pl.xperios.tdb.domain.UserGroup;
import pl.xperios.tdb.domain.UserGroup_;

public interface UserGroupRepository
        extends CrudRepository<UserGroup, Long>, JpaRepository<UserGroup, Long>, QueryDslPredicateExecutor<UserGroup>, QuerydslBinderCustomizer<QUserGroup> {

    default List<UserGroup> complete(String query, int maxResults) {
        UserGroup probe = new UserGroup();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(UserGroup_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<UserGroup> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }

    /**
     * Return the persistent instance of {@link UserGroup} with the given unique property value name,
     * or null if there is no such persistent instance.
     *
     * @param name the unique value
     * @return the corresponding {@link UserGroup} persistent instance or null
     */
    UserGroup getByName(String name);

    default void customize(QuerydslBindings bindings, QUserGroup member) {
    }
}