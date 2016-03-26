<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>AUM Archive Log Search</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="../../calendar/jquery-ui-1.11.4.custom/external/jquery/jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="../../calendar/jquery-ui-1.11.4.custom/jquery-ui.min.css">
<script src="../../calendar/jquery-ui-1.11.4.custom/jquery-ui.min.js"></script>
<link rel="stylesheet"
	href="../../calendar/jquery-ui-1.11.4.custom/jquery-ui.structure.min.css">
<link rel="stylesheet"
	href="../../calendar/jquery-ui-1.11.4.custom/jquery-ui.theme.min.css">

</head>
<body>
	<div class="container">
		<div class="container" style="margin-top: 50px;">
			<a type="button" class="btn btn-info" href="AUMArchiveSearch.jsp">Reset</a>
			<a type="button" class="btn btn-info" href="AUMArchiveList.jsp">OK</a>
			<a type="button" class="btn btn-info" href="AUMArchiveList.jsp">Cancel</a>
		</div>

		<div style="margin-top: 10px;" align="right">
			<h3>
				<span class="label label-default">Search</span>
			</h3>
		</div>

		<div class="panel panel-default" style="margin-top: 15px;">
			<div class="panel-heading">
				<Strong>Search AUM Archive Log</Strong>
			</div>
			<div class="panel-body">
				<form class="form-horizontal">
					<div class="form-group">
						<label class="col-md-2 control-label">View By</label>
						<div class="col-sm-6 col-md-3">
							<select id="viewby" class="form-control">
								<option>AUM By CIF</option>
								<option>AUM By Branch</option>
								<option>Port Holding By Sub Account</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">AUM Date</label>
						<div class="col-md-3">
							<s:textfield cssClass="datepicker form-control"></s:textfield>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-2 control-label">User Archive</label>
						<div class="col-md-3">
							<s:textfield name="userarchive" cssClass="form-control"></s:textfield>
						</div>
						<label class="col-md-2 control-label">Date Archive</label>
						<div class="col-md-3">
							<s:textfield cssClass="datepicker form-control"></s:textfield>
						</div>
					</div>

					<div style="margin-top: 10px;" align="right">
						<h3>
							<span class="label label-default">AUM By CIF</span>
						</h3>
					</div>

					<table class="table table-striped table-hover ">
						<thead style="color: #4863A0;">
							<th>Event ID</th>
							<th>Date</th>
							<th>Time</th>
							<th>Level</th>
							<th>Entity Class</th>
							<th>Mode</th>
							<th>Client IP</th>
							<th>Front Server IP</th>
							<th>Member Name</th>
							<th>Activity Log ID</th>
							<th>User Archive</th>
							<th>Date Archive</th>
							<th>Condition Archive</th>
						</thead>
						<tbody>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
						</tbody>
					</table>

					<div style="margin-top: 10px;" align="right">
						<h3>
							<span class="label label-default">AUM By Branch</span>
						</h3>
					</div>

					<table class="table table-striped table-hover ">
						<thead style="color: #4863A0;">
							<th>Event ID</th>
							<th>Date</th>
							<th>Time</th>
							<th>Level</th>
							<th>Entity Class</th>
							<th>Mode</th>
							<th>Client IP</th>
							<th>Front Server IP</th>
							<th>Member Name</th>
							<th>Activity Log ID</th>
							<th>User Archive</th>
							<th>Date Archive</th>
							<th>Condition Archive</th>
						</thead>
						<tbody>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
						</tbody>
					</table>

					<div style="margin-top: 10px;" align="right">
						<h3>
							<span class="label label-default">Port Holding By Sub
								Account</span>
						</h3>
					</div>

					<table class="table table-striped table-hover ">
						<thead style="color: #4863A0;">
							<th>Event ID</th>
							<th>Date</th>
							<th>Time</th>
							<th>Level</th>
							<th>Entity Class</th>
							<th>Mode</th>
							<th>Client IP</th>
							<th>Front Server IP</th>
							<th>Member Name</th>
							<th>Activity Log ID</th>
							<th>User Archive</th>
							<th>Date Archive</th>
							<th>Condition Archive</th>
						</thead>
						<tbody>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
							<tr style="color: #98AFC7;">
								<th>1</th>
								<th>20/10/2015</th>
								<th>12:12:59</th>
								<th>Test</th>
								<th>classTest</th>
								<th>Test</th>
								<th>192.155.125.0</th>
								<th>10.10.10.10</th>
								<th>TestName</th>
								<th>14525...</th>
								<th>TestName</th>
								<th>20/10/2015</th>
								<th>Date = 20/10/2015</th>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
	</div>
	<script>
		$('.datepicker').datepicker({
			changeYear : true,
			yearRange : '-100:+100',
			dateFormat : 'dd MM yy'
		});
	</script>
	<style>
select.ui-datepicker-year {
	color: #000;
}
</style>
</body>
</html>