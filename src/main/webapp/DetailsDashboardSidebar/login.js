$(function() {
	 var test1 = [];
	 var test2 = [];
	 var data1 = [];
	 var data2 = [];
	$.ajax({
		  type : "GET",
		  url : 'loginJson.action',
		  data : {},
		  success : function(response) {
			  test1 = response.numberarray1;
			  test2 = response.numberarray2;
			  
		    $('#dashboardlogin')
			.highcharts(
					{
						chart : {
							type : 'area'
						},
						title : {
							text : 'Data Yearly Users Login'
						},
						subtitle : {
							text : ''
						},
						xAxis : {
							allowDecimals : false,
							labels : {
								formatter : function() {
									return this.value; // clean, unformatted
														// number for year
								}
							}
						},
						yAxis : {
							title : {
								text : 'Value Of Time /sec.'
							},
							labels : {
								formatter : function() {
									return this.value / 1000 + 'k';
								}
							}
						},
						tooltip : {
							pointFormat : '{series.name} produced <b>{point.y:,.0f}</b><br/>warheads in {point.x}'
						},
						plotOptions : {
							area : {
								pointStart : 1,
								marker : {
									enabled : false,
									symbol : 'circle',
									radius : 2,
									states : {
										hover : {
											enabled : true
										}
									}
								}
							}
						},
						series : [
								{
									name : 'Current Year',
									data : test1
								},
								{
									name : 'Last Year',
									data : test2
								} ]
					});
		  },
		  error : function(e) {
		   alert('Error: ' + e);
		  }
		 });
	
	
	
});