var monthName = [];
var nameModule = [];
var dataModule1 = [];
var dataModule2 = [];
var dataModule3 = [];
var dataModule4 = [];
var dataModule5 = [];
$('#top-module').val(moment().format("YYYY"));
var years = $('#top-module').val();

$(function() {
	calTopmodule();
});

$('#top-module').change(function() {
	years = $('#top-module').val()
	calTopmodule();
});

function calTopmodule() {
	$
			.ajax({
				type : "GET",
				url : 'TopModuleJson.action',
				data : {
					year : years
				},
				success : function(response) {

					monthName = response.month;
					nameModule = response.nameModule;
					dataModule1 = response.dataModule1;
					dataModule2 = response.dataModule2;
					dataModule3 = response.dataModule3;
					dataModule4 = response.dataModule4;
					dataModule5 = response.dataModule5;
					$('#dashboardtopmodule')
							.highcharts(
									{
										chart : {
											type : 'spline'
										},
										title : {
											text : 'Year ' + years
													+ ' Users using Top Modules',
										},
										subtitle : {
											text : '',
										},
										xAxis : {
											categories : monthName,
											crosshair : true
										},
										yAxis : {
											min : 0,
											title : {
												text : 'value of Module'
											}
										},
										tooltip : {
											headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
											pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
													+ '<td style="padding:0"><b>{point.y:.1f} used</b></td></tr>',
											footerFormat : '</table>',
											shared : true,
											useHTML : true
										},
										plotOptions : {
											column : {
												pointPadding : 0.2,
												borderWidth : 0
											},
											pie : {
												allowPointSelect : true,
											}
										},
										series : [
												{
													name : nameModule[0],
													data : dataModule1
												},
												{
													name : nameModule[1],
													data : dataModule2
												},
												{
													name : nameModule[2],
													data : dataModule3
												},
												{
													name : nameModule[3],
													data : dataModule4
												},
												{
													name : nameModule[4],
													data : dataModule5
												},
												{
													type : 'pie',
													name : 'Total consumption',
													data : [
															{
																name : nameModule[0],
																y : sumArray(dataModule1),
																color : Highcharts
																		.getOptions().colors[0]
															// Jane's color
															},
															{
																name : nameModule[1],
																y : sumArray(dataModule2),
																color : Highcharts
																		.getOptions().colors[1]
															// John's color
															},
															{
																name : nameModule[2],
																y : sumArray(dataModule3),
																color : Highcharts
																		.getOptions().colors[2]
															// Joe's color
															},
															{
																name : nameModule[3],
																y : sumArray(dataModule4),
																color : Highcharts
																		.getOptions().colors[3]
															// Joe's color
															},
															{
																name : nameModule[4],
																y : sumArray(dataModule5),
																color : Highcharts
																		.getOptions().colors[4]
															// Joe's color
															} ],
													center : [ 80, -15 ],
													size : 80,
													showInLegend : false,
													dataLabels : {
														enabled : false
													}
												} ],
									});
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
}
function sumArray(array) {
	var result = 0;
	for (var int = 0; int < array.length; int++) {
		result = array[int] + result;
	}
	return result;
}