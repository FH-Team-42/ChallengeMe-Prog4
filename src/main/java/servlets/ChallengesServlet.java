package servlets;

import administration.StorageController;
import models.Challenge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(
        name = "ChallengeServlet",
        urlPatterns = "/challenges"
)
public class ChallengesServlet extends HttpServlet {

    private StorageController controller;

    public ChallengesServlet() {
        controller = new StorageController();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String message = "";

        switch(request.getParameter("action")) {
            case "showAll":
                ArrayList<Challenge> challenges = controller.getAllChallenges();
                if(!challenges.isEmpty()) {
                    request.setAttribute("challengeList", challenges);
                    request.getRequestDispatcher("challenges.jsp").forward(request, response);
                } else {
                    response.getWriter().print("No challenges in Database");
                }
                break;
            case "show":
                long challengeId = Long.parseLong(request.getParameter("challengeId"));
                Challenge desiredChallenge = controller.getChallengeById(challengeId);
                if(desiredChallenge != null) {
                    String creatorUsername = controller.getUserById(desiredChallenge.getIdCreator()).getName();
                    request.setAttribute("creatorUsername", creatorUsername);
                    request.setAttribute("desiredChallenge", desiredChallenge);
                    request.getRequestDispatcher("single-challenge.jsp").forward(request, response);
                } else {
                    response.getWriter().print("There was an error with your Challenge");
                }


        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        switch(request.getParameter("action")) {
            case "create":
                message = createChallenge(request, response);
                break;
        }

        HttpSession session = request.getSession();
        session.setAttribute("message", message);
        response.sendRedirect("index.jsp");
    }


    private String createChallenge(HttpServletRequest request, HttpServletResponse response) {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int completionTime = Integer.parseInt(request.getParameter("time"));
        long idCreator = Long.parseLong(request.getParameter("id"));


        controller.createChallenge(new Challenge(title, description, completionTime, idCreator));

        return "Challenge wurde hinzugefügt!";
    }
}
