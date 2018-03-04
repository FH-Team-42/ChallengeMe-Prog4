package models;

import administration.daos.AbstractUserEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Felix on 02.01.2017.
 */

/**
 * This class is representing the model for a user. It creates a database entity which is realized in the H2 database.
 * A user has an username, a password, a birthday and a profile picture.
 */
@Entity
public class User extends AbstractUserEntity {

    @Column
    private String username;

    @Column
    private String password;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column
    private String profilePic;          //link to profile pic

    @Column
    private int reputation;

    /**
     * Standard constructor for User
     *
     */
    public User(){

    }


    /**
     * Creates a new user object and writes it into the database if it is not there yet
     *
     * @param name  The username
     * @param pass  The users password hash, encrypted with SHA-256
     * @param day   The users birthday
     */
    public User(String name, String pass, Date day) {
        //database = new connectDataBase();
        username = name;
        password = pass;
        birthday = day;
        profilePic = "http://s3.amazonaws.com/37assets/svn/765-default-avatar.png";
        reputation = 100;
    }


    /**
     * Remove a challenge from a user
     *
     * @return If giving up was successful
     */
    /*public int giveUp() {
        if (challengeCurrent != 0) {
            challengeCurrent = 0;
            return 1;
        } else {
            reputation -= 2;
            return 0;
        }
    }*/

    /**
     * Returns the username
     *
     * @return The username
     */
    public String getName() {
        return username;
    }

    /**
     * Returns the user password
     *
     * @return The users password
     */
    public String getPass() {
        return password;
    }

    /**
     * Returns the users birthday
     *
     * @return The users birthday
     */
    public Date getBirthday() {
        return birthday;
    }


    /**
     * Returns the users reputation
     *
     * @return The users reputation
     */
    /*public int getReputation() {
        return reputation;
    }*/

    /**
     * Sets the users Name
     *
     * @param name The username
     */
    public void setName(String name) {
        username = name;
    }

    /**
     * Sets the users Password
     *
     * @param pass The password
     */
    public void setPassword(String pass) {
        password = pass;
    }

    /**
     * Return the profile picture URL
     *
     * @return profilePicture URL
     */
    public String getProfilePic() {
        return profilePic;
    }

    /**
     * Sets a new profile picture URL
     *
     * @param profilePic new profile picture URL
     */
    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }


    /*public void voteForUser(int vote){
        reputation += vote;
    }*/
}