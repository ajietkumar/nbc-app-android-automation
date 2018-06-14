package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAndroidApp;
import com.nbcd.Pages.PGVideoPlayerPage;

public class TCAndroid_Vod_resume_functionality_NAF_3548 extends GetWebDriverInstance {
	@Test(groups="PGVideoPlayerPage")
	
	 public void android_Resume_functionality_NAF_3548() throws Throwable
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGVideoPlayerPage objHP = new PGVideoPlayerPage(driver);
		objHP.android_resume_functionality_NAF_3548();
		
		
	 }

}
