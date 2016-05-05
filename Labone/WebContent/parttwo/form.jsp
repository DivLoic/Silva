<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Labone - Fill the Form.</title>
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
				<div id="mainform" class="col-md-offset-1 col-md-6">
					<form class="form-horizontal" method="post" action="/Labone/parttwo/bean.jsp">
		 	 			<div class="form-group">
		    				<div class="col-sm-10">
		      					<input name="firstName" type="text" class="form-control" id="inputEmail3" placeholder="firstname">
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<div class="col-sm-10">
		      					<input name="lastName" type="text" class="form-control" id="inputPassword3" placeholder="lastname">
		    				</div>
		  				</div>
		  				<div class="form-group">
		    				<div class="col-sm-10">
		      					<input name="date" type="Date" class="form-control" id="inputPassword3" placeholder="date">
		    				</div>
		  				</div>
		  				<div class="radio">
						  <label style="margin:10px;">
						    <input type="radio" name="sex" id="optionsRadios1" value="homme">H
						  </label>
						  <label>
						    <input type="radio" name="sex" id="optionsRadios2" value="femme">F
						  </label>
						</div>
		  				<div class="form-group">
		    				<div class="col-sm-offset-0 col-sm-10">
		      					<button type="submit" class="btn btn-default">Submit</button>
		    				</div>
		  				</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	<script src="/Labone/js/jquery-1.11.2.min.js"></script>
	<script src="/Labone/js/bootstrap.min.js"></script>
</html>