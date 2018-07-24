package visnode.ws.db;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * The mission service
 */
@Service
public class MissionService extends AbsDBService<Mission> {

    /** Challenge service */
    private final ChallengeService challengeService;
    /** Challenge repository */
    private final ChallengeRepository challengeRepository;
    
    public MissionService(MissionRepository repository,
            ChallengeService challengeService,
            ChallengeRepository challengeRepository) {
        super(repository);
        this.challengeService = challengeService;
        this.challengeRepository = challengeRepository;
    }

    @Override
    public Mission save(Mission obj) {
        Mission mission = super.save(obj);
        saveFields(obj);
        return mission;
    }

    @Override
    public Mission update(Mission obj) {
        Mission mission = super.update(obj);
        deleteFields(obj);
        saveFields(obj);
        return mission;
    }

    /**
     * Delete the tables fields
     *
     * @param challenge
     */
    private void deleteFields(Mission mission) {
        challengeRepository.findAll(new Specification<Challenge>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.equal(root.get("mission"), mission);
            }
        }).forEach((it) -> {
            challengeService.delete(it);
        });
    }

    /**
     * Save the tables fields
     * 
     * @param mission 
     */
    private void saveFields(Mission mission) {
        mission.getChallenge().forEach((it) -> {
            it.setMission(mission);
            challengeService.save(it);
        });

    }

}
