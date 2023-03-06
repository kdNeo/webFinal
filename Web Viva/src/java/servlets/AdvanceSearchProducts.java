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

public class AdvanceSearchProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            int value = Integer.parseInt(req.getParameter("value"));
            String catagory = req.getParameter("catagory");
            String brand = req.getParameter("brand");
            String price_from = req.getParameter("price_from");
            String price_to = req.getParameter("price_to");
            String order_by = req.getParameter("order_by");
            String name = req.getParameter("name");

            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria typeCriteria = session.createCriteria(Type.class);
            Criteria brandCriteria = session.createCriteria(Brand.class);
            Criteria productCriteria = session.createCriteria(Product.class);

            if (!name.isEmpty()) {
                productCriteria.add(Restrictions.like("pname", name, MatchMode.ANYWHERE));
            }

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

            //price eken search eka gahanawa
            double from;
            if (price_from.isEmpty()) {
                from = 0;
            } else {
                try {
                    from = Double.parseDouble(price_from);
                } catch (Exception e) {
                    from = 0;
                }
            }

            productCriteria.add(Restrictions.ge("price", from));//grater than equal

            double to;
            if (price_to.isEmpty()) {
                to = 0;
            } else {
                try {
                    to = Double.parseDouble(price_to);

                    if (to > from) {

                        productCriteria.add(Restrictions.le("price", to));//less than equal

                    }

                } catch (Exception e) {
                }
            }

            if (order_by.equals("Price Low - High")) {
                productCriteria.addOrder(Order.asc("price"));//price eka assending
            } else if (order_by.equals("Price High - Low")) {
                productCriteria.addOrder(Order.desc("price"));//price eka descending
            } else if (order_by.equals("Name ASC")) {
                productCriteria.addOrder(Order.asc("pname"));//model eka ascending
            } else if (order_by.equals("Name DESC")) {
                productCriteria.addOrder(Order.desc("pname"));//model eka descending
            }

            productCriteria.add(Restrictions.eq("status", 1));//status eka 1 wena product ganne

            productCriteria.add(Restrictions.gt("qty", 0));//product greater than qty 0

            productCriteria.add(Restrictions.gt("expiry", new Date()));//not expired products

            //productCriteria.addOrder(Order.asc("expiry"));//home eke load
            productCriteria.addOrder(Order.desc("pid")); //

            int count = productCriteria.list().size();
            int pagecount = count / 9;

            if (count % 9 != 0) {
                pagecount++;
            }

            productCriteria.setFirstResult(value);
            productCriteria.setMaxResults(9);

            List<Product> product_list = productCriteria.list();

            ArrayList<Product> allProducts = new ArrayList<Product>();
            ArrayList<Product> toberemoved = new ArrayList<Product>();

            for (Product product : product_list) {
                for (Product product1 : product_list) {
                    if ((product1.getPname()).equals(product.getPname())) {
                        boolean b = true;
                        if ((product1.getPid()).equals(product.getPid())) {
                            if (product.getQty() > 0) {
                                if (!(product1.getExpiry()).before(new Date())) {
                                   // System.out.println(product.getPname() + " || Qty is Greater than 0 || Product is not Expired ||");
                                    b = true;
                                }
                            }
                        } else {
                            for (Product product2 : allProducts) {
                               // System.out.println("im having same name different pid " + product.getPid() + " " + product.getPname());
                                if (product2.equals(product1)) {
                                   // System.out.println("im the same product " + product1.getPid());
                                    toberemoved.add(product2);
                                }
                                b = false;
                            }
                        }

                        if (b) {
                            allProducts.add(product);
                        }

                    }
                }

            }

            for (Product product : toberemoved) {
                allProducts.remove(product);
                //System.out.println("this have been removed " + product.getPid());
            }

//            if (product_list.isEmpty()) {
            if (allProducts.isEmpty()) {
                resp.getWriter().write("<div class=\"container\">"
                        + "<div class=\"row\">"
                        + "<h3>No Results Found. Please Refresh the Page</h3>"
                        + "</div></div>");
            } else {
                RequestDispatcher rd = req.getRequestDispatcher("productview.jsp");
//                req.setAttribute("product_list", product_list);
                req.setAttribute("product_list", allProducts);
                req.setAttribute("pageCount", pagecount);
                rd.forward(req, resp);
            }

            session.close();

        } catch (Exception e) {
            
            e.printStackTrace();
            
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"AdvanceSearchProducts Servlet error");
        }

    }
}
