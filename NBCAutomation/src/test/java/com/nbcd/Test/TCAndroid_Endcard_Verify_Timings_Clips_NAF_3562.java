package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAndroidApp;
import com.nbcd.Pages.PGVideoPlayerPage;

public class TCAndroid_Endcard_Verify_Timings_Clips_NAF_3562 extends GetWebDriverInstance {
	@Test(groups="TCVerifyEndcard")
	
	 public void android_Endcard_NAF_3564() throws Throwable
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGVideoPlayerPage objHP = new PGVideoPlayerPage(driver);
	
	
		objHP.android_Endcard_Clips_NoFav();
		
		
	 }

}
