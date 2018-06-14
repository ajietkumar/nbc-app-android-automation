package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;


import com.nbcd.Pages.PGAllCategoriesShows;


import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_Shows_VerifyAllShowCategories_NAF_114 extends GetWebDriverInstance 
{

	
	
	@Test(groups="TCAllCategoriesShows")
	
	 public void android_Settings() throws Exception 
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGAllCategoriesShows objHP = new PGAllCategoriesShows(driver);
	
		
		//objHP.android_apptest();
		objHP.android_VerifyAllCategoriesOfShows_NAF_114();
		
		
		
	 }
} 