Ext.define('Testproj.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testproj.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Testproj.view.mobileview.reportui.datachart.DataChartViewTab',
			'Testproj.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Testproj.view.mobileview.reportui.ReportViewController' ,
			'Testproj.view.mobileview.fw.DataPointPanel',
			'Testproj.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
