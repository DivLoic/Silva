<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Items</title>
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
				<div class="col-md-offset-1 col-md-4">
					<%! private int numEntries = 10;
    					private int randomInt(int range) {
    						return(1 + ((int)(Math.random() * range)));
    					}
    				%>
					<h4>A random list from 1 to 100:</h4>
					<ul class="list-group"><% 
						for(int i=0; i<numEntries; i++) {
							out.println("<li>Random number n°"+i+": <span class=\"badge\">" + randomInt(100)+ "</span></li>");
						}
					%></ul>
				</div>
			</div>
		</div>
	</body>
	<script src="Labone/js/jquery-1.11.2.min.js"></script>
	<script src="/Labone/js/bootstrap.min.js"></script>
</html>