
package servlets;

import database.Cart;
import database.NewHibernateUtil;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.jboss.logging.Logger;


public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("form-username");
        String password = req.getParameter("form-password");

        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        criteria.add(Restrictions.eq("password", password));
        
         

        if (criteria.list().isEmpty()) {
            resp.getWriter().write("0");
         
        } else {
            //login success
            User user = (User) criteria.uniqueResult();

            if (user.getStatus() == 1) {

                //log una customerge db cart eke items gannawa
                Set<Cart> dbcarts = user.getCarts();

                req.getSession().setAttribute("user", user);
                resp.getWriter().write("1");
                
                
             
               

                //session cart ekak tiyenawada balanawa
                if (req.getSession().getAttribute("sessioncart") != null) {
                    List<Cart> sessioncarts = (List<Cart>) req.getSession().getAttribute("sessioncart");

                    if (dbcarts.isEmpty()) {
                        for (Cart sc : sessioncarts) {
                            Cart c = new Cart();
                            c.setUser(user);
                            c.setProduct(sc.getProduct());
                            c.setQty(sc.getQty());
                            c.setStatus(1);
                            session.save(c);
                            session.flush();
                            session.clear();
                        }

                    } else {
                        //else ekata awa kiyanne db cart eke item tiyenawa
                        for (Cart sc : sessioncarts) {

                            boolean foundIndbcart = false;

                            for (Cart dc : dbcarts) {

                                if (dc.getProduct().getPid() == sc.getProduct().getPid()) {

                                    foundIndbcart = true;

                                    if (sc.getProduct().getQty() >= (dc.getQty() + sc.getQty())) {
                                        dc.setQty(dc.getQty() + sc.getQty());
                                        session.update(dc);

                                    } else {
                                        //stock eke quantity madi
                                        dc.setQty(sc.getProduct().getQty());
                                        session.update(dc);
                                    }
                                }
                            }

                            if (!foundIndbcart) {
                                Cart c = new Cart();
                                c.setUser(user);
                                c.setProduct(sc.getProduct());
                                c.setQty(sc.getQty());
                                c.setStatus(1);
                                session.save(c);
                                session.flush();
                                session.clear();
                            }
                        }
                    }
                }

            } else {
                resp.getWriter().write("2");
               
            }

        }
        
        session.beginTransaction().commit();
        session.close();
        
        String appPath=getServletContext().getRealPath("");
        Log4j.loging(appPath,email+" "+"-"+"Logged in to the system");
        
       
    }
    

}
