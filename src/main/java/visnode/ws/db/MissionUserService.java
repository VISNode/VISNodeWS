package visnode.ws.db;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * The Mission user service
 */
@Service
public class MissionUserService extends AbsDBService<MissionUser> {

    /** Mission user repository */
    private final MissionUserRepository repository;
    /** User repository */
    private final UserRepository userRepository;
    /** Challenge repository */
    private final MissionRepository missionRepository;
    /** Mission repository */
    private final ChallengeRepository challengeRepository;
    /** Mission user repository */
    private final ChallengeUserRepository challengeUserRepository;

    public MissionUserService(MissionUserRepository repository,
            UserRepository userRepository,
            MissionRepository challengeRepository,
            ChallengeRepository missionRepository,
            ChallengeUserRepository missionUserRepository) {
        super(repository);
        this.repository = repository;
        this.userRepository = userRepository;
        this.missionRepository = challengeRepository;
        this.challengeRepository = missionRepository;
        this.challengeUserRepository = missionUserRepository;
    }

    @Override
    public List<MissionUser> findAll() {
        return super.findAll().stream().map((user) -> {
            user.getUser().setPassword(UserService.MASK);
            return user;
        }).collect(Collectors.toList());
    }

    @Override
    public List<MissionUser> findAll(String query) {
        return super.findAll(query).stream().map((user) -> {
            user.getUser().setPassword(UserService.MASK);
            return user;
        }).collect(Collectors.toList());
    }

    @Override
    public MissionUser save(String json) {
        MissionUser missionUser = super.save(json);
        if (missionUser.getStatus() == MissionUser.STATUS_SUCESS) {
            User user = userRepository.findByName(missionUser.getUser().getName());
            user.setXp(user.getXp() + missionUser.getXp());
            userRepository.save(user);
            updateChallenge(missionUser, user);
        }
        return missionUser;
    }

    /**
     * Updates the challenge mission
     *
     * @param missionUser
     * @param user
     */
    private void updateChallenge(MissionUser missionUser, User user) {
        Mission mission = missionRepository.findOne(missionUser.getIdChallenge());
        Challenge challenge = challengeRepository.findOne(mission.getChallenge().getId());
        //Ifs not the final level
        if (challenge.getLevel() != mission.getLevel()) {
            return;
        }
        ChallengeUser challengeUser = new ChallengeUser();
        challengeUser.setUser(user);
        challengeUser.setIdChallenge(challenge.getId());
        challengeUser.setStatus(ChallengeUser.STATUS_SUCESS);
        challengeUser.setSubmission(missionUser.getSubmission());
        challengeUser.setDateFinal(missionUser.getDateFinal());
        challengeUser.setXp(getXp(user, challenge));
        challengeUserRepository.save(challengeUser);
    }

    /**
     * Returns the challenge xp
     *
     * @param user
     * @param chllenge
     * @return int
     */
    private int getXp(User user, Challenge chllenge) {
        Optional<Integer> xp = repository.findAll(new Specification<MissionUser>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.and(
                        cb.equal(root.get("idChallenge"), chllenge.getId()),
                        cb.equal(root.get("user"), user),
                        cb.equal(root.get("status"), 1)
                );
            }
        }).stream().map((it) -> it.getXp()).reduce((a, b) -> a + b);
        if (xp.isPresent()) {
            return xp.get();
        }
        return 0;
    }

}
