Ext.define('Testp.testp.web.com.view.location.LanguageMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "LanguageMainController",
     "restURL": "/Language",
     "defaults": {
          "split": true
     },
     "requires": ["Testp.testp.shared.com.model.location.LanguageModel", "Testp.testp.web.com.controller.location.LanguageMainController", "Testp.testp.shared.com.viewmodel.location.LanguageViewModel"],
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
               "displayName": "Language",
               "name": "LanguageTreeContainer",
               "itemId": "LanguageTreeContainer",
               "restURL": "/Language",
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
                    "itemId": "LanguageTree",
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
                    "items": []
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
                    "viewModel": "LanguageViewModel",
                    "xtype": "form",
                    "displayName": "Language",
                    "title": "Language",
                    "name": "Language",
                    "itemId": "Language",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "languageId",
                         "itemId": "languageId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Language Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Language Id<font color='red'> *<\/font>",
                         "fieldId": "FC6CC6AC-4840-4F4A-B4F8-DB6978090A6A",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "languageId",
                         "bind": "{languageId}"
                    }, {
                         "name": "language",
                         "itemId": "language",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Language",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Language<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "B4696A14-2839-4191-AB72-6390BF0E5B44",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "language",
                         "bind": "{language}",
                         "columnWidth": 0.5
                    }, {
                         "name": "languageType",
                         "itemId": "languageType",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Language Type",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Language Type",
                         "fieldId": "F73D4389-662A-47A1-8F9E-6EF438CFABAB",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "languageType",
                         "bind": "{languageType}",
                         "columnWidth": 0.5
                    }, {
                         "name": "languageDescription",
                         "itemId": "languageDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Description",
                         "fieldId": "6802A673-DE1C-44BE-AC74-178833B7B1B0",
                         "bindable": "languageDescription",
                         "bind": "{languageDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "languageIcon",
                         "itemId": "languageIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon",
                         "fieldId": "4BBF0652-31F4-461F-B648-B296C71B1C86",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "languageIcon",
                         "bind": "{languageIcon}",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha2",
                         "itemId": "alpha2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Alpha 2",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Alpha 2",
                         "fieldId": "31490996-0CD4-46BB-897B-A29F3361B2AD",
                         "minLength": "0",
                         "maxLength": "2",
                         "bindable": "alpha2",
                         "bind": "{alpha2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha3",
                         "itemId": "alpha3",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Alpha 3",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Alpha 3",
                         "fieldId": "ECAA2B23-CB7F-4178-BB1A-8CFAD6458547",
                         "minLength": "0",
                         "maxLength": "3",
                         "bindable": "alpha3",
                         "bind": "{alpha3}",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha4",
                         "itemId": "alpha4",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Alpha 4",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Alpha 4",
                         "fieldId": "28BA86CC-93CA-4A18-B71C-54DB14A00C11",
                         "minLength": "0",
                         "maxLength": "4",
                         "bindable": "alpha4",
                         "bind": "{alpha4}",
                         "columnWidth": 0.5
                    }, {
                         "name": "alpha4parentid",
                         "itemId": "alpha4parentid",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "Aplha4 Parent Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Aplha4 Parent Id",
                         "fieldId": "DDA73CD6-E48B-4738-A346-1369DCC163F5",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "alpha4parentid",
                         "bind": "{alpha4parentid}",
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
                         "fieldId": "3D6B9C10-F47E-43C8-819C-A35FCDD2F26B",
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
                         "customId": 240,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 240,
                              "customId": 96
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 240,
                              "customId": 97,
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
                              "parentId": 240,
                              "customId": 98,
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
                    "displayName": "Language",
                    "title": "Details Grid",
                    "name": "LanguageGrid",
                    "itemId": "LanguageGrid",
                    "restURL": "/Language",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Language Id",
                         "dataIndex": "languageId",
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
                         "header": "Language",
                         "dataIndex": "language",
                         "flex": 1
                    }, {
                         "header": "Language Type",
                         "dataIndex": "languageType",
                         "flex": 1
                    }, {
                         "header": "Description",
                         "dataIndex": "languageDescription",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "languageIcon",
                         "flex": 1
                    }, {
                         "header": "Alpha 2",
                         "dataIndex": "alpha2",
                         "flex": 1
                    }, {
                         "header": "Alpha 3",
                         "dataIndex": "alpha3",
                         "flex": 1
                    }, {
                         "header": "Alpha 4",
                         "dataIndex": "alpha4",
                         "flex": 1
                    }, {
                         "header": "Aplha4 Parent Id",
                         "dataIndex": "alpha4parentid",
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
               "viewModel": "LanguageViewModel",
               "xtype": "form",
               "displayName": "Language",
               "title": "Language",
               "name": "Language",
               "itemId": "Language",
               "bodyPadding": 10,
               "items": [{
                    "name": "languageId",
                    "itemId": "languageId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Language Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Language Id<font color='red'> *<\/font>",
                    "fieldId": "FC6CC6AC-4840-4F4A-B4F8-DB6978090A6A",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "languageId",
                    "bind": "{languageId}"
               }, {
                    "name": "language",
                    "itemId": "language",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Language",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Language<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "B4696A14-2839-4191-AB72-6390BF0E5B44",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "language",
                    "bind": "{language}",
                    "columnWidth": 0.5
               }, {
                    "name": "languageType",
                    "itemId": "languageType",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Language Type",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Language Type",
                    "fieldId": "F73D4389-662A-47A1-8F9E-6EF438CFABAB",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "languageType",
                    "bind": "{languageType}",
                    "columnWidth": 0.5
               }, {
                    "name": "languageDescription",
                    "itemId": "languageDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Description",
                    "fieldId": "6802A673-DE1C-44BE-AC74-178833B7B1B0",
                    "bindable": "languageDescription",
                    "bind": "{languageDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "languageIcon",
                    "itemId": "languageIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Icon",
                    "fieldId": "4BBF0652-31F4-461F-B648-B296C71B1C86",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "languageIcon",
                    "bind": "{languageIcon}",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha2",
                    "itemId": "alpha2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Alpha 2",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Alpha 2",
                    "fieldId": "31490996-0CD4-46BB-897B-A29F3361B2AD",
                    "minLength": "0",
                    "maxLength": "2",
                    "bindable": "alpha2",
                    "bind": "{alpha2}",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha3",
                    "itemId": "alpha3",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Alpha 3",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Alpha 3",
                    "fieldId": "ECAA2B23-CB7F-4178-BB1A-8CFAD6458547",
                    "minLength": "0",
                    "maxLength": "3",
                    "bindable": "alpha3",
                    "bind": "{alpha3}",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha4",
                    "itemId": "alpha4",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Alpha 4",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Alpha 4",
                    "fieldId": "28BA86CC-93CA-4A18-B71C-54DB14A00C11",
                    "minLength": "0",
                    "maxLength": "4",
                    "bindable": "alpha4",
                    "bind": "{alpha4}",
                    "columnWidth": 0.5
               }, {
                    "name": "alpha4parentid",
                    "itemId": "alpha4parentid",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "Aplha4 Parent Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Aplha4 Parent Id",
                    "fieldId": "DDA73CD6-E48B-4738-A346-1369DCC163F5",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "alpha4parentid",
                    "bind": "{alpha4parentid}",
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
                    "fieldId": "3D6B9C10-F47E-43C8-819C-A35FCDD2F26B",
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
                    "customId": 240,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 240,
                         "customId": 96
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 240,
                         "customId": 97,
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
                         "parentId": 240,
                         "customId": 98,
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