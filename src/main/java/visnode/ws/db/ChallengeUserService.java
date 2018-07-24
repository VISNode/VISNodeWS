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
 * The challenge user service
 */
@Service
public class ChallengeUserService extends AbsDBService<ChallengeUser> {

    /** Challenge user repository */
    private final ChallengeUserRepository repository;
    /** User repository */
    private final UserRepository userRepository;
    /** Challenge repository */
    private final ChallengeRepository challengeRepository;
    /** Mission repository */
    private final MissionRepository missionRepository;
    /** Mission user repository */
    private final MissionUserRepository missionUserRepository;

    public ChallengeUserService(ChallengeUserRepository repository,
            UserRepository userRepository,
            ChallengeRepository challengeRepository,
            MissionRepository missionRepository,
            MissionUserRepository missionUserRepository) {
        super(repository);
        this.repository = repository;
        this.userRepository = userRepository;
        this.challengeRepository = challengeRepository;
        this.missionRepository = missionRepository;
        this.missionUserRepository = missionUserRepository;
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
        if (challengeUser.getStatus() == ChallengeUser.STATUS_SUCESS) {
            User user = userRepository.findByName(challengeUser.getUser().getName());
            user.setXp(user.getXp() + challengeUser.getXp());
            userRepository.save(user);
            updateMission(challengeUser, user);
        }
        return challengeUser;
    }

    /**
     * Updates the challenge mission
     *
     * @param challengeUser
     * @param user
     */
    private void updateMission(ChallengeUser challengeUser, User user) {
        Challenge challenge = challengeRepository.findOne(challengeUser.getIdChallenge());
        Mission mission = missionRepository.findOne(challenge.getMission().getId());
        //Ifs not the final level
        if (mission.getLevel() != challenge.getLevel()) {
            return;
        }
        MissionUser missionUser = new MissionUser();
        missionUser.setUser(user);
        missionUser.setIdMission(mission.getId());
        missionUser.setStatus(MissionUser.STATUS_SUCESS);
        missionUser.setSubmission(challengeUser.getSubmission());
        missionUser.setDateFinal(challengeUser.getDateFinal());
        missionUser.setXp(getXp(user, mission));
        missionUserRepository.save(missionUser);
    }

    /**
     * Returns the mission xp
     *
     * @param user
     * @param mission
     * @return int
     */
    private int getXp(User user, Mission mission) {
        Optional<Integer> xp = repository.findAll(new Specification<ChallengeUser>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.and(
                        cb.equal(root.get("idMission"), mission.getId()),
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
