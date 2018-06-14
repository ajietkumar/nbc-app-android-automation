package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAppShowVideoDetails;

public class TCIOS_ShowDetails_Verify_Tapsonshowthumbnail_NIR7199 extends GetWebDriverInstance
{

	
	
	@Test(groups="PGAppSettings")
	
	 public void iOS_Verify_Tapsonshowthumbnail_NIR7199() throws Exception 
	 {

		
		PGAppShowVideoDetails objHP = new PGAppShowVideoDetails(driver);
		
		
		
		objHP.iOS_Verify_Tapsonshowthumbnail_NIR7199();
		
		
		
	 }
} 