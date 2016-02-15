<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/Labone/css/bootstrap.min.css">
		<title>A short list of Cookies</title>
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
					<ul>		
						<%
						Cookie[] cks = request.getCookies();
						if(cks != null){
							for(Cookie c : cks){
								out.print("<li class=\"list-group-item\">"+c.getName()+" : "+c.getValue()+"</li>");
							}
						}
						%>
					</ul>
				</div>
			</div>
		</div>
	</body>
	<script src="/Labone/js/jquery-1.11.2.min.js"></script>
	<script src="/Labone/js/bootstrap.min.js"></script>
</html>