Ext.define('Sales.sales.web.sales.view.contacts.CoreContactsMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CoreContactsMainController",
     "restURL": "/CoreContacts",
     "defaults": {
          "split": true
     },
     "requires": ["Sales.sales.shared.sales.model.contacts.CoreContactsModel", "Sales.sales.web.sales.controller.contacts.CoreContactsMainController", "Sales.sales.shared.sales.model.contacts.TitleModel", "Sales.sales.shared.sales.model.location.LanguageModel", "Sales.sales.shared.sales.model.contacts.GenderModel", "Sales.view.fw.component.Grids", "Sales.sales.shared.sales.model.contacts.CommunicationGroupModel", "Sales.sales.shared.sales.model.contacts.CommunicationTypeModel", "Sales.view.fw.component.Grids", "Sales.sales.shared.sales.model.location.AddressTypeModel", "Sales.sales.shared.sales.model.location.CountryModel", "Sales.sales.shared.sales.model.location.StateModel", "Sales.sales.shared.sales.model.location.CityModel", "Sales.sales.shared.sales.viewmodel.contacts.CoreContactsViewModel"],
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
               "displayName": "Core Contacts",
               "name": "CoreContactsTreeContainer",
               "itemId": "CoreContactsTreeContainer",
               "margin": "5 0 5 5",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "useArrows": true,
                    "title": "Browse",
                    "rootVisible": false,
                    "itemId": "CoreContactsTree",
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
                    "layout": "fit",
                    "autoScroll": false,
                    "itemId": "queryPanel",
                    "buttons": [{
                         "text": "Filter",
                         "handler": "onFilterClick"
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
                    "xtype": "form",
                    "displayName": "Core Contacts",
                    "name": "CoreContacts",
                    "itemId": "CoreContactsForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form0",
                         "customWidgetType": "vdCard",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "contactId",
                                   "itemId": "contactId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Contact Id",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                                   "fieldId": "1F8F5A9C-94A4-4B33-A7AF-1177C1CAFCC9",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "hidden": true,
                                   "value": "",
                                   "bindable": "contactId",
                                   "bind": "{contactId}"
                              }, {
                                   "name": "titleId",
                                   "itemId": "titleId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Title",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Title<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "BFA99F1E-AA07-4232-9A03-4C4BACBF70E3",
                                   "errorMessage": "Please enter title",
                                   "restURL": "Title",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Sales.sales.shared.sales.model.contacts.TitleModel"
                                   },
                                   "bindable": "titleId",
                                   "columnWidth": 0.5,
                                   "bind": "{titleId}"
                              }, {
                                   "name": "firstName",
                                   "itemId": "firstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "First Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "C6231F6E-9A09-460A-98FC-A2060FA8CB6B",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter First Name",
                                   "bindable": "firstName",
                                   "columnWidth": 0.5,
                                   "bind": "{firstName}"
                              }, {
                                   "name": "middleName",
                                   "itemId": "middleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Middle Name",
                                   "fieldId": "7A99FCA8-214E-4049-88B9-E66D59A645FC",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "middleName",
                                   "columnWidth": 0.5,
                                   "bind": "{middleName}"
                              }, {
                                   "name": "lastName",
                                   "itemId": "lastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Last Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Last Name<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "2F415A93-A492-4DB2-9524-8B21B6D52E56",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Last Name",
                                   "bindable": "lastName",
                                   "columnWidth": 0.5,
                                   "bind": "{lastName}"
                              }, {
                                   "name": "nativeLanguageCode",
                                   "itemId": "nativeLanguageCode",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Language Code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native Language Code",
                                   "fieldId": "C65AE0BF-F4E3-48C4-BD76-5E2DA3D9142A",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Language",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Sales.sales.shared.sales.model.location.LanguageModel"
                                   },
                                   "bindable": "nativeLanguageCode",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeLanguageCode}"
                              }, {
                                   "name": "nativeTitle",
                                   "itemId": "nativeTitle",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Native Title",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native Title",
                                   "fieldId": "0B31A2FE-ADA3-414C-B9B7-1AF32ECBF801",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "bindable": "nativeTitle",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeTitle}"
                              }, {
                                   "name": "nativeFirstName",
                                   "itemId": "nativeFirstName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native First Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native First Name",
                                   "fieldId": "769967BF-0FA6-4B48-9CDB-CB0B20D1BE9E",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeFirstName",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeFirstName}"
                              }, {
                                   "name": "nativeMiddleName",
                                   "itemId": "nativeMiddleName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native Middle Name",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native Middle Name",
                                   "fieldId": "90041927-F009-4020-964D-E413D9BC08CE",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeMiddleName",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeMiddleName}"
                              }, {
                                   "name": "nativeLastName",
                                   "itemId": "nativeLastName",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Native LastName",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Native LastName",
                                   "fieldId": "566E96A8-CDA6-4AFC-A877-9E898C079557",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "nativeLastName",
                                   "columnWidth": 0.5,
                                   "bind": "{nativeLastName}"
                              }, {
                                   "name": "genderId",
                                   "itemId": "genderId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Gender",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Gender<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "8B8941E5-CCE8-4F6D-BCD8-CB6CCD3A3A01",
                                   "errorMessage": "Please enter gender",
                                   "restURL": "Gender",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Sales.sales.shared.sales.model.contacts.GenderModel"
                                   },
                                   "bindable": "genderId",
                                   "columnWidth": 0.5,
                                   "bind": "{genderId}"
                              }, {
                                   "name": "dateofbirth",
                                   "itemId": "dateofbirth",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "DOB",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "DOB",
                                   "fieldId": "94B332C5-067D-4BD4-960C-CA914C370692",
                                   "errorMessage": "Please enter Date of birth",
                                   "bindable": "dateofbirth",
                                   "columnWidth": 0.5,
                                   "bind": "{dateofbirth}",
                                   "format": "d-m-Y H:m:s",
                                   "submitFormat": "d-m-Y H:m:s"
                              }, {
                                   "name": "age",
                                   "itemId": "age",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "Age",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Age",
                                   "fieldId": "70B4C54C-D534-4C97-8607-BC16954FC9E8",
                                   "minValue": "0",
                                   "maxValue": "125",
                                   "bindable": "age",
                                   "columnWidth": 0.5,
                                   "bind": "{age}"
                              }, {
                                   "name": "approximateDOB",
                                   "itemId": "approximateDOB",
                                   "xtype": "datefield",
                                   "customWidgetType": "vdDatefield",
                                   "displayName": "Approx DOB",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Approx DOB",
                                   "fieldId": "5453548C-6FF7-4076-9265-3DADB017BA90",
                                   "bindable": "approximateDOB",
                                   "columnWidth": 0.5,
                                   "bind": "{approximateDOB}",
                                   "format": "d-m-Y H:m:s",
                                   "submitFormat": "d-m-Y H:m:s"
                              }, {
                                   "name": "emailId",
                                   "itemId": "emailId",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Email ID",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Email ID<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E169760A-31F2-4413-BDF4-6DF3041704AC",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "errorMessage": "Please enter Email ID",
                                   "bindable": "emailId",
                                   "columnWidth": 0.5,
                                   "bind": "{emailId}"
                              }, {
                                   "name": "phoneNumber",
                                   "itemId": "phoneNumber",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Phone Number",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "4215AB67-A961-4E4E-A853-0B87C42F7494",
                                   "minLength": "0",
                                   "maxLength": "20",
                                   "errorMessage": "Please enter Phone Number",
                                   "bindable": "phoneNumber",
                                   "columnWidth": 0.5,
                                   "bind": "{phoneNumber}"
                              }, {
                                   "name": "versionId",
                                   "itemId": "versionId",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "versionId",
                                   "margin": "5 5 5 5",
                                   "value": "-1",
                                   "fieldLabel": "versionId",
                                   "fieldId": "292BA3FB-0A38-471A-96F1-DBE111E4C882",
                                   "bindable": "versionId",
                                   "bind": "{versionId}",
                                   "hidden": true
                              }]
                         }]
                    }, {
                         "xtype": "form",
                         "displayName": "Timezone",
                         "title": "Timezone",
                         "name": "Timezone",
                         "itemId": "TimezoneForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "utcdifference",
                                        "itemId": "utcdifference",
                                        "xtype": "numberfield",
                                        "customWidgetType": "vdNumberfield",
                                        "displayName": "UTC Difference",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "UTC Difference<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "2FF7AE9A-91BA-4A4E-9059-12156F35C373",
                                        "minValue": "0",
                                        "maxValue": "11",
                                        "bindable": "timezone.utcdifference",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.utcdifference}"
                                   }, {
                                        "name": "gmtLabel",
                                        "itemId": "gmtLabel",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "GMT",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "GMT",
                                        "fieldId": "3DDE84F8-FB2C-4F1D-9231-938D3DBCF518",
                                        "minLength": "0",
                                        "maxLength": "256",
                                        "bindable": "timezone.gmtLabel",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.gmtLabel}"
                                   }, {
                                        "name": "timeZoneLabel",
                                        "itemId": "timeZoneLabel",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Time Zone",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Time Zone",
                                        "fieldId": "13FA275D-8093-450E-BFF0-4304F15C56F9",
                                        "minLength": "0",
                                        "maxLength": "256",
                                        "bindable": "timezone.timeZoneLabel",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.timeZoneLabel}"
                                   }, {
                                        "name": "country",
                                        "itemId": "country",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Country",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Country",
                                        "fieldId": "6E75600C-115A-404C-A965-2FACA1CE602E",
                                        "minLength": "0",
                                        "maxLength": "256",
                                        "bindable": "timezone.country",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.country}"
                                   }, {
                                        "name": "cities",
                                        "itemId": "cities",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "City",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "City",
                                        "fieldId": "B2657BDE-F9B8-42A5-990F-CD7AD551F529",
                                        "minLength": "0",
                                        "maxLength": "256",
                                        "bindable": "timezone.cities",
                                        "columnWidth": 0.5,
                                        "bind": "{timezone.cities}"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }, {
                         "xtype": "form",
                         "displayName": "Communication Data",
                         "title": "Communication Data",
                         "name": "CommunicationData",
                         "itemId": "CommunicationDataForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "commGroupId",
                                        "itemId": "commGroupId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Group",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "E435BFBC-9F6D-45FC-8F08-9B592CD5BD15",
                                        "restURL": "CommunicationGroup",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Sales.sales.shared.sales.model.contacts.CommunicationGroupModel"
                                        },
                                        "bindable": "communicationData.commGroupId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onCommGroupIdChange"
                                        }
                                   }, {
                                        "name": "commType",
                                        "itemId": "commType",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Communication Type",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "02EFFA16-9914-41D3-827A-9FE80F0160CD",
                                        "restURL": "CommunicationType",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Sales.sales.shared.sales.model.contacts.CommunicationTypeModel"
                                        },
                                        "bindable": "communicationData.commType",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "commData",
                                        "itemId": "commData",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Communication Data",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "5C9777F5-7A09-415F-BA56-E607A950AD03",
                                        "minLength": "0",
                                        "errorMessage": "please enter communication details",
                                        "bindable": "communicationData.commData",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 242,
                              "text": "Add CommunicationData",
                              "handler": "addCommunicationData"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "CommunicationData",
                              "columnWidth": 1,
                              "itemId": "CommunicationDataGrid",
                              "fieldLabel": "List",
                              "bindLevel": "communicationData",
                              "bindable": "communicationData",
                              "listeners": {
                                   "select": "onCommunicationDataGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "commType",
                                   "text": "commType",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commDataId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Communication Group",
                                   "text": "Communication Group",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commGroupId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Type",
                                   "text": "Communication Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commType",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Communication Data",
                                   "text": "Communication Data",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "commData",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }, {
                         "xtype": "form",
                         "displayName": "Address",
                         "title": "Address",
                         "name": "Address",
                         "itemId": "AddressForm",
                         "bodyPadding": 10,
                         "items": [{
                              "xtype": "form",
                              "itemId": "form1",
                              "customWidgetType": "vdAnchorLayout",
                              "header": {
                                   "hidden": true
                              },
                              "items": [{
                                   "layout": "column",
                                   "customWidgetType": "vdColumnLayout",
                                   "header": {
                                        "hidden": true
                                   },
                                   "xtype": "panel",
                                   "items": [{
                                        "name": "addressTypeId",
                                        "itemId": "addressTypeId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Address Type",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "43C88DCE-CF7D-41BD-A002-855CF5BF2EE3",
                                        "errorMessage": "Please enter valid Address type",
                                        "restURL": "AddressType",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Sales.sales.shared.sales.model.location.AddressTypeModel"
                                        },
                                        "bindable": "address.addressTypeId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "addressLabel",
                                        "itemId": "addressLabel",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Address Label",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address Label",
                                        "fieldId": "12ECD96F-F2E4-41DA-86B5-4594394D3784",
                                        "minLength": "0",
                                        "maxLength": "11",
                                        "bindable": "address.addressLabel",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address1",
                                        "itemId": "address1",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address1",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address1",
                                        "fieldId": "915C39AE-9A0A-4134-9DD0-3D7679226062",
                                        "bindable": "address.address1",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address2",
                                        "itemId": "address2",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address2",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address2",
                                        "fieldId": "E91D288D-3A66-48CE-9C01-083338C05312",
                                        "bindable": "address.address2",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "address3",
                                        "itemId": "address3",
                                        "xtype": "textareafield",
                                        "customWidgetType": "vdTextareafield",
                                        "displayName": "Address3",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Address3",
                                        "fieldId": "C1D9BE13-68A2-4C67-A324-5AE7460A0234",
                                        "bindable": "address.address3",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "countryId",
                                        "itemId": "countryId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "Country",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Country<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "CD5A2B60-D9CC-4F4C-9C6A-A5060F003471",
                                        "errorMessage": "Please enter Country",
                                        "restURL": "Country",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Sales.sales.shared.sales.model.location.CountryModel"
                                        },
                                        "bindable": "address.countryId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onCountryIdChange"
                                        }
                                   }, {
                                        "name": "stateId",
                                        "itemId": "stateId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "State",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "State<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "DF7365B4-B18F-45A3-8ECB-A605FD999D92",
                                        "errorMessage": "Please enter State",
                                        "restURL": "State",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Sales.sales.shared.sales.model.location.StateModel"
                                        },
                                        "bindable": "address.stateId",
                                        "columnWidth": 0.5,
                                        "listeners": {
                                             "change": "onStateIdChange"
                                        }
                                   }, {
                                        "name": "cityId",
                                        "itemId": "cityId",
                                        "xtype": "combo",
                                        "customWidgetType": "vdCombo",
                                        "displayName": "City",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "City<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "D1935998-2ECB-466C-A1AF-3E36566E4775",
                                        "errorMessage": "Please enter City",
                                        "restURL": "City",
                                        "displayField": "primaryDisplay",
                                        "valueField": "primaryKey",
                                        "typeAhead": true,
                                        "queryMode": "local",
                                        "minChars": 2,
                                        "store": {
                                             "data": [],
                                             "model": "Sales.sales.shared.sales.model.location.CityModel"
                                        },
                                        "bindable": "address.cityId",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "zipcode",
                                        "itemId": "zipcode",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Postal Code",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                        "allowBlank": false,
                                        "fieldId": "BD9E93B3-0E21-46D1-854D-7C147B13AF1E",
                                        "minLength": "0",
                                        "maxLength": "6",
                                        "errorMessage": "Please enter postal code",
                                        "bindable": "address.zipcode",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "latitude",
                                        "itemId": "latitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Latitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Latitude",
                                        "fieldId": "69720DB9-B938-46DB-87A8-4EEBED493B79",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.latitude",
                                        "columnWidth": 0.5
                                   }, {
                                        "name": "longitude",
                                        "itemId": "longitude",
                                        "xtype": "textfield",
                                        "customWidgetType": "vdTextfield",
                                        "displayName": "Longitude",
                                        "margin": "5 5 5 5",
                                        "fieldLabel": "Longitude",
                                        "fieldId": "DAAC6B40-8CC9-4C61-8253-6D7442C6E98A",
                                        "minLength": "0",
                                        "maxLength": "64",
                                        "bindable": "address.longitude",
                                        "columnWidth": 0.5
                                   }]
                              }]
                         }, {
                              "columnWidth": 1,
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "maxWidth": 132,
                              "text": "Add Address",
                              "handler": "addAddress"
                         }, {
                              "xtype": "grids",
                              "customWidgetType": "vdGrid",
                              "title": "Address",
                              "columnWidth": 1,
                              "itemId": "AddressGrid",
                              "fieldLabel": "List",
                              "bindLevel": "address",
                              "bindable": "address",
                              "listeners": {
                                   "select": "onAddressGridItemClick"
                              },
                              "store": {
                                   "fields": [],
                                   "data": []
                              },
                              "columns": [{
                                   "header": "Address Id",
                                   "text": "Address Id",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "Address Type",
                                   "text": "Address Type",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressTypeId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Address Label",
                                   "text": "Address Label",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "addressLabel",
                                   "flex": 1
                              }, {
                                   "header": "Address1",
                                   "text": "Address1",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address1",
                                   "flex": 1
                              }, {
                                   "header": "Address2",
                                   "text": "Address2",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address2",
                                   "flex": 1
                              }, {
                                   "header": "Address3",
                                   "text": "Address3",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "address3",
                                   "flex": 1
                              }, {
                                   "header": "Country",
                                   "text": "Country",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "countryId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "State",
                                   "text": "State",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "stateId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "City",
                                   "text": "City",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "cityId",
                                   "renderer": "renderFormValue",
                                   "flex": 1
                              }, {
                                   "header": "Postal Code",
                                   "text": "Postal Code",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "zipcode",
                                   "flex": 1
                              }, {
                                   "header": "Latitude",
                                   "text": "Latitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "latitude",
                                   "flex": 1
                              }, {
                                   "header": "Longitude",
                                   "text": "Longitude",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "longitude",
                                   "flex": 1
                              }, {
                                   "header": "createdBy",
                                   "text": "createdBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "createdDate",
                                   "text": "createdDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "createdDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedBy",
                                   "text": "updatedBy",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedBy",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "updatedDate",
                                   "text": "updatedDate",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "updatedDate",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "versionId",
                                   "text": "versionId",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "versionId",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "activeStatus",
                                   "text": "activeStatus",
                                   "customWidgetType": "vdGridColumn",
                                   "dataIndex": "activeStatus",
                                   "hidden": true,
                                   "flex": 1
                              }, {
                                   "header": "txnAccessCode",
                                   "text": "txnAccessCode",
                                   "customWidgetType": "vdGridColumn",
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
                                        "handler": "onDeleteActionColumnClick"
                                   }]
                              }]
                         }],
                         "customWidgetType": "vdCard"
                    }],
                    "tools": [{
                         "type": "help",
                         "tooltip": "Get Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "layout": "card",
                    "defaults": {
                         "autoScroll": true
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "margin": 0,
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {
                              "margin": "0 5 0 5"
                         }
                    }, {
                         "xtype": "toolbar",
                         "customWidgetType": "vdTBar",
                         "defaults": {
                              "margin": "0 5 0 5"
                         },
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardPrev",
                              "text": "&laquo; Previous",
                              "handler": "showPreviousCard",
                              "disabled": true,
                              "margin": "0 5 0 5"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "itemId": "cardNext",
                              "text": "Next &raquo;",
                              "handler": "showNextCard",
                              "margin": "0 5 0 5"
                         }]
                    }],
                    "viewModel": "CoreContactsViewModel",
                    "listeners": {},
                    "extend": "Ext.form.Panel",
                    "region": "center",
                    "customWidgetType": "vdCardLayout"
               }, {
                    "xtype": "grid",
                    "customWidgetType": "vdGrid",
                    "displayName": "Core Contacts",
                    "title": "Details Grid",
                    "name": "CoreContactsGrid",
                    "itemId": "CoreContactsGrid",
                    "store": [],
                    "bodyPadding": 10,
                    "requires": [],
                    "columns": [{
                         "header": "Contact Id",
                         "dataIndex": "contactId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Title",
                         "dataIndex": "titleId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "First Name",
                         "dataIndex": "firstName",
                         "flex": 1
                    }, {
                         "header": "Middle Name",
                         "dataIndex": "middleName",
                         "flex": 1
                    }, {
                         "header": "Last Name",
                         "dataIndex": "lastName",
                         "flex": 1
                    }, {
                         "header": "Native Language Code",
                         "dataIndex": "nativeLanguageCode",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "Native Title",
                         "dataIndex": "nativeTitle",
                         "flex": 1
                    }, {
                         "header": "Native First Name",
                         "dataIndex": "nativeFirstName",
                         "flex": 1
                    }, {
                         "header": "Native Middle Name",
                         "dataIndex": "nativeMiddleName",
                         "flex": 1
                    }, {
                         "header": "Native LastName",
                         "dataIndex": "nativeLastName",
                         "flex": 1
                    }, {
                         "header": "Gender",
                         "dataIndex": "genderId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "DOB",
                         "dataIndex": "dateofbirth",
                         "flex": 1
                    }, {
                         "header": "Age",
                         "dataIndex": "age",
                         "flex": 1
                    }, {
                         "header": "Approx DOB",
                         "dataIndex": "approximateDOB",
                         "flex": 1
                    }, {
                         "header": "Email ID",
                         "dataIndex": "emailId",
                         "flex": 1
                    }, {
                         "header": "Phone Number",
                         "dataIndex": "phoneNumber",
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
               "xtype": "form",
               "displayName": "Core Contacts",
               "name": "CoreContacts",
               "itemId": "CoreContactsForm",
               "bodyPadding": 10,
               "items": [{
                    "xtype": "form",
                    "itemId": "form0",
                    "customWidgetType": "vdCard",
                    "header": {
                         "hidden": true
                    },
                    "items": [{
                         "layout": "column",
                         "customWidgetType": "vdColumnLayout",
                         "header": {
                              "hidden": true
                         },
                         "xtype": "panel",
                         "items": [{
                              "name": "contactId",
                              "itemId": "contactId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Contact Id",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Contact Id<font color='red'> *<\/font>",
                              "fieldId": "1F8F5A9C-94A4-4B33-A7AF-1177C1CAFCC9",
                              "minLength": "0",
                              "maxLength": "64",
                              "hidden": true,
                              "value": "",
                              "bindable": "contactId",
                              "bind": "{contactId}"
                         }, {
                              "name": "titleId",
                              "itemId": "titleId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Title",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Title<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "BFA99F1E-AA07-4232-9A03-4C4BACBF70E3",
                              "errorMessage": "Please enter title",
                              "restURL": "Title",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Sales.sales.shared.sales.model.contacts.TitleModel"
                              },
                              "bindable": "titleId",
                              "columnWidth": 0.5,
                              "bind": "{titleId}"
                         }, {
                              "name": "firstName",
                              "itemId": "firstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "First Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "C6231F6E-9A09-460A-98FC-A2060FA8CB6B",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter First Name",
                              "bindable": "firstName",
                              "columnWidth": 0.5,
                              "bind": "{firstName}"
                         }, {
                              "name": "middleName",
                              "itemId": "middleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Middle Name",
                              "fieldId": "7A99FCA8-214E-4049-88B9-E66D59A645FC",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "middleName",
                              "columnWidth": 0.5,
                              "bind": "{middleName}"
                         }, {
                              "name": "lastName",
                              "itemId": "lastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Last Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Last Name<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "2F415A93-A492-4DB2-9524-8B21B6D52E56",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Last Name",
                              "bindable": "lastName",
                              "columnWidth": 0.5,
                              "bind": "{lastName}"
                         }, {
                              "name": "nativeLanguageCode",
                              "itemId": "nativeLanguageCode",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Language Code",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native Language Code",
                              "fieldId": "C65AE0BF-F4E3-48C4-BD76-5E2DA3D9142A",
                              "errorMessage": "Please enter gender",
                              "restURL": "Language",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Sales.sales.shared.sales.model.location.LanguageModel"
                              },
                              "bindable": "nativeLanguageCode",
                              "columnWidth": 0.5,
                              "bind": "{nativeLanguageCode}"
                         }, {
                              "name": "nativeTitle",
                              "itemId": "nativeTitle",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Native Title",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native Title",
                              "fieldId": "0B31A2FE-ADA3-414C-B9B7-1AF32ECBF801",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "bindable": "nativeTitle",
                              "columnWidth": 0.5,
                              "bind": "{nativeTitle}"
                         }, {
                              "name": "nativeFirstName",
                              "itemId": "nativeFirstName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native First Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native First Name",
                              "fieldId": "769967BF-0FA6-4B48-9CDB-CB0B20D1BE9E",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeFirstName",
                              "columnWidth": 0.5,
                              "bind": "{nativeFirstName}"
                         }, {
                              "name": "nativeMiddleName",
                              "itemId": "nativeMiddleName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native Middle Name",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native Middle Name",
                              "fieldId": "90041927-F009-4020-964D-E413D9BC08CE",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeMiddleName",
                              "columnWidth": 0.5,
                              "bind": "{nativeMiddleName}"
                         }, {
                              "name": "nativeLastName",
                              "itemId": "nativeLastName",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Native LastName",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Native LastName",
                              "fieldId": "566E96A8-CDA6-4AFC-A877-9E898C079557",
                              "minLength": "0",
                              "maxLength": "256",
                              "bindable": "nativeLastName",
                              "columnWidth": 0.5,
                              "bind": "{nativeLastName}"
                         }, {
                              "name": "genderId",
                              "itemId": "genderId",
                              "xtype": "combo",
                              "customWidgetType": "vdCombo",
                              "displayName": "Gender",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Gender<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "8B8941E5-CCE8-4F6D-BCD8-CB6CCD3A3A01",
                              "errorMessage": "Please enter gender",
                              "restURL": "Gender",
                              "displayField": "primaryDisplay",
                              "valueField": "primaryKey",
                              "typeAhead": true,
                              "queryMode": "local",
                              "minChars": 2,
                              "store": {
                                   "data": [],
                                   "model": "Sales.sales.shared.sales.model.contacts.GenderModel"
                              },
                              "bindable": "genderId",
                              "columnWidth": 0.5,
                              "bind": "{genderId}"
                         }, {
                              "name": "dateofbirth",
                              "itemId": "dateofbirth",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "DOB",
                              "margin": "5 5 5 5",
                              "fieldLabel": "DOB",
                              "fieldId": "94B332C5-067D-4BD4-960C-CA914C370692",
                              "errorMessage": "Please enter Date of birth",
                              "bindable": "dateofbirth",
                              "columnWidth": 0.5,
                              "bind": "{dateofbirth}",
                              "format": "d-m-Y H:m:s",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "name": "age",
                              "itemId": "age",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "Age",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Age",
                              "fieldId": "70B4C54C-D534-4C97-8607-BC16954FC9E8",
                              "minValue": "0",
                              "maxValue": "125",
                              "bindable": "age",
                              "columnWidth": 0.5,
                              "bind": "{age}"
                         }, {
                              "name": "approximateDOB",
                              "itemId": "approximateDOB",
                              "xtype": "datefield",
                              "customWidgetType": "vdDatefield",
                              "displayName": "Approx DOB",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Approx DOB",
                              "fieldId": "5453548C-6FF7-4076-9265-3DADB017BA90",
                              "bindable": "approximateDOB",
                              "columnWidth": 0.5,
                              "bind": "{approximateDOB}",
                              "format": "d-m-Y H:m:s",
                              "submitFormat": "d-m-Y H:m:s"
                         }, {
                              "name": "emailId",
                              "itemId": "emailId",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Email ID",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Email ID<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "E169760A-31F2-4413-BDF4-6DF3041704AC",
                              "minLength": "0",
                              "maxLength": "256",
                              "errorMessage": "Please enter Email ID",
                              "bindable": "emailId",
                              "columnWidth": 0.5,
                              "bind": "{emailId}"
                         }, {
                              "name": "phoneNumber",
                              "itemId": "phoneNumber",
                              "xtype": "textfield",
                              "customWidgetType": "vdTextfield",
                              "displayName": "Phone Number",
                              "margin": "5 5 5 5",
                              "fieldLabel": "Phone Number<font color='red'> *<\/font>",
                              "allowBlank": false,
                              "fieldId": "4215AB67-A961-4E4E-A853-0B87C42F7494",
                              "minLength": "0",
                              "maxLength": "20",
                              "errorMessage": "Please enter Phone Number",
                              "bindable": "phoneNumber",
                              "columnWidth": 0.5,
                              "bind": "{phoneNumber}"
                         }, {
                              "name": "versionId",
                              "itemId": "versionId",
                              "xtype": "numberfield",
                              "customWidgetType": "vdNumberfield",
                              "displayName": "versionId",
                              "margin": "5 5 5 5",
                              "value": "-1",
                              "fieldLabel": "versionId",
                              "fieldId": "292BA3FB-0A38-471A-96F1-DBE111E4C882",
                              "bindable": "versionId",
                              "bind": "{versionId}",
                              "hidden": true
                         }]
                    }]
               }, {
                    "xtype": "form",
                    "displayName": "Timezone",
                    "title": "Timezone",
                    "name": "Timezone",
                    "itemId": "TimezoneForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "utcdifference",
                                   "itemId": "utcdifference",
                                   "xtype": "numberfield",
                                   "customWidgetType": "vdNumberfield",
                                   "displayName": "UTC Difference",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "UTC Difference<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "2FF7AE9A-91BA-4A4E-9059-12156F35C373",
                                   "minValue": "0",
                                   "maxValue": "11",
                                   "bindable": "timezone.utcdifference",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.utcdifference}"
                              }, {
                                   "name": "gmtLabel",
                                   "itemId": "gmtLabel",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "GMT",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "GMT",
                                   "fieldId": "3DDE84F8-FB2C-4F1D-9231-938D3DBCF518",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "timezone.gmtLabel",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.gmtLabel}"
                              }, {
                                   "name": "timeZoneLabel",
                                   "itemId": "timeZoneLabel",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Time Zone",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Time Zone",
                                   "fieldId": "13FA275D-8093-450E-BFF0-4304F15C56F9",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "timezone.timeZoneLabel",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.timeZoneLabel}"
                              }, {
                                   "name": "country",
                                   "itemId": "country",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Country",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Country",
                                   "fieldId": "6E75600C-115A-404C-A965-2FACA1CE602E",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "timezone.country",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.country}"
                              }, {
                                   "name": "cities",
                                   "itemId": "cities",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "City",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "City",
                                   "fieldId": "B2657BDE-F9B8-42A5-990F-CD7AD551F529",
                                   "minLength": "0",
                                   "maxLength": "256",
                                   "bindable": "timezone.cities",
                                   "columnWidth": 0.5,
                                   "bind": "{timezone.cities}"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }, {
                    "xtype": "form",
                    "displayName": "Communication Data",
                    "title": "Communication Data",
                    "name": "CommunicationData",
                    "itemId": "CommunicationDataForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "commGroupId",
                                   "itemId": "commGroupId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Group",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Communication Group<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "E435BFBC-9F6D-45FC-8F08-9B592CD5BD15",
                                   "restURL": "CommunicationGroup",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Sales.sales.shared.sales.model.contacts.CommunicationGroupModel"
                                   },
                                   "bindable": "communicationData.commGroupId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onCommGroupIdChange"
                                   }
                              }, {
                                   "name": "commType",
                                   "itemId": "commType",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Communication Type",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Communication Type<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "02EFFA16-9914-41D3-827A-9FE80F0160CD",
                                   "restURL": "CommunicationType",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Sales.sales.shared.sales.model.contacts.CommunicationTypeModel"
                                   },
                                   "bindable": "communicationData.commType",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "commData",
                                   "itemId": "commData",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Communication Data",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Communication Data<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "5C9777F5-7A09-415F-BA56-E607A950AD03",
                                   "minLength": "0",
                                   "errorMessage": "please enter communication details",
                                   "bindable": "communicationData.commData",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 242,
                         "text": "Add CommunicationData",
                         "handler": "addCommunicationData"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "CommunicationData",
                         "columnWidth": 1,
                         "itemId": "CommunicationDataGrid",
                         "fieldLabel": "List",
                         "bindLevel": "communicationData",
                         "bindable": "communicationData",
                         "listeners": {
                              "select": "onCommunicationDataGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "commType",
                              "text": "commType",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commDataId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Communication Group",
                              "text": "Communication Group",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commGroupId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Type",
                              "text": "Communication Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commType",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Communication Data",
                              "text": "Communication Data",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "commData",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }, {
                    "xtype": "form",
                    "displayName": "Address",
                    "title": "Address",
                    "name": "Address",
                    "itemId": "AddressForm",
                    "bodyPadding": 10,
                    "items": [{
                         "xtype": "form",
                         "itemId": "form1",
                         "customWidgetType": "vdAnchorLayout",
                         "header": {
                              "hidden": true
                         },
                         "items": [{
                              "layout": "column",
                              "customWidgetType": "vdColumnLayout",
                              "header": {
                                   "hidden": true
                              },
                              "xtype": "panel",
                              "items": [{
                                   "name": "addressTypeId",
                                   "itemId": "addressTypeId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Address Type",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Type<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "43C88DCE-CF7D-41BD-A002-855CF5BF2EE3",
                                   "errorMessage": "Please enter valid Address type",
                                   "restURL": "AddressType",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Sales.sales.shared.sales.model.location.AddressTypeModel"
                                   },
                                   "bindable": "address.addressTypeId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "addressLabel",
                                   "itemId": "addressLabel",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Address Label",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address Label",
                                   "fieldId": "12ECD96F-F2E4-41DA-86B5-4594394D3784",
                                   "minLength": "0",
                                   "maxLength": "11",
                                   "bindable": "address.addressLabel",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address1",
                                   "itemId": "address1",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address1",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address1",
                                   "fieldId": "915C39AE-9A0A-4134-9DD0-3D7679226062",
                                   "bindable": "address.address1",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address2",
                                   "itemId": "address2",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address2",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address2",
                                   "fieldId": "E91D288D-3A66-48CE-9C01-083338C05312",
                                   "bindable": "address.address2",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "address3",
                                   "itemId": "address3",
                                   "xtype": "textareafield",
                                   "customWidgetType": "vdTextareafield",
                                   "displayName": "Address3",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Address3",
                                   "fieldId": "C1D9BE13-68A2-4C67-A324-5AE7460A0234",
                                   "bindable": "address.address3",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "countryId",
                                   "itemId": "countryId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "Country",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Country<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "CD5A2B60-D9CC-4F4C-9C6A-A5060F003471",
                                   "errorMessage": "Please enter Country",
                                   "restURL": "Country",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Sales.sales.shared.sales.model.location.CountryModel"
                                   },
                                   "bindable": "address.countryId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onCountryIdChange"
                                   }
                              }, {
                                   "name": "stateId",
                                   "itemId": "stateId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "State",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "State<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "DF7365B4-B18F-45A3-8ECB-A605FD999D92",
                                   "errorMessage": "Please enter State",
                                   "restURL": "State",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Sales.sales.shared.sales.model.location.StateModel"
                                   },
                                   "bindable": "address.stateId",
                                   "columnWidth": 0.5,
                                   "listeners": {
                                        "change": "onStateIdChange"
                                   }
                              }, {
                                   "name": "cityId",
                                   "itemId": "cityId",
                                   "xtype": "combo",
                                   "customWidgetType": "vdCombo",
                                   "displayName": "City",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "City<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "D1935998-2ECB-466C-A1AF-3E36566E4775",
                                   "errorMessage": "Please enter City",
                                   "restURL": "City",
                                   "displayField": "primaryDisplay",
                                   "valueField": "primaryKey",
                                   "typeAhead": true,
                                   "queryMode": "local",
                                   "minChars": 2,
                                   "store": {
                                        "data": [],
                                        "model": "Sales.sales.shared.sales.model.location.CityModel"
                                   },
                                   "bindable": "address.cityId",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "zipcode",
                                   "itemId": "zipcode",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Postal Code",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Postal Code<font color='red'> *<\/font>",
                                   "allowBlank": false,
                                   "fieldId": "BD9E93B3-0E21-46D1-854D-7C147B13AF1E",
                                   "minLength": "0",
                                   "maxLength": "6",
                                   "errorMessage": "Please enter postal code",
                                   "bindable": "address.zipcode",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "latitude",
                                   "itemId": "latitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Latitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Latitude",
                                   "fieldId": "69720DB9-B938-46DB-87A8-4EEBED493B79",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.latitude",
                                   "columnWidth": 0.5
                              }, {
                                   "name": "longitude",
                                   "itemId": "longitude",
                                   "xtype": "textfield",
                                   "customWidgetType": "vdTextfield",
                                   "displayName": "Longitude",
                                   "margin": "5 5 5 5",
                                   "fieldLabel": "Longitude",
                                   "fieldId": "DAAC6B40-8CC9-4C61-8253-6D7442C6E98A",
                                   "minLength": "0",
                                   "maxLength": "64",
                                   "bindable": "address.longitude",
                                   "columnWidth": 0.5
                              }]
                         }]
                    }, {
                         "columnWidth": 1,
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "maxWidth": 132,
                         "text": "Add Address",
                         "handler": "addAddress"
                    }, {
                         "xtype": "grids",
                         "customWidgetType": "vdGrid",
                         "title": "Address",
                         "columnWidth": 1,
                         "itemId": "AddressGrid",
                         "fieldLabel": "List",
                         "bindLevel": "address",
                         "bindable": "address",
                         "listeners": {
                              "select": "onAddressGridItemClick"
                         },
                         "store": {
                              "fields": [],
                              "data": []
                         },
                         "columns": [{
                              "header": "Address Id",
                              "text": "Address Id",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "Address Type",
                              "text": "Address Type",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressTypeId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Address Label",
                              "text": "Address Label",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "addressLabel",
                              "flex": 1
                         }, {
                              "header": "Address1",
                              "text": "Address1",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address1",
                              "flex": 1
                         }, {
                              "header": "Address2",
                              "text": "Address2",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address2",
                              "flex": 1
                         }, {
                              "header": "Address3",
                              "text": "Address3",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "address3",
                              "flex": 1
                         }, {
                              "header": "Country",
                              "text": "Country",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "countryId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "State",
                              "text": "State",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "stateId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "City",
                              "text": "City",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "cityId",
                              "renderer": "renderFormValue",
                              "flex": 1
                         }, {
                              "header": "Postal Code",
                              "text": "Postal Code",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "zipcode",
                              "flex": 1
                         }, {
                              "header": "Latitude",
                              "text": "Latitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "latitude",
                              "flex": 1
                         }, {
                              "header": "Longitude",
                              "text": "Longitude",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "longitude",
                              "flex": 1
                         }, {
                              "header": "createdBy",
                              "text": "createdBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "createdDate",
                              "text": "createdDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "createdDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedBy",
                              "text": "updatedBy",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedBy",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "updatedDate",
                              "text": "updatedDate",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "updatedDate",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "versionId",
                              "text": "versionId",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "versionId",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "activeStatus",
                              "text": "activeStatus",
                              "customWidgetType": "vdGridColumn",
                              "dataIndex": "activeStatus",
                              "hidden": true,
                              "flex": 1
                         }, {
                              "header": "txnAccessCode",
                              "text": "txnAccessCode",
                              "customWidgetType": "vdGridColumn",
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
                                   "handler": "onDeleteActionColumnClick"
                              }]
                         }]
                    }],
                    "customWidgetType": "vdCard"
               }],
               "tools": [{
                    "type": "help",
                    "tooltip": "Get Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "layout": "card",
               "defaults": {
                    "autoScroll": true
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "margin": 0,
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {
                         "margin": "0 5 0 5"
                    }
               }, {
                    "xtype": "toolbar",
                    "customWidgetType": "vdTBar",
                    "defaults": {
                         "margin": "0 5 0 5"
                    },
                    "isDockedItem": true,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardPrev",
                         "text": "&laquo; Previous",
                         "handler": "showPreviousCard",
                         "disabled": true,
                         "margin": "0 5 0 5"
                    }, {
                         "xtype": "button",
                         "customWidgetType": "vdButton",
                         "itemId": "cardNext",
                         "text": "Next &raquo;",
                         "handler": "showNextCard",
                         "margin": "0 5 0 5"
                    }]
               }],
               "viewModel": "CoreContactsViewModel",
               "listeners": {},
               "extend": "Ext.form.Panel",
               "region": "center",
               "customWidgetType": "vdCardLayout"
          }]
     }]
});