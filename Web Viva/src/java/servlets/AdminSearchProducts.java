package servlets;

import database.Brand;
import database.NewHibernateUtil;
import database.Product;
import database.Type;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AdminSearchProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String catagory = req.getParameter("catagory");
            String brand = req.getParameter("brand");
            String name = req.getParameter("name");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria typeCriteria = session.createCriteria(Type.class);
            Criteria brandCriteria = session.createCriteria(Brand.class);
            Criteria productCriteria = session.createCriteria(Product.class);

            if (!catagory.equals("Select Catagory")) {
                typeCriteria.add(Restrictions.eq("typename", catagory));
                Type types = (Type) typeCriteria.uniqueResult();
                productCriteria.add(Restrictions.eq("type", types));
            }

            if (!brand.equals("Select Brand")) {
                brandCriteria.add(Restrictions.eq("brandname", brand));
                Brand brands = (Brand) brandCriteria.uniqueResult();
                productCriteria.add(Restrictions.eq("brand", brands));
            }
            if (!name.isEmpty()) {
                productCriteria.add(Restrictions.like("pname", name, MatchMode.ANYWHERE));
            }

            productCriteria.addOrder(Order.desc("status"));
           //  productCriteria.addOrder(Order.asc("expiry"));
          //   productCriteria.add(Restrictions.gt("expiry", new Date()));//not expired products

            List<Product> product_list = productCriteria.list();


            if (product_list.isEmpty()) {
                resp.getWriter().write("0");
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("adminproductsearchview.jsp");
                req.setAttribute("admin_product_list", product_list);
                rd.forward(req, resp);
            }
            session.close();

        } catch (Exception e) {
              e.printStackTrace();
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"AdminSearchProducts Servlet error");
        }

    }
}
