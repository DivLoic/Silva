<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" href="/Labtwo/css/bootstrap.min.css">
		<link rel="stylesheet" href="/Labtwo/css/main.css">
		<title> Labtwo </title>
	</head>
	<body>
		<div class="container-fluid">
				<div class="col-md-offset-2 col-md-7">
					<h1>Technologie web: Labtwo</h1>
					<h4>DIVAD Loïc</h4>
				</div>
				<div class="col-md-offset-1 col-md-9"><hr/></div>
				<div class="col-md-offset-2 col-md-7 partone">
					<h1>First part of the Lab2</h1>
					<form action="card.jsp" method="get">
						<div class="form-group">
        				<fieldset>
        					<legend class="male">Peronal information</legend>
        					<div class="row">
        						<div class="col-md-offset-1 col-md-4 tag">First Name :</div>
        						<input  type="text" name="fName">
        					</div>
        					<div class="row">
        						<div class="col-md-offset-1 col-md-4 tag">Last Name :</div>
        						<input  type="text" name="lName">
        					</div>
        				</fieldset>
        				<fieldset>
        					<legend class="male">Birth Day </legend>
        					<div class="row">
        						<div class="col-md-offset-1 col-md-4 tag">Birth Day :</div> 
        						<input type="text" name="bDay">
        					</div>
        				</fieldset>
        				<fieldset>
        					<legend class="male">Sex </legend>
        					<div class="row">
        						<div class="col-md-offset-1 col-md-4 tag">Male</div>
        						<input type="radio" name="sex" value="male">
        					</div>
        					<div class="row">
        						<div class="col-md-offset-1 col-md-4 tag">Female</div>
        						<input type="radio" name="sex" value="female" checked>
							</div>
        				</fieldset>
        				<input onClick="return validation();" type="submit">
        				</div>
					</form>
				</div>
				<div class="col-md-offset-1 col-md-9"><hr/></div>
				<div class="col-md-offset-2 col-md-7 parttwo">
					<h1>Second part of the Lab2</h1>
					<ul>
						<li>
							<input type=button value="Random quote in h1" onClick="f1()">
						</li>
						<li>
							<input type=button value="Change the div" onClick="f2()">
						</li>
						<li>
							<input type=button value="Insert after the div" onClick="f3()">
						</li>
						<li>
							<input type=button value="Change the title" onClick="f4()">
						</li>
						<li>
							<input type=button value="Toggle" onClick="f5()"><span class="badge">@£#ù!&*$</span>
						</li>
					</ul>
					<div id="divtest" class="col-md-offset-0 col-md-12">This is a divtest for the lab session N°2</div>
				</div>
				<div class="col-md-offset-1 col-md-9"><hr/></div>
				<div class="col-md-offset-2 col-md-7 partthree">
					<h1>Login & Password<br/>check using AJAX</h1>
					<p>
					this is not really "secure" :s... but for the good of the execise, here is a list of id:passwd<br/>
					<strong>lmd:divad</strong>, <strong>abc:123</strong>, <strong>NicoTesla:Electro</strong>, <strong>MaxW:Magneto</strong> (Case sensitive)
					</p>
					<form action="/Labtwo/Home" method="post">
						<div class="form-group">
						<input type="text" name="id" placeholder="Your pseudo"/>
						<span class="ajaxflag failure" >Sorry there is no id like: <strong>"Speudo"</strong></span>
						<span class="ajaxflag succes">Welcome: <strong>"Speudo"</strong></span>
						<input type="password" name="password" placeholder="Your password"/>
						<input id="submitter3" type="submit">
						</div>
					</form>
				</div>
				<div class="col-md-offset-1 col-md-9"><hr/></div>
				<div class="col-md-offset-2 col-md-7 partfour">
					<h1>Autocopmlete contry using AJAX</h1>
					<form action="https://www.google.fr/maps/search/" method="get">
						<div class="form-group">
						<input type="text" name="id" placeholder="Your City"/><span class="badge">Press enter!</span>
						</div>
					</form>
				</div>
			</div>
		</body>
	<script src="/Labtwo/js/jquery-1.11.2.min.js"></script>
	<script src="/Labtwo/js/jquery-ui.min.js"></script>
	<script src="/Labtwo/js/bootstrap.min.js"></script>
	<script src="/Labtwo/js/action.js"></script>
</html>