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

import pl.xperios.tdb.domain.Permission;
import pl.xperios.tdb.domain.Permission_;
import pl.xperios.tdb.domain.QPermission;

public interface PermissionRepository extends CrudRepository<Permission, Long>, JpaRepository<Permission, Long>, QueryDslPredicateExecutor<Permission>,
        QuerydslBinderCustomizer<QPermission> {

    default List<Permission> complete(String query, int maxResults) {
        Permission probe = new Permission();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Permission_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Permission> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }

    /**
     * Return the persistent instance of {@link Permission} with the given unique property value name,
     * or null if there is no such persistent instance.
     *
     * @param name the unique value
     * @return the corresponding {@link Permission} persistent instance or null
     */
    Permission getByName(String name);

    default void customize(QuerydslBindings bindings, QPermission member) {
    }
}