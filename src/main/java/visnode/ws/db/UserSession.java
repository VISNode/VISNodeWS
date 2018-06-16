package visnode.ws.db;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * The user session
 */
@Entity(name = "user_session")
public class UserSession implements Serializable {

    @Id
    @Column
    private long id;
    /** The user name */
    @Column(nullable = false)
    private String name;
    /** Token access */
    @Column(nullable = false)
    private String token;
    /** Creation date */
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dateCreation;
    /** Last access */
    @Temporal(TemporalType.TIMESTAMP)
    @Column
    private Date dateLastAccess;
    
    /**
     * Returns the user name
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the user name
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the token access
     * 
     * @return String
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the token access
     * 
     * @param token 
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Returns the creation date
     * 
     * @return Date
     */
    public Date getDateCreation() {
        return dateCreation;
    }

    /**
     * Sets the creation date
     * 
     * @param dateCreation 
     */
    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    /**
     * Returns the date of the last access
     * 
     * @return Date
     */
    public Date getDateLastAccess() {
        return dateLastAccess;
    }

    /**
     * Sets the data of the last access
     * 
     * @param dateLastAccess 
     */
    public void setDateLastAccess(Date dateLastAccess) {
        this.dateLastAccess = dateLastAccess;
    }

}
