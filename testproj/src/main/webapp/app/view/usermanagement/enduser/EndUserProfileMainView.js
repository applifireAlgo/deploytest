Ext.define('Testproj.view.usermanagement.enduser.EndUserProfileMainView', {
	extend : 'Ext.tab.Panel',
	requires : ['Testproj.view.usermanagement.enduser.UserProfile',
	            'Testproj.view.usermanagement.enduser.ChangePwd'],
	xtype : 'endUserMainView',
	margin : '3 0 0 0',
	items:[{
				xtype:'userProfileView',
				title:'User Profile',
				iconCls:'editUserTabIcon',
				tooltip:'View/Edit your profile'
			},
			{
				xtype:'changePwdView',
				title:'Change Password',
				iconCls:'changePwdTabIcon',
				tooltip:'Change Password'
			}]
});