package pl.xperios.tdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import pl.xperios.tdb.models.DepartmentUnit;
import pl.xperios.tdb.models.QDepartmentUnit;

public interface DepartmentUnitRepository extends JpaRepository<DepartmentUnit, Long>, QueryDslPredicateExecutor<DepartmentUnit>,
		QuerydslBinderCustomizer<QDepartmentUnit> {

	@Override
	default void customize(QuerydslBindings bindings, QDepartmentUnit departmentUnit) {
		bindings.bind(departmentUnit.name).first((path, value) -> path.containsIgnoreCase(value));
	}
}
