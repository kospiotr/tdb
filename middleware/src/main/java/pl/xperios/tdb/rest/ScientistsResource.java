/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/rest/EntityResource.java.e.vm
 */
package pl.xperios.tdb.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.DELETE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;

import pl.xperios.tdb.domain.Scientists;
import pl.xperios.tdb.dto.ScientistsDTO;
import pl.xperios.tdb.dto.ScientistsDTOService;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.ScientistsRepository;
import pl.xperios.tdb.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/api/scientistss")
public class ScientistsResource {

    private final Logger log = LoggerFactory.getLogger(ScientistsResource.class);

    @Inject
    private ScientistsRepository scientistsRepository;
    @Inject
    private ScientistsDTOService scientistsDTOService;

    /**
     * Create a new Scientists.
     */
    @RequestMapping(value = "/", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ScientistsDTO> create(@RequestBody ScientistsDTO scientistsDTO) throws URISyntaxException {

        log.debug("Create ScientistsDTO : {}", scientistsDTO);

        if (scientistsDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create Scientists with existing ID").body(null);
        }

        ScientistsDTO result = scientistsDTOService.save(scientistsDTO);

        return ResponseEntity.created(new URI("/api/scientistss/" + result.id)).body(result);
    }

    /**
    * Find by id Scientists.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ScientistsDTO> findById(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Find by id Scientists : {}", id);

        return Optional.ofNullable(scientistsDTOService.findOne(id)).map(scientistsDTO -> new ResponseEntity<>(scientistsDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Scientists.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ScientistsDTO> update(@RequestBody ScientistsDTO scientistsDTO) throws URISyntaxException {

        log.debug("Update ScientistsDTO : {}", scientistsDTO);

        if (!scientistsDTO.isIdSet()) {
            return create(scientistsDTO);
        }

        ScientistsDTO result = scientistsDTOService.save(scientistsDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of Scientists using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<ScientistsDTO>> findAll(@RequestBody PageRequestByExample<ScientistsDTO> prbe) throws URISyntaxException {
        PageResponse<ScientistsDTO> pageResponse = scientistsDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ScientistsDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<ScientistsDTO> results = scientistsDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id Scientists.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Delete by id Scientists : {}", id);

        try {
            scientistsRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}