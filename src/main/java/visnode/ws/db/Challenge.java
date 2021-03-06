package visnode.ws.db;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

/**
 * Challenge
 */
@Entity
public class Challenge implements Serializable {

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
    /** Payment */
    @Lob
    @Column
    private String payment;
    /** Puzzle */
    @Column
    private String puzzle;     
    /** Challenges */
    @OneToMany(mappedBy = "challenge")
    private List<Mission> missions;

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
     * Returns the payment
     * 
     * @return String
     */
    public String getPayment() {
        return payment;
    }

    /**
     * Sets the payment
     * 
     * @param payment 
     */
    public void setPayment(String payment) {
        this.payment = payment;
    }

    /**
     * Returns the puzzle
     * 
     * @return String
     */
    public String getPuzzle() {
        return puzzle;
    }

    /**
     * Sets the puzzle
     * 
     * @param puzzle 
     */
    public void setPuzzle(String puzzle) {
        this.puzzle = puzzle;
    }
    
    /**
     * Returns the missions
     * 
     * @return {@code List<Missions>}
     */
    public List<Mission> getMissions() {
        return missions;
    }

    /**
     * Sets the missions
     * 
     * @param missions
     */
    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
    
}
