<!DOCTYPE html>
<%@page import="database.Product"%>
<%
    Product product = (Product) request.getAttribute("product");
%>
<div class="col">
    <a target="blank" href="<%=product.getImage()%>">
    <img class="card" src="<%=product.getImage()%>" width="400px" height="500px"/>
    </a>
</div>
    <div class="col">
    <div class="form-box">
        <div class="form-bottom">
            <form role="form" action="" method="post" class="registration-form" id="form-addproduct">

               
                <div class="form-group">
                    <div class="row" style="color: #0066cc;font-weight: bold; font-family: monospace;">
                        <h3><label><%=product.getPname()%></label></h3>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <h3><label>LKR <%=product.getPrice()%></label></h3>
                    </div>
                </div>
                    
                <div class="form-group">
                    <div class="row" style="color: #009900;font-weight: bold; font-family: monospace;">
                        <h4><p style="word-break: break-all;"><%=product.getDescription()%></p></h4>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <h5><label style="color: #cc0000; font-family: monospace;font-weight: bold;font-size: x-large;">Available Quantity</label></h5>
                    </div>
                    <div class="row">
                        <h4><label><%=product.getQty()%></label></h4>
                    </div>
                </div>
                    
             
                <div class="form-group">
                    <div class="row">
                        <button class="btn btn-secondary btn-minuse minus" type="button" onclick="minus();">-</button>&nbsp;

                        <input type="text" onkeypress="validate(event)" id="addtocartqty" class="form-control no-padding add-color text-center height-25 w-25"  maxlength="5" minlength="1" value="1" oninput="process(this)" >&nbsp;
                        

                        <button class="btn btn-secondary btn-pluss plus" type="button" onclick="plus();">+</button>

                    </div>
                </div>
                <div class="row">
                    <%
                        if (product.getQty() == 0) {
                    %>
                    <a href="#"><button type="button" class="btn btn-dark" disabled="">Out of Stock</button></a><br/>
                   
                    <%
                    } else {
                    %>
                    <button type="button" class="btn btn-lg btn-dark mr-sm-2" onclick="addToCart(<%=product.getPid()%>);">Add to Cart</button>
                    <%
                        }
                    %>
                   </div><br/>
               <p id="showmessage" style="font-weight: lighter; font-family: Stencil Std, fantasy"></p>
            </form>
                <br/>
        </div>
    </div>
</div>
                  
                   
                     <script src="js/main.js"></script>
