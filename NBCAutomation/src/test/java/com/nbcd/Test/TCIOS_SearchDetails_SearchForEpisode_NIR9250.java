package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;


import com.nbcd.Pages.PGAllCategoriesShows;
import com.nbcd.Pages.PGAppSearchDetails;
import com.nbcd.Pages.PGAppShowVideoDetails;

import io.appium.java_client.android.AndroidDriver;

public class TCIOS_SearchDetails_SearchForEpisode_NIR9250 extends GetWebDriverInstance 
{

	
	
	@Test(groups="PGAppSearchDetails")
	
	 public void iOS_SearchForEpisode_NIR_9250() throws Exception 
	 {

		
		PGAppSearchDetails objHP = new PGAppSearchDetails(driver);
		
		objHP.iOS_SearchForEpisode_NIR_9250();
		
		
		
	 }
} 