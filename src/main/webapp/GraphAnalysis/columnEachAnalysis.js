var selecttime = "";
var fromyear = "";
var toyear = "";
var frommonth = "";
var tomonth = "";
var toyearII = "";
var textName = "";
var selectType = "";
var assetid = "";
var customerid = "";

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
	$("#showasset").hide(0);
	$('#showcustomer').show(0);
});

$('#send').click(function() {
	
		selecttime = $('#selecttime').val();
		fromyear = $('#fromyear').val();
		toyear = $('#toyear').val();
		frommonth = $('#frommonth').val();
		tomonth = $('#tomonth').val();
		toyearII = $('#toyear2').val();
		selectType = $('#analysisid').val();
		assetid = $('#assetid').val();
		customerid = $('#customerid').val();
		
		if(selectType=="1"){
			$("#showasset").hide(0);
			$('#showcustomer').show(0);
			showDataEachGraphLineAsset();
		}else if(selectType=="2"){
			$("#showasset").show(0);
			$('#showcustomer').hide(0);
			showDataEachGraphLineCustomer();
		}

});

function showDataEachGraphLineCustomer() {

	$.ajax({
		type : "GET",
		url : 'analysisEachCustomerDataJSON.action',
		data : {
			selectTime : selecttime,
			fromYear : fromyear,
			toYear : toyear,
			fromMonth : frommonth,
			toMonth : tomonth,
			toYearII : toyearII,
			assetId : assetid
		},
		success : function(response) {
			
			dateList = response.dateList;
			
			person = response.person;
			corperation = response.corperation;
			textName = response.dateSelect;
			
			$('#columnanalysisperson').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'Customers'
		        },
		        subtitle: {
		            text: 'Assets '+ textName
		        },
		        xAxis: {
		            categories: dateList,
		            crosshair: true
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: 'unit'
		            }
		        },
		        tooltip: {
		            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		                '<td style="padding:0"><b>{point.y:.2f} Unit</b></td></tr>',
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
		        series: [{
		            name: 'Personal',
		            data: person

		        }, {
		            name: 'Corporation',
		            data: corperation

		        }]
		    });

		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}


function showDataEachGraphLineAsset() {

	$.ajax({
		type : "GET",
		url : 'analysisEachAssetDataJSON.action',
		data : {
			selectTime : selecttime,
			fromYear : fromyear,
			toYear : toyear,
			fromMonth : frommonth,
			toMonth : tomonth,
			toYearII : toyearII,
			customerId : customerid
		},
		success : function(response) {
			
			dateList = response.dateList;
			
			stocks = response.stocks;
			exchange = response.exchange;
			gold = response.gold;
			land = response.land;
			oil = response.oil;
			bulding = response.bulding;
			equipment = response.equipment;
			mine = response.mine;
			
			textName = response.dateSelect;
			

			$('#columnanalysis').highcharts({
		        chart: {
		            type: 'column'
		        },
		        title: {
		            text: 'Assets'
		        },
		        subtitle: {
		            text: 'Assets '+ textName
		        },
		        xAxis: {
		            categories: dateList,
		            crosshair: true
		        },
		        yAxis: {
		            min: 0,
		            title: {
		                text: 'unit'
		            }
		        },
		        tooltip: {
		            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
		            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
		                '<td style="padding:0"><b>{point.y:.2f} Unit</b></td></tr>',
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
		        series: [{
		            name: 'Foreign stocks',
		            data: stocks

		        }, {
		            name: 'Exchange rate',
		            data: exchange

		        }, {
		            name: 'Gold',
		            data: gold

		        }, {
		            name: 'Land',
		            data: land

		        }, {
		            name: 'Oil',
		            data: oil

		        }, {
		            name: 'Bulding',
		            data: bulding

		        }, {
		            name: 'Equipment',
		            data: equipment

		        }, {
		            name: 'Mine',
		            data: mine

		        }]
		    });
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});

}