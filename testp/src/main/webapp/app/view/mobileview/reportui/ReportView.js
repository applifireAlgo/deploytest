Ext.define('Testp.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testp.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Testp.view.mobileview.reportui.datachart.DataChartViewTab',
			'Testp.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Testp.view.mobileview.reportui.ReportViewController' ,
			'Testp.view.mobileview.fw.DataPointPanel',
			'Testp.view.mobileview.googlemaps.map.MapPanel'
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
