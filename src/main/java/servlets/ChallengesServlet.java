package servlets;

import administration.StorageController;
import models.Challenge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(
        name = "ChallengeServlet",
        urlPatterns = "/challenges"
)
public class ChallengesServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StorageController controller = new StorageController();

            ArrayList<Challenge> challenges = controller.getAllChallenges();
            if(!challenges.isEmpty()) {
                for(Challenge c : challenges) {
                    c.setCompletionTime(250);
                    controller.updateChallenge(c);
                    response.getWriter().print("ID: " + c.getId() + ", Creation Date: " + c.getCreatedAt() + ", Completion Time: " + c.getCompletionTime() + ", Update Date: " + c.getUpdated());
                }
            } else {
                response.getWriter().print("No challenges in Database");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }
}
