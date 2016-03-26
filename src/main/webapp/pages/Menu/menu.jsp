<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bootstrap Case</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/ionicons.min.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="dist/css/skins/_all-skins.min.css">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<s:url action="login_logout" var="logout"></s:url>
	<s:url action="login_homeFirst" var="home"></s:url>
	<s:url action="profile" var="profile"></s:url>
	<s:url action="activityArchive_list" var="listactivity"></s:url>
	<s:url action="applicationArchive_list" var="listapplication"></s:url>
	<s:url action="aumByCIFArchive_list" var="listaumbycif"></s:url>
	<s:url action="aumByBranchArchive_list" var="listaumbybranch"></s:url>
	<s:url action="portHoldingBySubAccountArchive_list" var="listaumbyport"></s:url>
	<s:url action="aumByCIFArchive_add" var="addaumbycif"></s:url>
	<s:url action="dashBoard_browser" var="showDashBoard"></s:url>

	<div class="wrapper">
		<header class="main-header"> <!-- Logo --> <a
			href="login_homeFirst.action" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
			<span class="logo-lg"><b>Eng</b>Pro</span>
		</a> <nav class="navbar navbar-static-top" role="navigation">
		<div class="container-fluid">
			<ul class="nav navbar-nav navbar-right">
				<li><s:a href="%{search}">
						<img src="dist/img/usertest.png" class="img-circle"
							alt="Cinque Terre" width="19" height="19">
						<span class="hidden-xs"> <s:property value="userNameLogin" />
						</span>
					</s:a></li>
				<li><s:a href="%{logout}">
						<span class="glyphicon glyphicon-log-out"></span>
						Logout</s:a></li>
			</ul>
		</div>
		</nav> </header>
	</div>


	<div class="control-sidebar-bg"></div>
	<script src="js/bootstrap.min.js"></script>
	<script src="plugins/fastclick/fastclick.min.js"></script>
	<script src="plugins/slimScroll/jquery.slimscroll.min.js"></script>
</body>
</html>