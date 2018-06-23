package visnode.ws.db;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * User
 */
@Entity
public class User implements Serializable {

    /** Id */
    @Id
    @Column
    private long id;
    /** Name */
    @Column(unique = true)
    @NotNull
    @NotEmpty
    private String name;
    /** Password */
    @Column
    @NotNull
    @NotEmpty
    private String password;
    /** Points */
    @Column
    private int xp;
    /** Institution */
    @Column
    private String institution;
    /** Image */
    @Column
    private String image;

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

}
