package servlets;

import administration.StorageController;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        try {
            StorageController controller = new StorageController();

            Long testuserID = 1L;

            //TODO USERID aus Session holen
            User actualUser = controller.getUserById(testuserID);
            if(actualUser.getUserId()==testuserID) {
                request.setAttribute("actualUser", actualUser);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            } else {
                response.getWriter().print("Actual User not found");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }
}
