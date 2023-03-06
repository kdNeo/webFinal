<%@page import="database.CartHasInvoice"%>
<%@page import="database.Invoice"%>
<%@page import="java.util.List"%>
<table class="table table-bordered w-100 border border-dark">
    <thead>
        <tr>
            <th>Invoice ID</th>
            <th>Product Name</th>
            <th>Qty</th>
            <th>Price</th>
            <th>Sub Total</th>
            <th colspan="2"></th>
        </tr>
    </thead>
    <tbody id="cartitems">

        <%
            List<Invoice> invoice_list = (List<Invoice>) request.getAttribute("invoice_list");
            List<CartHasInvoice> carthasinvoice_list = (List<CartHasInvoice>) request.getAttribute("carthasinvoice_list");

            if (invoice_list.isEmpty()) {
        %>

        <tr>
            <td scope="row">No Purchase History</td>
        </tr>

        <%
        } else {
            for (Invoice i : invoice_list) {
                int count = 0;
                for (CartHasInvoice chi : carthasinvoice_list) {
                    if (chi.getInvoice().getInvid().equals(i.getInvid())) {
                        count++;
                    }
                }
        %>



        <%
            if (count == 1) {
        %>
        <tr>
            <td><%="INV " + i.getInvid()%></td>

            <%
                for (CartHasInvoice chi : carthasinvoice_list) {

                    if (chi.getInvoice().getInvid().equals(i.getInvid())) {
                        
            %>


            <td><%=chi.getCart().getProduct().getPname()%></td>
            <td><%=chi.getCart().getQty()%></td>
            <td><%=chi.getCart().getProduct().getPrice()%></td>
            <td><%=i.getTotal()%></td>
           
            <%
                if (i.getStatus() == 1) {
            %>
            <td><label type="button" class="btn btn-success">Delivered</label></td>
            <%
            } else {
            %>
            <td><Button type="button" class="btn btn-secondary" onclick="markasDelivered('<%=i.getInvid() %>')">Mark As Delivered</Button></td>
            
            <%
                }
            %>

            <td><a href="invoice.jsp?invid=<%=i.getInvid()%>" target="_blank"><Button type="button" class="btn btn-secondary">View</Button></a></td>
            
            <%
                    }
                }
            %>
        </tr>

        <%
        } else {
        %>

        <%
            int count1 = 0;
            for (CartHasInvoice chi : carthasinvoice_list) {

                if (chi.getInvoice().getInvid().equals(i.getInvid())) {
                    count1++;
                    
                    if (count1 == 1) {
        %>

        <tr> 
            <td rowspan="<%=count%>"><%="INV " + i.getInvid()%></td>
            <td><%=chi.getCart().getProduct().getPname()%></td>
            <td><%=chi.getCart().getQty()%></td>
            <td><%=chi.getCart().getProduct().getPrice()%></td>
            <td rowspan="<%=count%>"><%=i.getTotal()%></td>
            
            <%
                if (i.getStatus() == 1) {
            %>
            <td rowspan="<%=count%>"><label type="button" class="btn btn-success">Delivered</label></td>
            <%
            } else {
            %>
            <td rowspan="<%=count%>"><Button type="button" class="btn btn-secondary" onclick="markasDelivered('<%=i.getInvid() %>')">Mark As Delivered</Button></td>
            <%
                }
            %>
            
            <td rowspan="<%=count%>"><a href="invoice.jsp?invid=<%=i.getInvid()%>" target="_blank"><Button type="button" class="btn btn-secondary">View</Button></a></td>
        </tr>
        <%
        } else {
        %>

        <tr> 
            <td><%=chi.getCart().getProduct().getPname()%></td>
            <td><%=chi.getCart().getQty()%></td>
            <td><%=chi.getCart().getProduct().getPrice()%></td>
        </tr>

        <%                
                                }
                            }
                        }
                    }
                }
            }
        %>

    </tbody>
</table>
