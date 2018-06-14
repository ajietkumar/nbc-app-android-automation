package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAndroidApp;
import com.nbcd.Pages.PGAppSearchDetails;
import com.nbcd.Pages.PGAppSettings;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;





import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_Schedule_Verify_Schedule_NAF_3542 extends GetWebDriverInstance 
{

	
	@Test(groups="TCAppNBCAppSchedule")
	
	 public void android_Verify_Schedule() throws Throwable
	 {
		
			PGAndroidApp App = new PGAndroidApp(driver);
		App.android_Verify_Schedule();
			
		
		
	 }
} 