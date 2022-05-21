<!doctype html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Gym List</title>
<style type="text/css">
.error {
	color: red
}
</style>
<meta name="description" content="Ela Admin - HTML5 Admin Template">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
<link rel="stylesheet"
	href="assets/css/lib/datatable/dataTables.bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
								<strong class="card-title">Plan List</strong>
							</div>
							<div class="card-body">
								<table id="bootstrap-data-table"
									class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>Name</th>
											<th>Created Date</th>
											<th>View Plan</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${gymTypeList}" var="current">
											<tr>
												<td><c:out value="${current.gymTypeName}"></c:out></td>
												<td><c:out value="${current.gymTypeName}"></c:out></td>
												<td><a href="viewPlan.do?gtId=${current.gymTypeId}" >View</a>
												</td>
												<%-- <td> &nbsp <a href="addWeight.do?mId=${member.mId}">Add</a></td> --%>
											</tr>
										</c:forEach>
									</tbody>
									<tbody>
										<form:form action="addGymType.do" method="post" modelAttribute="gymType">
											<td><form:input path="gymTypeName" type="text" class="form-control"/>
											<form:errors path="gymTypeName" cssClass="error"/></td>
											<td><input type="submit" value="add" class="form-control"> </td>
										</form:form>
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
	

</body>
</html>
