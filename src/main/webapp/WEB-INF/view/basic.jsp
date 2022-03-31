<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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

<h3>Information for all employees</h3>
<br><br>

<security:authorize access="hasRole('DIRECTOR')">
<input type="button" value="Administration"
onclick="window.location.href = 'director'">
Only for Director staff
</security:authorize>

<br><br>
<security:authorize access="hasRole('TOURCREATOR')">
<input type="button" value="Tour Creation"
onclick="window.location.href = 'tour-creator'">
Only for TourCreator staff
</security:authorize>
<br><br>

<security:authorize access="hasRole('TOURMANAGER')">
<input type="button" value="Tour Management"
onclick="window.location.href = 'tour-manager'">
Only for TourManager staff
</security:authorize>
<br><br>

<security:authorize access="hasRole('SALESMANAGER')">
<input type="button" value="Sales"
onclick="window.location.href = 'sales-manager'">
Only for Sales Manager staff
</security:authorize>
<br><br>

</body>
</html>