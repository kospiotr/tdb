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

import pl.xperios.tdb.domain.Messages;
import pl.xperios.tdb.dto.MessagesDTO;
import pl.xperios.tdb.dto.MessagesDTOService;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.MessagesRepository;
import pl.xperios.tdb.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/api/messagess")
public class MessagesResource {

    private final Logger log = LoggerFactory.getLogger(MessagesResource.class);

    @Inject
    private MessagesRepository messagesRepository;
    @Inject
    private MessagesDTOService messagesDTOService;

    /**
     * Create a new Messages.
     */
    @RequestMapping(value = "/", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagesDTO> create(@RequestBody MessagesDTO messagesDTO) throws URISyntaxException {

        log.debug("Create MessagesDTO : {}", messagesDTO);

        if (messagesDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create Messages with existing ID").body(null);
        }

        MessagesDTO result = messagesDTOService.save(messagesDTO);

        return ResponseEntity.created(new URI("/api/messagess/" + result.id)).body(result);
    }

    /**
    * Find by id Messages.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagesDTO> findById(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Find by id Messages : {}", id);

        return Optional.ofNullable(messagesDTOService.findOne(id)).map(messagesDTO -> new ResponseEntity<>(messagesDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Messages.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<MessagesDTO> update(@RequestBody MessagesDTO messagesDTO) throws URISyntaxException {

        log.debug("Update MessagesDTO : {}", messagesDTO);

        if (!messagesDTO.isIdSet()) {
            return create(messagesDTO);
        }

        MessagesDTO result = messagesDTOService.save(messagesDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of Messages using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<MessagesDTO>> findAll(@RequestBody PageRequestByExample<MessagesDTO> prbe) throws URISyntaxException {
        PageResponse<MessagesDTO> pageResponse = messagesDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<MessagesDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<MessagesDTO> results = messagesDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id Messages.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Delete by id Messages : {}", id);

        try {
            messagesRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}