<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cinema</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<form action="/schedule" method="post">
<c:forEach items="${movies}" var="movie">
    <div class="container">
        <h>${movie.getMovieName()}</h>
        <div class="card" style="width:400px">
            <div class="card-body">
                <h4 class="card-title">${movie.getMovieDescription()}</h4>
                <button type="submit" class="btn btn-primary" name="movie id" value="${movie.getId()}">See schedule
                </button>
            </div>
        </div>
    </div>
</c:forEach>
</form>

<div>
<form action="/registration" method="post">
    <button type="submit" class="btn btn-primary" name="button" value="button1">Go to registration page</button>
</form>

<form action="/login" method="post">
    <button type="submit" class="btn btn-primary" name="button" value="button2">Go to Login Page</button>
</form>

<form action="/personalCabinet" method="post">
    <button type="submit" class="btn btn-primary" name="button" value="button2">Go to Personal Cabinet</button>
</form>
</div>>


</body>
</html>
