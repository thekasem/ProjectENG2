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
	showDataGraphPie();
});

$('.changepie').change(function() {
	selecttime = $('#selecttime').val();
	fromyear = $('#fromyear').val();
	toyear = $('#toyear').val();
	frommonth = $('#frommonth').val();
	tomonth = $('#tomonth').val();
	toyearII = $('#toyear2').val();

	showDataGraphPie();
});

function showDataGraphPie() {

	$.ajax({
		type : "GET",
		url : 'analysisLineDataJSON.action',
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
			
			$('#lineanalysis').highcharts(
					{
						title : {
							text : 'Assets',
							x : -20
						// center
						},
						subtitle : {
							text : 'Assets '+textName,
							x : -20
						},
						xAxis : {
							categories : dateList
						},
						yAxis : {
							title : {
								text : 'values of Asset'
							},
							plotLines : [ {
								value : 0,
								width : 1,
								color : '#808080'
							} ]
						},
						tooltip : {
							valueSuffix : '°C'
						},
						legend : {
							layout : 'vertical',
							align : 'right',
							verticalAlign : 'middle',
							borderWidth : 0
						},
						series : [
								{
									name : 'Foreign stocks',
									data : stocks
								},
								{
									name : 'Exchange rate',
									data : exchange
								},
								{
									name : 'Gold',
									data : gold
								},
								{
									name : 'Land',
									data : land
								},
								{
									name : 'Oil',
									data : oil
								},
								{
									name : 'Bulding',
									data : bulding
								},
								{
									name : 'Equipment',
									data : equipment
								},
								{
									name : 'Mine',
									data : mine
								} ]
					});

			$('#lineanalysisperson').highcharts(
					{
						title : {
							text : 'Customers',
							x : -20
						// center
						},
						subtitle : {
							text : 'Assets '+textName,
							x : -20
						},
						xAxis : {
							categories : dateList
						},
						yAxis : {
							title : {
								text : 'value of Asset'
							},
							plotLines : [ {
								value : 0,
								width : 1,
								color : '#808080'
							} ]
						},
						tooltip : {
							valueSuffix : 'unit'
						},
						legend : {
							layout : 'vertical',
							align : 'right',
							verticalAlign : 'middle',
							borderWidth : 0
						},
						series : [
								{
									name : 'Personal',
									data : person
								},
								{
									name : 'Corperation',
									data : corperation
								} ]
					});
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}