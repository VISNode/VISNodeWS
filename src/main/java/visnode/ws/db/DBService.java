package visnode.ws.db;

import java.util.List;
import java.util.Optional;

/**
 * Service responsible for the entity manipulation
 *
 * @param <O> Entity
 */
public interface DBService<O> {

    /**
     * Find all
     *
     * @return {@code List<O>}
     */
    public List<O> findAll();

    /**
     * Find all
     *
     * @param query
     * @return {@code List<O>}
     */
    public List<O> findAll(String query);

    /**
     * Find by id
     *
     * @param id
     * @return {@code Optional<O>}
     */
    public Optional<O> findById(long id);

    /**
     * Save
     *
     * @param obj Object
     * @return O
     */
    public O save(O obj);

    /**
     * Save
     *
     * @param json Data String
     * @return O
     */
    public O save(String json);

    /**
     * Save
     *
     * @param obj Object
     * @return O
     */
    public O update(O obj);
    
    /**
     * Update
     *
     * @param json Data String
     * @return O
     */
    public O update(String json);
}
