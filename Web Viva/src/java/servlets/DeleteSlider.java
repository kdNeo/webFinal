/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Editslider;
import database.NewHibernateUtil;
import java.io.File;
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
public class DeleteSlider extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
           try {
            String id = request.getParameter("id");

            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session s = factory.openSession();
            Transaction transaction = s.beginTransaction();

            Criteria cc = s.createCriteria(Editslider.class);
            cc.add(Restrictions.eq("id", Integer.parseInt(id)));
            Editslider result = (Editslider) cc.uniqueResult();

            String appPath = getServletContext().getRealPath("");
            String fileName = String.valueOf(System.currentTimeMillis());

            File currentFile = new File(appPath + "//img//" + result.getPic());
            currentFile.delete();

            s.delete(result);
            transaction.commit();
            s.close();

           response.sendRedirect("adminpanel.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"DeleteSlider Servlet error");
        }
    }
       
  

   

}
