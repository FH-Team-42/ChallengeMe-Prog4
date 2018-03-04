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


        //getData from register form
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String birthdayString = request.getParameter("birthday");

        Date date = Utils.parseDate(birthdayString);


        //create new User
        User newUser = new User(name, password, date);
        controller.createUser(newUser);


        ArrayList<User> userList;
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
