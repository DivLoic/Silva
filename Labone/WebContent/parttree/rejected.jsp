<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Labone - Id.</title>
		<link rel="stylesheet" href="/Labone/css/bootstrap.min.css">
	</head>
	<body>
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
				<div class="col-md-offset-1 col-md-6">
					<div class="alert alert-danger" role="alert">
						<strong>Sorry Bro.</strong> You are too young, look ur Id Card!
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-offset-1 col-md-4">
					<table class="table table-hover">
						<tr>
		    				<td>Nom</td>
		    				<td><c:out value="${ beanH.lastName }"/></td> 
		  				</tr>
		  				<tr>
		    				<td>Prenom</td>
		    				<td><c:out value="${ beanH.firstName }"/></td> 
		  				</tr>
		  				<tr>
		    				<td>Date</td>
		    				<td><c:out value="${ beanH.birthDay }"/></td> 
		  				</tr>
		  				<tr>
		    				<td>Sex</td>
		    				<td><c:out value="${ beanH.sex }"/></td> 
		  				</tr>
					</table>
				</div>
			</div>
		</div>
	</body>
	<script src="Labone/js/jquery-1.11.2.min.js"></script>
	<script src="/Labone/js/bootstrap.min.js"></script>
</html>