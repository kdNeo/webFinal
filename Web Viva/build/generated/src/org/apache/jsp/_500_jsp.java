package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class _500_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus((Integer)request.getAttribute("javax.servlet.error.status_code"));
    }
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("     <center>\n");
      out.write("         <div style=\"padding: 40px;\">\n");
      out.write("        <h1 style=\"color: #272727;\">500:SERVER ERROR</h1>\n");
      out.write("        <img src=\"resources/5giphy.gif\" /><br>\n");
      out.write("        \n");
      out.write("       \n");
      out.write("         \n");
      out.write("                     <p style=\"font-family: sans-serif;font-weight: bold;\">Do you want to go home? </p>\n");
      out.write("            <img src=\"resources/stronglogo.jpg\" width=\"60\" height=\"60\" /><a href=\"index.jsp\" class=\"button\" style=\"vertical-align:middle; margin-bottom: 54px;\"><span>Yes Please!!! </span></a>\n");
      out.write("        </div>\n");
      out.write("     </center>\n");
      out.write("    <style>\n");
      out.write(".button {\n");
      out.write("  display: inline-block;\n");
      out.write("  border-radius: 4px;\n");
      out.write("  background-color: #272727;\n");
      out.write("  border: none;\n");
      out.write("  color: #FFFFFF;\n");
      out.write("  text-align: center;\n");
      out.write("  font-size: 24px;\n");
      out.write("  padding: 20px;\n");
      out.write("  width: 200px;\n");
      out.write("  transition: all 0.5s;\n");
      out.write("  cursor: pointer;\n");
      out.write("  margin: 5px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".button span {\n");
      out.write("  cursor: pointer;\n");
      out.write("  display: inline-block;\n");
      out.write("  position: relative;\n");
      out.write("  transition: 0.5s;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".button span:after {\n");
      out.write("  content: '\\00bb';\n");
      out.write("  position: absolute;\n");
      out.write("  opacity: 0;\n");
      out.write("  top: 0;\n");
      out.write("  right: -20px;\n");
      out.write("  transition: 0.5s;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".button:hover span {\n");
      out.write("  padding-right: 25px;\n");
      out.write("}\n");
      out.write("\n");
      out.write(".button:hover span:after {\n");
      out.write("  opacity: 1;\n");
      out.write("  right: 0;\n");
      out.write("}\n");
      out.write("</style>\n");
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
