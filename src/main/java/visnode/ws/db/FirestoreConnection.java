package visnode.ws.db;

import com.google.cloud.firestore.Firestore;

/**
 * The Firestore connection
 */
public class FirestoreConnection {

    /** Connection instance */
    private final Firestore conn;

    /**
     * Creates a new connection
     *
     * @param conn
     */
    public FirestoreConnection(Firestore conn) {
        this.conn = conn;
    }

    /**
     * Returns the connection
     *
     * @return Firestore
     */
    public Firestore get() {
        return conn;
    }
}
