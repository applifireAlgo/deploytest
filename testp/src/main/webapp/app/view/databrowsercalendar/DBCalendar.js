Ext.define('Testp.view.databrowsercalendar.DBCalendar', {
	extend : 'Testp.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Testp.view.databrowsercalendar.DBCalendarController',
	             'Testp.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
