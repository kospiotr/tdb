package pl.xperios.tdb.repositories;

import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import pl.xperios.tdb.models.Instrument;
import pl.xperios.tdb.models.QInstrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long>, QueryDslPredicateExecutor<Instrument>,
        QuerydslBinderCustomizer<QInstrument> {

    @Override
    default void customize(QuerydslBindings bindings, QInstrument instrument) {
        bindings.bind(instrument.name).first(StringExpression::containsIgnoreCase);
        bindings.bind(instrument.contact).first(StringExpression::containsIgnoreCase);
    }

}
