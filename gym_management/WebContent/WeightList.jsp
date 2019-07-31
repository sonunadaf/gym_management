<!doctype html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Member List</title>
<meta name="description" content="Ela Admin - HTML5 Admin Template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
<link rel="stylesheet"
	href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
</head>
<body>
	<%@include file="Header.jsp"%>
	<div class="container">
		<!-- Right Panel -->
		<div class="content">
			<div class="animated fadeIn">
				<div class="row">

					<div class="col-md-12">
						<div class="card">
							<div class="card-header">
								<strong class="card-title">${member.fullName}</strong>
							</div>
							<div class="card-body">
								<table id="bootstrap-data-table"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Last Weight Date</th>
											<th>Last Weight</th>
											<th>Add Weight</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${weightlist}" var="current">
											<tr>
												<td><c:out value="${current.lastWtDate}"></c:out></td>
												<td><c:out value="${current.lastMonthWt}"></c:out></td>
												<td> &nbsp <a href="addWeight.do?mId=${member.mId}">Add</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>


				</div>
			</div>
			<!-- .animated -->
		</div>
		<!-- .content -->


		<div class="clearfix"></div>

	</div>
	<!-- /#right-panel -->
	<!-- <div class="container-fliud"
		style="background-color: slategrey; color: white; height: 55px;">

		<div class="row">
			<div class="col-md-12">
				<br>
				<h5 align="center">© 2019 Gold Gym . All Rights Reserved</h5>
			</div>
		</div>
	</div> -->
	<!-- Right Panel -->


</body>
</html>
