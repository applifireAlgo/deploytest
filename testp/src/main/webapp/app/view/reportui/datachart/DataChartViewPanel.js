Ext.define('Testp.view.reportui.datachart.DataChartViewPanel', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testp.view.reportui.datachart.DataChartPController',
			'Testp.view.reportui.datachart.datagrid.DataGridView',
			'Testp.view.reportui.datachart.chart.ChartTabView',
			'Testp.view.reportui.datachart.ChartPointView' ],
	controller : 'datachartpController',
	xtype : 'datachart-panel',
	itemId : 'datachart-tabpanel',
	viewType : "panel",
	bodyStyle : 'background:#D8D8D8',

	margin : '0 0 0 0',
	autoScroll : true,
	// layout : 'fit',
	layout : {
		type : 'accordion',
		padding : 0,
		align : 'stretch',
   		multi : true,
   		titleCollapse: false
	},
	initComponent : function() {
		
		this.callParent(arguments);
	},
	listeners : {
		scope : "controller",
		tabchange : 'tabchange'
	}

});