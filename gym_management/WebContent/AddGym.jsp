<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Gym</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<%@include file="Header.jsp" %>
	<div class="container" style="background-color:aliceblue;  height:490px;">
	<br>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5"><h4 align="center">Add New Gym</h4></div>
		</div>
		<br>
		<form action="addGym.do" method="post">
		<div class="form-row">
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<label for="gymName">GYM Name</label>
				<input type="text" class="form-control" id="gymName" name="gymName" required/>
			</div>
		</div>
		<div class="form-row">
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<label for="gymLocation">Location</label>
				<input type="text" class="form-control" id="gymLocation" name="gymLocation" required/>
			</div>		
		</div>
		<div class="form-row">
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<label for="gymUserName">User Name</label>
				<input type="text" class="form-control" id="gymUserName" name="gymUserName" required/>
			</div>	
		</div>
		<div class="form-row">
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<label for="gymPassword">Password</label>
				<input type="password" class="form-control" id="gymPassword" name="gymPassword" required/>
			</div>		
		</div>
		
		<br>
		<div class="form-row">
			<div class="col-sm-4"></div>
			<div class="col-md-3">
				<input type="submit" class="form-control" value="Add Gym"/>
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