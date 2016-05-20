/**
 * 
 */

var chart;
var listDataCurrentYear = [];
var listDataNextYear = [];
var alpha;
var predictionid;
var selectprediction;
var typeCustomerId;
var typeAssetId;

$(function() {
	
	
    
	$('.alphavalue').hide(0);
	$('#line').show(0);
	$('#column').hide(0);
	$('#pie').hide(0);
	$('#scatter').hide(0);
	$('.predictionidcustomer').show(0);
	$('.predictionidasset').hide(0);
	$('.overlay').hide(0);
	alpha = $('#alpha').val();
	predictionid = $('#predictionid').val();
	showLinePrediction();

});

$(
		'#selectchart,#selectprediction,#predictionid,#alpha,#typeassetid,#typecustomerid')
		.change(function() {
			$('.overlay').show(0);
			alpha = $('#alpha').val();
			predictionid = $('#predictionid').val();
			chart = $('#selectchart').val();
			$('.alphavalue').hide(0);
			if ($('#selectprediction').val() == 2) {
				$('.alphavalue').show(0);
			}
			// alert(chart);
			if (chart == 1) {
				$('#line').show(0);
				$('#column').hide(0);
				$('#pie').hide(0);
				$('#scatter').hide(0);
				showLinePrediction();
			}
			if (chart == 2) {
				$('#line').hide(0);
				$('#column').show(0);
				$('#pie').hide(0);
				$('#scatter').hide(0);
				showColumnPrediction();
			}
			if (chart == 3) {
				$('#line').hide(0);
				$('#column').hide(0);
				$('#pie').hide(0);
				$('#scatter').show(0);
				showScatterPrediction();
			}
			$('.overlay').hide(0);
			
		});

$('#predictionid').change(function() {
	predictionid = $('#predictionid').val();
	if (predictionid == 1) {
		$('.predictionidcustomer').show(0);
		$('.predictionidasset').hide(0);
	}
	if (predictionid == 2) {
		$('.predictionidcustomer').hide(0);
		$('.predictionidasset').show(0);
	}
});

// show line chart prediction
function showLinePrediction() {

	$.ajax({
		type : "GET",
		url : 'predictionLineEachDataJSON.action',
		data : {
			alpha : alpha,
			selectPrediction : $('#selectprediction').val(),
			typeSelect : predictionid,
			typeCustomerId : $('#typecustomerid').val(),
			typeAssetId : $('#typeassetid').val()

		},
		success : function(response) {

			listDataCurrentYear = response.listDataCurrentYear;
			listDataNextYear = response.listDataNextYear;
			
			$('#table').remove();
			
			var appendText = '<table id="table" class="table table-striped"><tr><th style="width: 10px">';
			appendText = appendText+'#</th><th>Task</th><th>Progress</th><th style="width: 40px">Label</th></tr><tr><td>1.</td><td>Update software</td><td><div class="progress progress-xs"><div class="progress-bar progress-bar-danger"style="width: 55%"></div></div></td><td><span class="badge bg-red">55%</span></td></tr><tr><td>2.</td><td> Clean database </td><td><div class="progress progress-xs"><div class="progress-bar progress-bar-yellow" style="width: 100%"></div></div></td><td><span class="badge bg-yellow">100%</span></td></tr><tr><td>3.</td><td>Cron job running</td><td><div class="progress progress-xs progress-striped active"><div class="progress-bar progress-bar-primary" style="width: 30%"></div></div></td><td><span class="badge bg-light-blue">30%</span></td></tr><tr><td>4.</td><td>Fix and squish bugs</td><td><div class="progress progress-xs progress-striped active"><div class="progress-bar progress-bar-success" style="width: 90%"></div></div></td><td><span class="badge bg-green">90%</span></td></tr></table>';
			$('#showtable').append(appendText);

			$('#lineprediction').highcharts(
					{
						title : {
							text : 'Prediction Sum Cost Asset',
							x : -20
						// center
						},
						subtitle : {
							text : 'by year XXXX',
							x : -20
						},
						xAxis : {
							categories : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May',
									'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov',
									'Dec' ]
						},
						yAxis : {
							title : {
								text : 'value of customer'
							},
							plotLines : [ {
								value : 0,
								width : 1,
								color : '#808080'
							} ]
						},
						tooltip : {
							valueSuffix : ' unit'
						},
						legend : {
							layout : 'vertical',
							align : 'right',
							verticalAlign : 'middle',
							borderWidth : 0
						},
						series : [ {
							name : 'average Cuerrent year',
							color : Highcharts.getOptions().colors[2],
							data : listDataCurrentYear
						}, {
							name : 'prediction nextyear',
							color : Highcharts.getOptions().colors[8],
							data : listDataNextYear
						} ]
					});

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});

}

