var customer = "";

var datacustomer1 = [];
var datacustomer2 = [];
$('#top-module').val(moment().format("YYYY"));
//$('#top-module').val("2014");
var years = $('#top-module').val();

$(function() {

	showCustomer();

	$('#top-module').change(function() {
		years = $('#top-module').val()
		showCustomer();
	});
});

function showCustomer() {
	$.ajax({
		type : "GET",
		url : 'customerJson.action',
		data : {
			year : years
		},
		success : function(response) {

			customer = response.customer;

			datacustomer1 = response.datacustomerCurrent;
			datacustomer2 = response.datacustomerLast;

			$('#dashboardcustomer').highcharts(
					{

						chart : {
							type : ''
						},

						title : {
							text : 'Data Year '+years+' Monthly Customers'
						},

						xAxis : {
							categories : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May',
									'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov',
									'Dec' ]
						},

						yAxis : {
							allowDecimals : false,
							min : 0,
							title : {
								text : 'Number of Customers'
							}
						},

						tooltip : {
							formatter : function() {
								return '<b>' + this.x + '</b><br/>'
										+ this.series.name + ': ' + this.y
										+ '<br/>' + 'Total: '
										+ this.point.stackTotal;
							}
						},

						plotOptions : {
							column : {
								stacking : 'normal'
							}
						},

						series : [ {
							name : 'Current Year',
							data : datacustomer1,
							stack : ''
						}, {
							name : 'Last Year',
							data : datacustomer2,
							stack : ''
						} ]
					});
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}