<%@page import="java.text.DecimalFormat"%>
<%@page import="database.Product"%>
<%@page import="java.util.List"%>

<div class="container">

    <div class="row">

        <%
            List<Product> product_list = (List<Product>) request.getAttribute("product_list");
            DecimalFormat df2 = new DecimalFormat("#,###.00");

            for (Product p : product_list) {
        %>

        <div class="col-sm-4 mt-4">
            <div style="cursor: pointer;" class="card bg-white" style="width: 18rem;">
                <a href="viewsingleproduct.jsp?pid=<%=p.getPid()%>">
                    <img style="padding-top: 10px; padding-bottom: 10px; padding-left: 50px; padding-right: 50px; object-fit: contain;" src="<%=p.getImage()%>" class="card-img-top bg-white" alt="" width="100px" height="250px">
                </a>
                <div class="card-body text-center">
                    <h5 class="card-title text-uppercase"><%=p.getPname().split("-")[0]%></h5>
                    <p class="card-text"><h5 style="color: brown; font-weight: bold;">LKR &nbsp;<%=df2.format(p.getPrice())%></h5></p>
                    <p class="card-text"><%=p.getPname().split("-")[1]%></p>

                    <%
                        if (p.getQty() == 0) {
                    %>
                    <a href="#"><button type="button" class="btn btn-dark" disabled="">Out of Stock</button></a><br/>
                   
                    <%
                    } else {
                    %>
                    <a href='javascript:void();' class="btn btn-dark" onclick="addToCart(<%=p.getPid()%>);">Add to Cart</a><br/>
                    <%
                        }
                    %>
                    <a  href="viewsingleproduct.jsp?pid=<%=p.getPid()%>"><button type="button" class="btn btn-light">View More</button></a>
                </div>
            </div>
        </div>

        <%
            }
        %>
        <br/>
        <br/>
    </div>
</div>

<br/>

<!--Pagination-->
<nav aria-label="...">
    <ul class="pagination justify-content-center">
       

        <%
            //meken check karanne view wela tiyenne palaweni page ekada kiyala, palaweni page eka nam parameters walin enne 0 kiyala,ethakota ena value eka 0 newei nam witharai previous button eka pennanna one
            if (Integer.parseInt(request.getParameter("value")) != 0) {
        %>

        <li class="page-item">
            <a onclick="searchProducts(<%=Integer.parseInt(request.getParameter("value")) - 9%>);" class="font-weight-bold" href="#">Previous</a>
        </li>

        <%
            }
        %>

        <%
            //page count eka aragena integer walata cast karala e count ekata anuwa buttons hadanawa
            Integer count = (Integer) request.getAttribute("pageCount");

            for (int i = 1; i <= count; i++) {

                //methanadi click karana button ekata color ekak set karanawa
                if (Integer.parseInt(request.getParameter("value")) == (i * 9) - 9) {//mekedi balanne button eka click karama ewana value ekai button eka click karama yawana vale ekai ekamada kiyala(e kiyanne pennana page ekata adala button ekada kiyala check karanawa), loop eka yaddi pennala tiyena page ekata adala button eka hambunama eke color eka wenas karanawa
%>

        <li class="page-item active"><a onclick="searchProducts(<%=(i * 9) - 9%>);" class="font-weight-bold" href="#"><%=i%></a></li>

        <%
        } else {
        %>

        <li class="page-item"><a onclick="searchProducts(<%=(i * 9) - 9%>);" class="font-weight-bold" href="#"><%=i%></a></li>

        <%
                }
            }
        %>

        <%
            //meken check karanne view wela tiyenne anthima page ekada kiyala, anthima page eka nam apita eka balaganna puluwan pagecount eka 3n wedi karala ekata 3k ethathu karala,count kiyanne methama pages count eka namuth parameter eke enne ekata 3k ekathu karapu value eka nisa anthima page ekada view wela tiyenne kiyala balaganna puluwan me widiyen
            if (Integer.parseInt(request.getParameter("value")) != (count * 9) - 9) {
        %>

        <li class="page-item">
            <a onclick="searchProducts(<%=Integer.parseInt(request.getParameter("value")) + 9%>);" class="font-weight-bold" href="#">Next</a>
        </li>

        <%
            }
        %>

    </ul>
</nav>