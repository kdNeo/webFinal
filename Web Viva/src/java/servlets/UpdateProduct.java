package servlets;

import database.Brand;
import database.NewHibernateUtil;
import database.Product;
import database.Type;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
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

public class UpdateProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            DiskFileItemFactory dfif = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(dfif);

            List<FileItem> items = sfu.parseRequest(req);

            String path = getServletContext().getRealPath("") + "//";
            String name = "";
            String description = "";
            String qty = "";
            String imagepath = "";
            String currentimagepath = "";
            String pid = "";
            String expiry = "";

            int i = 1;
            for (FileItem item : items) {
                if (item.getFieldName().equals("hidden-product-id")) {
                    pid = item.getString();
                } else if (item.getFieldName().equals("hidden-product-image")) {
                    currentimagepath = item.getString();
                } else if (item.getFieldName().equals("form-product-name")) {
                    name = item.getString();
                } else if (item.getFieldName().equals("form-product-description")) {
                    description = item.getString();
                } else if (item.getFieldName().equals("form-quantity")) {
                    qty = item.getString();
                } else if (item.getFieldName().equals("form-image")) {
                    if (item.getName().isEmpty()) {
                        imagepath = currentimagepath;
                    } else {
                        imagepath = "resources/" + System.currentTimeMillis() + item.getName();
                        File f = new File(path + imagepath);
                        item.write(f);
                    }
                } else if (item.getFieldName().equals("form-expiry")) {
                    expiry = item.getString();
                }

                if (i++ == items.size()) {
                    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                    Session session = sessionFactory.openSession();

                    Product product = (Product) session.load(Product.class, Integer.parseInt(pid));

                    product.setPname(name);
                    product.setDescription(description);
                    product.setQty(Integer.valueOf(qty));
                    product.setImage(imagepath);
                    DateFormat format = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
                    product.setExpiry(format.parse(expiry));
                    session.update(product);
                    session.beginTransaction().commit();

                    resp.sendRedirect("adminpanel.jsp");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"UpdateProducts Servlet error");
        }

    }
}
