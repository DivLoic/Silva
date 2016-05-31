<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Labone - Id Card</title>
		<link rel="stylesheet" href="/Labone/css/bootstrap.min.css">
	</head>
	<body>
		<jsp:useBean id="user" class="fr.labone.jsp.Person" scope="request"/>
		<jsp:setProperty name="user"  property="*"/>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-offset-1 col-md-4">
					<h1>Labone</h1> 1st Lab of Techno Web.<br/><br/><br/>
				</div>
				<div class="col-md-offset-10" style="padding-top:20px;">
					<a href="/Labone/index.jsp">
						<button type="button" class="btn btn-default btn-lg">Home</button>
					</a>
				</div>
			</div>
			<div class="row">
				<div class="col-md-offset-1 col-md-4">
					<table class="table table-striped">
						<tr>
							<td>Lastname: </td>
							<td><jsp:getProperty name="user" property="lastName" /></td>
						</tr>
						<tr>
							<td>Firstname: </td>
							<td><jsp:getProperty name="user" property="firstName" /></td>
						</tr>
						<tr>
							<td>BirthDate: </td>
							<td><jsp:getProperty name="user" property="date" /></td>
						</tr>
						<tr>
							<td>Sex: </td>
							<td><jsp:getProperty name="user" property="sex" /></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</body>
	<script src="/Labone/js/jquery-1.11.2.min.js"></script>
	<script src="/Labone/js/bootstrap.min.js"></script>
</html>