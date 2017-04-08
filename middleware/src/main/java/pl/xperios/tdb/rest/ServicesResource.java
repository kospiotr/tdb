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

import pl.xperios.tdb.domain.Services;
import pl.xperios.tdb.dto.ServicesDTO;
import pl.xperios.tdb.dto.ServicesDTOService;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.ServicesRepository;
import pl.xperios.tdb.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/api/servicess")
public class ServicesResource {

    private final Logger log = LoggerFactory.getLogger(ServicesResource.class);

    @Inject
    private ServicesRepository servicesRepository;
    @Inject
    private ServicesDTOService servicesDTOService;

    /**
     * Create a new Services.
     */
    @RequestMapping(value = "/", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ServicesDTO> create(@RequestBody ServicesDTO servicesDTO) throws URISyntaxException {

        log.debug("Create ServicesDTO : {}", servicesDTO);

        if (servicesDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create Services with existing ID").body(null);
        }

        ServicesDTO result = servicesDTOService.save(servicesDTO);

        return ResponseEntity.created(new URI("/api/servicess/" + result.id)).body(result);
    }

    /**
    * Find by id Services.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ServicesDTO> findById(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Find by id Services : {}", id);

        return Optional.ofNullable(servicesDTOService.findOne(id)).map(servicesDTO -> new ResponseEntity<>(servicesDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Services.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<ServicesDTO> update(@RequestBody ServicesDTO servicesDTO) throws URISyntaxException {

        log.debug("Update ServicesDTO : {}", servicesDTO);

        if (!servicesDTO.isIdSet()) {
            return create(servicesDTO);
        }

        ServicesDTO result = servicesDTOService.save(servicesDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of Services using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<ServicesDTO>> findAll(@RequestBody PageRequestByExample<ServicesDTO> prbe) throws URISyntaxException {
        PageResponse<ServicesDTO> pageResponse = servicesDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ServicesDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<ServicesDTO> results = servicesDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id Services.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Delete by id Services : {}", id);

        try {
            servicesRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}