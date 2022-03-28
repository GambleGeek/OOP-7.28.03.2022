<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Add Contract</title>
</head>
<body>

<h1>New Contract</h1>

<form:form action="" modelAttribute="contract">

    <form:hidden path="id"/>

    Contract number <form:input path="contractNumber"/>
    <br><br>
    Registration Date <form:input path="registrationDate"/>
    <br><br>
    Client <form:input path="client"/>
    <br><br>
    Tour <form:input path="tour"/>
    <br><br>
    <input type="submit" value="OK">

</form:form>

</body>
</html>
