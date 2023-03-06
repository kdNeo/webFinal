

//meka 0idan 9 dakwa illkam witrk type krnna pulwun eka
function validate(evt) {
    var theEvent = evt || window.event;

    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /[0-9]|\./;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }
}
//meka a idan z dakwa illkam witrk type krnna pulwun eka
function validateAlpa(evt) {
    var theEvent = evt || window.event;

    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /[A-Za-z]|\./;
    if (!regex.test(key)) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault)
            theEvent.preventDefault();
    }
}
//meka akuru paste krnna bari eka
function process(input){
  let value = input.value;
  let numbers = value.replace(/[^0-9]/g, "");
  input.value = numbers;
}
//meka ilakkma paste krnna abri wenna
function processAlpa(input){
  let value = input.value;
  let letters = value.replace(/[0-9]/g, "");
  input.value = letters;
}
//meka uda search bar eka enter krma wena eka
function onkeycase() {
    var input = document.getElementById("homesearch");
    input.addEventListener("keyup", function (event) {
        if (event.keyCode === 13) {
            event.preventDefault();
            searchProducts(0);
        }
    });

}

 function ValidateEmail() {
          var email = document.getElementById("form-email").value;
       // var lblError = document.getElementById("lblError");
       // lblError.innerHTML = "";
        var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        if (!expr.test(email)) {
           // lblError.innerHTML = "Invalid email address.";
            document.getElementById("showmessage").innerHTML = "Invalid Email Address";
                document.getElementById("showmessage").style.color = 'red';
        }else{
             document.getElementById("showmessage").innerHTML = "Valid Email Address";
                document.getElementById("showmessage").style.color = 'green';
        }
    }
    function ValidateEmail1() {
          var email = document.getElementById("email").value;
       // var lblError = document.getElementById("lblError");
       // lblError.innerHTML = "";
        var expr = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
        if (!expr.test(email)) {
           // lblError.innerHTML = "Invalid email address.";
            document.getElementById("showmessage").innerHTML = "Invalid Email Address";
                document.getElementById("showmessage").style.color = 'red';
        }else{
             document.getElementById("showmessage").innerHTML = "Valid Email Address";
                document.getElementById("showmessage").style.color = 'green';
        }
    }


function check() {
    var name = document.getElementById("form-product-name").value;
  if (name.match("[a-zA-Z0-9 _]+[a-za-z]+[ _]{1}[\\-]{1}[ _]{1}[0-9]+[_a-zA-Z]{1,2}")) {
    document.getElementById("showmessagexx").innerHTML = "";
      
      
        
         
  } else if(name === ""){
      document.getElementById("showmessagexx").innerHTML = "";
    
      
  }else {
    document.getElementById("showmessagexx").innerHTML = "Invalid Insert : please insert like given below in the brackets";
        document.getElementById("showmessagexx").style.color = 'red';
       
  }
}

function checkPassword() {
    var name = document.getElementById("form-full-name").value;
    var email = document.getElementById("form-email").value;
    var password = document.getElementById("form-password").value;
    var confirmpassword = document.getElementById("form-confirmpassword").value;

    if (password.length < 8) {
//        alert("password must be at least 8 characters");
        document.getElementById("showmessage").innerHTML = "password must be at least 8 characters";
        document.getElementById("showmessage").style.color = 'red';
        return false;
    } else {
        if (password !== confirmpassword) {
//            alert("pasword mismatch");
            document.getElementById("showmessage").innerHTML = "pasword mismatch";
            document.getElementById("showmessage").style.color = 'red';
            return false;
        } else {
            var parameters = "form-full-name=" + name + "&" + "form-email=" + email + "&" + "form-password=" + password;

            var request = new XMLHttpRequest();

            request.onreadystatechange = function () {
                if (request.readyState === 4 && request.status === 200) {
                    var response = request.responseText;
//alert(response);
                    if (response === "0") {
                        
//                        alert("User Email Already Exist");
                     //   document.getElementById("showmessage").innerHTML = "User Email Already Exist";
                     //   document.getElementById("showmessage").style.color = 'red';
                        window.location.href = "signup.jsp";
                    } else {
//                        alert("User Sign up Success");
                      //  document.getElementById("showmessage").innerHTML = "User Sign up Success";
                      //  document.getElementById("showmessage").style.color = 'green';
                        window.location.href = "Emailverify.jsp";
                    }
                }
            };

            request.open("POST", "Signup?" + parameters, true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.send();
        }
    }
}




function logout() {
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            window.location = "index.jsp";
        }
    };

    request.open("GET", "Logout", true);
    request.send();
}



