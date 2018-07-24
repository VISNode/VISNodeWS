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
 * Challenge
 */
@Entity
public class Challenge implements Serializable {

    /** Id */
    @Id
    @GeneratedValue
    private long id;
    /** Mission */
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_Mission")
    private Mission mission;
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
    @OneToMany(mappedBy = "challenge")
    private List<ChallengeValueInput> input;
    /** Output */
    @OneToMany(mappedBy = "challenge")
    private List<ChallengeValueOutput> output;
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
     * Returns the mission
     *
     * @return Mission
     */
    public Mission getMission() {
        return mission;
    }

    /**
     * Sets the mission
     *
     * @param mission
     */
    public void setMission(Mission mission) {
        this.mission = mission;
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
     * @return {@code List<ChallengeValueInput>}
     */
    public List<ChallengeValueInput> getInput() {
        return input;
    }

    /**
     * Sets the inputs
     *
     * @param input
     */
    public void setInput(List<ChallengeValueInput> input) {
        this.input = input;
    }

    /**
     * Returns the outputs
     *
     * @return {@code List<ChallengeValueOutput>}
     */
    public List<ChallengeValueOutput> getOutput() {
        return output;
    }

    /**
     * Sets the output
     *
     * @param output
     */
    public void setOutput(List<ChallengeValueOutput> output) {
        this.output = output;
    }

}
