package visnode.ws.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * Mission value
 */
@Entity
public class MissionValueInput implements Serializable {

    /** Id */
    @Id
    @GeneratedValue
    private long id;
    /** Type */
    @Column
    private String type;
    /** Value */
    @Lob
    @Column
    private String value;
    /** Mission */
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id_Mission")
    private Mission mission;

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
     * Returns the mission type
     *
     * @return ChallengeType
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the mission type
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
     * Sets the mission value
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Returns the mission
     *
     * @return Mission
     */
    public Mission getMission() {
        return mission;
    }

    /**
     * Sets the mission
     *
     * @param mission
     */
    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
