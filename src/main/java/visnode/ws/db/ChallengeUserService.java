package visnode.ws.db;

import org.springframework.stereotype.Service;

/**
 * The challenge user service
 */
@Service
public class ChallengeUserService extends AbsDBService<ChallengeUser> {

    public ChallengeUserService(ChallengeUserRepository repository) {
        super(repository);
    }
    
}
