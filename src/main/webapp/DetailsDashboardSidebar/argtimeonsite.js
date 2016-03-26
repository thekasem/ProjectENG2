var timeonsite = "";

var dataaverage = [];
$('#top-module').val(moment().format("YYYY"));
var years = $('#top-module').val();

$(function() {
	showAverageTimeOnSite()
	$('#top-module').change(function() {
		years = $('#top-module').val()
		showAverageTimeOnSite();
	});

});

function showAverageTimeOnSite() {
	$.ajax({
		type : "GET",
		url : 'averageJson.action',
		data : {
			year : years
		},
		success : function(response) {

			dataaverage = response.dataaverage;

			timeonsite = response.timeonsite;

			$('#dashboardaverage').highcharts(
					{
						chart : {
							type : 'column',
							margin : 75,
							options3d : {
								enabled : true,
								alpha : 10,
								beta : 25,
								depth : 70
							}
						},
						title : {
							text : 'Data Year ' + years
									+ ' Users Average Time On Site'
						},
						subtitle : {
							text : ''
						},
						plotOptions : {
							column : {
								depth : 25
							}
						},
						xAxis : {
							categories : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May',
									'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov',
									'Dec' ]
						},
						yAxis : {
							title : {
								text : 'time (ms.)'
							}
						},
						series : [ {
							name : timeonsite,
							data : dataaverage
						} ]
					});
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}