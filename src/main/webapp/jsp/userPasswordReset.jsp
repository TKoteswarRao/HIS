<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="./js/app.js"></script>
<meta charset="ISO-8859-1">
<title>IUser</title>
</head>
<script type="text/javascript">
	$('#password, #confirm_password').on('keyup', function() {
		if ($('#password').val() == $('#confirm_password').val()) {
			$('#message').html('Matching').css('color', 'green');
		} else
			$('#message').html('Not Matching').css('color', 'red');
	});
</script>
<h1>User Password Reset Page</h1>

<div class="panel-body">
	<h2 style="color: green;">${success}</h2>

	<form:form modelAttribute="user" method="post" action="updateUser"
		id="passwordResetUser">

		<form:hidden path="userId" />
		<table border="2">

			<tr>
				<td>Email</td>
				<td><form:input path="userEmail" id="userEmail"
						placeholder="Enter a Email" /></td>
				<form:errors path="userEmail" />
			</tr>

			<tr>
				<td>Password</td>
				<td><form:input path="userPWD" id="userPWD"
						placeholder="Enter a Password" /></td>
				<form:errors path="userPWD" />
			</tr>
		</table>
		<form:button type="submit" class="btn btn-success"
			onclick="doAjaxPost()">Save</form:button>
	</form:form>
	<a class="btn btn-primary" href="/index" role="button">Main Page</a>
</div>

</body>
</html>