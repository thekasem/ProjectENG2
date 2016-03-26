///**
// * Grid-light theme for Highcharts JS
// * @author Torstein Honsi
// */
//
//// Load the fonts
//Highcharts.createElement('link', {
//   href: '//fonts.googleapis.com/css?family=Dosis:400,600',
//   rel: 'stylesheet',
//   type: 'text/css'
//}, null, document.getElementsByTagName('head')[0]);
//
//Highcharts.theme = {
//   colors: ["#7cb5ec", "#f7a35c", "#90ee7e", "#7798BF", "#aaeeee", "#ff0066", "#eeaaee",
//      "#55BF3B", "#DF5353", "#7798BF", "#aaeeee"],
//   chart: {
//      backgroundColor: null,
//      style: {
//         fontFamily: "Dosis, sans-serif"
//      }
//   },
//   title: {
//      style: {
//         fontSize: '16px',
//         fontWeight: 'bold',
//         textTransform: 'uppercase'
//      }
//   },
//   tooltip: {
//      borderWidth: 0,
//      backgroundColor: 'rgba(219,219,216,0.8)',
//      shadow: false
//   },
//   legend: {
//      itemStyle: {
//         fontWeight: 'bold',
//         fontSize: '13px'
//      }
//   },
//   xAxis: {
//      gridLineWidth: 1,
//      labels: {
//         style: {
//            fontSize: '12px'
//         }
//      }
//   },
//   yAxis: {
//      minorTickInterval: 'auto',
//      title: {
//         style: {
//            textTransform: 'uppercase'
//         }
//      },
//      labels: {
//         style: {
//            fontSize: '12px'
//         }
//      }
//   },
//   plotOptions: {
//      candlestick: {
//         lineColor: '#404048'
//      }
//   },
//   credits : {
//		enabled : false
//	},
//
//	exporting: {
//        buttons: {
//            contextButton: {
//                enabled: false
//            },
//            exportButton: {
////            	id:'best',
////            	priority:3000,
//            	text: 'Download',
////            	y: 500,
////                x:-10,
////                z_index:3000,
//                // Use only the download related menu items from the default context button
//                menuItems: Highcharts.getOptions().exporting.buttons.contextButton.menuItems.splice(2)
//            },
//            printButton: {
////            	id:'au',
//                text: 'Print',
//                onclick: function () {
//                    this.print();
//                }
//            }
//        }
//    },
//    
//    
//   // General
//   background2: '#F0F0EA'
//
//};
//
//// Apply the theme
//Highcharts.setOptions(Highcharts.theme);
//
//



$(function() {
	Highcharts.createElement('link', {
		href : '//fonts.googleapis.com/css?family=Dosis:400,600',
		rel : 'stylesheet',
		type : 'text/css'
	}, null, document.getElementsByTagName('head')[0]);
	Highcharts.theme = {
		colors : [ "#7cb5ec", "#f7a35c", "#90ee7e", "#7798BF", "#aaeeee",
				"#ff0066", "#eeaaee", "#55BF3B", "#DF5353", "#7798BF",
				"#aaeeee" ],
		chart : {
			backgroundColor : null,
			style : {
				fontFamily : "Dosis, sans-serif"
			}
		},
		title : {
			style : {
				fontSize : '16px',
				fontWeight : 'bold',
				textTransform : 'uppercase'
			}
		},
		tooltip : {
			borderWidth : 0,
			backgroundColor : 'rgba(219,219,216,0.8)',
			shadow : false
		},
		legend : {
			itemStyle : {
				fontWeight : 'bold',
				fontSize : '13px'
			}
		},
		xAxis : {
			gridLineWidth : 1,
			labels : {
				style : {
					fontSize : '12px'
				}
			}
		},
		yAxis : {
			minorTickInterval : 'auto',
			title : {
				style : {
					textTransform : 'uppercase'
				}
			},
			labels : {
				style : {
					fontSize : '12px'
				}
			}
		},
		plotOptions : {
			candlestick : {
				lineColor : '#404048'
			}
		},
		credits : {
			enabled : false
		},
		exporting: {
	        buttons: {
	            contextButton: {
	                enabled: false
	            },
	            exportButton: {
	            	text: 'Download',
	                // Use only the download related menu items from the default context button
	                menuItems: Highcharts.getOptions().exporting.buttons.contextButton.menuItems.splice(2)
	            },
	            printButton: {
	                text: 'Print',
	                onclick: function () {
	                    this.print();
	                }
	            }
	        }
	    },
	};
	Highcharts.setOptions(Highcharts.theme);
});