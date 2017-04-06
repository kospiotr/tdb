package pl.xperios.tdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import pl.xperios.tdb.domain.DepartmentUnit;
import pl.xperios.tdb.domain.QDepartmentUnit;

public interface DepartmentUnitRepository extends JpaRepository<DepartmentUnit, Long>, QueryDslPredicateExecutor<DepartmentUnit>,
        QuerydslBinderCustomizer<QDepartmentUnit> {

    @Override
    default void customize(QuerydslBindings bindings, QDepartmentUnit departmentUnit) {
        bindings.bind(departmentUnit.name).first((path, value) -> path.containsIgnoreCase(value));
    }
}
