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

    /** Mission input value */
    private final MissionValueInputRepository inputRepository;
    /** Mission output value */
    private final MissionValueOutputRepository outputRepository;

    public MissionService(MissionRepository repository,
            MissionValueInputRepository inputRepository,
            MissionValueOutputRepository outputRepository) {
        super(repository);
        this.inputRepository = inputRepository;
        this.outputRepository = outputRepository;
    }

    @Override
    public Mission save(Mission obj) {
        Mission challenge = super.save(obj);
        saveFields(challenge);
        return challenge;
    }

    @Override
    public Mission update(Mission obj) {
        Mission challenge = super.update(obj);
        deleteFields(obj);
        saveFields(obj);
        return challenge;
    }

    @Override
    public void delete(Mission obj) {
        deleteFields(obj);
        super.delete(obj);
    }

    /**
     * Delete table field
     *
     * @param challenge
     */
    private void deleteFields(Mission challenge) {
        inputRepository.findAll(new Specification<MissionValueInput>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.equal(root.get("mission"), challenge);
            }
        }).forEach((it) -> {
                inputRepository.delete(it);
        });
        outputRepository.findAll(new Specification<MissionValueOutput>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.equal(root.get("mission"), challenge);
            }
        }).forEach((it) -> {
                outputRepository.delete(it);
        });
    }

    /**
     * Save table fields
     *
     * @param mission
     */
    private void saveFields(Mission mission) {
        mission.getInput().forEach((it) -> {
            it.setId(0);
            it.setMission(mission);
            inputRepository.save(it);
        });
        mission.getOutput().forEach((it) -> {
            it.setId(0);
            it.setMission(mission);
            outputRepository.save(it);
        });
    }

}
