<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Dashboard Percent New User</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	<div class="wrapper">
		<s:include value="/pages/Menu/menuV.jsp"></s:include>
		<div class="content-wrapper" style="background: #2C3B41;">
			<!-- Content Header (Page header) -->
			<section class="content-header" style="color: white">
			<h1>
				Dashboard <small>Version 6.0</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#" style="color: white"><i class="fa fa-home"></i>
						Dashboard </a></li>
				<li class="active" style="color: white">Percent New User</li>
			</ol>
			</section>

			<section class="content">
			<div class="row">

				<div class="col-md-12">
					<div style="margin-top: 20px"></div>
					<div class="container ">
						<div class="row">

							<div class="col-md-9">
								<div class="box box-warning">
									<div class="box-header with-border">
										<Strong>Details Dashboard</Strong>
									</div>
									<div class="panel-body box box box-warning">
										<form class="form-horizontal">
											<div class="well">
												<h4>
													<span class="fa fa-user-plus"> <b>Percent New
															User</b></span>
												</h4>
												<div class="form-group">
													<label class="col-md-2 control-label">Year :</label>
													<div class="col-md-3">
														<div class="form-group has-feedback">
															<s:select id="top-module" class="form-control"
																headerKey="-1" list="listYears" name="year" />
															<span class="fa fa-calendar form-control-feedback"></span>
														</div>
													</div>
												</div>

												<div class="input-group text-center">
													<div class="col-md-2">
														<div id="dashboardnewuser" style="width: 750px;"></div>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="col-md-3">
								<s:include value="/pages/Dashboard/Sidebar.jsp"></s:include>
							</div>
						</div>
					</div>
				</div>
			</div>
			</section>
			<!-- Main content -->
		</div>
		<s:include value="/pages/Menu/footer.jsp"></s:include>
	</div>

	<script
		src="calendar/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
	<script src="js/highcharts.js"></script>
	<script src="js/exporting.js"></script>
	<script src="js/highcharts-3d.js"></script>
	<script src="js/team-highcharts.js"></script>
	<script src="js/moment.js"></script>
	<script src="DetailsDashboardSidebar/percentnewuser.js"></script>
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