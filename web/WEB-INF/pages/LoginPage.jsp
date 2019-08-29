<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cinema</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<form action="/loginUser" method="post">
    <div class="form-group">
        <label for="userName">User name</label>
        <input type="text" class="form-control" name="userName" id="userName" aria-describedby="emailHelp"
               placeholder="Enter user name">
    </div>
    <div class="form-group">
        <label for="userPassword">Password</label>
        <input type="password" class="form-control" name="userPassword" id="userPassword" placeholder="Enter password">
    </div>
    <button type="submit" class="btn btn-primary">Login</button>
</form>

<form action="/logoutUser" method="post">
    <button type="submit" class="btn btn-primary">Log out</button>
</form>
</body>
</html>
