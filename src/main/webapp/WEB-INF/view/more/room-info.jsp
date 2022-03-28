<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<h2>Client info</h2>
<br>

<form:form action="saveRoom" modelAttribute="newRoom">

    Name <form:input path="place_in_hotel"/>
    <form:errors path="place_in_hotel"/>
    <br><br>
    category <form:input path="category"/>
    <form:errors path="category"/>
    <br><br>
    arrival_date <form:input path="arrival_date"/>
    <form:errors path="arrival_date"/>
    <br><br>
    hotel <form:input path="hotel"/>
    <form:errors path="hotel"/>
    <br><br>
    <input type="submit" value="OK">


</form:form>

</body>
</html>