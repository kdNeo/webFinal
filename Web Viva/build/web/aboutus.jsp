<%@page import="org.hibernate.criterion.Restrictions"%>
<%@page import="database.Suspend"%>
<%@page import="org.hibernate.Criteria"%>
<%@page import="org.hibernate.Session"%>
<%@page import="database.NewHibernateUtil"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="database.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>About Us</title>

        <link rel="icon" href="resources/stronglogo.jpg">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500&display=swap">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <%-- footer area--%>
        <meta name="description" content="Free Web tutorials">
        <meta name="keywords" content="HTML,CSS,XML,JavaScript">
        <meta name="author" content="W3HUBS">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <%-- footer area--%>
    </head>
    <body onload="getCartQuantity();">        

        <nav class="navbar navbar-expand-lg navbar-dark bg-dark" 
             style="position: fixed;top: 0;
             left: 0;
             z-index: 9999;
             width: 100%;
             height: 50px;
             background-color: #00a087;">

            <a class="navbar-brand" href="index.jsp">
                <img src="resources/stronglogo.jpg" width="35" height="35" class="d-inline-block align-top" alt="">
                Strong Drinks Shop
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">

                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?catagory=Soft Drinks&value=0" id="navbarDropdown1" aria-expanded="false">Soft Drinks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?catagory=Health Drinks&value=0" id="navbarDropdown2" aria-expanded="false">Health Drinks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?catagory=Energy Drinks&value=0" id="navbarDropdown3" aria-expanded="false">Energy Drinks</a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="index.jsp?catagory=Waters&value=0" id="navbarDropdown4" aria-expanded="false">Waters</a>

                    </li>






                    <li class="nav-item">
                        <form class="form-inline my-2 my-lg-0">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" maxlength="30" onkeypress="validateAlpa(event)" oninput="processAlpa(this)" size="30" aria-label="Search" id="homesearch">         
                            <a class="btn btn-outline-light my-2 my-sm-0"   href="index.jsp" onclick="this.href = 'index.jsp?searchname=' + document.getElementById('homesearch').value" type="button">Search</a>
                        </form>
                    </li>
                </ul>

 <%
                        if (session.getAttribute("user") != null) {

                            User user = (User) session.getAttribute("user");

                    %>
                    <!--if signed in-->
                    <div class="dropdown">
                        <button class="btn btn-secondary dropdown-toggle mr-3" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <%=user.getName().split(" ")[0]%>
                        </button>
                        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenuButton">

                            <a class="dropdown-item" href="myprofile.jsp">My Profile</a>
                            <a class="dropdown-item" href="checkouthistory.jsp">Checkout History</a>
                            <a class="dropdown-item" href="javascript:logout()">Log Out</a>

                            <%
                                if (user.getEmail().equals("admin@gmail.com") && user.getName().equals("admin") && user.getPassword().equals("12345678")) {
                            %>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="adminpanel.jsp">Admin Panel</a>
                            <%
                                } else {

                                    SessionFactory factory = NewHibernateUtil.getSessionFactory();
                                    Session s = factory.openSession();

                                    Criteria criteria = s.createCriteria(Suspend.class);

                                    criteria.add(Restrictions.eq("id", 1));

                                    Suspend suspend = (Suspend) criteria.uniqueResult();

                                    if (suspend.getStatus() == 1) {
                                        response.sendRedirect("suspend.jsp");
                                    }

                                }
                            %>
                        </div>
                    </div>   
                    <%
                    } else {

                        SessionFactory factory = NewHibernateUtil.getSessionFactory();
                        Session s = factory.openSession();

                        Criteria criteria = s.createCriteria(Suspend.class);

                        criteria.add(Restrictions.eq("id", 1));

                        Suspend suspend = (Suspend) criteria.uniqueResult();
                        if (suspend.getStatus() == 1) {
                            response.sendRedirect("suspend.jsp");
                        }

                    %>
                    <!--if not signin-->
                    <a href="login.jsp"><button type="button" class="btn btn-secondary mr-sm-2">SignIn</button></a>

                    <%                    }
                    %>

                <a href="cart.jsp"><button onclick="loadCart();" style="border-radius: 50%;" type="button" class="btn btn-dark"><img style="width:20px; height: 20px;" src="resources/cart icon 3.svg"/>&nbsp<span id="cartquantity"></span></button></a>

            </div>
        </nav>
        <br/>




        <script src="js/main.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <div style="padding:20px; margin-top:-24px;background-image: url(resources//thumb-1920-410585.png);height:564px;background-repeat: no-repeat;">


            <div style="margin-top: 50px;font-size: 60px; color: #fff;margin-left: 550px;">

                <span>About Us</span>
            </div>
            <center>




                <article>
                    <p id="text">Here at Alcohol free , we have the largest range of non-alcoholic drinks in Sri Lanka. Ideal for those who don’t want to drink alcohol!Our mission is to make it easier for you to find great tasting alternatives
                        to alcoholic drinks... </p>

                    <button id="reset" data-bound="true">reset</button>
                </article>
            </center>
        </div>
        <style>


            *{
                box-sizing:border-box;
            }

            html,body{
                width:100%;
                height:100%;
            }

            body{
                margin:0;
                overflow-x: hidden;

            }

            p#text{
                padding : 1em;
                font-family : monospace;
                font-size:2em;
            }
            button#reset{
                margin:auto;
                text-align:center;
                display:block;
                width:250px;
                height:70px;
                background: tan;
                border:0;
                cursor:pointer;
                position: absolute;
                left: 0;
                right:0;

                border-radius:3px;
                font-family : monospace;
                font-size:2em;
            }

            article{
                width:80%;
                margin:auto;
            }
        </style>
        <script>
                    var time = 0;
                    function Gravity(id) {
                        var that = this;
                        var element = document.getElementById(id);
                        var text = element.textContent;
                        var arr = text.split('');

                        this.animate = true;
                        this.floating = true;
                        this.resetTime = 0;

                        this.positionType = getComputedStyle(element).position;

                        this.lerp = function (e, t, i) {
                            return(1 - i) * e + i * t;
                        }
                        this.checkBound = function () {
                            if (element.hasAttribute("data-bound")) {
                                return element.dataset.bound === "true";
                            }
                        }

                        this.useBound = this.checkBound();
                        this.colors = [
                            '#f44336', '#e91e63', '#9c27b0',
                            '#673ab7', '#3f51b5', '#2196f3',
                            '#03a9f4', '#00bcd4', '#009688',
                            '#4caf50', '#8bc34a', '#cddc39',
                            '#ffeb3b', '#ffc107', '#ff9800',
                            '#ff5722', '#795548', '#9e9e9e',
                            '#607d8b'
                        ];

                        this.randomColor = function () {
                            var randNum = Math.floor(Math.random() * this.colors.length);
                            return this.colors[randNum];
                        }

                        this.bounds = this.useBound ? {
                            min: {
                                x: element.offsetLeft,
                                y: element.offsetTop
                            },
                            max: {
                                x: element.offsetLeft + element.offsetWidth,
                                y: element.offsetTop + element.offsetHeight
                            }
                        } : {
                            min: {
                                x: 0,
                                y: 0
                            },
                            max: {
                                x: window.innerWidth,
                                y: window.innerHeight
                            }
                        }

                        this.pointInCircle = function (point, target, radius) {
                            var distsq = (point.x - target.x) * (point.x - target.x) + (point.y - target.y) * (point.y - target.y);
                            return [distsq <= radius * radius, distsq];
                        }

                        function createSpan(text, pos) {
                            var span = document.createElement('span');
                            span.innerHTML = text;
                            span.style.position = "relative";
                            span.style.display = "inline-block";
                            span.style.minWidth = "10px";
                            span.style.color = that.randomColor();
                            span._own = {
                                pos: {
                                    x: 0,
                                    y: 0
                                },
                                vel: {
                                    x: -0.5 + Math.random(),
                                    y: -0.5 + Math.random()
                                },
                                speed: {
                                    x: 1,
                                    y: 1
                                },
                                dir: {
                                    x: 1,
                                    y: 1
                                }
                            }
                            return span;
                        }
                        this.textSpans = [];

                        element.innerHTML = '';

                        arr.forEach(function (t, i) {
                            var el = createSpan(t, {
                                x: 0,
                                y: 0
                            });
                            element.appendChild(el);
                            that.textSpans.push(el);
                        });

                        this.getDim = function () {

                            this.textSpans.forEach(function (t, i) {
                                var offset = {
                                    x: 0,
                                    y: 0
                                }
                                if (that.positionType === 'relative' || that.positionType === 'absolute') {
                                    offset.x = element.offsetLeft
                                    offset.y = element.offsetTop
                                }
                                t._own.real = {
                                    x: offset.x + t.offsetLeft,
                                    y: offset.y + t.offsetTop
                                },
                                        t._own.size = {
                                            x: t.offsetWidth,
                                            y: t.offsetHeight
                                        }

                            });

                        };

                        this.getDim();

                        this.floatText = function () {
                            this.textSpans.forEach(function (t, i) {

                                if (t._own.pos.x + t._own.real.x < that.bounds.min.x || t._own.pos.x + t._own.real.x + t._own.size.x > that.bounds.max.x) {
                                    t._own.dir.x *= -1;
                                }
                                if (t._own.pos.y + t._own.real.y < that.bounds.min.y || t._own.pos.y + t._own.real.y + t._own.size.y > that.bounds.max.y) {
                                    t._own.dir.y *= -1;
                                }
                                t._own.pos.x += (t._own.vel.x * t._own.speed.x) * t._own.dir.x;
                                t._own.pos.y += (t._own.vel.y * t._own.speed.y) * t._own.dir.y;
                                t.style.transform = 'translateX(' + t._own.pos.x + 'px) translateY(' + t._own.pos.y + 'px)';

                            });
                        }
                        this.update = function () {
                            if (this.animate) {
                                if (this.floating) {
                                    this.floatText();
                                } else {
                                    this.floatBackwards();
                                }
                            }
                        }

                        this.floatBackwards = function () {
                            this.textSpans.forEach(function (t, i) {

                                var x = that.lerp(t._own.pos.x, 0, that.resetTime / 10);
                                var y = that.lerp(t._own.pos.y, 0, that.resetTime / 10);

                                t.style.transform = 'translateX(' + x + 'px) translateY(' + y + 'px)';

                            });

                            if (this.resetTime === 10) {
                                this.animate = false;
                                this.resetTime = 0;
                            }
                            this.resetTime++;
                        }
                        this.reset = function () {
                            this.floating = false;
                        }
                        this.restart = function () {
                            this.textSpans.forEach(function (t, i) {
                                t._own.pos.x = 0;
                                t._own.pos.y = 0;
                            });
                            this.floating = true;
                            this.animate = true;
                        }

                        window.onresize = function () {
                            that.getDim();
                        }

                    }

                    var paragraph = new Gravity('text');
                    var gravity = new Gravity('reset');

                    var button = document.getElementById('reset');
                    button.addEventListener('click', function () {
                        if (gravity.animate) {
                            gravity.reset();
                            paragraph.reset();
                        } else {
                            gravity.restart();
                            paragraph.restart();
                        }
                    });

                    var render = function (time) {
                        requestAnimationFrame(render);

                        animation(time);
                    };

