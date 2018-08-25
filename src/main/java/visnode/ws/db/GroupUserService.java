package visnode.ws.db;

import org.springframework.stereotype.Service;

/**
 * Group user service
 */
@Service
public class GroupUserService extends AbsDBService<GroupUser> {

    public GroupUserService(GroupUserRepository repository) {
        super(repository);
    }

}
