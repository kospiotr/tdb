/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/repository/EntityRepository.java.e.vm
 */
package pl.xperios.tdb.repository;

import java.util.List;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;

import pl.xperios.tdb.domain.Instrument;
import pl.xperios.tdb.domain.Instrument_;
import pl.xperios.tdb.domain.QInstrument;

public interface InstrumentRepository extends CrudRepository<Instrument, Long>, JpaRepository<Instrument, Long>, QueryDslPredicateExecutor<Instrument>,
        QuerydslBinderCustomizer<QInstrument> {

    default List<Instrument> complete(String query, int maxResults) {
        Instrument probe = new Instrument();
        probe.setName(query);

        ExampleMatcher matcher = ExampleMatcher.matching() //
                .withMatcher(Instrument_.name.getName(), match -> match.ignoreCase().startsWith());

        Page<Instrument> page = findAll(Example.of(probe, matcher), new PageRequest(0, maxResults));
        return page.getContent();
    }

    default void customize(QuerydslBindings bindings, QInstrument member) {
    }
}