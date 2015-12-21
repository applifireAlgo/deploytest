Ext.define('Testp.view.art.masterform.QueryPanel', {
	extend :'Ext.form.Panel',
	xtype: 'queryPanel',
	itemId: 'queryPanel',
	requires: ['Testp.view.art.masterform.QueryPanelController','Testp.view.art.masterform.QueryPanelViewModel'],
	controller: 'queryPanelController',
	viewModel:'queryPanelViewModel',
	serviceURL:null,
	buttons : [{
		text : 'Filter',
		listeners:{
			click:'submitQuery'
		}	
		
	}]	
});