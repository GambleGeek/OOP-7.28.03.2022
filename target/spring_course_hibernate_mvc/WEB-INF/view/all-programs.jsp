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

<h2>All Programs</h2>

<table>
    <tr>
        <th>Id</th>
        <th>Program number</th>
        <th>Description</th>
    </tr>

    <c:forEach var="program" items="${allPrograms}">

        <tr>
            <td>${program.id}</td>
            <td>${program.program_number}</td>
            <td>${program.description}</td>

        </tr>
    </c:forEach>
</table>

<br>

<input type="button" value="Add"
       onclick="window.location.href = 'addNewClient'"/>

</body>
</html>