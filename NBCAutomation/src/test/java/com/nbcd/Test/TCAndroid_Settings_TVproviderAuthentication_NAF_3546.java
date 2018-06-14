package com.nbcd.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import org.testng.annotations.Test;


import com.nbcd.Pages.PGSettingsTVproviderAuthentication;
import com.nbcd.Pages.PGShowMeHow;

public class TCAndroid_Settings_TVproviderAuthentication_NAF_3546 extends GetWebDriverInstance 
{


	
	@Test(groups="Settings")
	
	 public void android_TVproviderAuthentication_NAF_3546() throws Exception 
	 {

		
		PGSettingsTVproviderAuthentication objHP = new PGSettingsTVproviderAuthentication(driver);
	
		objHP.android_TVproviderAuthentication_NAF_3546();
		
		
		
	 }
} 