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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Kaveesha Nadun
 */
public class LoadContacts extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            
            Criteria criteria = session.createCriteria(Contactus.class);
            
            criteria.add(Restrictions.eq("id", 1));
            Contactus result = (Contactus) criteria.uniqueResult();
            
            request.getSession(true).setAttribute("id", result);
            
            request.getRequestDispatcher("view.jsp").forward(request,response);
            
        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"LoadContacts Servlet error");
        }
       
    }



}
