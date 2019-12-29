<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><th>pid</th><th>First Name</th><th>Last Name</th><th>age</th>
</tr>
<tr><td>${person.firstName}</td>
<td>${person.lastName}</td>
<td>${person.age}</td>
</table>
<a href="person">add new person</a>
</body>
</html>