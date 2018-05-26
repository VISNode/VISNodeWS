package visnode.ws.db;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * User repository
 */
public interface UserRepository extends Repository<User, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM user WHERE name = :name LIMIT 1")
    public User findByName(@Param("name") String name);

}
