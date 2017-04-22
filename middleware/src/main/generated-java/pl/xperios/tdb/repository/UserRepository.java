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

import pl.xperios.tdb.domain.QUser;
import pl.xperios.tdb.domain.User;
import pl.xperios.tdb.domain.User_;

public interface UserRepository
        extends CrudRepository<User, Long>, JpaRepository<User, Long>, QueryDslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

    default List<User> complete(String query, int maxResults) {
        User probe = new User();
        probe.setUsername(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(User_.username.getName(), match -> match.ignoreCase().startsWith());

        Page<User> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }

    /**
     * Return the persistent instance of {@link User} with the given unique property value username,
     * or null if there is no such persistent instance.
     *
     * @param username the unique value
     * @return the corresponding {@link User} persistent instance or null
     */
    User getByUsername(String username);

    default void customize(QuerydslBindings bindings, QUser member) {
    }
}