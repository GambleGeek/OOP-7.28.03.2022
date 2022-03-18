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

<h2>Employee info</h2>
<br>

<form:form action="saveEmployee" modelAttribute="newEmployee">

    Name <form:input path="name"/>
    <br><br>
    Position <form:input path="position"/>
    <br><br>
    Passport number <form:input path="passport_number"/>
    <br><br>
    Address <form:input path="address"/>
    <br><br>
    <input type="submit" value="OK">


</form:form>

</body>
</html>