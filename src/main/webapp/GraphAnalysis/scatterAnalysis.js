var selecttime = "";
var fromyear = "";
var toyear = "";
var frommonth = "";
var tomonth = "";
var toyearII = "";
var textName = "";

var dateList = [];

var person = [];
var corperation = [];
var stocks = [];
var exchange = [];
var gold = [];
var land = [];
var oil = [];
var bulding = [];
var equipment = [];
var mine = [];

$(function() {
	selecttime = $('#selecttime').val();
	showDataGraphColumn();
});

$('.changeselect').change(function() {
	selecttime = $('#selecttime').val();
	fromyear = $('#fromyear').val();
	toyear = $('#toyear').val();
	frommonth = $('#frommonth').val();
	tomonth = $('#tomonth').val();
	toyearII = $('#toyear2').val();

	showDataGraphColumn();
});

function showDataGraphColumn() {

	$.ajax({
		type : "GET",
		url : 'analysisDataJSON.action',
		data : {
			selectTime : selecttime,
			fromYear : fromyear,
			toYear : toyear,
			fromMonth : frommonth,
			toMonth : tomonth,
			toYearII : toyearII
		},
		success : function(response) {
			
			dateList = response.dateList;
			
			person = response.person;
			corperation = response.corperation;
			stocks = response.stocks;
			exchange = response.exchange;
			gold = response.gold;
			land = response.land;
			oil = response.oil;
			bulding = response.bulding;
			equipment = response.equipment;
			mine = response.mine;
			textName = response.dateSelect;
			
			$('#scatteranalysis').highcharts({
		        chart: {
		            type: 'scatter',
		            zoomType: 'xy'
		        },
		        title: {
		            text: 'Assets'
		        },
		        subtitle: {
		            text: 'Assets '+ textName
		        },
		        xAxis: {
		            title: {
		                enabled: true,
		                text: 'Unit'
		            },
		            startOnTick: true,
		            endOnTick: true,
		            showLastLabel: true
		        },
		        yAxis: {
		            title: {
		                text: 'Time'
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
		            name: 'Foreign stocks',
		            color: 'rgba(223, 83, 83, .5)',
		            data: stocks

		        }, {
		            name: 'Exchange rate',
		            color: 'rgba(119, 152, 191, .5)',
		            data: exchange
		        }, {
		            name: 'Gold',
		            color: 'rgba(223, 83, 83, .5)',
		            data: gold

		        }, {
		            name: 'Land',
		            color: 'rgba(119, 152, 191, .5)',
		            data: land
		        }, {
		            name: 'Oil',
		            color: 'rgba(223, 83, 83, .5)',
		            data: oil

		        }, {
		            name: 'Bulding',
		            color: 'rgba(119, 152, 191, .5)',
		            data: bulding
		        }, {
		            name: 'Equipment',
		            color: 'rgba(223, 83, 83, .5)',
		            data: equipment

		        }, {
		            name: 'Mine',
		            color: 'rgba(119, 152, 191, .5)',
		            data: mine
		        }]
		    });
		    
		    $('#scatteranalysisperson').highcharts({
		        chart: {
		            type: 'scatter',
		            zoomType: 'xy'
		        },
		        title: {
		            text: 'Customers'
		        },
		        subtitle: {
		            text: 'Assets '+ textName
		        },
		        xAxis: {
		            title: {
		                enabled: true,
		                text: 'Unit'
		            },
		            startOnTick: true,
		            endOnTick: true,
		            showLastLabel: true
		        },
		        yAxis: {
		            title: {
		                text: 'Time'
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
		            name: 'Personal',
		            color: 'rgba(223, 83, 83, .5)',
		            data: person

		        }, {
		            name: 'Corporation',
		            color: 'rgba(119, 152, 191, .5)',
		            data: corperation
		        }]
		    });
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}