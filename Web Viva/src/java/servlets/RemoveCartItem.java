
package servlets;

import database.Cart;
import database.NewHibernateUtil;
import database.Product;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class RemoveCartItem extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String product_id = req.getParameter("id");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Product product = (Product) session.load(Product.class, Integer.parseInt(product_id));

            if (req.getSession().getAttribute("user") != null) {
                //Logged In - Add to DB Cart
                User user = (User) req.getSession().getAttribute("user");

                //log wela inna userge cart eke ewana product eka add wela tiyeda balala ita adala cart eke quantity eka check karaganna one
                //**********LazyInitialization Exception************
                user = (User) session.load(User.class, user.getEmail());
                Set<Cart> user_cart_items = user.getCarts();

                //user has cart items
                resp.getWriter().write("User Has Cart Items");

                Cart cart = null;

                //check all cart items
                for (Cart c : user_cart_items) {
                    if (c.getProduct().getPid() == product.getPid()) {
                        cart = c;
                        session.delete(cart);
                        session.beginTransaction().commit();
                        user_cart_items.remove(c);
                        break;
                    }
                }
                //session.close();

            } else {
                //Not Logged In - Add to Session Cart
                HttpSession hs = req.getSession();

                //sessin eke cart ites add karapu array list ekak tiyeda kiyala balanawa
                if (hs.getAttribute("sessioncart") != null) {
                    resp.getWriter().write("Session Cart Exists");

                    ArrayList<Cart> cart_items = (ArrayList<Cart>) hs.getAttribute("sessioncart");

                    Cart cart = null;

                    for (Cart c : cart_items) {
                        
                        if (c.getProduct().getPid() == product.getPid()) {
                            cart = c;
                            session.delete(cart);
                            session.beginTransaction().commit();
                            cart_items.remove(c);
                            break;
                        }
                    }

                } 
            }
            session.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"RemoveCartItem Servlet error");
        }

    }
}
