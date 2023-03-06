/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import database.Cart;
import database.CartHasInvoice;
import database.Invoice;
import database.NewHibernateUtil;
import database.Product;
import database.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Kaveesha Nadun
 */
public class test extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String parameter = request.getParameter("id");
            String path = request.getSession().getServletContext().getRealPath("/") + "\\WEB-INF\\classes\\reports\\webin.jrxml";
            System.out.println(path);
            File f = new File(path);
           // System.out.println(f.getPath());
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/strongwebnew", "root", "1234");

            InputStream jrxml = new FileInputStream(f);
            System.out.println(jrxml);
            net.sf.jasperreports.engine.JasperReport compileReport = JasperCompileManager.compileReport(jrxml);
            Map<String, Object> hm = new HashMap();
            hm.put("inv", parameter);

            JasperPrint jp = JasperFillManager.fillReport(compileReport, hm, con);
//
            JasperExportManager.exportReportToPdfFile(jp, request.getSession().getServletContext().getRealPath("/") + "down/" + parameter + ".pdf");
            response.getWriter().write("down/" + parameter + ".pdf");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
