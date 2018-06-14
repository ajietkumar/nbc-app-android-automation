package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;


import com.nbcd.Pages.PGAllCategoriesShows;
import com.nbcd.Pages.PGAndroidApp;
import com.nbcd.Pages.PGNbcProfile;

import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_HomePage_Verify_Episode_Metadata_NAF_3366 extends GetWebDriverInstance 
{

	
	
	@Test(groups="TCVerifyEpisodeMetadata")
	
	 public void android_Verify_Episode_Metadata_NAF_3366() throws Throwable
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGAndroidApp objHP = new PGAndroidApp(driver);
	
		objHP.android_Verify_Episode_Metadata();
		
		
	 }
} 