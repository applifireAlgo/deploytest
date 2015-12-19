Ext.define('Testproj.view.art.masterform.MasterFormPanel',
{
	extend :'Ext.form.Panel',
	xtype: 'masterFormPanel',
	itemId : 'masterFormPanel',
	
	requires: ['Testproj.view.art.masterform.MasterFormModel','Testproj.view.art.masterform.MasterFormViewModel','Testproj.view.art.masterform.MasterFormPanelController'],

	//viewModel: 'masterFormViewModel',
	
	controller: 'masterFormPanelController'

});
	