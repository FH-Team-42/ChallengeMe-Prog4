package administration;

import administration.daos.DataController;
import administration.daos.IGenericDao;
import models.Challenge;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by Max on 09.07.2017.
 */
public class ChallengeController {

    public ChallengeController() {
        IGenericDao<Challenge> challengeDao = DataController.getInstance().getChallengeDao();

        Challenge testChallenge = new Challenge("Test Challenge", "Das ist eine Testchallenge. Mach 10 Liegestützen", 200, 1);

        challengeDao.create( testChallenge );

        Collection<Challenge> allChallenges = challengeDao.findAll();

        ArrayList<Challenge> allChallengesList = new ArrayList<Challenge>(allChallenges);

        for ( Challenge c : allChallengesList) {
            System.out.println( "Description: " + c.getDescription() + ", Titel: " + c.getTitle());
        }
    }
}
