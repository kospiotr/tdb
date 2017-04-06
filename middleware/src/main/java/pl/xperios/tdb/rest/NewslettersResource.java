/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/rest/EntityResource.java.e.vm
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

import pl.xperios.tdb.domain.Newsletters;
import pl.xperios.tdb.dto.NewslettersDTO;
import pl.xperios.tdb.dto.NewslettersDTOService;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.NewslettersRepository;
import pl.xperios.tdb.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/api/newsletterss")
public class NewslettersResource {

    private final Logger log = LoggerFactory.getLogger(NewslettersResource.class);

    @Inject
    private NewslettersRepository newslettersRepository;
    @Inject
    private NewslettersDTOService newslettersDTOService;

    /**
     * Create a new Newsletters.
     */
    @RequestMapping(value = "/", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<NewslettersDTO> create(@RequestBody NewslettersDTO newslettersDTO) throws URISyntaxException {

        log.debug("Create NewslettersDTO : {}", newslettersDTO);

        if (newslettersDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create Newsletters with existing ID").body(null);
        }

        NewslettersDTO result = newslettersDTOService.save(newslettersDTO);

        return ResponseEntity.created(new URI("/api/newsletterss/" + result.id)).body(result);
    }

    /**
    * Find by id Newsletters.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<NewslettersDTO> findById(@PathVariable String id) throws URISyntaxException {

        log.debug("Find by id Newsletters : {}", id);

        return Optional.ofNullable(newslettersDTOService.findOne(id)).map(newslettersDTO -> new ResponseEntity<>(newslettersDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Newsletters.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<NewslettersDTO> update(@RequestBody NewslettersDTO newslettersDTO) throws URISyntaxException {

        log.debug("Update NewslettersDTO : {}", newslettersDTO);

        if (!newslettersDTO.isIdSet()) {
            return create(newslettersDTO);
        }

        NewslettersDTO result = newslettersDTOService.save(newslettersDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of Newsletters using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<NewslettersDTO>> findAll(@RequestBody PageRequestByExample<NewslettersDTO> prbe) throws URISyntaxException {
        PageResponse<NewslettersDTO> pageResponse = newslettersDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<NewslettersDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<NewslettersDTO> results = newslettersDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id Newsletters.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable String id) throws URISyntaxException {

        log.debug("Delete by id Newsletters : {}", id);

        try {
            newslettersRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}