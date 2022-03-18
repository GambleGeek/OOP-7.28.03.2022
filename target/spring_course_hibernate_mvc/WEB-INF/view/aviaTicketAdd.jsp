<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Avia Ticket</title>
</head>
<body>

<h1>New Avia Ticket</h1>

<form:form action="" modelAttribute="aviaTicket">

    <form:hidden path="id"/>

    Place <form:input path="place"/>
    <br><br>
    Tour Flight <form:input path="tourFlight"/>
    <br><br>
    Class Avia <form:input path="classAvia"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>
