package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;

import com.nbcd.Pages.PGAppHomePage;
import com.nbcd.Pages.PGAppSettings;
import com.nbcd.Pages.PGAppShowVideoDetails;

import io.appium.java_client.android.AndroidDriver;

public class TCIOS_Verify_MVPD_fromshowpage_NIR8685 extends GetWebDriverInstance
{

	
	
	@Test(groups="PGAppSettings")
	
	 public void iOS_Setting_MVPD() throws Exception 
	 {

		
		PGAppShowVideoDetails objHP = new PGAppShowVideoDetails(driver);
		
		
		
		objHP.iOS_Verify_MVPD_fromshow_MVP_NIR8685();
		
				
	 }
} 