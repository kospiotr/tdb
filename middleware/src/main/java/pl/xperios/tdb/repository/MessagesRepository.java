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

import pl.xperios.tdb.domain.Messages;
import pl.xperios.tdb.domain.Messages_;

public interface MessagesRepository extends JpaRepository<Messages, Integer> {

    default List<Messages> complete(String query, int maxResults) {
        Messages probe = new Messages();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Messages_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Messages> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }
}