package pl.xperios.tdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import pl.xperios.tdb.domain.Permission;
import pl.xperios.tdb.domain.QPermission;

public interface PermissionRepository extends JpaRepository<Permission, Long>, QueryDslPredicateExecutor<Permission>, QuerydslBinderCustomizer<QPermission> {


    @Override
    default void customize(QuerydslBindings bindings, QPermission root) {

    }

}
