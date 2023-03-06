
package servlets;

import database.Cart;
import database.CartHasInvoice;
import database.Invoice;
import database.NewHibernateUtil;
import database.Product;
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
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class AddInvoice extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String contact = req.getParameter("form-contactno");
            String address = req.getParameter("form-deliveryaddress");
            
            HttpSession hs = req.getSession();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();

            int i = 1;
            double total = 0.0;
            List<Cart> cart_list = null;

            User user = (User) hs.getAttribute("user");

            Criteria criteria = session.createCriteria(Cart.class);
            criteria.add(Restrictions.eq("user", user));

            cart_list = criteria.list();

            Invoice invoice = new Invoice();
            invoice.setStatus(0);
            invoice.setUser(user);
            invoice.setContact(contact);
            invoice.setAddress(address);
            session.save(invoice);
            transaction.commit();

            for (Cart c : cart_list) {
                if (c.getStatus() == 1) {
                    Product p = c.getProduct();
                    
                    total += c.getQty() * c.getProduct().getPrice();

                    CartHasInvoice cartHasInvoice = new CartHasInvoice();
                    cartHasInvoice.setCart(c);
                    cartHasInvoice.setInvoice(invoice);
                    session.save(cartHasInvoice);

                    c.setStatus(0);
                    session.update(c);
                    
                    p.setQty(p.getQty() - c.getQty());
                    session.update(p);
                  
                }

                if (i++ == cart_list.size()) {
                    invoice.setTotal(total);
                    session.update(invoice);
                    session.beginTransaction().commit();

                  
               resp.getWriter().write(invoice.getInvid()+"");
               
                String appPath=getServletContext().getRealPath("");
        Log4j.order(appPath,invoice.getInvid(),invoice.getUser().getName()+"-"+"Purchased items");
                }
            }

        } catch (Exception e) {
              e.printStackTrace();
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"AddInvoice Servlet error");
        }
    }

}
