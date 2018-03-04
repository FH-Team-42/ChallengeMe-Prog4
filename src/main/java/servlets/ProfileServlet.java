package servlets;

import administration.StorageController;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;


/**
 * Created by davidwenkemann on 02.03.18.
 */

@WebServlet(
        name = "ProfileServlet",
        urlPatterns = "/profile"

)
public class ProfileServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StorageController controller = new StorageController();


        //Gets Sessions and load actual user ID
        HttpSession session = request.getSession(false);
        Long userID = (Long) session.getAttribute("id");


        User actualUser = controller.getUserById(userID);
        int completedChallenges = controller.getCompletedChallengesByUserId(userID);

        if(actualUser.getUserId() == userID) {
            request.setAttribute("completedChallenges", completedChallenges);
            request.setAttribute("actualUser", actualUser);
            request.getRequestDispatcher("includes/pages/Profile/profile.jsp").forward(request, response);
        } else {
            response.getWriter().print("Actual User not found");
        }
    }
}