<%-- 
    Document   : Emailverify
    Created on : Jul 29, 2020, 3:54:43 PM
    Author     : Kaveesha Nadun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <form action="ValidateOTP" method="GET" >
                        
           <input type="text" name="code"/>

                        <input type="submit" value="Save "/>

                    </form>
    </body>
</html>
