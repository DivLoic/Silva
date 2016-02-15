<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="org.joda.time.*, org.joda.time.format.DateTimeFormatter, org.joda.time.format.DateTimeFormat" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>LabOne - Scriptlet.</title>
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
				<div class="col-md-offset-1 col-md-5">
				<%! 
					DateTime d = new DateTime();
					DateTimeFormatter dtf = DateTimeFormat.forPattern("dd/MM/yyyy - HH:mm:ss");
					String dt = dtf.print(d);
				%>
					<div style="border:black 1px solid;"; class="alert alert-defeult" role="alert">
						The current time given by java is <strong><% out.print(dt); %></strong> .
					</div>
				</div>
			</div>
		</div>
	</body>
	<script src="Labone/js/jquery-1.11.2.min.js"></script>
	<script src="/Labone/js/bootstrap.min.js"></script>
</html>