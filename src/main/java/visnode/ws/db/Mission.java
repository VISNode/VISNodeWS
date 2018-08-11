package visnode.ws.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Mission
 */
@Entity
public class Mission implements Serializable {

    /** Id */
    @Id
    @GeneratedValue
    private long id;
    /** Mission */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_Challenge")
    private Challenge challenge;
    /** Name */
    @Column
    private String name;
    /** Description */
    @Column
    private String description;
    /** Difficulty */
    @Column
    private int difficulty;
    /** Input */
    @OneToMany(mappedBy = "mission")
    private List<MissionValueInput> input;
    /** Output */
    @OneToMany(mappedBy = "mission")
    private List<MissionValueOutput> output;
    /** Problem */
    @Column
    private String problem;
    /** Point */
    @Column
    private int xp;
    /** Level */
    @Column
    private int level;

    /**
     * Returns the id
     *
     * @return Long
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
     * Returns the challenge
     *
     * @return Challenge
     */
    public Challenge getChallenge() {
        return challenge;
    }

    /**
     * Sets the challenge
     *
     * @param challenge
     */
    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
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
     * Returns the difficulty
     *
     * @return int
     */
    public int getDifficulty() {
        return difficulty;
    }

    /**
     * Sets the difficulty
     *
     * @param difficulty
     */
    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
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
     * Returns the inputs
     *
     * @return {@code List<MissionValueInput>}
     */
    public List<MissionValueInput> getInput() {
        return input;
    }

    /**
     * Sets the inputs
     *
     * @param input
     */
    public void setInput(List<MissionValueInput> input) {
        this.input = input;
    }

    /**
     * Returns the outputs
     *
     * @return {@code List<MissionValueOutput>}
     */
    public List<MissionValueOutput> getOutput() {
        return output;
    }

    /**
     * Sets the output
     *
     * @param output
     */
    public void setOutput(List<MissionValueOutput> output) {
        this.output = output;
    }

}
