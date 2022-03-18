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
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Address</th>
        <th>Passport number</th>
        <th>Packages</th>
    </tr>

    <c:forEach var="tourist" items="${allTourists}">

        <tr>
            <td>${tourist.id}</td>
            <td>${tourist.name}</td>
            <td>${tourist.age}</td>
            <td>${tourist.address}</td>
            <td>${tourist.passport_number}</td>
            <td>${tourist.tourPackages}</td>
        </tr>

    </c:forEach>
</table>

<br>

<input type="button" value="Add"
       onclick="window.location.href = 'addNewClient'"/>

</body>
</html>