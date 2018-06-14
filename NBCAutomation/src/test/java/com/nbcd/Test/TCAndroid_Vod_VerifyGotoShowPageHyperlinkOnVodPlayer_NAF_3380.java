package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;

import com.nbcd.Pages.PGAppHomePage;
import com.nbcd.Pages.PGGotoShowPage;

import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_Vod_VerifyGotoShowPageHyperlinkOnVodPlayer_NAF_3380 extends GetWebDriverInstance 
{

	
	
	@Test(groups="TCGotoShowPage")
	
	 public void android_GoToShow() throws Exception 
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGGotoShowPage objHP = new PGGotoShowPage(driver);
		
		
		//objHP.android_apptest();
		objHP.android_VerifyGoToShowBtn();
		
		
		
	 }
} 