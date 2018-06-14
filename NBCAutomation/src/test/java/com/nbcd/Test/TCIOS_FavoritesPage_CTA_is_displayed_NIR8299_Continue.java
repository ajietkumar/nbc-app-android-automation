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

public class TCIOS_FavoritesPage_CTA_is_displayed_NIR8299_Continue extends GetWebDriverInstance
{

	
	
	@Test(groups="PGAppFavorites")
	
	 public void Favorites_CTA_is_displayed_NIR8298_continue() throws Exception 
	 {

		//PGAppHomePage objHP = new PGAppHomePage(androidDriver);
		PGAppFavorites objHP = new PGAppFavorites(driver);
		
		
		//objHP.android_apptest();
		objHP.Favorites_CTA_is_displayed_NIR8298_continue();
		
		
	 }
} 