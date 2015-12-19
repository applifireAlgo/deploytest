/**
 * 
 */
Ext.define("Testproj.view.scheduleconfiguration.tab.ScheduleConfigTab", {
	extend : 'Ext.tab.Panel',
	xtype : 'schedulerConfigTab',
	requires : [ 'Testproj.view.scheduleconfiguration.tab.ScheduleConfigTabController' ],
	controller : 'schedulerConfigTabController'
});