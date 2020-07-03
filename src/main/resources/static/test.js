/*$.ajax({
	url:'historique',
	success: function(result){
		var soldeclient=JSON.parse(result).soldeclient;
		var soldebanque=JSON.parse(result).soldebanque;
		drawSalesByRegionChart(soldeclient,soldebanque);
		}
})

 function drawSalesByRegionChart(soldeclient,soldebanque) {
        var salesByRegionChart = Highcharts.chart('conta', {
            chart: {
                type: 'pie',
                margin: 40,
              
            },
            title: {
                text: 'Sales by Region'
            },
            xAxis:{
            	categories:
            }
            tooltip: {
                pointFormat: "${point.y:,.0f}"
            },

            plotOptions: {
                series: {
                    label: {
                        connectorAllowed: false
                    },
                    pointStart: 2010
                }
            },
            series: [{
            	data:soldeclient;
            }]
        });
    }
     */


$.ajax({
	url:'historique',
	success: function(result){
		console.log(result);
	}})
	