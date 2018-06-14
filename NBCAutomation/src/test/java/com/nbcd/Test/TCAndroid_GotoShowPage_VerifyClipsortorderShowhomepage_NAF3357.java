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
import com.nbcd.Pages.PGAppShowVideoDetails;
import com.nbcd.Pages.PGGotoShowPage;

import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_GotoShowPage_VerifyClipsortorderShowhomepage_NAF3357 extends GetWebDriverInstance
{

	
	
	@Test(groups="PGAppSettings")
	
	 public void iOS_Setting_MVPD() throws Exception 
	 {

		
		PGGotoShowPage objHP = new PGGotoShowPage(driver);
		
		
		
		objHP.android_VerifyClipsortorderShowhomepage_NAF3357();
		
		//objHP.anroid_Error_messages_Live_VOD_NAF_3554();
	 }
} 