function signIn() {

    var un = document.getElementById("form-username").value;
    var pw = document.getElementById("form-password").value;

    var parameters = "form-username=" + un + "&" + "form-password=" + pw;

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;

            if (response === "0") {
                document.getElementById("showmessage").innerHTML = "Invalid Details";
                document.getElementById("showmessage").style.color = 'red';
//                alert("Invalid Details");
                //window.location.href = "login.jsp";
            } else if (response === "1") {
                document.getElementById("showmessage").innerHTML = "Login success";
                document.getElementById("showmessage").style.color = 'green';
//                alert("login success");
                window.location.href = "index.jsp";
            } else if (response === "2") {
                document.getElementById("showmessage").innerHTML = "Your Account Deactivated";
                document.getElementById("showmessage").style.color = 'red';
//                alert("Your Account Deactivated");
                // window.location.href = "login.jsp";
            }
        }
    };

    request.open("POST", "Login?" + parameters, true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send();
}

function resetPassword() {
    var email = document.getElementById("form-email").value;
   

   
            var parameters = "form-email=" + email ;

            var request = new XMLHttpRequest();

            request.onreadystatechange = function () {
                if (request.readyState === 4 && request.status === 200) {
                    var response = request.responseText;

                    if (response === "0") {
                        document.getElementById("showmessage").innerHTML = "Invalid Email";
                        document.getElementById("showmessage").style.color = 'red';
                    } else {
                        document.getElementById("showmessage").innerHTML = "Password Successfully Changed";
                        document.getElementById("showmessage").style.color = 'green';
                        window.location.href = "login.jsp";
                    }
                }
            };

            request.open("POST", "ForgetPassword?" + parameters, true);
            request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            request.send();
        }
  

function SendMail() {
    var email = document.getElementById("form-email").value;
    var msg = document.getElementById("form-message").value;

    var parameters = "form-email=" + email + "&" + "form-message=" + msg;

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
               document.getElementById("i1").src = "";
              document.getElementById("showmessage").innerHTML = "";
            if (response === "1") {
                document.getElementById("showmessage").innerHTML = "Message Successfully Sent";
                document.getElementById("showmessage").style.color = 'green';
                document.getElementById("form-email").value="";
                 var msg = document.getElementById("form-message").value="";
//            alert("Message Successfullye Sent");
            } else {
                document.getElementById("showmessage").innerHTML = "Message Not Sent";
                document.getElementById("showmessage").style.color = 'red';
//                alert("Message Not Sent");
            }
        }else{
              document.getElementById("i1").src = "resources/3.gif";
              document.getElementById("showmessage").innerHTML = "Your message is sending....";
                document.getElementById("showmessage").style.color = 'blue';
        }
    };

    request.open("POST", "SendMail?" + parameters, true);
    request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    request.send();
}

function loadUserDetails() {
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("userdetails").innerHTML = response;
            setNavUsername();
        }
    };

    request.open("GET", "LoadUserDetails", true);
    request.send();
}

function updateUserDetails() {
    document.getElementById("form-viewuserdetails").enctype = "multipart/form-data";
    var name = document.getElementById("form-full-name").value;
    var email = document.getElementById("form-email").value;
    var password = document.getElementById("form-password").value;
    var userimage = document.getElementById("form-image").files;

//    if (userimage.length === 0) {
//        userimage = "0";
//    }

    if (password.length < 8) {
        document.getElementById("showmessage").innerHTML = "Password must be at least 8 characters";
        document.getElementById("showmessage").style.color = 'red';
//        alert("password must be at least 8 characters");
        return false;
    } else {
        var form = new FormData();
        form.append("form-full-name", name);
        form.append("form-email", email);
        form.append("form-password", password);
        form.append("form-image", userimage[0]);

        var request = new XMLHttpRequest();

        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                var response = request.responseText;
                document.getElementById("showmessage").innerHTML = "Successfully Updated";
                document.getElementById("showmessage").style.color = 'green';
//                alert("Successfully Updated");
            }
        };

        request.open("POST", "UpdateUserDetails", true);
        request.send(form);
    }
}

