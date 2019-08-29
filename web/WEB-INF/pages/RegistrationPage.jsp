<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cinema</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
</head>
<body>
<%
    out.println("<center>You are on the registration page</center>");
%>
<form action="/registrate" method="post">
    <div class="form-group">
        <label for="firstName">First Name</label>
        <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Enter first name">
    </div>
    <div class="form-group">
        <label for="secondName">Second Name</label>
        <input type="text" class="form-control" name="secondName" id="secondName" placeholder="Enter second name">
    </div>
    <div class="form-group">
        <label for="userName">User Name</label>
        <input type="text" class="form-control" name="userName" id="userName" placeholder="Enter user name">
    </div>
    <div class="form-group">
        <label for="userPassword">Password</label>
        <input type="password" class="form-control" name="userPassword" id="userPassword" placeholder="Password">
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" name="email" id="email" placeholder="Enter email">
    </div>
    <button type="submit" class="btn btn-success">Registrate</button>
</form>


</body>
</html>
