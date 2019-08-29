<%@ page import="app.utils.AttributesNames" %>
<%@ page import="app.models.Ticket" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cinema</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/buyTicket" method ="post">
    <table class="table">
        <thead class="thead-inverse">
        <tr>
            <th>Row</th>
            <th>Place</th>
            <th>Reservation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${places}" var="place">
            <tr>
                <th>${place.getRow()}</th>
                <th>${place.getPlaceNumber()}</th>
                <c:if test="${place.getReservation()=='reserved'}">
                    <th>RESERVED_PLACE</th>
                </c:if>
                <c:if test="${place.getReservation()=='free'}">
                    <th> <button type="submit" class="btn btn-primary" name="buyTickets" value=${place.toString()}>Buy ticket</button></th>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
