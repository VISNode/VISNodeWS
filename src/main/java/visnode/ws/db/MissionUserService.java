package visnode.ws.db;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 * The mission user service
 */
@Service
public class MissionUserService extends AbsDBService<MissionUser> {

    public MissionUserService(MissionUserRepository repository) {
        super(repository);
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

}
