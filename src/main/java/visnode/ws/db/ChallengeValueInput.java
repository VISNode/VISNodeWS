package visnode.ws.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Challenge value
 */
@Entity
public class ChallengeValueInput implements Serializable {

    /** Id */
    @Id
    @GeneratedValue
    private long id;
    /** Type */
    @Column
    private String type;
    /** Value */
    @Column
    private String value;
    /** Challenge */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_Challenge")
    private Challenge challenge;

    /**
     * Returns the id
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the if
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Returns the challenge type
     *
     * @return ChallengeType
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the challenge type
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the value
     *
     * @return String
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the challenge value
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Returns the challenge
     *
     * @return Challenge
     */
    public Challenge getChallenge() {
        return challenge;
    }

    /**
     * Sets the challenge
     *
     * @param challenge
     */
    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }
}
