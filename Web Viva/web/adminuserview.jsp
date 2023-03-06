<%@page import="database.User"%>
<%@page import="java.util.List"%>
<table class="table table-hover" name="carttable">
    <thead>
        <tr>
            <th class="w-25" scope="col">Name</th>
            <th class="w-25" scope="col">Email</th>
            <th class="w-25" scope="col">Image</th>
            <th class="w-25" scope="col"></th>
        </tr>
    </thead>
    <tbody id="cartitems">

        <%
            List<User> user_list = (List<User>) request.getAttribute("admin_user_list");

            for (User u : user_list) {

        %>

        <tr>
            <td scope="row"><%=u.getName()%></td>
            <td><%=u.getEmail()%></td>
            <td><img src="<%=u.getImage()%>" width="60" height="60"/></td>

            <%
                if (u.getStatus() == 1) {
            %>
            <td><button type="button" class="btn btn-danger" onclick="changeUserStatus('<%=u.getEmail()%>', 0);">Deactivate</button></td>
            <%
            } else {
            %>
            <td><button type="button" class="btn btn-success" onclick="changeUserStatus('<%=u.getEmail()%>', 1);">Activate</button></td>
            <%
                }
            %>
        </tr>

        <%    }
        %>
    </tbody>
</table>
