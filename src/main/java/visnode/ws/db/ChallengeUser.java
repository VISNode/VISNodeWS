package visnode.ws.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;

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
    /** Date initial */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateInitial;
    /** Date final */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dateFinal;

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

    /**
     * Returns the initial date
     *
     * @return Date
     */
    public Date getDateInitial() {
        return dateInitial;
    }

    /**
     * Sets the initial date
     *
     * @param dateInitial
     */
    public void setDateInitial(Date dateInitial) {
        this.dateInitial = dateInitial;
    }

    /**
     * Returns the final date
     *
     * @return Date
     */
    public Date getDateFinal() {
        return dateFinal;
    }

    /**
     * Sets the final date
     *
     * @param dateFinal
     */
    public void setDateFinal(Date dateFinal) {
        this.dateFinal = dateFinal;
    }

}
