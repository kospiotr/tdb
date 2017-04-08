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

import pl.xperios.tdb.domain.Assets;
import pl.xperios.tdb.domain.Assets_;

public interface AssetsRepository extends JpaRepository<Assets, Integer> {

    default List<Assets> complete(String query, int maxResults) {
        Assets probe = new Assets();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Assets_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Assets> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }
}