package visnode.ws.db;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Firestore connection factory
 */
@Service
@Scope("application")
public class FirestoreConnectionFactory {

    /** Connection instance */
    private FirestoreConnection db;

    /**
     * Creates a new firestore connection
     *
     * @return FirestoreConnection
     */
    @Bean
    public FirestoreConnection create() {
        if (db != null) {   
            return db;
        }
        try {
            GoogleCredentials credentials = GoogleCredentials.fromStream(getKey());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(credentials)
                    .build();
            FirebaseApp.initializeApp(options);
            db = new FirestoreConnection(FirestoreClient.getFirestore());
            return db;
        } catch (Exception ex) {
            throw new RuntimeException("Database error", ex);
        }
    }

    private InputStream getKey() throws FileNotFoundException {
        String key = System.getenv("ENV_KEY");
        if (key != null) {
            return new ByteArrayInputStream(key.getBytes());
        }
        return new FileInputStream(System.getProperty("user.home") + "/VISNode-e99efb8531ce.json");
    }
    
}
