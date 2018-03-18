package visnode.ws.authentication;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Authentication controller
 */
@RestController
@RequestMapping("/v1")
public class AuthenticationController {

    /** The authentication service */
    private final AuthenticationService service;

    @Autowired
    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    /**
     * Returns entity data
     *
     * @param object
     * @return ResponseEntity
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Map<String, String> object) {
        try {
            if (service.isValid(object.get("user"), object.get("password"))) {
                return new ResponseEntity(HttpStatus.OK);
            }
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

}
