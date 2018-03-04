package models;

import javax.persistence.*;

import administration.daos.AbstractChallengeEntity;

import java.util.Date;

@Entity (name = "completed_challenges")
public class CompletedChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long completedId;

    @Column
    private long userId;

    @Column
    private long challnegeId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date completedAt;

    public CompletedChallenge() {

    }

    public CompletedChallenge(long userId, long challnegeId) {
        this.userId = userId;
        this.challnegeId = challnegeId;
        completedAt = new Date();
    }

    public long getCompletedId() {
        return completedId;
    }

    public void setCompletedId(long id) {
        completedId = id;
    }
}
