package administration;

import administration.daos.DataController;
import administration.daos.IGenericDao;
import models.Challenge;
import models.User;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by Max on 09.07.2017.
 */
public class ChallengeController {

    IGenericDao<Challenge> challengeDao = null;
    IGenericDao<User> userDao = null;

    public ChallengeController() {
        challengeDao = DataController.getInstance().getChallengeDao();
        userDao = DataController.getInstance().getUserDao();
    }

    public void createAllChallenges(Collection<Challenge> challenges) {
        challengeDao.createAll(challenges);
    }

    public ArrayList<Challenge> getAllChallenges() {
        return new ArrayList<Challenge>( challengeDao.findAll());
    }

    public void createAllUsers(Collection<User> users) {
        userDao.createAll(users);
    }

    public ArrayList<User> getAllUsers() {
        return new ArrayList<User>( userDao.findAll());
    }
}
