package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;


import com.nbcd.Pages.PGAllCategoriesShows;
import com.nbcd.Pages.PGAppShowVideoDetails;

import io.appium.java_client.android.AndroidDriver;

public class TCAppShowVideoDetails_iOS_Verifytheupdatedmetadata_NIR7619 extends GetWebDriverInstance 
{

	
	
	@Test(groups="TCAllCategoriesShows")
	
	 public void iOS_Verifytheupdatedmetadata_NIR7620() throws Exception 
	 {

		
		PGAppShowVideoDetails objHP = new PGAppShowVideoDetails(driver);
		
		
	
		objHP.iOS_Verifytheupdatedmetadata_NIR7619();
		
		
		
	 }
} 