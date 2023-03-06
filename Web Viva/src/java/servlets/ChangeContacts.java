/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Contactus;
import database.NewHibernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Kaveesha Nadun
 */
public class ChangeContacts extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String email = request.getParameter("e");
            String con = request.getParameter("c");
            String add = request.getParameter("a");
            
            if (!email.equals("") && !con.equals("") && !add.equals("")) {
                
                SessionFactory factory = NewHibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                Transaction transaction = session.beginTransaction();

                Criteria criteria = session.createCriteria(Contactus.class);

                criteria.add(Restrictions.eq("id", 1));
                Contactus result = (Contactus) criteria.uniqueResult();
                result.setEmail(email);
                result.setConatctno(con);
                result.setAddress(add);

                session.update(result);
                transaction.commit();
                session.close();

                response.getWriter().write("success");
            }
            
        } catch (Exception e) {
          e.printStackTrace();
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"ChangeContacts Servlet error");
        }
    }



   

}
