/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/repository/EntityRepository.java.e.vm
 */
package pl.xperios.tdb.repository;

import java.util.List;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.*;

import pl.xperios.tdb.domain.Scientists;
import pl.xperios.tdb.domain.Scientists_;

public interface ScientistsRepository extends JpaRepository<Scientists, Integer> {

    /**
     * Return the persistent instance of {@link Scientists} with the given unique property value uniquestamp,
     * or null if there is no such persistent instance.
     *
     * @param uniquestamp the unique value
     * @return the corresponding {@link Scientists} persistent instance or null
     */
    Scientists getByUniquestamp(String uniquestamp);

    default List<Scientists> complete(String query, int maxResults) {
        Scientists probe = new Scientists();
        probe.setFirstname(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Scientists_.firstname.getName(), match -> match.ignoreCase().startsWith());

        Page<Scientists> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }
}