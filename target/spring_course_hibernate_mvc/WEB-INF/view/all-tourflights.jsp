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

<h2>All </h2>

<table>
    <tr>
        <th>ID</th>
        <th>Flight number</th>
        <th>Tour</th>
        <th>Air company</th>
        <th>Departure date</th>
        <th>Departure time</th>
        <th>Departure city</th>
        <th>Arrival city</th>
        <th>Direction</th>
    </tr>

    <c:forEach var="tourflight" items="${allTourFlights}">

        <tr>
            <td>${tourflight.id}</td>
            <td>${tourflight.departure_date}</td>
            <td>${tourflight.air_company}</td>
            <td>${tourflight.arrival_city}</td>
            <td>${tourflight.departure_city}</td>
            <td>${tourflight.departure_time}</td>
            <td>${tourflight.direction}</td>
            <td>${tourflight.flight_number}</td>
            <td>${tourflight.tour}</td>
        </tr>

    </c:forEach>
</table>

<br>

<input type="button" value="Add"
       onclick="window.location.href = 'addNewClient'"/>

</body>
</html>