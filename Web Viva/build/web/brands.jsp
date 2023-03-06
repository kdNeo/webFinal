<%@page import="java.util.List"%>

<option>Select Brand</option>

<%
    List<String> types_list = (List<String>) request.getAttribute("brands_list");
    for (String name : types_list) {
%>

<option><%=name%></option>

<%
    }
%>