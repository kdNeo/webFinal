
package servlets;

import database.NewHibernateUtil;
import database.User;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class UpdateUserDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            User user = (User) req.getSession().getAttribute("user");
            
            DiskFileItemFactory dfif = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(dfif);

            List<FileItem> items = sfu.parseRequest(req);

            String path = getServletContext().getRealPath("") + "//";
            String name = "";
            String email = "";
            String password = "";
            String imagepath = "";
            
            int i = 1;
            for (FileItem item : items) {
                if (item.getFieldName().equals("form-full-name")) {
                    name = item.getString();
                } else if (item.getFieldName().equals("form-email")) {
                    email = item.getString();
                } else if (item.getFieldName().equals("form-password")) {
                    password = item.getString();
                } else if (item.getFieldName().equals("form-image")) {
                    if (item.getName() == null) {
                        //System.out.println(item.getName());
                        imagepath = "";
                    } else {
                        //System.out.println(item.getName());
                        imagepath = "resources/" + System.currentTimeMillis() + item.getName();
                        File f = new File(path + imagepath);
                        item.write(f);
                    }
                }

                if (i++ == items.size()) {
                    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                    Session session = sessionFactory.openSession();
                    Transaction transaction = session.beginTransaction();

                    user = (User) session.load(User.class, user.getEmail());

                    if (imagepath != "") {
                        user.setImage(imagepath);
                    }
                    user.setName(name);
                    user.setPassword(password);
                    session.update(user);
                    session.flush();
                    transaction.commit();

                    req.getSession().setAttribute("user", user);

                    resp.getWriter().write("1");
                }
            }
            

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"UpdateUserDetails Servlet error");

        }

    }
}
