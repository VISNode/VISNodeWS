package visnode.ws.db;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 * Mission User
 */
@Entity
public class MissionUser implements Serializable {

    public static transient final int STATUS_SUCESS = 1;

    /** Id */
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    /** User */
    private User user;
    /** Mission */
    private long idMission;
    /** Submission */
    @Column(length = 60000)
    private String submission;
    /** Points */
    private int xp;
    /** Date final */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
    private Date dateFinal;
    /** Status */
    private int status;

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
     * @return User
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Returns the mission identifier
     *
     * @return long
     */
    public long getIdMission() {
        return idMission;
    }

    /**
     * Sets the mission identifier
     *
     * @param idMission
     */
    public void setIdMission(long idMission) {
        this.idMission = idMission;
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

    /**
     * Returns the status
     *
     * @return int
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets the status
     *
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

}
