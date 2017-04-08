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

import pl.xperios.tdb.domain.Assets;
import pl.xperios.tdb.dto.AssetsDTO;
import pl.xperios.tdb.dto.AssetsDTOService;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.AssetsRepository;
import pl.xperios.tdb.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/api/assetss")
public class AssetsResource {

    private final Logger log = LoggerFactory.getLogger(AssetsResource.class);

    @Inject
    private AssetsRepository assetsRepository;
    @Inject
    private AssetsDTOService assetsDTOService;

    /**
     * Create a new Assets.
     */
    @RequestMapping(value = "/", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AssetsDTO> create(@RequestBody AssetsDTO assetsDTO) throws URISyntaxException {

        log.debug("Create AssetsDTO : {}", assetsDTO);

        if (assetsDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create Assets with existing ID").body(null);
        }

        AssetsDTO result = assetsDTOService.save(assetsDTO);

        return ResponseEntity.created(new URI("/api/assetss/" + result.id)).body(result);
    }

    /**
    * Find by id Assets.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AssetsDTO> findById(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Find by id Assets : {}", id);

        return Optional.ofNullable(assetsDTOService.findOne(id)).map(assetsDTO -> new ResponseEntity<>(assetsDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Assets.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<AssetsDTO> update(@RequestBody AssetsDTO assetsDTO) throws URISyntaxException {

        log.debug("Update AssetsDTO : {}", assetsDTO);

        if (!assetsDTO.isIdSet()) {
            return create(assetsDTO);
        }

        AssetsDTO result = assetsDTOService.save(assetsDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of Assets using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<AssetsDTO>> findAll(@RequestBody PageRequestByExample<AssetsDTO> prbe) throws URISyntaxException {
        PageResponse<AssetsDTO> pageResponse = assetsDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<AssetsDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<AssetsDTO> results = assetsDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id Assets.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Delete by id Assets : {}", id);

        try {
            assetsRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}