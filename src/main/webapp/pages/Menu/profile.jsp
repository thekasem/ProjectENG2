<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Profile <s:property value="userNameLogin" /></title>
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
	<div class="wrapper">
		<s:include value="/pages/Menu/menuV.jsp"></s:include>
		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				Profile
				<s:property value="userNameLogin" />
				<small>Version 6.0</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-user"></i> Profile <s:property
							value="userNameLogin" /></a></li>
			</ol>
			</section>

			<section class="content">
			<div class="col-md-12">



				<div class="box box-info">
					<div class="box-header with-border">
						<Strong>Profile <s:property value="userNameLogin" /></Strong>
					</div>
					<br>
					<div class="container">
						<div class="row">
							<div
								class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad">
								<div class="panel panel-info">
									<div class="panel-heading">
										<h3 class="panel-title">
											<s:property value="member.firstNameEn" />
											<s:property value="member.lastNameEn" />
										</h3>
									</div>
									<div class="panel-body">
										<div class="row">
											<div class=" col-md-12 col-lg-12 center">
												<table class="table table-user-information">
													<tbody>
														<tr>
															<td>MemberId</td>
															<td><s:property value="member.memberId" /></td>
														</tr>
														<tr>
															<td>MemberSince</td>
															<td><s:property value="member.memberSince" /></td>
														</tr>
														<tr>
															<td>FirstName</td>
															<td><s:property value="member.firstNameEn" /></td>
														</tr>
														<tr>
															<td>LastName</td>
															<td><s:property value="member.lastNameEn" /></td>
														</tr>
														<tr>
															<td>Mobile</td>
															<td><s:property value="member.mobile" /></td>
														</tr>
														<tr>
															<td>E-Mail</td>
															<td><s:property value="member.email" /></td>
<!-- 															<a href="mailto:info@support.com">info@support.com</a> -->
															
															</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>




					<div class="panel-body">
						<form class="form-horizontal">
							
							
							
							
						</form>
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