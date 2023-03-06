/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Contactus;
import database.NewHibernateUtil;
import database.User;
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
public class ValidateOTP extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("code", Integer.parseInt(req.getParameter("code"))));
        if (!criteria.list().isEmpty()) {

    User uniqueResult = (User) criteria.uniqueResult();

    uniqueResult.setStatus (1);
    session.update (uniqueResult);

    Transaction ts = session.beginTransaction();

    ts.commit ();
    resp.sendRedirect("login.jsp");

    //working donen
        } else {
//code error
 resp.sendRedirect("signup.jsp");
        }
    
}

}
