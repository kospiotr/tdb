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

import pl.xperios.tdb.domain.Technologies;
import pl.xperios.tdb.domain.Technologies_;

public interface TechnologiesRepository extends JpaRepository<Technologies, Integer> {

    default List<Technologies> complete(String query, int maxResults) {
        Technologies probe = new Technologies();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Technologies_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Technologies> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }
}