package models;

import javax.persistence.*;
import administration.daos.AbstractDatabaseEntity;

@Entity (name = "completed_challenges")
public class CompletedChallenge extends AbstractDatabaseEntity {


    @Id
    @GeneratedValue
    private int id;

    @Column
    private int userId;

    @Column
    private int challnegeId;

    public CompletedChallenge() {


    }
}
