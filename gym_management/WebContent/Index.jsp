<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<div class="container-fliud" style="background-color:slategrey; color:white; height:60px;">
		
		<div class="row">
			<div class="col-md-2">
				<h1 align="center">Gold_Gym</h1>
			</div>
		</div>
	</div>
	<div class="container" style="background-color:aliceblue;  height:490px;">
	<br>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-4"><h4 align="center">Admin Panel</h4></div>
		</div>
		<br>
		<div class="form-row">
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<div style="color:red;">${error}</div>
			</div>		
		</div>
		<form action="login.do" method="post">
		<div class="form-row">
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<label for="userName">User Name</label>
				<input type="text" class="form-control" id="userName" name="userName" required/>
			</div>		
		</div>
		<div class="form-row">
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<label for="password">Password</label>
				<input type="password" class="form-control" id="password" name="password" required/>
			</div>		
		</div>
		<br>
		<div class="form-row">
			<div class="col-sm-5"></div>
			<div class="col-md-1">
				<input type="submit" class="form-control" value="login"/>
			</div>		
		</div>
		</form>
	</div>
	<div class="container-fliud" style="background-color:slategrey; color:white; height:55px;">
		
		<div class="row">
			<div class="col-md-12"><br>
				<h5 align="center">© 2019 Gold Gym . All Rights Reserved</h5>
			</div>
		</div>
	</div>
	<script type="js/bootstrap.min.js"></script>
	<script type="js/jquery-3.2.1.min.js"></script>
</body>
</html>