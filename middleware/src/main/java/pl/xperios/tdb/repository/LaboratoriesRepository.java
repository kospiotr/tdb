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

import pl.xperios.tdb.domain.Laboratories;
import pl.xperios.tdb.domain.Laboratories_;

public interface LaboratoriesRepository extends JpaRepository<Laboratories, Integer> {

    default List<Laboratories> complete(String query, int maxResults) {
        Laboratories probe = new Laboratories();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Laboratories_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Laboratories> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }
}