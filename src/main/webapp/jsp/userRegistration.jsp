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

<body>
	<h1>User Registration Page</h1>

	<div class="panel-body">
		<h2 style="color: green;">${success}</h2>

		<form:form modelAttribute="user" method="post" action="saveUser"
			id="userRegistration">

			<form:hidden path="userId" />
			<table border="2">
				<tr>
					<td>First Name</td>
					<td><form:input path="firstName" id="firstName"
							placeholder="Enter a First Name" /></td>
					<form:errors path="firstName" />
				</tr>

				<tr>
					<td>last Name</td>
					<td><form:input path="lastName" id="lastName"
							placeholder="Enter a last Name" /></td>
					<form:errors path="lastName" />
				</tr>

				<tr>
					<td>Email</td>
					<td><form:input path="userEmail" id="userEmail"
							placeholder="Enter a Email" /></td>
					<form:errors path="userEmail" />
				</tr>
				<tr>
					<td>Contact Number</td>
					<td><form:input path="userMobile" id="userMobile"
							placeholder="Enter a Number" /></td>
					<form:errors path="userMobile" />
				</tr>
				<tr>
					<td>Date of Birth</td>
					<td><form:input path="dob" id="dob" placeholder="Enter a DOB" /></td>
					<form:errors path="dob" />
				</tr>

				<tr>
					<td>Gender</td>
					<td>Male: <form:radiobutton path="gender" value="Male"
							id="gender" /> Female:<form:radiobutton path="gender"
							value="Female" id="gender" /></td>
					<form:errors path="gender" />
				</tr>
				<tr>
					<td>Country</td>
					<td><form:select path="countryId">
							<form:option value="">-Select-</form:option>
							<form:options items="${countriesMap}" />
						</form:select></td>
					<form:errors path="countryId" />
				</tr>
				<tr>
					<td>State</td>
					<td><form:select path="stateId">
							<form:option value="">-Select-</form:option>
						</form:select></td>
					<form:errors path="stateId" />
				</tr>
				<tr>
					<td>City</td>
					<td><form:select path="cityId">
							<form:option value="">-Select-</form:option>
						</form:select></td>
					<form:errors path="cityId" />
				</tr>
			</table>
			<form:button type="submit" class="btn btn-success"
				onclick="doAjaxPost()">Save</form:button>
		</form:form>
		<a class="btn btn-primary" href="/getAllContacts" role="button">All
			Contact</a>
	</div>

</body>
</html>