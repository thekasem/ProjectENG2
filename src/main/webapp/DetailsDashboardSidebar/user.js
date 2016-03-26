$(function() {

	var dateLastYear = [];
	var dateCurrentYear = [];
	var monthName = [];
	$.ajax({
		type : "GET",
		url : 'UserJson.action',
		data : {},
		success : function(response) {
			monthName = response.month;
			dateLastYear = response.dataLastYear;
			dateCurrentYear = response.dataCurrentYear;
			$('#dashboarduser').highcharts({
				chart : {
					type : 'area'
				},
				title : {
					text : ''
				},
				xAxis : {
					categories : monthName
				},
				credits : {
					enabled : false
				},
				series : [ {
					name : 'Last Year',
					data : dateLastYear
				}, {
					name : 'Current Year',
					data : dateCurrentYear
				} ]
			});
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
});