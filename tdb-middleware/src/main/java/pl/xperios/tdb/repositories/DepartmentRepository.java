package pl.xperios.tdb.repositories;

import com.querydsl.core.types.dsl.SimpleExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import pl.xperios.tdb.models.Department;
import pl.xperios.tdb.models.QDepartment;

public interface DepartmentRepository extends JpaRepository<Department, Long>, QueryDslPredicateExecutor<Department>,
        QuerydslBinderCustomizer<QDepartment> {

    @Override
    default void customize(QuerydslBindings bindings, QDepartment department) {
        bindings.bind(department.id).first(SimpleExpression::eq);
        bindings.bind(department.name).first(StringExpression::containsIgnoreCase);
        bindings.bind(department.code).first(StringExpression::containsIgnoreCase);
    }

}