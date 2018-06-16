package visnode.ws.authentication;

import java.time.Instant;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import visnode.ws.db.UserSession;
import visnode.ws.db.UserSessionService;

/**
 * Token service
 */
@Service
public class AuthenticationTokenService {

    private final UserSessionService userSessionService;

    @Autowired
    public AuthenticationTokenService(UserSessionService userSessionService) {
        this.userSessionService = userSessionService;
    }

    /**
     * Adds a new token
     *
     * @param user
     * @param token
     */
    public void addToken(String user, String token) {
        Date now = Date.from(Instant.now());
        UserSession userSession = new UserSession();
        userSession.setName(user);
        userSession.setToken(token);
        userSession.setDateCreation(now);
        userSession.setDateLastAccess(now);
        userSessionService.save(userSession);
    }
    
    /**
     * Removes a token
     * 
     * @param token 
     */
    public void removeToken(String token) {
        userSessionService.deleteByToken(token);
    }
    
    /**
     * Returns true if the token is valid
     * 
     * @param token
     * @return boolean
     */
    public boolean isValid(String token) {
        if (token == null || token.isEmpty()) {
            return false;
        }
        return userSessionService.findByToken(token) != null;
    }

}
