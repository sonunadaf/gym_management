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
			<div class="col-md-7"></div>
			<div class="col-md-1"><br>
			<h6 align="center"><a  href="home.do" style="color:cyan;">Home</a></h6>				
			</div>
			<div class="col-md-2"> <h5 align="center">${gold.gymName}</h5>
			<h6 align="center"><a href="logout.do" style="color:cyan;">logout</a></div></h6>
		</div>
	</div>
	<script type="js/bootstrap.min.js"></script>
	<script type="js/jquery-3.2.1.min.js"></script>
</body>
</html>