<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Labone - Items</title>
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
				<div id="mainform" class=" col-md-offset-1 col-md-6">
					<form class="form-horizontal" method="post" action="/Labone/ListItems">
		 	 			<div class="form-group">
		    				<div class="col-md-6">
		      					<input name="item" type="text" class="form-control" placeholder="Your Item Here">
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<div class="col-sm-offset-0 col-sm-10">
		      					<button type="submit" class="btn btn-default">Submit</button>
		    				</div>
		  				</div>
					</form>
					<div>
						<div>
							<% out.print(request.getSession().getAttribute("line")); %>
						</div>
					</div>
					<div>
						<% HashMap<String, Integer> box = (HashMap<String, Integer>)request.getSession().getAttribute("items"); %>
						<table class="table table-hover">
							<tr>
	    						<td>Item</td>
	    						<td>number</td> 
	  						</tr>
	  						<%
	  						Iterator it = box.entrySet().iterator();
	  					    while (it.hasNext()) {
	  					        Map.Entry b = (Map.Entry)it.next();
	  					        out.print("<tr><td>"+b.getKey()+"</td>");
	  					      	out.print("<td>"+b.getValue()+"</td></tr>");
	  					        //it.remove(); // avoids a ConcurrentModificationException
	  					    }
	  						%>
	  					</table>
					</div>
				</div>
			</div>
		</div>
	</body>
	<script src="/Labone/js/jquery-1.11.2.min.js"></script>
	<script src="/Labone/js/bootstrap.min.js"></script>
</html>