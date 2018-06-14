package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAppShowVideoDetails;
import com.nbcd.Pages.PGVideoPlayerPage;

public class TCAndroid_Vod_OverlayFades_NAF7108 extends GetWebDriverInstance
{

	
	
	@Test(groups="TCActivationPage_TCActivationPage_VerifySucessPage_2751")
	
	 public void Verifytogglereflectaction_NIR7655() throws Exception 
	 {

		
	
		PGVideoPlayerPage objHP = new PGVideoPlayerPage(driver);
		
		
		
		objHP.android_OverlayFades_NAF7108();
		
		
		
	 }
} 