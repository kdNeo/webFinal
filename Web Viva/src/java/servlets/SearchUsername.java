
package servlets;

import database.NewHibernateUtil;
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


public class SearchUsername extends HttpServlet {

     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            if (req.getSession().getAttribute("user") != null) {
                User user = (User) req.getSession().getAttribute("user");
                User currentUser = (User) session.load(User.class, user.getEmail());

                resp.getWriter().write(currentUser.getName()+"");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"SearchUsername Servlet error");
        }

    }

}
