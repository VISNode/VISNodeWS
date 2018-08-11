package visnode.ws.db;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * The challenge user service
 */
@Service
public class ChallengeUserService extends AbsDBService<ChallengeUser> {

    public ChallengeUserService(ChallengeUserRepository repository) {
        super(repository);
    }

    @Override
    public List<ChallengeUser> findAll() {
        return super.findAll().stream().map((user) -> {
            user.getUser().setPassword(UserService.MASK);
            return user;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ChallengeUser> findAll(String query) {
        return super.findAll(query).stream().map((user) -> {
            user.getUser().setPassword(UserService.MASK);
            return user;
        }).collect(Collectors.toList());
    }

}
