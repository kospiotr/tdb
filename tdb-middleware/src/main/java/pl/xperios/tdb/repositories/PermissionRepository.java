package pl.xperios.tdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import pl.xperios.tdb.models.Permission;
import pl.xperios.tdb.models.QPermission;

public interface PermissionRepository extends JpaRepository<Permission, Long>, QueryDslPredicateExecutor<Permission>, QuerydslBinderCustomizer<QPermission> {


    @Override
    default void customize(QuerydslBindings bindings, QPermission root) {

    }

}
