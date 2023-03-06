
package servlets;

import database.NewHibernateUtil;
import database.Type;
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
import org.hibernate.criterion.Projections;


public class LoadCatagories extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
    try {

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Type.class);
            criteria.setProjection(Projections.distinct(Projections.property("typename")));

            List<String> types_list = criteria.list();

            RequestDispatcher rd = req.getRequestDispatcher("catagories.jsp");
            req.setAttribute("types_list", types_list);
            rd.forward(req, resp);

            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"LoadCategories Servlet error");
        }
    
    }

    
}
