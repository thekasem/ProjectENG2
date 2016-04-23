var selecttime = "";
var fromyear = "";
var toyear = "";
var frommonth = "";
var tomonth = "";
var toyearII = "";
var textName = "";

var listPercentCustomer = [];
var listPercentAsset = [];

$(function() {
	selecttime = $('#selecttime').val();
	showDataGraphPie();

});

$('.changepie').change(function() {
	selecttime = $('#selecttime').val();
	fromyear = $('#fromyear').val();
	toyear = $('#toyear').val();
	frommonth = $('#frommonth').val();
	tomonth = $('#tomonth').val();
	toyearII = $('#toyear2').val();

//	 alert("selecttime" + selecttime + "fromyear:" + fromyear
//	 + " toyear:" + toyear + " frommonth:" + frommonth
//	 + " tomonth:" + tomonth);
	showDataGraphPie();
});

function showDataGraphPie() {
	$
			.ajax({
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
					
					listPercentCustomer = response.percentCustomer;
					listPercentAsset = response.percentAsset;
					textName = response.dateSelect;


					// Build the chart
					$('#pieanalysis')
							.highcharts(
									{
										chart : {
											plotBackgroundColor : null,
											plotBorderWidth : null,
											plotShadow : false,
											type : 'pie'
										},
										title : {
											text : 'Assets '+textName
										},
										tooltip : {
											pointFormat : '{series.name}: <b>{point.percentage:.2f}%</b>'
										},
										plotOptions : {
											pie : {
												allowPointSelect : true,
												cursor : 'pointer',
												dataLabels : {
													enabled : false
												},
												showInLegend : true
											}
										},
										series : [ {
											name : 'Category Assets',
											colorByPoint: true,
											data : [ {
												name : 'Foreign Stocks',
												y : listPercentAsset[0]
											}, {
												name : 'Exchange Rate',
												y : listPercentAsset[1],
												sliced : true,
												selected : true
											}, {
												name : 'Gold',
												y : listPercentAsset[2]
											}, {
												name : 'Land',
												y : listPercentAsset[3]
											}, {
												name : 'Oil',
												y : listPercentAsset[4]
											}, {
												name : 'Building',
												y : listPercentAsset[5]
											}, {
												name : 'Equipment',
												y : listPercentAsset[6]
											}, {
												name : 'Mine',
												y : listPercentAsset[7]
											}, ]
										} ]
									});

					$('#pieanalysisperson')
							.highcharts(
									{
										chart : {
											plotBackgroundColor : null,
											plotBorderWidth : null,
											plotShadow : false,
											type : 'pie'
										},
										title : {
											text : 'Customers '+textName
										},
										tooltip : {
											pointFormat : '{series.name}: <b>{point.percentage:.2f}%</b>'
										},
										plotOptions : {
											pie : {
												allowPointSelect : true,
												cursor : 'pointer',
												dataLabels : {
													enabled : false
												},
												showInLegend : true
											}
										},
										series : [ {
											name : 'Category Customers',
											colorByPoint: true,
											data : [ {
												name : 'Personal',
												y : listPercentCustomer[0]
											}, {
												name : 'Corporation',
												y : listPercentCustomer[1],
												sliced : true,
												selected : true
											} ]
										} ]
									});
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
}
