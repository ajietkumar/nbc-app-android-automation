package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;

import com.nbcd.Pages.PGAppHomePage;
import com.nbcd.Pages.PGAppSchedule;
import com.nbcd.Pages.PGAppSettings;

import io.appium.java_client.android.AndroidDriver;

public class TCIOS_Schedule_DayScroll_NIR7670 extends GetWebDriverInstance
{

	
	
	@Test(groups="PGAppSettings")
	
	 public void iOS_Verify_Day_Selector_Scrolling_NIR7670() throws Exception 
	 {

		
		PGAppSchedule objHP = new PGAppSchedule(driver);
		
		
		
		objHP.iOS_Verify_Day_Selector_Scrolling_NIR7670();
		
		
		
	 }
} 