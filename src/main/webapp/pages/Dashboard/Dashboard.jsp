<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>DashBoard</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="js/highcharts.js"></script>
<script src="js/highcharts-3d.js"></script>
<script src="js/highcharts-more.js"></script>
<script src="js/funnel.js"></script>
<script src="js/exporting.js"></script>
<script src="js/solid-gauge.js"></script>
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/bootstrap.min.js"></script>
<script src="js/team-highcharts.js"></script>
<script src="detailsdashboard/browsers.js"></script>
<script src="detailsdashboard/browser-donutchart.js"></script>
<script src="detailsdashboard/login.js"></script>
<script src="detailsdashboard/user.js"></script>
<script src="detailsdashboard/average.js"></script>
<script src="detailsdashboard/percent-new-user.js"></script>
<script src="detailsdashboard/topmodule.js"></script>
<script src="detailsdashboard/topuser.js"></script>
<script src="detailsdashboard/customer.js"></script>
<script src="detailsdashboard/view-aum.js"></script>
<script src="detailsdashboard/disk-usage.js"></script>

</head>
<body style="background: #E5E4E2">
	<s:include value="/pages/Menu/menu.jsp"></s:include>
	<div class="container" id="main">
		<div style="margin-top: 10px;" align="right">
			<h3>
				<span class="label label-default"><span
					class="fa fa-dashboard"> Dashboard</span></span>
			</h3>
		</div>

		<div class="panel panel-default" style="margin-top: 15px;">
			<div class="panel-heading">
				<Strong>Dashboard</Strong>
			</div>
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="row" style="">
						<div class="col-md-4 col-sm-6">
							<div class="well">
								<form class="form">
									<h4>Browsers</h4>
									<div class="input-group text-center">
										<div class="col-md-4">
											<div id="browser"
												style="min-width: 310px; height: 300px; max-width: 600px;"></div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="col-md-8 col-sm-6">
							<div class="well">
								<form class="form">
									<h4>Login</h4>
									<div class="input-group text-center">
										<div class="col-md-4">
											<div id="login"
												style="min-width: 650px; height: 300px; max-width: 650px;"></div>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>

					<div class="row" style="margin-left: 10px; margin-right: 10px;">
						<div class="col-md-8 col-sm-6">
							<div class="panel panel-info" style="margin: auto;">
								<div class="panel-heading">
									<h4>User</h4>
								</div>
								<div class="panel-body" style="height: 330px;">
									<div id="result" style="margin: auto; margin-top: 30px;"></div>
									<table id="table-sparkline"
										style="margin: auto; margin-top: 30px;">
										<thead>
											<tr>
												<th>State</th>
												<th>Income</th>
												<th>Income per quarter</th>
												<th>Costs</th>
												<th>Costs per quarter</th>
												<th>Result</th>
												<th>Result per quarter</th>
											</tr>
											<hr>
										</thead>
										<tbody id="tbody-sparkline">
											<tr>
												<th>Alabama</th>
												<td>254</td>
												<td data-sparkline="71, 78, 39, 66 " />
												<td>296</td>
												<td data-sparkline="68, 52, 80, 96 " />
												<td>-42</td>
												<td data-sparkline="3, 26, -41, -30 ; column" />
											</tr>
											<tr>
												<th>Alaska</th>
												<td>246</td>
												<td data-sparkline="87, 44, 74, 41 " />
												<td>181</td>
												<td data-sparkline="29, 54, 73, 25 " />
												<td>65</td>
												<td data-sparkline="58, -10, 1, 16 ; column" />
											</tr>
											<tr>
												<th>Arizona</th>
												<td>101</td>
												<td data-sparkline="56, 12, 8, 25 " />
												<td>191</td>
												<td data-sparkline="69, 14, 53, 55 " />
												<td>-90</td>
												<td data-sparkline="-13, -2, -45, -30 ; column" />
											</tr>
											<tr>
												<th>Arkansas</th>
												<td>303</td>
												<td data-sparkline="81, 50, 78, 94 " />
												<td>76</td>
												<td data-sparkline="36, 15, 14, 11 " />
												<td>227</td>
												<td data-sparkline="45, 35, 64, 83 ; column" />
											</tr>
											<tr>
												<th>California</th>
												<td>200</td>
												<td data-sparkline="61, 80, 10, 49 " />
												<td>217</td>
												<td data-sparkline="100, 8, 52, 57 " />
												<td>-17</td>
												<td data-sparkline="-39, 72, -42, -8 ; column" />
											</tr>
											<tr>
												<th>Wisconsin</th>
												<td>183</td>
												<td data-sparkline="24, 55, 21, 83 " />
												<td>224</td>
												<td data-sparkline="80, 64, 13, 67 " />
												<td>-41</td>
												<td data-sparkline="-56, -9, 8, 16 ; column" />
											</tr>
											<tr>
												<th>Wyoming</th>
												<td>231</td>
												<td data-sparkline="52, 49, 97, 33 " />
												<td>251</td>
												<td data-sparkline="96, 50, 23, 82 " />
												<td>-20</td>
												<td data-sparkline="-44, -1, 74, -49 ; column" />
											</tr>
										</tbody>
									</table>
								</div>
							</div>
						</div>

						<div class="col-md-4 col-sm-6">
							<div class="panel panel-info">
								<div class="panel-heading">
									<h4>Top Module</h4>
								</div>
								<div class="panel-body">
									<div class="row col-md-12">
										<div class="col-md-4">
											<div id="topmodule" style="width: 300px; height: 300px;"></div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-6 col-sm-6">
							<div class="well">
								<form class="form">
									<h4>Percent New User</h4>
									<div class="input-group text-center">
										<div class="col-md-4">
											<div id="newuser" style="width: 500px; height: 300px;"></div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="col-md-6 col-sm-6">
							<div class="well">
								<h4>Customers</h4>
								<div class="input-group text-center">
									<div class="col-md-4">
										<div id="customer" style="width: 500px; height: 300px;"></div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="row" style="margin-left: 10px; margin-right: 10px;">
						<div class="col-md-5 col-sm-6">
							<div class="panel panel-info">
								<div class="panel-heading">
									<h4>Top User</h4>
								</div>
								<div class="panel-body">
									<div class="row col-md-12">
										<div class="col-md-4">
											<div id="topuser" style="width: 390px; height: 300px;"></div>
										</div>
									</div>
								</div>
							</div>
						</div>

						<div class="col-md-7 col-sm-6" style="margin: auto;">
							<div class="panel panel-info" style="margin: auto;">
								<div class="panel-heading">
									<h4>Average Time On Site</h4>
								</div>
								<div class="panel-body">
									<div id="average" style="width: 550px; height: 300px;"></div>
								</div>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-md-8 col-sm-6">
							<div class="well">
								<form class="form">
									<h4>View AUM</h4>
									<div class="input-group text-center">
										<div class="col-md-4">
											<div id="viewaum" style="width: 650px; height: 350px;"></div>
										</div>
									</div>
								</form>
							</div>
						</div>
						<div class="col-md-4 col-sm-6">
							<div class="well">
								<h4>Disk Usage</h4>
								<div class="input-group text-center">
									<div id="bonanza"
										style="width: 300px; height: 175px; float: left"></div>
									<div id="archive"
										style="width: 300px; height: 175px; float: left"></div>
								</div>
							</div>
						</div>
					</div>
					</form>
			</div>
		</div>
	</div>
</body>
</html>