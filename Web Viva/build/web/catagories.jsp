<%@page import="java.util.List"%>

<option>Select Catagory</option>

<%
    List<String> types_list = (List<String>) request.getAttribute("types_list");
    for (String name : types_list) {
%>

<option><%=name%></option>

<%
    }
%>