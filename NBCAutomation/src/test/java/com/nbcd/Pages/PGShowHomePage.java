package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import com.nbcd.Pages.PGNbcApp;

public class PGShowHomePage {
	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> objShowLists, objShowList;
	String sqlQry, Status;
	WebElement objnav, objRespNavBar, objloading, objClipDropDownWebEx, objShowLink, CastIcon, about, showeditorial,
	season, CastPopUp, vodtap, aboutHeadline, readmore, ShowName, showinfo, marketingSignupbtn,
	marketingSigninHyp, marktngPopuptxt, marktngsgnintxt, ShowsMenu, EpisodeVideo, ad, HambergerIcon, playPause,
	GoToShow;

	// Constructor to initialize all the Page Objects
	public PGShowHomePage(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGShowHomePage", "Input");
		lstObject = db.getTestDataObject("Select * from PGShowHomePage", "ObjectRepository");
	}

	@Test
	public void android_VerifyPromptOnFavoritingShow_NAF_4646() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			try {

				PGNbcApp App = new PGNbcApp(driver);
				App.android_WaitForAppToLoad();
				App.android_DismissCastOverlay();
				App.android_OpenShow(lstTestData.get(4));

			} catch (Exception e) {

				Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
						driver);
				Thread.sleep(10000);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(46))));
			WebElement heartIcon = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
			if (heartIcon.isDisplayed()) {
				heartIcon.click();
				Thread.sleep(10000);
				Extent_Reports.executionLog("PASS", "Better Late Than Never should be marked as favorite " + "\n"
						+ "Better Late Than Never Show is marked as favorite", driver);
				try {

					marketingSignupbtn = Utilities.returnElement(driver, lstObject.get(59), lstObject.get(58));
					marketingSigninHyp = Utilities.returnElement(driver, lstObject.get(62), lstObject.get(61));
					marktngPopuptxt = Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
					marktngsgnintxt = Utilities.returnElement(driver, lstObject.get(68), lstObject.get(67));

					if (marketingSignupbtn.isDisplayed() && marketingSigninHyp.isDisplayed()
							&& lstTestData.get(0).equalsIgnoreCase(marktngPopuptxt.getText())
							&& lstTestData.get(0).equalsIgnoreCase(marktngsgnintxt.getText())) {
						Extent_Reports.executionLog("PASS", "Favorites marketing Pop-up should be Displayed " + "\n"
								+ "Favorites marketing Pop-up is Displayed", driver);
					} else {
						Extent_Reports.executionLog("FAIL", "Favorites marketing Pop-up should be Displayed " + "\n"
								+ "Favorites marketing Pop-up is not Displayed", driver);
					}
				} catch (Exception e) {
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				}

			} else {
				Extent_Reports.executionLog("FAIL", "Better Late Than Never should be marked as favorite " + "\n"
						+ "Better Late Than Never Show is not marked as favorite", driver);
			}

			Thread.sleep(10000);

		} catch (Exception e) {
			Extent_Reports.executionLog("INFO", "android_VerifyPromptOnFavoritingShow_NAF_4646" + "\n" + e.getMessage(),
					driver);
		}
	}// EOM

	public void android_VerifyAboutinShowHomepage_NAF_3358() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			try {

				PGNbcApp App1 = new PGNbcApp(driver);
				App1.android_WaitForAppToLoad();
				App1.android_DismissCastOverlay();
				//App1.android_OpenShowsMenu();
				App1.android_OpenShow(lstTestData.get(4).trim());

			} catch (Exception e) {

				Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
						driver);
				Thread.sleep(10000);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(70))));
			// Synchronization.ExplicitWait(driver, lstObject.get(71),
			// "visible");
			about = Utilities.returnElement(driver, lstObject.get(71), lstObject.get(70));
			if (about.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						"About icon should be displayed " + "\n" + "About icon is displayed on show Home Page", driver);
				about.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS", "Clicking on About icon it should display the info related to show "
						+ "\n" + "Clicking on About icon info related to show is displayed ", driver);

				try {
					// Synchronization.ExplicitWait(driver, lstObject.get(74),
					// "visible");
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(73))));
					aboutHeadline = Utilities.returnElement(driver, lstObject.get(74), lstObject.get(73));
					readmore = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
					showinfo = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));
					showeditorial = Utilities.returnElement(driver, lstObject.get(83), lstObject.get(82));

					// if(aboutHeadline.isDisplayed()){
					/*
					 * TouchAction action = new
					 * TouchAction((AppiumDriver)driver);
					 * //action.press(showeditorial).moveTo(showinfo).release();
					 * 
					 * 
					 * 
					 * }
					 */
					if (aboutHeadline.isDisplayed() && readmore.isDisplayed()
							&& lstObject.get(2).contains(showinfo.getText())) {
						Extent_Reports
						.executionLog(
								"PASS", "Clicking on About icon it should display the info related to show "
										+ "\n" + "Clicking on About icon info related to show is displayed ",
										driver);
					} else {
						Extent_Reports
						.executionLog("FAIL",
								"Clicking on About icon it should display the info related to show " + "\n"
										+ "Clicking on About icon info related to show is not displayed ",
										driver);
					}
					// Need to Swipe to check read less button availability
					if (readmore.isDisplayed()) {
						readmore.click();

						try {
							Dimension size = driver.manage().window().getSize();
							int starty = (int) (size.height * 0.60);
							int endy = (int) (size.height * 0.20);
							int startx = size.width / 2;

							System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
							TouchAction touchAction = new TouchAction(driver);
							touchAction.press(startx, endy).moveTo(startx, starty).release().perform();
							// touchAction.press(540, 410).moveTo(540,
							// 1590).release().perform();
							// 540, 1590 540, 410

							Thread.sleep(2000);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println(e);
						}
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			} else {
				Extent_Reports.executionLog("FAIL",
						"About icon should be displayed " + "\n" + "About icon is not displayed", driver);
			}

			// }
			Thread.sleep(10000);

		} catch (Exception e) {
			Extent_Reports.executionLog("INFO",
					"TCAndroid_Settings_TVproviderAuthentication_NAF_3546" + "\n" + e.getMessage(), driver);
		}
	}

	public void android_VerifySeasonShelfinShowHomepage_NAF_3741() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			PGNbcApp App = new PGNbcApp(driver);
			App.android_WaitForAppToLoad();

			App.android_OpenShow(lstTestData.get(3).trim());
			// Validating Season Shelf for a Show in Current
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(88))));
			season = Utilities.returnElement(driver, lstObject.get(89), lstObject.get(88));
			if (season.isDisplayed()) {
				List<WebElement> seasonShelf = Utilities.returnElements(driver, lstObject.get(92), lstObject.get(91));
				System.out.println(seasonShelf);
				System.out.println(seasonShelf.size());
				for (int i = 1; i <= seasonShelf.size(); i++) {
					if (seasonShelf.get(i).getText().equalsIgnoreCase("1")
							|| seasonShelf.get(i).getText().equalsIgnoreCase("2")
							|| seasonShelf.get(i).getText().equalsIgnoreCase("3")
							|| seasonShelf.get(i).getText().equalsIgnoreCase("4")
							|| seasonShelf.get(i).getText().equalsIgnoreCase("5")) {
						seasonShelf.get(i).click();
						Extent_Reports.executionLog("PASS", "season Shelf should be displayed and clickable" + "\n"
								+ "season Headline is displayed and clickable on show Home Page", driver);
					}

				}

			} else {
				Extent_Reports.executionLog("FAIL",
						"season Headline should be displayed " + "\n" + "season Headline is not displayed", driver);
			}



		} catch (Exception e) {
			Extent_Reports.executionLog("INFO",
					"TCAndroid_ShowHomePage_android_VerifySeasonShelfinShowHomepage_NAF_3741" + "\n" + e.getMessage(),
					driver);
		}
	}
	public void android_category_labels_All_shows_page_NAF_3354() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			PGNbcApp App = new PGNbcApp(driver);
			App.android_WaitForAppToLoad();
			App.android_DismissCastOverlay();

			WebElement Menu = Utilities.returnElement(driver, lstObject.get(95), lstObject.get(94));
			Menu.click();
			Thread.sleep(6000);
			List <WebElement> Shows = Utilities.returnElements(driver, lstObject.get(98), lstObject.get(97));
			Shows.get(1).click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to ShowHome Page " + "\n" + Extent_Reports.logActual + " Navigated to ShowHome Page " , driver);

			WebElement CURRENT_Shows = Utilities.returnElement(driver, lstObject.get(101), lstObject.get(100));
			if (CURRENT_Shows.isSelected()){
				App.swipeUp();
				Thread.sleep(1000);
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Current Show Header should be focused after scroll down" + "\n" + Extent_Reports.logActual + " Current Show Header is focused after scroll down " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ "Current Show Header should be focused after scroll down " + "\n" + Extent_Reports.logActual + " Current Show Header is not focused after scroll down " , driver);
			}

			WebElement THROWBACK_Shows = Utilities.returnElement(driver, lstObject.get(104), lstObject.get(103));
			THROWBACK_Shows.click();
			Thread.sleep(10000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to THROWBACK Shows Page " + "\n" + Extent_Reports.logActual + " Navigated to THROWBACK Shows Page " , driver);
			WebElement THROWBACK_Shows_selected = Utilities.returnElement(driver, lstObject.get(107), lstObject.get(106));
			if (THROWBACK_Shows_selected.isSelected()){
				App.swipeUp();
				Thread.sleep(1000);
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Current Show Header should be focused after scroll down" + "\n" + Extent_Reports.logActual + " Current Show Header is focused after scroll down " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ "Current Show Header should be focused after scroll down " + "\n" + Extent_Reports.logActual + " Current Show Header is not focused after scroll down " , driver);
			}

			WebElement ALL_Shows = Utilities.returnElement(driver, lstObject.get(110), lstObject.get(109));
			ALL_Shows.click();
			Thread.sleep(10000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to All Shows Page " + "\n" + Extent_Reports.logActual + " Navigated to All Shows Page " , driver);
			WebElement ALL_Shows_selected =Utilities.returnElement(driver, lstObject.get(113), lstObject.get(112));
			if (ALL_Shows_selected.isSelected()){
				App.swipeUp();
				Thread.sleep(1000);
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Current Show Header should be focused after scroll down" + "\n" + Extent_Reports.logActual + " Current Show Header is focused after scroll down " , driver);
			}else{
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ "Current Show Header should be focused after scroll down " + "\n" + Extent_Reports.logActual + " Current Show Header is not focused after scroll down " , driver);
			}

		} catch (Exception e) {
			Extent_Reports.executionLog("INFO",
					"android_category_labels_All_shows_page_NAF_3354" + "\n" + e.getMessage(),
					driver);
		}
	}//EOM


	public void android_VerifyClipsmetadatainShowHomepage_NAF_3364() throws Exception {
		PGNbcApp App1 = new PGNbcApp(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			try {


				App1.android_WaitForAppToLoad();
				App1.android_DismissCastOverlay();
				App1.android_OpenShow(lstTestData.get(5).trim());

			} catch (Exception e) {

				Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
						driver);
				Thread.sleep(10000);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(70))));

			about = Utilities.returnElement(driver, lstObject.get(71), lstObject.get(70));
			if (about.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						"About icon should be displayed " + "\n" + "About icon is displayed on show Home Page", driver);
				about.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS", "Clicking on About icon it should display the info related to show "
						+ "\n" + "Clicking on About icon info related to show is displayed ", driver);


				//Added New Code
				try 
				{
					for(int j=0;j<=1;j++) 
					{
						List<WebElement> ClipsNamesList = Utilities.returnElements(driver, lstObject.get(95), lstObject.get(94));
						List<WebElement> ClipsInfoList = Utilities.returnElements(driver, lstObject.get(98), lstObject.get(97));
						for (int i = 0; i < ClipsNamesList.size(); i++) 
						{
							String ClipName=  ClipsNamesList.get(i).getText();
							String Clipinfor=  ClipsInfoList.get(i).getText();

							Extent_Reports.executionLog("PASS", "Clips metada should be displayed" + "\n"
									+ "Clips metada should be displayed with name"+ClipName+" and info "+Clipinfor, driver);
						}
						if(j==0) 
						{
							try {
								//((AndroidDriver) driver).rotate(ScreenOrientation.LANDSCAPE);
								App1.rotateDeviceScreenToLandscape("LANDSCAPE");
							}
							catch(Exception e) {

							}
						}
					}

				} catch (Exception e) {
					System.out.println(e);
				}

			} else {
				Extent_Reports.executionLog("FAIL",
						"About icon should be displayed " + "\n" + "About icon is not displayed", driver);
			}



		} catch (Exception e) {
			Extent_Reports.executionLog("INFO",
					"android_VerifyClipsmetadatainShowHomepage_NAF_3364" + "\n" + e.getMessage(), driver);
		}
	}//EOM


	public void android_VerifyshowsmetadataFeatured_NAF3373() throws Exception {
		PGNbcApp App1 = new PGNbcApp(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			try {

				App1.android_WaitForAppToLoad();

				scrollDown(By.xpath(lstObject.get(100)));

				//List<WebElement> TrendingNowShowsList = Utilities.returnElements(driver, lstObject.get(104), lstObject.get(103));
				WebElement TrendingNowShowsList = Utilities.returnElement(driver, lstObject.get(104), lstObject.get(103));

				if(TrendingNowShowsList.isEnabled())
				{
					Extent_Reports.executionLog("PASS", "Trending show should be displayed" + "\n" + "Trending show is "+TrendingNowShowsList.getText() +" displayed",
							driver);

					TrendingNowShowsList.click();
				}
				else {
					Extent_Reports.executionLog("FAIL", "Trending show should be displayed" + "\n" + "Trending show is not displayed",
							driver);

				}

				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(106))));

				//	WebElement showFirstText = Utilities.returnElement(driver, lstObject.get(107), lstObject.get(106));
				//if (showFirstText.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						"Show home page should be displayed " + "\n" + "Show home page is displayed", driver);

				WebElement Navigateup = Utilities.returnElement(driver, lstObject.get(110), lstObject.get(109));
				Navigateup.click();
				Extent_Reports.executionLog("PASS",
						"App home page should be displayed " + "\n" + "App home page is displayed", driver);

				/*
				}
				else {
					Extent_Reports.executionLog("PASS",
							"Show home page should be displayed " + "\n" + "Show home page is not displayed", driver);


				}
				 */




			} catch (Exception e) {
				System.out.println(e);
				Extent_Reports.executionLog("FAIL", "Waiting for app to load" + "\n" + "Waiting for app to load",
						driver);

			}
		} catch (Exception e) {
			Extent_Reports.executionLog("INFO",
					"android_VerifyClipsmetadatainShowHomepage_NAF_3364" + "\n" + e.getMessage(), driver);
		}
	}//EOM



	public void android_VerifyShowArtinforinShowHomepage_NAF3360() throws Exception {
		PGNbcApp App1 = new PGNbcApp(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);


			App1.android_WaitForAppToLoad();
			App1.android_DismissCastOverlay();
			App1.android_OpenShow(lstTestData.get(6).trim());
			WebElement ShowTitle = Utilities.returnElement(driver, lstObject.get(50), lstObject.get(49));
			if(ShowTitle.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Show title should be displayed" + "\n" + "Show title is displayed with name "+ShowTitle.getText(),
						driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Show title should be displayed" + "\n" + "Show title is not displayed",
						driver);
			}
			WebElement EpisodeTitle = Utilities.returnElement(driver, lstObject.get(113), lstObject.get(112));
			if(EpisodeTitle.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Episodes section should be displayed" + "\n" + "Episodes section is displayed",
						driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Episodes section should be displayed" + "\n" + "Episodes section is not displayed",
						driver);
			}



			about = Utilities.returnElement(driver, lstObject.get(71), lstObject.get(70));
			if (about.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						"About icon should be displayed " + "\n" + "About icon is displayed on show Home Page", driver);
				about.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS", "Clicking on About icon it should display the info related to show "
						+ "\n" + "Clicking on About icon info related to show is displayed ", driver);


				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(73))));
				aboutHeadline = Utilities.returnElement(driver, lstObject.get(74), lstObject.get(73));


				if (aboutHeadline.isDisplayed() ) {
					Extent_Reports
					.executionLog(
							"PASS", "Clicking on About icon it should display the info related to show "
									+ "\n" + "Clicking on About icon info related to show is displayed ",
									driver);
				} else {
					Extent_Reports
					.executionLog("FAIL",
							"Clicking on About icon it should display the info related to show " + "\n"
									+ "Clicking on About icon info related to show is not displayed ",
									driver);
				}


			}

			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(10000);
			App1.android_OpenShow(lstTestData.get(6).trim());

			WebElement heartIcon = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
			if (heartIcon.isDisplayed()) {
				heartIcon.click();
				Thread.sleep(10000);
				Extent_Reports.executionLog("PASS", "Show should be marked as favorite " + "\n"
						+ " Show is marked as favorite", driver);
				try {

					marketingSignupbtn = Utilities.returnElement(driver, lstObject.get(59), lstObject.get(58));


					if (marketingSignupbtn.isDisplayed() ) {
						Extent_Reports.executionLog("PASS", "Favorites marketing Pop-up should be Displayed " + "\n"
								+ "Favorites marketing Pop-up is Displayed", driver);
						((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
					} else {
						Extent_Reports.executionLog("FAIL", "Favorites marketing Pop-up should be Displayed " + "\n"
								+ "Favorites marketing Pop-up is not Displayed", driver);
					}
				} catch (Exception e) {
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				}

			} else {
				Extent_Reports.executionLog("FAIL", "Show should be marked as favorite " + "\n"
						+ " Show is not marked as favorite", driver);
			}



			scrollDown(By.xpath(lstObject.get(115)));
			WebElement ClipsTitle = Utilities.returnElement(driver, lstObject.get(116), lstObject.get(115));
			if(ClipsTitle.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Clips section should be displayed" + "\n" + "Clips section is displayed",
						driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Clips section should be displayed" + "\n" + "Clips section is not displayed",
						driver);
			}






		} catch (Exception e) {
			Extent_Reports.executionLog("INFO",
					"android_VerifyShowArtinforinShowHomepage_NAF3360" + "\n" + e.getMessage(), driver);
		}
	}//EOM

	public void scrollDown(By Loc) {

		for(int i=0;i<10;i++) 
		{
			//if pressX was zero it didn't work for me
			int pressX = driver.manage().window().getSize().width / 2;
			// 4/5 of the screen as the bottom finger-press point
			int bottomY = driver.manage().window().getSize().height * 4/5;
			// just non zero point, as it didn't scroll to zero normally
			int topY = driver.manage().window().getSize().height / 8;
			//scroll with TouchAction by itself
			TouchAction touchAction = new TouchAction(driver);
			touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
			//	scroll(pressX, bottomY, pressX, topY);
			try {
				if(driver.findElement(Loc).isEnabled())
				{
					Extent_Reports.executionLog("PASS", "Scrlloed till the object is visible" + "\n" + "Scrlloed till the object is visible",
							driver);
					break;

				}
			}
			catch(Exception e) {

			}

		}

	}//EOM



	public void android_VerifyDynamicleadslidecarouselsCTAdestinations_NAF3377() throws Exception {
		try {


			PGNbcApp App1 = new PGNbcApp(driver);
			WebDriverWait wait = new WebDriverWait(driver, 50);
			Thread.sleep(30000);
			//App1.android_WaitForAppToLoad();
			//App1.android_DismissCastOverlay();
			
			for(int i=0;i<20;i++) 
			{
				try 
				{
					driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
					//Utilities.returnElement(driver, lstObject.get(125), lstObject.get(124)).click();;
					driver.findElement(By.xpath(lstObject.get(124))).click();
					Thread.sleep(10000);
					WebElement ShowName = Utilities.returnElement(driver, lstObject.get(50), lstObject.get(49));
					Extent_Reports.executionLog("PASS", "On clicking dynamic lead page with CTA having links to show page, Show home page should be displayed" + "\n" + "On clicking dynamic lead page with CTA having links to show page,"+ShowName.getText()+" Show home page is displayed" ,
							driver);
					WebElement Logo = Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
					Logo.click();
					Thread.sleep(10000);



				}
				catch(Exception e) {

				}

			}


			for(int i=0;i<20;i++) 
			{
				try 
				{
					WebElement WatchEpisode = Utilities.returnElement(driver, lstObject.get(119), lstObject.get(118));
					WatchEpisode.click();
					Thread.sleep(10000);
					if(Utilities.returnElement(driver, lstObject.get(122), lstObject.get(121)).isDisplayed())
					{
						WebElement Logo = Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
						Logo.click();
						Thread.sleep(10000);

					}
					else 
					{
						Thread.sleep(20000);
						Extent_Reports.executionLog("PASS", "On clicking dynamic lead page should play the particular video " + "\n" + "On clicking dynamic lead page video is played" ,
								driver);
						break;
					}


				}
				catch(Exception e) {
					Thread.sleep(20000);
					Extent_Reports.executionLog("PASS", "On clicking dynamic lead page should play the particular video " + "\n" + "On clicking dynamic lead page video is played" ,
							driver);
					break;

				}

			}

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		}

		catch(Exception e) {
			Extent_Reports.executionLog("INFO",
					"android_VerifyShowArtinforinShowHomepage_NAF3360" + "\n" + e.getMessage(), driver);
		}
	}//EOM


	public void android_VerifylistofshowsmetadataEpisodecollectionshelf_NAF3374() throws Exception {
		PGNbcApp App1 = new PGNbcApp(driver);
		try 
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			App1.android_WaitForAppToLoad();
			App1.android_DismissCastOverlay();
			
			scrollDown(By.xpath(lstObject.get(130)));
			WebElement Episode = Utilities.returnElement(driver, lstObject.get(128), lstObject.get(127));
			
			if(Episode.isDisplayed()) 
			{
				
				Extent_Reports.executionLog("PASS", "Episode should be displayed in home page" + "\n" + "Episode  is displayed in home page ",
						driver);
				Episode.click();
			}
			else 
			{
				Extent_Reports.executionLog("FAIL", "Episode should be displayed in home page" + "\n" + "Episode  is not displayed in home page ",
						driver);
			}
			
			
			WebElement EpisodeTitle = Utilities.returnElement(driver, lstObject.get(113), lstObject.get(112));
			if(EpisodeTitle.isDisplayed()) 
			{
				Extent_Reports.executionLog("PASS", "Episodes section should be displayed" + "\n" + "Episodes section is displayed",
						driver);
			}
			else 
			{
				Extent_Reports.executionLog("FAIL", "Episodes section should be displayed" + "\n" + "Episodes section is not displayed",
						driver);
			}
		}
		catch(Exception e) 
		{
			Extent_Reports.executionLog("INFO",
					"android_VerifyShowArtinforinShowHomepage_NAF3360" + "\n" + e.getMessage(), driver);
		}
	}//EOM
	
	
	}//EOC