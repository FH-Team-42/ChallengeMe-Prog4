package servlets;

import administration.StorageController;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by davidwenkemann on 02.03.18.
 */


/**
 * This servlet handles the changes of the profile. It proofs if the password or the profile picture is changend.
 * Further the methods for the database interface are called.
 */
@WebServlet(
        name = "ChangeProfileServlet",
        urlPatterns = "/change-profile"

)


public class ChangeProfileServlet extends HttpServlet {

    private StorageController controller;
    private User actualUser;

    @Override
    public void init() throws ServletException {
        super.init();
        controller = new StorageController();
    }

    /**
     * Handles GET requests to the profile change servlet
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Gets Sessions and load actual user ID
        HttpSession session = request.getSession();
        Long userID = (Long) session.getAttribute("id");

        actualUser = controller.getUserById(userID);

        if (actualUser.getUserId() == userID) {
            request.setAttribute("actualUser", actualUser);
            request.getRequestDispatcher("includes/pages/Profile/change-profile.jsp").forward(request, response);
        } else {
            response.getWriter().print("Actual User not found");
        }
    }

    /**
     * Handles POST requests to the profile change servlet
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Long userID = (Long) session.getAttribute("id");

        actualUser = controller.getUserById(userID);

        String password = request.getParameter("password");
        String profilePicture = request.getParameter("profilePicture");


        if (actualUser != null && password != null) {
           actualUser.setPassword(password);

           controller.updateUser(actualUser);

           request.getSession(false).setAttribute("message", "Passwort erfolgreich geändert!");

           response.sendRedirect("profile");

        } else if(actualUser != null && profilePicture != null)  {
            actualUser.setProfilePic(profilePicture);

            controller.updateUser(actualUser);

            request.getSession(false).setAttribute("message", "Profilbild erfolgreich geändert!");

           response.sendRedirect("profile");
        } else {
            response.getWriter().print("konnte nicht gespeichert werden");

        }

    }
}
