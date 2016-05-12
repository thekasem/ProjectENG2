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

var listPercentCustomer = [];
var listPercentAsset = [];


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
			showDataGraphPieAsset();
		}else if(selectType=="2"){
			$("#showasset").show(0);
			$('#showcustomer').hide(0);
			showDataGraphPieCustomer();
		}

 });

function showDataGraphPieCustomer() {
	$
			.ajax({
				type : "GET",
				url : 'analysisPieEachCustomerDataJSON.action',
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

					listPercentCustomer = response.percentCustomer;
					textName = response.dateSelect;

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
											text : 'Customers of assetId :'+assetid+" on " + textName
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
											colorByPoint : true,
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

function showDataGraphPieAsset() {
	$
			.ajax({
				type : "GET",
				url : 'analysisPieEachAssetDataJSON.action',
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
											text : 'Assets of CutomerId : '+customerid+" on " + textName
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
											colorByPoint : true,
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

				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});

}

