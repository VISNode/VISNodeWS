package visnode.ws.authentication;

import java.util.HashMap;
import java.util.Map;

/**
 * Token information
 */
public class AuthenticationToken {

    /** Header */
    public static final String HEADER = "visnode-token";
    /** Token */
    private final String token;

    public AuthenticationToken(String token) {
        this.token = token;
    }

    /**
     * Returns the token
     *
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     * Convert token to header map
     * 
     * @return Map
     */
    public Map toHeaderMap() {
        Map map = new HashMap();
        map.put(HEADER, getToken());
        return map;
    }

}
