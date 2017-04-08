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

import pl.xperios.tdb.domain.Technologies;
import pl.xperios.tdb.dto.TechnologiesDTO;
import pl.xperios.tdb.dto.TechnologiesDTOService;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.TechnologiesRepository;
import pl.xperios.tdb.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/api/technologiess")
public class TechnologiesResource {

    private final Logger log = LoggerFactory.getLogger(TechnologiesResource.class);

    @Inject
    private TechnologiesRepository technologiesRepository;
    @Inject
    private TechnologiesDTOService technologiesDTOService;

    /**
     * Create a new Technologies.
     */
    @RequestMapping(value = "/", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TechnologiesDTO> create(@RequestBody TechnologiesDTO technologiesDTO) throws URISyntaxException {

        log.debug("Create TechnologiesDTO : {}", technologiesDTO);

        if (technologiesDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create Technologies with existing ID").body(null);
        }

        TechnologiesDTO result = technologiesDTOService.save(technologiesDTO);

        return ResponseEntity.created(new URI("/api/technologiess/" + result.id)).body(result);
    }

    /**
    * Find by id Technologies.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TechnologiesDTO> findById(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Find by id Technologies : {}", id);

        return Optional.ofNullable(technologiesDTOService.findOne(id)).map(technologiesDTO -> new ResponseEntity<>(technologiesDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Technologies.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TechnologiesDTO> update(@RequestBody TechnologiesDTO technologiesDTO) throws URISyntaxException {

        log.debug("Update TechnologiesDTO : {}", technologiesDTO);

        if (!technologiesDTO.isIdSet()) {
            return create(technologiesDTO);
        }

        TechnologiesDTO result = technologiesDTOService.save(technologiesDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of Technologies using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<TechnologiesDTO>> findAll(@RequestBody PageRequestByExample<TechnologiesDTO> prbe) throws URISyntaxException {
        PageResponse<TechnologiesDTO> pageResponse = technologiesDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TechnologiesDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<TechnologiesDTO> results = technologiesDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id Technologies.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Delete by id Technologies : {}", id);

        try {
            technologiesRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}