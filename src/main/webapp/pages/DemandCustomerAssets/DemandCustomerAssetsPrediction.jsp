<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Demand Customer Assets Analysis</title>
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


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="background: #2C3B41;">
			<!-- Content Header (Page header) -->
			<section class="content-header" style="color: white">
			<h1>
				Demand Customer Assets Prediction <small>Version 6.0</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#" style="color: white"><i class="fa fa-home"></i>
						Demand Customer Assets </a></li>
				<li class="active" style="color: white">Prediction</li>
			</ol>
			</section>

			<section class="content">

			<div class="col-md-12">
				<div style="margin-top: 20px"></div>
				<div class="container ">
					<div class="row">
						<div style="margin-top: 10px;" align="right">
							<h3>
								<span class="label label-default"><span
									class="fa fa-line-chart"> Prediction</span></span>
							</h3>
						</div>
						<div class="box box-warning">
							<div class="box-header with-border">
								<Strong>Details Dashboard</Strong>
							</div>
							<div class="panel-body box box box-warning">
								<form class="form-horizontal">
									<div class="well" style="padding-bottom: 0;">
										<div class="row">
											<div class="col-sm-7">
											</div>
											
											<div class="form-group col-sm-2">
												<div class="dropdown">
													<button class="btn btn-info dropdown-toggle" type="button"
														data-toggle="dropdown">
														Select Chart <span class="caret"></span>
													</button>
													<ul class="dropdown-menu">
														<li><a href="#">Chart1</a></li>
														<li><a href="#">Chart2</a></li>
														<li><a href="#">Chart3</a></li>
													</ul>
											
												</div>
											</div>
											
											<div class="form-group col-sm-2">
												<s:a type="button" class="btn btn-primary" href="%{}">
													<span class="fa fa-refresh"></span>
													 Refresh
											    </s:a>	
											</div>
										</div>
									</div>
									
									<div class="well">
										<div id="dashboardbrowser" style="width: 750px;"></div>
									</div>
								</form>
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
	<script src="js/team-highcharts.js"></script>
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