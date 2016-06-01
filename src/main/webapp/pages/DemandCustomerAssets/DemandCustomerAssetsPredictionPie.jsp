<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Demand Customer Assets Prediction</title>
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
				Demand Customer Assets Prediction <small>Computer
					Engineering</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#" style="color: white"><i class="fa fa-home"></i>
						Demand Customer Assets </a></li>
				<li class="active" style="color: white">Prediction</li>
			</ol>
			</section>

			<section class="content">

			<div class="row">
				<div style="margin-top: 10px;" align="right">
					<h3>
						<span class="label label-default"><span
							class="fa fa-line-chart"> Prediction</span></span>
					</h3>
				</div>
				<div class="box box-warning">
					<div class="box-header with-border">
						<Strong>Demand Customer Assets Prediction</Strong>
					</div>
					<div class="panel-body box box-warning">
						<form class="form-horizontal">
							<div class="row">
								<label class="col-md-1 control-label">Forecast :</label>
								<div class="has-feedback col-md-2">
									<s:select id="selectprediction" headerKey="-1"
										class="form-control"
										list="#{'1':'Naive Forecast', '2':'Exponential Smoothing Forecast', '3':'Techniques for Trend'}"
										name="function" value="1" />
									<span class="fa fa-line-chart form-control-feedback"></span>
								</div>
								<label class="col-md-1 control-label alphavalue">Alpha
									Value:</label>
								<div class="has-feedback col-sm-2 alphavalue">
									<s:select id="alpha" headerKey="-1"
										class="form-control alphavalue"
										list="#{'0.5':'0.5', '0.1':'0.1', '0.05':'0.05','0.01':'0.01'}"
										name="selectchart" value="0.5" />
									<span class="fa fa-bar-chart form-control-feedback alphavalue"></span>
								</div>

								<label class="col-md-1 control-label">Chart :</label>
								<div class="has-feedback col-sm-2">
									<s:select id="selectchart" headerKey="-1" class="form-control"
										list="#{'1':'line chart', '2':'column chart', '3':'scatter chart'}"
										name="selectchart" value="1" />
									<span class="fa fa-bar-chart form-control-feedback"></span>
								</div>

								<div class="col-md-2">
									<s:a type="button" class="btn btn-primary"
										href="demandCustomerAssets_predictionpie">
										<span class="fa fa-refresh"></span>
													 Refresh
											    </s:a>
								</div>
							</div>
							<div style="margin: 20px"></div>

							<div class="row">
								<div class="col-md-10">

									<!-- 										show line chart -->
									<div class="well col-md-12" id="line">
										<div class="col-sm-6">
											<div id="lineprediction"
												style="width: 1180px; height: 520px;"></div>
										</div>
									</div>

									<!-- 									show column chart -->
									<div class="well col-md-12" id="column">
										<div class="col-sm-6">
											<div id="columnprediction"
												style="width: 1150px; height: 520px;"></div>
										</div>
									</div>

									<!-- 									show scatter chart -->
									<div class="well col-md-12" id="scatter">
										<div class="col-sm-6">
											<div id="scatterprediction"
												style="width: 1150px; height: 520px;"></div>
										</div>
									</div>

								</div>
								<div class="col-md-2 text-purple">
									<div class="box box-primary">
										<div class="box-header text-light-blue">
											<h3 class="box-title">Error values prediction</h3>
										</div>
										<!-- /.box-header -->
										<div id="showtable" class="box-body no-padding">
<!-- 											<table id="table" class="table table-striped"> -->
<!-- 												<tr> -->
<!-- 													<th style="width: 10px">#</th> -->
<!-- 													<th>Task</th> -->
<!-- 													<th>Progress</th> -->
<!-- 													<th style="width: 40px">Label</th> -->
<!-- 												</tr> -->
<!-- 											</table> -->
										</div>
										<!-- /.box-body -->
									</div>
									<!-- /.box -->
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
	<script
		src="calendar/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
	<script src="js/highcharts.js"></script>
	<script src="js/exporting.js"></script>
	<script src="js/team-highcharts.js"></script>
	<script src="GraphPrediction/predictionAll.js"></script>
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