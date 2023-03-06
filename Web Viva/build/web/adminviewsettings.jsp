<%-- 
    Document   : adminviewsettings
    Created on : Jul 26, 2020, 1:02:37 AM
    Author     : Kaveesha Nadun
--%>

<%@page import="java.util.List"%>
<%@page import="database.Editslider"%>
<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="database.Suspend"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
<div>
    <div class="row">
        <div class="col-6">
            <h4>Logger Control</h4>
            <button class="button" onclick="adminViewNotePad();" style="vertical-align:middle"><span>View Logger </span></button>


            <style>
                .button {
                    display: inline-block;
                    border-radius: 4px;
                    background-color: #cc0000;
                    border: none;
                    color: #FFFFFF;
                    text-align: center;
                    font-size: 20px;
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




            <br>
            <br>


            <form action="Suspendeds" method="POST" enctype="multipart/form-data">
                <h4>Suspend Control</h4>
                <textarea id="text" placeholder="Type your message here and choose a image below..." name="w3review" rows="4" cols="50"></textarea>
                <br>
                <label for="img">Select Image :</label>
                <input type="file" name="img"/>

                <%
                    SessionFactory factory = NewHibernateUtil.getSessionFactory();
                    Session s = factory.openSession();

                    Criteria criteria = s.createCriteria(Suspend.class);

                    criteria.add(Restrictions.eq("id", 1));

                    Suspend suspend = (Suspend) criteria.uniqueResult();

                    if (suspend.getStatus() != 1) {

                %>

                <br>
                <input type="submit" value="Suspend"/>

                <%                            } else {

                %>

                <br>
                <input onclick="active();" type="button" value="Suspended" style="color: red"/>

            </form>    

            <%                                }


            %>


        </div>
        <div class="col-6">
            <h4>Slider Control</h4>
            <div class="row">

                <div class="col-6 alert-warning" style="height: 150px;">
                    <br>
                    <form action="SaveSliders" method="POST" >

                    </form>
                    <form action="SaveSliders" method="POST" enctype="multipart/form-data">
                        <label for="img">Select Image :</label>
                        <input type="file" name="imageSlider"/>

                        <input type="submit" value="Save Slider Details" style="color: red"/>

                    </form>
                </div>
                <div class="col-6"  id="deleteSlider">

                    <div class="col-lg-12 col-md-8 col-sm-10 mx-auto table-responsive" style="height: 150px;">

                        <div class="col-12">
                            <table class="table table-bordered table-hover table-sm">
                                <thead>
                                    <tr>
                                        <th>Photo</th>

                                        <th>Option</th>

                                    </tr>
                                </thead>

                                <tbody>
                                    <%                                                Criteria cc = s.createCriteria(Editslider.class);
                                        List<Editslider> l = cc.list();
                                        for (Editslider list : l) {

                                    %>
                                    <tr>
                                        <td style="width: 100%; height: 100%;">
                                            <img src="recources/<%= list.getPic()%>" class="img-fluid" width="100%" height="100%">

                                        </td>


                                        <td>
                                            <form action="DeleteSlider" method="GET">

                                                <button name="id" value="<%= list.getId()%>">Delete</button>
                                            </form>
                                        </td>



                                    </tr>

                                    <%

                                        }
                                    %>


                                </tbody>
                            </table>
                        
                        
                        </div>
                    </div>
              
                </div>
                        
                                    
            </div>
        </div>


    </div>
     <br>
     <br>
      <div id="coti" onload="loadContacts();">                         
  
     </div>           
</div>
                                    <script type="text/javascript" src="js/main.js"></script>
    </body>
</html>
                                  

