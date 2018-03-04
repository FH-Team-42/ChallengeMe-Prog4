package servlets;

import administration.StorageController;
import data.DataProvider;
import models.Challenge;
import models.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import java.util.Collection;

@WebListener
public class StartupServlet implements ServletContextListener {

    public void contextInitialized(ServletContextEvent event) {

        DataProvider provider = new DataProvider();
        StorageController controller = new StorageController();

        Collection<User> users = provider.createTestUsers();
        controller.createAllUsers(users);

        Collection<Challenge> challenges = provider.createTestChallenges(controller.getUserById(1L).getUserId(), controller.getUserById(2L).getUserId(), controller.getUserById(3L).getUserId());
        controller.createAllChallenges(challenges);
    }

    public void contextDestroyed(ServletContextEvent event) {
        //do on application destroy
    }
}