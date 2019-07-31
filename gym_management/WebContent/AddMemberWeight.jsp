<!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Weight</title>
<style type="text/css">
.error {
	color: red
}
</style>
<link rel="stylesheet" href="css/bootstrap.min.css" />
</head>
<body>
	<%@include file="Header.jsp"%>
	<div class="container" style="background-color: aliceblue;">
		<br>
		<div class="row">
			<div class="col-md-3"></div>
			<div class="col-md-5">
				<h4 align="center">Add Member wt</h4>
			</div>
		</div>
		<br>
		
		<form:form method="POST" action="addWeight.do"
			modelAttribute="memberWt">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<form:hidden path="mid" class="form-control" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<label>Name</label>
					<form:input path="memberName" class="form-control" readonly="true"/>
					<form:errors path="memberName" cssClass="error" />
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<label>Current Weight</label>
					<form:input path="currentWt" class="form-control" />
					<form:errors path="currentWt" cssClass="error" />
				</div>
			</div>
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4">
					<label>New Weight Date</label>
					<form:input type="date" path="wtDate" class="form-control" />
					<form:errors path="wtDate" cssClass="error" />
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-sm-5"></div>
				<div class="col-md-2">
					<input type="submit" class="form-control" value="Add Date" />
				</div>
			</div>
		</form:form>
		<br></br>
	</div>
	<!-- <div class="container-fliud"
		style="background-color: slategrey; color: white; height: 55px;">
		<div class="row">
			<div class="col-md-12">
				<br>
				<h5 align="center">© 2019 Gold Gym . All Rights Reserved</h5>
			</div>
		</div>
	</div> -->
	<script type="js/bootstrap.min.js"></script>
	<script type="js/jquery-3.2.1.min.js"></script>
</body>
</html>