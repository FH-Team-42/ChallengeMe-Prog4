package servlets;

import administration.StorageController;
import data.DataProvider;
import models.Challenge;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@WebServlet(
        name = "HomeServlet",
        urlPatterns = "/home"
)
public class StartPageServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DataProvider provider = new DataProvider();

        StorageController controller = new StorageController();

        Collection<User> users = provider.createTestUsers();
        Collection<Challenge> challenges = provider.createTestChallenges();

        controller.createAllUsers(users);
        controller.createAllChallenges(challenges);


        request.getRequestDispatcher("home.jsp").forward(request, response);
    }

}