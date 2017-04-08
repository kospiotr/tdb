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

import pl.xperios.tdb.domain.Research;
import pl.xperios.tdb.dto.ResearchDTO;
import pl.xperios.tdb.dto.ResearchDTOService;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.ResearchRepository;
import pl.xperios.tdb.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/api/researchs")
public class ResearchResource {

    private final Logger log = LoggerFactory.getLogger(ResearchResource.class);

    @Inject
    private ResearchRepository researchRepository;
    @Inject
    private ResearchDTOService researchDTOService;

    /**
     * Create a new Research.
     */
    @RequestMapping(value = "/", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResearchDTO> create(@RequestBody ResearchDTO researchDTO) throws URISyntaxException {

        log.debug("Create ResearchDTO : {}", researchDTO);

        if (researchDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create Research with existing ID").body(null);
        }

        ResearchDTO result = researchDTOService.save(researchDTO);

        return ResponseEntity.created(new URI("/api/researchs/" + result.id)).body(result);
    }

    /**
    * Find by id Research.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResearchDTO> findById(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Find by id Research : {}", id);

        return Optional.ofNullable(researchDTOService.findOne(id)).map(researchDTO -> new ResponseEntity<>(researchDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Research.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResearchDTO> update(@RequestBody ResearchDTO researchDTO) throws URISyntaxException {

        log.debug("Update ResearchDTO : {}", researchDTO);

        if (!researchDTO.isIdSet()) {
            return create(researchDTO);
        }

        ResearchDTO result = researchDTOService.save(researchDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of Research using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<ResearchDTO>> findAll(@RequestBody PageRequestByExample<ResearchDTO> prbe) throws URISyntaxException {
        PageResponse<ResearchDTO> pageResponse = researchDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ResearchDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<ResearchDTO> results = researchDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id Research.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Delete by id Research : {}", id);

        try {
            researchRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}