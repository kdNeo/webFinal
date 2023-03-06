package servlets;

import database.Brand;
import database.NewHibernateUtil;
import database.Product;
import database.Type;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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

public class AddProduct extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            DiskFileItemFactory dfif = new DiskFileItemFactory();
            ServletFileUpload sfu = new ServletFileUpload(dfif);

            List<FileItem> items = sfu.parseRequest(req);

            String path = getServletContext().getRealPath("") + "//";
            String type = "";
            String brand = "";
            String name = "";
            String description = "";
            String price = "";
            String qty = "";
            String imagepath = "";
            String expiry = "";

            int i = 1;
            boolean status = false;
            for (FileItem item : items) {
                if (item.getFieldName().equals("form-product-type")) {
                    type = item.getString();
                } else if (item.getFieldName().equals("form-brand")) {
                    brand = item.getString();
                } else if (item.getFieldName().equals("form-product-name")) {
                    name = item.getString();
                } else if (item.getFieldName().equals("form-product-description")) {
                    description = item.getString();
                } else if (item.getFieldName().equals("form-price")) {
                    price = item.getString();
                } else if (item.getFieldName().equals("form-quantity")) {
                    qty = item.getString();
                } else if (item.getFieldName().equals("form-image")) {
                    imagepath = "resources/" + System.currentTimeMillis() + item.getName();
                    File f = new File(path + imagepath);
                    item.write(f);
                } else if (item.getFieldName().equals("form-expiry")) {
                    expiry = item.getString();
                }

                if (i++ == items.size()) {
                    SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                    Session session = sessionFactory.openSession();
                    Transaction transaction = session.beginTransaction();

                    Criteria productCriteria = session.createCriteria(Product.class);
                    productCriteria.add(Restrictions.eq("pname", name));

                    Criteria typeCriteria = session.createCriteria(Type.class);
                    typeCriteria.add(Restrictions.eq("typename", type));

                    Type types = (Type) typeCriteria.uniqueResult();
                    productCriteria.add(Restrictions.eq("type", types));

                    Criteria brandCriteria = session.createCriteria(Brand.class);
                    brandCriteria.add(Restrictions.eq("brandname", brand));

                    Brand brands = (Brand) brandCriteria.uniqueResult();
                    productCriteria.add(Restrictions.eq("brand", brands));

                    if (productCriteria.list().isEmpty()) {
                        Product p = new Product();
                        p.setPname(name);
                        p.setDescription(description);
                        p.setPrice(Double.valueOf(price));
                        p.setQty(Integer.valueOf(qty));
                        p.setImage(imagepath);
                        p.setBrand(brands);
                        p.setType(types);
                        p.setStatus(1);
                        System.out.println(expiry);
                        DateFormat format = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
                        p.setExpiry(format.parse(expiry));

                        session.save(p);
                        session.flush();
                        transaction.commit();

                        resp.getWriter().write("1");
//                        resp.sendRedirect("adminpanel.jsp");
                    } else {
                        Product p = new Product();
                        p.setPname(name);
                        p.setDescription(description);
                        p.setPrice(Double.valueOf(price));
                        p.setQty(Integer.valueOf(qty));
                        p.setImage(imagepath);
                        p.setBrand(brands);
                        p.setType(types);
                        p.setStatus(1);
                        System.out.println(expiry);
                        DateFormat format = new SimpleDateFormat("yyyy-MM-d", Locale.ENGLISH);
                        p.setExpiry(format.parse(expiry));

                        session.save(p);
                        session.flush();
                        transaction.commit();
                       
                        resp.getWriter().write("0");
//                        resp.sendRedirect("adminpanel.jsp");
                    }
                }
            }

        } catch (Exception e) {
             e.printStackTrace();
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"AddProduct Servlet error");

        }

    }
}
