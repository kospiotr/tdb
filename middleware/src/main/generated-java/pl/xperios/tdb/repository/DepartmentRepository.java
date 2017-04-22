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

import pl.xperios.tdb.domain.Department;
import pl.xperios.tdb.domain.Department_;
import pl.xperios.tdb.domain.QDepartment;

public interface DepartmentRepository extends CrudRepository<Department, Long>, JpaRepository<Department, Long>, QueryDslPredicateExecutor<Department>,
        QuerydslBinderCustomizer<QDepartment> {

    default List<Department> complete(String query, int maxResults) {
        Department probe = new Department();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Department_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Department> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }

    default void customize(QuerydslBindings bindings, QDepartment member) {
    }
}