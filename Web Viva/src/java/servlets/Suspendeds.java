/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.NewHibernateUtil;
import database.Suspend;
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
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Kaveesha Nadun
 */
public class Suspendeds extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
            DiskFileItemFactory diff = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(diff);
            List<FileItem> fiList = sfu.parseRequest(req);
            
            

            SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session session = factory.openSession();
            Transaction transaction = session.beginTransaction();

            Criteria criteria = session.createCriteria(Suspend.class);

            criteria.add(Restrictions.eq("id", 1));

            Suspend suspend = (Suspend) criteria.uniqueResult();

     
               
                
                suspend.setStatus(1);

                for (FileItem fi : fiList) {
                    
                    System.out.println(fi);

                    if (fi.isFormField()) {
                        switch (fi.getFieldName()) {
                            case "w3review":
                                System.out.println(fi.getString());
                                suspend.setText(fi.getString());
                                break;

                        }
                    } else {

                        
                        // FileItem get = fiList.get(0);
                        String appPath = getServletContext().getRealPath("");
                        String fileName = String.valueOf(System.currentTimeMillis());
                        String filePath = appPath + "//img//" + fileName + fi.getName();
                        File currentFile = new File(appPath + "//img//" + suspend.getPath());
                        currentFile.delete();
                        File f = new File(filePath);
                        fi.write(f);
                        suspend.setPath(fileName+fi.getName());
                        System.out.println(filePath);

                    }

                }
                session.update(suspend);
            

            transaction.commit();
            session.close();
            
           
          req.getRequestDispatcher("adminpanel.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"Suspends Servlet error");
        }
    }

   


}
