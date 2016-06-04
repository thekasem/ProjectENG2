<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login System</title>
<link rel="stylesheet" href="css/font-awesome.min.css">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/bootstrap.theme.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/ionicons.min.css">
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<link rel="stylesheet" href="plugins/iCheck/square/blue.css">
<link rel="stylesheet" href="dist/css/w3schools/lib/w3.css">
<script type="text/javascript">
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, intial-scale=1">
</head>
<style>
.mySlides {display:none;}
</style>
<body style="background: #E5E4E2">
	<div style="margin-top: 150px">
		<form action="login_execute" method="post" class="form-horizontal">
			<div class="container">
			<div class="panel panel-default w3-round-xlarge">
				<div class="panel-heading w3-round-xlarge" style="color: #686868">
					<img class="mySlides w3-border w3-round-xlarge" src="pages/Menu/foreign.jpg" style="width: 750px; height: 450px;">
					<img class="mySlides w3-border w3-round-xlarge" src="pages/Menu/human.png" style="width: 750px; height: 450px;">
					<img class="mySlides w3-border w3-round-xlarge" src="pages/Menu/stockpick.jpg" style="width: 750px; height: 450px;">

				<s:if test="arlert.equals('Login Fail')">
					<div class="alert alert-danger col-md-4 col-md-offset-4" style="margin-top: -410px; margin-left: 752px;">
						<div class="center">
							<s:property value="arlert" />
						</div>
					</div>
				</s:if>
				<div class="row">
				
					<div class="col-md-4 col-md-offset-4" style="margin-top: -350px; margin-left: 762px;">
						<div class="panel panel-default">
							<div class="panel-heading" style="color: #686868">
								<span class="fa fa-sign-in"></span> <strong><s:text
										name="user.login" /></strong>
							</div>
							
							<div class="panel-body">
								<div class="form-group">
									<label class="control-label col-md-3" style="color: #686868"><s:text
											name="user.name" /></label>
									<div class="col-md-8">
										<div class="form-group has-feedback">
											<s:textfield name="username" cssClass="form-control"
												placeholder="username" type="text"></s:textfield>
											<span
												class="fa fa-user-md form-control-feedback"></span>
										</div>
									</div>
								</div>

								<div class="form-group">
									<label class="control-label col-md-3" style="color: #686868"><s:text
											name="user.password" /></label>
									<div class="col-md-8">
										<div class="form-group has-feedback">
											<s:password name="userpass" cssClass="text form-control"
												placeholder="password"></s:password>
											<span class="fa fa-key form-control-feedback"></span>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<div class="checkbox">
											<label class=""> <input type="checkbox" class="">
												Remember me
											</label>
										</div>
									</div>
								</div>

								<div class="form-group">
									<div class="col-sm-offset-3 col-sm-9">
										<button type="submit" class="btn btn-primary btn-flat">
											Sign in</button>
										<a class="btn btn-default btn-flat" href="index.jsp">reset</a>
									</div>
								</div>

							</div>
						</div>
					</div>
				</div>
				</div>
		</div>
			</div>
		</form>
	</div>
	<script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
	<script src="plugins/iCheck/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
	<script>
		var myIndex = 0;
			carousel();

		function carousel() {
   			var i;
    		var x = document.getElementsByClassName("mySlides");
    		for (i = 0; i < x.length; i++) {
       			x[i].style.display = "none";  
    		}
   			myIndex++;
    		if (myIndex > x.length) {myIndex = 1}    
    		x[myIndex-1].style.display = "block";  
    		setTimeout(carousel, 2000); // Change image every 2 seconds
			}
	</script>
</body>
</html>