
var chart;
var listDataCurrentYear = [];
var listDataNextYear = [];
var alpha;
var date = [];
var mape;
$(function (){
	
	$('.alphavalue').hide(0);
	$('#line').show(0);
	$('#column').hide(0);
	$('#pie').hide(0);
	$('#scatter').hide(0);
	showLinePrediction();
	$('#loading').hide(0);
});

$('#selectchart,#alpha,#selectprediction').change(function() {
	$('#loading').show(0);
	alpha = $('#alpha').val();  
	chart = $('#selectchart').val();
	$('.alphavalue').hide(0);
	if($('#selectprediction').val()==2){
	$('.alphavalue').show(0);
	}
//	alert(chart);
	if(chart==1){
		$('#line').show(0);
		$('#column').hide(0);
		$('#pie').hide(0);
		$('#scatter').hide(0);
		showLinePrediction();
	}
	if(chart==2){
		$('#line').hide(0);
		$('#column').show(0);
		$('#pie').hide(0);
		$('#scatter').hide(0);
		showColumnPrediction();
	}
	if(chart==3){
		$('#line').hide(0);
		$('#column').hide(0);
		$('#pie').hide(0);
		$('#scatter').show(0);
		showScatterPrediction();
	}
	$('#loading').hide(0);
});

//$('#predictionid').change(function() {
//	var predictionid = $('#predictionid').val();
//	if(predictionid==1){
//		$('.predictionidcustomer').show(0);
//		$('.predictionidasset').hide(0);
//	}
//	if(predictionid==2){
//		$('.predictionidcustomer').hide(0);
//		$('.predictionidasset').show(0);
//	}
//});

//show line chart prediction
function showLinePrediction() {
	
	$
	.ajax({
		type : "GET",
		url : 'predictionLineDataJSON.action',
		data : {
			alpha:alpha,
			selectPrediction:$('#selectprediction').val()
			
		},
		success : function(response) {
			
			listDataCurrentYear = response.listDataCurrentYear;
			listDataNextYear = response.listDataNextYear;
			date = response.date;
			mape = response.mape.toFixed(2);
//			ListError = response.listError;
			$('#table').remove();
			
			var appendText = '<table id="table" class="table table-striped">';
			appendText = appendText+'<tr><th> </th><td> </td></tr><tr><th>MAPE</th><td>'+mape+'</td></tr></table>';
			$('#showtable').append(appendText);
			
			$('#lineprediction').highcharts({
		        title: {
		            text: 'Prediction All Sum Cost',
		            x: -20 //center
		        },
		        subtitle: {
		            text: 'by year 2015',
		            x: -20
		        },
		        xAxis: {
		            categories: date
		        },
		        yAxis: {
		            title: {
		                text: 'value of customer'
		            },
		            plotLines: [{
		                value: 0,
		                width: 1,
		                color: '#808080'
		            }]
		        },
		        tooltip: {
		            valueSuffix: ' unit'
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'right',
		            verticalAlign: 'middle',
		            borderWidth: 0
		        },
		        series: [ {
		            name: 'Average Current Year',
		            color : Highcharts
					.getOptions().colors[2],
		            data: listDataCurrentYear
		        }, {
		            name: 'Prediction Next Year',
		            color : Highcharts
					.getOptions().colors[8],
		            data: listDataNextYear
		        }]
		    });

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
    
    
}

//show column chart prediction
function showColumnPrediction() {
	
	$
	.ajax({
		type : "GET",
		url : 'predictionColumnDataJSON.action',
		data : {
			alpha:alpha,
			selectPrediction:$('#selectprediction').val()
			
		},
		success : function(response) {
			listDataCurrentYear = response.listDataCurrentYear;
			listDataNextYear = response.listDataNextYear;
			date = response.date;
			mape = response.mape.toFixed(2);
//			ListError = response.listError;
			$('#table').remove();
			
			var appendText = '<table id="table" class="table table-striped">';
			appendText = appendText+'<tr><th> </th><td> </td></tr><tr><th>MAPE</th><td>'+mape+'</td></tr></table>';
			$('#showtable').append(appendText);
			
			$('#columnprediction').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'Prediction All Sum Cost'
		        },
		        subtitle: {
		            text: 'by year 2015'
		        },
		        xAxis: {
		            categories: date,
		            crosshair: true
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: ' value of person'
		            }
		        },
		        tooltip: {
		            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
		            footerFormat: '</table>',
		            shared: true,
		            useHTML: true
		        },
		        plotOptions: {
		            column: {
		                pointPadding: 0.2,
		                borderWidth: 0
		            }
		        },
		        series: [ {
		            name: 'Average Current Year',
		            data: listDataCurrentYear

		        }, {
		            name: 'Prediction Next Year',
		            data: listDataNextYear

		        }]
		    });

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
    
    
}


function showScatterPrediction(){
	
	$
	.ajax({
		type : "GET",
		url : 'predictionScatterDataJSON.action',
		data : {
			alpha:alpha,
			selectPrediction:$('#selectprediction').val()
			
		},
		success : function(response) {
			
			listDataCurrentYear = response.listDataCurrentYear;
			listDataNextYear = response.listDataNextYear;
			date = response.date;
			mape = response.mape.toFixed(2);
			mse = response.mse.toFixed(2);
			mad = response.mad.toFixed(2);
//			ListError = response.listError;
			$('#table').remove();
			
			var appendText = '<table id="table" class="table table-striped">';
			appendText = appendText+'<tr><th> </th><td> </td></tr><tr><th>MAPE</th><td>'+mape+'</td></tr></table>';
			$('#showtable').append(appendText);	
			$('#scatterprediction').highcharts({
		        chart: {
		            type: 'scatter',
		            zoomType: 'xy'
		        },
		        title: {
		            text: 'Prediction All Sum Cost'
		        },
		        subtitle: {
		            text: 'by year 2015'
		        },
		        xAxis: {
		            title: {
		                enabled: true,
		                text: 'Date (month)'
		            },
		            startOnTick: true,
		            endOnTick: true,
		            showLastLabel: true
		        },
		        yAxis: {
		            title: {
		                text: 'Cost (unit)'
		            }
		        },
		        legend: {
		            layout: 'vertical',
		            align: 'left',
		            verticalAlign: 'top',
		            x: 100,
		            y: 70,
		            floating: true,
		            backgroundColor: (Highcharts.theme && Highcharts.theme.legendBackgroundColor) || '#FFFFFF',
		            borderWidth: 1
		        },
		        plotOptions: {
		            scatter: {
		                marker: {
		                    radius: 5,
		                    states: {
		                        hover: {
		                            enabled: true,
		                            lineColor: 'rgb(100,100,100)'
		                        }
		                    }
		                },
		                states: {
		                    hover: {
		                        marker: {
		                            enabled: false
		                        }
		                    }
		                },
		                tooltip: {
		                    headerFormat: '<b>{series.name}</b><br>',
		                    pointFormat: '{point.x} month, {point.y} unit'
		                }
		            }
		        },
		        series: [{
		            name: 'Prediction Current Year',
		            color: 'rgba(223, 83, 83, .5)',
		            data: listDataCurrentYear

		        }, {
		            name: 'Prediction Next Year',
		            color: 'rgba(119, 152, 191, .5)',
		            data: listDataNextYear
		        }]
		    });
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
	
	    
}

function getTextHTML(ListError){
	var text = '' ;
	for (i = 0; i < ListError.length; i++){
		text = text + '<tr><td>'+(i+1)+'</td><td>'+ListError[i]+'</td></tr>';
	}
	
	return text;
}