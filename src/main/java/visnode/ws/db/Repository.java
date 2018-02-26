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

}
