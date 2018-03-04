package servlets;


/**
 * This servlet handels everything in the frontend, what has to do with the challenges.
 * It is possible to start and end the challenges and also show them on a table.
 */

import administration.StorageController;
import models.Challenge;
import models.CompletedChallenge;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(
        name = "ChallengeServlet",
        urlPatterns = "/challenges"
)
public class ChallengesServlet extends HttpServlet {

    private StorageController controller;

    @Override
    public void init() throws ServletException {
        super.init();
        controller = new StorageController();
    }

    /**
     * Handles GET requests to the challenge servlet
     *
     * @param request The GET request
     * @param response The response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession(false).getAttribute("id") != null) {

            switch (request.getParameter("action")) {
                case "showAll":
                    showAllChallenges(request, response);
                    break;
                case "show":
                    showChallenge(request, response);
                    break;
                case "start":
                    startChallenge(request, response);
                    break;
                case "showActive":
                    showActiveChallenges(request, response);
                    break;
                case "complete":
                    completeChallenge(request, response);
                    break;
                case "showCreate":
                    showCreateForm(request, response);
            }

            } else {
                request.getSession(false).setAttribute("message", "Bitte zuerst einloggen!");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }

    }

    /**
     * Handles POST requests to the challenge servlet
     *
     * @param request The POST request
     * @param response The response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if(request.getSession(false).getAttribute("id") != null) {
            switch (request.getParameter("action")) {
                case "create":
                    createChallenge(request, response);
                    break;
            }
        } else {
            request.getSession(false).setAttribute("message", "Bitte zuerst einloggen!");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    /**
     * Shows all challenges in the database
     *
     * @param request The request
     * @param response The response
     * @throws ServletException
     * @throws IOException
     */
    private void showAllChallenges(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Challenge> challenges = controller.getAllChallenges();
        if(!challenges.isEmpty()) {
            request.setAttribute("challengeList", challenges);
            request.getRequestDispatcher("/includes/pages/ShowChallenge/challenges.jsp").forward(request, response);
        } else {
            response.getWriter().print("No challenges in Database");
        }
    }

    /**
     * Shows a specific challenge from the database
     *
     * @param request The request
     * @param response The response
     * @throws ServletException
     * @throws IOException
     */
    private void showChallenge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long challengeId = Long.parseLong(request.getParameter("challengeId"));
        Challenge desiredChallenge = controller.getChallengeById(challengeId);
        if(desiredChallenge != null) {
            String creatorUsername = controller.getUserById(desiredChallenge.getIdCreator()).getName();
            request.setAttribute("creatorUsername", creatorUsername);
            request.setAttribute("desiredChallenge", desiredChallenge);
            request.getRequestDispatcher("/includes/pages/ShowChallenge/single-challenge.jsp").forward(request, response);
        } else {
            response.getWriter().print("There was an error with your Challenge");
        }
    }

    /**
     * Starts a challenge
     *
     * @param request The request
     * @param response The response
     * @throws ServletException
     * @throws IOException
     */
    private void startChallenge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message = "";
        long sessionUserId = (long) request.getSession(false).getAttribute("id");
        long challengeId = Long.parseLong(request.getParameter("challengeId"));
        Challenge startedChallenge = controller.getChallengeById(challengeId);
        if(startedChallenge.isCompleted()) {
            message = "Challenge wurde bereits abgeschlossen. Wähle eine andere";
            request.getSession(false).setAttribute("message", message);
            showChallenge(request, response);
        } else {
            startedChallenge.setIdChallenged(sessionUserId);
            startedChallenge.setStarted(new Date());
            controller.updateChallenge(startedChallenge);

            ArrayList<Challenge> activeChallenges = controller.getActiveChallengesByUserId(sessionUserId);
            request.setAttribute("activeChallenges", activeChallenges);
            request.getRequestDispatcher("/includes/pages/ActiveChallenge/active-challenges.jsp").forward(request, response);
        }

    }

    /**
     * Show a users active challenges
     *
     * @param request The request
     * @param response The response
     * @throws ServletException
     * @throws IOException
     */
    private void showActiveChallenges(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long sessionUserId = (long) request.getSession(false).getAttribute("id");
        ArrayList<Challenge> activeChallenges = controller.getActiveChallengesByUserId(sessionUserId);
        request.setAttribute("activeChallenges", activeChallenges);
        request.getRequestDispatcher("/includes/pages/ActiveChallenge/active-challenges.jsp").forward(request, response);
    }

    /**
     * Set a given challenge to completed status
     *
     * @param request The request
     * @param response The response
     * @throws ServletException
     * @throws IOException
     */
    private void completeChallenge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long challengeId = Long.parseLong(request.getParameter("challengeId"));
        Challenge completedChallenge = controller.getChallengeById(challengeId);
        long sessionUserId = (long) request.getSession(false).getAttribute("id");

        if(completedChallenge.getIdChallenged() == sessionUserId) {
            completedChallenge.complete();
            controller.updateChallenge(completedChallenge);
            CompletedChallenge challenge = new CompletedChallenge(sessionUserId, completedChallenge.getChallengeId());
            controller.createCompletedChallenge(challenge);

            ArrayList<Challenge> activeChallenges = controller.getActiveChallengesByUserId(sessionUserId);
            request.setAttribute("activeChallenges", activeChallenges);
            request.getRequestDispatcher("/includes/pages/ActiveChallenge/active-challenges.jsp").forward(request, response);

        }
    }

    /**
     * Show the form to create a new challenge
     *
     * @param request The request
     * @param response The response
     * @throws ServletException
     * @throws IOException
     */
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/includes/pages/CreateChallenge/create-challenge.jsp").forward(request, response);
    }

    /**
     * Create a new challenge in the database
     *
     * @param request The request
     * @param response The response
     * @throws ServletException
     * @throws IOException
     */
    private void createChallenge(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int completionTime = Integer.parseInt(request.getParameter("time"));
        long idCreator = (long) request.getSession(false).getAttribute("id");


        controller.createChallenge(new Challenge(title, description, completionTime, idCreator));

        request.getSession(false).setAttribute("message", "Challenge wurde erfolgreich hinzugefügt.");
        response.sendRedirect("/challenges?action=showAll");
    }
}
