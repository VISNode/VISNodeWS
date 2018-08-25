package visnode.ws.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * UserGroup
 */
@Entity
public class UserGroup implements Serializable {

    /** Id */
    @Id
    @GeneratedValue
    @Column
    private long id;
    /** Name */
    @Column(unique = true)
    private String name;
    /** Users */
    @OneToMany(mappedBy = "group")
    private List<GroupUser> users;
    
    
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
    
    /**
     * Returns the users
     * 
     * @return {@code List<GroupUser>}
     */
    public List<GroupUser> getUsers() {
        return users;
    }

    public void setUsers(List<GroupUser> users) {
        this.users = users;
    }

}
