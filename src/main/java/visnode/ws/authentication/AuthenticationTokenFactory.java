package visnode.ws.authentication;

import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * Token factory
 */
@Service
public class AuthenticationTokenFactory {
    
    /**
     * Creates a new token
     * 
     * @return 
     */
    public AuthenticationToken create() {
        UUID uuidToken = UUID.randomUUID();
        String token = uuidToken.toString().replaceAll("-", "");
        return new AuthenticationToken(token);
    }
    
}
