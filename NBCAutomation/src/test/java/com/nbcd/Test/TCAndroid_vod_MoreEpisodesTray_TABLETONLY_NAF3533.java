package com.nbcd.Test;


import com.nbcd.GenericLib.GetWebDriverInstance;
import org.testng.annotations.Test;

import com.nbcd.Pages.PGEntitedVodAuthentication;
import com.nbcd.Pages.PGGotoShowPage;
import com.nbcd.Pages.PGSettingsTVproviderAuthentication;
import com.nbcd.Pages.PGVideoPlayerPage;

import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_vod_MoreEpisodesTray_TABLETONLY_NAF3533 extends GetWebDriverInstance
{

	
	
	@Test(groups="Authentication")

	 public void android_VerifyMoreEpisodesTrayinAndroidTablet() throws Exception 
	 {

		
		PGVideoPlayerPage objHP = new PGVideoPlayerPage(driver);
		
		objHP.android_VerifyMoreEpisodesTray();
	
	
		
		
		
	 }
} 