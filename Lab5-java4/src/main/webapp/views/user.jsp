<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home User</title>
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
body {
	font-family: arial;
}

form {
	width: 350px;
	padding: 20px;
	box-shadow: 2px 2px 10px gray;
	border-radius: 15px;
	margin-top: 20px;
	margin-bottom: 20px;
}

.form-check-label1 {
	margin-left: 25px;
}

h5 {
	color: red;
	font-style: italic;
}

table {
	width: 500px;
	box-shadow: 2px 2px 10px gray;
}

button {
	background-color: #FFCCCC !important;
	border: none !important;
	border-radius: 2px !important;
}

button:hover {
	background-color: white !important;
	color: black;
	font-weight: bold;
}

a {
	text-decoration: none;
	color: black;
}

a:hover {
	color: #FFCCCC;
	text-decoration: underline;
}
</style>
</head>

<body class="container">

	<!-- Thông báo -->
	<c:url var="url" value="/user" />
	<!-- Form -->

	<!-- Bảng -->


	<form action="${url}/index" method="post" class="mx-auto">
		<h5>${message}</h5>
		<div class="mb-3 mt-3">
			<label for="id" class="form-label">ID:</label> <input type="id"
				class="form-control" id="id" placeholder="Enter id" name="id"
				value="${form.id}">
		</div>
		<div class="mb-3">
			<label for="pwd" class="form-label">Password:</label> <input
				type="password" class="form-control" id="pwd"
				placeholder="Enter password" name="password"
				value="${form.password}">
		</div>
		<div class="mb-3 mt-3">
			<label for="fullname" class="form-label">Fullname:</label> <input
				type="fullname" class="form-control" id="fullname"
				placeholder="Enter fullname" name="fullname"
				value="${form.fullname}">
		</div>
		<div class="mb-3">
			<label for="email" class="form-label">Email:</label> <input
				type="email" class="form-control" id="email"
				placeholder="Enter email" name="email" value="${form.email}">
		</div>

		<div class="form-check mb-3">
			<label class="form-check-label"> <input
				${form.admin?'checked':''} class="form-check-input" type="radio"
				name="admin" value="true"> Admin
			</label> <label class="form-check-label1"> <input
				${form.admin?'':'checked'} class="form-check-input" type="radio"
				name="admin" value="false"> User
			</label>
		</div>
		<input type="text" name="message" value="${message}"
			style="margin-bottom: 10px;"><br>
		<button class="btn" formaction="${url}/create" name="create">Create</button>
		<button class="btn" formaction="${url}/update" name="update">Update</button>
		<button class="btn" formaction="${url}/delete" name="delete">Delete</button>
		<a href="${url}/index">Reset</a><br>
	</form>


	<table class="table table-danger mx-auto text-center">
		<thead>
			<tr>
				<th>Id</th>
				<th>Password</th>
				<th>Fullname</th>
				<th>Email</th>
				<th>Admin</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${items}">
				<tr>
					<td>${item.id}</td>
					<td>${item.password}</td>
					<td>${item.fullname}</td>
					<td>${item.email}</td>
					<td>${item.admin?'Admin':'User'}</td>
					<td><a href="/Lab5-java4/user/edit/${item.id}">Edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>