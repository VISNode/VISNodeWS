package visnode.ws.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Mission
 */
@Entity
public class Mission implements Serializable {

    /** Id */
    @Id
    @GeneratedValue
    @Column
    private long id;
    /** name */
    @Column
    private String name;
    /** Description */
    @Column
    private String description;
    /** Problem */
    @Column
    private String problem;
    /** Point */
    @Column
    private int xp;
    /** Level */
    @Column
    private int level;
    /** Challenges */
    @OneToMany(mappedBy = "mission")
    private List<Challenge> challenges;

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
     * Returns the description
     *
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the problem
     *
     * @return String
     */
    public String getProblem() {
        return problem;
    }

    /**
     * Sets the problem
     *
     * @param problem
     */
    public void setProblem(String problem) {
        this.problem = problem;
    }

    /**
     * Returns the xp
     *
     * @return int
     */
    public int getXp() {
        return xp;
    }

    /**
     * Sets the xp
     *
     * @param xp
     */
    public void setXp(int xp) {
        this.xp = xp;
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
    
    /**
     * Returns the challenge
     * 
     * @return {@code List<Challenge>}
     */
    public List<Challenge> getChallenges() {
        return challenges;
    }

    /**
     * Sets the challenges
     * 
     * @param challenges 
     */
    public void setChallenges(List<Challenge> challenges) {
        this.challenges = challenges;
    }
    
}
