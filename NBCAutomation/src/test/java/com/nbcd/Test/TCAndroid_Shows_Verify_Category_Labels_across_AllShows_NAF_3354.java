package com.nbcd.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import org.testng.annotations.Test;

import com.nbcd.Pages.PGEntitedVodAuthentication;
import com.nbcd.Pages.PGShowHomePage;
import com.nbcd.Pages.PGShowMeHow;

public class TCAndroid_Shows_Verify_Category_Labels_across_AllShows_NAF_3354 extends GetWebDriverInstance 
{

	
	
	@Test(groups="TCandroid_EntitledAuthentication_NAF_3546")
	
	 public void android_category_labels_All_shows_page_NAF_3354() throws Exception 
	 {

		
		PGShowHomePage objHP = new PGShowHomePage(driver);
	
		objHP.android_category_labels_All_shows_page_NAF_3354();
		
		
		
	 }
} 