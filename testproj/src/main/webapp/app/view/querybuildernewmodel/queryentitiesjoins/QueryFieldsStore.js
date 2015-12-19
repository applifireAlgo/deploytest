Ext.define('Testproj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Testproj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Testproj.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
