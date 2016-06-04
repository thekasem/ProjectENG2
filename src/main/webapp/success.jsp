<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Success Login</title>
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
<link rel="stylesheet" href="dist/css/w3schools/lib/w3.css">
</head>
<style>
.mySlides {display:none}
</style>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<s:url action="activityArchive_search" var="search"></s:url>
		<%-- 	<s:include value="/pages/Menu/menu.jsp"></s:include> --%>
		<!-- 	<div class="row"> -->

		<!-- 		<div class="col-md-2"> -->
		<s:include value="/pages/Menu/menuV.jsp"></s:include>


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
			<h1>
				Home <small>Version 6.0</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-home"></i> Home</a></li>
			</ol>
			
			
			<div class="w3-container">
</div>

<div class="w3-content" style="">
  <img src="pages/Menu/forecast.jpg" class="mySlides w3-border w3-padding w3-round-xlarge" style="width: 960px; height: 640px;">
  <img src="pages/Menu/plan.png" class="mySlides w3-border w3-padding w3-round-xlarge" style="width: 960px; height: 640px;">
  <img src="pages/Menu/foreign-gold-graph.jpg" class="mySlides w3-border w3-padding w3-round-xlarge" style="width: 960px; height: 640px;">

  <div class="w3-row-padding w3-section">
    <div class="w3-col s4">
      <img class="demo w3-border w3-hover-shadow w3-padding w3-hover-opacity w3-round-xlarge" src="pages/Menu/forecast.jpg" style="width: 250px; height: 150px;" onclick="currentDiv(1)">
    </div>
    <div class="w3-col s4">
      <img class="demo w3-border w3-hover-shadow w3-padding w3-hover-opacity w3-round-xlarge" src="pages/Menu/plan.png" style="width: 250px; height: 150px;" onclick="currentDiv(2)">
    </div>
    <div class="w3-col s4">
      <img class="demo w3-border w3-hover-shadow w3-padding w3-hover-opacity w3-round-xlarge" src="pages/Menu/foreign-gold-graph.jpg" style="width: 250px; height: 150px;" onclick="currentDiv(3)">
    </div>
  </div>
</div>
			</section>
		</div>
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
<script>
var slideIndex = 1;
showDivs(slideIndex);

function plusDivs(n) {
  showDivs(slideIndex += n);
}

function currentDiv(n) {
  showDivs(slideIndex = n);
}

function showDivs(n) {
  var i;
  var x = document.getElementsByClassName("mySlides");
  var dots = document.getElementsByClassName("demo");
  if (n > x.length) {slideIndex = 1}    
  if (n < 1) {slideIndex = x.length} ;
  for (i = 0; i < x.length; i++) {
     x[i].style.display = "none";  
  }
  for (i = 0; i < dots.length; i++) {
     dots[i].className = dots[i].className.replace(" w3-border-red", "");
  }
  x[slideIndex-1].style.display = "block";  
  dots[slideIndex-1].className += " w3-border-red";
}
</script>
</body>
</html>