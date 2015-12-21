Ext.define('Testp.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Testp.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Testp.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
