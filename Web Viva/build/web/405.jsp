
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>505 Page</title>
    </head>
    <body>
        <center>
            <div style="padding: 40px;">
        <h1 style="color: #272727;">405:THE REQUEST METHOD IS NOT ALLOWED</h1>
        <img src="resources/405giphy.gif" />
            
          
                     <p style="font-family: sans-serif;font-weight: bold;">Do you want to go home? </p>
            <img src="resources/stronglogo.jpg" width="60" height="60" /><a href="index.jsp" class="button" style="vertical-align:middle; margin-bottom: 54px;"><span>Yes Please!!! </span></a>
       </div>
        </center>
    <style>
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #272727;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 24px;
  padding: 20px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
    </body>
</html>
