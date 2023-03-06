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
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class ForgetPassword extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            
            String email = req.getParameter("form-email");
          //  String password = req.getParameter("form-password");
            
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("email", email));
            System.out.println("hellooooooooo");
            if (criteria.list().isEmpty()) {
                resp.getWriter().write("0");
            } else {
                String valueOf = String.valueOf(GenarateOTP.getOTP());
                User user = (User) criteria.uniqueResult();
                user.setPassword(valueOf);
                session.update(user);
                session.beginTransaction().commit();
                resp.getWriter().write("1");
                UserMail.doGet(email, valueOf, user);
            }
            
           
            
        } catch (Exception e) {
            e.printStackTrace();
            
            String appPath = getServletContext().getRealPath("");
            Log4j.exceptionss(appPath, e.getMessage() + " " + "-" + "ForgetPassword Servlet error");
        }
    }
    
}
