package visnode.ws.db;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * The challenge service
 */
@Service
public class ChallengeService extends AbsDBService<Challenge> {

    /** Challenge service */
    private final MissionService missionService;
    /** Challenge repository */
    private final MissionRepository missionRepository;
    
    public ChallengeService(ChallengeRepository repository,
            MissionService challengeService,
            MissionRepository challengeRepository) {
        super(repository);
        this.missionService = challengeService;
        this.missionRepository = challengeRepository;
    }

    @Override
    public Challenge save(Challenge obj) {
        Challenge challenge = super.save(obj);
        saveFields(obj);
        return challenge;
    }

    @Override
    public Challenge update(Challenge obj) {
        Challenge challenge = super.update(obj);
        deleteFields(obj);
        saveFields(obj);
        return challenge;
    }

    /**
     * Delete the tables fields
     *
     * @param challenge
     */
    private void deleteFields(Challenge challenge) {
        missionRepository.findAll(new Specification<Mission>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.equal(root.get("challenge"), challenge);
            }
        }).forEach((it) -> {
            missionService.delete(it);
        });
    }

    /**
     * Save the tables fields
     * 
     * @param challenge 
     */
    private void saveFields(Challenge challenge) {
        challenge.getMissions().forEach((it) -> {
            it.setChallenge(challenge);
            it.setId(0);
            missionService.save(it);
        });

    }

}
