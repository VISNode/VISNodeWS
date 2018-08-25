package visnode.ws.db;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * The group service
 */
@Service
public class GroupService extends AbsDBService<UserGroup> {

    /** Group repository */
    private final GroupRepository repository;
    /** GroupUser service */
    private final GroupUserService userService;
    /** GroupUser repository */
    private final GroupUserRepository userRepository;

    public GroupService(GroupRepository repository,
            GroupUserService userService,
            GroupUserRepository userRepository) {
        super(repository);
        this.repository = repository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public UserGroup save(UserGroup obj) {
        validate(obj);
        UserGroup group = super.save(obj);
        saveFields(obj);
        return group;
    }

    @Override
    public UserGroup update(UserGroup obj) {
        validate(obj);
        UserGroup group = super.update(obj);
        deleteFields(obj);
        saveFields(obj);
        return group;
    }
    
    /**
     * Validate the user
     * 
     * @param group 
     */
    private void validate(UserGroup group) {
        UserGroup user = repository.findByName(group.getName());
        if (user != null && user.getId() != group.getId()) {
            throw new DatabaseException("Group is already in the database");
        }
    }

    /**
     * Delete the tables fields
     *
     * @param group
     */
    private void deleteFields(UserGroup group) {
        userRepository.findAll(new Specification<GroupUser>() {
            @Override
            public Predicate toPredicate(Root root, CriteriaQuery cq, CriteriaBuilder cb) {
                return cb.equal(root.get("group"), group);
            }
        }).forEach((it) -> {
            if (group.getUsers().
                    stream().
                    anyMatch((m) -> m.getId() != it.getId())) {
                userService.delete(it);
            }
        });
    }

    /**
     * Save the tables fields
     *
     * @param group
     */
    private void saveFields(UserGroup group) {
        group.getUsers().forEach((it) -> {
            it.setGroup(group);
            if (it.getId() == 0) {
                userService.update(it);
            } else {
                userService.save(it);
            }
        });

    }

}
