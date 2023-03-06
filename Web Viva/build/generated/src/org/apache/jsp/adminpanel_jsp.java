package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import database.User;

public final class adminpanel_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');

    //if (request.getSession().getAttribute("user") == null) {
       // response.sendRedirect("index.jsp");
   // }

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Panel</title>\n");
      out.write("\n");
      out.write("        <link rel=\"icon\" href=\"resources/stronglogo.jpg\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:100,300,400,500&display=swap\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        <meta name=\"description\" content=\"Free Web tutorials\">\n");
      out.write("        <meta name=\"keywords\" content=\"HTML,CSS,XML,JavaScript\">\n");
      out.write("        <meta name=\"author\" content=\"W3HUBS\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"loadCatagories(); getCartQuantity();\">\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\" \n");
      out.write("             style=\"position: fixed;top: 0;\n");
      out.write("             left: 0;\n");
      out.write("             z-index: 9999;\n");
      out.write("             width: 100%;\n");
      out.write("             height: 50px;\n");
      out.write("             background-color: #00a087;\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.jsp\">\n");
      out.write("                <img src=\"resources/stronglogo.jpg\" width=\"35\" height=\"35\" class=\"d-inline-block align-top\" alt=\"\">\n");
      out.write("                Strong Drinks Shop\n");
      out.write("            </a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\" id=\"navbarCatagory\">\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"index.jsp?catagory=Soft Drinks&value=0\" id=\"navbarDropdown1\" aria-expanded=\"false\">Soft Drinks</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"index.jsp?catagory=Health Drinks&value=0\" id=\"navbarDropdown2\" aria-expanded=\"false\">Health Drinks</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"index.jsp?catagory=Energy Drinks&value=0\" id=\"navbarDropdown3\" aria-expanded=\"false\">Energy Drinks</a>\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"index.jsp?catagory=Waters&value=0\" id=\"navbarDropdown4\" aria-expanded=\"false\">Waters</a>\n");
      out.write("\n");
      out.write("                    </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <form class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                            <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" maxlength=\"30\" onkeypress=\"validateAlpa(event)\" oninput=\"processAlpa(this)\" size=\"30\" aria-label=\"Search\" id=\"homesearch\">         \n");
      out.write("                            <a class=\"btn btn-outline-light my-2 my-sm-0\"   href=\"index.jsp\" onclick=\"this.href='index.jsp?searchname=' + document.getElementById('homesearch').value\" type=\"button\">Search</a>\n");
      out.write("                        </form>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                ");

                    if (session.getAttribute("user") != null) {

                        User user = (User) session.getAttribute("user");
                
      out.write("\n");
      out.write("                <!--if signed in-->\n");
      out.write("                <div class=\"dropdown\">\n");
      out.write("                    <button class=\"btn btn-secondary dropdown-toggle mr-3\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                        ");
      out.print(user.getName().split(" ")[0]);
      out.write("\n");
      out.write("                    </button>\n");
      out.write("                    <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"dropdownMenuButton\">\n");
      out.write("                        <a class=\"dropdown-item\" href=\"myprofile.jsp\">My Profile</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"checkouthistory.jsp\">Checkout History</a>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"javascript:logout()\">Log Out</a>\n");
      out.write("\n");
      out.write("                        ");

                            if (user.getEmail().equals("admin@gmail.com") && user.getName().equals("admin") && user.getPassword().equals("12345678")) {
                        
      out.write("\n");
      out.write("                        <div class=\"dropdown-divider\"></div>\n");
      out.write("                        <a class=\"dropdown-item\" href=\"adminpanel.jsp\">Admin Panel</a>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>   \n");
      out.write("                ");

                } else {
                
      out.write("\n");
      out.write("                <!--if not signin-->\n");
      out.write("                <a href=\"login.jsp\"><button type=\"button\" class=\"btn btn-secondary mr-sm-2\">SignIn</button></a>\n");
      out.write("\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("\n");
      out.write("                <a href=\"cart.jsp\"><button onclick=\"loadCart();\" style=\"border-radius: 50%;\" type=\"button\" class=\"btn btn-dark\"><img style=\"width:20px; height: 20px;\" src=\"resources/cart icon 3.svg\"/>&nbsp<span id=\"cartquantity\"></span></button></a>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("        <br/>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("\n");
      out.write("        <div class=\"container-fluid\">\n");
      out.write("            <!--<br/>-->\n");
      out.write("\n");
      out.write("            <h2 class=\"px-4\">Admin Panel</h2>\n");
      out.write("            <br/>\n");
      out.write("\n");
      out.write("            <ul class=\"nav nav-pills nav-tabs mb-3\" id=\"pills-tab\" role=\"tablist\" onclick=\"adminSearchLoadCatagories();\">\n");
      out.write("                <li class=\"nav-item col\">\n");
      out.write("                    <a class=\"nav-link active\" id=\"pills-home-tab\" data-toggle=\"pill\" href=\"#pills-home\" role=\"tab\" aria-controls=\"pills-add-product\" aria-selected=\"true\">Add Product</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item col\">\n");
      out.write("                    <a class=\"nav-link\" id=\"pills-profile-tab\" data-toggle=\"pill\" href=\"#pills-product\" role=\"tab\" aria-controls=\"pills-view-products\" aria-selected=\"false\">View Products</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item col\" onclick=\"adminViewUsers()\">\n");
      out.write("                    <a class=\"nav-link\" id=\"pills-user-tab\" data-toggle=\"pill\" href=\"#pills-user\" role=\"tab\" aria-controls=\"pills-view-users\" aria-selected=\"false\">View Users</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item col\" onclick=\"adminViewOrders()\">\n");
      out.write("                    <a class=\"nav-link\" id=\"pills-orders-tab\" data-toggle=\"pill\" href=\"#pills-orders\" role=\"tab\" aria-controls=\"pills-view-orders\" aria-selected=\"false\">Orders</a>\n");
      out.write("                </li>\n");
      out.write("                <li class=\"nav-item col\" onclick=\"adminViewSettings();\">\n");
      out.write("                    <a class=\"nav-link\" id=\"pills-settings-tab\" data-toggle=\"pill\" href=\"#pills-settings\" role=\"tab\" aria-controls=\"pills-view-settings\" aria-selected=\"false\">Settings</a>\n");
      out.write("                </li>\n");
      out.write("            </ul>\n");
      out.write("            <div class=\"tab-content\" id=\"pills-tabContent\">\n");
      out.write("                <div class=\"tab-pane fade show active col\" id=\"pills-home\" role=\"tabpanel\" aria-labelledby=\"pills-add-product-tab\">\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-sm-5\">\n");
      out.write("                            <div class=\"form-box\">\n");
      out.write("                                <div class=\"form-bottom\">\n");
      out.write("                                    <form role=\"form\" action=\"\" method=\"post\" class=\"registration-form\" id=\"form-addproduct\" enctype=\"multipart/form-data\" onsubmit=\"return addProduct();\">\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <h6>Product Type</h6>\n");
      out.write("                                            <div class=\"row ml-1\">\n");
      out.write("                                                <select class=\"selectpicker col\" data-style=\"btn-info\" id=\"form-product-type\" onclick=\"loadBrands();\">\n");
      out.write("\n");
      out.write("                                                </select>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <h6>Brand</h6>\n");
      out.write("                                            <div class=\"row ml-1\">\n");
      out.write("                                                <select class=\"selectpicker col\" data-style=\"btn-info\" id=\"form-brand\">\n");
      out.write("\n");
      out.write("                                                </select>\n");
      out.write("\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <div class=\"row ml-1\">\n");
      out.write("                                                <label class=\"sr-only\" for=\"form-product-name\">Product Name</label>\n");
      out.write("                                                <input type=\"text\" name=\"form-product-name\" placeholder=\"Product Name...\" maxlength=\"40\" onkeyup=\"check()\" class=\"form-text form-control\" id=\"form-product-name\" aria-describedby=\"passwordHelpBlock\" required><label id=\"showmessagexx\" style=\"font-weight: bold;font-size: 15px;\"></label>\n");
      out.write("                                                &nbsp;&nbsp; <small id=\"passwordHelpBlock\" class=\"form-text text-muted\">(Ex: Product Name - 750ml)</small>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <div class=\"row ml-1\">\n");
      out.write("                                                <label class=\"sr-only\" for=\"form-product-description\">Description</label>\n");
      out.write("                                                <textarea type=\"text\" name=\"form-product-description\" placeholder=\"Description...\" maxlength=\"40\" class=\"form-text form-control\" id=\"form-product-description\" required></textarea>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <div class=\"row ml-1\">\n");
      out.write("                                                <label class=\"sr-only\" for=\"form-password\">Price</label>\n");
      out.write("                                                <input type=\"number\" name=\"form-price\" placeholder=\"Price...\"  oninput=\"process(this)\"  min=\"50\" max=\"10000\" class=\"form-price form-control\" id=\"form-price\" required>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <div class=\"row ml-1\">\n");
      out.write("                                                <label class=\"sr-only\" for=\"form-quantity\">Quantity</label>\n");
      out.write("                                                <input type=\"number\" name=\"form-quantity\" placeholder=\"Quantity...\"  oninput=\"process(this)\"  min=\"1\" max=\"1000\" class=\"form-quantity form-control\" id=\"form-quantity\" required>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <div class=\"row ml-1\">\n");
      out.write("                                                <label class=\"sr-only\" for=\"form-image\">Select Image</label>\n");
      out.write("                                                <input type=\"file\" name=\"form-image\" placeholder=\"Choose Image...\" class=\"form-image form-control\" id=\"form-image\" required>\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                        <div class=\"form-group\">\n");
      out.write("                                            <div class=\"row ml-1\">\n");
      out.write("                                                <h6>Expiry</h6>\n");
      out.write("                                                <label class=\"sr-only\" for=\"form-expiry\">Expiry</label>\n");
      out.write("                                                <input type=\"date\" name=\"form-expiry\" placeholder=\"Choose Date...\" class=\"form-expiry form-control\" id=\"form-expiry\">\n");
      out.write("                                            </div>\n");
      out.write("                                        </div>       \n");
      out.write("\n");
      out.write("                                        <div class=\"row ml-1\">\n");
      out.write("                                            <button type=\"submit\" class=\"btn btn-dark mr-sm-2\">Add Product</button>\n");
      out.write("                                            <p id=\"showmessage\" style=\"font-weight: bold;\"></p>\n");
      out.write("                                        </div>\n");
      out.write("                                    </form>\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <div class=\"col-sm-5\">\n");
      out.write("                            <button type=\"button\" style=\"margin-top: 90px;\" class=\"btn btn-dark ml-2\" data-toggle=\"modal\" data-target=\"#exampleModal\" data-whatever=\"@mdo\">Add Brand</button>\n");
      out.write("\n");
      out.write("                            <div class=\"modal fade\" id=\"exampleModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"exampleModalLabel\" aria-hidden=\"true\">\n");
      out.write("                                <div class=\"modal-dialog\" role=\"document\">\n");
      out.write("                                    <div class=\"modal-content\">\n");
      out.write("                                        <div class=\"modal-header\">\n");
      out.write("                                            <h5 class=\"modal-title\" id=\"exampleModalLabel\">Add Brand</h5>\n");
      out.write("                                            <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-label=\"Close\">\n");
      out.write("                                                <span aria-hidden=\"true\">&times;</span>\n");
      out.write("                                            </button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-body\">\n");
      out.write("                                            <form>\n");
      out.write("                                                <div class=\"form-group\">\n");
      out.write("                                                    <label for=\"recipient-name\" class=\"col-form-label\">Brand Name</label>\n");
      out.write("                                                    <input type=\"text\" class=\"form-control\" maxlength=\"30\"   oninput=\"processAlpa(this)\" onkeypress=\"validateAlpa(event)\" id=\"brand-name\" required>\n");
      out.write("                                                </div>\n");
      out.write("                                            </form>\n");
      out.write("                                        </div>\n");
      out.write("                                        <div class=\"modal-footer\">\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-dark\" data-dismiss=\"modal\">Close</button>\n");
      out.write("                                            <button type=\"button\" class=\"btn btn-dark\" onclick=\"addBrand();\">Add</button>\n");
      out.write("                                        </div>\n");
      out.write("                                        <p id=\"showmessagebrand\" style=\"font-weight: bold;\"></p>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"tab-pane fade col\" id=\"pills-product\" role=\"tabpanel\" aria-labelledby=\"pills-view-products-tab\">\n");
      out.write("\n");
      out.write("                    <div class=\"card\">\n");
      out.write("                        <div class=\"card-body border border-dark\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("\n");
      out.write("                                <div class=\"col\">\n");
      out.write("                                    <h6>Catagory</h6>\n");
      out.write("                                    <select class=\"selectpicker col\" data-style=\"btn-info\" id=\"form-product-type1\">\n");
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col\">\n");
      out.write("                                    <h6>Brand</h6>\n");
      out.write("                                    <select class=\"selectpicker col\" data-style=\"btn-info\" id=\"form-brand1\">\n");
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col\">\n");
      out.write("                                    <h6>Name</h6>\n");
      out.write("                                    <input class=\"form-control input-sm\" type=\"search\" placeholder=\"Search\"  maxlength=\"40\" size=\"40\" aria-label=\"Search\" id=\"form-name1\"> \n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <div class=\"col\">    \n");
      out.write("                                    <button class=\"btn btn-dark btn-block my-2\" type=\"submit\" onclick=\"adminSearchProducts();\">Search</button>\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <br/>\n");
      out.write("\n");
      out.write("                    <div class=\"container-fluid h-100\">\n");
      out.write("                        <div class=\"row p-4\"  id=\"adminsearchitems\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"tab-pane fade col\" id=\"pills-user\" role=\"tabpanel\" aria-labelledby=\"pills-view-users-tab\">\n");
      out.write("\n");
      out.write("                    <div class=\"container-fluid h-100\">\n");
      out.write("                        <div class=\"row p-4\"  id=\"adminsearchusers\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"tab-pane fade col\" id=\"pills-orders\" role=\"tabpanel\" aria-labelledby=\"pills-view-orders-tab\">\n");
      out.write("\n");
      out.write("                    <div class=\"container-fluid h-100\">\n");
      out.write("                        <div class=\"row p-4\"  id=\"adminvieworders\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <div class=\"tab-pane fade col\" id=\"pills-settings\" role=\"tabpanel\" aria-labelledby=\"pills-view-settings-tab\">\n");
      out.write("\n");
      out.write("                    <div class=\"container-fluid h-100\">\n");
      out.write("                        <div class=\"row p-4\"  id=\"adminviewsettings\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        <br>\n");
      out.write("        <br>\n");
      out.write("        ");
      out.write("\n");
      out.write("        <div class=\"w3hubs-footer\">\n");
      out.write("\n");
      out.write("            <div class=\"w3hubs-icon\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"https://www.facebook.com/\" target=\"black\"><i class=\"fa fa-facebook\"></i></a></li>\n");
      out.write("\n");
      out.write("                    <li><a href=\"https://twitter.com/\" target=\"black\"><i class=\"fa fa-twitter\"></i></a></li>\n");
      out.write("                    <li><a href=\"https://www.instagram.com/\" target=\"black\"><i class=\"fa fa-instagram\"></i></a></li>\n");
      out.write("                    <li><a href=\"https://www.youtube.com/\" target=\"black\"><i class=\"fa fa-youtube-play\"></i></a></li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"w3hubs-nav\">\n");
      out.write("                <ul>\n");
      out.write("                    <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                    <li><a href=\"aboutus.jsp\">About</a></li>\n");
      out.write("                    <li><a href=\"contactus.jsp\">Contact Us</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"w3hubs-nav2\">\n");
      out.write("                <ul>\n");
      out.write("\n");
      out.write("                    <li><a href=\"#\" title=\"To Top\"><i class=\"fa fa-chevron-down\"></i></a></li>\n");
      out.write("\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"footer-end\">\n");
      out.write("             <p>2020 @ All Rights Reserved | Designed and Developed By: KAVEESHA NADUN DE SILVA</p>\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
