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
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	function deleteConform() {
		return confirm("Do You want to Delete this User");
	}
	function UnlockConform() {
		return confirm("Do You want to Unlock this User");
	}
	$(document).ready(function() {
		$('#contactTable').DataTable({
			"pagingType" : "full_numbers"
		});
	});
</script>
<body>
	<h1>All User</h1>

	<div class="panel-body">
		<div>
			<div>
				<table border="1" id="contactTable">
					<thead>
						<th scope="row">S.No</th>
						<th scope="row">Name</th>
						<th scope="row">Email</th>
						<th scope="row">AccStatus</th>
						<th scope="row">Number</th>
						<th scope="row">Edit</th>
						<th scope="row">Action</th>
					</thead>
					<tbody>
						<c:forEach items="${user}" var="user" varStatus="index">
							<tr>
								<td>${index.count }</td>
								<td>${user.firstName }</td>
								<td>${user.email }</td>
								<td>${user.accStatus }</td>
								<td>${user.phone }</td>

								<td><a href="/editUser?uid=${user.userId }">Edit</a></td>
								<c:choose>
									<c:when test="${user.accStatus=='UnLocked'}">
										<td><a href="/deleteUser?uId=${user.userId }"
											onClick="deleteConform()">Delete</a></td>
										<br />
									</c:when>
									<c:otherwise>
										<td><a href="/unlockUser?uId=${user.userId }"
											onClick="UnlockConform()">UnLock</a></td>
										<br />
									</c:otherwise>
								</c:choose>

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