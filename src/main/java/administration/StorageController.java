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
 * Created by Max on 09.07.2017.
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

    public void createAllChallenges(Collection<Challenge> challenges) {
        challengeDao.createAll(challenges);
    }

    public ArrayList<Challenge> getAllChallenges() {
        return new ArrayList<>( challengeDao.findAll());
    }

    public void createAllUsers(Collection<User> users) {
        userDao.createAll(users);
    }

    public User getUserById(Long id) {
        return userDao.findById(id);
    }

    public ArrayList<User> getAllUsers() {
        return new ArrayList<>( userDao.findAll());
    }

    public Challenge getChallengeById(long id) {

        return challengeDao.findById(id);
    }

    public void updateChallenge(Challenge challenge) {
        challengeDao.update(challenge);
    }

    public void createChallenge (Challenge challenge) {
        challengeDao.create(challenge);
    }

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

    public void deleteChallenge(Challenge challenge) {
        challengeDao.delete(challenge);
    }

    public void deleteChallengeById(long id) {
        challengeDao.delete(id);
    }

    public void createCompletedChallenge(CompletedChallenge completed) {
        completedDao.create(completed);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void createUser(User user) {
        userDao.create(user);
    }

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
