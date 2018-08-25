package visnode.ws.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The group repository
 */
public interface GroupRepository extends Repository<UserGroup, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM user_group WHERE name = :name LIMIT 1")
    public UserGroup findByName(@Param("name") String name);
    
}
