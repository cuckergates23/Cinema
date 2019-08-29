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

<c:out value="Welcome to the personal cabinet"/>

<c:forEach items="${tickets}" var="ticket">
<div class="card">
    <div class="card-header">${ticket.getSession().getMovie().getMovieName()}</div>
    <div class="card-body">Row:${ticket.rowNumber} Place: ${ticket.place} </div>
    <div class="card-footer">Price:${ticket.price}</div>
</div>
<p>
    </c:forEach>
</body>
</html>
