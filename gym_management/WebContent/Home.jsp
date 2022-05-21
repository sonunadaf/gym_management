<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<%@include file="Header.jsp" %>
	<div class="container" style="background-color:aliceblue; color:black; height:490px;">
	<br>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-4"><h4 align="center"></h4></div>
		</div>
		<br>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
			<h5 style="color:black;">
			<a  href="addMember.do" style="color:black;"> 1. Add Member</a><br></br>
			<a  href="appointment.do" style="color:black;">2. Enquiry Form</a> <br></br>
			<a  href="addGym.do" style="color:black;">3. Add New Gym</a><br></br>
			<a  href="memberList.do" style="color:black;">4. Member List</a><br></br>
			<a  href="addGymType.do" style="color:black;">5. Add Gym Type  </a> <br></br>
			<a  href="#" style="color:black;">6. Add Plan  </a> 
			</h5>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-4"><h4 align="center"></h4></div>
		</div>
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