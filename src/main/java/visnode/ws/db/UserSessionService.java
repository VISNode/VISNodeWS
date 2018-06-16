package visnode.ws.db;

import org.springframework.stereotype.Service;

/**
 * User session service
 */
@Service
public class UserSessionService extends AbsDBService<UserSession> {

    private final UserSessionRepository repository;
    
    public UserSessionService(UserSessionRepository repository) {
        super(repository);
        this.repository = repository;
    }
    
    /**
     * Delete session by token
     * 
     * @param token 
     */
    public void deleteByToken(String token) {
        repository.deleteByToken(token);
    }

    /**
     * Finds a session by token
     * 
     * @param token
     * @return 
     */
    public UserSession findByToken(String token) {
        return repository.findByToken(token);
    }
    
}
