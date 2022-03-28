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
        <th>Name</th>
        <th>Status</th>
        <th>Tour number</th>
        <th>Tour type</th>
        <th>Country</th>
        <th>Start date</th>
        <th>End date</th>
        <th>Program number</th>
    </tr>

    <c:forEach var="tour" items="${allTours}">
        <tr>
            <td>${tour.id}</td>
            <td>${tour.name}</td>
            <td>${tour.status}</td>
            <td>${tour.tour_number}</td>
            <td>${tour.tourType}</td>
            <td>${tour.country}</td
            <td>${tour.start_date}</td>
            <td>${tour.end_date}</td>
            <td>${tour.program}</td>
        </tr>
    </c:forEach>
</table>

<br>

<input type="button" value="Add"
       onclick="window.location.href = 'addNewClient'"/>

</body>
</html>