function setNavUsername() {
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("dropdownMenuButtonUsername").innerHTML = response;
        }
    };
    request.open("GET", "SearchUsername", true);
    request.send();
}


function addBrand() {

    var brandname = document.getElementById("brand-name").value;

    if (brandname === "") {
        document.getElementById("showmessagebrand").innerHTML = "Brand Name Empty";
        document.getElementById("showmessagebrand").style.color = 'red';
//        alert("Brand Name Empty");
    } else {
        var parameters = "brand-name=" + brandname;

        var request = new XMLHttpRequest();

        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                var response = request.responseText;

                if (response === "0") {
                    document.getElementById("showmessagebrand").innerHTML = "Brand Already Exist";
                    document.getElementById("showmessagebrand").style.color = 'red';
//                    alert("Brand Already Exist");
                } else {
                    document.getElementById("showmessagebrand").innerHTML = "Brand Successfully Added";
                    document.getElementById("showmessagebrand").style.color = 'green';
//                    alert("Brand Successfully Added");
                    loadBrands();
                }
            } else {

            }
        };
        request.open("GET", "AddBrand?" + parameters, true);
        request.send();
    }
}

function samplecode() {
    var expiry = document.getElementById("form-expiry").value;
    alert(expiry);
}

function addProduct() {
    //document.getElementById("form-addproduct").enctype = "multipart/form-data";
    var type = document.getElementById("form-product-type").value;
    var brand = document.getElementById("form-brand").value;
    var name = document.getElementById("form-product-name").value;
    var description = document.getElementById("form-product-description").value;
    var price = document.getElementById("form-price").value;
    var qty = document.getElementById("form-quantity").value;
    var image = document.getElementById("form-image").files;
    var expiry = document.getElementById("form-expiry").value;

    if (type === "Select Catagory") {
        document.getElementById("showmessage").innerHTML = "Select Product Catagory";
        document.getElementById("showmessage").style.color = 'red';
//        alert("Select Product Catagory");
        return false;
    } else if (brand === "Select Brand") {
        document.getElementById("showmessage").innerHTML = "Select Brand";
        document.getElementById("showmessage").style.color = 'red';
//        alert("Select Brand");
        return false;
    } else if (expiry === "") {
        document.getElementById("showmessage").innerHTML = "Select Expiry";
        document.getElementById("showmessage").style.color = 'red';
//        alert("Select Brand");
        return false;
        
    }else if (name === "" && check()) {
       
//        alert("Select Brand");
        return false;
    }else {
        var form = new FormData();
        form.append("form-product-type", type);
        form.append("form-brand", brand);
        form.append("form-product-name", name);
        form.append("form-product-description", description);
        form.append("form-price", price);
        form.append("form-quantity", qty);
        form.append("form-image", image[0]);
        form.append("form-expiry", expiry);

        var request = new XMLHttpRequest();

        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                var response = request.responseText;

                if (response === "0") {
                    document.getElementById("showmessage").innerHTML = "Product Readded";
                    document.getElementById("showmessage").style.color = 'red';
                    alert("Product Already Exist");
//                    window.location.href = "adminpanel.jsp";
                } else {
                    document.getElementById("showmessage").innerHTML = "Product Successfully Added";
                    document.getElementById("showmessage").style.color = 'green';
                    alert("Product Successfully Added");
//                    window.location.href = "adminpanel.jsp";
                }
            } else {

            }
        };
        request.open("POST", "AddProduct", true);
        request.send(form);
    }
}

function loadCatagories(i) {

    var url = window.location.pathname;
    var filename = url.substring(url.lastIndexOf('/') + 1);

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("form-product-type").innerHTML = response;
            if (filename === "adminpanel.jsp") {
                loadBrands();
            }
            if (filename === "index.jsp") {
                advanceSearchLoadBrands(i);
            }
        }
    };

    request.open("GET", "LoadCatagories", true);
    request.send();
}

function adminSearchLoadCatagories() {

    var url = window.location.pathname;
    var filename = url.substring(url.lastIndexOf('/') + 1);

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("form-product-type1").innerHTML = response;
            adminSearchLoadBrands();
        }
    };

    request.open("GET", "LoadCatagories", true);
    request.send();
}

function adminSearchLoadBrands() {

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("form-brand1").innerHTML = response;
        }
    };

    request.open("GET", "LoadBrands", true);
    request.send();
}

