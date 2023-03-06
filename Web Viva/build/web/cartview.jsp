<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="database.User"%>
<%@page import="database.Cart"%>
<%@page import="java.util.List"%>

<table class="table table-hover" name="carttable">
    <thead>
        <tr>
            <th class="w-25" scope="col">Product</th>
            <th class="w-25" scope="col">Price</th>
            <th class="w-25" scope="col">QTY</th>
            <th class="w-25" scope="col">Sub Total</th>
        </tr>
    </thead>
    <tbody id="cartitems">

        <%
            List<Cart> cart_list = (List<Cart>) request.getAttribute("cart_list");

            double total = 0;

            if (cart_list.isEmpty()) {
        %>

        <tr>
            <td scope="row">No Cart Items</td>
        </tr>

        <%
        } else {

            for (Cart c : cart_list) {


        %>

        <tr>
            <td scope="row"><%=c.getProduct().getPname()%></td>
            <td><%=c.getProduct().getPrice()%></td>
            <td><input id="<%="qty" + c.getProduct().getPid()%>" type="number" class="col-sm-4" id="inputZip" maxlength="4" min="1" max="1000" onkeyup="if(parseInt(this.value)>1000){ this.value =1000; return false; }" value="<%=c.getQty()%>"></td>
            <td><%=c.getQty() * c.getProduct().getPrice()%></td>
            <td><button class="btn btn-dark mr-sm-2" onclick="removeCartItem(<%=c.getProduct().getPid()%>);">Remove</button></td>
            <td><button class="btn btn-dark mr-sm-2" onclick="updateCart(<%=c.getProduct().getPid()%>);">Update</button></td>
        </tr>

        <%
                    total += c.getQty() * c.getProduct().getPrice();
                }
            }
        %>

    </tbody>
</table>
  
 
        
         <div class="container-fluid">
                <div class="row">
                    <div class="col">
                        <button type="button" class="btn btn-dark mr-sm-2" onclick="emptyCart();">Empty Cart</button>
                        <br/>
                        <br/>
                        <p id="showmessagev" style="font-weight: bold;"></p>
                        
                      
                    </div>
                    <div class="card float-right border-dark" style="width: 30rem; padding: 10px;">
                        <label for="form-contactno">Contact Number</label>
                        <input type="text" name="form-contactno" placeholder="Contact No..." maxlength="13" minlength="13" onkeypress="validate(event)" oninput="process(this)" class="form-contactno form-control" id="form-contactno" required>
                                <br/>
                                    <label for="form-deliveryaddress">Delivery Address</label>
                                <textarea type="text" name="form-deliveryaddress" placeholder="Delivery Address..." class="form-deliveryaddress form-control" id="form-deliveryaddress" required></textarea>
                                <br/>
                    <p id="showmessage" style="font-weight: bold;"></p>
                    </div>
                </div>
                <br/>

                <div class="row float-right">
                    <div class="card float-right border-dark" style="width: 30rem;">
                        <div class="card-body">
                            <h5>Sub Total</h5>
                            <h4>LKR</h4>
                            <h3 class="card-title"><%=total%></h3>

                            <%
                                if (request.getSession().getAttribute("user") != null) {

                                    User user = (User) request.getSession().getAttribute("user");
                            %>
                             <button id="payhere-payment" class="btn btn-primary" onclick="checkout('<%=total%>','<%=user.getEmail()%>','<%=user.getName()%>');">Proceed to Checkout</button>
                            <!--<button id="payhere-payment" class="btn btn-dark" onclick="addInvoice();">Proceed to Checkout</button>-->
                            <%                } else {
                            %>
                            <button id="payhere-payment" class="btn btn-secondary" disabled>Proceed to Checkout</button>
                            <%
                                }
                            %>
                        </div>
                    </div>
                </div>
            </div>