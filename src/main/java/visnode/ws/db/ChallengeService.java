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

    /** Challenge input value */
    private final ChallengeValueInputRepository inputRepository;
    /** Challenge output value */
    private final ChallengeValueOutputRepository outputRepository;

    public ChallengeService(ChallengeRepository repository,
            ChallengeValueInputRepository inputRepository,
            ChallengeValueOutputRepository outputRepository) {
        super(repository);
        this.inputRepository = inputRepository;
        this.outputRepository = outputRepository;
    }

    @Override
    public Challenge save(Challenge obj) {
        Challenge challenge = super.save(obj);
        saveFields(challenge);
        return challenge;
    }

    @Override
    public Challenge update(Challenge obj) {
        Challenge challenge = super.update(obj);
        deleteFields(challenge);
        saveFields(challenge);
        return challenge;
    }

    @Override
    public void delete(Challenge obj) {
        deleteFields(obj);
        super.delete(obj);
    }

    /**
     * Delete table field
     *
     * @param challenge
     */
    private void deleteFields(Challenge challenge) {
        inputRepository.findAll(new Specification<ChallengeValueInput>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.equal(root.get("challenge"), challenge);
            }
        }).forEach((it) -> {
            inputRepository.delete(it);
        });
        outputRepository.findAll(new Specification<ChallengeValueOutput>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.equal(root.get("challenge"), challenge);
            }
        }).forEach((it) -> {
            outputRepository.delete(it);
        });
    }

    /**
     * Save table fields
     *
     * @param challenge
     */
    private void saveFields(Challenge challenge) {
        challenge.getInput().forEach((it) -> {
            it.setId(0);
            it.setChallenge(challenge);
            System.out.println(it.getValue().length());
            inputRepository.save(it);
        });
        challenge.getOutput().forEach((it) -> {
            it.setId(0);
            it.setChallenge(challenge);
            System.out.println(it.getValue().length());
            outputRepository.save(it);
        });
    }

}
