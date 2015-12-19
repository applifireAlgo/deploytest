/**
 * 
 */
Ext.define('Testproj.view.logalarm.mainscreen.LogAlarmMainViewTabPanel', {
	extend : 'Ext.tab.Panel',
	xtype : 'logAlarmMainViewTabPanel',
	
	requires : ['Testproj.view.logalarm.mainscreen.LogAlarmMainViewTabPanelController', 'Ext.ux.TabReorderer','Testproj.view.logalarm.mainscreen.AddLogAlarm'],
	
	controller : 'logAlarmMainViewTabPanelController',
	defaults: {
        bodyPadding: 10,
        autoScroll : true,
    },
});