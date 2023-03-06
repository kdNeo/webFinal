
package servlets;

import database.Cart;
import database.NewHibernateUtil;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
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


public class EmptyCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession hs = req.getSession();

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            List<Cart> cart_list = null;

            if (hs.getAttribute("user") != null) {

                User user = (User) hs.getAttribute("user");

                Criteria criteria = session.createCriteria(Cart.class);
                criteria.add(Restrictions.eq("user", user));
                criteria.add(Restrictions.eq("status", 1));

                cart_list = criteria.list();
                Cart cart = null;

                if (cart_list != null) {
                    for (int i = 0; i < cart_list.size(); i++) {
                      
                        session.delete(cart_list.get(i));
                        session.beginTransaction().commit();
                        cart_list.remove(i);
                    }
                    if (cart_list.size() == 0) {
                        resp.getWriter().write("1");
                    }
                }

            } else {
                cart_list = (List<Cart>) hs.getAttribute("sessioncart");
                Cart cart = null;

                if (cart_list != null) {
                    for (int i = 0; i < cart_list.size(); i++) {
                       
                        session.delete(cart_list.get(i));
                        session.beginTransaction().commit();
                        cart_list.remove(i);

                    }
                    if (cart_list.size() == 0) {
                        resp.getWriter().write("1");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"EmptyCart Servlet error");
        }

    }

}
