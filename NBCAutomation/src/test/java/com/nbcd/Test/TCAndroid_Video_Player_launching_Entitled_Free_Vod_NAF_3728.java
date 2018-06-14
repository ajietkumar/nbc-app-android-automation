package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAndroidApp;
import com.nbcd.Pages.PGVideoPlayerPage;

public class TCAndroid_Video_Player_launching_Entitled_Free_Vod_NAF_3728 extends GetWebDriverInstance {
	@Test(groups="PGVideoPlayerPage")
	
	 public void android_VideoPlayerLaunching_Entitled_Free_Vod_NAF_3728() throws Throwable
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGVideoPlayerPage objHP = new PGVideoPlayerPage(driver);
		objHP.android_Video_Player_launching_Entitled_Free_Vod_NAF_3728();
		
		
	 }

}
