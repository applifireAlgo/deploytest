Ext.define('Testp.view.art.masterform.MasterGridPanel',{
	extend :'Ext.grid.Panel',
	
	xtype: 'masterGridPanel',
		
	itemId: 'masterGridPanel',
	
	autoScroll: true,
	
	requires: ['Testp.view.art.masterform.MasterGridPanelController'],
	
	controller: 'masterGridPanelController',
		
	listeners : {
		select : function ( current, record, index, eOpts ){
			this.getController().showMasterFormData(record);
		}
	}
});
