<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!Doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<h2>All Rooms</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Hotel name</th>
        <th>Arrival</th>
        <th>Category</th>
        <th>Departure</th>
        <th>Place in hotel</th>
    </tr>

    <c:forEach var="room" items="${allRooms}">

        <tr>
            <td>${room.id}</td>
            <td>${room.hotel.name}</td>
            <td>${room.arrival_date}</td>
            <td>${room.category}</td>
            <td>${room.departure_date}</td>
            <td>${room.place_in_hotel}</td>
        </tr>

    </c:forEach>
</table>

<br>

<input type="button" value="Add"
       onclick="window.location.href = 'addNewClient'"/>

</body>
</html>