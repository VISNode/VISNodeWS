package visnode.ws.db;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

/**
 * The user service
 */
@Service
public class UserService extends AbsDBService<User> {

    /** Password */
    public static final String MASK = "***";
    /** User repository */
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public List<User> findAll() {
        return super.findAll().stream().map((user) -> {
            user.setPassword(MASK);
            return user;
        }).collect(Collectors.toList());
    }

    @Override
    public List<User> findAll(String query) {
        return super.findAll(query).stream().map((user) -> {
            user.setPassword(MASK);
            return user;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(long id) {
        Optional<User> obj = super.findById(id);
        if (obj.isPresent()) {
            User user = obj.get();
            user.setPassword(MASK);
            return Optional.of(user);
        }
        return obj;
    }

    @Override
    public User save(User obj) {
        if (isNewUser(obj) && hasPassword(obj)) {
            User user = repository.findByName(obj.getName());
            if (user != null) {
                throw new DatabaseException("User is already in the database");
            }
            obj.setPassword(DigestUtils.
                    md5DigestAsHex(obj.getPassword().getBytes())
            );
        }
        obj.setUserVisitor();
        return super.save(obj);
    }

    @Override
    public User update(User obj) {
        if (hasPassword(obj)) {
            if (obj.getPassword().equals(MASK)) {
                User user = repository.findByName(obj.getName());
                obj.setPassword(user.getPassword());
            } else {
                obj.setPassword(DigestUtils.
                        md5DigestAsHex(obj.getPassword().getBytes())
                );
            }
        }
        return super.update(obj);
    }

    /**
     * Returns true if it is a new user
     *
     * @param obj
     * @return boolean
     */
    private boolean isNewUser(User obj) {
        return obj.getId() == 0;
    }

    /**
     * Returns true if the user has a password
     *
     * @param obj
     * @return boolean
     */
    private boolean hasPassword(User obj) {
        return obj.getPassword() != null && !obj.getPassword().isEmpty();
    }

}
