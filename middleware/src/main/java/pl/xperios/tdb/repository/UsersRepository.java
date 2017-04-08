/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/repository/EntityRepository.java.e.vm
 */
package pl.xperios.tdb.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.*;

import pl.xperios.tdb.domain.Users;
import pl.xperios.tdb.domain.Users_;

public interface UsersRepository extends JpaRepository<Users, Integer> {

    /**
     * Return the persistent instance of {@link Users} with the given unique property value uniquestamp,
     * or null if there is no such persistent instance.
     *
     * @param uniquestamp the unique value
     * @return the corresponding {@link Users} persistent instance or null
     */
    Users getByUniquestamp(String uniquestamp);

    default List<Users> complete(String query, int maxResults) {
        Users probe = new Users();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Users_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Users> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }
}