function loadBrands() {

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("form-brand").innerHTML = response;
        }
    };

    request.open("GET", "LoadBrands", true);
    request.send();
}

function advanceSearchLoadBrands(i) {

    var type = document.getElementById("form-product-type").value;
    var parameters = "type=" + type;

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("form-brand").innerHTML = response;
            if (i === 1) {
                const queryString = window.location.search;
                const urlParams = new URLSearchParams(queryString);
                const catagory = urlParams.get('catagory');
                const value = urlParams.get('value');
                searchProductsbyCatagory(value, catagory);
            } else if (i === 2) {
                const queryString = window.location.search;
                const urlParams = new URLSearchParams(queryString);
                const searchname = urlParams.get('searchname');
                searchProducts(0, searchname);
            } else {
                searchProducts(0);
            }
        }
    };

    request.open("GET", "AdvanceSearchLoadBrands?" + parameters, true);
    request.send();
}

function advanceSearchLoadBrands1() {

    var type = document.getElementById("form-product-type").value;
    var parameters = "type=" + type;

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("form-brand").innerHTML = response;
        }
    };

    request.open("GET", "AdvanceSearchLoadBrands?" + parameters, true);
    request.send();
}

function searchProducts(value, search) {
    var catagory = document.getElementById("form-product-type").value;
    var brand = document.getElementById("form-brand").value;
    var price_from = document.getElementById("showpricefrom").value;
    var price_to = document.getElementById("showpriceto").value;
    var order_by = document.getElementById("form-orderby").value;

    if (search == null) {
        var name = document.getElementById("homesearch").value;
    } else {
        var name = search;
    }

    var request = new XMLHttpRequest();

    var parameters = "catagory=" + catagory + "&" + "brand=" + brand + "&" + "name=" + name + "&" + "price_from=" + price_from + "&" + "price_to=" + price_to + "&" + "order_by=" + order_by + "&" + "value=" + value;

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("product_list").innerHTML = response;
        }
    };

    request.open("GET", "AdvanceSearchProducts?" + parameters, true);
    request.send();
}

function searchProductsbyCatagory(value, catagory) {
    //var catagory = catagory.innerHTML;

    var request = new XMLHttpRequest();

    var parameters = "catagory=" + catagory + "&" + "value=" + value;


    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("product_list").innerHTML = response;


        }
    };

    request.open("GET", "SearchProductsbyCatagory?" + parameters, true);
    request.send();
}

function adminSearchProducts() {

    var catagory = document.getElementById("form-product-type1").value;
    var brand = document.getElementById("form-brand1").value;
    var name = document.getElementById("form-name1").value;

    var request = new XMLHttpRequest();

    var parameters = "catagory=" + catagory + "&" + "brand=" + brand + "&" + "name=" + name;

    request.onreadystatechange = function () {

        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;

            if (response === "0") {
                document.getElementById("adminsearchitems").innerHTML = "<h4>No Items Found</h4>";
            } else {
                document.getElementById("adminsearchitems").innerHTML = response;
            }
        }
    };

    request.open("GET", "AdminSearchProducts?" + parameters, true);
    request.send();
}

function addToCart(id) {

    var url = window.location.pathname;
    var filename = url.substring(url.lastIndexOf('/') + 1);

    var qty;

    var request = new XMLHttpRequest();

    if (filename === "viewsingleproduct.jsp") {
        qty = document.getElementById("addtocartqty").value;
        //alert(qty);
    }
    if (filename === "index.jsp") {
        qty = 1;
    }

    if (qty === "") {
        document.getElementById("showmessage").innerHTML = "quantity cannot be empty";
        document.getElementById("showmessage").style.color = 'red';
    } else {
        //alert(id);
        //alert(qty);
        var parameters = "id=" + id + "&" + "qty=" + qty;

        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                var response = request.responseText;
                getCartQuantity();
                document.getElementById("showmessage").innerHTML = response;
                document.getElementById("showmessage").style.color = 'green';
                //alert(response);
            }
        };

        request.open("GET", "AddToCart?" + parameters, true);
        request.send();
    }
}

function updateCart(id) {

     var qty = document.getElementById("qty" + id).value;

    if (qty === "") {
         document.getElementById("showmessagev").innerHTML = "Quantity cannot be empty !!!";
        document.getElementById("showmessagev").style.color = 'red';
    } else {

        var parameters = "id=" + id + "&" + "qty=" + qty;

        var request = new XMLHttpRequest();

        request.onreadystatechange = function () {
            if (request.readyState === 4 && request.status === 200) {
                var response = request.responseText;
          //  alert(response);
               
                
                loadCart();
            }
        };

        request.open("GET", "UpdateCart?" + parameters, true);
        request.send();

    }

}

