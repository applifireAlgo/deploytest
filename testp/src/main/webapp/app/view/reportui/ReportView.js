Ext.define('Testp.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testp.view.reportui.querycriteria.QueryCriteriaView',
			'Testp.view.reportui.datachart.DataChartViewTab',
			'Testp.view.reportui.datachart.DataChartViewPanel',
			'Testp.view.reportui.ReportViewController' ,
			'Testp.view.fw.MainDataPointPanel',
			'Testp.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
