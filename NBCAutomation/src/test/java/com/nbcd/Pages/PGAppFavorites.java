package com.nbcd.Pages;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
public class PGAppFavorites  {
	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> StaticText,X_icon,show_name;
	String sqlQry, Status;
	WebElement Favorites_icon,Editbtn,Fav_btn,x_btn,Scrollobj,EpisodeVideo,Fav_show,Source,Desc,Sign_up;
	// Constructor to initialize all the Page Objects
	public PGAppFavorites(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGAppFavorites", "Input");
		lstObject = db.getTestDataObject("Select * from PGAppFavorites", "ObjectRepository");
	}
	// =========================================================================================================================
	@SuppressWarnings("deprecation")
	@Test
	public void iOS_Verifythe_text_in_Favorites_page_NIR7667() throws  Exception {
		try
		{

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			
		    Favorites_icon =  Utilities.returnElement(driver, lstObject.get(2), lstObject.get(1));
			Favorites_icon.click();
			Thread.sleep(4000);
			try {
			Editbtn  =  Utilities.returnElement(driver, lstObject.get(8), lstObject.get(7));
			if (Editbtn.isEnabled()) {
				Extent_Reports.executionLog("PASS",  " Edit Button should be dispayed" +"\n"
						+ " Edit Button is dispayed", driver);
				
				Editbtn.click();
				Thread.sleep(2000);
				X_icon=Utilities.returnElements(driver, lstObject.get(11), lstObject.get(10));
				for (int i=0;i<=X_icon.size();i++) {
					Extent_Reports.executionLog("PASS", " X Icon button should be dispayed" +"\n"
							+  " X Icon button is dispayed", driver);
					
					X_icon.get(i).click();
					Thread.sleep(5000);
					X_icon=Utilities.returnElements(driver, lstObject.get(11), lstObject.get(10));
				}
			}
			}catch(Exception e) {
				
				
			}
			
			
			StaticText  =  Utilities.returnElements(driver, lstObject.get(5), lstObject.get(4));
			if(StaticText.get(2).getAttribute("label").contains(lstTestData.get(0))) {
				Extent_Reports.executionLog("PASS", StaticText.get(2).getAttribute("label")+ " should be displayed in the middle of the continue watching section" +"\n"
						+ StaticText.get(2).getAttribute("label")+ " is displayed in the middle of the continue watching section", driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", StaticText.get(2).getAttribute("label")+ " should be displayed in the middle of the continue watching section" +"\n"
						+ StaticText.get(2).getAttribute("label")+ " is not displayed in the middle of the continue watching section", driver);
			}
			
			
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verifythe_text_in_Favorites_page_NIR7667"  + "\n"+ e.getMessage(), driver);
			
		}
		
	}// EOM
	
	
	
	@Test
	public void iOS_Verify_Watch_more_videos_band_Favorites_page_NIR7322() throws  Exception {
		try
		{

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			pgncapp.iOS_OpenShow(lstTestData.get(1),lstTestData.get(6));
			Thread.sleep(4000);
			Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
			if (Fav_btn.getAttribute("value") == "1") {
				Extent_Reports.executionLog("PASS", " Show is alread added to favorites" +"\n"
						+ "Show is alread added to favorites", driver);
				}else {
					Fav_btn.click();
					Extent_Reports.executionLog("PASS", " Show should be added to favorites" +"\n"
							+ "Show is added to favorites", driver);
				}
			
			Thread.sleep(4000);
			x_btn = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			x_btn.click();
			Thread.sleep(4000);
			Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
			if (Fav_btn.getAttribute("value") == "1") {
				Extent_Reports.executionLog("PASS", " Show should be added to favorites" +"\n"
						+ "Show is added to favorites", driver);
				}else {
					Extent_Reports.executionLog("FAIL", " Show should be added to favorites" +"\n"
							+ "Show is not added to favorites", driver);
				}
		    
			Favorites_icon =  Utilities.returnElement(driver, lstObject.get(2), lstObject.get(1));
			Favorites_icon.click();
			Thread.sleep(4000);
			
			/*Fav_show = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
			if(Fav_show.getAttribute("label").equalsIgnoreCase(lstTestData.get(1))) {
				Extent_Reports.executionLog("PASS", " Added show should be displayed in favorites page" +"\n"
						+ "Added show is displayed in favorites page", driver);
			}else {
				Extent_Reports.executionLog("FAIL", " Added show should be displayed in favorites page" +"\n"
						+ "Added show is not displayed in favorites page", driver);
			}*/
			
			//for(int i=0;i<20;i++)
			//{
		     List<WebElement> SourceList =  Utilities.returnElements(driver, lstObject.get(23), lstObject.get(22));
		    
		   //  Source =  driver.findElement(By.xpath("//XCUIElementTypeTable/XCUIElementTypeCell/XCUIElementTypeStaticText[@name='Favorites-FavoritesSection-Label-Title']//*"));
		     //Desc =  Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
		   
		     // new TouchAction(driver).press(SourceList.get(1)).moveTo(SourceList.get(2)).release();
				
		   //  pgncapp.iOS_scroll(Source, Source.getSize(), "right");
			//}
		    
		     RemoteWebElement element = (RemoteWebElement)driver.findElement(By.className("XCUIElementTypeTable"));
		     String elementID = element.getId();
		     HashMap<String, String> scrollObject = new HashMap<String, String>();
		     scrollObject.put("element", elementID); // Only for ‘scroll in element’
		     scrollObject.put("direction", "right");
		     driver.executeScript("mobile:scroll", scrollObject);
		     
		    /*
			pgncapp.iOS_scroll(Source, Desc, "right");
			Thread.sleep(2000);
			Desc.click();
			Thread.sleep(3000);
            show_name = Utilities.returnElements(driver, lstObject.get(29), lstObject.get(28));
            if(show_name.get(0).getAttribute("value").equalsIgnoreCase(lstTestData.get(1))) {
            	Extent_Reports.executionLog("PASS", " Should be navigated back to show home page" +"\n"
						+ " navigated back to show home page", driver);
            }else {
            	Extent_Reports.executionLog("FAIL", " Should be navigated back to show home page" +"\n"
						+ " not navigated back to show home page", driver);
            }
			*/
			
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verifythe_text_in_Favorites_page_NIR7667"  + "\n"+ e.getMessage(), driver);
			
		}
		
	}// EOM
	