function  removeCartItem(id) {

    var request = new XMLHttpRequest();

    var parameters = "id=" + id;

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            loadCart();
            //getCartQuantity();
        }
    };

    request.open("GET", "RemoveCartItem?" + parameters, true);
    request.send();
}

function emptyCart() {
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            if (response === "1") {
                //alert("1");
                loadCart();
            } else {
                //alert("0");
                emptyCart();
            }
            //getCartQuantity();
        }
    };

    request.open("GET", "EmptyCart", true);
    request.send();
}

function getCartQuantity() {

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("cartquantity").innerHTML = response;
            //alert(response);
        }
    };

    request.open("GET", "CartQuantity", true);
    request.send();
}

function viewSingleProduct(id) {

    var parameters = "pid=" + id;
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("singleproduct").innerHTML = response;
        }
    };

    request.open("GET", "LoadSingleProduct?" + parameters, true);
    request.send();
}

function loadCart() {

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("cartitems").innerHTML = response;
            getCartQuantity();
        }
    };

    request.open("GET", "LoadCart", true);
    request.send();
}

function viewCheckoutHistory() {

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("checkouthistory").innerHTML = response;
        }
    };

    request.open("GET", "LoadCheckoutHistory", true);
    request.send();
}

function changeProductStatus(id, status) {
    var parameters = "pid=" + id + "&" + "status=" + status;

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            //alert("Success");
            adminSearchProducts();
        }
    };

    request.open("GET", "ChangeProductStatus?" + parameters, true);
    request.send();
}

function changeUserStatus(email, status) {
    var parameters = "email=" + email + "&" + "status=" + status;

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            //alert("Success");
            adminViewUsers();
        }
    };

    request.open("GET", "ChangeUserStatus?" + parameters, true);
    request.send();
}

function markasDelivered(invid) {
    var parameters = "invid=" + invid + "";

    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            //alert("Success");
            viewCheckoutHistory();
        }
    };

    request.open("GET", "MarkasDelivered?" + parameters, true);
    request.send();
}

function adminViewUsers() {
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("adminsearchusers").innerHTML = response;
        }
    };

    request.open("GET", "AdminViewUsers", true);
    request.send();
}

function adminViewOrders() {
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            document.getElementById("adminvieworders").innerHTML = response;
        }
    };

    request.open("GET", "LoadOrders", true);
    request.send();
}
function adminViewSettings() {
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            
            document.getElementById("adminviewsettings").innerHTML = response;
            loadContacts();
        }
    };

    request.open("GET", "LoadAdminSettings", true);
    request.send();
}
function adminViewNotePad() {
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            
        }
    };

    request.open("GET", "ViewNotePad", true);
    request.send();
}
function active() {

    
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status === 200) {
                var response = request.responseText;
     
                  document.getElementById("adminviewsettings").innerHTML = response;

            }
        }
    };
    
    request.open("GET","CheckSus",true);
    request.send();
    
}
function changeContacts() {

   // alert("dlkdbhfg");
    var email = document.getElementById('email').value;
    var contact = document.getElementById('contact').value;
    var address = document.getElementById('address').value;
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status === 200) {
                var response = request.responseText;
                if (response.includes("success")) {
                    loadContacts();
                }

                

            }
        }
    };
    
    request.open("GET","ChangeContacts?e="+email + "&c="+contact+ "&a=" +address,true);
    request.send();
    
}
function loadContacts() {

   // alert("ok");
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status === 200) {
                var response = request.responseText;
              //  alert(response);
                document.getElementById("coti").innerHTML=response;

            }
        }
    };
    
    request.open("GET","LoadContacts",true);
    request.send();
    
}



function printReport(invid) {
    var request = new XMLHttpRequest();
    request.onreadystatechange = function () {
        if (request.readyState === 4) {
            if (request.status === 200) {
                var response = request.responseText;
                var pager = window.open(response,"invoice");
                pager.onload=function(){
                    pager.focus();
                    pager.print();
                    pager.window.print();
                };
                
            }
        }
    };
    request.open("GET", "JasperReport?id="+ invid, true);
    request.send();




}


