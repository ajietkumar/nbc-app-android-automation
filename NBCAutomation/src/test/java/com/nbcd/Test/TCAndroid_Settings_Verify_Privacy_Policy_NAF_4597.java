package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;

import com.nbcd.Pages.PGAppSettings;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;





import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_Settings_Verify_Privacy_Policy_NAF_4597 extends GetWebDriverInstance{
	@Test(groups="Settings")
	
	 public void Anroid_Privacy_Policy() throws Throwable 
	 {

		
		PGAppSettings objHP = new PGAppSettings(driver);
	
		objHP.Anroid_Privacy_Policy();
		
		
		
	 }
}
