
package servlets;

import database.NewHibernateUtil;
import database.Product;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ChangeUserStatus extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String email = req.getParameter("email");
            String status = req.getParameter("status");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            User user = (User) session.load(User.class, email);
            user.setStatus(Integer.valueOf(status));
            session.update(user);
            session.beginTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"ChangeUserStatus Servlet error");
        }

    }

}
