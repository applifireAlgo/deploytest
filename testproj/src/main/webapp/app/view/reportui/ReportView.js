Ext.define('Testproj.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testproj.view.reportui.querycriteria.QueryCriteriaView',
			'Testproj.view.reportui.datachart.DataChartViewTab',
			'Testproj.view.reportui.datachart.DataChartViewPanel',
			'Testproj.view.reportui.ReportViewController' ,
			'Testproj.view.fw.MainDataPointPanel',
			'Testproj.view.googlemaps.map.MapPanel'
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
