var user = [];
var datauser1 = [];
var datauser2 = [];
var datauser3 = [];
var datauser4 = [];
var datauser5 = [];

var sex = [];
$('#top-module').val(moment().format("YYYY"));
var years = $('#top-module').val();
$(function() {
	showTopUser();
	$('#top-module').change(function() {
		years = $('#top-module').val()
		showTopUser();
	});
});

function showTopUser() {
	$.ajax({
		type : "GET",
		url : 'TopUserJson.action',
		data : {
			year : years
		},
		success : function(response) {
			datauser1 = response.datauser1;
			datauser2 = response.datauser2;
			datauser3 = response.datauser3;
			datauser4 = response.datauser4;
			datauser5 = response.datauser5;

			user = response.user;

			sex = response.sex;
			$('#dashboardtopuser').highcharts(
					{
						chart : {
							type : 'column'
						},
						title : {
							text : 'Year ' + years + ' Users Top Users'
						},
						subtitle : {
							text : ''
						},
						xAxis : {
							categories : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May',
									'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov',
									'Dec' ],
							tickmarkPlacement : 'on',
							title : {
								enabled : false
							}
						},
						yAxis : {
							title : {
								text : 'Time'
							},
							labels : {
								formatter : function() {
									return this.value / 1000;
								}
							}
						},
						tooltip : {
							shared : true,
							valueSuffix : ' ms.'
						},
						plotOptions : {
							area : {
								stacking : 'normal',
								lineColor : '#666666',
								lineWidth : 1,
								marker : {
									lineWidth : 1,
									lineColor : '#666666'
								}
							}
						},
						series : [ {
							name : user[0],
							data : datauser1,
							stack : sex[1]
						}, {
							name : user[1],
							data : datauser2,
							stack : sex[0]
						}, {
							name : user[2],
							data : datauser3,
							stack : sex[0]
						}, {
							name : user[3],
							data : datauser4,
							stack : sex[1]
						}, {
							name : user[4],
							data : datauser5,
							stack : sex[0]
						} ]
					});
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}