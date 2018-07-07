package visnode.ws.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * User
 */
@Entity
public class User implements Serializable {

    private transient static final int ROLE_EDITOR = 1;
    private transient static final int ROLE_VISITOR = 2;

    /** Id */
    @Id
    @Column
    private long id;
    /** Name */
    @Column(unique = true)
    @NotNull
    @Size(min=5, max = 50)
    private String name;
    /** Password */
    @Column
    @NotNull
    @Size(min=5, max = 32)
    private String password;
    /** Points */
    @Column
    private int xp;
    /** Institution */
    @Column
    private String institution;
    /** Image */
    @Column(nullable = true)
    private String image;
    /** Role */
    @Column
    private int role;

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

    /**
     * Returns the password
     *
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
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
     * Returns the institution
     *
     * @return String
     */
    public String getInstitution() {
        return institution;
    }

    /**
     * Sets the institution
     *
     * @param institution
     */
    public void setInstitution(String institution) {
        this.institution = institution;
    }

    /**
     * Returns the image
     *
     * @return String
     */
    public String getImage() {
        return image;
    }

    /**
     * Sets the user image
     *
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Returns the role
     *
     * @return int
     */
    public int getRole() {
        return role;
    }

    /**
     * Sets the role
     *
     * @param role
     */
    public void setRole(int role) {
        this.role = role;
    }

    /**
     * Sets the user visitor
     */
    public void setUserVisitor() {
        this.role = ROLE_VISITOR;
    }

}
