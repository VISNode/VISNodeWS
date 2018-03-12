package visnode.ws.db;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * User
 */
@Entity
public class User implements Serializable {

    /** Id */
    @Id
    private long id;
    /** Name */
    private String name;

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
     * Returns the name
     *
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

}
