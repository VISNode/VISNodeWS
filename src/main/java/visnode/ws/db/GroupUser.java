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
 * UserGroup
 */
@Entity
public class GroupUser implements Serializable {

    /** Id */
    @Id
    @GeneratedValue
    @Column
    private long id;
    /** UserGroup */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_Group")
    private UserGroup group;
    @ManyToOne
    @JoinColumn(name = "user", nullable = false)
    /** User */
    private User user;    
    
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
     * Returns the group
     * 
     * @return UserGroup
     */
    public UserGroup getGroup() {
        return group;
    }

    /**
     * Sets the group
     * 
     * @param group 
     */
    public void setGroup(UserGroup group) {
        this.group = group;
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
    
}
