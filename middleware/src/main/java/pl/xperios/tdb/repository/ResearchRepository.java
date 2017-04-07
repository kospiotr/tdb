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

import pl.xperios.tdb.domain.Research;
import pl.xperios.tdb.domain.Research_;

public interface ResearchRepository extends JpaRepository<Research, Integer> {

    default List<Research> complete(String query, int maxResults) {
        Research probe = new Research();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Research_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Research> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }
}