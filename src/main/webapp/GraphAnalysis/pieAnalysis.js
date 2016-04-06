$(function () {

    // Radialize the colors
    Highcharts.getOptions().colors = Highcharts.map(Highcharts.getOptions().colors, function (color) {
        return {
            radialGradient: {
                cx: 0.5,
                cy: 0.3,
                r: 0.7
            },
            stops: [
                [0, color],
                [1, Highcharts.Color(color).brighten(-0.3).get('rgb')] // darken
            ]
        };
    });

    // Build the chart
    $('#pieanalysis').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Assets'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
        series: [{
            name: 'Category Assets',
            data: [
                { name: 'Foreign Stocks', y: 14.3625 },
                {
                    name: 'Exchange Rate',
                    y: 52.3125,
                    sliced: true,
                    selected: true
                },
                { name: 'Gold', y: 2 },
                { name: 'Land', y: 4.7375 }, 
                { name: 'Oil', y: 7.575 },
                { name: 'Building', y: 5.4125 },
                { name: 'Equipment', y: 1.1375 }, 
                { name: 'Mine', y: 12.4625 },
            ]
        }]
    });
    
    $('#pieanalysisperson').highcharts({
        chart: {
            plotBackgroundColor: null,
            plotBorderWidth: null,
            plotShadow: false,
            type: 'pie'
        },
        title: {
            text: 'Customers'
        },
        tooltip: {
            pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
        },
        plotOptions: {
                pie: {
                    allowPointSelect: true,
                    cursor: 'pointer',
                    dataLabels: {
                        enabled: false
                    },
                    showInLegend: true
                }
            },
        series: [{
            name: 'Category Customers',
            data: [
                { name: 'Personal', y: 50.9 },
                {
                    name: 'Corporation',
                    y: 49.1,
                    sliced: true,
                    selected: true
                }
            ]
        }]
    });
    
    
    
    
});