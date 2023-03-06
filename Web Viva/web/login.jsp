<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="database.Suspend"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="database.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>

       
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
    <body onload="getCartQuantity();" style="background-color: #cccccc;">
        
        
 <%
                        if (session.getAttribute("user") != null) {
                            
                            response.sendRedirect("index.jsp");

                            User user = (User) session.getAttribute("user");

                    %>
                    <!--if signed in-->
                  

                            <%
                                if (user.getEmail().equals("admin@gmail.com") && user.getName().equals("admin") && user.getPassword().equals("12345678")) {
                            %>
                           
                            
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
                   

                    <%                    }
                    %>
        
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" 
             style="position: fixed;top: 0;
             left: 0;
             z-index: 9999;
             width: 100%;
             height: 50px;
             background-color: #00a087;">
            <a class="navbar-brand" href="index.jsp">
                <img src="resources/stronglogo.jpg" width="30" height="30" class="d-inline-block align-top" alt="">
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


                 <a href="login.jsp"><button type="button" class="btn btn-secondary mr-sm-2">SignIn</button></a>
                <a href="cart.jsp"><button onclick="loadCart();" style="border-radius: 50%;" type="button" class="btn btn-dark"><img style="width:20px; height: 20px;" src="resources/cart icon 3.svg"/>&nbsp<span id="cartquantity"></span></button></a>
                 </div>
        </nav>
        <br/>

        <div class="container">
            <div class="row">
                

                <div style="width: 100%; height: 100%;">
            <img src="resources/background.jpg" style="width: 1538px; height: 667px; margin-left: -295px; margin-top: -25px; opacity: 0.1;"/>
        </div>
                    <br/><br/><br/><br/><br/><br/>
                    
                    <div class="form-box" align="center" 
                         style="background-color: white;
                         width: 35%;
                         border-radius: 5px;
                         padding: 60px; 
                         position: absolute;
                         margin-left: 350px;
                         margin-top: 100px;">
                        
                        
                        
                        <div class="form-top">
                            <div class="form-top-left">
                                <h3 style="font-style: oblique;font-family: sans-serif; font-weight: bold;">Sign In</h3>
                            </div>
                        </div>
                        <br/>
                        <div class="form-bottom">
                            <form role="form" action="JavaScript:signIn()" method="post" class="login-form">
                                <div class="form-group">
                                    <label class="sr-only" for="form-username">Username</label>
                                    <input type="text" name="form-username" placeholder="Username..." maxlength="30" class="form-username form-control" id="form-username" required>
                                </div>
                                <div class="form-group">
                                    <label class="sr-only" for="form-password">Password</label>
                                    <input type="password" name="form-password" placeholder="Password..." maxlength="30" class="form-password form-control" id="form-password" required>
                                </div>
                                <button type="submit" class="btn btn-dark btn-lg mr-sm-2">Sign In</button><br/><br/>
                                <p>Forgot Password? <a href="forgetpassword.jsp">Reset Password</a></p>
                                <p>Don't have an acoount yet? <a href="signup.jsp">Sign Up Now</a></p>
                                <p id="showmessage" style="font-weight: lighter; font-family: Stencil Std, fantasy"></p>
                            </form>
                        </div>
                    </div>

               
            </div>
        </div>

        <script src="js/main.js"></script>
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
