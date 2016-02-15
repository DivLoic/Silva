<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/Labone/css/bootstrap.min.css">
		<title>Labone</title>
	</head>
	<body>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-offset-1">
					<h1>Labone</h1> 1st Lab of Techno Web.<br/><br/><br/>
				</div>
			</div>
			<div class="row">
				<div class=" col-md-offset-1 col-md-3 list-group">
					<h3>Part 1</h3>
					<a href="/Labone/partone/form.jsp" class="list-group-item">1.1 Form -> servlet -> jsp</a>
					<a href="/Labone/partone/form2.jsp" class="list-group-item">1.2 Form -> servlet -> cookie</a>
					<a href="/Labone/ReadCookie" class="list-group-item">1.2 ReadCookies: a short list of cookies.</a>
					<a href="/Labone/Visit" class="list-group-item">1.2 Cookies tell ur numder of visit.
						<span class="badge"><%try{Cookie[] cs = request.getCookies();
							for(Cookie c: cs){if(c.getName().equals("visited"))out.print(c.getValue());}} catch(Exception e){}%>
						</span>
					</a>
					<a href="/Labone/ShowSession" class="list-group-item">1.3 Session save your birthdate.</a>
					<a href="/Labone/ListItems" class="list-group-item">1.3 Session save yout items.</a>
				</div>
				<div class="col-md-3 list-group">
					<h3>Part 2</h3>
					<a href="/Labone/parttwo/expression.jsp" class="list-group-item">2.1 Random expression</a>
					<a href="/Labone/parttwo/scriptlet.jsp" class="list-group-item">2.2 The current time</a>
					<a href="/Labone/parttwo/declaration.jsp" class="list-group-item">2.3 Declaration</a>
					<a href="/Labone/parttwo/form.jsp" class="list-group-item">2.4 Form, JSP and JavaBean</a>
				</div>
				<div class=" col-md-3 list-group">
					<h3>Part 3</h3>
					<a href="/Labone/parttree/form.jsp" class="list-group-item">3.* MVC Cycle</a>
				</div>
			</div>
		</div>
	</body>
	<script src="/Labone/js/jquery-1.11.2.min.js"></script>
	<script src="/Labone/js/bootstrap.min.js"></script>
</html>