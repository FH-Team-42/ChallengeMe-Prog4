package data;

import models.Challenge;
import models.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

public class DataProvider {

    private User user1 = null;
    private User user2 = null;
    private User user3 = null;

    public Collection<User> createTestUsers() {
        //Collection<User> allUsers ;


        this.user1 = new User("max", "123456", new Date(1995, 3, 29));
        this.user2 = new User("david", "passWort1", new Date(1995, 1, 2));
        this.user3 = new User("felix", "098765", new Date(1997, 4, 9));

        Collection<User> allUsers = new ArrayList<User>() {{
            add(user1);
            add(user2);
            add(user3);
        }};

        return allUsers;
    }

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
