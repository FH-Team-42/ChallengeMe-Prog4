import administration.StorageController;
import models.Challenge;
import models.User;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Felix on 02.01.2017.
 */

public class Main {

    public static void main(String[] args) {
        DataProvider provider = new DataProvider();
        StorageController controller = new StorageController();

        Collection<User> users = provider.createTestUsers();
        Collection<Challenge> challenges = provider.createTestChallenges();

        controller.createAllUsers(users);
        controller.createAllChallenges(challenges);

        ArrayList<Challenge> challenge = controller.getAllChallenges();

        for(Challenge c : challenge) {
            c.setCompletionTime(250);
            controller.updateChallenge(c);
            System.out.println("ID: " + c.getId() + ", Creation Date: " + c.getCreatedAt() + ", Completion Time: " + c.getCompletionTime() + ", Update Date: " + c.getUpdated());
        }

    }
}
