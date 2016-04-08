<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Demand Customer Assets Analysis Column</title>
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
				Demand Customer Assets Analysis Column<small>Computer Engineering</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#" style="color: white"><i class="fa fa-home"></i>
						Demand Customer Assets </a></li>
				<li class="active" style="color: white">Analysis</li>
			</ol>
			</section>

			<section class="content">

			<div class="row">
				<div style="margin-top: 10px;" align="right">
					<h3>
						<span class="label label-default"><span
							class="fa fa-pie-chart"> Analysis Column</span></span>
					</h3>
				</div>
				<div class="box box-warning">
					<div class="box-header with-border">
						<Strong>Demand Customer Assets Analysis Column</Strong>
					</div>
					<div class="panel-body box box box-warning">
						<form class="form-horizontal">
								<div class="row well">
								<div class="col-md-1">
									<button type="button" class="btn btn-info" data-toggle="modal"
										data-target="#myModal">
										<span class="fa fa-search-plus"></span> See more
									</button>

								</div>
								<div class="modal" id="myModal" role="dialog">
									<div class="modal-dialog">

										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">select type by see more</h4>
											</div>
											<div class="modal-body">
												<!-- checkbox -->
												<div class="row">
													<div class="col-md-6">
														<div class="checkbox">
															<label> <input type="checkbox"> Foreign
																stocks
															</label>
														</div>

														<div class="checkbox">
															<label> <input type="checkbox"> Exchange
																rate
															</label>
														</div>

														<div class="checkbox">
															<label> <input type="checkbox"> Gold
															</label>
														</div>
														<div class="checkbox">
															<label> <input type="checkbox"> Land
															</label>
														</div>
													</div>
													<div class="col-md-6">
														<div class="checkbox">
															<label> <input type="checkbox"> Oil
															</label>
														</div>
														<div class="checkbox">
															<label> <input type="checkbox"> Building
															</label>
														</div>
														<div class="checkbox">
															<label> <input type="checkbox"> Equipment
															</label>
														</div>
														<div class="checkbox">
															<label> <input type="checkbox"> Mine
															</label>
														</div>
													</div>
												</div>
											</div>
											<div class="modal-body">
												<!-- checkbox -->
												<div class="row">
													<div class="col-md-6">
														<div class="checkbox">
															<label> <input type="checkbox"> Person
															</label>
														</div>
													</div>
													<div class="col-md-6">
														<div class="checkbox">
															<label> <input type="checkbox">
																Corporation
															</label>
														</div>
													</div>
												</div>
											</div>

											<div class="modal-footer">
												<button type="button" class="btn btn btn-primary">submit</button>
											</div>
										</div>

									</div>
								</div>
								
								<div class="col-md-2">
									<div class="has-feedback">
										<s:select id="selecttime" headerKey="-1" class="form-control"
											list="#{'1':'All Year', '2':'Year', '3':'Month'}"
											name="selecttime" value="1" />
										<span class="fa fa-calendar form-control-feedback"></span>
									</div>
								</div>
								
								<div class="selectfromyear">
									<label class="col-md-1 control-label">From Year :</label>
									<div class="col-md-2">
										<div class="has-feedback">
											<s:select id="top-module" class="form-control" headerKey="-1"
												list="listYears" name="year" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>

									<label class="col-md-1 control-label">To Year :</label>
									<div class="col-md-2">
										<div class="has-feedback">
											<s:select id="top-module" class="form-control" headerKey="-1"
												list="listYears" name="year" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>
								</div>
								<div class="selectfrommonth">
									<label class="col-md-1 control-label">From Month :</label>
									<div class="col-md-2">
										<div class="has-feedback">
											<s:select class="selectfrommonth form-control" headerKey="-1"
												list="#{'1':'January', '2':'February', '3':'March', '4':'April', '5':'May', '6':'June', '7':'July', '8':'August', '9':'September', '10':'October', '11':'November', '12':'December'}"
												name="selectfrommonth" value="1" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>

									<label class="col-md-1 control-label">To Month :</label>
									<div class="col-md-2">
										<div class="has-feedback">
											<s:select class="selectfrommonth form-control" headerKey="-1"
												list="#{'1':'January', '2':'February', '3':'March', '4':'April', '5':'May', '6':'June', '7':'July', '8':'August', '9':'September', '10':'October', '11':'November', '12':'December'}"
												name="selectfrommonth" value="1" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>

									<label class="col-md-1 control-label">To Year :</label>
									<div class="col-md-2">
										<div class="has-feedback">
											<s:select id="top-module" class="form-control" headerKey="-1"
												list="listYears" name="year" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>
								</div>
								
								<div class="col-md-12" style="margin: 10px"></div>

								<div class="col-sm-1">
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle" type="button"
											data-toggle="dropdown">
											Select Chart <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><s:a href="analysis_analysispie">Pie Chart</s:a></li>
											<li><s:a href="analysis_analysisline">Line Chart</s:a></li>
											<li><s:a href="analysis_analysiscolumn">Column Chart</s:a></li>
											<li><s:a href="analysis_analysisscatter">Scatter Chart</s:a></li>
										</ul>
									</div>
								</div>

								<div class="col-md-2">
									<s:a type="button" class="btn btn-primary"
										href="analysis_analysiscolumn">
										<span class="fa fa-refresh"></span>
													 Refresh
											    </s:a>
								</div>
							</div>

							<div class="well col-md-12">
								<div class="col-md-6">
									<div id="columnanalysis" style="width: 750px;"></div>
								</div>
								<div class="col-md-6">
									<div id="columnanalysisperson" style="width: 750px;"></div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			</section>
			<!-- Main content -->
		</div>
		<s:include value="/pages/Menu/footer.jsp"></s:include>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script src="js/highcharts.js"></script>
	<script src="js/exporting.js"></script>
	<script src="js/highcharts-3d.js"></script>
	<script src="js/team-highcharts.js"></script>
	<script src="GraphAnalysis/columnAnalysis.js"></script>
	<script src="GraphAnalysis/callFromDate.js"></script>
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