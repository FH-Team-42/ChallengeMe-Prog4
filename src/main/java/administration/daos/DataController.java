package administration.daos;

import models.Challenge;
import models.CompletedChallenge;
import models.User;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/*
    This class is used to create Dao instances and to hide all
    the database related stuff. Therefore, it can be considered
    as a Facade to the database module/package.

    It is implemented as a singleton and holds a reference to the
    sole instance of our EntityManagerFactory that manages our
    persistence context.
 */
public class DataController
{
    private static final String PERSISTENCE_UNIT_NAME = "challenge_me";

    private EntityManagerFactory entityManagerFactory;

    /*
        Singleton definition
     */
    private static DataController instance;

    /**
     * Returns the DataController instance in use
     *
     * @return The DataController instance
     */
    public static DataController getInstance()
    {
        if( instance == null )
            instance = new DataController();

        return instance;
    }

    private DataController()
    {
        this.entityManagerFactory = Persistence.createEntityManagerFactory( PERSISTENCE_UNIT_NAME );
    }

    /*
        Dao Getter
     */

    /**
     * Gets a Dao containing a challenges data
     *
     * @return The challenge data dao
     */
    public IGenericDao<Challenge> getChallengeDao()
    {
        return new GenericDao<Challenge>( Challenge.class,
                this.entityManagerFactory.createEntityManager() );
    }

    /**
     * Gets a Dao containing a users data
     *
     * @return The user data dao
     */
    public IGenericDao<User> getUserDao()
    {
        return new GenericDao<User>( User.class,
                this.entityManagerFactory.createEntityManager() );
    }

    /**
     * Returns a dao containing a completed challenge
     *
     * @return The completed challenge dao
     */
    public IGenericDao<CompletedChallenge> getCompletedDao() {
        return new GenericDao<CompletedChallenge>(CompletedChallenge.class,
                this.entityManagerFactory.createEntityManager());
    }

}