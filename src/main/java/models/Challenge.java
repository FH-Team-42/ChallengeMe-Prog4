package models;

import javax.persistence.*;

import administration.daos.AbstractChallengeEntity;
import jdk.jfr.Timestamp;

import java.util.Date;


@Entity
public class Challenge extends AbstractChallengeEntity {


    @Column
    private String title;       //title of the challenge

    @Column
    private String description; //description of the challenge

    @Column
    private int completionTime; //time to complete challenge

    @Column
    private Long idCreator;      //ID of challenge creator in database

    @Column
    private Long idChallenged;   //ID of the user which is assigned this challenge

    @Column
    private int vote;           //votes of the challenge, delete challenges with too much negative votes

    @Column
    private boolean isCompleted;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startedAt;


    //connectDataBase database = new connectDataBase(); //connection to the database


    public Challenge() {

    }
    /**
     * Creates a new challenge and inserts it into the database if it is not part of it yet.
     *
     * @param title          The title of the challenge
     * @param description    The challenge description
     * @param completionTime The time to complete the challenge in seconds
     * @param idCreator      User-ID of user creating the challenge
     */
    public Challenge(String title, String description, int completionTime, long idCreator) {
        this.title = title;
        this.description = description;
        this.completionTime = completionTime;
        this.idCreator = idCreator;
        idChallenged = 0L;
        vote = 0;
        isCompleted = false;
    }

    public void complete() {
        isCompleted = true;
        idChallenged = 0L;
    }

    /**
     * Get the title of the challenge
     *
     * @return The title of the challenge
     */
    public String getTitle() {
    	return title;
    }

    /**
     * Get the description of the challenge
     *
     * @return The description of the challenge
     */
    public String getDescription() {
    	return description;
    }

    /**
     * Get the challenge creator's ID
     *
     * @return The challenge creator's ID
     */
    public Long getIdCreator() {
    	return idCreator;

    }

    /**
     * Get the challenged person's user ID
     *
     * @return The challenged person's user ID
     */
    public Long getIdChallenged() {
    	return idChallenged;

    }

    /**
     * Get the current voting of the challenge
     *
     * @return The current voting of the challenge
     */
    public int getVote() {
        return vote;

    }

    /**
     * Get remaining completion time
     *
     * @return The remaining completion time
     */
    public int getCompletionTime() {
        return completionTime;
    }


    /**
     * Get the start time of the challenge
     *
     * @return Start time in Date-Format
     */
    public Date getStarted() {
        return startedAt;
    }

    /**
     * Returns if the challenge is already completed.
     *
     * @return Value of isCompleted
     */
    public boolean isCompleted() {
        return isCompleted;
    }

    /**
     * Set the title of the challenge
     *
     * @param setTitle The new title
     */
    public void setTitle(String setTitle) {
        title = setTitle;

    }

    /**
     * Set the description of the title
     *
     * @param setDescription The new description
     */
    public void setDescription(String setDescription) {
        description = setDescription;

    }

    /**
     * Set the completion time
     *
     * @param setCompletionTime The new completion time in seconds
     */
    public void setCompletionTime(int setCompletionTime) {
        completionTime = setCompletionTime;

    }

    /**
     * Set the challenged user's ID
     *
     * @param setIdChallenged The challenged user's ID
     */
    public void setIdChallenged(Long setIdChallenged) {
        idChallenged = setIdChallenged;

    }

    /**
     * Set the challenges start date
     *
     * @param setStartedAt The Date the challenge was started
     */
    public void setStarted(Date setStartedAt) {
        startedAt = setStartedAt;
    }


    /**
     * Vote the challenge
     * First catches the old vote from the database and then writes the new value into it
     *
     * @param value The value to add (1 for positive, -1 for negative vote)
     */
    public void userVote(int value) {
    	vote += value;
    }

}
