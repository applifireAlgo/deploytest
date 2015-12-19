Ext.define('Testproj.view.databrowsercalendar.DBCalendar', {
	extend : 'Testproj.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testproj.view.databrowsercalendar.DBCalendarController',
	             'Testproj.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
