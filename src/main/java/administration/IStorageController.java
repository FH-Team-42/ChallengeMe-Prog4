package administration;

import models.Challenge;
import models.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Max on 09.07.2017.
 */
public interface IStorageController {

    void createAllChallenges(Collection<Challenge> challenges);

    ArrayList<Challenge> getAllChallenges();

    void createAllUsers(Collection<User> users);

    ArrayList<User> getAllUsers();

    Challenge findChallengeById(Long id);

    void updateChallenge(Challenge challenge);
}
