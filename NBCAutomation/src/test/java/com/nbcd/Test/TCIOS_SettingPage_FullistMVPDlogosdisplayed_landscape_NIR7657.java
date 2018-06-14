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
import com.nbcd.Pages.PGAppSettings;
import com.nbcd.Pages.PGAppShowVideoDetails;

import io.appium.java_client.android.AndroidDriver;

public class TCIOS_SettingPage_FullistMVPDlogosdisplayed_landscape_NIR7657 extends GetWebDriverInstance 
{

	
	
	@Test(groups="PGAppSearchDetails")
	
	 public void IOS_fullistMVPDlogosdisplayed_landscape_NIR7657() throws Exception 
	 {

		
		PGAppSettings objHP = new PGAppSettings(driver);
		
		objHP.IOS_fullistMVPDlogosdisplayed_landscape_NIR7657();
		
		
		
	 }
} 