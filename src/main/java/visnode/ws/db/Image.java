package visnode.ws.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Image
 */
@Entity
public class Image implements Serializable {

    /** Id */
    @Id
    @Column
    private long id;
    /** Returns the image*/
    @Column(length = 1000000)
    private String data;

    /**
     * Returns the id
     *
     * @return long
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * Returns the image
     * 
     * @return {@code String}
     */
    public String getData() {
        return data;
    }

    /**
     * Sets the image
     * 
     * @param data 
     */
    public void setData(String data) {
        this.data = data;
    }
    
}
