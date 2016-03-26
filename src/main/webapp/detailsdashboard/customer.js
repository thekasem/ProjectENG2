$(function() {
	$('#customer').highcharts({
		chart : {
			type : 'column',
			margin : 75,
		},
		title : {
			text : 'Customer'
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
			categories : Highcharts.getOptions().lang.shortMonths
		},
		yAxis : {
			title : {
				text : null
			}
		},
		series : [ {
			name : 'Sales',
			data : [ 2, 3, null, 4, 0, 5, 1, 4, 6, 3 ]
		} ]
	});
});