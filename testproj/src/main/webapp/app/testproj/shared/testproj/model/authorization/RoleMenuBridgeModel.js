Ext.define('Testproj.testproj.shared.testproj.model.authorization.RoleMenuBridgeModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "roleMenuMapId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "menuid",
          "reference": "AppMenus",
          "defaultValue": ""
     }, {
          "name": "isRead",
          "type": "boolean",
          "defaultValue": ""
     }, {
          "name": "isWrite",
          "type": "boolean",
          "defaultValue": ""
     }, {
          "name": "isExecute",
          "type": "boolean",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "Roles",
          "reference": "RolesModel"
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});