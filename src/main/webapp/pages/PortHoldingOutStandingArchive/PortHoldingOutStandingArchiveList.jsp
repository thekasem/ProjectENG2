<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>PortHolding OutStanding Archive Log List</title>
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
	<s:url action="portHoldingBySubAccountArchive_search"
		var="searchaumport"></s:url>
	<s:url action="portHoldingBySubAccountArchive_list" var="listaumport"></s:url>
	<div class="wrapper">
		<s:url action="activityArchive_search" var="search"></s:url>
		<s:include value="/pages/Menu/menuV.jsp"></s:include>

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h1>
				AUM Archive <small>Version 6.0</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-home"></i> AUM Archive</a></li>
				<li class="active">By SubAcc</li>
				<li class="active">List</li>
			</ol>
			</section>

			<section class="content">
			<div class="col-md-12">
				<div class="col-md-5">
					<s:a type="button" class="btn btn-primary" href="%{searchaumport}">
						<span class="fa fa-search"></span> Search</s:a>
					<s:a type="button" class="btn btn-primary" href="%{listaumport}">
						<span class="fa fa-refresh"></span> Refresh</s:a>
				</div>

				<div style="margin-top: 10px;" align="right">
					<h3>
						<span class="label label-default"><span class="fa fa-list">
								List</span></span>
					</h3>
				</div>


				<div class="box box-success">
					<div class="box-header with-border">
						<Strong>List PortHolding OutStanding Archive Log</Strong>
					</div>
					<div class="panel-body">
						<form class="form-horizontal">
							<div class="table-responsive">
								<table class="table table-striped table-hover">
									<thead style="color: #4863A0;">
										<th>Port Holding ID</th>
										<th>SubaccountNo</th>
										<th>AccountName</th>
										<th>BranchCode</th>
										<th>CurrencyCode</th>
										<th>CustomerName</th>
										<th>AUM Date</th>
										<th>Market Value</th>
										<th>User Archive</th>
										<th>Date Archive</th>
										<th>Condition Archive</th>
									</thead>
									<tbody>
										<s:iterator value="list">
											<tr style="color: #98AFC7;">
												<td><s:property value="portHoldingId" /></td>
												<td><s:property value="subAccountId" /></td>
												<td><s:property value="accountName" /></td>
												<td><s:property value="branchCode" /></td>
												<td><s:property value="currencyCode" /></td>
												<td><s:property value="customerNameEn" /></td>
												<td><s:property value="aumDate" /></td>
												<td><s:property value="marketValue" /></td>
												<td><s:property value="userArchive" /></td>
												<td><s:property value="dateArchive" /></td>
												<td><s:property value="conditionArchive" /></td>
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
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