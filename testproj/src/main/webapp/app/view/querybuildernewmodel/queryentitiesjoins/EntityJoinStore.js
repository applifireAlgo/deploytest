Ext.define('Testproj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Testproj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Testproj.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
