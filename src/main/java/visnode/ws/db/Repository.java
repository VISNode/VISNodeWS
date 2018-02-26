package visnode.ws.db;

import java.util.List;

/**
 * Data base repository
 */
public interface Repository {

    /**
     * Returns the entity result
     * 
     * @param entity
     * @return List
     * @throws DatabaseException
     */
    public List get(String entity) throws DatabaseException;

    /**
     * Returns the entity result
     * 
     * @param entity
     * @param id
     * @return List
     * @throws DatabaseException
     */
    public Object get(String entity, long id) throws DatabaseException;

}
