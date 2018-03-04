import administration.StorageController;
import models.Challenge;
import models.User;
import org.junit.Test;

import java.util.*;

public class UnitTestsLogic {
    StorageController controller = new StorageController();

    /**
     * Test user creation
     */
    @Test
    public void testUserCreation() {
        String name1 = "Max";
        String pass1 = "meinSuperDuperPasswort";
        Date birthdate1 = new Date(2000, 2, 2);

        String name2 = "David";
        String pass2 = "5";
        Date birthdate2 = new Date(1970, 1, 1);

        String name3 = "Felix";
        String pass3 = "12345abc";
        Date birthdate3 = new Date(1492, 3, 24);

        User user = new User(name1, pass1, birthdate1);
        User user2 = new User(name2, pass2, birthdate2);
        User user3 = new User(name3, pass3, birthdate3);

        assert (user.getName() == name1);
        assert (user.getBirthday() == birthdate1);
        assert (user.getPass() == pass1);

        assert (user2.getName() == name2);
        assert (user2.getBirthday() == birthdate2);
        assert (user2.getPass() == pass2);

        assert (user3.getName() == name3);
        assert (user3.getBirthday() == birthdate3);
        assert (user3.getPass() == pass3);

        List<User> users = new ArrayList<>();

        users.add(user);
        users.add(user2);
        users.add(user3);

        controller.createAllUsers(users);

        ArrayList<User> userList = controller.getAllUsers();
        assert (userList.size() > 0);
        assert (userList.get(0).getName() == name1);
        assert (userList.get(1).getName() == name2);
        assert (userList.get(2).getName() == name3);
    }

    /**
     * Test challenge creation
     */
    @Test
    public void testChallenge() {
        String title = "Testchallenge";
        String desc = "Erstelle eine Challenge, ohne Java zu zerstören";
        Challenge challenge = new Challenge(title, desc, 3600, 1);

        assert (challenge.getCompletionTime() == 3600);
        assert (challenge.getDescription() == desc);
        assert (challenge.getTitle() == title);
        assert (challenge.getIdCreator() == 1);

        controller.createChallenge(challenge);

        ArrayList<Challenge> challengeList = controller.getAllChallenges();
        assert (challengeList.size() > 0);
        assert (challengeList.get(2).getTitle() == title);
    }

    /**
     * Test challenge assignment
     */
    @Test
    public void testChallengeAssignment() {
        String name = "Max";
        String pass = "meinSuperDuperPasswort";
        Date birthdate = new Date(2000, 2, 2);

        User user = new User(name, pass, birthdate);
        user.setUserId(2L);

        Challenge challenge = new Challenge("test", "test", 3600, 1);
        controller.createChallenge(challenge);

        challenge.setIdChallenged(user.getUserId());
        controller.updateChallenge(challenge);

        ArrayList<Challenge> challenges = controller.getActiveChallengesByUserId(2L);

        assert (challenges.size() > 0);
    }

    /**
     * Test challenge completion
     */
    @Test
    public void testChallengeCompletion() {
        String name = "Max";
        String pass = "meinSuperDuperPasswort";
        Date birthdate = new Date(2000, 2, 2);

        User user = new User(name, pass, birthdate);
        user.setUserId(3L);

        Challenge challenge = new Challenge("test", "test", 3600, 1);
        controller.createChallenge(challenge);
        challenge.setIdChallenged(user.getUserId());
        controller.updateChallenge(challenge);

        challenge.complete();
        controller.updateChallenge(challenge);

        ArrayList<Challenge> challenges = controller.getActiveChallengesByUserId(3L);

        assert (challenges.size() == 0);
    }
}
