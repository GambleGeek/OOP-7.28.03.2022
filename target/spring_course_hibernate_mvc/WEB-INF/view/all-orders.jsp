<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>

<h2>All Orders</h2>

<table>
    <tr>
        <th>Name</th>
        <th>Address</th>
        <th>Client_number</th>
        <th>Tel_number</th>
    </tr>

    <c:forEach var="employee" items="${allEmployees}">

        <tr>
            <td>${employee.name}</td>
            <td>${employee.address}</td>
            <td>${employee.client_number}</td>
            <td>${employee.tel_number}</td>
            <td>${employee.position.position}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>