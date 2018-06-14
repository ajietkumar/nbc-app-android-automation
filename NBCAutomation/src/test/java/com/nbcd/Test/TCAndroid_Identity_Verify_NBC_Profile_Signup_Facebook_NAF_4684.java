package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAndroidApp;
import com.nbcd.Pages.PGAppSettings;
import com.nbcd.Pages.PGNbcProfile;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;





import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_Identity_Verify_NBC_Profile_Signup_Facebook_NAF_4684 extends GetWebDriverInstance 
{

	
	@Test(groups="TCAppNBCSignUP")
	
	 public void android_Verify_NBCSignUP() throws Throwable
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGNbcProfile objHP = new PGNbcProfile(driver);
				
				//PGAndroidApp App = new PGAndroidApp(driver);
				//objHP.android_apptest();
				//objHP.android_Verify_NBCSignUP();
			objHP.android_NBC_Profile_With_Facebook_NAF_4684();
				//App.android_UnlinkTvProvider();
		
		
		
	 }
} 