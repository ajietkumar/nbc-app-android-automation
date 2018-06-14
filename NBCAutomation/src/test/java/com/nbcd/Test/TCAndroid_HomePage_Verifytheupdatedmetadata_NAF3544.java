package com.nbcd.Test;


import com.nbcd.GenericLib.GetWebDriverInstance;
import org.testng.annotations.Test;
import com.nbcd.Pages.PGGotoShowPage;

import io.appium.java_client.android.AndroidDriver;

public class TCAndroid_HomePage_Verifytheupdatedmetadata_NAF3544 extends GetWebDriverInstance
{

	
	
	@Test(groups="ShowHomePage")
	
	 public void android_Verifytheupdatedmetadata_NAF3544() throws Exception 
	 {

		
		PGGotoShowPage objHP = new PGGotoShowPage(driver);
		
		
	
		objHP.android_VerifyFavoritesSectionHomePage();
		
		
		
	 }
} 