package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAppShowVideoDetails;

public class TCIOS_ShowDetails_Verify_keyartShowdetail_Portrait_NIR7201 extends GetWebDriverInstance
{

	
	
	@Test(groups="PGAppSettings")
	
	 public void IOS_MVPDPicker_Portrait_NIR7658() throws Exception 
	 {

		
		PGAppShowVideoDetails objHP = new PGAppShowVideoDetails(driver);
		
		
		
		objHP.iOS_Verify_keyartShowdetail_Portrait_NIR_7201();
		
		
		
	 }
} 