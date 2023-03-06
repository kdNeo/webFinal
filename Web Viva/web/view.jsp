<%@page import="database.Contactus"%>
<%
    Contactus us = (Contactus)request.getSession().getAttribute("id");
%>
<h4>Control Contacts Details</h4>
  <br>
  <h6>Email:</h6>
  <input type="text" id="email" placeholder="<%= us.getEmail()%>" onkeyup="ValidateEmail1()"><br><br>
   <h6>Contact No:</h6>
   <input type="text" id="contact" placeholder="<%= us.getConatctno()%>" maxlength="13" minlength="13"><br><br>
   <h6>Address:</h6>
   <textarea  id="address" rows="4" cols="50" placeholder="<%= us.getAddress()%> "></textarea><br>
   
   
     <input onclick="changeContacts();" style=" background-color: red;
            border: none;
            text-decoration: none;
            color: white;
            padding: 15px 15px;
            margin: 20px 20px;
            width: 100px;
            height:50px;
            cursor: pointer; margin-left: 1px;" type="button" value="Change"/>
     
      <p id="showmessage" style="font-weight: lighter; font-family: Stencil Std, fantasy"></p>