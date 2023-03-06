 <%@page import="database.Suspend"%>
<%@page import="database.Product"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="database.CartHasInvoice"%>
<%@page import="database.User"%>
<%@page import="database.Cart"%>
<%@page import="database.Invoice"%>
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
        <title>Invoice</title>

        <link rel="icon" href="resources/stronglogo.jpg">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500&display=swap">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        
        
       

    </head>
    <body onload="getCartQuantity();">

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
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

        
        <div class="container-fluid">
            <div class="row ml-2 p-2 d-flex justify-content-center">
                <h2>Invoice</h2>
            </div>

            <div class="row mr-2">
                <div class="col">
                    <%
                        String invoiceid = request.getParameter("invid");
                       

                        SessionFactory sessionFactory = NewHibernateUtil.getSessionFactory();
                        Session session1 = sessionFactory.openSession();
                        Transaction transaction = session1.beginTransaction();

                        User user = (User) request.getSession().getAttribute("user");
                        user = (User) session1.load(User.class, user.getEmail());

                        Criteria productCriteria = session1.createCriteria(Product.class);
                        Criteria invoiceCriteria = session1.createCriteria(Invoice.class);
                        Criteria cartCriteria = session1.createCriteria(Cart.class);
                        //Criteria userCriteria = session1.createCriteria(User.class);
                        Criteria carthasinvoiceCriteria = session1.createCriteria(CartHasInvoice.class);

                        invoiceCriteria.add(Restrictions.eq("invid", Integer.valueOf(invoiceid)));
                        Invoice invoice = (Invoice) invoiceCriteria.uniqueResult();
                    %>

                    <div class="card float-right" style="width: 30rem;">
                        <div class="card-body border border-dark">
                            <h6>Invoice ID : INV<%=invoiceid%></h6>
                            <h6>User Name : <%=user.getName()%></h6>
                            <h6>User Email : <%=user.getEmail()%></h6>
                            <h6>Contact No : <%=invoice.getContact()%></h6>
                            <h6>Address : <%=invoice.getAddress()%></h6>
                        </div>
                    </div>
                </div>
            </div>
            <br/>
            <div class="row ml-2 p-2">
                <table class="table table-hover" name="carttable">
                    <thead>
                        <tr>
                            <th class="w-25" scope="col">Product</th>
                            <th class="w-25" scope="col">Price</th>
                            <th class="w-25" scope="col">QTY</th>
                            <th class="w-25" scope="col">Sub Total</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%

                            carthasinvoiceCriteria.add(Restrictions.eq("invoice", invoice));
                            List<CartHasInvoice> cartHasInvoice_list = carthasinvoiceCriteria.list();

                            double total = 0.0;

                            for (CartHasInvoice carthasinvoice : cartHasInvoice_list) {
                              
                                Cart cart = carthasinvoice.getCart();

                                total += cart.getQty() * cart.getProduct().getPrice();

                               
                                Product product = cart.getProduct();
                        %>

                        <tr>
                            <td scope="row"><%=product.getPname()%></td>
                            <td><%=product.getPrice()%></td>
                            <td><%=cart.getQty()%></td>
                            <td><%=cart.getQty() * product.getPrice()%></td>
                        </tr>

                        <%
                                //userCriteria.add(Restrictions.eq("email", cart.getUser()));
                                //User user = (User) userCriteria.uniqueResult();
                            }
                        %>

                    </tbody>
                </table>
            </div>
            <br/><br/>

            <div class="row mr-2 float-right">
                <div class="card float-right" style="width: 30rem;">
                    <div class="card-body border border-dark">
                        <h6>Sub Total</h6>
                        <h5>LKR</h5>
                        <h4 class="card-title"><%=total%></h4>
                    </div>
                    <br/>
                    <div class="row ml-1">
                        <button id="btnprint" class="btn-lg btn-dark" onclick="printReport(<%=invoice.getInvid()%>);">Print Report</button>&nbsp;&nbsp;
                        <a href="index.jsp"><button id="btnback" class="btn-lg btn-dark" >Back To Shopping</button></a>
                    </div>
                    <br/>
                </div>
            </div>
        </div>

        <script src="js/main.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
       
        
       
    </body>
</html>
