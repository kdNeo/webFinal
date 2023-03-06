
package servlets;

import database.NewHibernateUtil;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;


public class AdminViewUsers extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
     try {
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.ne("email", "admin@gmail.com"));
            criteria.addOrder(Order.desc("status"));

            List<User> user_list = criteria.list();


            RequestDispatcher rd = req.getRequestDispatcher("adminuserview.jsp");
            req.setAttribute("admin_user_list", user_list);
            rd.forward(req, resp);

        } catch (Exception e) {
              e.printStackTrace();
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"AdminViewUsers Servlet error");
        }
    }

   
}
