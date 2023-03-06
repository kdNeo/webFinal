<%@page import="database.Product"%>
<%@page import="java.util.List"%>

<table class="table table-hover" name="carttable">
    <thead>
        <tr>
            <th class="w-25" scope="col" colspan="2">Product</th>
            <th class="w-25" scope="col">Price</th>
            <th class="w-25" scope="col">QTY</th>
            <th class="w-25" scope="col">Expry</th>
        </tr>
    </thead>
    <tbody id="cartitems">

        <%
            List<Product> product_list = (List<Product>) request.getAttribute("admin_product_list");

            for (Product p : product_list) {

        %>

        <tr>
            <td scope="row"><img src="<%=p.getImage()%>" width="100" height="100"/></td>
            <td><%=p.getPname()%></td>
            <td><%=p.getPrice()%></td>
            <td><%=p.getQty()%></td>
            <td><%= p.getExpiry() %></td>
            <td><a href="productupdate.jsp?pid=<%=p.getPid()%>&pname=<%=p.getPname()%>&pdescription=<%=p.getDescription()%>&brand=<%=p.getBrand().getBrandname()%>&ptype=<%=p.getType().getTypename()%>&price=<%=p.getPrice()%>&qty=<%=p.getQty()%>&image=<%=p.getImage()%>&expiry=<%=p.getExpiry()%>"><button type="button" class="btn btn-dark ml-2">Update</button></a></td>
        <%
                if (p.getStatus() == 1) {
            %>
            <td><button type="button" class="btn btn-danger" onclick="changeProductStatus('<%=p.getPid() %>', 0);">Deactivate</button></td>
            <%
            } else {
            %>
            <td><button type="button" class="btn btn-success" onclick="changeProductStatus('<%=p.getPid()%>', 1);">Activate</button></td>
            <%
                }
            %>
        </tr>

        <%
            }
        %>


    </tbody>
</table>