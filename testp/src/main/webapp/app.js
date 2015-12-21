/*
 * This file is generated and updated by Sencha Cmd. You can edit this file as
 * needed for your application, but these edits will have to be merged by
 * Sencha Cmd when upgrading.
 */
Ext.application({
    name: 'Testp',

    extend: 'Testp.Application',
    
/**AppPathDetails**/autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Testp.view.mainleftmenutree.MainPanel':'Testp.view.mobileview.login.Login',
    //autoCreateViewport: (Ext.os.deviceType=='Desktop')?'Testp.view.login.LoginPage':'Testp.view.mobileview.login.LoginPage',//'Testp.view.login.Login'
    	
    //-------------------------------------------------------------------------
    // Most customizations should be made to Testp.Application. If you need to
    // customize this file, doing so below this section reduces the likelihood
    // of merge conflicts when upgrading to new versions of Sencha Cmd.
    //-------------------------------------------------------------------------
});
