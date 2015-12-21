Ext.define('Testp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Testp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Testp.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
