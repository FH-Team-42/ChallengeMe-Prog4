package models;

import javax.persistence.*;

import java.util.Date;

/**
 * This class is representing the model for a completed challenge. It creates a database
 * entity which is realized in the H2 database. It stores the time of completion, the user
 * id of the user completing the challenge as well as the id of the completed challenge itself.
 *
 */
@Entity (name = "completed_challenges")
public class CompletedChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long completedId;

    @Column
    private long userId;

    @Column
    private long challengeId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date completedAt;

    public CompletedChallenge() {

    }

    /**
     * Is created when a challenge gets marked as completed. Stores the userId, the challengeId and the completion date
     * of the challenge.
     *
     * @param userId
     * @param challengeId
     */
    public CompletedChallenge(long userId, long challengeId) {
        this.userId = userId;
        this.challengeId = challengeId;
        completedAt = new Date();
    }

    /**
     * Returns the id inside the completed table
     *
     * @return the id inside the completed table
     */
    public long getCompletedId() {
        return completedId;
    }

    /**
     * Returns the userId of the user that completed the challenge
     *
     * @return the userId that completed the challenge
     */
    public long getUserId() {
        return userId;
    }


    /**
     * Returns the id of the challenge which was completed
     *
     * @return the id of the challenge
     */
    public long getChallengeId() {
        return challengeId;
    }

    /**
     * Returns the time the challenge was completed
     *
     * @return time of the challenge completion
     */
    public Date getCompletedAt() {
        return completedAt;
    }
}
