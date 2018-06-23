package visnode.ws.entity;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Entity repository controller
 */
@RestController
@RequestMapping("/v1")
public class EntityController {

    /** Entity instances */
    private final EntityIntances instances;

    @Autowired
    public EntityController(EntityIntances instances) {
        this.instances = instances;
    }

    /**
     * Returns entity data
     *
     * @param entity
     * @param query
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{entity}", method = RequestMethod.GET)
    public ResponseEntity fildAll(@PathVariable("entity") String entity, @RequestParam(required = false) String query) {
        try {
            return new ResponseEntity(instances.get(entity).findAll(query), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Returns entity data
     *
     * @param entity
     * @param id
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{entity}/{id}", method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable("entity") String entity, @PathVariable("id") long id) {
        try {
            Optional obj = instances.get(entity).findById(id);
            if (!obj.isPresent()) {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity(obj.get(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Returns entity data
     *
     * @param entity
     * @param object
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{entity}", method = RequestMethod.POST)
    public ResponseEntity post(@PathVariable("entity") String entity, @RequestBody String object) {
        return new ResponseEntity(instances.get(entity).save(object), HttpStatus.OK);
    }

    /**
     * Returns entity data
     *
     * @param entity
     * @param id
     * @param object
     * @return ResponseEntity
     */
    @RequestMapping(value = "/{entity}/{id}", method = RequestMethod.POST)
    public ResponseEntity post(@PathVariable("entity") String entity, @PathVariable("id") long id, @RequestBody String object) {
        return new ResponseEntity(instances.get(entity).update(object), HttpStatus.OK);
    }

}
