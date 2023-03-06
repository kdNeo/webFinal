
package servlets;

import database.Cart;
import database.CartHasInvoice;
import database.Invoice;
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
import javax.servlet.http.HttpSession;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;


public class LoadOrders extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            HttpSession hs = req.getSession();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            User user = (User) hs.getAttribute("user");

            Criteria invoiceCriteria = session.createCriteria(Invoice.class);
            Criteria carthasinvoiceCriteria = session.createCriteria(CartHasInvoice.class);
            Criteria cartCriteria = session.createCriteria(Cart.class);

          

            List<Invoice> invoice_list = invoiceCriteria.list();

            if (invoice_list.isEmpty()) {
                resp.getWriter().write("<h4>No Orders Found</h4>");
            } else {
                carthasinvoiceCriteria.add(Restrictions.in("invoice", invoice_list));
                List<CartHasInvoice> carthasinvoice_list = carthasinvoiceCriteria.list();

                RequestDispatcher rd = req.getRequestDispatcher("adminordersview.jsp");
                req.setAttribute("carthasinvoice_list", carthasinvoice_list);
                req.setAttribute("invoice_list", invoice_list);
                rd.forward(req, resp);
            }

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"LoadOrders Servlet error");
        }
    }

}
