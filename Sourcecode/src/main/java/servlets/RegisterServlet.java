package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import administration.StorageController;
import models.User;
import utilities.Utils;

import java.util.ArrayList;
import java.util.Date;

import java.text.*;

/**
 * Created by davidwenkemann on 03.03.18.
 */

/**
 * This servlet handels the registration. It proofs if the passwords were two times the same and if the username
 * is already used.
 */
@WebServlet(name = "RegisterServlet",
        urlPatterns = "/register"
)
public class RegisterServlet extends HttpServlet {
    /**
     * Handles POST requests to the Register Servlet
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session=request.getSession();
        StorageController controller = new StorageController();
        ArrayList<User> userList;
        userList = controller.getAllUsers();



        //getData from register form
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String birthdayString = request.getParameter("birthday");

        Date date = Utils.parseDate(birthdayString);

        for (User u: userList) {
            if(u.getName().equals(name))
            {
                request.getSession(false).setAttribute("message", "Username schon vorhanden");

                request.getRequestDispatcher("/index.jsp").forward(request, response);
                return;
            }
        }


        //create new User
        User newUser = new User(name, password, date);
        controller.createUser(newUser);


        userList = controller.getAllUsers();
        for (User u: userList) {
            if(u.getName().equals(name))
            {

                    newUser = u;

                    session.setAttribute("id",newUser.getUserId());
            }
        }


        response.sendRedirect("profile");

    }
}
