package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;


import com.nbcd.Pages.PGAppSettings;


import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_Settings_NAF_345 extends GetWebDriverInstance 
{

	
	
	@Test(groups="TCAppSettings")
	
	 public void android_Settings() throws Exception 
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGAppSettings objHP = new PGAppSettings(driver);
		
		
		//objHP.android_apptest();
		objHP.android_Settings();
		
		
		
	 }
} 