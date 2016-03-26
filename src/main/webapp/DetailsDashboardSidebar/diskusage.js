$(function() {

	var namemodules = [];

	var dataactivity = [];
	var dataapplication = [];
	var dataaumbycif = [];
	var dataaumbybranch = [];
	var dataportholding = [];

	$
			.ajax({
				type : "GET",
				url : 'diskUsageJson.action',
				data : {},
				success : function(response) {

					namemodules = response.namemodules;

					dataactivity = response.dataactivity;
					dataapplication = response.dataapplication;
					dataaumbycif = response.dataaumbycif;
					dataaumbybranch = response.dataaumbybranch;
					dataportholding = response.dataportholding;

					var gaugeOptions = {
						credits : {
							enabled : false
						},
						exporting : {
							enabled : false
						},
						chart : {
							type : 'solidgauge',
							backgroundColor : null,
							style : {
								fontFamily : "Dosis, sans-serif"
							}
						},

						title : {
							text : ''
						},

						pane : {
							center : [ '50%', '85%' ],
							size : '140%',
							startAngle : -90,
							endAngle : 90,
							background : {
								backgroundColor : (Highcharts.theme && Highcharts.theme.background2)
										|| '#EEE',
								innerRadius : '60%',
								outerRadius : '100%',
								shape : 'arc'
							}
						},

						tooltip : {
							enabled : false
						},

						// the value axis
						yAxis : {
							stops : [ [ 0.1, '#55BF3B' ], // green
							[ 0.5, '#DDDF0D' ], // yellow
							[ 0.9, '#DF5353' ] // red
							],
							lineWidth : 0,
							minorTickInterval : null,
							tickPixelInterval : 400,
							tickWidth : 0,
							title : {
								y : -70
							},
							labels : {
								y : 16
							}
						},

						plotOptions : {
							solidgauge : {
								dataLabels : {
									y : 5,
									borderWidth : 0,
									useHTML : true
								}
							}
						}
					};

					$('#dashboardactivity')
							.highcharts(
									Highcharts
											.merge(
													gaugeOptions,
													{
														yAxis : {
															min : 0,
															max : 10000,
															title : {
																text : namemodules[0]
															}
														},

														series : [ {
															name : namemodules[0],
															data : dataactivity,
															dataLabels : {
																format : '<div style="text-align:center"><span style="font-size:25px;color:'
																		+ ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black')
																		+ '">{y}</span><br/>'
																		+ '<span style="font-size:12px;color:silver">Records/ 10000 Records</span></div>'
															},
															tooltip : {
																valueSuffix : ''
															}
														} ]

													}));

					$('#dashboardapplication')
							.highcharts(
									Highcharts
											.merge(
													gaugeOptions,
													{
														yAxis : {
															min : 0,
															max : 10000,
															title : {
																text : namemodules[1]
															}
														},

														series : [ {
															name : namemodules[1],
															data : dataapplication,
															dataLabels : {
																format : '<div style="text-align:center"><span style="font-size:25px;color:'
																		+ ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black')
																		+ '">{y}</span><br/>'
																		+ '<span style="font-size:12px;color:silver">Records/ 10000 Records</span></div>'
															},
															tooltip : {
																valueSuffix : ''
															}
														} ]

													}));

					$('#dashboardaumbycif')
							.highcharts(
									Highcharts
											.merge(
													gaugeOptions,
													{
														yAxis : {
															min : 0,
															max : 10000,
															title : {
																text : namemodules[2]
															}
														},

														series : [ {
															name : namemodules[2],
															data : dataaumbycif,
															dataLabels : {
																format : '<div style="text-align:center"><span style="font-size:25px;color:'
																		+ ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black')
																		+ '">{y}</span><br/>'
																		+ '<span style="font-size:12px;color:silver">Records/ 10000 Records</span></div>'
															},
															tooltip : {
																valueSuffix : ''
															}
														} ]

													}));

					$('#dashboardaumbybranch')
							.highcharts(
									Highcharts
											.merge(
													gaugeOptions,
													{
														yAxis : {
															min : 0,
															max : 10000,
															title : {
																text : namemodules[3]
															}
														},

														series : [ {
															name : namemodules[3],
															data : dataaumbybranch,
															dataLabels : {
																format : '<div style="text-align:center"><span style="font-size:25px;color:'
																		+ ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black')
																		+ '">{y}</span><br/>'
																		+ '<span style="font-size:12px;color:silver">Records/ 10000 Records</span></div>'
															},
															tooltip : {
																valueSuffix : ''
															}
														} ]

													}));

					$('#dashboardportholding')
							.highcharts(
									Highcharts
											.merge(
													gaugeOptions,
													{
														yAxis : {
															min : 0,
															max : 10000,
															title : {
																text : namemodules[4]
															}
														},

														series : [ {
															name : namemodules[4],
															data : dataportholding,
															dataLabels : {
																format : '<div style="text-align:center"><span style="font-size:25px;color:'
																		+ ((Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black')
																		+ '">{y}</span><br/>'
																		+ '<span style="font-size:12px;color:silver">Records/ 10000 Records</span></div>'
															},
															tooltip : {
																valueSuffix : ''
															}
														} ]

													}));
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
});