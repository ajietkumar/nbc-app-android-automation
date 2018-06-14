package com.nbcd.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import org.testng.annotations.Test;

import com.nbcd.Pages.PGShowMeHow;

public class TCAndroid_VerifyHowCanWeHelp_NAF_4728 extends GetWebDriverInstance 
{

	
	
	@Test(groups="TCandroid_VerifyHowCanWeHelp_NAF_4728")
	
	 public void android_Settings() throws Exception 
	 {

		
		PGShowMeHow objHP = new PGShowMeHow(driver);
	
		objHP.android_VerifyHowCanWeHelp_NAF_4728();
		
		
		
	 }
} 