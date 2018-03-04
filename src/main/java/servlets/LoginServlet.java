package servlets;

import administration.StorageController;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;


/**
 * Created by davidwenkemann on 03.03.18.
 */
@WebServlet(
        name = "LoginServlet",
        urlPatterns = "/login"
)

public class LoginServlet extends HttpServlet {

    private StorageController controller;


    @Override
    public void init() throws ServletException {
        super.init();
        controller = new StorageController();

    }

    /**
     * Handles GET requests to the login servlet
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ArrayList<User> userList = controller.getAllUsers();

        String password = request.getParameter("password");
        String username = request.getParameter("username");




        //Check if login name and password fits with one of the user list
        //if it is fitting, get session with user, if not alert failure
        for (User u: userList) {

            if(u.getName().equals(username))
            {
               if(u.getPass().equals(password))
               {
                   HttpSession session = request.getSession();
                   session.setAttribute("id", u.getUserId());
                   response.sendRedirect("profile");

               }
               else
               {
                   response.getWriter().print("Falsches Passwort: " + password + ", " + u.getPass());
               }
                break;
            } else {
                response.getWriter().print("User nicht vorhanden");
            }
            break;
        }



    }

    /**
     * Handles POST requests to the login servlet
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            switch(request.getParameter("action")) {
                case "logout":
                    request.getSession(false).removeAttribute("id");
                    response.sendRedirect("/");
        }
    }
}
