package visnode.ws.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Mission
 */
@Entity
public class Mission implements Serializable {

    /** Id */
    @Id
    private Long id;
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
