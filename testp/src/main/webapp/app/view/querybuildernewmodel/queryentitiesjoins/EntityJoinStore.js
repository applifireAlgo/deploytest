Ext.define('Testp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Testp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Testp.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