	@Test
	public void iOS_Verify_Favorites_CTA_is_displayed_NIR8298() throws  Exception
	{
		try
		{

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			pgncapp.iOS_OpenShow(lstTestData.get(1),lstTestData.get(6));
			Thread.sleep(6000);	
			
			
			try {
				Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
				if(Fav_btn.getAttribute("value").trim()=="1") {
					Fav_btn.click();
					Thread.sleep(2000);
					//Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
					Fav_btn.click();
				}
			}catch(Exception e) {
				Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
				Fav_btn.click();
			}
			
			Thread.sleep(3000);	
			Sign_up=Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
			if (Sign_up.isEnabled()) {
				Extent_Reports.executionLog("PASS", " Favorites CTA page should be displad" +"\n"
						+ "Favorites CTA page is displad", driver);
				}else {
					Extent_Reports.executionLog("FAIL", " Favorites CTA page should be displad" +"\n"
							+ "Favorites CTA page is not displad", driver);
				}
			StaticText  =  Utilities.returnElements(driver, lstObject.get(5), lstObject.get(4));
			for (int i=0;i<=StaticText.size()-1;i++) {
				Extent_Reports.executionLog("PASS", StaticText.get(i).getAttribute("label")+ " should be displayed in the middle of the Favorites CTA page" +"\n"
						+ " is displayed in the middle of the Favorites CTA page", driver);
			}
			
			x_btn = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			x_btn.click();
			Thread.sleep(3000);	
			pgncapp.iOS_OpenShow(lstTestData.get(2),lstTestData.get(6));
			
			try {
				Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
				if(Fav_btn.getAttribute("value").trim()=="1") {
					Fav_btn.click();
					Thread.sleep(2000);
					//Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
					Fav_btn.click();
				}
			}catch(Exception e) {
				Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
				Fav_btn.click();
			}
			Thread.sleep(3000);
			try {
				Sign_up=Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
				Extent_Reports.executionLog("FAIL", " Favorites CTA page should not be displad" +"\n"
						+ "Favorites CTA page is displad", driver);
					
					
			} catch(Exception e) {
				Extent_Reports.executionLog("PASS", " Favorites CTA page should not be displad" +"\n"
						+ "Favorites CTA page is not displad", driver);
			}
			
			
		}
		
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verify_Favorites_CTA_is_displayed_NIR8298"  + "\n"+ e.getMessage(), driver);
			
		}
	}
	
	@Test
	public void Favorites_CTA_is_displayed_NIR8298_continue() throws  Exception
	{
		try
		{

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			pgncapp.iOS_OpenShow(lstTestData.get(3),lstTestData.get(6));
			Thread.sleep(6000);	
			
			try {
				Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
				if(Fav_btn.getAttribute("value").trim()=="1") {
					Fav_btn.click();
					Thread.sleep(2000);
					//Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
					Fav_btn.click();
				}
			}catch(Exception e) {
				Fav_btn =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
				Fav_btn.click();
			}
			Thread.sleep(3000);	
			Sign_up=Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
			if (Sign_up.isEnabled()) {
				Extent_Reports.executionLog("PASS", " Favorites CTA page should be displad" +"\n"
						+ "Favorites CTA page is displad", driver);
				}else {
					Extent_Reports.executionLog("FAIL", " Favorites CTA page should be displad" +"\n"
							+ "Favorites CTA page is not displad", driver);
				}
			StaticText  =  Utilities.returnElements(driver, lstObject.get(5), lstObject.get(4));
			for (int i=0;i<=StaticText.size()-1;i++) {
				Extent_Reports.executionLog("PASS", StaticText.get(i).getAttribute("label")+ " should be displayed in the middle of the Favorites CTA page" +"\n"
						+ " is displayed in the middle of the Favorites CTA page", driver);
			}
			
			x_btn = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			x_btn.click();
			Thread.sleep(3000);				
			
		}
		
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verify_Favorites_CTA_is_displayed_NIR8298"  + "\n"+ e.getMessage(), driver);
			
		}
	}
	
	
}// EOC
