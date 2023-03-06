
package servlets;

import database.NewHibernateUtil;
import database.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


public class Signup extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String name = req.getParameter("form-full-name");
            String email = req.getParameter("form-email");
            String password = req.getParameter("form-password");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Restrictions.eq("email", email));

            String imgpath = "resources//defaultuser.png";

            if (criteria.list().isEmpty()) {
                User u = new User();
                u.setEmail(email);
                u.setName(name);
                u.setPassword(password);
                u.setImage(imgpath);
                u.setStatus(0);
                int parseInt = Integer.parseInt( String.valueOf(GenarateOTP.getOTP()));
                u.setCode(parseInt);
                session.save(u);
                Transaction transaction = session.beginTransaction();
                transaction.commit();
               UserMail.doGet(email,String.valueOf(parseInt),u);
                resp.getWriter().write("1");
                
            } else {
                resp.getWriter().write("0");
            }
            session.close();
             String appPath=getServletContext().getRealPath("");
        Log4j.signup(appPath,email,password);

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"Signup Servlet error");
        }
    }

}
