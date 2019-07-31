<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Member</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<%@include file="Header.jsp" %>
	<div class="container" style="background-color:aliceblue;  height:600px;">
	<br>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5"><h4 align="center">Add Member</h4></div>
		</div>
		<br>
		<div class="form-row">
			<div class="col-md-4"></div>
			<div class="col-md-3">
				<h5 style="color:green;">${message}</h5>
			</div>	
		</div>
		<form action="addMember.do" method="post">
		<div class="form-row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="fullName">Full Name</label>
				<input type="text" class="form-control" id="fullName" name="fullName" required/>
			</div>
			<div class="col-md-3">
				<label for="contacts">Contacts</label>
				<input type="number" class="form-control" id="contacts" name="contacts" required/>
			</div>		
		</div>
		<div class="form-row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="emailId">Email</label>
				<input type="email" class="form-control" id="emailId" name="emailId" required/>
			</div>
			<div class="col-md-3">
				<label for="currentWt">Current Weight</label>
				<input type="number" class="form-control" id="currentWt" name="currentWt" required/>
			</div>		
		</div>
		<div class="form-row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="gymType">Gym Type</label>
				<select id="gymType" name="gymType" class="form-control">
					<option value="">--select--</option>
				</select>
			</div>
			<div class="col-md-3">
				<label for="gender">Gender</label>
				<select id="gender" name="gender" class="form-control" required>
					<option value="">--select--</option>
					<option value="male">Male</option>
					<option value="female">Female</option>
				</select>
			</div>		
		</div>
		<div class="form-row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="userPlan">Gym Plane</label>
				<select id="userPlan" name="userPlan" class="form-control">
					<option value="">--select--</option>
				</select>
			</div>
			<div class="col-md-3">
				<label for="payment">Payment</label>
				<input type="number" class="form-control" id="payment" name="payment" readonly/>
			</div>		
		</div>
		<div class="form-row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<label for="joiningDate">Joining Date</label>
				<input type="date" id="joiningDate" name="joiningDate" class="form-control" required>
			</div>	
		</div>
		<br>
			<div class="form-row">
			<div class="col-md-3"></div>
			<div class="col-md-3">
				<input type="checkbox" id="isPaymentDone" name="isPaymentDone" required/>
				Payment is Done by Member.
			</div>		
		</div>
		<br>
		<div class="form-row">
			<div class="col-sm-4"></div>
			<div class="col-md-3">
				<input type="submit" class="form-control" value="Add Member"/>
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