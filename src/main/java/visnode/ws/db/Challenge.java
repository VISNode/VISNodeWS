package visnode.ws.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Challenge
 */
@Entity
public class Challenge implements Serializable {

    /** Id */
    @Id
    private Long id;
    /** Id mission */
    private long idMission;
    /** Level */
    @Column
    private int level;

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
     * Returns the mission id
     *
     * @return long
     */
    public long getIdMission() {
        return idMission;
    }

    /**
     * Sets the mission id
     *
     * @param idMission
     */
    public void setIdMission(long idMission) {
        this.idMission = idMission;
    }

    /**
     * Returns the level
     *
     * @return int
     */
    public int getLevel() {
        return level;
    }

    /**
     * Sets the level
     *
     * @param level
     */
    public void setLevel(int level) {
        this.level = level;
    }

}
