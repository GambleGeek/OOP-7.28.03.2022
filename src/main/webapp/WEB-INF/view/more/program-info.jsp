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

<h2>Program info</h2>
<br>

<form:form action="saveProgram" modelAttribute="newProgram">

    Program number <form:input path="program_number"/>
    <br><br>
    Description <form:input path="description"/>
    <br><br>
    <input type="submit" value="OK">


</form:form>

</body>
</html>