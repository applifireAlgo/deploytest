/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Testproj',

    extend: 'Testproj.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Testproj.view.mainleftmenutree.MainPanel':'Testproj.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Testproj.view.login.LoginPage':'Testproj.view.mobileview.login.LoginPage',//'Testproj.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Testproj.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
