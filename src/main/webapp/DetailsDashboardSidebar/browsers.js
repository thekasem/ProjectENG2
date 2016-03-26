var y = [];
var nameBrowser = [];
var dataMSIE = [];
var dataFirefox = [];
var dateChrome = [];
var dataSafari = [];
var dataOpera = [];
var dateProprietary = [];

var nameMSIEVersions = [];
var nameFirefoxVersions = [];
var nameChromeVersions = [];
var nameSafariVersions = [];
var nameOperaVersions = [];
$('#top-module').val(moment().format("YYYY"));
var years = $('#top-module').val();

$(function() {
	showBrowsers();
	$('#top-module').change(function() {
		years = $('#top-module').val()
		showBrowsers();
	});
});

function showBrowsers() {
	$
			.ajax({
				type : "GET",
				url : 'browserJson.action',
				data : {
					year : years
				},
				success : function(response) {
					nameMSIEVersions = response.nameMSIEVersions;
					nameFirefoxVersions = response.nameFirefoxVersions;
					nameChromeVersions = response.nameChromeVersions;
					nameSafariVersions = response.nameSafariVersions;
					nameOperaVersions = response.nameOparaVersions;
					dataMSIE = response.dataMSIE;
					dataFirefox = response.dataFirefox;
					dateChrome = response.dataChrome;
					dataSafari = response.dataSafari;
					dataOpera = response.dataOpera;
					dateProprietary = response.dateProprietary;
					nameBrowser = response.nameBrowser;
					y = response.y;
					var colors = Highcharts.getOptions().colors, categories = nameBrowser, data = [
							{
								y : y[0],
								color : colors[0],
								drilldown : {
									name : nameBrowser[0],
									categories : nameMSIEVersions,
									data : dataMSIE,
									color : colors[0]
								}
							}, {
								y : y[1],
								color : colors[1],
								drilldown : {
									name : nameBrowser[1],
									categories : nameFirefoxVersions,
									data : dataFirefox,
									color : colors[1]
								}
							}, {
								y : y[2],
								color : colors[2],
								drilldown : {
									name : nameBrowser[2],
									categories : nameChromeVersions,
									data : dateChrome,
									color : colors[2]
								}
							}, {
								y : y[3],
								color : colors[3],
								drilldown : {
									name : nameBrowser[3],
									categories : nameSafariVersions,
									data : dataSafari,
									color : colors[3]
								}
							}, {
								y : y[4],
								color : colors[4],
								drilldown : {
									name : nameBrowser[4],
									categories : nameOperaVersions,
									data : dataOpera,
									color : colors[4]
								}
							}, {
								y : 0,
								color : colors[5],
								drilldown : {
									name : 'Proprietary or Undetectable',
									categories : [],
									data : dateProprietary,
									color : colors[5]
								}
							} ], browserData = [], versionsData = [], i, j, dataLen = data.length, drillDataLen, brightness;

					// Build the data arrays
					for (i = 0; i < dataLen; i += 1) {

						// add browser data
						browserData.push({
							name : categories[i],
							y : data[i].y,
							color : data[i].color
						});

						// add version data
						drillDataLen = data[i].drilldown.data.length;
						for (j = 0; j < drillDataLen; j += 1) {
							brightness = 0.2 - (j / drillDataLen) / 5;
							versionsData.push({
								name : data[i].drilldown.categories[j],
								y : data[i].drilldown.data[j],
								color : Highcharts.Color(data[i].color)
										.brighten(brightness).get()
							});
						}
					}

					// Create the chart
					$('#dashboardbrowser')
							.highcharts(
									{
										chart : {
											type : 'pie'
										},
										title : {
											text : 'Year '+years+' Users Browsers'
										},
										subtitle : {
											text : ''
										},
										yAxis : {
											title : {
												text : ''
											}
										},
										plotOptions : {
											pie : {
												allowPointSelect : true,
											}
										},
										tooltip : {
											valueSuffix : '%'
										},
										series : [
												{
													name : 'Browsers',
													data : browserData,
													size : '60%',
													dataLabels : {
														formatter : function() {
															return this.y > 5 ? this.point.name
																	: null;
														},
														color : '#ffffff',
														distance : -30
													}
												},
												{
													name : 'Versions',
													data : versionsData,
													size : '80%',
													innerSize : '60%',
													dataLabels : {
														formatter : function() {
															// display only if
															// larger than 1
															return this.y > 1 ? '<b>'
																	+ this.point.name
																	+ ':</b> '
																	+ this.y
																	+ '%'
																	: null;
														}
													}
												} ]
									});
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
}
