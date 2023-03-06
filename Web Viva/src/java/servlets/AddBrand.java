
package servlets;

import database.Brand;
import database.NewHibernateUtil;
import database.User;
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


public class AddBrand extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String brandname = req.getParameter("brand-name");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(Brand.class);
            criteria.add(Restrictions.eq("brandname", brandname));

            if (criteria.list().isEmpty()) {
                Brand b = new Brand();
                b.setBrandname(brandname);

                session.save(b);
                Transaction transaction = session.beginTransaction();
                transaction.commit();

                resp.getWriter().write("1");
            } else {
                resp.getWriter().write("0");
            }
            session.close();

        } catch (Exception e) {
           e.printStackTrace();
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"AddBrand Servlet error");
        }

    }

}
