
package servlets;

import database.Brand;
import database.NewHibernateUtil;
import database.Product;
import database.Type;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;


public class AdvanceSearchLoadBrands extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            String type = req.getParameter("type");
            
            SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Criteria brandCriteria = session.createCriteria(Brand.class);

            if (type.equals("Select Type")) {
                brandCriteria.setProjection(Projections.distinct(Projections.property("brandname")));

                List<String> brands_list = brandCriteria.list();

                RequestDispatcher rd = req.getRequestDispatcher("brands.jsp");
                req.setAttribute("brands_list", brands_list);
                rd.forward(req, resp);

            } else {
                Criteria typeCriteria = session.createCriteria(Type.class);
                typeCriteria.add(Restrictions.eq("typename", type));

                Type types = (Type) typeCriteria.uniqueResult();
                
                Criteria productCriteria = session.createCriteria(Product.class);
                productCriteria.add(Restrictions.eq("type", types));

                List<Product> product_list = productCriteria.list();
                
                if (product_list.isEmpty()) {
                    brandCriteria.setProjection(Projections.distinct(Projections.property("brandname")));

                    List<String> brands_list = brandCriteria.list();

                    RequestDispatcher rd = req.getRequestDispatcher("brands.jsp");
                    req.setAttribute("brands_list", brands_list);
                    rd.forward(req, resp);
                } else {
//                    for (Product p : product_list) {
//                        System.out.println(p.getBrand().getBid());
//                        brandCriteria.add(Restrictions.eq("bid", p.getBrand().getBid()));
//                    }
//
//                    Brand brands = (Brand) brandCriteria.uniqueResult();
//                    productCriteria.add(Restrictions.eq("brand", brands));
//                    System.out.println("aaa"+brands.getBrandname());
//                    brandCriteria.setProjection(Projections.distinct(Projections.property("brandname")));
//
//                    List<String> brands_list = brandCriteria.list();
//                   
//                    RequestDispatcher rd = req.getRequestDispatcher("brands.jsp");
//                    req.setAttribute("brands_list", brands_list);
//                    rd.forward(req, resp);

        Query query = session.createSQLQuery("SELECT b.brandname FROM Brand b inner join Product p inner join Type t ON p.brand_bid=b.bid and p.type_tid=t.tid and t.typename='"+type+"'");
                    List<String> list = query.list();
                    Set<String> brands_set = new HashSet<>();
                    
                    for(String s:list){
                        brands_set.add(s);
                        System.out.println(s+"sample");
                    }
                    List<String> brands_list = new ArrayList<>(brands_set);
                  
                    RequestDispatcher rd = req.getRequestDispatcher("brands.jsp");
                    req.setAttribute("brands_list", brands_list);
                    rd.forward(req, resp);
                }
            }
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
             String appPath=getServletContext().getRealPath("");
        Log4j.exceptionss(appPath,e.getMessage()+" "+"-"+"AdvanceSearchLoadBrands Servlet error");
        }

    }
}
