
package servlets;

import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         User email = (User) req.getSession().getAttribute("user");
        // System.out.println(email);
        req.getSession().invalidate();
        String appPath=getServletContext().getRealPath("");
        Log4j.loging(appPath,email.getEmail()+" "+"-"+"Logged out from  the system");
    }

}
