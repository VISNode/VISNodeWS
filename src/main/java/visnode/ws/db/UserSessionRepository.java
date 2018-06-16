package visnode.ws.db;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The user session repository
 */
public interface UserSessionRepository extends Repository<UserSession, Long> {

    @Query(nativeQuery = true, value = "select * from user_session where token = :token limit 1")
    public UserSession findByToken(@Param("token") String token);
    
    @Modifying
    @Transactional
    @Query("delete from user_session where token = :token")
    public void deleteByToken(@Param("token") String token);
}
