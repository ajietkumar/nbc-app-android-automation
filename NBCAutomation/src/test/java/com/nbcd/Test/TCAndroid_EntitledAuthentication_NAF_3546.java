package com.nbcd.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import org.testng.annotations.Test;

import com.nbcd.Pages.PGEntitedVodAuthentication;
import com.nbcd.Pages.PGShowMeHow;

public class TCAndroid_EntitledAuthentication_NAF_3546 extends GetWebDriverInstance 
{

	
	
	@Test(groups="TCandroid_EntitledAuthentication_NAF_3546")
	
	 public void android_EntitledAuthentication_NAF_3546() throws Exception 
	 {

		
		PGEntitedVodAuthentication objHP = new PGEntitedVodAuthentication(driver);
	
		objHP.android_EntitledAuthentication_NAF_3546();
		
		
		
	 }
} 