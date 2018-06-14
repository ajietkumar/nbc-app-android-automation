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

public class TCIOS_SearchDetails_SearchForClip_NIR9251 extends GetWebDriverInstance 
{

	
	
	@Test(groups="PGAppSearchDetails")
	
	 public void iOS_SearchForClip_NIR_9251() throws Exception 
	 {

		
		PGAppSearchDetails objHP = new PGAppSearchDetails(driver);
		
		objHP.iOS_SearchForClip_NIR_9251();
		
		
		
	 }
} 