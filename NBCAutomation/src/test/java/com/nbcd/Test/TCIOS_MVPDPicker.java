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

import io.appium.java_client.android.AndroidDriver;

public class TCIOS_MVPDPicker extends GetWebDriverInstance
{

	
	
	@Test(groups="PGAppSettings")
	
	 public void ios_Linkprovider() throws Throwable 
	 {

		
		PGAppSettings objHP = new PGAppSettings(driver);
		
		
		
		objHP.MVPDPicker();
		
		
		
	 }
} 