// show column chart prediction
function showColumnPrediction() {

	$
			.ajax({
				type : "GET",
				url : 'predictionColumnEachDataJSON.action',
				data : {
					alpha : alpha,
					selectPrediction : $('#selectprediction').val(),
					typeSelect : predictionid,
					typeCustomerId : $('#typecustomerid').val(),
					typeAssetId : $('#typeassetid').val()

				},
				success : function(response) {
					listDataCurrentYear = response.listDataCurrentYear;
					listDataNextYear = response.listDataNextYear;
					$('#table').remove();
					var appendText = '<table id="table" class="table table-striped"><tr><th style="width: 10px">#</th><th>Task</th><th>Progress</th><th style="width: 40px">Label</th></tr><tr><td>1.</td><td>Update software</td><td><div class="progress progress-xs"><div class="progress-bar progress-bar-danger"style="width: 55%"></div></div></td><td><span class="badge bg-red">55%</span></td></tr><tr><td>2.</td><td> Clean database </td><td><div class="progress progress-xs"><div class="progress-bar progress-bar-yellow" style="width: 100%"></div></div></td><td><span class="badge bg-yellow">100%</span></td></tr></table>';
					$('#showtable').append(appendText);
					
					$('#columnprediction')
							.highcharts(
									{
										chart : {
											type : 'column'
										},
										title : {
											text : 'Prediction Sum Cost Asset'
										},
										subtitle : {
											text : 'by year XXXX'
										},
										xAxis : {
											categories : [ 'Jan', 'Feb', 'Mar',
													'Apr', 'May', 'Jun', 'Jul',
													'Aug', 'Sep', 'Oct', 'Nov',
													'Dec' ],
											crosshair : true
										},
										yAxis : {
											min : 0,
											title : {
												text : ' value of person'
											}
										},
										tooltip : {
											headerFormat : '<span style="font-size:10px">{point.key}</span><table>',
											pointFormat : '<tr><td style="color:{series.color};padding:0">{series.name}: </td>'
													+ '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
											footerFormat : '</table>',
											shared : true,
											useHTML : true
										},
										plotOptions : {
											column : {
												pointPadding : 0.2,
												borderWidth : 0
											}
										},
										series : [ {
											name : 'average Current Year',
											data : listDataCurrentYear

										}, {
											name : 'prediction Next Year',
											data : listDataNextYear

										} ]
									});

				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

}

function showScatterPrediction() {

	$
			.ajax({
				type : "GET",
				url : 'predictionScatterEachDataJSON.action',
				data : {
					alpha : alpha,
					selectPrediction : $('#selectprediction').val(),
					typeSelect : predictionid,
					typeCustomerId : $('#typecustomerid').val(),
					typeAssetId : $('#typeassetid').val()

				},
				success : function(response) {

					listDataCurrentYear = response.listDataCurrentYear;
					listDataNextYear = response.listDataNextYear;
					
					$('#table').remove();
					var appendText = '<table id="table" class="table table-striped"><tr><th style="width: 10px">#</th><th>Task</th><th>Progress</th><th style="width: 40px">Label</th></tr><tr><td>1.</td><td>Update software</td><td><div class="progress progress-xs"><div class="progress-bar progress-bar-danger"style="width: 55%"></div></div></td><td><span class="badge bg-red">55%</span></td></tr><tr><td>2.</td><td> Clean database </td></table>';
					$('#showtable').append(appendText);
					
					$('#scatterprediction')
							.highcharts(
									{
										chart : {
											type : 'scatter',
											zoomType : 'xy'
										},
										title : {
											text : 'Prediction Sum Cost Asset'
										},
										subtitle : {
											text : 'by year XXXX'
										},
										xAxis : {
											title : {
												enabled : true,
												text : 'Date (month)'
											},
											startOnTick : true,
											endOnTick : true,
											showLastLabel : true
										},
										yAxis : {
											title : {
												text : 'Cost (unit)'
											}
										},
										legend : {
											layout : 'vertical',
											align : 'left',
											verticalAlign : 'top',
											x : 100,
											y : 70,
											floating : true,
											backgroundColor : (Highcharts.theme && Highcharts.theme.legendBackgroundColor)
													|| '#FFFFFF',
											borderWidth : 1
										},
										plotOptions : {
											scatter : {
												marker : {
													radius : 5,
													states : {
														hover : {
															enabled : true,
															lineColor : 'rgb(100,100,100)'
														}
													}
												},
												states : {
													hover : {
														marker : {
															enabled : false
														}
													}
												},
												tooltip : {
													headerFormat : '<b>{series.name}</b><br>',
													pointFormat : '{point.x} month, {point.y} unit'
												}
											}
										},
										series : [ {
											name : 'prediction Current Year',
											color : 'rgba(223, 83, 83, .5)',
											data : listDataCurrentYear

										}, {
											name : 'prediction Next Year',
											color : 'rgba(119, 152, 191, .5)',
											data : listDataNextYear
										} ]
									});
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

}