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

import pl.xperios.tdb.domain.Users;
import pl.xperios.tdb.dto.UsersDTO;
import pl.xperios.tdb.dto.UsersDTOService;
import pl.xperios.tdb.dto.support.PageRequestByExample;
import pl.xperios.tdb.dto.support.PageResponse;
import pl.xperios.tdb.repository.UsersRepository;
import pl.xperios.tdb.rest.support.AutoCompleteQuery;

@RestController
@RequestMapping("/api/userss")
public class UsersResource {

    private final Logger log = LoggerFactory.getLogger(UsersResource.class);

    @Inject
    private UsersRepository usersRepository;
    @Inject
    private UsersDTOService usersDTOService;

    /**
     * Create a new Users.
     */
    @RequestMapping(value = "/", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDTO> create(@RequestBody UsersDTO usersDTO) throws URISyntaxException {

        log.debug("Create UsersDTO : {}", usersDTO);

        if (usersDTO.isIdSet()) {
            return ResponseEntity.badRequest().header("Failure", "Cannot create Users with existing ID").body(null);
        }

        UsersDTO result = usersDTOService.save(usersDTO);

        return ResponseEntity.created(new URI("/api/userss/" + result.id)).body(result);
    }

    /**
    * Find by id Users.
    */
    @RequestMapping(value = "/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDTO> findById(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Find by id Users : {}", id);

        return Optional.ofNullable(usersDTOService.findOne(id)).map(usersDTO -> new ResponseEntity<>(usersDTO, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Update Users.
     */
    @RequestMapping(value = "/", method = PUT, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UsersDTO> update(@RequestBody UsersDTO usersDTO) throws URISyntaxException {

        log.debug("Update UsersDTO : {}", usersDTO);

        if (!usersDTO.isIdSet()) {
            return create(usersDTO);
        }

        UsersDTO result = usersDTOService.save(usersDTO);

        return ResponseEntity.ok().body(result);
    }

    /**
     * Find a Page of Users using query by example.
     */
    @RequestMapping(value = "/page", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<PageResponse<UsersDTO>> findAll(@RequestBody PageRequestByExample<UsersDTO> prbe) throws URISyntaxException {
        PageResponse<UsersDTO> pageResponse = usersDTOService.findAll(prbe);
        return new ResponseEntity<>(pageResponse, new HttpHeaders(), HttpStatus.OK);
    }

    /**
    * Auto complete support.
    */
    @RequestMapping(value = "/complete", method = POST, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UsersDTO>> complete(@RequestBody AutoCompleteQuery acq) throws URISyntaxException {

        List<UsersDTO> results = usersDTOService.complete(acq.query, acq.maxResults);

        return new ResponseEntity<>(results, new HttpHeaders(), HttpStatus.OK);
    }

    /**
     * Delete by id Users.
     */
    @RequestMapping(value = "/{id}", method = DELETE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> delete(@PathVariable Integer id) throws URISyntaxException {

        log.debug("Delete by id Users : {}", id);

        try {
            usersRepository.delete(id);
            return ResponseEntity.ok().build();
        } catch (Exception x) {
            // todo: dig exception, most likely org.hibernate.exception.ConstraintViolationException
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}