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
<title>HIS</title>
</head>

<body>
	<h1>All User</h1>

	<div class="panel-body">
		<div>
			<div>
				<h2>All User</h2>
				<table border="1" id="contactTable">
					<thead>
						<th scope="row">S.No</th>
						<th scope="row">User Name</th>
						<th scope="row">User Email</th>
						<th scope="row">User Number</th>
						<th scope="row">User AccStatus</th>
						<th scope="row">Edit</th>
						<th scope="row">Delete</th>
					</thead>
					<tbody>
						<c:forEach items="${user}" var="contact" varStatus="index">
							<tr>
								<td>${user.count }</td>
								<td>${user.firstName }</td>
								<td>${user.userEmail }</td>
								<td>${user.accStatus }</td>
								<td>${user.userMobile }</td>
								<td><a href="/editUser?cid=${user.userId }">Edit</a></td>
								<td><a href="/deleteUser?cid=${user.userId }"
									onClick="deleteConform()">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<a class="btn btn-primary" href="/user" role="button">Add New
					User</a>
			</div>
		</div>
	</div>

</body>
</html>