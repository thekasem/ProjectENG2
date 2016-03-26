<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Menu Bar</title>
</head>
<body class="hold-transition skin-blue sidebar-mini">

	<header class="main-header">

		<!-- Logo -->
		<a href="login_homeFirst" class="logo"> <!-- mini logo for sidebar mini 50x50 pixels -->
			<span class="logo-mini"><b>E</b>NG</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg"><b>Pro</b>ENG</span>
		</a>

		<!-- Header Navbar: style can be found in header.less -->
		<nav class="navbar navbar-static-top" role="navigation">
			<!-- Sidebar toggle button-->
			<a href="#" class="sidebar-toggle" data-toggle="offcanvas"
				role="button"> <span class="sr-only">Toggle navigation</span>
			</a>
			<!-- Navbar Right Menu -->
			<div class="navbar-custom-menu">
				<ul class="nav navbar-nav">
					<li class="dropdown user user-menu"><a href="#"
						class="dropdown-toggle" data-toggle="dropdown"> <img
							src="dist/img/usertest.png" class="user-image"
							alt="User Image"> <span class="hidden-xs"><s:property
									value="userNameLogin" /></span>
					</a>
						<ul class="dropdown-menu">
							<!-- User image -->
							<li class="user-header"><img
								src="dist/img/usertest.png" class="img-circle"
								alt="User Image">
								<p>
									<s:property value="userNameLogin" />
									- Web Developer <small>Member since Nov. 2012</small>
								</p></li>
							<!-- Menu Footer-->
							<li class="user-footer">
								<div class="pull-left">
									<a href="profile_profile" class="btn btn-default btn-flat">Profile</a>
								</div>
								<div class="pull-right">
									<a href="login_logout" class="btn btn-default btn-flat">Sign
										out</a>
								</div>
							</li>
						</ul></li>
					<!-- Control Sidebar Toggle Button -->
					<li><a href="#" data-toggle="control-sidebar"><i
							class="fa fa-gears"></i></a></li>
				</ul>
			</div>

		</nav>
	</header>
	<!-- Left side column. contains the logo and sidebar -->
	<aside class="main-sidebar">
		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">
			<!-- Sidebar user panel -->
			<div class="user-panel">
				<div class="pull-left image">
					<img src="dist/img/usertest.png" class="img-circle"
						alt="User Image">
				</div>
				<div class="pull-left info">
					<p>
						<s:property value="userNameLogin" />
					</p>
					<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
				</div>
			</div>
			<!-- search form -->
			<form action="#" method="get" class="sidebar-form">
				<div class="input-group">
					<input type="text" name="q" class="form-control"
						placeholder="Search..."> <span class="input-group-btn">
						<button type="submit" name="search" id="search-btn"
							class="btn btn-flat">
							<i class="fa fa-search"></i>
						</button>
					</span>
				</div>
			</form>
			<!-- /.search form -->
			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu">
				<li class="header">MAIN NAVIGATION</li>
				<li class="active treeview"><a href="#"> <i
						class="fa fa-dashboard"></i> <span>Dashboard</span> <i
						class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
					<li><a href="dashBoard_browser"><i class="fa fa-circle-o"></i>
								Dashboard</a></li>
						<!-- <li><a href="dashBoard_browser"><i class="fa fa-circle-o"></i>
								Dashboard v1.1</a></li> -->
						<!-- <li class="active"><a href="dashBoard_browser"><i
								class="fa fa-circle-o"></i> Dashboard v2.1</a></li> -->
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-archive"></i>
						<span>AUM Archive</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="aumByCIFArchive_list"><i
								class="fa fa-circle-o"></i> AUM By CIF Archive List</a></li>
						<li><a href="aumByBranchArchive_list"><i
								class="fa fa-circle-o"></i> AUM By Branch Archive List</a></li>
						<li><a href="portHoldingBySubAccountArchive_list"><i
								class="fa fa-circle-o"></i> AUM By SubAcc Archive List</a></li>
						<li><a href="aumByCIFArchive_add"><i
								class="fa fa-circle-o"></i> Add Archive AUM</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-archive"></i>
						<span>Application Archive</span> <i
						class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="applicationArchive_list"><i
								class="fa fa-circle-o"></i> Application Archive List</a></li>
						<li><a href="applicationArchive_search"><i
								class="fa fa-circle-o"></i> Application Archive Search</a></li>
						<li><a href="applicationArchive_add"><i
								class="fa fa-circle-o"></i> Add Application Archive</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-archive"></i>
						<span>Activity Archive</span> <i
						class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="activityArchive_list"><i
								class="fa fa-circle-o"></i> Activity Archive List</a></li>
						<li><a href="activityArchive_search"><i
								class="fa fa-circle-o"></i> Activity Archive Search</a></li>
						<li><a href="activityArchive_add"><i
								class="fa fa-circle-o"></i> Add Activity Archive</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-users"></i>
						<span>Demand Customer Assets</span> <i
						class="fa fa-angle-left pull-right"></i>
				</a>
					<ul class="treeview-menu">
						<li><a href="demandCustomerAssets_analysis"><i
								class="fa fa-circle-o"></i> Analysis</a></li>
						<li><a href="demandCustomerAssets_prediction"><i
								class="fa fa-circle-o"></i> Prediction</a></li>
					</ul></li>
<!-- 				<li class="header">LABELS</li> -->
<%-- 				<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>Important</span></a></li> --%>
<!-- 				<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> -->
<%-- 						<span>Warning</span></a></li> --%>
<%-- 				<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>Information</span></a></li> --%>
			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>

</body>
</html>
