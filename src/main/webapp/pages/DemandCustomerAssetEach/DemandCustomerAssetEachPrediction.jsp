<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>prediction total purchase</title>
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
				Each prediction total purchase values <small>Computer
					Engineering</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#" style="color: white"><i class="fa fa-home"></i>
						Each prediction total purchase </a></li>
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
						<Strong>Each prediction total purchase values</Strong>
					</div>
					<div class="panel-body box box-warning">
						<div class="row form-horizontal">
							<label class="col-md-1 control-label" >Forecast :</label>
							<div class="has-feedback col-md-2 ">
								<s:select id="selectprediction" headerKey="-1"
									class="form-control"
									list="#{'1':'Naive Forecast', '2':'Exponential Smoothing Forecast', '3':'Techniques for Trend', '4':'Neural Network'}"
									name="function" value="1" />
								<span class="fa fa-line-chart form-control-feedback"></span>
							</div>
							<label class="col-md-1 control-label alphavalue">Alpha
								Value:</label>
							<div class="has-feedback col-sm-2 alphavalue">
								<s:select id="alpha" headerKey="-1"
									class="form-control alphavalue"
									list="#{'0.9':'0.9', '0.7':'0.7', '0.5':'0.5', '0.3':'0.3', '0.1':'0.1', '0.09':'0.09', '0.07':'0.07', '0.05':'0.05','0.03':'0.03' ,'0.01':'0.01'}"
									name="selectchart" value="0.9" />
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
									href="eachpredicton_predictionpie">
									<span class="fa fa-refresh"></span>
													 Refresh
											    </s:a>
							</div>

							<div class="col-md-12" style="margin: 10px"></div>

							<label class="col-md-1 control-label">Prediction Type
								Data :</label>
							<div class="col-md-2">
								<div class="has-feedback">
									<s:select id="predictionid" headerKey="-1" class="form-control"
										list="#{'1':'Asset', '2':'Customer'}" name="predictionid"
										value="1" />
									<span class="fa fa-users form-control-feedback"></span>
								</div>
							</div>

							<div class="predictionidcustomer">
								<label class="col-md-1 control-label">Type Customer:</label>
								<div class="col-md-2 has-feedback">
									<s:select id="typecustomerid" headerKey="-1"
										class="form-control"
										list="#{'1':'corporation','2':'personal'}" name="selectchart"
										value="1" />
									<span class="fa fa-bar-chart form-control-feedback"></span>
								</div>
							</div>

							<div class="predictionidasset">
								<label class="col-md-1 control-label">Type Asset :</label>
								<div class="col-md-2 has-feedback">
									<s:select id="typeassetid" headerKey="-1" class="form-control"
										list="#{'1':'Foreign stocks', '2':'Exchange rate','3':'Gold','4':'Land','5':'Oil','6':'Building','7':'Equipment','8':'Mine'}"
										name="selectchart" value="1" />
									<span class="fa fa-bar-chart form-control-feedback"></span>
								</div>
							</div>


						</div>
						<div style="margin: 20px"></div>


						<div class="overlay">
							<i class="fa fa-refresh fa-spin"></i>
						</div>

						<div class="row">
							<div id="grahps" class="col-md-10">


								<div class="well col-md-12" id="line">
									<div class="col-sm-6">
										<div id="lineprediction" style="width: 1180px; height: 520px;"></div>
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
								<div id="erorprediction" class="col-md-2 text-purple">
									<div class="box box-primary">
										<div class="box-header with-border text-light-blue">
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
	<script src="GraphPrediction/predictionEach.js"></script>
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