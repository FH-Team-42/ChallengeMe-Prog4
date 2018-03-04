package data;

import models.Challenge;
import models.User;
import utilities.Utils;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The DataProvider provides sample data for user and challenges to the other classes.
 * It creates 3 test user and 3 test challenges, if the respective methods are called.
 *
 */
public class DataProvider {

    private User user1 = null;
    private User user2 = null;
    private User user3 = null;

    /**
     * Create new test users
     * @return A collection of test users
     */
    public Collection<User> createTestUsers() {
        //Collection<User> allUsers ;


        this.user1 = new User("max", "123456", Utils.parseDate("1995-03-29"));
        this.user2 = new User("david", "passWort1", Utils.parseDate("1995-01-02"));
        this.user3 = new User("felix", "098765", Utils.parseDate("1997-04-09"));

        Collection<User> allUsers = new ArrayList<User>() {{
            add(user1);
            add(user2);
            add(user3);
        }};

        return allUsers;
    }

    /**
     * Create three test challenges
     * @param id1 The ID of the first challenge
     * @param id2 The ID of the second challenge
     * @param id3 The ID of the third challenge
     * @return A collection of test users
     */
    public Collection<Challenge> createTestChallenges(Long id1, Long id2, Long id3) {
        //Collection<Challenge> allChallenges = null;

        Challenge challenge1 = new Challenge("Tasty Carrot", "Iss eine Karotte", 200, id1);
        Challenge challenge2 = new Challenge("Be Loud, shout out!", "Stelle dich auf einen öffentlichen Platz und schreie sehr laut", 3000, id2);
        Challenge challenge3 = new Challenge("Push you up!", "Mache 5 Liegestützen", 150, id3);

        Collection<Challenge> allChallenges = new ArrayList<Challenge>() {{
            add(challenge1);
            add(challenge2);
            add(challenge3);
        }};

        return allChallenges;
    }

}
