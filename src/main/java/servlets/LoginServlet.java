package servlets;

import administration.StorageController;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    User actualUser;
    ArrayList<User> userlist;


    public LoginServlet()
    {
        controller = new StorageController();
        userlist = controller.getAllUsers();

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");
        String username = request.getParameter("username");




        //Check if login name and password fits with one of the user list
        //if it is fitting, get session with user, if not alert failure
        for (User u: userlist) {

            //response.getWriter().print(u.getName());
            //response.getWriter().print(u.getPass());

            if(u.getName().equals(username))
            {
               if(u.getPass().equals(password))
               {
                   actualUser = u;

                   // TODO User in Session eintragen
                   HttpSession session=request.getSession();
                   session.setAttribute("id",actualUser.getUserId());
                   response.sendRedirect("profile");


               }
               else
               {
                   response.getWriter().print("Falsches Passwort");
               }
            }
        }

        response.getWriter().print("User nicht vorhanden");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
