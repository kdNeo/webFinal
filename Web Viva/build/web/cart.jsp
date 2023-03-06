

<%@page import="database.Suspend"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="database.Cart"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="database.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>

        <link rel="icon" href="resources/stronglogo.jpg">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500&display=swap">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        
           <%-- footer area--%>
         <meta name="description" content="Free Web tutorials">
  <meta name="keywords" content="HTML,CSS,XML,JavaScript">
  <meta name="author" content="W3HUBS">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="css/style.css">
   <%-- footer area--%>

    </head>
    <body onload="loadCart();">

         <nav class="navbar navbar-expand-lg navbar-dark bg-dark" 
             style="position: fixed;top: 0;
             left: 0;
             z-index: 9999;
             width: 100%;
             height: 50px;
             background-color: #00a087;">
            
            <a class="navbar-brand" href="index.jsp">
                <img src="resources/stronglogo.jpg" width="35" height="35" class="d-inline-block align-top" alt="">
               Strong Drinks Shop
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    
                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?catagory=Soft Drinks&value=0" id="navbarDropdown1" aria-expanded="false">Soft Drinks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?catagory=Health Drinks&value=0" id="navbarDropdown2" aria-expanded="false">Health Drinks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?catagory=Energy Drinks&value=0" id="navbarDropdown3" aria-expanded="false">Energy Drinks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?catagory=Waters&value=0" id="navbarDropdown4" aria-expanded="false">Waters</a>

                    </li>
                  
                   
                    
                   
                    <li class="nav-item">
                        <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" maxlength="30" onkeypress="validateAlpa(event)" oninput="processAlpa(this)" size="30" aria-label="Search" id="homesearch">         
                            <a class="btn btn-outline-light my-2 my-sm-0"   href="index.jsp" onclick="this.href='index.jsp?searchname=' + document.getElementById('homesearch').value" type="button">Search</a>
                        </form>
                    </li>
                </ul>


                <%
                        if (session.getAttribute("user") != null) {

                            User user = (User) session.getAttribute("user");

                    %>
                    <!--if signed in-->
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle mr-3" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <%=user.getName().split(" ")[0]%>
                        </button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">

                            <a class="dropdown-item" href="myprofile.jsp">My Profile</a>
                            <a class="dropdown-item" href="checkouthistory.jsp">Checkout History</a>
                            <a class="dropdown-item" href="javascript:logout()">Log Out</a>

                            <%
                                if (user.getEmail().equals("admin@gmail.com") && user.getName().equals("admin") && user.getPassword().equals("12345678")) {
                            %>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="adminpanel.jsp">Admin Panel</a>
                            <%
                                } else {

                                    SessionFactory factory = NewHibernateUtil.getSessionFactory();
                                    Session s = factory.openSession();

                                    Criteria criteria = s.createCriteria(Suspend.class);

                                    criteria.add(Restrictions.eq("id", 1));

                                    Suspend suspend = (Suspend) criteria.uniqueResult();

                                    if (suspend.getStatus() == 1) {
                                        response.sendRedirect("suspend.jsp");
                                    }

                                }
                            %>
                        </div>
                    </div>   
                    <%
                    } else {

                        SessionFactory factory = NewHibernateUtil.getSessionFactory();
                        Session s = factory.openSession();

                        Criteria criteria = s.createCriteria(Suspend.class);

                        criteria.add(Restrictions.eq("id", 1));

                        Suspend suspend = (Suspend) criteria.uniqueResult();
                        if (suspend.getStatus() == 1) {
                            response.sendRedirect("suspend.jsp");
                        }

                    %>
                    <!--if not signin-->
                    <a href="login.jsp"><button type="button" class="btn btn-secondary mr-sm-2">SignIn</button></a>

                    <%                    }
                    %>

                <a href="cart.jsp"><button onclick="loadCart();" style="border-radius: 50%;" type="button" class="btn btn-dark"><img style="width:20px; height: 20px;" src="resources/cart icon 3.svg"/>&nbsp<span id="cartquantity"></span></button></a>

            </div>
        </nav>
        <br/>
        <br/>
        <br/>
        

        <h2 class="px-4">Shopping Cart</h2>

        <div class="container-fluid h-100">
            <div class="row p-4"  id="cartitems">

               

              


            </div>



           


        </div>

        <script src="js/main.js"></script>
        <script type="text/javascript" src="https://www.payhere.lk/lib/payhere.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        
           
        <%-- footer area--%>
        <div class="w3hubs-footer">
   	  
   	  <div class="w3hubs-icon">
   	  	<ul>
   	  		<li><a href="https://www.facebook.com/" target="black"><i class="fa fa-facebook"></i></a></li>
   	  	
   	  		<li><a href="https://twitter.com/" target="black"><i class="fa fa-twitter"></i></a></li>
   	  		<li><a href="https://www.instagram.com/" target="black"><i class="fa fa-instagram"></i></a></li>
   	  		<li><a href="https://www.youtube.com/" target="black"><i class="fa fa-youtube-play"></i></a></li>
   	  	</ul>
   	  </div>
           
            
   	  <div class="w3hubs-nav">
   	  	<ul>
   	  		<li><a href="index.jsp">Home</a></li>
   	  		<li><a href="aboutus.jsp">About</a></li>
   	  		<li><a href="contactus.jsp">Contact Us</a></li>
   	  		
   	  		

   	  	</ul>
              
   	  </div>
   	 

   	  <div class="w3hubs-nav2">
   	  	<ul>
   	  		
   	  		<li><a href="#" title="To Top"><i class="fa fa-chevron-down"></i></a></li>
   	  		
   	  	</ul>
   	  </div>
   </div>

   <div class="footer-end">
   	   <p>2020 @ All Rights Reserved | Designed and Developed By: KAVEESHA NADUN DE SILVA</p>
   </div>
         <%-- footer area--%>


    </body>
</html>
