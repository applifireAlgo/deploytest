Ext.define('Testproj.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Testproj.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Testproj.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
