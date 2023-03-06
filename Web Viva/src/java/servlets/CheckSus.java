
package servlets;

import database.NewHibernateUtil;
import database.Suspend;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class CheckSus extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(Suspend.class);

            criteria.add(Restrictions.eq("id", 1));

            Suspend suspend = (Suspend) criteria.uniqueResult();
            
            suspend.setStatus(0);
            session.update(suspend);
            transaction.commit();
            
            request.getRequestDispatcher("adminviewsettings.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"CheckSus Servlet error");
        }
       
    }

  

}
