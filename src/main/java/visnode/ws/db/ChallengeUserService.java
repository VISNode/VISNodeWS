package visnode.ws.db;

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
    public ChallengeUser save(String json) {
        ChallengeUser challengeUser = super.save(json);
        User user = userRepository.findByName(challengeUser.getUser());
        user.setXp(user.getXp() + challengeUser.getXp());
        userRepository.save(user);
        return challengeUser;
    }

}
