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

import pl.xperios.tdb.domain.Services;
import pl.xperios.tdb.domain.Services_;

public interface ServicesRepository extends JpaRepository<Services, Integer> {

    default List<Services> complete(String query, int maxResults) {
        Services probe = new Services();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Services_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Services> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }
}