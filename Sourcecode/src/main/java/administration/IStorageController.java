package administration;

import models.Challenge;
import models.CompletedChallenge;
import models.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Max on 09.07.2017.
 */
public interface IStorageController {

    void createAllChallenges(Collection<Challenge> challenges);

    ArrayList<Challenge> getAllChallenges();

    void updateChallenge(Challenge challenge);

    void createChallenge (Challenge challenge);

    Challenge findChallengeById(Long id);

    ArrayList<Challenge> getActiveChallengesByUserId(long idChallenged);

    void deleteChallenge(Challenge challenge);

    void deleteChallengeById(long id);

    void createCompletedChallenge(CompletedChallenge completed);

    int getCompletedChallengesByUserId(long id);

    void createAllUsers(Collection<User> users);

    ArrayList<User> getAllUsers();




}
