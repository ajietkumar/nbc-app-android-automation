package com.nbcd.Test;

import java.io.IOException;
import com.nbcd.GenericLib.GetWebDriverInstance;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.Pages.PGAppFavorites;
import com.nbcd.Pages.PGAppHomePage;

import io.appium.java_client.android.AndroidDriver;

public class TCIOS_FavoritesPage_WatchMoreVideos_NIR7322 extends GetWebDriverInstance
{

	
	
	@Test(groups="PGAppFavorites")
	
	 public void iOS_Verify_Watch_more_videos_band_Favorites_page_NIR7322() throws Exception 
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGAppFavorites objHP = new PGAppFavorites(driver);
		
		
		//objHP.android_apptest();
		objHP.iOS_Verify_Watch_more_videos_band_Favorites_page_NIR7322();
		
		
		
	 }
} 