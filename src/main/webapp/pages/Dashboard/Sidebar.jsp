<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Sidebar</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="plugins/fullcalendar/fullcalendar.min.css">
<link rel="stylesheet"
	href="plugins/fullcalendar/fullcalendar.print.css" media="print">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
<link rel="stylesheet" href="plugins/iCheck/flat/blue.css">
</head>
<body style="background: #FEFCFF">
	<div class="box box-solid">
		<div class="color-palette-set">
			<div class="box-header with-border bg-yellow disabled color-palette">
				<h3 class="box-title">
					<span class="fa fa-bars"> Menu Dashboard</span>
				</h3>
				<div class="box-tools">
					<button type="button" class="btn btn-box-tool"
						data-widget="collapse">
						<i class="fa fa-minus"></i>
					</button>
				</div>
			</div>
		</div>
		<div class="box-body no-padding">
			<ul class="nav nav-pills nav-stacked">
				<li><s:a href="dashBoard_browser">
						<span class="fa fa-edge"></span> Browsers
					</s:a></li>
				<li><s:a href="dashBoard_login">
						<span class="fa fa-sign-in"></span> Login
					</s:a></li>
				<%-- 					<li><s:a href="dashBoard_user"><span class="fa fa-users"></span>    User</span></li> --%>
				<li><s:a href="dashBoard_topModule">
						<span class="fa fa-file-archive-o"></span> Top Module
					</s:a></li>
				<li><s:a href="dashBoard_newUser">
						<span class="fa fa-user-plus"></span> Percent New User
					</s:a></li>
				<li><s:a href="dashBoard_customer">
						<span class="fa fa-odnoklassniki"></span> Customers
					</s:a></li>
				<li><s:a href="dashBoard_topUser">
						<span class="fa fa-user"></span> Top User
					</s:a></li>
				<li><s:a href="dashBoard_argTimeOnSite">
						<span class="fa fa-clock-o"></span>  Average Time On Site
					</s:a></li>
				<li><s:a href="dashBoard_viewAUM">
						<span class="fa fa-briefcase"></span> View AUM
					</s:a></li>
				<li><s:a href="dashBoard_diskUsage">
						<span class="fa fa-database"></span> Disk Usage
					</s:a></li>
			</ul>
		</div>
	</div>
	<div class="control-sidebar-bg"></div>
	<script src="js/bootstrap.min.js"></script>
	<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
	<script src="plugins/fastclick/fastclick.js"></script>
	<script src="plugins/iCheck/icheck.min.js"></script>
	<script src="dist/js/app.min.js"></script>
</body>
</html>