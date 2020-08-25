<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">

<table>
		<form:form modelAttribute="user" method="post" action="saveUser">
        First name: <form:input path="firstName" />
			<br>
			<br>  
        Last name: <form:input path="lastName" />
			<br>
			<br>  
         Email: <form:input path="email" />
			<br>
			<br>   
         Email: <form:input path="phone" />
			<br>
			<br>   
        Gender:   
        Male<form:radiobutton path="gender" value="Male" />  
        Female<form:radiobutton path="gender" value="Female" />
			<br>
			<br>  
     
       Role: <form:select path="role">
				<form:option value="">-Select-</form:option>
				<form:options items="${roles}" />
			</form:select>
			<br>
			<br>
			<input type="submit" value="Submit" />
		</form:form>
		</table>
</body>
</html>
