import administration.StorageController;
import models.Challenge;
import models.User;
import data.DataProvider;

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
        controller.createAllUsers(users);


        Collection<Challenge> challenges = provider.createTestChallenges(controller.getUserById(new Long(1)).getUserId(), controller.getUserById(new Long(2)).getUserId(), controller.getUserById(new Long(3)).getUserId());
        controller.createAllChallenges(challenges);

        ArrayList<Challenge> challenge = controller.getAllChallenges();
        ArrayList<User> allUser = controller.getAllUsers();

        for(Challenge c : challenge) {
            System.out.println("ID: " + c.getChallengeId() + ", Creator: " + c.getCreatorId() +", Creation Date: " + c.getCreated() +", Update Date: " + c.getUpdated());
        }

    }
}
