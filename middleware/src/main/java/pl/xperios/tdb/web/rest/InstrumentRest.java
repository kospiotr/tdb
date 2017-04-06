package pl.xperios.tdb.web.rest;

import com.querydsl.core.types.Predicate;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pl.xperios.tdb.domain.Instrument;
import pl.xperios.tdb.repository.InstrumentRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/instrument")
@Api(value = "/rest/instrument")
@Slf4j
@PreAuthorize("hasAuthority('TDB.instrument.read')")
public class InstrumentRest {

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private InstrumentRepository instrumentRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find")
    public Page<Instrument> find(@QuerydslPredicate(root = Instrument.class) Predicate predicate, Pageable pageable) {
        return instrumentRepository.findAll(predicate, pageable);
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @ApiOperation(value = "Count")
    public long count(@QuerydslPredicate(root = Instrument.class) Predicate predicate) {
        return instrumentRepository.count(predicate);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Get single")
    public Instrument get(@PathVariable("id") Long id) {
        return instrumentRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Update")
    public Instrument update(@PathVariable Long id, @RequestBody Instrument instrument) {
        instrument.setId(id);
//        instrument.setCode(instrument.getCode() + "upd");
        return instrumentRepository.save(instrument);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create")
    public Instrument create(@RequestBody Instrument instrument) {
//        instrument.setCode(instrument.getCode() + "new");
        return instrumentRepository.save(instrument);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete")
    public void update(@PathVariable Long id) {
        instrumentRepository.delete(id);
    }

    @RequestMapping(value = "/batch", method = RequestMethod.POST)
    @ApiOperation(value = "Batch processing")
    public void batch(@RequestBody BatchProcessing<Instrument, Long> operations) {
        List<Instrument> toDelete = instrumentRepository.findAll(operations.getDelete());
        instrumentRepository.delete(toDelete);

        log.debug("Removed {} records", toDelete.size());
    }

}
