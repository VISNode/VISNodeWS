package visnode.ws.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import visnode.ws.db.User;
import visnode.ws.db.UserRepository;

/**
 * Authentication service
 */
@Service
public class AuthenticationService {

    /** The user repository */
    private final UserRepository repository;

    @Autowired
    public AuthenticationService(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Returns true if the login is valid
     *
     * @param user
     * @param password
     * @return boolean
     */
    public boolean isValid(String user, String password) {
        if (user == null || user.isEmpty()) {
            return false;
        }
        if (password == null || password.isEmpty()) {
            return false;
        }
        User model = repository.findByName(user);
        if (model == null) {
            return false;
        }
        String md5 = DigestUtils.md5DigestAsHex(password.getBytes());
        return model.getPassword().equals(md5);
    }

}
