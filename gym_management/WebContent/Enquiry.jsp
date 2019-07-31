<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enquiry Form</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<%@include file="Header.jsp" %>
	<div class="container" style="background-color:aliceblue;  height:490px;">
	<br>
	<form action="appointment.do" method="post">
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5"><h3 align="center">Enquiry Form</h3></div>
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="aName">Full Name</label>
				<input type="text" class="form-control" name="aName" id="aName" required/>
			</div>
			<div class="col-md-3">
				<label for="enquiryDate">Enquiry Date</label>
				<input type="date" class="form-control" name="enquiryDate" id="enquiryDate" required/>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="contacts">Contacts</label>
				<input type="number" name="contacts" class="form-control" id="contacts"/>
			</div>
			<div class="col-md-3">
				<label for="gender">Gender</label>
				<select id="gender" name="gender" class="form-control">
					<option value="">--select--</option>
					<option value="male">Male</option>
					<option value="female">Female</option>
				</select>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="reason">Reason</label>
				<textarea rows="4" cols="75" id="reason" name="reason"></textarea>
			</div>		
		</div><br>
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<input type="submit" class="form-control" value="add">
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
</body>
<script type="js/bootstrap.min.js"></script>
	<script type="js/jquery-3.2.1.min.js"></script>
</html>