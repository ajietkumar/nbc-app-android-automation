
package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;

import com.nbcd.Pages.PGShowHomePage;
import com.nbcd.Pages.PGShowHomePage;

import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_ShowHomePage_VerifyAboutinShowHomePage_NAF_3358 extends GetWebDriverInstance 
{

	
	
	@Test(groups="ShowHomePage")
	
	 public void VerifyAboutinShowHomepage_NAF_3358() throws Exception 
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGShowHomePage objHP = new PGShowHomePage(driver);
		
		
		//objHP.android_apptest();
		objHP.android_VerifyAboutinShowHomepage_NAF_3358();
		
		
		
	 }
} 




