/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/rest/EntityResource.java.e.vm
 */
package pl.xperios.tdb.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.data.domain.*;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import com.querydsl.core.types.Predicate;

import io.swagger.annotations.ApiOperation;

import lombok.extern.slf4j.Slf4j;

import pl.xperios.tdb.domain.Instrument;
import pl.xperios.tdb.repository.InstrumentRepository;

@Slf4j
@RestController
@RequestMapping("/api/instruments")
public class InstrumentResource {

    @Inject
    private InstrumentRepository instrumentRepository;

    /**
    * Find by id Instrument.
    */
    @RequestMapping(value = "/{id}", method = GET)
    public ResponseEntity<Instrument> findOne(@PathVariable Long id) {

        log.debug("Find by id Instrument : {}", id);

        Instrument record = instrumentRepository.findOne(id);

        ResponseEntity<Instrument> result = Optional.ofNullable(record).map(existingRecord -> new ResponseEntity<>(existingRecord, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        return result;
    }

    /**
     * Find a Page of Instrument using query by example.
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "Find")
    public Page<Instrument> findAll(@QuerydslPredicate(root = Instrument.class) Predicate predicate, Pageable pageable) {
        return instrumentRepository.findAll(predicate, pageable);
    }

    /**
    * Save Instrument.
    */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Save")
    public ResponseEntity<Instrument> save(@RequestBody Instrument instrument) {

        log.debug("Save Instrument : {}", instrument);
        Instrument result = instrumentRepository.save(instrument);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Delete by id Instrument.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Delete")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        log.debug("Delete by id Instrument : {}", id);

        try {
            instrumentRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}