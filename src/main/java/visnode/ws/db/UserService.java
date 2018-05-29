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

    public UserService(UserRepository repository) {
        super(repository);
    }

    @Override
    public List<User> findAll() {
        return super.findAll().stream().map((user) -> {
            user.setPassword("***");
            return user;
        }).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findById(long id) {
        Optional<User> obj = super.findById(id);
        if (obj.isPresent()) {
            User user = obj.get();
            user.setPassword("***");
            return Optional.of(user);
        }
        return obj;
    }

    @Override
    public User save(User obj) {
        if (obj.getId() == 0) {
            obj.setPassword(DigestUtils.
                    md5DigestAsHex(obj.getPassword().getBytes())
            );
        }
        return super.save(obj);
    }

}
