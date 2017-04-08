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

import pl.xperios.tdb.domain.Laboratories;
import pl.xperios.tdb.dto.LaboratoriesDTO;
import pl.xperios.tdb.dto.LaboratoriesDTOService;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.LaboratoriesRepository;
import pl.xperios.tdb.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/api/laboratoriess")
public class LaboratoriesResource {

    private final Logger log = LoggerFactory.getLogger(LaboratoriesResource.class);

    @Inject
    private LaboratoriesRepository laboratoriesRepository;
    @Inject
    private LaboratoriesDTOService laboratoriesDTOService;

    /**
     * Create a new Laboratories.
     */
    @RequestMapping(value = "/", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LaboratoriesDTO> create(@RequestBody LaboratoriesDTO laboratoriesDTO) throws URISyntaxException {

        log.debug("Create LaboratoriesDTO : {}", laboratoriesDTO);

        if (laboratoriesDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create Laboratories with existing ID").body(null);
        }

        LaboratoriesDTO result = laboratoriesDTOService.save(laboratoriesDTO);

        return ResponseEntity.created(new URI("/api/laboratoriess/" + result.id)).body(result);
    }

    /**
    * Find by id Laboratories.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LaboratoriesDTO> findById(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Find by id Laboratories : {}", id);

        return Optional.ofNullable(laboratoriesDTOService.findOne(id)).map(laboratoriesDTO -> new ResponseEntity<>(laboratoriesDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Laboratories.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<LaboratoriesDTO> update(@RequestBody LaboratoriesDTO laboratoriesDTO) throws URISyntaxException {

        log.debug("Update LaboratoriesDTO : {}", laboratoriesDTO);

        if (!laboratoriesDTO.isIdSet()) {
            return create(laboratoriesDTO);
        }

        LaboratoriesDTO result = laboratoriesDTOService.save(laboratoriesDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of Laboratories using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<LaboratoriesDTO>> findAll(@RequestBody PageRequestByExample<LaboratoriesDTO> prbe) throws URISyntaxException {
        PageResponse<LaboratoriesDTO> pageResponse = laboratoriesDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<LaboratoriesDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<LaboratoriesDTO> results = laboratoriesDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id Laboratories.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Delete by id Laboratories : {}", id);

        try {
            laboratoriesRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}