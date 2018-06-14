package com.nbcd.Pages;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class PGAppSearchDetails  {

	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List <WebElement> objShowLists,objShowList,resultText,Showname,ShowMetadat1,ShowMetadat2,ShowThumbnailImage,ShowMetadat3,ShowMetadat4;
	String sqlQry, Status;
	WebElement SearchIcon , SearchImg, enterText, clearIcon;
	// Constructor to initialize all the Page Objects
	public PGAppSearchDetails(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGSearchDeatils", "Input");
		lstObject = db.getTestDataObject("Select * from PGSearchDeatils", "ObjectRepository");
	}
	// =========================================================================================================================



	public void iOS_SearchForEpisode_NIR_9250() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();

			SearchIcon = Utilities.returnElement(driver, lstObject.get(2), lstObject.get(1));
			//driver.findElement(By.xpath("//XCUIElementTypeButton[@label=‘SearchButton’]"));

			if (SearchIcon.isEnabled()) {

				Extent_Reports.executionLog("PASS", "Search Icon should be displayed" + "\n"
						+ "Search Icon is displayed", driver);
				SearchIcon.click();
				Thread.sleep(3000);
				SearchImg = Utilities.returnElement(driver, lstObject.get(5), lstObject.get(4));
				//"//XCUIElementTypeImage[@type=‘XCUIElementTypeImage’]"
				//Synchronization.ExplicitWait(driver,lstObject.get(4) ,"visible");
				enterText=Utilities.returnElement(driver, lstObject.get(8), lstObject.get(7));
				////XCUIElementTypeSearchField[@name=‘SearchTextField’]
				enterText.sendKeys(lstTestData.get(0));
				Thread.sleep(20000);
				clearIcon=Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
				//XCUIElementTypeButton[@label=‘clearSearchIcon’]
				if (clearIcon.isEnabled()) {

					Extent_Reports.executionLog("PASS", "Clear Icon should be displayed" + "\n"
							+ "Clear Icon is displayed", driver);

				}else {
					Extent_Reports.executionLog("FAIL", "Clear Icon should be displayed" + "\n"
							+ "Clear Icon is notdisplayed", driver);
				}

				resultText=Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
				if (resultText.get(1).isEnabled()) {
					//XCUIElementTypeStaticText[@type=‘XCUIElementTypeStaticText] 
					Extent_Reports.executionLog("PASS", "Result text should be displayed as: " + resultText.get(1).getAttribute("value") + "\n"
							+ " ", driver);		
				}
				Thread.sleep(20000);

				ShowThumbnailImage=Utilities.returnElements(driver, lstObject.get(17), lstObject.get(16));
				if (ShowThumbnailImage.get(0).isEnabled()) {

					Extent_Reports.executionLog("PASS", "Episode thumbnail should be displayed :"  + "\n"
							+ " Episode thumbnail is displayed " , driver);

					Showname=Utilities.returnElements(driver, lstObject.get(20), lstObject.get(19));
					Extent_Reports.executionLog("PASS", "Show name text should be displayed as:" + Showname.get(2).getAttribute("value") + "\n"
							+ " Show name text is displayed " , driver);

					ShowMetadat1=Utilities.returnElements(driver, lstObject.get(20), lstObject.get(19));
					Extent_Reports.executionLog("PASS", "Show name meta data Line one should be displayed as:" + Showname.get(3).getAttribute("value") + "\n"
							+ " Show name meta data Line one is displayed ", driver);

					ShowMetadat2=Utilities.returnElements(driver, lstObject.get(20), lstObject.get(19));
					Extent_Reports.executionLog("PASS", "Show name meta data Line two should be displayed as:" + Showname.get(4).getAttribute("value") + "\n"
							+ " how name meta data Line two is displayed " , driver);

					ShowThumbnailImage.get(0).click();
					Thread.sleep(30000);
					WebElement VideoPlayArea=Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
					VideoPlayArea.click();

					WebElement VideoClosebtn=Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
					if(VideoClosebtn.isDisplayed())
					{
						Extent_Reports.executionLog("PASS", "Episode video should be displayed" + "\n"
								+ " Episode video is displayed " , driver);

					}
					else {
						Extent_Reports.executionLog("FAIL", "Episode video should be displayed" + "\n"
								+ " Episode video is displayed " , driver);

					}

				}
				else {

					Extent_Reports.executionLog("FAIL", "Episode thumbnail should be displayed " + "\n"
							+ " Episode thumbnail is not displayed " , driver);
				}


			}else {

				Extent_Reports.executionLog("FAIL", "Search Icon should be displayed" + "\n"
						+ "Search Icon is not displayed", driver);
			}



		}



		catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_example"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM


	public void iOS_SearchForClip_NIR_9251() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();

			SearchIcon = Utilities.returnElement(driver, lstObject.get(2), lstObject.get(1));
			//driver.findElement(By.xpath("//XCUIElementTypeButton[@label=‘SearchButton’]"));

			if (SearchIcon.isEnabled()) {

				Extent_Reports.executionLog("PASS", "Search Icon should be displayed" + "\n"
						+ "Search Icon is displayed", driver);
				SearchIcon.click();
				Thread.sleep(3000);
				SearchImg = Utilities.returnElement(driver, lstObject.get(5), lstObject.get(4));
				//"//XCUIElementTypeImage[@type=‘XCUIElementTypeImage’]"
				//Synchronization.ExplicitWait(driver,lstObject.get(4) ,"visible");
				enterText=Utilities.returnElement(driver, lstObject.get(8), lstObject.get(7));
				////XCUIElementTypeSearchField[@name=‘SearchTextField’]
				enterText.sendKeys(lstTestData.get(1));
				Thread.sleep(20000);
				clearIcon=Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
				//XCUIElementTypeButton[@label=‘clearSearchIcon’]
				if (clearIcon.isEnabled()) {

					Extent_Reports.executionLog("PASS", "Clear Icon should be displayed" + "\n"
							+ "Clear Icon is displayed", driver);

				}else {
					Extent_Reports.executionLog("FAIL", "Clear Icon should be displayed" + "\n"
							+ "Clear Icon is notdisplayed", driver);
				}

				resultText=Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
				if (resultText.get(1).isEnabled()) {
					//XCUIElementTypeStaticText[@type=‘XCUIElementTypeStaticText] 
					Extent_Reports.executionLog("PASS", "Result text should be displayed as: " + resultText.get(1).getAttribute("value") + "\n"
							+ " ", driver);		
				}
				Thread.sleep(20000);

				ShowThumbnailImage=Utilities.returnElements(driver, lstObject.get(17), lstObject.get(16));
				if (ShowThumbnailImage.get(0).isEnabled()) {

					Extent_Reports.executionLog("PASS", "Episode thumbnail should be displayed :"  + "\n"
							+ " Episode thumbnail is displayed " , driver);

					Showname=Utilities.returnElements(driver, lstObject.get(20), lstObject.get(19));
					Extent_Reports.executionLog("PASS", "Clip text should be displayed as:" + Showname.get(2).getAttribute("label") + "\n"
							+ " Show name text is displayed " , driver);
					
					  ShowMetadat1=Utilities.returnElements(driver, lstObject.get(20), lstObject.get(19));
					if (ShowMetadat1.get(3).getLocation().getX()!=0) {
						
						Extent_Reports.executionLog("PASS", "Clip name meta data Line one should be displayed as:" + Showname.get(3).getAttribute("label") + "\n"
								+ " Show name meta data Line one is displayed ", driver);
					}
					else {
						Extent_Reports.executionLog("PASS", "Show name meta data Line one should be displayed as:" + Showname.get(3).getAttribute("label") + "\n"
								+ " Clip name meta data Line one is not displayed ", driver);
					}
					//ShowMetadat2=Utilities.returnElements(driver, lstObject.get(20), lstObject.get(19));
					if (ShowMetadat1.get(4).getLocation().getX()!=0) {
					
						Extent_Reports.executionLog("PASS", "Clip Badge should be displayed as:"  + "\n"
								+ " Clip Badge is displayed " , driver);
					}
					else {
						Extent_Reports.executionLog("FAIL", "Clip Badge should be displayed as:"  + "\n"
								+ " Clip Badge is not displayed " , driver);
					}
					//ShowMetadat3=Utilities.returnElements(driver, lstObject.get(20), lstObject.get(19));
					if (ShowMetadat1.get(5).getLocation().getX()!=0) {
						
						Extent_Reports.executionLog("PASS", "Clip Air date should be displayed as:" + Showname.get(5).getAttribute("label") + "\n"
								+ " Clip Air date is displayed " , driver);
					}
					else {
						Extent_Reports.executionLog("FAIL", "Clip Air date should be displayed as:" + Showname.get(5).getAttribute("label") + "\n"
								+ " Clip Air date is not displayed " , driver);
					}
					if (ShowMetadat1.get(6).getLocation().getX()!=0) {
						//ShowMetadat4=Utilities.returnElements(driver, lstObject.get(20), lstObject.get(19));
						Extent_Reports.executionLog("PASS", "Clip description should be displayed as:" + Showname.get(6).getAttribute("label") + "\n"
								+ " Clip description is displayed " , driver);
					}else {
						Extent_Reports.executionLog("FAIL", "Clip description should be displayed as:" + Showname.get(6).getAttribute("label") + "\n"
								+ " Clip description is not displayed " , driver);
					}
					
					ShowThumbnailImage.get(0).click();
					Thread.sleep(30000);
					WebElement VideoPlayArea=Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
					VideoPlayArea.click();

					WebElement VideoClosebtn=Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
					if(VideoClosebtn.isDisplayed())
					{
						Extent_Reports.executionLog("PASS", "Episode video should be displayed" + "\n"
								+ " Episode video is displayed " , driver);

					}
					else {
						Extent_Reports.executionLog("FAIL", "Episode video should be displayed" + "\n"
								+ " Episode video is displayed " , driver);

					}

				}
				else {

					Extent_Reports.executionLog("FAIL", "Episode thumbnail should be displayed " + "\n"
							+ " Episode thumbnail is not displayed " , driver);
				}


			}else {

				Extent_Reports.executionLog("FAIL", "Search Icon should be displayed" + "\n"
						+ "Search Icon is not displayed", driver);
			}



		}



		catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_example"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM
	
	
	public void android_Search_NAF_3540() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			PGNbcApp App = new PGNbcApp(driver);
			App.android_WaitForAppToLoad();
			App.android_DismissCastOverlay();
			
			/*PGAndroidApp app = new PGAndroidApp(driver);
			app.android_OpenMenu("SEARCH"); */
			
			String CW_Show = null;
			
			WebElement Menu = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
    		Menu.click();
			Thread.sleep(4000);
			List <WebElement> Search = Utilities.returnElements(driver, lstObject.get(80), lstObject.get(79));
    		Search.get(3).click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", "Should be navigated to Search Page " + "\n" + Extent_Reports.logActual + " Navigated to Search Page " , driver);
			
			WebElement Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
					//driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.EditText"));
			
			if (Search_field.isEnabled()){
				Extent_Reports.executionLog("PASS", "Seach Text field should be displayed :"+ Search_field.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Seach Text field is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Seach Text field should be displayed :"+ Search_field.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Seach Text field is not displayed " , driver);
			}
			
			List<WebElement> Featured_shows_text = Utilities.returnElements(driver, lstObject.get(32), lstObject.get(31));
					//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView"));
			
			if (Featured_shows_text.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Featured shows text should be displayed :"+ Featured_shows_text.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Featured shows text is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Featured shows text should be displayed :"+ Featured_shows_text.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Featured shows text is not displayed " , driver);
			}

			List<WebElement> show_item_container = Utilities.returnElements(driver, lstObject.get(35), lstObject.get(34));
					//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[contains(@resource-id,'show_item_container')]/android.widget.TextView"));

			for (int i=0;i<=show_item_container.size()-1;i++){
				if (show_item_container.get(i).isEnabled()){
					Extent_Reports.executionLog("PASS", "Default shows should be displayed :"+ show_item_container.get(i).getAttribute("text") + "\n"
							+ Extent_Reports.logActual + " Default shows is displayed " , driver);
				}else{
					Extent_Reports.executionLog("FAIL", "Default shows should be displayed :"+ show_item_container.get(i).getAttribute("text") + "\n"
							+ Extent_Reports.logActual + " Default shows is not displayed " , driver);
				}
			}
			
			Search_field = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
					//driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.EditText"));
			Search_field.sendKeys(lstTestData.get(2));
			Thread.sleep(5000);
			WebElement Invalid_text = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
					//driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.TextView"));
			if (Invalid_text.isEnabled()){
				Extent_Reports.executionLog("PASS", "Invalid text should be displayed :"+ Invalid_text.getAttribute("text") + "\n"
						 + Extent_Reports.logActual+ " Invalid_text is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Invalid text should be displayed :"+ Invalid_text.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Invalid text is not displayed " , driver);
			}
			
			if (Invalid_text.getAttribute("text").contains("Sorry, there are no results")){
				Extent_Reports.executionLog("PASS", "Sorry, there are no results for . You can search for shows or episodes. Do you want to check out our popular shows? text message shuld be displayed" + "\n"
						+ Extent_Reports.logActual + "Sorry, there are no results for . You can search for shows or episodes. Do you want to check out our popular shows? text message is displayed" , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Sorry, there are no results for . You can search for shows or episodes. Do you want to check out our popular shows? text message shuld be displayed" + "\n"
						+ Extent_Reports.logActual + "Sorry, there are no results for . You can search for shows or episodes. Do you want to check out our popular shows? text message is not displayed" , driver);
			}
			
			List<WebElement> Recommended_Shows  = Utilities.returnElements(driver, lstObject.get(44), lstObject.get(43));
					//driver.findElements(By.xpath("//android.widget.LinearLayout/android.widget.TextView"));
			for (int i=0;i<=Recommended_Shows.size()-1;i++){
				if (Recommended_Shows.get(i).isEnabled()){
					Extent_Reports.executionLog("PASS", "Recommended shows should be displayed :"+ Recommended_Shows.get(i).getAttribute("text") + "\n"
							+ Extent_Reports.logActual + " Recommended shows is displayed " , driver);
				}else{
					Extent_Reports.executionLog("FAIL", "Recommended shows should be displayed :"+ Recommended_Shows.get(i).getAttribute("text") + "\n"
							+ Extent_Reports.logActual + " Recommended shows is not displayed " , driver);
				}
			}
			
			
			
			WebElement X_icon = Utilities.returnElement(driver, lstObject.get(62), lstObject.get(61));
			//driver.findElement(By.xpath("//android.widget.FrameLayout[contains(@resource-id,'clear_search_text_button')]"));
			if (X_icon.isEnabled()){
				Extent_Reports.executionLog("PASS", "X icon should be displayed :" + "\n"
						+ Extent_Reports.logActual + " X icon is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Invalid text should be displayed :" + "\n"
						+ Extent_Reports.logActual + " X icon is not displayed " , driver);
			}
			
			X_icon.clear();
			Thread.sleep(3000);
			Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
				
			if (Search_field.isEnabled()){
				if (Search_field.getAttribute("text").contains("What are you looking for?")){
				Extent_Reports.executionLog("PASS", "Invalid Seach Text should be cleared :"+ Search_field.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Invalid Seach Text should be cleared " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Invalid Seach Text should be cleared :"+ Search_field.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Invalid Seach Text should be cleared " , driver);
			}
			}
						
			Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
			Search_field.sendKeys(lstTestData.get(3));
			Thread.sleep(5000);
			List<WebElement> We_found_text_message = Utilities.returnElements(driver, lstObject.get(59), lstObject.get(58));
					//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"));
			if (We_found_text_message.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is not displayed " , driver);
			}
			
			String shows = We_found_text_message.get(0).getAttribute("text");
			String[] Subtitle = shows.split(" ");
			
			if (Integer.valueOf(Subtitle[2]) == 1) {
                if (Subtitle[4].equalsIgnoreCase("result")) {
                    Extent_Reports.executionLog("PASS",
                            Extent_Reports.logExpected + "We found " + "[x] " + "related result should be displayed "
                                    + Extent_Reports.logActual + "We found " + Subtitle[2] + "related "
                                    + Subtitle[4] + " is displayed",
                            driver);
                } else {
                    Extent_Reports.executionLog("PASS",
                            Extent_Reports.logExpected + "We found " + "[x] " + "related result should be displayed "
                                    + Extent_Reports.logActual + "We found " + Subtitle[2] + "related "
                                    + Subtitle[4] + " is be displayed",
                            driver);
                }
            } else if (Integer.valueOf(Subtitle[2]) > 1) {
                if (Subtitle[4].equalsIgnoreCase("results")) {
                    Extent_Reports.executionLog("PASS",
                            Extent_Reports.logExpected + "We found " + "[x] " + "related results should be displayed "
                                    + Extent_Reports.logActual + "We found " + Subtitle[2] + "related "
                                    + Subtitle[4] + "is displayed",
                            driver);
                } else {
                    Extent_Reports.executionLog("PASS",
                            Extent_Reports.logExpected + "We found " + "[x] " + "related results should be displayed "
                                    + Extent_Reports.logActual + "We found " + Subtitle[2] + "related "
                                    + Subtitle[4]+ " is displayed",
                            driver);
                }
            } else {
                Extent_Reports.executionLog("PASS",
                        Extent_Reports.logExpected + "We found " + "[x] " + "related result should be displayed "
                                + Extent_Reports.logActual + "We found " + Subtitle[2] + "RELATED " + "[x]"
                                + "results Subtitle is not Displayed. ",
                        driver);
            }
			
			WebElement Show_Name = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
					//driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'show_name')]"));
			if (Show_Name.isEnabled()){
				Extent_Reports.executionLog("PASS", "Show Name should be displayed :"+ Show_Name.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Show Name is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Show Name should be displayed :"+ Show_Name.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Show Name text is not displayed " , driver);
			}
			
			List<WebElement> episode_image = Utilities.returnElements(driver, lstObject.get(50), lstObject.get(49));
					//driver.findElements(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[contains(@resource-id,'episode_image')]"));
			if (episode_image.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Episode image should be displayed :" + "\n"
						+ Extent_Reports.logActual + " Episode image is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Episode image should be displayed :" + "\n"
						+ Extent_Reports.logActual + "Episode image is not displayed " , driver);
			}
			
			List<WebElement> season_episode = Utilities.returnElements(driver, lstObject.get(53), lstObject.get(52));
					//driver.findElements(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[contains(@resource-id,'season_episode')]"));
			if (season_episode.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Season episode meta data should be displayed and is :" + season_episode.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Season episode meta data is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Season episode meta data should be displayed :" + season_episode.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + "Season episode meta data is not displayed " , driver);
			}
			
			List<WebElement> episode_date = Utilities.returnElements(driver, lstObject.get(56), lstObject.get(55));
					//driver.findElements(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[contains(@resource-id,'episode_date')]"));
			if (episode_date.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Episode date meta data should be displayed and is :" + episode_date.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Episode date meta data is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Episode date meta data should be displayed :" + episode_date.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + "Episode date meta data is not displayed " , driver);
			}
			
			WebElement Show = Utilities.returnElement(driver, lstObject.get(86), lstObject.get(85));
			Show.click();
			Thread.sleep(10000);
			
            List<WebElement> Show_Name1 = Utilities.returnElements(driver, lstObject.get(89), lstObject.get(88));
			String Show_Name2 = Show_Name1.get(0).getAttribute("text");
			if(lstTestData.get(3).equalsIgnoreCase(Show_Name2)){
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Navigated to expected show home page"
			            + Extent_Reports.logActual + "Navigated to show home page ", driver);
			}else{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Navigated to expected show home page"
			            + Extent_Reports.logActual + "Not Navigated to show home page  ", driver);
			}
			
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			
			WebElement Episode = Utilities.returnElement(driver, lstObject.get(92), lstObject.get(91));
			Episode.click();
			Thread.sleep(35000);
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode shpuld be displayed"
		            + Extent_Reports.logActual + "Episode is displayed ", driver);
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			
			X_icon.clear();
			Thread.sleep(3000);
			Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
				
			if (Search_field.isEnabled()){
				if (Search_field.getAttribute("text").contains("What are you looking for?")){
				Extent_Reports.executionLog("PASS", "Invalid Seach Text should be cleared :"+ Search_field.getAttribute("text") + "\n"
				 		+ Extent_Reports.logActual + " Invalid Seach Text should be cleared " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Invalid Seach Text should be cleared :"+ Search_field.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Invalid Seach Text should be cleared " , driver);
			}
			}
						
			Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
			Search_field.sendKeys(lstTestData.get(4));
			Thread.sleep(5000);
			List<WebElement> clipShow_Name = Utilities.returnElements(driver, lstObject.get(65), lstObject.get(64));
			//driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'show_name')]"));
			if (clipShow_Name.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Show Name should be displayed :"+ clipShow_Name.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Show Name is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Show Name should be displayed :"+ clipShow_Name.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Show Name text is not displayed " , driver);
			}
			
			List<WebElement> clip_title = Utilities.returnElements(driver, lstObject.get(68), lstObject.get(67));
			//driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'show_name')]"));
			if (clip_title.get(0).isEnabled()){
				if (clip_title.get(0).getAttribute("text").contains(lstTestData.get(4))){
				Extent_Reports.executionLog("PASS", "Clip name should be displayed and matched with text data :"+ clip_title.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Clip name is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "clip should be displayed matched with text data :"+ clip_title.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Clip name is not displayed " , driver);
			}
		}
			
			We_found_text_message = Utilities.returnElements(driver, lstObject.get(59), lstObject.get(58));
			//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"));
			if (We_found_text_message.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is not displayed " , driver);
			}
	
			String shows1 = We_found_text_message.get(0).getAttribute("text");
			String[] Subtitle1 = shows1.split(" ");
	
			if (Integer.valueOf(Subtitle1[2]) == 1) {
				if (Subtitle1[4].equalsIgnoreCase("result")) {
					Extent_Reports.executionLog("PASS",
							Extent_Reports.logExpected + "We found " + "[x] " + "related result should be displayed "
                            + Extent_Reports.logActual + "We found " + Subtitle1[2] + "related "
                            + Subtitle1[4] + " is displayed",
                    driver);
				} else {
					Extent_Reports.executionLog("FAIL",
							Extent_Reports.logExpected + "We found " + "[x] " + "related result should be displayed "
                            + Extent_Reports.logActual + "We found " + Subtitle1[2] + "related "
                            + Subtitle1[4] + " is displayed",
                            driver);
				}
				} else if (Integer.valueOf(Subtitle1[2]) > 1) {
				if (Subtitle1[4].equalsIgnoreCase("results")) {
					Extent_Reports.executionLog("PASS",
                    Extent_Reports.logExpected + "We found " + "[x] " + "related results should be displayed "
                            + Extent_Reports.logActual + "We found " + Subtitle1[2] + "related "
                            + Subtitle1[4] + " is displayed",
                    driver);
				} else {
					Extent_Reports.executionLog("FAIL",
                    Extent_Reports.logExpected + "We found " + "[x] " + "related results should be displayed "
                            + Extent_Reports.logActual + "We found " + Subtitle1[2] + "related "
                            + Subtitle1[4] + " is be displayed",
                    driver);
				}
				} else {
				Extent_Reports.executionLog("FAIL",  Extent_Reports.logExpected + "We found " + "[x] " + "related result should be displayed "
                        + Extent_Reports.logActual + "We found " + Subtitle1[2] + "RELATED " + "[x]" + "results Subtitle is not Displayed. ",
                driver);
				}
			    
			
				WebElement clip = Utilities.returnElement(driver, lstObject.get(83), lstObject.get(82));
				clip.click();
				Thread.sleep(35000);
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video content should be displayed "
                + Extent_Reports.logActual + "Video content is  displayed ", driver);
                ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				
                Menu = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
			    	
			    Menu.click();
			    Thread.sleep(4000);
			    Search = Utilities.returnElements(driver, lstObject.get(80), lstObject.get(79));
			    		
			    Search.get(0).click();
			    Thread.sleep(6000);
			    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + " Navigated to Global Home Page " + Extent_Reports.logActual + "Navigated to Global Home Page" , driver);
			
				List<WebElement> Continue_Watching = Utilities.returnElements(driver, lstObject.get(71), lstObject.get(70));
				if (Continue_Watching.get(0).isEnabled()){
					Extent_Reports.executionLog("PASS",
			                Extent_Reports.logExpected + "Continue Watching sections should be displayed "
			                        + Extent_Reports.logActual + "Continue Watching sections is displayed ", driver);
					List<WebElement> CW_Show_Titile = Utilities.returnElements(driver, lstObject.get(74), lstObject.get(73));
					CW_Show = CW_Show_Titile.get(0).getAttribute("text");
					Extent_Reports.executionLog("PASS",
			                Extent_Reports.logExpected + "Continue Watching Episode Name should be displayed " + CW_Show_Titile.get(0).getAttribute("text")
			                        + Extent_Reports.logActual + "Continue Watching Episode Name is displayed " + CW_Show_Titile.get(0).getAttribute("text") ,driver);
					
				}else {

					Extent_Reports.executionLog("INFO",
			                Extent_Reports.logExpected + "Continue Watching sections should be displayed "
			                        + Extent_Reports.logActual + "Continue Watching sections is not displayed ", driver);
				}
				
				Menu.click();
			    Thread.sleep(4000);
			    Search = Utilities.returnElements(driver, lstObject.get(80), lstObject.get(79));
			    		//driver.findElements(By.xpath("//android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView[contains(@resource-id,'menu_icon')]"));
			    Search.get(3).click();
			    Thread.sleep(6000);
			    Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + " Navigated to Global Home Page " + Extent_Reports.logActual + "Navigated to Global Home Page" , driver);
			
								
			Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
			Search_field.sendKeys(CW_Show);
			Thread.sleep(5000);
			
			We_found_text_message = Utilities.returnElements(driver, lstObject.get(59), lstObject.get(58));
			//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"));
			if (We_found_text_message.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is not displayed " , driver);
			}
	
			String shows2 = We_found_text_message.get(0).getAttribute("text");
			String[] Subtitle2 = shows2.split(" ");
	
			if (Integer.valueOf(Subtitle2[2]) == 1) {
				if (Subtitle2[4].equalsIgnoreCase("result")) {
					Extent_Reports.executionLog("PASS",
							Extent_Reports.logExpected + "We found " + "[x] " + "related result should be displayed "
                            + Extent_Reports.logActual + "We found " + Subtitle2[2] + "related "
                            + Subtitle2[4] + " is displayed",
                    driver);
				} else {
					Extent_Reports.executionLog("FAIL",
							Extent_Reports.logExpected + "We found " + "[x] " + "related result should be displayed "
                            + Extent_Reports.logActual + "We found " + Subtitle2[2] + "related "
                            + Subtitle2[4] + " is displayed",
                            driver);
				}
				} else if (Integer.valueOf(Subtitle2[2]) > 1) {
				if (Subtitle2[4].equalsIgnoreCase("results")) {
					Extent_Reports.executionLog("PASS",
                    Extent_Reports.logExpected + "We found " + "[x] " + "related results should be displayed "
                            + Extent_Reports.logActual + "We found " + Subtitle2[2] + "related "
                            + Subtitle2[4] + " is displayed",
                    driver);
				} else {
					Extent_Reports.executionLog("FAIL",
                    Extent_Reports.logExpected + "We found " + "[x] " + "related results should be displayed "
                            + Extent_Reports.logActual + "We found " + Subtitle2[2] + "related "
                            + Subtitle2[4] + " is be displayed",
                    driver);
				}
				} else {
				Extent_Reports.executionLog("FAIL",
                Extent_Reports.logExpected + "We found " + "[x] " + "related result should be displayed "
                        + Extent_Reports.logActual + "We found " + Subtitle2[2] + "RELATED " + "[x]"
                        + "results Subtitle is not Displayed. ",
                driver);
				}
			
			
			
		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "Android_SearchFor_NIR_3450"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM
	
	
	
		
	
	
	public void android_Search_index_NAF_5968() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			PGNbcApp App = new PGNbcApp(driver);
			App.android_WaitForAppToLoad();
			App.android_DismissCastOverlay();
			
			/*PGAndroidApp app = new PGAndroidApp(driver);
			app.android_OpenMenu("SEARCH"); */
			
			WebElement Menu = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
    		Menu.click();
			Thread.sleep(4000);
			List <WebElement> Search = Utilities.returnElements(driver, lstObject.get(80), lstObject.get(79));
    		Search.get(3).click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", "Should be navigated to Search Page " + "\n" + Extent_Reports.logActual + " Navigated to Search Page " , driver);
						
			WebElement Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
					//driver.findElement(By.xpath("//android.view.ViewGroup/android.widget.EditText"));
			
			if (Search_field.isEnabled()){
				Extent_Reports.executionLog("PASS", "Seach Text field should be displayed :"+ Search_field.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Seach Text field is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Seach Text field should be displayed :"+ Search_field.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Seach Text field is not displayed " , driver);
			}
			
			List<WebElement> Featured_shows_text = Utilities.returnElements(driver, lstObject.get(32), lstObject.get(31));
					//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.TextView"));
			
			if (Featured_shows_text.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Featured shows text should be displayed :"+ Featured_shows_text.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Featured shows text is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Featured shows text should be displayed :"+ Featured_shows_text.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Featured shows text is not displayed " , driver);
			}

			List<WebElement> show_item_container = Utilities.returnElements(driver, lstObject.get(35), lstObject.get(34));
					//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[contains(@resource-id,'show_item_container')]/android.widget.TextView"));

			for (int i=0;i<=show_item_container.size()-1;i++){
				if (show_item_container.get(i).isEnabled()){
					Extent_Reports.executionLog("PASS", "Default shows should be displayed :"+ show_item_container.get(i).getAttribute("text") + "\n"
							+ Extent_Reports.logActual + " Default shows is displayed " , driver);
				}else{
					Extent_Reports.executionLog("FAIL", "Default shows should be displayed :"+ show_item_container.get(i).getAttribute("text") + "\n"
							+ Extent_Reports.logActual + " Default shows is not displayed " , driver);
				}
			}
			
									
			Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
			Search_field.sendKeys(lstTestData.get(3));
			Thread.sleep(5000);
			List<WebElement> We_found_text_message = Utilities.returnElements(driver, lstObject.get(59), lstObject.get(58));
					//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"));
			if (We_found_text_message.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is not displayed " , driver);
			}
			
			
			
			WebElement Show_Name = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
					//driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'show_name')]"));
			if (Show_Name.isEnabled()){
				Extent_Reports.executionLog("PASS", "Show Name should be displayed :"+ Show_Name.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Show Name is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Show Name should be displayed :"+ Show_Name.getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Show Name text is not displayed " , driver);
			}
			
			List<WebElement> episode_image = Utilities.returnElements(driver, lstObject.get(50), lstObject.get(49));
					//driver.findElements(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView[contains(@resource-id,'episode_image')]"));
			if (episode_image.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Episode image should be displayed :" + "\n"
						+ Extent_Reports.logActual + " Episode image is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Episode image should be displayed :" + "\n"
						+ Extent_Reports.logActual + "Episode image is not displayed " , driver);
			}
			
			List<WebElement> season_episode = Utilities.returnElements(driver, lstObject.get(53), lstObject.get(52));
					//driver.findElements(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[contains(@resource-id,'season_episode')]"));
			if (season_episode.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Season episode meta data should be displayed and is :" + season_episode.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Season episode meta data is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Season episode meta data should be displayed :" + season_episode.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + "Season episode meta data is not displayed " , driver);
			}
			
			List<WebElement> episode_date = Utilities.returnElements(driver, lstObject.get(56), lstObject.get(55));
					//driver.findElements(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView[contains(@resource-id,'episode_date')]"));
			if (episode_date.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Episode date meta data should be displayed and is :" + episode_date.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Episode date meta data is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Episode date meta data should be displayed :" + episode_date.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + "Episode date meta data is not displayed " , driver);
			}
			
			WebElement Episode = Utilities.returnElement(driver, lstObject.get(95), lstObject.get(94));
			String Episode_title = Episode.getAttribute("text");
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode title should be dispalyed and is: " + Episode.getAttribute("text")
		            + Extent_Reports.logActual + "Episode title is dispalyed and is: " + Episode.getAttribute("text"), driver);
			
			WebElement Show = Utilities.returnElement(driver, lstObject.get(86), lstObject.get(85));
			Show.click();
			Thread.sleep(10000);
			
            List<WebElement> Show_Name1 = Utilities.returnElements(driver, lstObject.get(89), lstObject.get(88));
			String Show_Name2 = Show_Name1.get(0).getAttribute("text");
			if(lstTestData.get(3).equalsIgnoreCase(Show_Name2)){
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Navigated to expected show home page"
			            + Extent_Reports.logActual + "Navigated to show home page ", driver);
			}else{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Navigated to expected show home page"
			            + Extent_Reports.logActual + "Not Navigated to show home page  ", driver);
			}
			
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(10000);
			WebElement X_icon = Utilities.returnElement(driver, lstObject.get(62), lstObject.get(61));
			X_icon.clear();
			Thread.sleep(2000);
			Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
			Search_field.sendKeys(Episode_title);
			Thread.sleep(20000);
			WebElement Episode1 = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
			String Episode_title_after_search = Episode1.getAttribute("text");
			if (Episode_title.equals(Episode_title_after_search)){
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Should be navigated to Episode page and episode title is: " + Episode1.getAttribute("text")
		            + Extent_Reports.logActual + "navigated to Episode page and episode title is: " + Episode1.getAttribute("text"), driver);
			}else{
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Should be navigated to Episode page and episode title is: " + Episode1.getAttribute("text")
	            + Extent_Reports.logActual + "Not navigated to Episode page and episode title is: " + Episode1.getAttribute("text"), driver);
			}
			
			We_found_text_message = Utilities.returnElements(driver, lstObject.get(59), lstObject.get(58));
			//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"));
			if (We_found_text_message.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is not displayed " , driver);
			}
			
			X_icon.clear();
			Thread.sleep(2000);
			Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
			Search_field.sendKeys(lstTestData.get(4));
			Thread.sleep(20000);
			List<WebElement> clipShow_Name = Utilities.returnElements(driver, lstObject.get(65), lstObject.get(64));
			//driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'show_name')]"));
			if (clipShow_Name.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "Show Name should be displayed :"+ clipShow_Name.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Show Name is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Show Name should be displayed :"+ clipShow_Name.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Show Name text is not displayed " , driver);
			}
			
			List<WebElement> clip_title = Utilities.returnElements(driver, lstObject.get(68), lstObject.get(67));
			//driver.findElement(By.xpath("//android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout/android.widget.TextView[contains(@resource-id,'show_name')]"));
			if (clip_title.get(0).isEnabled()){
				if (clip_title.get(0).getAttribute("text").contains(lstTestData.get(4))){
				Extent_Reports.executionLog("PASS", "Clip name should be displayed and matched with text data :"+ clip_title.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Clip name is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "clip should be displayed matched with text data :"+ clip_title.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " Clip name is not displayed " , driver);
			}
		}
			
			We_found_text_message = Utilities.returnElements(driver, lstObject.get(59), lstObject.get(58));
			//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"));
			if (We_found_text_message.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is not displayed " , driver);
			}
	
			X_icon = Utilities.returnElement(driver, lstObject.get(62), lstObject.get(61));
			X_icon.clear();
			Thread.sleep(2000);
			Search_field = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
			Search_field.sendKeys(lstTestData.get(5));
			Thread.sleep(20000);	
			We_found_text_message = Utilities.returnElements(driver, lstObject.get(59), lstObject.get(58));
			//driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.view.ViewGroup/android.widget.TextView"));
			if (We_found_text_message.get(0).isEnabled()){
				Extent_Reports.executionLog("PASS", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "We found text message should be displayed :"+ We_found_text_message.get(0).getAttribute("text") + "\n"
						+ Extent_Reports.logActual + " We found text message is not displayed " , driver);
			}
			
			Show_Name = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
			
			if (Show_Name.isEnabled()){
				Extent_Reports.executionLog("PASS", "Show Name should be displayed :"+ Show_Name.getAttribute("text") + "\n"
				+ Extent_Reports.logActual + " Show Name is displayed " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", "Show Name should be displayed :"+ Show_Name.getAttribute("text") + "\n"
				+ Extent_Reports.logActual + " Show Name text is not displayed " , driver);
			}
			
			Episode = Utilities.returnElement(driver, lstObject.get(95), lstObject.get(94));
			if (Episode.isEnabled()){
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Episode title should be dispalyed and is: " + Episode.getAttribute("text")
		            + Extent_Reports.logActual + "Episode title is dispalyed and is: " + Episode.getAttribute("text"), driver);
			}else{
				Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Episode title should be dispalyed and is: " + Episode.getAttribute("text")
	            + Extent_Reports.logActual + "Episode title is not dispalyed and is: " + Episode.getAttribute("text"), driver);
			}
			
			WebElement Clip_title = Utilities.returnElement(driver, lstObject.get(68), lstObject.get(67));
			if (Clip_title.isEnabled()){
				Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Clip title should be dispalyed and is: " + Clip_title.getAttribute("text")
			            + Extent_Reports.logActual + "Clip title is dispalyed and is: " + Episode.getAttribute("text"), driver);
				}else{
					Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + "Clip title should be dispalyed and is: " + Clip_title.getAttribute("text")
		            + Extent_Reports.logActual + "Clip title is not dispalyed and is: " + Episode.getAttribute("text"), driver);
				}
			
			
		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "Android_SearchFor_NIR_3450"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM
	

}//EOC
