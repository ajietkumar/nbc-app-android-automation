package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;

import com.nbcd.Pages.PGAppHomePage;

import io.appium.java_client.android.AndroidDriver;

public class TCAppHomePage_android_apptest_NotaDuplicte_JustFor_Reference extends GetWebDriverInstance
{

	
	
	@Test(groups="TCActivationPage_TCActivationPage_VerifySucessPage_2751")
	
	 public void android_apptest() throws Exception 
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGAppHomePage objHP = new PGAppHomePage(driver);
		
		
		//objHP.android_apptest();
		objHP.android_Apptest();
		
		
		
	 }
} 