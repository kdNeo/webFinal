<%-- 
    Document   : suspend
    Created on : Jul 26, 2020, 9:17:10 PM
    Author     : Kaveesha Nadun
--%>

<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="database.Suspend"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="org.hibernate.Session"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Suspend Page</title>
    </head>
    <body>
        <center>
               <div style="padding: 30px;">
            
            <%
                SessionFactory factory = NewHibernateUtil.getSessionFactory();
            Session s = factory.openSession();
            Transaction transaction = s.beginTransaction();

            Criteria criteria = s.createCriteria(Suspend.class);

            criteria.add(Restrictions.eq("id", 1));
            
            Suspend suspend = (Suspend) criteria.uniqueResult();

            %>
            
            <h1 style="color: #000000;"><%= suspend.getText() %></h1>
        
            <img src="img/<%= suspend.getPath() %>" /><br>

        </div>
         
    </center>
    
    </body>
</html>
