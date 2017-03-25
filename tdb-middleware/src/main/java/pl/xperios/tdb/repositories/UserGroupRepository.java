package pl.xperios.tdb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import pl.xperios.tdb.models.QUserGroup;
import pl.xperios.tdb.models.UserGroup;

import java.util.Optional;

public interface UserGroupRepository extends JpaRepository<UserGroup, Long>, QueryDslPredicateExecutor<UserGroup>,
		QuerydslBinderCustomizer<QUserGroup> {

	Optional<UserGroup> findByName(String name);


	@Override
	default void customize(QuerydslBindings bindings, QUserGroup userGroup) {
		bindings.bind(userGroup.name).first((path, value) -> path.containsIgnoreCase(value));
	}
}
