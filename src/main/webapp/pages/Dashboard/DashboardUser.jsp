<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>DashBoard User</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="calendar/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/highmaps.js"></script>
<script src="js/exporting.js"></script>
<script src="js/th-all.js"></script>
<script src="js/team-highcharts.js"></script>
<script src="DetailsDashboardSidebar/usermap.js"></script>
<link rel="stylesheet"
	href="calendar/jquery-ui-1.11.4.custom/jquery-ui.min.css">
<script src="calendar/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="calendar/jquery-ui-1.11.4.custom/jquery-ui.structure.min.css">
<link rel="stylesheet"
	href="calendar/jquery-ui-1.11.4.custom/jquery-ui.theme.min.css">
</head>
<body style="background: #E5E4E2">
	<s:include value="/pages/Menu/menu.jsp"></s:include>
	<div class="row">

		<div class="col-md-2">
			<s:include value="/pages/Menu/menuV.jsp"></s:include>
		</div>
		<div class="col-md-10">
			<div style="margin-top: 20px"></div>
			<div class="container">
				<div class="row">
					<div class="col-md-3">
						<s:include value="/pages/Dashboard/Sidebar.jsp"></s:include>
					</div>
					<div col-md-9>
						<div class="panel panel-default"
							style="margin-top: 60px; margin-left: 270px;">
							<div class="panel-heading">
								<Strong>Details Dashboard</Strong>
							</div>
							<div class="panel-body box box-warning">
								<form class="form-horizontal">
									<div class="well">
										<h4>
											<span class="fa fa-users"> <b>User</b></span>
										</h4>
										<div class="form-group" style="margin-left: 50px;">
											<label class="col-md-2 control-label">From Date :</label>
											<div class="col-md-3">
												<s:textfield name="" cssClass="datepicker form-control"></s:textfield>
											</div>
											<label class="col-md-2 control-label">To Date :</label>
											<div class="col-md-3">
												<s:textfield name="" cssClass="datepicker form-control"></s:textfield>
											</div>
										</div>

										<div class="input-group text-center">
											<div class="col-md-2">
												<div id="dashboarduser"
													style="width: 800px; height: 500px; margin-top: -250px;"></div>
											</div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script>
		$('.datepicker').datepicker({
			changeYear : true,
			yearRange : '-100:+100',
			dateFormat : 'yymmdd'
		});
	</script>
	<style>
select.ui-datepicker-year {
	color: #000;
}
</style>
</body>
</html>