package visnode.ws.authentication;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import visnode.ws.OpenAccess;
import visnode.ws.db.UserService;

/**
 * Authentication controller
 */
@RestController
@RequestMapping("/v1")
public class AuthenticationController {

    /** User service */
    private final UserService userService;
    /** The authentication service */
    private final AuthenticationService service;
    /** Token factory */
    private final AuthenticationTokenFactory tokenFactory;
    /** Token Service */
    private final AuthenticationTokenService tokenService;

    @Autowired
    public AuthenticationController(AuthenticationService service,
            AuthenticationTokenFactory tokenFactory,
            AuthenticationTokenService tokenService,
            UserService userService) {
        this.service = service;
        this.tokenFactory = tokenFactory;
        this.tokenService = tokenService;
        this.userService = userService;
    }

    /**
     * Executes the login
     *
     * @param object
     * @return ResponseEntity
     */
    @OpenAccess
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(@RequestBody Map<String, String> object) {
        try {
            String user = object.get("user");
            String password = object.get("password");
            if (!service.isValid(user, password)) {
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
            }
            AuthenticationToken token = tokenFactory.create();
            tokenService.addToken(user, token.getToken());
            return new ResponseEntity(token.toHeaderMap(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Executes the logout
     *
     * @param token
     * @return ResponseEntity
     */
    @OpenAccess
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseEntity logout(@RequestHeader(AuthenticationToken.HEADER) String token) {
        try {
            if (!tokenService.isValid(token)) {
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            }
            tokenService.removeToken(token);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity(HttpStatus.UNAUTHORIZED);
        }
    }
    
    /**
     * Creates a new user
     *
     * @param object
     * @return ResponseEntity
     */
    @OpenAccess
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity user(@RequestBody String object) {
        return new ResponseEntity(userService.save(object), HttpStatus.OK);
    }

}
