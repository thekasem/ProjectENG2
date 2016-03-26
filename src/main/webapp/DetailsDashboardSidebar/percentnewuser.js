var dateLastYear = [];
var dateCurrentYear = [];
var monthName = [];
var avgDate = [];
var totalCurrentYear;
var totalLastYear;
$('#top-module').val(moment().format("YYYY"));
var years = $('#top-module').val();
$(function() {
	showPercentNewUser();
	$('#top-module').change(function() {
		years = $('#top-module').val()
		showPercentNewUser();
	});
});

function showPercentNewUser() {
	$
			.ajax({
				type : "GET",
				url : 'percentNewUserJson.action',
				data : {
					year : years
				},
				success : function(response) {
					monthName = response.month;
					dateLastYear = response.dataLastYear;
					dateCurrentYear = response.dataCurrentYear;
					avgDate = response.avgDate;
					totalCurrentYear = response.totalCurrentYear;
					totalLastYear = response.totalLastYear;
					$('#dashboardnewuser')
							.highcharts(
									{
										title : {
											text : 'Year '+years+' Percent New Users'
										},
										xAxis : {
											categories : monthName
										},
										plotOptions : {
											pie : {
												allowPointSelect : true,
											}
										},
										labels : {
											items : [ {
												html : 'Total percent user/year',
												style : {
													left : '50px',
													top : '18px',
													color : (Highcharts.theme && Highcharts.theme.textColor)
															|| 'black'
												}
											} ]
										},
										series : [
												{
													type : 'column',
													name : 'Current Year',
													data : dateCurrentYear,
													color : Highcharts
															.getOptions().colors[1]
												},
												{
													type : 'column',
													name : 'Last Year',
													data : dateLastYear,
													color : Highcharts
															.getOptions().colors[2]
												},
												{
													type : 'spline',
													name : 'Average',
													data : avgDate,
													marker : {
														lineWidth : 2,
														lineColor : Highcharts
																.getOptions().colors[3],
														fillColor : 'white'
													}
												},
												{
													type : 'pie',
													name : 'Total consumption',
													data : [
															{
																name : 'Current Year',
																y : totalCurrentYear,
																color : Highcharts
																		.getOptions().colors[1]
															},
															{
																name : 'Last Year',
																y : totalLastYear,
																color : Highcharts
																		.getOptions().colors[2]
															} ],
													center : [ 100, 80 ],
													size : 100,
													showInLegend : false,
													dataLabels : {
														enabled : false
													}
												} ]
									});
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
}
