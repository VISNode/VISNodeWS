package visnode.ws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visnode.ws.db.DatabaseException;
import visnode.ws.db.FirestoreRepository;
import visnode.ws.db.Repository;

/**
 * Entity repository controller
 */
@RestController
@RequestMapping("/v1")
public class EntityController {

    /** Database repository */
    private final Repository repository;

    @Autowired
    public EntityController(FirestoreRepository repository) {
        this.repository = repository;
    }

    /**
     * Returns entity data
     *
     * @param entity
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{entity}", method = RequestMethod.GET)
    public ResponseEntity get(@PathVariable("entity") String entity) {
        try {
            return new ResponseEntity(repository.get(entity), HttpStatus.OK);
        } catch (DatabaseException ex) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