//__________ animation

                    function animation(time) {
                        paragraph.update();
                        gravity.update();
                    }
                    ;

//__________

                    render(time);

        </script>



        <%-- footer area--%>
        <div class="w3hubs-footer">

            <div class="w3hubs-icon">
                <ul>
                    <li><a href="https://www.facebook.com/" target="black"><i class="fa fa-facebook"></i></a></li>

                    <li><a href="https://twitter.com/" target="black"><i class="fa fa-twitter"></i></a></li>
                    <li><a href="https://www.instagram.com/" target="black"><i class="fa fa-instagram"></i></a></li>
                    <li><a href="https://www.youtube.com/" target="black"><i class="fa fa-youtube-play"></i></a></li>
                </ul>
            </div>


            <div class="w3hubs-nav">
                <ul>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="aboutus.jsp">About</a></li>
                    <li><a href="contactus.jsp">Contact Us</a></li>



                </ul>

            </div>


            <div class="w3hubs-nav2">
                <ul>

                    <li><a href="#" title="To Top"><i class="fa fa-chevron-down"></i></a></li>

                </ul>
            </div>
        </div>

        <div class="footer-end">
            <p>2020 @ All Rights Reserved | Designed and Developed By: KAVEESHA NADUN DE SILVA</p>
        </div>
        <%-- footer area--%>
    </body>
</html>
