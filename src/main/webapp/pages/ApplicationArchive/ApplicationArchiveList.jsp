<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Application Archive List</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="calendar/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/ionicons.min.css">
<link rel="stylesheet"
	href="plugins/jvectormap/jquery-jvectormap-1.2.2.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<s:url action="applicationArchive_search" var="searchappl"></s:url>
	<s:url action="applicationArchive_list" var="listapp"></s:url>
	<s:url action="applicationArchive_add" var="addapp"></s:url>

	<div class="wrapper">
		<s:url action="activityArchive_search" var="search"></s:url>
		<s:include value="/pages/Menu/menuV.jsp"></s:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h1>
				Application Archive<small>Version 6.0</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-home"></i> Application Archive</a></li>
				<li class="active">List</li>
			</ol>
			</section>

			<section class="content">
			<div class="col-md-12">
				<div class="col-md-5">
					<s:a type="button" class="btn btn-primary" href="%{searchappl}">
						<span class="fa fa-search"></span> Search</s:a>
					<s:a type="button" class="btn btn-primary" href="%{listapp}">
						<span class="fa fa-refresh"></span> Refresh</s:a>
					<s:a type="button" class="btn btn-primary" href="%{addapp}">
						<span class="fa fa-plus-circle"></span> ADD Archive</s:a>
				</div>

				<div style="margin-top: 10px;" align="right">
					<h3>
						<span class="label label-default"><span class="fa fa-list">
								List</span></span>
					</h3>
				</div>

				<div class="box box-success">
					<div class="box-header with-border">
						<Strong>List Application Archive Log</Strong>
					</div>
					<div class="panel-body">
						<form class="form-horizontal">
							<table class="table table-striped table-hover ">
								<thead style="color: #4863A0;">
									<th>Event ID</th>
									<th>Date</th>
									<th>Time</th>
									<th>Level</th>
									<th>Entity Class</th>
									<th>Mode</th>
									<th>Client IP</th>
									<th>Front Server IP</th>
									<th>Member Name</th>
									<th>User Archive</th>
									<th>Date Archive</th>
									<th>Condition Archive</th>
								</thead>
								<tbody>
									<s:iterator value="list">
										<tr style="color: #98AFC7;">
											<td><s:property value="eventId" /></td>
											<td><s:property value="logDate" /></td>
											<td><s:property value="logTime" /></td>
											<td><s:property value="level" /></td>
											<td><s:property value="entityClass" /></td>
											<td><s:property value="mode" /></td>
											<td><s:property value="clientIP" /></td>
											<td><s:property value="frontServerIP" /></td>
											<td><s:property value="memberId" /></td>
											<td><s:property value="userArchive" /></td>
											<td><s:property value="dateArchive" /></td>
											<td><s:property value="coditionArchive" /></td>
										</tr>
									</s:iterator>
								</tbody>
							</table>
						</form>
						<s:include value="/pages/Menu/paging.jsp"></s:include>
					</div>
				</div>
			</div>
			</section>
			<!-- Main content -->
		</div>
		<!-- /.content-wrapper -->
		<s:include value="/pages/Menu/footer.jsp"></s:include>
	</div>
	<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="plugins/fastclick/fastclick.min.js"></script>
	<script src="dist/js/app.min.js"></script>
	<script src="plugins/sparkline/jquery.sparkline.min.js"></script>
	<script src="plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="plugins/chartjs/Chart.min.js"></script>
	<script src="dist/js/demo.js"></script>
</body>
</html>