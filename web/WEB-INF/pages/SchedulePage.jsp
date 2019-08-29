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
<form action="/tickets" method="post">
</form>
<c:out value="You are on the schedule page"/>
<form action="/tickets" method="post">
    <c:forEach items="${movieSchedule}" var="session">
    <p>${session.getMovie().getMovieName()}
    <p>${session.getShowDate()}
    <p>${session.getShowTime()}
    <p>
        <button type="submit" class="btn btn-primary" name="session id" value="${session.getId()}">Buy Ticket</button>
        </c:forEach>
</form>
</body>
</html>
