package visnode.ws.db;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Firestore database repository
 */
@Service
public class FirestoreRepository implements Repository {

    /** Database connection */
    private final FirestoreConnection db;

    /**
     * Creates a new firestore repository
     *
     * @param conn
     */
    @Autowired
    public FirestoreRepository(FirestoreConnection conn) {
        this.db = conn;
    }

    /**
     * Returns the entity result
     *
     * @param entity
     * @return List
     * @throws DatabaseException
     */
    @Override
    public List get(String entity) throws DatabaseException {
        try {
            List list = new ArrayList<>();
            ApiFuture<QuerySnapshot> query = db.get().collection(entity).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                list.add(document.getData());
            }
            return list;
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

    /**
     * Returns the entity result
     *
     * @param entity
     * @return List
     * @throws DatabaseException
     */
    @Override
    public Object get(String entity, long id) throws DatabaseException {
        try {
            ApiFuture<QuerySnapshot> query = db.get().collection(entity).whereEqualTo("id", id).get();
            List<QueryDocumentSnapshot> documents = query.get().getDocuments();
            if (documents.isEmpty()) {
                return null;
            }
            return documents.get(0).getData();
        } catch (Exception e) {
            throw new DatabaseException(e);
        }
    }

}
