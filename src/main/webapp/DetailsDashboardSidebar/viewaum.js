var asset = [];

var dataAUMBYCIF = [];
var dataAUMBYBranch = [];
var dataPortholding = [];
$('#top-module').val(moment().format("YYYY"));
var years = $('#top-module').val();

$(function() {
	showViewAUM()
	$('#top-module').change(function() {
		years = $('#top-module').val()
		showViewAUM();
	});
});

function showViewAUM() {
	$
			.ajax({
				type : "GET",
				url : 'viewAUMJson.action',
				data : {
					year : years
				},
				success : function(response) {

					asset = response.asset;

					dataAUMBYCIF = response.dataAUMBYCIF;
					dataAUMBYBranch = response.dataAUMBYBranch;
					dataPortholding = response.dataPortholding;

					$('#dashboardviewaum')
							.highcharts(
									{
										chart : {
											type : 'spline'
										},
										title : {
											text : 'Data Year ' + years
													+ ' Users AUM'
										},
										subtitle : {
											text : ''
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
												text : 'Asset Holding (million)'
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
											name : asset[0],
											data : dataAUMBYCIF
										}, {
											name : asset[1],
											data : dataAUMBYBranch
										}, {
											name : asset[2],
											data : dataPortholding
										} ]
									});
				},
				error : function(e) {
					alert('Error: ' + e);
				}
			});
}