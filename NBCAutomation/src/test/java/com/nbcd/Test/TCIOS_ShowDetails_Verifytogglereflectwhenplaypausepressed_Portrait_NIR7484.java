package com.nbcd.Test;

import org.testng.annotations.Test;

import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.Pages.PGAppShowVideoDetails;

public class TCIOS_ShowDetails_Verifytogglereflectwhenplaypausepressed_Portrait_NIR7484 extends GetWebDriverInstance
{

	
	
	@Test(groups="PGAppSettings")
	
	 public void Verifytogglereflectwhenplaypausepressed_Portrait_NIR7484() throws Exception 
	 {

		
		PGAppShowVideoDetails objHP = new PGAppShowVideoDetails(driver);
		
		
		
		objHP.iOS_Verifytogglereflectwhenplaypausepressed_Portrait_NIR7484();
		
		
		
	 }
} 