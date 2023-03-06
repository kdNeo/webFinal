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
        <title>Update Product</title>

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
    <body onload="getCartQuantity();">

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
                        <a class="nav-link" href="#" onclick="searchProductsbyCatagory(0, this)" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Soft Drinks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="searchProductsbyCatagory(0, this)" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Health Drinks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="searchProductsbyCatagory(0, this)" id="navbarDropdown3" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Energy Drinks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="#" onclick="searchProductsbyCatagory(0, this)" id="navbarDropdown4" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Waters</a>

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

        <%
            String pid = request.getParameter("pid");
            String pname = request.getParameter("pname");
            String pdescription = request.getParameter("pdescription");
            String ptype = request.getParameter("ptype");
            String brand = request.getParameter("brand");
            String price = request.getParameter("price");
            String qty = request.getParameter("qty");
            String image = request.getParameter("image");
            String expiry = request.getParameter("expiry");

           // System.out.println(expiry + " what now");
        %>

        <br/>
        <br/>
        <br/>
        <div class="container">
            <h2>Update Product</h2>
            <br/>
            <div class="row">
                <div class="col-sm-5">
                    <div class="form-box">
                        <div class="form-bottom">
                            <form role="form" action="UpdateProduct" method="post" class="registration-form" id="form-addproduct" enctype="multipart/form-data">
                                <div class="form-group">
                                    <input type="hidden" name="hidden-product-id" value="<%=pid%>" readonly>
                                    <input type="hidden" name="hidden-product-image" value="<%=image%>" readonly>

                                    <h6>Product Type</h6>
                                    <div class="row ml-1">
                                        <input type="text" value="<%=ptype%>" name="form-product-type" placeholder="Product Name..." class="form-text form-control" id="form-product-name" aria-describedby="passwordHelpBlock" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <h6>Brand</h6>
                                    <div class="row ml-1">
                                        <input type="text" value="<%=brand%>" name="form-product-type" placeholder="Product Name..." class="form-text form-control" id="form-product-name" aria-describedby="passwordHelpBlock" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row ml-1">
                                        <h6>Product Name</h6>
                                        <label class="sr-only" for="form-product-name">Product Name</label>
                                        <input type="text" value="<%=pname%>" name="form-product-name" placeholder="Product Name..." maxlength="40" class="form-text form-control" id="form-product-name" aria-describedby="passwordHelpBlock" required>
                                        <small id="passwordHelpBlock" class="form-text text-muted">(Ex: Product Name - 750ml)</small>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row ml-1">
                                        <label class="sr-only" for="form-product-description">Description</label>
                                        <textarea type="text" name="form-product-description" placeholder="Description..." class="form-text form-control" maxlength="40" id="form-product-description" required><%=pdescription%></textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row ml-1">
                                        <h6>Price</h6>
                                        <label class="sr-only" for="form-password">Price</label>
                                        <input type="number" value="<%=price%>" name="form-price" placeholder="Price..." class="form-price form-control" id="form-price" readonly>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row ml-1">
                                        <h6>Quantity</h6>
                                        <label class="sr-only" for="form-quantity">Quantity</label>
                                        <input type="number" value="<%=qty%>" name="form-quantity" placeholder="Quantity..." min="1" max="1000" class="form-quantity form-control" id="form-quantity" required>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="row ml-1">
                                        <h6>Select Image</h6>
                                        <label class="sr-only" for="form-image">Select Image</label>
                                        <input type="file"  name="form-image" placeholder="Choose Image..." class="form-image form-control" id="form-image">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <div class="row ml-1">
                                        <h6>Expiry</h6>
                                        <label class="sr-only" for="form-expiry">Expiry</label>
                                        <input type="date" value="<%= expiry%>" name="form-expiry" placeholder="Choose Date..." class="form-expiry form-control" id="form-expiry">
                                    </div>
                                </div>


                                <div class="row ml-1">
                                    <button type="submit" class="btn btn-dark mr-sm-2">Update</button>
                                </div>
                            </form>
                        </div>
                        <br/>
                    </div>
                </div>

                <div class="col-sm-5">
                    <div class="card border-dark">
                        <img class="col-md" height="500" src="<%=image%>"/>
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
