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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Kaveesha Nadun
 */
public class SaveSliders extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
          
             DiskFileItemFactory diff = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(diff);
            List<FileItem> fiList = sfu.parseRequest(request);

            if (!fiList.isEmpty()) {
                SessionFactory factory = NewHibernateUtil.getSessionFactory();
                Session session = factory.openSession();
                
                Criteria createCriteria = session.createCriteria(Editslider.class);
                int size = createCriteria.list().size();
                Transaction transaction = session.beginTransaction();

                Editslider slide = new Editslider();
                slide.setId(size+1);

                for (FileItem fi : fiList) {

                    if (fi.isFormField()) {
                        
                    } else {

                        // FileItem get = fiList.get(0);
                        String appPath = getServletContext().getRealPath("");
                        String fileName = String.valueOf(System.currentTimeMillis());
                        String filePath = appPath + "//recources//" + fileName + fi.getName();
                        
                        File f = new File(filePath);
                        fi.write(f);
                        slide.setPic(fileName + fi.getName());
                        

                    }

                }
                session.save(slide);

                transaction.commit();
                session.close();

                response.sendRedirect("adminpanel.jsp");
            }
        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"SaveSliders Servlet error");
        }
    }


}
