package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.hibernate.criterion.Restrictions;
import database.Suspend;
import org.hibernate.Criteria;
import org.hibernate.Session;
import database.NewHibernateUtil;
import org.hibernate.SessionFactory;
import database.User;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Login</title>\n");
      out.write("\n");
      out.write("       \n");
      out.write("        <link rel=\"icon\" href=\"resources/stronglogo.jpg\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Roboto:100,300,400,500&display=swap\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.7.2/css/all.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\n");
      out.write("        \n");
      out.write("          ");
      out.write("\n");
      out.write("         <meta name=\"description\" content=\"Free Web tutorials\">\n");
      out.write("  <meta name=\"keywords\" content=\"HTML,CSS,XML,JavaScript\">\n");
      out.write("  <meta name=\"author\" content=\"W3HUBS\">\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=Roboto+Slab\" rel=\"stylesheet\">\n");
      out.write("  <link rel=\"stylesheet\" type=\"text/css\" href=\"css/style.css\">\n");
      out.write("   ");
      out.write("\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body onload=\"getCartQuantity();\" style=\"background-color: #cccccc;\">\n");
      out.write("        \n");
      out.write("        \n");
      out.write(" ");

                        if (session.getAttribute("user") != null) {
                            
                            response.sendRedirect("index.jsp");

                            User user = (User) session.getAttribute("user");

                    
      out.write("\n");
      out.write("                    <!--if signed in-->\n");
      out.write("                  \n");
      out.write("\n");
      out.write("                            ");

                                if (user.getEmail().equals("admin@gmail.com") && user.getName().equals("admin") && user.getPassword().equals("12345678")) {
                            
      out.write("\n");
      out.write("                           \n");
      out.write("                            \n");
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
      out.write("                        \n");
      out.write("                            \n");
      out.write("                            \n");
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
      out.write("                   \n");
      out.write("\n");
      out.write("                    ");
                    }
                    
      out.write("\n");
      out.write("        \n");
      out.write("        <nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\" \n");
      out.write("             style=\"position: fixed;top: 0;\n");
      out.write("             left: 0;\n");
      out.write("             z-index: 9999;\n");
      out.write("             width: 100%;\n");
      out.write("             height: 50px;\n");
      out.write("             background-color: #00a087;\">\n");
      out.write("            <a class=\"navbar-brand\" href=\"index.jsp\">\n");
      out.write("                <img src=\"resources/stronglogo.jpg\" width=\"30\" height=\"30\" class=\"d-inline-block align-top\" alt=\"\">\n");
      out.write("               Strong Drinks Shop\n");
      out.write("            </a>\n");
      out.write("            <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("                <span class=\"navbar-toggler-icon\"></span>\n");
      out.write("            </button>\n");
      out.write("\n");
      out.write("            <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n");
      out.write("                <ul class=\"navbar-nav mr-auto\">\n");
      out.write("                  \n");
      out.write("                   <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"index.jsp?catagory=Soft Drinks&value=0\" id=\"navbarDropdown1\" aria-expanded=\"false\">Soft Drinks</a>\n");
      out.write("                    </li>\n");
      out.write("                    \n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                      <a class=\"nav-link\" href=\"index.jsp?catagory=Health Drinks&value=0\" id=\"navbarDropdown2\" aria-expanded=\"false\">Health Drinks</a>\n");
      out.write("                    </li>\n");
      out.write("                  \n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                         <a class=\"nav-link\" href=\"index.jsp?catagory=Energy Drinks&value=0\" id=\"navbarDropdown3\" aria-expanded=\"false\">Energy Drinks</a>\n");
      out.write("                    </li>\n");
      out.write("                \n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <a class=\"nav-link\" href=\"index.jsp?catagory=Waters&value=0\" id=\"navbarDropdown4\" aria-expanded=\"false\">Waters</a>\n");
      out.write("                       \n");
      out.write("                    </li>\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                 \n");
      out.write("                  \n");
      out.write("                   \n");
      out.write("                  \n");
      out.write("                    <li class=\"nav-item\">\n");
      out.write("                        <form class=\"form-inline my-2 my-lg-0\">\n");
      out.write("                            <input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Search\" maxlength=\"30\" onkeypress=\"validateAlpa(event)\" oninput=\"processAlpa(this)\" size=\"30\" aria-label=\"Search\" id=\"homesearch\">         \n");
      out.write("                            <a class=\"btn btn-outline-light my-2 my-sm-0\"   href=\"index.jsp\" onclick=\"this.href='index.jsp?searchname=' + document.getElementById('homesearch').value\" type=\"button\">Search</a>\n");
      out.write("                        </form>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                 <a href=\"login.jsp\"><button type=\"button\" class=\"btn btn-secondary mr-sm-2\">SignIn</button></a>\n");
      out.write("                <a href=\"cart.jsp\"><button onclick=\"loadCart();\" style=\"border-radius: 50%;\" type=\"button\" class=\"btn btn-dark\"><img style=\"width:20px; height: 20px;\" src=\"resources/cart icon 3.svg\"/>&nbsp<span id=\"cartquantity\"></span></button></a>\n");
      out.write("                 </div>\n");
      out.write("        </nav>\n");
      out.write("        <br/>\n");
      out.write("\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("                \n");
      out.write("\n");
      out.write("                <div style=\"width: 100%; height: 100%;\">\n");
      out.write("            <img src=\"resources/background.jpg\" style=\"width: 1538px; height: 667px; margin-left: -295px; margin-top: -25px; opacity: 0.1;\"/>\n");
      out.write("        </div>\n");
      out.write("                    <br/><br/><br/><br/><br/><br/>\n");
      out.write("                    \n");
      out.write("                    <div class=\"form-box\" align=\"center\" \n");
      out.write("                         style=\"background-color: white;\n");
      out.write("                         width: 35%;\n");
      out.write("                         border-radius: 5px;\n");
      out.write("                         padding: 60px; \n");
      out.write("                         position: absolute;\n");
      out.write("                         margin-left: 350px;\n");
      out.write("                         margin-top: 100px;\">\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        <div class=\"form-top\">\n");
      out.write("                            <div class=\"form-top-left\">\n");
      out.write("                                <h3 style=\"font-style: oblique;font-family: sans-serif; font-weight: bold;\">Sign In</h3>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        <br/>\n");
      out.write("                        <div class=\"form-bottom\">\n");
      out.write("                            <form role=\"form\" action=\"JavaScript:signIn()\" method=\"post\" class=\"login-form\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"sr-only\" for=\"form-username\">Username</label>\n");
      out.write("                                    <input type=\"text\" name=\"form-username\" placeholder=\"Username...\" maxlength=\"30\" class=\"form-username form-control\" id=\"form-username\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <label class=\"sr-only\" for=\"form-password\">Password</label>\n");
      out.write("                                    <input type=\"password\" name=\"form-password\" placeholder=\"Password...\" maxlength=\"30\" class=\"form-password form-control\" id=\"form-password\" required>\n");
      out.write("                                </div>\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-dark btn-lg mr-sm-2\">Sign In</button><br/><br/>\n");
      out.write("                                <p>Forgot Password? <a href=\"forgetpassword.jsp\">Reset Password</a></p>\n");
      out.write("                                <p>Don't have an acoount yet? <a href=\"signup.jsp\">Sign Up Now</a></p>\n");
      out.write("                                <p id=\"showmessage\" style=\"font-weight: lighter; font-family: Stencil Std, fantasy\"></p>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("               \n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script src=\"js/main.js\"></script>\n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\n");
      out.write("        <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\n");
      out.write("        \n");
      out.write("           ");
      out.write("\n");
      out.write("        <div class=\"w3hubs-footer\">\n");
      out.write("   \t  \n");
      out.write("   \t  <div class=\"w3hubs-icon\">\n");
      out.write("   \t  \t<ul>\n");
      out.write("   \t  \t\t<li><a href=\"https://www.facebook.com/\" target=\"black\"><i class=\"fa fa-facebook\"></i></a></li>\n");
      out.write("   \t  \t\n");
      out.write("   \t  \t\t<li><a href=\"https://twitter.com/\" target=\"black\"><i class=\"fa fa-twitter\"></i></a></li>\n");
      out.write("   \t  \t\t<li><a href=\"https://www.instagram.com/\" target=\"black\"><i class=\"fa fa-instagram\"></i></a></li>\n");
      out.write("   \t  \t\t<li><a href=\"https://www.youtube.com/\" target=\"black\"><i class=\"fa fa-youtube-play\"></i></a></li>\n");
      out.write("   \t  \t</ul>\n");
      out.write("   \t  </div>\n");
      out.write("           \n");
      out.write("            \n");
      out.write("   \t  <div class=\"w3hubs-nav\">\n");
      out.write("   \t  \t<ul>\n");
      out.write("   \t  \t\t<li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("   \t  \t\t<li><a href=\"aboutus.jsp\">About</a></li>\n");
      out.write("   \t  \t\t<li><a href=\"contactus.jsp\">Contact Us</a></li>\n");
      out.write("   \t  \t\t\n");
      out.write("   \t  \t\t\n");
      out.write("\n");
      out.write("   \t  \t</ul>\n");
      out.write("              \n");
      out.write("   \t  </div>\n");
      out.write("   \t \n");
      out.write("\n");
      out.write("   \t  <div class=\"w3hubs-nav2\">\n");
      out.write("   \t  \t<ul>\n");
      out.write("   \t  \t\t\n");
      out.write("   \t  \t\t<li><a href=\"#\" title=\"To Top\"><i class=\"fa fa-chevron-down\"></i></a></li>\n");
      out.write("   \t  \t\t\n");
      out.write("   \t  \t</ul>\n");
      out.write("   \t  </div>\n");
      out.write("   </div>\n");
      out.write("\n");
      out.write("   <div class=\"footer-end\">\n");
      out.write("   \t   <p>2020 @ All Rights Reserved | Designed and Developed By: KAVEESHA NADUN DE SILVA</p>\n");
      out.write("   </div>\n");
      out.write("         ");
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
