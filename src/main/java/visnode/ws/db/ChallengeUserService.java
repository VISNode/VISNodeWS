package visnode.ws.db;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * The challenge user service
 */
@Service
public class ChallengeUserService extends AbsDBService<ChallengeUser> {

    /** User repository */
    private final UserRepository userRepository;

    public ChallengeUserService(ChallengeUserRepository repository, UserRepository userRepository) {
        super(repository);
        this.userRepository = userRepository;
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

    @Override
    public ChallengeUser save(String json) {
        ChallengeUser challengeUser = super.save(json);
        User user = userRepository.findByName(challengeUser.getUser().getName());
        user.setXp(user.getXp() + challengeUser.getXp());
        userRepository.save(user);
        return challengeUser;
    }

}
