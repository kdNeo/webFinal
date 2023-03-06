<%@page import="database.User"%>
<%
    User user = (User) request.getAttribute("userdetails");
%>

<form role="form" action="" method="post" class="registration-form" id="form-viewuserdetails" enctype="multipart/form-data" onsubmit="return updateUserDetails();">
    <div class="form-group">
        <img id="uploadPreview" src="<%=user.getImage()%>" class="rounded-circle border border-dark" alt="avatar" style="width:200px;height:200px;">
        <h6>Upload a Photo</h6>
        <input type="file" name="form-image" placeholder="Choose Image..." class="text-center center-block" id="form-image">
    </div>
    <div class="form-group">
        <label class="sr-only" for="form-full-name"><%=user.getName()%></label>
        <input type="text" name="form-full-name" placeholder="Full name..." value="<%=user.getName()%>" maxlength="40" class="form-full-name form-control" id="form-full-name" required>
    </div>
    <div class="form-group">
        <label class="sr-only" for="form-email"><%=user.getEmail()%></label>
        <input type="email" name="form-email" placeholder="Email..." value="<%=user.getEmail()%>" class="form-email form-control" id="form-email" disabled>
    </div>
    <div class="form-group">
        <label class="sr-only" for="form-password"><%=user.getPassword()%></label>
        <input type="password" name="form-password" placeholder="Password..." value="<%=user.getPassword()%>" class="form-password form-control" maxlength="40" id="form-password" aria-describedby="passwordHelpBlock" required>
    </div>
    <button type="submit" class="btn btn-dark mr-sm-2">Update</button>
    <p id="showmessage" style="font-weight: bold;"></p>
</form>