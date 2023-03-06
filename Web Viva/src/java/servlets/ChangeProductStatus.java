
package servlets;

import database.NewHibernateUtil;
import database.Product;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class ChangeProductStatus extends HttpServlet {

 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String pid = req.getParameter("pid");
            String status = req.getParameter("status");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Product product = (Product) session.load(Product.class, Integer.valueOf(pid));
            product.setStatus(Integer.valueOf(status));
            session.update(product);
            session.beginTransaction().commit();

        } catch (Exception e) {
          e.printStackTrace();
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"ChangeProducts Servlet error");
        }

    }

}
