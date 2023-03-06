
<%
                   
    if (request.getSession().getAttribute("user") == null) {
        response.sendRedirect("index.jsp");
    }
%>

              
               
                      
                       
                        
                  
                
<%@page import="database.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Panel</title>

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
    <body onload="loadCatagories(); getCartQuantity();">

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
                <ul class="navbar-nav mr-auto" id="navbarCatagory">

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
                            }else{
  response.sendRedirect("index.jsp");

}

                        %>
                    </div>
                </div>   
                <%
                } else {
                %>
                <!--if not signin-->
                <a href="login.jsp"><button type="button" class="btn btn-secondary mr-sm-2">SignIn</button></a>

                <%
                    }
                %>

                <a href="cart.jsp"><button onclick="loadCart();" style="border-radius: 50%;" type="button" class="btn btn-dark"><img style="width:20px; height: 20px;" src="resources/cart icon 3.svg"/>&nbsp<span id="cartquantity"></span></button></a>

            </div>
        </nav>
        <br/>
        <br>
        <br>

        <div class="container-fluid">
            <!--<br/>-->

            <h2 class="px-4">Admin Panel</h2>
            <br/>

            <ul class="nav nav-pills nav-tabs mb-3" id="pills-tab" role="tablist" onclick="adminSearchLoadCatagories();">
                <li class="nav-item col">
                    <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-add-product" aria-selected="true">Add Product</a>
                </li>
                <li class="nav-item col">
                    <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-product" role="tab" aria-controls="pills-view-products" aria-selected="false">View Products</a>
                </li>
                <li class="nav-item col" onclick="adminViewUsers()">
                    <a class="nav-link" id="pills-user-tab" data-toggle="pill" href="#pills-user" role="tab" aria-controls="pills-view-users" aria-selected="false">View Users</a>
                </li>
                <li class="nav-item col" onclick="adminViewOrders()">
                    <a class="nav-link" id="pills-orders-tab" data-toggle="pill" href="#pills-orders" role="tab" aria-controls="pills-view-orders" aria-selected="false">Orders</a>
                </li>
                <li class="nav-item col" onclick="adminViewSettings();">
                    <a class="nav-link" id="pills-settings-tab" data-toggle="pill" href="#pills-settings" role="tab" aria-controls="pills-view-settings" aria-selected="false">Settings</a>
                </li>
            </ul>
            <div class="tab-content" id="pills-tabContent">
                <div class="tab-pane fade show active col" id="pills-home" role="tabpanel" aria-labelledby="pills-add-product-tab">
                    <div class="row">
                        <div class="col-sm-5">
                            <div class="form-box">
                                <div class="form-bottom">
                                    <form role="form" action="" method="post" class="registration-form" id="form-addproduct" enctype="multipart/form-data" onsubmit="return addProduct();">
                                        <div class="form-group">
                                            <h6>Product Type</h6>
                                            <div class="row ml-1">
                                                <select class="selectpicker col" data-style="btn-info" id="form-product-type" onclick="loadBrands();">

                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <h6>Brand</h6>
                                            <div class="row ml-1">
                                                <select class="selectpicker col" data-style="btn-info" id="form-brand">

                                                </select>

                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row ml-1">
                                                <label class="sr-only" for="form-product-name">Product Name</label>
                                                <input type="text" name="form-product-name" placeholder="Product Name..." maxlength="40" onkeyup="check()" class="form-text form-control" id="form-product-name" aria-describedby="passwordHelpBlock" required><label id="showmessagexx" style="font-weight: bold;font-size: 15px;"></label>
                                                &nbsp;&nbsp; <small id="passwordHelpBlock" class="form-text text-muted">(Ex: Product Name - 750ml)</small>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row ml-1">
                                                <label class="sr-only" for="form-product-description">Description</label>
                                                <textarea type="text" name="form-product-description" placeholder="Description..." maxlength="40" class="form-text form-control" id="form-product-description" required></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row ml-1">
                                                <label class="sr-only" for="form-password">Price</label>
                                                <input type="number" name="form-price" placeholder="Price..."  oninput="process(this)"  min="50" max="10000" class="form-price form-control" id="form-price" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row ml-1">
                                                <label class="sr-only" for="form-quantity">Quantity</label>
                                                <input type="number" name="form-quantity" placeholder="Quantity..."  oninput="process(this)"  min="1" max="1000" class="form-quantity form-control" id="form-quantity" required>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="row ml-1">
                                                <label class="sr-only" for="form-image">Select Image</label>
                                                <input type="file" name="form-image" placeholder="Choose Image..." class="form-image form-control" id="form-image" required>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <div class="row ml-1">
                                                <h6>Expiry</h6>
                                                <label class="sr-only" for="form-expiry">Expiry</label>
                                                <input type="date" name="form-expiry" placeholder="Choose Date..." class="form-expiry form-control" id="form-expiry">
                                            </div>
                                        </div>       

                                        <div class="row ml-1">
                                            <button type="submit" class="btn btn-dark mr-sm-2">Add Product</button>
                                            <p id="showmessage" style="font-weight: bold;"></p>
                                        </div>
                                    </form>

                                </div>
                            </div>


                        </div>

                        <div class="col-sm-5">
                            <button type="button" style="margin-top: 90px;" class="btn btn-dark ml-2" data-toggle="modal" data-target="#exampleModal" data-whatever="@mdo">Add Brand</button>

                            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="exampleModalLabel">Add Brand</h5>
                                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form>
                                                <div class="form-group">
                                                    <label for="recipient-name" class="col-form-label">Brand Name</label>
                                                    <input type="text" class="form-control" maxlength="30"   oninput="processAlpa(this)" onkeypress="validateAlpa(event)" id="brand-name" required>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-dark" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-dark" onclick="addBrand();">Add</button>
                                        </div>
                                        <p id="showmessagebrand" style="font-weight: bold;"></p>
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>

                </div>

                <div class="tab-pane fade col" id="pills-product" role="tabpanel" aria-labelledby="pills-view-products-tab">

                    <div class="card">
                        <div class="card-body border border-dark">
                            <div class="row">

                                <div class="col">
                                    <h6>Catagory</h6>
                                    <select class="selectpicker col" data-style="btn-info" id="form-product-type1">

                                    </select>
                                </div>

                                <div class="col">
                                    <h6>Brand</h6>
                                    <select class="selectpicker col" data-style="btn-info" id="form-brand1">

                                    </select>
                                </div>

                                <div class="col">
                                    <h6>Name</h6>
                                    <input class="form-control input-sm" type="search" placeholder="Search"  maxlength="40" size="40" aria-label="Search" id="form-name1"> 
                                </div>

                                <div class="col">    
                                    <button class="btn btn-dark btn-block my-2" type="submit" onclick="adminSearchProducts();">Search</button>
                                </div>
                            </div>
                        </div>
                    </div>
                    <br/>

                    <div class="container-fluid h-100">
                        <div class="row p-4"  id="adminsearchitems">


                        </div>
                    </div>

                </div>
                <div class="tab-pane fade col" id="pills-user" role="tabpanel" aria-labelledby="pills-view-users-tab">

                    <div class="container-fluid h-100">
                        <div class="row p-4"  id="adminsearchusers">


                        </div>
                    </div>

                </div>

                <div class="tab-pane fade col" id="pills-orders" role="tabpanel" aria-labelledby="pills-view-orders-tab">

                    <div class="container-fluid h-100">
                        <div class="row p-4"  id="adminvieworders">


                        </div>
                    </div>

                </div>
                <div class="tab-pane fade col" id="pills-settings" role="tabpanel" aria-labelledby="pills-view-settings-tab">

                    <div class="container-fluid h-100">
                        <div class="row p-4"  id="adminviewsettings">


                        </div>
                    </div>

                </div>
            </div>

        </div>

        <script src="js/main.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <br>
        <br>
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
