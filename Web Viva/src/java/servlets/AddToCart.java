
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


public class AddToCart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String product_id = req.getParameter("id");
            String qty = req.getParameter("qty");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Product product = (Product) session.load(Product.class, Integer.parseInt(product_id));

            if (req.getSession().getAttribute("user") != null) {
                //Logged In - Add to DB Cart
                User user = (User) req.getSession().getAttribute("user");
                
                resp.getWriter().write("User Logged In"+"<br>");

                //log wela inna userge cart eke ewana product eka add wela tiyeda balala ita adala cart eke quantity eka check karaganna one
                //**********LazyInitialization Exception************
                user = (User) session.load(User.class, user.getEmail());
                Set<Cart> user_cart_items = user.getCarts();

                if (user_cart_items.isEmpty()) {
                    
                    resp.getWriter().write("Cart has No Items"+"<br>");
                    //cart eke items ne
                    //products wala available quantity eka user enter karana qty ekata wada wedida kiyala check karanawa
                    if (product.getQty() >= Integer.parseInt(qty)) {
                        //quantity available
                        //cart object ekak hadala data tika add karagannawa
                        Cart cart = new Cart();
                        cart.setUser(user);
                        cart.setProduct(product);
                        cart.setQty(Integer.parseInt(qty));
                        cart.setStatus(1);
                        session.save(cart);
                        session.beginTransaction().commit();
                        
                        resp.getWriter().write("Quantity available - added to cart"+"<br>");

                    } else {
                        //quantity not available
                        resp.getWriter().write("Quantity Out Of Stock"+"<br>");
                    }

                } else {
                    //user has cart items
                    resp.getWriter().write("User Cart Has Items"+"<br>");

                    Cart cart = null;

                    //check all cart items
                    for (Cart c : user_cart_items) {
                        if (c.getProduct().getPid() == product.getPid() && c.getStatus()==1) {
                            cart = c;
                            break;
                        }
                    }

                    //aluthen add karana product eka cart eke tiyeda kiyala check karanawa
                    if (cart != null) {
                        //added product already in cart
                        if (product.getQty() >= (cart.getQty() + Integer.parseInt(qty))) {
                            //update quantity
                            cart.setQty(cart.getQty() + Integer.parseInt(qty));
                            session.update(cart);
                            session.beginTransaction().commit();
                        } else {
                            //quantity out of stock
                            resp.getWriter().write("You can add maximum " + (product.getQty() - cart.getQty()));
                        }

                    } else {
                        //added product not in cart
                        if (product.getQty() >= Integer.parseInt(qty)) {
                            //quantity available
                            //cart object ekak hadala data tika add karagannawa
                            Cart cart1 = new Cart();
                            cart1.setUser(user);
                            cart1.setProduct(product);
                            cart1.setQty(Integer.parseInt(qty));
                            cart1.setStatus(1);
                            session.save(cart1);
                            session.beginTransaction().commit();
                            resp.getWriter().write("Quantity Available - Added to Cart"+"<br>");
                        } else {
                            //quantity not available
                            resp.getWriter().write("You can add maximum " + (product.getQty()));
                        }
                        
                    }

                }

            } else {
                //Not Logged In - Add to Session Cart
                resp.getWriter().write("Not Logged In"+"<br>");

                HttpSession hs = req.getSession();

                //sessin eke cart ites add karapu array list ekak tiyeda kiyala balanawa
                if (hs.getAttribute("sessioncart") != null) {
                    resp.getWriter().write("But Cart Exists"+"<br>");//session cart exists

                    ArrayList<Cart> cart_items = (ArrayList<Cart>) hs.getAttribute("sessioncart");

                    Cart cart = null;

                    for (Cart c : cart_items) {

                        if (c.getProduct().getPid() == product.getPid()) {
                            cart = c;
                            break;
                        }
                    }

                    if (cart != null) {
                        resp.getWriter().write("Cart Not Empty"+"<br>");//Session Cart Not Empty

                        if (product.getQty() >= (cart.getQty() + Integer.parseInt(qty))) {
                            resp.getWriter().write("Quantity Available"+"<br>");
                            cart.setQty((cart.getQty() + Integer.parseInt(qty)));
                        } else {
                            resp.getWriter().write("You can add maximum " + (product.getQty() - cart.getQty()));
                        }

                    } else {
                        resp.getWriter().write("Session Cart is Empty"+"<br>");

                        if (product.getQty() >= Integer.parseInt(qty)) {
                            resp.getWriter().write("Quantity Available"+"<br>");

                            Cart cart1 = new Cart();
                            cart1.setUser(null);
                            cart1.setProduct(product);
                            cart1.setQty(Integer.parseInt(qty));

                            cart_items.add(cart1);
                            hs.setAttribute("sessioncart", cart_items);

                        } else {
                            resp.getWriter().write("You can add maximum " + (product.getQty() - cart.getQty()));
                        }
                    }
                } else {
                    resp.getWriter().write("1st Item added to Cart"+"<br>");//1st Item added to Session Cart

                    if (product.getQty() >= Integer.parseInt(qty)) {
                        resp.getWriter().write("Quantity Available"+"<br>");

                        ArrayList<Cart> cart_items = new ArrayList<>();

                        Cart cart = new Cart();
                        cart.setUser(null);
                        cart.setProduct(product);
                        cart.setQty(Integer.parseInt(qty));

                        cart_items.add(cart);
                        hs.setAttribute("sessioncart", cart_items);

                    } else {
                        resp.getWriter().write("Quantity Not Available"+"<br>");
                    }
                }
            }
            session.close();

        } catch (Exception e) {
              e.printStackTrace();
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"AddToCart Servlet error");
        }

    }
}
