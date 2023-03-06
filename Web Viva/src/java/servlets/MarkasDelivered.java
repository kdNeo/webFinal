
package servlets;

import database.Invoice;
import database.NewHibernateUtil;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class MarkasDelivered extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String invid = req.getParameter("invid");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Invoice invoice = (Invoice) session.load(Invoice.class, Integer.valueOf(invid));
            invoice.setStatus(1);
            session.update(invoice);
            session.beginTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"MarkasDeliverd Servlet error");
        }

    }

}
