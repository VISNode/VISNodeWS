package visnode.ws.db;

import org.springframework.stereotype.Service;

/**
 * The user service
 */
@Service
public class UserService extends AbsDBService<User> {

    public UserService(UserRepository repository) {
        super(repository);
    }
    
}
