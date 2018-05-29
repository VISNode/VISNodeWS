package visnode.ws.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Challenge User
 */
@Entity
public class ChallengeUser implements Serializable {

    /** Id */
    @Id
    private long id;
    /** User */
    private String user;
    /** Challenge */
    private int idChallenge;
    /** Submission */
    @Column(length = 60000)
    private String submission;
    /** Points */
    private int xp;
    
    /**
     * Returns the id
     *
     * @return Long
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the user
     *
     * @return String
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the user
     *
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Returns the challenge identification
     *
     * @return int
     */
    public int getIdChallenge() {
        return idChallenge;
    }

    /**
     * Sets the challenge identification
     *
     * @param idChallenge
     */
    public void setIdChallenge(int idChallenge) {
        this.idChallenge = idChallenge;
    }

    /**
     * Returns the user submission
     *
     * @return String
     */
    public String getSubmission() {
        return submission;
    }

    /**
     * Sets the user submission
     *
     * @param submission
     */
    public void setSubmission(String submission) {
        this.submission = submission;
    }
    
    /**
     * Returns the points
     * 
     * @return int
     */
    public int getXp() {
        return xp;
    }

    /**
     * Sets the points
     * 
     * @param xp 
     */
    public void setXp(int xp) {
        this.xp = xp;
    }
    
}
