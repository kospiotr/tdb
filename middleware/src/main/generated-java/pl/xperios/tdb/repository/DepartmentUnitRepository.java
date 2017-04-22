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

import pl.xperios.tdb.domain.DepartmentUnit;
import pl.xperios.tdb.domain.DepartmentUnit_;
import pl.xperios.tdb.domain.QDepartmentUnit;

public interface DepartmentUnitRepository extends CrudRepository<DepartmentUnit, Long>, JpaRepository<DepartmentUnit, Long>,
        QueryDslPredicateExecutor<DepartmentUnit>, QuerydslBinderCustomizer<QDepartmentUnit> {

    default List<DepartmentUnit> complete(String query, int maxResults) {
        DepartmentUnit probe = new DepartmentUnit();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(DepartmentUnit_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<DepartmentUnit> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }

    default void customize(QuerydslBindings bindings, QDepartmentUnit member) {
    }
}