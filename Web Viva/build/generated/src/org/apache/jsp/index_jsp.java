package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import org.hibernate.criterion.Order;
import database.Editslider;
import org.hibernate.criterion.Restrictions;
import database.Suspend;
import org.hibernate.Criteria;
import org.hibernate.Session;
import database.NewHibernateUtil;
import org.hibernate.SessionFactory;
import database.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Strong Drinks Shop</title>\n");
      out.write("\n");
      out.write("        <link rel=\"icon\" href=\"resources/stronglogo.jpg\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .slidecontainer {\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            .slider {\n");
      out.write("                -webkit-appearance: none;\n");
      out.write("                width: 100%;\n");
      out.write("                height: 15px;\n");
      out.write("                border-radius: 5px;  \n");
      out.write("                background: #d3d3d3;\n");
      out.write("                outline: none;\n");
      out.write("                opacity: 0.7;\n");
      out.write("                -webkit-transition: .2s;\n");
      out.write("                transition: opacity .2s;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .slider::-webkit-slider-thumb {\n");
      out.write("                -webkit-appearance: none;\n");
      out.write("                appearance: none;\n");
      out.write("                width: 25px;\n");
      out.write("                height: 25px;\n");
      out.write("                border-radius: 50%; \n");
      out.write("                background: #4CAF50;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .slider::-moz-range-thumb {\n");
      out.write("                width: 25px;\n");
      out.write("                height: 25px;\n");
      out.write("                border-radius: 50%;\n");
      out.write("                background: #4CAF50;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("    <body style=\"background-color:#ECE6E6;\" onload=\"getCartQuantity();\n");
      out.write("          ");

              if (request.getParameter("catagory") != null && request.getParameter("value") != null) {

          
      out.write("\n");
      out.write("\n");
      out.write("            loadCatagories(1);\n");
      out.write("\n");
      out.write("          ");
          } else if (request.getParameter("searchname") != null) {
          
      out.write("\n");
      out.write("            loadCatagories(2);\n");
      out.write("          ");

          } else {
          
      out.write("\n");
      out.write("            loadCatagories(null);\n");
      out.write("          ");

              }
          
      out.write("\n");
      out.write("          \">\n");
      out.write("\n");
      out.write("        <div id=\"loader\"></div>\n");
      out.write("        <div id=\"content\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\" \n");
      out.write("                 style=\"position: fixed;top: 0;\n");
      out.write("                 left: 0;\n");
      out.write("                 z-index: 9999;\n");
      out.write("                 width: 100%;\n");
      out.write("                 height: 50px;\n");
      out.write("                 background-color: #00a087;\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"index.jsp\">\n");
      out.write("                    <img src=\"resources/stronglogo.jpg\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n");
      out.write("                    Strong Drinks Shop\n");
      out.write("                </a>\n");
      out.write("                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                    <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("                </button>\n");
      out.write("\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                    <ul class=\"navbar-nav mr-auto\">\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\" onclick=\"searchProductsbyCatagory(0, this.innerHTML)\" id=\"navbarDropdown1\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Soft Drinks</a>\n");
      out.write("                        </li>\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\" onclick=\"searchProductsbyCatagory(0, this.innerHTML)\" id=\"navbarDropdown2\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Health Drinks</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\" onclick=\"searchProductsbyCatagory(0, this.innerHTML)\" id=\"navbarDropdown3\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Energy Drinks</a>\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <a class=\"nav-link\" href=\"#\" onclick=\"searchProductsbyCatagory(0, this.innerHTML)\" id=\"navbarDropdown4\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">Waters</a>\n");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <li class=\"nav-item\">\n");
      out.write("                            <div class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                                <input onkeyup=\"onkeycase()\" onkeypress=\"validateAlpa(event)\" oninput=\"processAlpa(this)\" maxlength=\"20\" minlength=\"1\" class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" size=\"30\" aria-label=\"Search\" id=\"homesearch\">         \n");
      out.write("                                <button class=\"btn btn-outline-light my-2 my-sm-0\" type=\"button\" onclick=\"searchProducts(0);\">Search</button>\n");
      out.write("                            </div>\n");
      out.write("                        </li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        if (session.getAttribute("user") != null) {

                            User user = (User) session.getAttribute("user");

                    
      out.write("\n");
      out.write("                    <!--if signed in-->\n");
      out.write("                    <div class=\"dropdown\">\n");
      out.write("                        <button class=\"btn btn-secondary dropdown-toggle mr-3\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n");
      out.write("                            ");
      out.print(user.getName().split(" ")[0]);
      out.write("\n");
      out.write("                        </button>\n");
      out.write("                        <div class=\"dropdown-menu dropdown-menu-right\" aria-labelledby=\"dropdownMenuButton\">\n");
      out.write("\n");
      out.write("                            <a class=\"dropdown-item\" href=\"myprofile.jsp\">My Profile</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"checkouthistory.jsp\">Checkout History</a>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"javascript:logout()\">Log Out</a>\n");
      out.write("\n");
      out.write("                            ");

                                if (user.getEmail().equals("admin@gmail.com") && user.getName().equals("admin") && user.getPassword().equals("12345678")) {
                            
      out.write("\n");
      out.write("                            <div class=\"dropdown-divider\"></div>\n");
      out.write("                            <a class=\"dropdown-item\" href=\"adminpanel.jsp\">Admin Panel</a>\n");
      out.write("                            ");

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
                            
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                    </div>   \n");
      out.write("                    ");

                    } else {

                        SessionFactory factory = NewHibernateUtil.getSessionFactory();
                        Session s = factory.openSession();

                        Criteria criteria = s.createCriteria(Suspend.class);

                        criteria.add(Restrictions.eq("id", 1));

                        Suspend suspend = (Suspend) criteria.uniqueResult();
                        if (suspend.getStatus() == 1) {
                            response.sendRedirect("suspend.jsp");
                        }

                    
      out.write("\n");
      out.write("                    <!--if not signin-->\n");
      out.write("                    <a href=\"login.jsp\"><button type=\"button\" class=\"btn btn-secondary mr-sm-2\">SignIn</button></a>\n");
      out.write("\n");
      out.write("                    ");
                    }
                    
      out.write("\n");
      out.write("\n");
      out.write("                    <a href=\"cart.jsp\"><button onclick=\"loadCart();\" style=\"border-radius: 50%;\" type=\"button\" class=\"btn btn-dark\"><img style=\"width:20px; height: 20px;\" src=\"resources/cart icon 3.svg\"/>&nbsp<span id=\"cartquantity\"></span></button></a>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("\n");
      out.write("                    ");


                        SessionFactory factory = NewHibernateUtil.getSessionFactory();
                        Session s = factory.openSession();
            Criteria cc = s.createCriteria(Editslider.class);
            cc.addOrder(Order.asc("id"));
            List<Editslider> lc = cc.list();
            int i =0;


        
      out.write("\n");
      out.write("            <div id=\"carouselExampleControls\" class=\"carousel slide\" data-ride=\"carousel\">\n");
      out.write("                <div class=\"carousel-inner\">\n");
      out.write("                    ");

                        for (Editslider elem : lc) {
                            
                            if (i== 0) {
                                
                                
      out.write("\n");
      out.write("                    <div class=\"carousel-item active\">\n");
      out.write("                        <img class=\"d-block w-100\" src=\"recources/");
      out.print( elem.getPic() );
      out.write("\" width=\"1366px\" height=\"455px\">\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    ");

                                    
                                }else{

                                
      out.write("\n");
      out.write("                    \n");
      out.write("                    <div class=\"carousel-item\">\n");
      out.write("                        <img class=\"d-block w-100\" src=\"recources/");
      out.print( elem.getPic() );
      out.write("\" width=\"1366px\" height=\"455px\">\n");
      out.write("                    </div>\n");
      out.write("                    ");

}
i =i+1;
                                
                            }
                    
      out.write("\n");
      out.write("               \n");
      out.write("                </div>\n");
      out.write("                <a class=\"carousel-control-prev\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"prev\">\n");
      out.write("                    <span class=\"carousel-control-prev-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                    <span class=\"sr-only\">Previous</span>\n");
      out.write("                </a>\n");
      out.write("                <a class=\"carousel-control-next\" href=\"#carouselExampleControls\" role=\"button\" data-slide=\"next\">\n");
      out.write("                    <span class=\"carousel-control-next-icon\" aria-hidden=\"true\"></span>\n");
      out.write("                    <span class=\"sr-only\">Next</span>\n");
      out.write("                </a>\n");
      out.write("            </div>\n");
      out.write("            <br>\n");
      out.write("            <br>\n");
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"container-fluid h-100\">     \n");
      out.write("\n");
      out.write("                <div class=\"row h-100\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"col-sm-2\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                        <div class=\"card\" style=\"width: 18rem; margin-top: 24px; padding: 10px;\">\n");
      out.write("                            <div class=\"card-body\">\n");
      out.write("                                <h6><b>Catagory</b></h6>\n");
      out.write("                                <select class=\"selectpicker col\" data-style=\"btn-info\" id=\"form-product-type\" onclick=\"advanceSearchLoadBrands1();\">\n");
      out.write("\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("                                <br/><br/>\n");
      out.write("\n");
      out.write("                                <h6><b>Brand</b></h6>\n");
      out.write("                                <select class=\"selectpicker col\" data-style=\"btn-info\" id=\"form-brand\">\n");
      out.write("\n");
      out.write("                                </select>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <br/><br/>\n");
      out.write("\n");
      out.write("                                <h6><b>Price</b></h6>\n");
      out.write("                                <div class=\"slidecontainer\">\n");
      out.write("                                    <input type=\"range\" min=\"0\" max=\"10000\" value=\"0\" class=\"custom-range\" id=\"myRange1\"/><br/>\n");
      out.write("                                    <input type=\"text\" onkeypress=\"validate(event)\" oninput=\"process(this)\" id=\"showpricefrom\" maxlength=\"5\" minlength=\"1\"  value=\"0\"/><br/>\n");
      out.write("                                    <input type=\"range\" min=\"0\" max=\"10000\" value=\"0\" class=\"custom-range\" id=\"myRange2\"/><br/>\n");
      out.write("                                    <input type=\"text\" onkeypress=\"validate(event)\" oninput=\"process(this)\" id=\"showpriceto\" maxlength=\"5\" minlength=\"1\" value=\"0\"/>\n");
      out.write("                                </div>\n");
      out.write("\n");
      out.write("                                <br/>\n");
      out.write("\n");
      out.write("                                <h6><b>Order By</b></h6>\n");
      out.write("                                <select class=\"selectpicker col\" data-style=\"btn-info\" id=\"form-orderby\">\n");
      out.write("                                    <option>Select Order</option>\n");
      out.write("                                    <option>Price Low - High</option>\n");
      out.write("                                    <option>Price High - Low</option>\n");
      out.write("                                    <option>Name ASC</option>\n");
      out.write("                                    <option>Name DESC</option>  \n");
      out.write("                                </select>\n");
      out.write("\n");
      out.write("                                <br/><br/>\n");
      out.write("                                <button class=\"btn btn-dark\" onclick=\"searchProducts(0);\">Search</button>\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"col-sm-1\"></div>\n");
      out.write("\n");
      out.write("                    <!--Load Products with pagination-->\n");
      out.write("                    <div class=\"col-sm-9\" id=\"product_list\">\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <script src=\"js/main.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\n");
      out.write("            <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("            <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("\n");
      out.write("            <script>\n");
      out.write("                                    var slider1 = document.getElementById(\"myRange1\");\n");
      out.write("                                    var slider2 = document.getElementById(\"myRange2\");\n");
      out.write("                                    var output1 = document.getElementById(\"showpricefrom\");\n");
      out.write("                                    var output2 = document.getElementById(\"showpriceto\");\n");
      out.write("                                    output1.innerHTML = slider1.value; // Display the default slider value\n");
      out.write("                                    output2.innerHTML = slider2.value; // Display the default slider value\n");
      out.write("\n");
      out.write("                                    // Update the current slider value (each time you drag the slider handle)\n");
      out.write("                                    slider1.oninput = function () {\n");
      out.write("                                        output1.value = this.value;\n");
      out.write("                                    }\n");
      out.write("                                    slider2.oninput = function () {\n");
      out.write("                                        output2.value = this.value;\n");
      out.write("                                    }\n");
      out.write("            </script>\n");
      out.write("            <script>\n");
      out.write("                $(\".pagination\").on('click', 'li', function (e) {\n");
      out.write("                    $(this).parent().find('li.active').removeClass('active');\n");
      out.write("                    $(this).addClass('active');\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("            <div class=\"w3hubs-footer\">\n");
      out.write("\n");
      out.write("                <div class=\"w3hubs-icon\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"https://www.facebook.com/\" target=\"black\"><i class=\"fa fa-facebook\"></i></a></li>\n");
      out.write("\n");
      out.write("                        <li><a href=\"https://twitter.com/\" target=\"black\"><i class=\"fa fa-twitter\"></i></a></li>\n");
      out.write("                        <li><a href=\"https://www.instagram.com/\" target=\"black\"><i class=\"fa fa-instagram\"></i></a></li>\n");
      out.write("                        <li><a href=\"https://www.youtube.com/\" target=\"black\"><i class=\"fa fa-youtube-play\"></i></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"w3hubs-nav\">\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                        <li><a href=\"aboutus.jsp\">About</a></li>\n");
      out.write("                        <li><a href=\"contactus.jsp\">Contact Us</a></li>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <div class=\"w3hubs-nav2\">\n");
      out.write("                    <ul>\n");
      out.write("\n");
      out.write("                        <li><a href=\"#\" title=\"To Top\"><i class=\"fa fa-chevron-down\"></i></a></li>\n");
      out.write("\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"footer-end\">\n");
      out.write("                <p>2020 @ All Rights Reserved | Designed and Developed By: KAVEESHA NADUN DE SILVA</p>\n");
      out.write("            </div>\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
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
