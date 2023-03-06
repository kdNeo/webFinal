<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Order"%>
<%@page import="database.Editslider"%>
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
        <title>Strong Drinks Shop</title>

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




        <style>
            .slidecontainer {
                width: 100%;
            }
            .slider {
                -webkit-appearance: none;
                width: 100%;
                height: 15px;
                border-radius: 5px;  
                background: #d3d3d3;
                outline: none;
                opacity: 0.7;
                -webkit-transition: .2s;
                transition: opacity .2s;
            }

            .slider::-webkit-slider-thumb {
                -webkit-appearance: none;
                appearance: none;
                width: 25px;
                height: 25px;
                border-radius: 50%; 
                background: #4CAF50;
                cursor: pointer;
            }

            .slider::-moz-range-thumb {
                width: 25px;
                height: 25px;
                border-radius: 50%;
                background: #4CAF50;
                cursor: pointer;
            }
        </style>


    </head>




    <body style="background-color:#ECE6E6;" onload="getCartQuantity();
          <%
              if (request.getParameter("catagory") != null && request.getParameter("value") != null) {

          %>

            loadCatagories(1);

          <%          } else if (request.getParameter("searchname") != null) {
          %>
            loadCatagories(2);
          <%
          } else {
          %>
            loadCatagories(null);
          <%
              }
          %>
          ">

        <div id="loader"></div>
        <div id="content">



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
                            <a class="nav-link" href="#" onclick="searchProductsbyCatagory(0, this.innerHTML)" id="navbarDropdown1" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Soft Drinks</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#" onclick="searchProductsbyCatagory(0, this.innerHTML)" id="navbarDropdown2" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Health Drinks</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#" onclick="searchProductsbyCatagory(0, this.innerHTML)" id="navbarDropdown3" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Energy Drinks</a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link" href="#" onclick="searchProductsbyCatagory(0, this.innerHTML)" id="navbarDropdown4" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Waters</a>

                        </li>





                        <li class="nav-item">
                            <div class="form-inline my-2 my-lg-0">
                                <input onkeyup="onkeycase()" onkeypress="validateAlpa(event)" oninput="processAlpa(this)" maxlength="20" minlength="1" class="form-control mr-sm-2" type="search" placeholder="Search" size="30" aria-label="Search" id="homesearch">         
                                <button class="btn btn-outline-light my-2 my-sm-0" type="button" onclick="searchProducts(0);">Search</button>
                            </div>
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

                        SessionFactory factory = NewHibernateUtil.getSessionFactory();
                        Session s = factory.openSession();
            Criteria cc = s.createCriteria(Editslider.class);
            cc.addOrder(Order.asc("id"));
            List<Editslider> lc = cc.list();
            int i =0;


        %>
            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <%
                        for (Editslider elem : lc) {
                            
                            if (i== 0) {
                                
                                %>
                    <div class="carousel-item active">
                        <img class="d-block w-100" src="recources/<%= elem.getPic() %>" width="1366px" height="455px">
                    </div>
                    
                    <%
                                    
                                }else{

                                %>
                    
                    <div class="carousel-item">
                        <img class="d-block w-100" src="recources/<%= elem.getPic() %>" width="1366px" height="455px">
                    </div>
                    <%
}
i =i+1;
                                
                            }
                    %>
               
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
            <br>
            <br>


            <div class="container-fluid h-100">     

                <div class="row h-100">



                    <div class="col-sm-2">



                        <div class="card" style="width: 18rem; margin-top: 24px; padding: 10px;">
                            <div class="card-body">
                                <h6><b>Catagory</b></h6>
                                <select class="selectpicker col" data-style="btn-info" id="form-product-type" onclick="advanceSearchLoadBrands1();">


                                </select>
                                <br/><br/>

                                <h6><b>Brand</b></h6>
                                <select class="selectpicker col" data-style="btn-info" id="form-brand">

                                </select>


                                <br/><br/>

                                <h6><b>Price</b></h6>
                                <div class="slidecontainer">
                                    <input type="range" min="0" max="10000" value="0" class="custom-range" id="myRange1"/><br/>
                                    <input type="text" onkeypress="validate(event)" oninput="process(this)" id="showpricefrom" maxlength="5" minlength="1"  value="0"/><br/>
                                    <input type="range" min="0" max="10000" value="0" class="custom-range" id="myRange2"/><br/>
                                    <input type="text" onkeypress="validate(event)" oninput="process(this)" id="showpriceto" maxlength="5" minlength="1" value="0"/>
                                </div>

                                <br/>

                                <h6><b>Order By</b></h6>
                                <select class="selectpicker col" data-style="btn-info" id="form-orderby">
                                    <option>Select Order</option>
                                    <option>Price Low - High</option>
                                    <option>Price High - Low</option>
                                    <option>Name ASC</option>
                                    <option>Name DESC</option>  
                                </select>

                                <br/><br/>
                                <button class="btn btn-dark" onclick="searchProducts(0);">Search</button>

                            </div>
                        </div>

                    </div>

                    <div class="col-sm-1"></div>

                    <!--Load Products with pagination-->
                    <div class="col-sm-9" id="product_list">



                    </div>

                </div>
            </div>



            <script src="js/main.js"></script>






            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

            <script>
                                    var slider1 = document.getElementById("myRange1");
                                    var slider2 = document.getElementById("myRange2");
                                    var output1 = document.getElementById("showpricefrom");
                                    var output2 = document.getElementById("showpriceto");
                                    output1.innerHTML = slider1.value; // Display the default slider value
                                    output2.innerHTML = slider2.value; // Display the default slider value

                                    // Update the current slider value (each time you drag the slider handle)
                                    slider1.oninput = function () {
                                        output1.value = this.value;
                                    }
                                    slider2.oninput = function () {
                                        output2.value = this.value;
                                    }
            </script>
            <script>
                $(".pagination").on('click', 'li', function (e) {
                    $(this).parent().find('li.active').removeClass('active');
                    $(this).addClass('active');
                });
            </script>



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

        </div>

    </body>

</html>