function minus() {
    var qty = document.getElementById("addtocartqty").value;

    if (qty > 1) {
        document.getElementById("addtocartqty").value = qty - 1;
    }
}
function plus() {
    var qty = document.getElementById("addtocartqty").value;
    var integer = parseInt(qty, 10);

    if (qty > 0) {
        document.getElementById("addtocartqty").value = integer + 1;
    }
}

function addInvoice() {

    var contact = document.getElementById("form-contactno").value;
    var address = document.getElementById("form-deliveryaddress").value;

    var parameters = "form-contactno=" + contact + "&" + "form-deliveryaddress=" + address;
//
//    if (contact === "" || address === "") {
//        document.getElementById("showmessage").innerHTML = "Contact Number and Address cannot be empty";
//        document.getElementById("showmessage").style.color = 'red';
//        return false;
//    } else {
    var request = new XMLHttpRequest();

    request.onreadystatechange = function () {
        if (request.readyState === 4 && request.status === 200) {
            var response = request.responseText;
            //alert(response);
//                var invid = response.split("-")[0];
//                var address = response.split("-")[1];
//                var phone = response.split("-")[2];
//                var total = response.split("-")[3];
//                var email = response.split("-")[4];
//                var name = response.split("-")[5];

            if (response !== null) {
                loadCart();
                //checkout(invid, address, phone, total, email, name);
                window.location = "invoice.jsp?invid=" + response;
            }
            //viewusers();
        }
    };

    request.open("GET", "AddInvoice?" + parameters, true);
    request.send();
    //}
}

function checkout(total, email, name) {
    //alert("Proceed to Checkout");
    // Put the payment variables here

    var contact = document.getElementById("form-contactno").value;
    var address = document.getElementById("form-deliveryaddress").value;

    var parameters = "form-contactno=" + contact + "&" + "form-deliveryaddress=" + address;

    if (contact === "" || address === "") {
        document.getElementById("showmessage").innerHTML = "Contact Number and Address cannot be empty";
        document.getElementById("showmessage").style.color = 'red';
        return false;
    } else {
        var payment = {
            "sandbox": true,
            "merchant_id": "1214341", // Replace your Merchant ID
            "return_url": "", //invoice eke url eka
            "cancel_url": "",
            "notify_url": "",
            "order_id": "", //invoice no eka
            "items": "",
            "amount": total,
            "currency": "LKR",
            "first_name": name,
            "last_name": "",
            "email": email,
            "phone": document.getElementById("form-contactno").value,
            "address": document.getElementById("form-deliveryaddress").value,
            "city": "",
            "country": "Sri Lanka",
            "delivery_address": document.getElementById("form-deliveryaddress").value,
            "delivery_city": "",
            "delivery_country": "Sri Lanka",
            "custom_1": "",
            "custom_2": ""
        };
        payhere.startPayment(payment);

        // Called when user completed the payment. It can be a successful payment or failure
        payhere.onCompleted = function onCompleted(orderId) {
            console.log("Payment completed. OrderID:" + orderId);
            //Note: validate the payment and show success or failure page to the customer
            alert("Payment Success");
            //window.location = "invoice.jsp?invid=" + invid;
            addInvoice();
            //window.location = "invoice.jsp";

        };

        // Called when user closes the payment without completing
        payhere.onDismissed = function onDismissed() {
            //Note: Prompt user to pay again or show an error page
            alert("Payment dismissed");
        };

        // Called when error happens when initializing payment such as invalid parameters
        payhere.onError = function onError(error) {
            // Note: show an error page
            alert("Error:" + error);
        };
    }

}




// makes sure the whole site is loaded
//jQuery(window).load(function() {
// will first fade out the loading animation
//jQuery("#status").fadeOut();
// will fade out the whole DIV that covers the website.
//jQuery("#preloader").delay(1000).fadeOut("slow");
//})	
var loader;

function loadNow(opacity) {
    if (opacity <= 0) {
        displayContent();
    } else {
        loader.style.opacity = opacity;
        window.setTimeout(function() {
            loadNow(opacity - 0.05);
        }, 50);
    }
}

function displayContent() {
    loader.style.display = 'none';
    document.getElementById('content').style.display = 'block';
}

document.addEventListener("DOMContentLoaded", function() {
    loader = document.getElementById('loader');
    loadNow(1);
});





