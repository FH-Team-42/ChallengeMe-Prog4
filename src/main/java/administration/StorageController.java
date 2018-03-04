package administration;

import administration.daos.DataController;
import administration.daos.IGenericDao;
import models.Challenge;
import models.CompletedChallenge;
import models.User;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by Max.
 *
 * The StorageController class is creating all the Daos, retrieving them from the DataController.
 * The StorageController is the contact point for all database-related actions from the rest of the program.
 * Whenever something needs to be inserted, deleted or updated in the database
 * the methods of this class are called.
 */
public class StorageController {

    IGenericDao<Challenge> challengeDao;
    IGenericDao<User> userDao;
    IGenericDao<CompletedChallenge> completedDao;

    public StorageController() {
        challengeDao = DataController.getInstance().getChallengeDao();
        userDao = DataController.getInstance().getUserDao();
        completedDao = DataController.getInstance().getCompletedDao();
    }

    /**
     * Create all challenges in a given collection
     *
     * @param challenges The collection of challenges to create
     */
    public void createAllChallenges(Collection<Challenge> challenges) {
        challengeDao.createAll(challenges);
    }

    /**
     * Get all challenges
     *
     * @return An array list containing all challenges
     */
    public ArrayList<Challenge> getAllChallenges() {
        return new ArrayList<>( challengeDao.findAll());
    }

    /**
     * Create all users in a given collection
     *
     * @param users The user collection to create
     */
    public void createAllUsers(Collection<User> users) {
        userDao.createAll(users);
    }

    /**
     * Get a user by his unique User-ID
     *
     * @param id The User-ID to search for
     * @return The user
     */
    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    /**
     * Get all users
     *
     * @return An array list containing all users
     */
    public ArrayList<User> getAllUsers() {
        return new ArrayList<>( userDao.findAll());
    }

    /**
     * Get a challenge by a given ID
     *
     * @param id The Challenge-ID to look for
     * @return The challenge
     */
    public Challenge getChallengeById(long id) {

        return challengeDao.findById(id);
    }

    /**
     * Update a given challenge
     *
     * @param challenge The challenge to update
     */
    public void updateChallenge(Challenge challenge) {
        challengeDao.update(challenge);
    }

    /**
     * Create a new challenge
     *
     * @param challenge The challenge to create
     */
    public void createChallenge (Challenge challenge) {
        challengeDao.create(challenge);
    }

    /**
     * Get all challenges active for a given User-ID
     *
     * @param idChallenged The User-ID to find active challenges for
     * @return An array list containing the active challenges
     */
    public ArrayList<Challenge> getActiveChallengesByUserId(long idChallenged) {
        ArrayList<Challenge> allChallenges = new ArrayList<>(challengeDao.findAll());
        ArrayList<Challenge> activeChallenges = new ArrayList<>();
        for (Challenge c : allChallenges) {
            if (c.getIdChallenged() == idChallenged) {
                activeChallenges.add(c);
            }
        }
        return activeChallenges;
    }

    /**
     * Delete a given challenge
     *
     * @param challenge The challenge to delete
     */
    public void deleteChallenge(Challenge challenge) {
        challengeDao.delete(challenge);
    }

    /**
     * Delete a challenge per ID
     *
     * @param id The ID of the challenge that will be deleted
     */
    public void deleteChallengeById(long id) {
        challengeDao.delete(id);
    }

    /**
     * Create a completed challenge
     *
     * @param completed The completed challenge to be created
     */
    public void createCompletedChallenge(CompletedChallenge completed) {
        completedDao.create(completed);
    }

    /**
     * Update a given user
     *
     * @param user The user to be updated
     */
    public void updateUser(User user) {
        userDao.update(user);
    }

    /**
     * Create a new user
     *
     * @param user The user that will be created
     */
    public void createUser(User user) {
        userDao.create(user);
    }

    /**
     * Get the amount of challenges a given user has completed
     *
     * @param id The User-ID of the user
     * @return The amount of completed challenges
     */
    public int getCompletedChallengesByUserId(long id) {
        ArrayList<CompletedChallenge> allCompleted = new ArrayList<>(completedDao.findAll());
        int counter = 0;
        for (CompletedChallenge comp : allCompleted) {
            if(comp.getUserId() == id) {
                counter++;
            }
        }
        return counter;

    }

}
