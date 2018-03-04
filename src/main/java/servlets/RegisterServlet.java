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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            HttpSession session=request.getSession();
            StorageController controller = new StorageController();


            //getData from register form
            String name = request.getParameter("username");
            String password = request.getParameter("password");
            String birthdayString = request.getParameter("birthday");
            //Date date = new Date(2000, 1, 1);


            //TODO geburtstag eintragen
            SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
            Date date = in.parse(birthdayString);


            //create new User
            User actualUser = new User(name, password, date);
            controller.createUser(actualUser);


            ArrayList<User> userlist;
            userlist = controller.getAllUsers();
            for (User u: userlist) {
                if(u.getName().equals(name))
                {

                        actualUser = u;

                        session.setAttribute("id",actualUser.getUserId());
                }
            }


            response.sendRedirect("profile");



        } catch (Exception e) {
            throw new ServletException(e);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

                request.getRequestDispatcher("register.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
