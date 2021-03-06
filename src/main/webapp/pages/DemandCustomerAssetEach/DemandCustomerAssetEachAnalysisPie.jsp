<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Analysis of purchase</title>
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
	<s:url action="analysis_analysispie" var="analysispie"></s:url>
	<s:url action="analysis_analysisline" var="analysisline"></s:url>
	<s:url action="analysis_analysiscolumn" var="analysiscolumn"></s:url>
	<s:url action="analysis_analysisscatter" var="analysisscatter"></s:url>
	<s:url action="analysis_monthanalysispie" var="monthanalysispie"></s:url>


	<div class="wrapper">
		<s:include value="/pages/Menu/menuV.jsp"></s:include>


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper" style="background: #2C3B41;">
			<!-- Content Header (Page header) -->
			<section class="content-header" style="color: white">
			<h1>
				Each Analysis of purchase Pie<small>Computer
					Engineering</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#" style="color: white"><i class="fa fa-home"></i>
						Each Analysis of purchase </a></li>
				<li class="active" style="color: white">Analysis</li>
			</ol>
			</section>

			<section class="content">

			<div class="row">
				<div style="margin-top: 10px;" align="right">
					<h3>
						<span class="label label-default"><span
							class="fa fa-pie-chart"> Analysis Pie</span></span>
					</h3>
				</div>
				<div class="box box-warning">
					<div class="box-header with-border">
						<Strong>Each Analysis of purchase Pie</Strong>
					</div>
					<div class="panel-body box box box-warning">
							<div class="row well">
								<div class="col-sm-1">
									<div class="dropdown">
										<button class="btn btn-default dropdown-toggle" type="button"
											data-toggle="dropdown">
											Select Chart <span class="caret"></span>
										</button>
										<ul class="dropdown-menu">
											<li><s:a href="eachanalysis_analysispie">Pie Chart</s:a></li>
											<li><s:a href="eachanalysis_analysisline">Line Chart</s:a></li>
											<li><s:a href="eachanalysis_analysiscolumn">Column Chart</s:a></li>
											<li><s:a href="eachanalysis_analysisscatter">Scatter Chart</s:a></li>
										</ul>
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
											<s:select id="fromyear" class="form-control" headerKey="-1"
												list="listYears" name="year" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>

									<label class="col-md-1 control-label">To Year :</label>
									<div class="col-md-2">
										<div class="has-feedback">
											<s:select id="toyear" class="form-control" headerKey="-1"
												list="listYears" name="year" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>
								</div>
								<div class="selectfrommonth">
									<label class="col-md-1 control-label">From Month :</label>
									<div class="col-md-2">
										<div class="has-feedback">
											<s:select id="frommonth" class="selectfrommonth form-control" headerKey="-1"
												list="#{'1':'January', '2':'February', '3':'March', '4':'April', '5':'May', '6':'June', '7':'July', '8':'August', '9':'September', '10':'October', '11':'November', '12':'December'}"
												name="selectfrommonth" value="1" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>

									<label class="col-md-1 control-label">To Month :</label>
									<div class="col-md-2">
										<div class="has-feedback">
											<s:select id="tomonth" class="selectfrommonth form-control" headerKey="-1"
												list="#{'1':'January', '2':'February', '3':'March', '4':'April', '5':'May', '6':'June', '7':'July', '8':'August', '9':'September', '10':'October', '11':'November', '12':'December'}"
												name="selectfrommonth" value="1" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>

									<label class="col-md-1 control-label">To Year :</label>
									<div class="col-md-2">
										<div class="has-feedback">
											<s:select id="toyear2" class="form-control" headerKey="-1"
												list="listYears" name="year" />
											<span class="fa fa-calendar form-control-feedback"></span>
										</div>
									</div>
								</div>

								<div class="col-md-12" style="margin: 10px"></div>

								<label class="col-md-1 control-label">Analysis Data :</label>
								<div class="col-md-2">
									<div class="has-feedback">
										<s:select id="analysisid" headerKey="-1" class="form-control"
											list="#{'1':'Customer', '2':'Asset'}" name="analysisid"
											value="1" />
										<span class="fa fa-users form-control-feedback"></span>
									</div>
								</div>

								<div class="analysisidcustomer">
									<label  class="col-md-1 control-label">ID Customer :</label>
									<div class="col-md-2">
										<s:textfield id="customerid" name="analysisidcustomer" cssClass="form-control"></s:textfield>
									</div>
								</div>

								<div class="analysisidasset">
									<label class="col-md-1 control-label">ID Asset :</label>
									<div class="col-md-2">
										<s:textfield id="assetid" name="analysisidasset" cssClass="form-control"></s:textfield>
									</div>
								</div>

								<div class="col-md-1">
									<s:a type="button" class="btn btn-primary"
										href="eachanalysis_analysispie">
										<span class="fa fa-refresh"></span>
													 Refresh
											    </s:a>
								</div>

								<div class="col-md-1">
									<button id="send"  class="btn btn-primary" >
										<span class="fa fa-search"></span>
													Submit
											    </button>
								</div>

							</div>

							<div style="margin: 20px"></div>

							<div class="well col-md-12" id="showcustomer">
								<div class="col-sm-offset-2 col-sm-6">
									<div class="analysisidcustomer">
										<div id="pieanalysis" style="width: 1050px; height: 450px;"></div>
									</div>

								</div>
							</div>
							<div class="well col-md-12" id="showasset">
								<div class="col-sm-offset-2 col-sm-6">

									<div class="analysisidasset">
										<div id="pieanalysisperson" style="width: 1050px; height: 450px;"></div>
									</div>
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
	<script src="GraphAnalysis/pieEachAnalysis.js"></script>
	<script src="GraphAnalysis/callFromDate.js"></script>
	<script src="GraphAnalysis/callFromId.js"></script>
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