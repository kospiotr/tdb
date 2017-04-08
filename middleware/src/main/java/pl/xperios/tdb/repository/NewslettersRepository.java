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

import pl.xperios.tdb.domain.Newsletters;
import pl.xperios.tdb.domain.Newsletters_;

public interface NewslettersRepository extends JpaRepository<Newsletters, String> {

    default List<Newsletters> complete(String query, int maxResults) {
        Newsletters probe = new Newsletters();

        ExampleMatcher matcher = ExampleMatcher.matching() //
        ;

        Page<Newsletters> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }
}