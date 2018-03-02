package models;

import javax.persistence.*;

import administration.daos.AbstractChallengeEntity;

@Entity (name = "completed_challenges")
public class CompletedChallenge extends AbstractChallengeEntity {


    @Column
    private int userId;

    @Column
    private int challnegeId;

    public CompletedChallenge() {


    }
}
