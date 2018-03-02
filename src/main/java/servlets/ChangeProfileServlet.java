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
        name = "ChangeProfileServlet",
        urlPatterns = "/changeprofile"

)


public class ChangeProfileServlet extends HttpServlet {

    private StorageController controller;
    Long testuserID;
    User actualUser;

    public ChangeProfileServlet()
    {
        controller = new StorageController();
        testuserID = 1L;
        //TODO USERID aus Session holen
        actualUser = controller.getUserById(testuserID);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            if (actualUser.getUserId() == testuserID) {
                request.setAttribute("actualUser", actualUser);
                request.getRequestDispatcher("changeprofile.jsp").forward(request, response);
            } else {
                response.getWriter().print("Actual User not found");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {


            String password = request.getParameter("password");
            String profilepic = request.getParameter("profilepic");


            if (actualUser != null && password != null) {
               actualUser.setPass(password);

               controller.updateUser(actualUser);

               response.sendRedirect("profile");

            } else if(actualUser != null && profilepic != null)  {
                actualUser.setProfilePic(profilepic);

                controller.updateUser(actualUser);

               response.sendRedirect("profile");
            } else {
                response.getWriter().print("konnte nicht gespeichert werden");

            }

        } catch (Exception e) {
            throw new ServletException(e);
        }



    }
}
