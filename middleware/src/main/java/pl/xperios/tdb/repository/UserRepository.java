package pl.xperios.tdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import pl.xperios.tdb.domain.QUser;
import pl.xperios.tdb.domain.User;

public interface UserRepository extends JpaRepository<User, Long>, QueryDslPredicateExecutor<User>, QuerydslBinderCustomizer<QUser> {

    User findByUsername(String username);


    @Override
    default void customize(QuerydslBindings bindings, QUser root) {
        bindings.excluding(root.password);
    }

}
