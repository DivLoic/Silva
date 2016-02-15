<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Labone - r u a new visitor??.</title>
		<link rel="stylesheet" href="/Labone/css/bootstrap.min.css">
		<style>
			input{
				margin-right:10px;
			}
		</style>
	</head>
	<body>
	<%  int l = Integer.parseInt(request.getSession().getAttribute("laps").toString()); %>
	<%  int d = Integer.parseInt(request.getSession().getAttribute("days").toString());%>
	<%! String nameForm = "<div class=\"form-group\"><label class=\"sr-only\">Full Name</label><input name=\"name\" type=\"text\" class=\"form-control\" placeholder=\"Full Name\"></div>"; %>
	<%! String dateForm = "<div class=\"form-group\"><label class=\"sr-only\">Birthdate</label><input name=\"date\" type=\"text\" class=\"form-control\"  placeholder=\"BirthDate dd/MM \"></div>"; %>
	<%! String buttonForm = "<button type=\"submit\" class=\"btn btn-default\">Enter</button>"; %>
	<%! String form = "<form style=\"margin-bottom:15px\" method=\"post\" action=\"/Labone/ShowSession\"  class=\"form-inline\">"+nameForm+dateForm+buttonForm+"</form>"; %>
	<%! String block = form + "<p>Please, don't mess with de date format<br/> 19/06 for de 19th june.</p>"; %>		
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
			<div class="row ">
				<div class="col-md-offset-1 col-md-6">
				<% if(l > 0){
						out.print("<div style=\"border:#31708f 1px solid;\"; class=\"alert alert-info\" role=\"alert\"><strong>Ok dude! </strong>It seems like ur a regular visitor.</div>");
					} else {
						out.print("<div style=\"border:green 1px solid;\"; class=\"alert alert-success\" role=\"alert\"><strong>Congrats! </strong>This is your first time here!!!</div>");
						if(d >= 0){
							out.print("Hi,"+request.getSession().getAttribute("name")+". There are "+d+" days to your birthday.<br/><br/>");
						} else {
							out.print(block);
						}				
					}%>
					<a href="/Labone/DeleteSession?delete=1" class="btn btn-primary btn-lg <% if(!(l > 0))out.print("disabled");%>" role="button">let's pretend this is your first time.</a>	
				</div >
			</div >	
		</div>
	</body>
	<script src="/Labone/js/jquery-1.11.2.min.js"></script>
	<script src="/Labone/js/bootstrap.min.js"></script>
</html>