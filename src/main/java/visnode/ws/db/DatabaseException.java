package visnode.ws.db;

/**
 * Database exception
 */
public class DatabaseException extends RuntimeException {

    public DatabaseException(Exception e) {
        super(e);
    }
    
    public DatabaseException(String message) {
        super(message);
    }
    
}
