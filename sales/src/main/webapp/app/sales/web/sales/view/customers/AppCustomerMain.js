Ext.define('Sales.sales.web.sales.view.customers.AppCustomerMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "AppCustomerMainController",
     "restURL": "/AppCustomer",
     "defaults": {
          "split": true
     },
     "requires": ["Sales.sales.shared.sales.model.customers.AppCustomerModel", "Sales.sales.web.sales.controller.customers.AppCustomerMainController", "Sales.sales.shared.sales.model.contacts.CoreContactsModel", "Sales.sales.shared.sales.model.customers.AppCustomerTypeModel", "Sales.sales.shared.sales.model.customers.AppCustomerCategoryModel", "Sales.sales.shared.sales.viewmodel.customers.AppCustomerViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "AppCustomer",
               "name": "AppCustomerTreeContainer",
               "itemId": "AppCustomerTreeContainer",
               "restURL": "/AppCustomer",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "AppCustomerTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "customerName",
                         "itemId": "customerName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "6AF5443B-D6FE-4EA1-9021-D86DEC816B9D",
                         "minLength": "0",
                         "maxLength": "65535"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "AppCustomerViewModel",
                    "xtype": "form",
                    "displayName": "AppCustomer",
                    "title": "AppCustomer",
                    "name": "AppCustomer",
                    "itemId": "AppCustomer",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "appCustomerId",
                         "itemId": "appCustomerId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "AppCustomer Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "AppCustomer Id<font color='red'> *<\/font>",
                         "fieldId": "29CF4CFF-5876-4CBB-AD42-2CA9518AE2D7",
                         "hidden": true,
                         "value": "",
                         "bindable": "appCustomerId",
                         "bind": "{appCustomerId}"
                    }, {
                         "name": "customerName",
                         "itemId": "customerName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "6AF5443B-D6FE-4EA1-9021-D86DEC816B9D",
                         "minLength": "0",
                         "maxLength": "65535",
                         "bindable": "customerName",
                         "bind": "{customerName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "contactId",
                         "itemId": "contactId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Contact",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Contact<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "A035C191-5316-4B9D-8CAE-BDD90D4BC738",
                         "restURL": "CoreContacts",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Sales.sales.shared.sales.model.contacts.CoreContactsModel"
                         },
                         "bindable": "contactId",
                         "bind": "{contactId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "appCustomerType",
                         "itemId": "appCustomerType",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Customer Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Type<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D15E7D61-3A4F-470D-B22A-006BA5FB5963",
                         "restURL": "AppCustomerType",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Sales.sales.shared.sales.model.customers.AppCustomerTypeModel"
                         },
                         "bindable": "appCustomerType",
                         "bind": "{appCustomerType}",
                         "columnWidth": 0.5
                    }, {
                         "name": "appCustomerCategory",
                         "itemId": "appCustomerCategory",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Customer Category",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Customer Category<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "ED78C71E-78ED-4124-BC68-D4A9D1DA7AB1",
                         "restURL": "AppCustomerCategory",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Sales.sales.shared.sales.model.customers.AppCustomerCategoryModel"
                         },
                         "bindable": "appCustomerCategory",
                         "bind": "{appCustomerCategory}",
                         "columnWidth": 0.5
                    }, {
                         "name": "deploymentModel",
                         "itemId": "deploymentModel",
                         "xtype": "checkbox",
                         "customWidgetType": "vdCheckbox",
                         "displayName": "Deployment Model",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "inputValue": true,
                         "fieldLabel": "Deployment Model<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "E9D5A4F2-1E59-487B-97E7-5C6512D7ECF5",
                         "bindable": "deploymentModel",
                         "bind": "{deploymentModel}",
                         "columnWidth": 0.5
                    }, {
                         "name": "customerStatus",
                         "itemId": "customerStatus",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Customer Status",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "fieldLabel": "Customer Status<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F9C9D6C6-28DB-49B9-94D8-D48E436429A3",
                         "minValue": "0",
                         "maxValue": "1",
                         "bindable": "customerStatus",
                         "bind": "{customerStatus}",
                         "columnWidth": 0.5
                    }, {
                         "name": "userRequested",
                         "itemId": "userRequested",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "User Requested",
                         "margin": "5 5 5 5",
                         "value": "1",
                         "fieldLabel": "User Requested<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "35888EB4-4012-4704-A239-3871C3183EBB",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "userRequested",
                         "bind": "{userRequested}",
                         "columnWidth": 0.5
                    }, {
                         "name": "evalTimePeriod",
                         "itemId": "evalTimePeriod",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Eval Time Period",
                         "margin": "5 5 5 5",
                         "value": "60",
                         "fieldLabel": "Eval Time Period<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "CC04DF06-A40D-49F8-8242-7DA43670CD35",
                         "minValue": "-2147483648",
                         "maxValue": "2147483647",
                         "bindable": "evalTimePeriod",
                         "bind": "{evalTimePeriod}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "2DBCC785-74C6-48F0-8EFC-25DC6A7A14D3",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 686,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 686,
                              "customId": 805
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 686,
                              "customId": 806,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 686,
                              "customId": 807,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "AppCustomer",
                    "title": "Details Grid",
                    "name": "AppCustomerGrid",
                    "itemId": "AppCustomerGrid",
                    "restURL": "/AppCustomer",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "AppCustomer Id",
                         "dataIndex": "appCustomerId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Name",
                         "dataIndex": "customerName",
                         "flex": 1
                    }, {
                         "header": "Contact",
                         "dataIndex": "contactId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Customer Type",
                         "dataIndex": "appCustomerType",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Customer Category",
                         "dataIndex": "appCustomerCategory",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Deployment Model",
                         "dataIndex": "deploymentModel",
                         "flex": 1
                    }, {
                         "header": "Customer Status",
                         "dataIndex": "customerStatus",
                         "flex": 1
                    }, {
                         "header": "User Requested",
                         "dataIndex": "userRequested",
                         "flex": 1
                    }, {
                         "header": "Eval Time Period",
                         "dataIndex": "evalTimePeriod",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "AppCustomerViewModel",
               "xtype": "form",
               "displayName": "AppCustomer",
               "title": "AppCustomer",
               "name": "AppCustomer",
               "itemId": "AppCustomer",
               "bodyPadding": 10,
               "items": [{
                    "name": "appCustomerId",
                    "itemId": "appCustomerId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "AppCustomer Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "AppCustomer Id<font color='red'> *<\/font>",
                    "fieldId": "29CF4CFF-5876-4CBB-AD42-2CA9518AE2D7",
                    "hidden": true,
                    "value": "",
                    "bindable": "appCustomerId",
                    "bind": "{appCustomerId}"
               }, {
                    "name": "customerName",
                    "itemId": "customerName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "6AF5443B-D6FE-4EA1-9021-D86DEC816B9D",
                    "minLength": "0",
                    "maxLength": "65535",
                    "bindable": "customerName",
                    "bind": "{customerName}",
                    "columnWidth": 0.5
               }, {
                    "name": "contactId",
                    "itemId": "contactId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Contact",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Contact<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "A035C191-5316-4B9D-8CAE-BDD90D4BC738",
                    "restURL": "CoreContacts",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Sales.sales.shared.sales.model.contacts.CoreContactsModel"
                    },
                    "bindable": "contactId",
                    "bind": "{contactId}",
                    "columnWidth": 0.5
               }, {
                    "name": "appCustomerType",
                    "itemId": "appCustomerType",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Customer Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Customer Type<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D15E7D61-3A4F-470D-B22A-006BA5FB5963",
                    "restURL": "AppCustomerType",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Sales.sales.shared.sales.model.customers.AppCustomerTypeModel"
                    },
                    "bindable": "appCustomerType",
                    "bind": "{appCustomerType}",
                    "columnWidth": 0.5
               }, {
                    "name": "appCustomerCategory",
                    "itemId": "appCustomerCategory",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Customer Category",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Customer Category<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "ED78C71E-78ED-4124-BC68-D4A9D1DA7AB1",
                    "restURL": "AppCustomerCategory",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Sales.sales.shared.sales.model.customers.AppCustomerCategoryModel"
                    },
                    "bindable": "appCustomerCategory",
                    "bind": "{appCustomerCategory}",
                    "columnWidth": 0.5
               }, {
                    "name": "deploymentModel",
                    "itemId": "deploymentModel",
                    "xtype": "checkbox",
                    "customWidgetType": "vdCheckbox",
                    "displayName": "Deployment Model",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "inputValue": true,
                    "fieldLabel": "Deployment Model<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "E9D5A4F2-1E59-487B-97E7-5C6512D7ECF5",
                    "bindable": "deploymentModel",
                    "bind": "{deploymentModel}",
                    "columnWidth": 0.5
               }, {
                    "name": "customerStatus",
                    "itemId": "customerStatus",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Customer Status",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "fieldLabel": "Customer Status<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F9C9D6C6-28DB-49B9-94D8-D48E436429A3",
                    "minValue": "0",
                    "maxValue": "1",
                    "bindable": "customerStatus",
                    "bind": "{customerStatus}",
                    "columnWidth": 0.5
               }, {
                    "name": "userRequested",
                    "itemId": "userRequested",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "User Requested",
                    "margin": "5 5 5 5",
                    "value": "1",
                    "fieldLabel": "User Requested<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "35888EB4-4012-4704-A239-3871C3183EBB",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "userRequested",
                    "bind": "{userRequested}",
                    "columnWidth": 0.5
               }, {
                    "name": "evalTimePeriod",
                    "itemId": "evalTimePeriod",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Eval Time Period",
                    "margin": "5 5 5 5",
                    "value": "60",
                    "fieldLabel": "Eval Time Period<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "CC04DF06-A40D-49F8-8242-7DA43670CD35",
                    "minValue": "-2147483648",
                    "maxValue": "2147483647",
                    "bindable": "evalTimePeriod",
                    "bind": "{evalTimePeriod}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "2DBCC785-74C6-48F0-8EFC-25DC6A7A14D3",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 686,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 686,
                         "customId": 805
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 686,
                         "customId": 806,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 686,
                         "customId": 807,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});