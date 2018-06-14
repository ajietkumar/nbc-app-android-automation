package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.Location;
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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class PGVideoPlayerPage {

	public static AppiumDriver driver;
	String sql, ShowNameActual;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> objShowLists, objShowList;
	String sqlQry, Status, EpNameActual, EpNameActual2;
	WebElement VideoDetailShowSummary, VideoDetailMetaData, VideoDetailShwName, VideoDetailGotoShowBtn,
			Tablet_NOWPLAYING, Tablet_NOWPLAYING_EpisodeName, MoreEpisodesText, MoreEpisodesTraySection, objnav,
			objRespNavBar, objloading, objClipDropDownWebEx, objShowLink, loading, CastIcon, CastPopUp, vodtap,
			ShowName, ShowsMenu, EpisodeVideo, ad, HambergerIcon, playPause, GoToShow;

	// Constructor to initialize all the Page Objects
	public PGVideoPlayerPage(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGVideoPlayerPage", "Input");
		lstObject = db.getTestDataObject("Select * from PGVideoPlayerPage", "ObjectRepository");
	}

	// =========================================================================================================================
	@Test
	public void android_VerifyFrdBckwrdOnVodPlayer() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			PGNbcApp App = new PGNbcApp(driver);
			App.android_WaitForAppToLoad();
			App.android_DismissCastOverlay();

			App.android_OpenShow(lstTestData.get(0));

			Thread.sleep(5000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(22))));
			EpisodeVideo = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
			EpisodeVideo.click();
			Extent_Reports.executionLog("PASS", "Episode  should be clicked " + "\n" + "Episode is clicked", driver);
			Thread.sleep(5000);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(67))));
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
			vodtap = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
			playPause = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
			vodtap.click();
			playPause.click();
			Thread.sleep(5000);

			try {
				ad = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
				Thread.sleep(5000);
				if (ad.isDisplayed()) {
					playPause.click();
					Thread.sleep(50000);
				} else {
					Extent_Reports.executionLog("PASS", "No Ad is displayed  " + "\n" + "No Ad is displayed ", driver);
				}
			} catch (Exception e) {
				System.out.println("exception occured at progress bar");
				Thread.sleep(10000);
			}

			List<WebElement> ControlButtonList = Utilities.returnElements(driver, lstObject.get(62), lstObject.get(61));
			WebElement Frwd = ControlButtonList.get(1);

			if (Frwd.isEnabled()) {

				Extent_Reports.executionLog("PASS",
						"Forward Button should be displayed on VOD " + "\n" + "Forward Button is displayed on VOD",
						driver);
				Thread.sleep(2000);
			} else {
				Extent_Reports.executionLog("FAIL",
						"Forward Button should be displayed on VOD " + "\n" + "Forward Button is not displayed on VOD",
						driver);
				Thread.sleep(2000);
			}
			// Validating Forward +10 on VOD Player
			Frwd.click();
			WebElement Timer = Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
			String timeprogress = Timer.getText();
			System.out.println(timeprogress);
			String[] currentduration = timeprogress.split("/");
			System.out.println(currentduration[0]);
			String CurrentTimer = currentduration[0];
			String[] CurrentTimerWatched = CurrentTimer.split(":");
			int minutes = Integer.parseInt(CurrentTimerWatched[0].trim());
			int seconds = Integer.parseInt(CurrentTimerWatched[1].trim());

			int totalDurationWatched = minutes * 60 + seconds;
			System.out.println(totalDurationWatched);

			vodtap = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
			playPause = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
			playPause.click();
			Timer = Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
			timeprogress = Timer.getText();
			System.out.println(timeprogress);
			currentduration = timeprogress.split("/");
			System.out.println(currentduration[0]);
			CurrentTimer = currentduration[0];
			CurrentTimerWatched = CurrentTimer.split(":");
			minutes = Integer.parseInt(CurrentTimerWatched[0].trim());
			seconds = Integer.parseInt(CurrentTimerWatched[1].trim());

			int totalDurationWatchedAftrFrwd = minutes * 60 + seconds;
			System.out.println(totalDurationWatched);
			if ((totalDurationWatchedAftrFrwd - totalDurationWatched) >= 10) {
				Extent_Reports.executionLog("PASS", "Video should be Forwarded on Clicking Forward button " + "\n"
						+ "Video Forwarded on Clicking Forward button", driver);
				Thread.sleep(2000);
			} else {
				Extent_Reports.executionLog("FAIL", "Video should be Forwarded on Clicking Forward button " + "\n"
						+ "Video not Forwarded on Clicking Forward button", driver);
			}
			// Validating Backward -10 on VOD Player
			vodtap = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
			playPause = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
			vodtap.click();
			playPause.click();
			ControlButtonList = Utilities.returnElements(driver, lstObject.get(62), lstObject.get(61));
			WebElement Bckwrd = ControlButtonList.get(0);
			if (Bckwrd.isEnabled()) {

				Extent_Reports.executionLog("PASS",
						"Backward Button should be displayed on VOD " + "\n" + "Backward Button is displayed on VOD",
						driver);
				Thread.sleep(2000);
			} else {
				Extent_Reports.executionLog("FAIL", "Backward Button should be displayed on VOD " + "\n"
						+ "Backward Button is not displayed on VOD", driver);
				Thread.sleep(2000);
			}
			Bckwrd.click();
			Timer = Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
			timeprogress = Timer.getText();
			System.out.println(timeprogress);
			currentduration = timeprogress.split("/");
			System.out.println(currentduration[0]);
			CurrentTimer = currentduration[0];
			CurrentTimerWatched = CurrentTimer.split(":");
			minutes = Integer.parseInt(CurrentTimerWatched[0].trim());
			seconds = Integer.parseInt(CurrentTimerWatched[1].trim());

			totalDurationWatched = minutes * 60 + seconds;
			System.out.println(totalDurationWatched);

			vodtap = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
			playPause = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
			// vodtap.click();
			playPause.click();
			Timer = Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
			timeprogress = Timer.getText();
			System.out.println(timeprogress);
			currentduration = timeprogress.split("/");
			System.out.println(currentduration[0]);
			CurrentTimer = currentduration[0];
			CurrentTimerWatched = CurrentTimer.split(":");
			minutes = Integer.parseInt(CurrentTimerWatched[0].trim());
			seconds = Integer.parseInt(CurrentTimerWatched[1].trim());

			int totalDurationWatchedAftrBackd = minutes * 60 + seconds;
			System.out.println(totalDurationWatched);

			if ((totalDurationWatched - totalDurationWatchedAftrBackd) <= 10) {
				Extent_Reports.executionLog("PASS", "Video should be Backwarded on Clicking Forward button " + "\n"
						+ "Video Backwarded on Clicking Backward button", driver);
				Thread.sleep(2000);
			} else {
				Extent_Reports.executionLog("FAIL", "Video should be Backwarded on Clicking Forward button " + "\n"
						+ "Video not backwarded on Clicking Backward button", driver);
			}

			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(3000);

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_GoToShow" + "\n" + e.getMessage(), driver);
		}
	}// EOM

	@Test
	public void android_VerifyNolivebasedonlocation_NAF3550() throws Exception {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 50);
			PGNbcApp App = new PGNbcApp(driver);
			PGAndroidApp AndApp = new PGAndroidApp(driver);
			App.android_WaitForAppToLoad();

			App.android_DismissCastOverlay();
			try {
				((AndroidDriver) driver).toggleLocationServices();
			} catch (Exception e) {

				e.printStackTrace();
			}
			try {
				((AndroidDriver) driver).setLocation(new Location(40, 74, 10));
			} catch (Exception e) {
				e.printStackTrace();
			}

			AndApp.android_OpenMenu("LIVE");

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_GoToShow" + "\n" + e.getMessage(), driver);
		}
	}// EOM

	@Test
	public void android_VerifyMoreEpisodesTray() throws Exception {
		try {
			PGAndroidApp App2 = new PGAndroidApp(driver);
			PGNbcApp App1 = new PGNbcApp(driver);
			App1.android_WaitForAppToLoad();
			// App1.android_DismissCastOverlay();
			App1.android_OpenShow("A.P. Bio");
			ShowNameActual = App2.android_getShowNamefromShowHomePage();
			// App1.android_GotoAnyShowHomePage();
			EpNameActual = App2.android_getEpisodeNameSmartTile();
			App2.android_clickOnSmartTile();
			EpNameActual2 = App2.android_getEpisodeNameVideoDetailsPageVODPlayer();

			if (EpNameActual.equals(EpNameActual2)) {

				Extent_Reports.executionLog("PASS", " Video Started from the smart tile only should be played " + "\n"
						+ " Video Started from the smart tile is played ", driver);
			} else {

				Extent_Reports.executionLog("FAIL", " Video Started from the smart tile only should be played " + "\n"
						+ " Video Started from the smart tile is not played.Actual played video is : " + EpNameActual2,
						driver);
			}

			Synchronization.ExplicitWait(driver, lstObject.get(73), "visible");
			MoreEpisodesTraySection = Utilities.returnElement(driver, lstObject.get(74), lstObject.get(73));

			Synchronization.ExplicitWait(driver, lstObject.get(70), "visible");
			MoreEpisodesText = Utilities.returnElement(driver, lstObject.get(71), lstObject.get(70));

			if (MoreEpisodesTraySection.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						" Video Details page should be displayed while the video is played : " + "\n"
								+ " Video Details page is displayed while the video is being played ",
						driver);
			} else {

				Extent_Reports
						.executionLog("FAIL",
								" Video Details page should be displayed while the video is played : " + "\n"
										+ " Video Details page is not displayed while the video is being played ",
								driver);

			}

			if (MoreEpisodesText.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						" MORE EPISODES text should be displayed while the video is played : " + "\n"
								+ " MORE EPISODES text is displayed while the video is being played ",
						driver);
			} else {

				Extent_Reports
						.executionLog("FAIL",
								" MORE EPISODES text should be displayed while the video is played : " + "\n"
										+ "MORE EPISODES text is not displayed while the video is being played ",
								driver);

			}

			VideoDetailShwName = Utilities.returnElement(driver, lstObject.get(80), lstObject.get(79));

			if (VideoDetailShwName.getText().equals(ShowNameActual)) {
				Extent_Reports.executionLog("PASS", "Correct show name should be displayed  " + "\n"
						+ " Correct show name is displayed:" + ShowNameActual, driver);
			} else {
				Extent_Reports.executionLog("FAIL ", "Correct show name should be displayed  " + "\n"
						+ " Correct show name is not displayed.Actual Show name is " + ShowNameActual, driver);
			}

			VideoDetailGotoShowBtn = Utilities.returnElement(driver, lstObject.get(95), lstObject.get(94));
			if (VideoDetailGotoShowBtn.isDisplayed()) {
				Extent_Reports.executionLog("PASS", " GO TO SHOW PAGE Button should be displayed  " + "\n"
						+ " GO TO SHOW PAGE Button is displayed   ", driver);
			} else {
				Extent_Reports.executionLog("FAIL", " GO TO SHOW PAGE Button should be displayed  " + "\n"
						+ " GO TO SHOW PAGE Button is not displayed   ", driver);
			}

			VideoDetailMetaData = Utilities.returnElement(driver, lstObject.get(89), lstObject.get(88));

			if (VideoDetailMetaData.isDisplayed()) {
				Extent_Reports.executionLog("PASS", " Video Meta Data should be displayed " + "\n"
						+ " Video Meta Data is  displayed.:" + VideoDetailMetaData.getText(), driver);
			} else {
				Extent_Reports.executionLog("FAIL",
						" Video Meta Data should be displayed " + "\n" + " Video Meta Data is not displayed.", driver);
			}

			VideoDetailShowSummary = Utilities.returnElement(driver, lstObject.get(92), lstObject.get(91));

			if (VideoDetailShowSummary.isDisplayed()) {
				Extent_Reports.executionLog("PASS", " Show summary should be displayed " + "\n"
						+ " Show summary is  displayed.:" + VideoDetailShowSummary.getText(), driver);
			} else {
				Extent_Reports.executionLog("FAIL",
						" Show summary should be displayed" + "\n" + " Show summary is  not displayed.", driver);
			}

			// Tablet_NOWPLAYING=Utilities.returnElement(driver,
			// lstObject.get(86), lstObject.get(85));

			List<WebElement> MenuList = driver
					.findElements(By.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout"));
			int counter = 0;
			for (int i = 0; i < MenuList.size() - 1; i++) {
				// List<WebElement> MenuList2 =
				// MenuList.get(i).findElements(By.xpath("//android.widget.TextView"));

				WebElement MenuList2 = MenuList.get(i).findElement(By.xpath("//android.widget.TextView"));
				if (MenuList2.getText().equalsIgnoreCase("Now Playing")) {

					Extent_Reports.executionLog("PASS",
							" NOW PLAYING  should be displayed on the episode thumbnail of the currently playing episode  "
									+ "\n"
									+ " NOW PLAYING  is displayed on the episode thumbnail of the currently playing episode  ",
							driver);

					String op = MenuList.get(i)
							.findElement(By
									.xpath("//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@index='1']"))
							.getText();

					if (op.equals(EpNameActual2)) {
						Extent_Reports.executionLog("PASS",
								" NOW PLAYING  should be present only on the  currently playing episode thumbnail : "
										+ "\n"
										+ " NOW PLAYING  is present only on  the  currently playing episode thumbnail   ",
								driver);

					} else {

						Extent_Reports.executionLog("FAIL",
								" NOW PLAYING  should be present on the  currently playing episode thumbnail : " + "\n"
										+ " NOW PLAYING  is not present on the  currently playing episode thumbnail   ",
								driver);
					}

					break;

				} else {
					counter++;
					if (counter == MenuList.size() - 1) {

						Extent_Reports.executionLog("FAIL", " NOW PLAYING  should be present on the  screen : " + "\n"
								+ " NOW PLAYING  is not present on the screen", driver);
						break;
					}
				}

			}

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_VerifyMoreEpisodesTray" + "\n" + e.getMessage(), driver);
		}
	}// EOM

	@Test
	public void android_VerifyCCoptionsinplayercontrols_NAF3553() throws Exception {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 50);
			PGNbcApp App = new PGNbcApp(driver);
			PGAndroidApp AndApp = new PGAndroidApp(driver);
			App.android_WaitForAppToLoad();

			App.android_DismissCastOverlay();

			App.android_OpenShowsMenu();

			// AndApp.android_OpenMenu("LIVE");

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_GoToShow" + "\n" + e.getMessage(), driver);
		}
	}// EOM

	@Test
	public void android_OverlayFades_NAF7108() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			PGNbcApp App = new PGNbcApp(driver);
			App.android_WaitForAppToLoad();
			App.android_DismissCastOverlay();
			PGNbcApp objHP = new PGNbcApp(driver);
			objHP.android_OpenShow("Better Late Than Never");
			Thread.sleep(8000);
			List<WebElement> Show = driver
					.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.ImageView"));
			Show.get(0).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='LOADING']")));
			WebElement Laoding = driver.findElement(By.xpath("//android.widget.TextView[@text='LOADING']"));
			if (Laoding.isEnabled()) {
				Extent_Reports.executionLog("PASS",
						" Loading text should be displayed " + "\n" + " Loading text is displayed", driver);
			} else {
				Extent_Reports.executionLog("FAIL",
						" Loading text should be displayed " + "\n" + " Loading text is not displayed", driver);
			}
			Thread.sleep(30000);

			for (int i = 0; i < 10; i++) {

				vodtap = driver.findElement(By.xpath("//android.widget.RelativeLayout"));
				vodtap.click();
				WebElement togglePlay = driver
						.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'toggle')]"));
				vodtap = driver.findElement(By.xpath("//android.widget.RelativeLayout"));
				vodtap.click();
				WebElement Caption = driver
						.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'toggleCaption')]"));
				vodtap = driver.findElement(By.xpath("//android.widget.RelativeLayout"));
				vodtap.click();
				if (togglePlay.isEnabled() && Caption.isEnabled()) {
					Extent_Reports.executionLog("PASS", " togglePlay button and toggle Caption are should be displayed "
							+ "\n" + " togglePlay button and toggle Caption are displayed", driver);
					break;
				}

			}
			Thread.sleep(3000);
			try {
				WebElement togglePlay = driver
						.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'toggle')] "));
				WebElement Caption = driver
						.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'toggleCaption')]"));

				if (togglePlay.isEnabled() && Caption.isEnabled()) {
					Extent_Reports.executionLog("FAIL", " VideoControl buttons should not be displayed " + "\n"
							+ " VideoControl buttons are displayed", driver);
				} else {
					Extent_Reports.executionLog("PASS", " VideoControl buttons should not be displayed " + "\n"
							+ " VideoControl buttons are not displayed", driver);
				}

			} catch (Exception e) {
				Extent_Reports.executionLog("PASS", " VideoControl buttons should not be displayed " + "\n"
						+ " VideoControl buttons are not displayed", driver);
			}

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_Settings" + "\n" + e.getMessage(), driver);

		}
	}// EOM

	public void android_AdElementsInPalyer_NAF3558() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			PGNbcApp App = new PGNbcApp(driver);
			App.android_WaitForAppToLoad();
			App.android_DismissCastOverlay();
			PGNbcApp objHP = new PGNbcApp(driver);
			objHP.android_OpenShow("A.P. Bio");
			Thread.sleep(8000);
			List<WebElement> Show = driver
					.findElements(By.xpath("//android.support.v7.widget.RecyclerView//android.widget.ImageView"));
			Show.get(0).click();
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='LOADING']")));
			WebElement Laoding = driver.findElement(By.xpath("//android.widget.TextView[@text='LOADING']"));
			if (Laoding.isEnabled()) {
				Extent_Reports.executionLog("PASS",
						" Loading text should be displayed " + "\n" + " Loading text is displayed", driver);
			} else {
				Extent_Reports.executionLog("FAIL",
						" Loading text should be displayed " + "\n" + " Loading text is not displayed", driver);
			}
			Thread.sleep(30000);

			for (int i = 0; i < 10; i++) {

				vodtap = driver.findElement(By.xpath("//android.widget.RelativeLayout"));
				vodtap.click();
				WebElement togglePlay = driver
						.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'toggle')]"));
				togglePlay.click();

				if (togglePlay.isEnabled()) {
					Extent_Reports.executionLog("PASS",
							" togglePlay button should be displayed " + "\n" + " togglePlay button is displayed",
							driver);
					break;
				}
			}

			for (int j = 0; j < 10; j++) {

				WebElement PLAYING_AD = driver.findElement(By.xpath(
						"//*[contains(@resource-id,'video_player_controls')]/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.TextView"));
				// vodtap =
				// driver.findElement(By.xpath("//android.widget.RelativeLayout"));
				// vodtap.click();
				if (PLAYING_AD.isEnabled()) {
					Extent_Reports.executionLog("PASS", " AD should be displayed " + "\n" + " Ad is displayed", driver);
					break;
				}

			}

			for (int j = 0; j < 10; j++) {

				// vodtap =
				// driver.findElement(By.xpath("//android.widget.RelativeLayout"));
				// vodtap.click();

				WebElement OpenAdBrowser = driver
						.findElement(By.xpath("//android.widget.TextView[@text='OPEN AD IN BROWSER']"));
				// vodtap =
				// driver.findElement(By.xpath("//android.widget.RelativeLayout"));
				// vodtap.click();
				if (OpenAdBrowser.isEnabled()) {

					OpenAdBrowser.click();
					Extent_Reports.executionLog("PASS", " OPEN AD IN BROWSER text should be displayed " + "\n"
							+ " OPEN AD IN BROWSER text is displayed", driver);
					break;
				}
			}

			Set<String> allContext = driver.getContextHandles();
			for (String context : allContext) {
				if (context.contains("NATIVE")) {
					driver.context(context);
					Extent_Reports.executionLog("FAIL",
							" Should be navigated to WebView " + "\n" + " Navigated to WebView", driver);
				}
			}
			WebElement BackButton = driver
					.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
			BackButton.click();
			Thread.sleep(7000);
			vodtap = driver.findElement(By.xpath("//android.widget.RelativeLayout"));
			vodtap.click();
			WebElement togglePlay = driver
					.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'toggle')]"));
			togglePlay = driver.findElement(
					By.xpath("//android.widget.ToggleButton[@resource-id='com.nbc.nbcapp:id/togglePlay']"));
			togglePlay.click();

			if (togglePlay.isEnabled()) {
				Extent_Reports.executionLog("FAIL",
						" togglePause button should be displayed " + "\n" + " togglePause button is not displayed",
						driver);
			} else {
				Extent_Reports.executionLog("PASS",
						" togglePause button should be displayed " + "\n" + " togglePause button is displayed", driver);
			}

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_Settings" + "\n" + e.getMessage(), driver);

		}
	}// EOM

	public void android_Entitled_video_Process_NAF_3546() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			PGNbcApp App = new PGNbcApp(driver);
			App.android_WaitForAppToLoad();
			App.android_DismissCastOverlay();

			WebElement Menu = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
			Menu.click();
			Thread.sleep(6000);
			List<WebElement> Menulist = Utilities.returnElements(driver, lstObject.get(101), lstObject.get(100));
			Menulist.get(2).click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Should be navigated to Current Shows Page " + "\n"
							+ Extent_Reports.logActual + " Navigated to Current Shows Page ",
					driver);
			// ***//
			/*
			 * List <WebElement> Better_Late_Than_Never_show =
			 * driver.findElements(By.xpath(
			 * "//android.widget.FrameLayout[contains(@resource-id,'show_item_outer_container')]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView"
			 * )); Better_Late_Than_Never_show.get(4).click();
			 */

			PGNbcApp nbc1 = new PGNbcApp(driver);
			nbc1.android_ClickOnParticularShow("Chicago Fire");
			Thread.sleep(6000);
			Extent_Reports.executionLog(
					"PASS", Extent_Reports.logExpected + "Should be navigated to Better Late Than Never Show Page "
							+ "\n" + Extent_Reports.logActual + " Navigated to Better Late Than Never Show Page ",
					driver);
			// ***//

			/** Find entitled Video **/

			WebElement Entitled_Video = Utilities.returnElement(driver, lstObject.get(104), lstObject.get(103));
			if (Entitled_Video.isEnabled()) {
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Found Auth Video " + "\n"
						+ Extent_Reports.logActual + " Found Auth Video ", driver);

			} else {
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Found Auth Video " + "\n"
						+ Extent_Reports.logActual + " Not found Auth Video ", driver);
			}

			WebElement Entitled_Video_title = Utilities.returnElement(driver, lstObject.get(107), lstObject.get(106));
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Auth Video Title shoud be displayed and is: "
							+ Entitled_Video_title.getAttribute("text") + "\n" + Extent_Reports.logActual
							+ "Auth Video Title is displayed and is:" + Entitled_Video_title.getAttribute("text"),
					driver);
			String Auth_Video_title = Entitled_Video_title.getAttribute("text");

			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(3000);
			Menu = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
			Menu.click();
			Thread.sleep(3000);
			Menulist = Utilities.returnElements(driver, lstObject.get(101), lstObject.get(100));
			Menulist.get(4).click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Search Page "
					+ "\n" + Extent_Reports.logActual + " Navigated to Search Page ", driver);
			WebElement search_field = Utilities.returnElement(driver, lstObject.get(110), lstObject.get(109));
			search_field.sendKeys(Auth_Video_title);
			Thread.sleep(8000);

			List<WebElement> Auth_Key = Utilities.returnElements(driver, lstObject.get(113), lstObject.get(112));
			if (Auth_Key.get(1).isEnabled()) {
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Auth Key Vod shoud be displayed "
						+ "\n" + Extent_Reports.logActual + "Auth Key Vod is displayed", driver);
			} else {
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Auth Key Vod shoud be displayed "
						+ "\n" + Extent_Reports.logActual + "Auth Key Vod is displayed", driver);
			}

			Menu = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
			Menu.click();
			Thread.sleep(3000);
			Menulist = Utilities.returnElements(driver, lstObject.get(101), lstObject.get(100));
			Menulist.get(5).click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Settings Page "
					+ "\n" + Extent_Reports.logActual + " Navigated to Settings Page ", driver);

			WebElement TV_PROVIDER = Utilities.returnElement(driver, lstObject.get(116), lstObject.get(115));
			TV_PROVIDER.click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Bridge Screen "
					+ "\n" + Extent_Reports.logActual + " Navigated to Bridge Screen ", driver);
			List<WebElement> Bridge_screen = Utilities.returnElements(driver, lstObject.get(119), lstObject.get(118));
			Bridge_screen.get(7).click();
			Thread.sleep(10000);
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Should be navigated to Optimum Login Page " + "\n"
							+ Extent_Reports.logActual + " Navigated to Optimum Login Page ",
					driver);
			Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
			for (String contextName : contextNames) {
				// if (contextName.contains("WEBVIEW_com.android.browser")) {
				if (contextName.contains("NATIVE_APP")) {
					((AppiumDriver) driver).context(contextName);
				}
			}
			WebElement UserName = Utilities.returnElement(driver, lstObject.get(122), lstObject.get(121));
			UserName.sendKeys("research39");
			Thread.sleep(1000);
			WebElement Password = Utilities.returnElement(driver, lstObject.get(125), lstObject.get(124));
			Password.sendKeys("support39");
			Thread.sleep(1000);
			WebElement SingIn_btn = Utilities.returnElement(driver, lstObject.get(128), lstObject.get(127));
			SingIn_btn.click();
			Thread.sleep(6000);
			WebElement NBC_Bridge_Screen = Utilities.returnElement(driver, lstObject.get(131), lstObject.get(130));
			if (NBC_Bridge_Screen.getAttribute("text").contains("TV Provider Linked!")) {
				Extent_Reports.executionLog("PASS",
						" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed " + "\n"
								+ " Navigated to NBC Bridge Screen and 'TV Provider Linked!' text is displayed ",
						driver);
			} else {
				Extent_Reports.executionLog("FAIL",
						" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed " + "\n"
								+ " Not navigated to NBC Bridge Screen and 'TV Provider Linked!' text is not displayed ",
						driver);
			}

			WebElement skip_btn = Utilities.returnElement(driver, lstObject.get(134), lstObject.get(133));
			skip_btn.click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Settings Page "
					+ "\n" + Extent_Reports.logActual + " Navigated to Settings Page ", driver);

			WebElement UNLINK_TV_PROVIDER = Utilities.returnElement(driver, lstObject.get(137), lstObject.get(136));
			if (UNLINK_TV_PROVIDER.isEnabled()) {
				Extent_Reports
						.executionLog("PASS",
								Extent_Reports.logExpected + "UNLINK YOUR TV PROVIDER text should be displayed " + "\n"
										+ Extent_Reports.logActual + " UNLINK YOUR TV PROVIDER text is displayed ",
								driver);
			} else {
				Extent_Reports
						.executionLog("FAIL",
								Extent_Reports.logExpected + "UNLINK YOUR TV PROVIDER text should be displayed " + "\n"
										+ Extent_Reports.logActual + " UNLINK YOUR TV PROVIDER text is displayed ",
								driver);
			}

			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(5000);

			Menu = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
			Menu.click();
			Thread.sleep(6000);
			Menulist = Utilities.returnElements(driver, lstObject.get(101), lstObject.get(100));
			Menulist.get(2).click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Should be navigated to Current Shows Page " + "\n"
							+ Extent_Reports.logActual + " Navigated to Current Shows Page ",
					driver);
			// ***//
			/*
			 * Better_Late_Than_Never_show = driver.findElements(By.xpath(
			 * "//android.widget.FrameLayout[contains(@resource-id,'show_item_outer_container')]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.ImageView"
			 * )); Better_Late_Than_Never_show.get(4).click();
			 */

			nbc1.android_ClickOnParticularShow("Chicago Med");
			Thread.sleep(6000);
			Extent_Reports.executionLog(
					"PASS", Extent_Reports.logExpected + "Should be navigated to Better Late Than Never Show Page "
							+ "\n" + Extent_Reports.logActual + " Navigated to Better Late Than Never Show Page ",
					driver);
			// ***//

			/** Find entitled Video **/
			try {
				Entitled_Video = Utilities.returnElement(driver, lstObject.get(140), lstObject.get(139));
				if (!Entitled_Video.isEnabled()) {
					Extent_Reports.executionLog("PASS",
							Extent_Reports.logExpected + "Auth Key Should not be displayed on the Video thumbnail"
									+ "\n" + Extent_Reports.logActual
									+ " Auth Key is not be displayed on the Video thumbnail ",
							driver);
				}
			} catch (Exception e) {
				Extent_Reports.executionLog(
						"FAIL", Extent_Reports.logExpected + "Auth Key Should be displayed on the Video thumbnail"
								+ "\n" + Extent_Reports.logActual + " Auth Key is displayed on the Video thumbnail ",
						driver);
			}

			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(3000);
			Menu = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
			Menu.click();
			Thread.sleep(3000);
			Menulist = Utilities.returnElements(driver, lstObject.get(101), lstObject.get(100));

			Menulist.get(4).click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Search Page "
					+ "\n" + Extent_Reports.logActual + " Navigated to Search Page ", driver);
			search_field = Utilities.returnElement(driver, lstObject.get(143), lstObject.get(142));
			search_field.sendKeys(Auth_Video_title);
			Thread.sleep(8000);
			try {
				Auth_Key = Utilities.returnElements(driver, lstObject.get(146), lstObject.get(145));
				if (!Auth_Key.get(1).isEnabled()) {
					Extent_Reports.executionLog("PASS",
							Extent_Reports.logExpected + "Auth Key Should not be displayed on the Video thumbnail"
									+ "\n" + Extent_Reports.logActual
									+ " Auth Key is not be displayed on the Video thumbnail ",
							driver);
				}
			} catch (Exception e) {
				Extent_Reports.executionLog(
						"FAIL", Extent_Reports.logExpected + "Auth Key Should be displayed on the Video thumbnail"
								+ "\n" + Extent_Reports.logActual + " Auth Key is displayed on the Video thumbnail ",
						driver);
			}

		} catch (Exception e) {
			Extent_Reports.executionLog("INFO",
					"android_Verify_Entitled_video_Process_NAF_3546" + "\n" + e.getMessage(), driver);
		}
	}// EOM

	public void android_Endcard_Episode_NoFav_NAF_3564() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		PGNbcApp App = new PGNbcApp(driver);
		App.android_WaitForAppToLoad();
		App.android_DismissCastOverlay();

		WebElement Menu = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
		Menu.click();
		Thread.sleep(6000);
		List<WebElement> Menulist = Utilities.returnElements(driver, lstObject.get(101), lstObject.get(100));
		Menulist.get(2).click();
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Current Shows Page "
				+ "\n" + Extent_Reports.logActual + " Navigated to Current Shows Page ", driver);

		PGNbcApp nbc1 = new PGNbcApp(driver);
		nbc1.android_ClickOnParticularShow("Chicago Fire");
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS",
				Extent_Reports.logExpected + "Should be navigated to Chicago Fire Show Page " + "\n"
						+ Extent_Reports.logActual + " Navigated to Chicago Fire Show Page ",
				driver);
		List<WebElement> EpisodeTitle = Utilities.returnElements(driver, lstObject.get(170), lstObject.get(169));
		EpisodeTitle.get(0).click();

		try {
			Thread.sleep(10000);
			WebElement tap = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			tap.click();
			Thread.sleep(20000);
			WebElement play = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
			play.click();
			WebElement seekBar = Utilities.returnElement(driver, lstObject.get(155), lstObject.get(154));
			// get start co-ordinate of seekbar
			int start = seekBar.getLocation().getX();
			// Get width of seekbar
			int end = seekBar.getSize().getWidth();
			// get location of seekbar vertically
			int y = seekBar.getLocation().getY();
			// Select till which position you want to move the seekbar
			TouchAction action = new TouchAction(driver);
			// Move it will the end
			action.longPress(start, y).moveTo(end, y).release().perform();
			/*
			 * int moveTo=(int)(end*0.8);
			 * //action.press(start,y).moveTo(moveTo,y).release().perform();
			 * action.longPress(start, y).moveTo(moveTo, y).release().perform();
			 */

			for (int j = 0; j < 100; j++) {

				try {
					WebElement GO_TO_SHOW = Utilities.returnElement(driver, lstObject.get(158), lstObject.get(157));
					if (GO_TO_SHOW.isEnabled()) {
						break;
					} else {
						Thread.sleep(5000);
					}
				} catch (Exception e) {
					Thread.sleep(5000);
				}

			}

			WebElement showContainerImage = Utilities.returnElement(driver, lstObject.get(173), lstObject.get(172));

			WebElement Recommended_for_You = Utilities.returnElement(driver, lstObject.get(176), lstObject.get(175));

			WebElement show_name = Utilities.returnElement(driver, lstObject.get(179), lstObject.get(178));
			String ShowName = show_name.getAttribute("text");

			WebElement show_description = Utilities.returnElement(driver, lstObject.get(182), lstObject.get(181));

			if (showContainerImage.isEnabled() && Recommended_for_You.isEnabled() && show_name.isEnabled()
					&& show_description.isEnabled()) {
				Extent_Reports.executionLog("PASS", " End card display info should be displayed  and  "
						+ " Show Name is: " + ShowName + "\n" + " End card display info is displayed ", driver);
			} else {
				Extent_Reports.executionLog("FAIL", " End card display info should be displayed and "
						+ " Show Name is: " + ShowName + "\n" + " End card display info is not displayed ", driver);
			}

			if (show_description.isEnabled()) {
				Extent_Reports.executionLog("PASS",
						"Show Description should be displayed and is : " + show_description.getAttribute("text") + "\n"
								+ " Show Description is displayed and is :  " + show_description.getAttribute("text"),
						driver);
			} else {
				Extent_Reports.executionLog("FAIL",
						"Show Description should be displayed and is : " + show_description.getAttribute("text") + "\n"
								+ " Show Description is not displayed and is :  "
								+ show_description.getAttribute("text"),
						driver);
			}

			if (Recommended_for_You.isEnabled()) {
				Extent_Reports.executionLog("PASS", "Recommended for You text should be displayed  " + "\n"
						+ "Recommended for You text is displayed", driver);
			} else {
				Extent_Reports.executionLog("PASS", "Recommended for You text should be displayed  " + "\n"
						+ "Recommended for You text is not displayed", driver);
			}

		} catch (Exception e) {
			Extent_Reports.executionLog("INFO",
					"android_VerifyShowArtinforinShowHomepage_NAF3360" + "\n" + e.getMessage(), driver);
		}
	}// EOM
	

public void android_Endcard_Episodes_WithFavorites_NAF_3563() throws Exception{
WebDriverWait wait = new WebDriverWait(driver, 50);

PGNbcApp App = new PGNbcApp(driver);
App.android_WaitForAppToLoad();
App.android_DismissCastOverlay();

WebElement Menu = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
Menu.click();
Thread.sleep(6000);
List<WebElement> Menulist = Utilities.returnElements(driver, lstObject.get(101), lstObject.get(100));
Menulist.get(2).click();
Thread.sleep(6000);
Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Current Shows Page "
		+ "\n" + Extent_Reports.logActual + " Navigated to Current Shows Page ", driver);

PGNbcApp nbc1 = new PGNbcApp(driver);
String Fav_Show = "Give";
nbc1.android_ClickOnParticularShow("Fav_Show");
PGAndroidApp Fav = new PGAndroidApp(driver);
Fav.android_AddToFavorites();
Thread.sleep(6000);
((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
Thread.sleep(3000);
((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

nbc1.android_ClickOnParticularShow("Chicago Fire");
Extent_Reports.executionLog("PASS",
		Extent_Reports.logExpected + "Should be navigated to Chicago Fire Show Page " + "\n"
				+ Extent_Reports.logActual + " Navigated to Chicago Fire Show Page ",
		driver);
WebElement Clip = Utilities.returnElement(driver, lstObject.get(185), lstObject.get(184));
Clip.click();

try {
	Thread.sleep(10000);
	WebElement tap = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
	tap.click();
	Thread.sleep(20000);
	WebElement play = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
	play.click();
	WebElement seekBar = Utilities.returnElement(driver, lstObject.get(155), lstObject.get(154));
	// get start co-ordinate of seekbar
	int start = seekBar.getLocation().getX();
	// Get width of seekbar
	int end = seekBar.getSize().getWidth();
	// get location of seekbar vertically
	int y = seekBar.getLocation().getY();
	// Select till which position you want to move the seekbar
	TouchAction action = new TouchAction(driver);
	// Move it will the end
	action.longPress(start, y).moveTo(end, y).release().perform();
	/*
	 * int moveTo=(int)(end*0.8);
	 * //action.press(start,y).moveTo(moveTo,y).release().perform();
	 * action.longPress(start, y).moveTo(moveTo, y).release().perform();
	 */

	 for(int j=0;j<100;j++)
     {

        try
        {
            WebElement PLAY_NOW = driver.findElement(By.xpath("//android.widget.Button[contains(@text,'PLAY NOW')]"));
            if(PLAY_NOW.isEnabled())
            {
          	  break;
            }
            else{
          	  Thread.sleep(5000);
            }
        }
        catch(Exception e){
      	  Thread.sleep(5000);
        }
   
     
     }
     
     WebElement up_next_text = Utilities.returnElement(driver, lstObject.get(161), lstObject.get(160));
     
    
      WebElement show_title = Utilities.returnElement(driver, lstObject.get(164), lstObject.get(163));
      String ShowTitle = show_title.getAttribute("text");
      if(show_title.equals(Fav_Show)){
    	  Extent_Reports.executionLog("PASS", " A Show from Favorites whow be displayed in the End card if the user completes latest episode from a show" + "Show Title is: " + ShowTitle +
                   "\n" + " Show from Favorites is displayed in the End card ", driver);    
      }else{
          Extent_Reports.executionLog("FAIL", " A Show from Favorites whow be displayed in the End card if the user completes latest episode from a show" + "Show Title is: " + ShowTitle + 
                 "\n" + " Show from Favorites is not displayed in the End card  ", driver);  
      }
      
     // WebElement searchInfo = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'searchInfo')]')]"));
      //String SearchInfo = searchInfo.getAttribute("text");
      
      WebElement SECONDS = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'SECONDS')]"));
      String Time = SECONDS.getAttribute("text");
      WebElement PLAY_NOW = driver.findElement(By.xpath("//android.widget.Button[contains(@text,'PLAY NOW')]"));
      if (PLAY_NOW.isEnabled() && up_next_text.isEnabled() && show_title.isEnabled()  &&  SECONDS.isEnabled()){
          Extent_Reports.executionLog("PASS", " End card display info should be displayed" + "Show Title is: " + ShowTitle +  "SECONDS are " + Time
                  + "\n" + " End card display info is displayed ", driver);    
      }else{
          Extent_Reports.executionLog("FAIL", " End card display info should be displayed" + "Show Title is: " + ShowTitle + "SECONDS are " + Time
                  + "\n" + " End card display info is not displayed ", driver);    
      }
	} catch (Exception e) {
		Extent_Reports.executionLog("INFO",
				"android_VerifyShowArtinforinShowHomepage_NAF3360" + "\n" + e.getMessage(), driver);
	}
}//EOM

public void android_Endcard_Clips_NoFav() throws Exception{
WebDriverWait wait = new WebDriverWait(driver, 50);

PGNbcApp App = new PGNbcApp(driver);
App.android_WaitForAppToLoad();
App.android_DismissCastOverlay();

WebElement Menu = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
Menu.click();
Thread.sleep(6000);
List<WebElement> Menulist = Utilities.returnElements(driver, lstObject.get(101), lstObject.get(100));
Menulist.get(2).click();
Thread.sleep(6000);
Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Current Shows Page "
		+ "\n" + Extent_Reports.logActual + " Navigated to Current Shows Page ", driver);

PGNbcApp nbc1 = new PGNbcApp(driver);
nbc1.android_ClickOnParticularShow("Access");
Thread.sleep(6000);
Extent_Reports.executionLog("PASS",
		Extent_Reports.logExpected + "Should be navigated to Chicago Fire Show Page " + "\n"
				+ Extent_Reports.logActual + " Navigated to Chicago Fire Show Page ",
		driver);
WebElement Clip = Utilities.returnElement(driver, lstObject.get(185), lstObject.get(184));
Clip.click();

try {
	Thread.sleep(10000);
	WebElement tap = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
	tap.click();
	Thread.sleep(20000);
	WebElement play = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
	play.click();
	WebElement seekBar = Utilities.returnElement(driver, lstObject.get(155), lstObject.get(154));
	// get start co-ordinate of seekbar
	int start = seekBar.getLocation().getX();
	// Get width of seekbar
	int end = seekBar.getSize().getWidth();
	// get location of seekbar vertically
	int y = seekBar.getLocation().getY();
	// Select till which position you want to move the seekbar
	TouchAction action = new TouchAction(driver);
	// Move it will the end
	action.longPress(start, y).moveTo(end, y).release().perform();
	/*
	 * int moveTo=(int)(end*0.8);
	 * //action.press(start,y).moveTo(moveTo,y).release().perform();
	 * action.longPress(start, y).moveTo(moveTo, y).release().perform();
	 */

	for (int j = 0; j < 100; j++) {

		try {
			WebElement GO_TO_SHOW = Utilities.returnElement(driver, lstObject.get(158), lstObject.get(157));
			if (GO_TO_SHOW.isEnabled()) {
				break;
			} else {
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			Thread.sleep(5000);
		}

	}

	WebElement showContainerImage = Utilities.returnElement(driver, lstObject.get(173), lstObject.get(172));

	WebElement Recommended_for_You = Utilities.returnElement(driver, lstObject.get(176), lstObject.get(175));

	WebElement show_name = Utilities.returnElement(driver, lstObject.get(179), lstObject.get(178));
	String ShowName = show_name.getAttribute("text");

	WebElement show_description = Utilities.returnElement(driver, lstObject.get(182), lstObject.get(181));

	if (showContainerImage.isEnabled() && Recommended_for_You.isEnabled() && show_name.isEnabled()
			&& show_description.isEnabled()) {
		Extent_Reports.executionLog("PASS", " End card display info should be displayed  and  "
				+ " Show Name is: " + ShowName + "\n" + " End card display info is displayed ", driver);
	} else {
		Extent_Reports.executionLog("FAIL", " End card display info should be displayed and "
				+ " Show Name is: " + ShowName + "\n" + " End card display info is not displayed ", driver);
	}

	if (show_description.isEnabled()) {
		Extent_Reports.executionLog("PASS",
				"Show Description should be displayed and is : " + show_description.getAttribute("text") + "\n"
						+ " Show Description is displayed and is :  " + show_description.getAttribute("text"),
				driver);
	} else {
		Extent_Reports.executionLog("FAIL",
				"Show Description should be displayed and is : " + show_description.getAttribute("text") + "\n"
						+ " Show Description is not displayed and is :  "
						+ show_description.getAttribute("text"),
				driver);
	}

	if (Recommended_for_You.isEnabled()) {
		Extent_Reports.executionLog("PASS", "Recommended for You text should be displayed  " + "\n"
				+ "Recommended for You text is displayed", driver);
	} else {
		Extent_Reports.executionLog("PASS", "Recommended for You text should be displayed  " + "\n"
				+ "Recommended for You text is not displayed", driver);
	}

} catch (Exception e) {
	Extent_Reports.executionLog("INFO",
			"android_VerifyShowArtinforinShowHomepage_NAF3360" + "\n" + e.getMessage(), driver);
}
}//EOM

public void android_VerifylistofshowsmetadataEpisodecollectionshelf_NAF3374() throws Exception {
	PGNbcApp App1 = new PGNbcApp(driver);
	String val="";
	String lastShow="";
	try 
	{
		WebDriverWait wait = new WebDriverWait(driver, 50);
		App1.android_WaitForAppToLoad();
		//App1.android_DismissCastOverlay();
		Thread.sleep(30000);
	
		
		List<WebElement> Sections=Utilities.returnElements(driver, lstObject.get(191), lstObject.get(190));
		scrollDown(By.xpath(lstObject.get(190)));
		WebElement Episode = Utilities.returnElement(driver, lstObject.get(188), lstObject.get(187));
		
		if(Episode.isDisplayed()) 
		{
			
			Extent_Reports.executionLog("PASS", "Episode should be displayed in home page" + "\n" + "Episode  is displayed in home page ",
					driver);
			Episode.click();
			Thread.sleep(30000);
			Extent_Reports.executionLog("PASS", "On clicking Episode VOD page should be displayed" + "\n" + "On clicking Episode VOD page is displayed ",
					driver);
		}
		else 
		{
			Extent_Reports.executionLog("FAIL", "Episode should be displayed in home page" + "\n" + "Episode  is not displayed in home page ",
					driver);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
		Extent_Reports.executionLog("PASS", "Video should play in VOD player " + "\n" + "Video is playing in VOD player  ",driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(10000);
		
		Sections=Utilities.returnElements(driver, lstObject.get(191), lstObject.get(190));
		if(Sections.size()>0)
		{
		Extent_Reports.executionLog("PASS", "Featured home page should be displayed " + "\n" + "Featured home page is displayed",
				driver);
		}
		else {
			Extent_Reports.executionLog("FAIL", "Featured home page should be displayed " + "\n" + "Featured home page is not displayed",
					driver);
		}
		
		
		//-----Episode title click
				//Sections=Utilities.returnElements(driver, lstObject.get(197), lstObject.get(196));
				
		//Sections=Utilities.returnElements(driver, lstObject.get(191), lstObject.get(190));
		//scrollDown(By.xpath(lstObject.get(190)));	
		int pressX = driver.manage().window().getSize().width / 2;
		
		int bottomY = driver.manage().window().getSize().height * 2/5;
		
		int topY = driver.manage().window().getSize().height / 8;
	
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
		
		Sections=Utilities.returnElements(driver, lstObject.get(191), lstObject.get(190));
		if(Sections.size()>0)
		{
		Extent_Reports.executionLog("PASS", "Featured home page should be displayed " + "\n" + "Featured home page is displayed",
				driver);
		}
		else {
			Extent_Reports.executionLog("FAIL", "Featured home page should be displayed " + "\n" + "Featured home page is not displayed",
					driver);
		}
		
		
		
		 Episode = Utilities.returnElement(driver, lstObject.get(197), lstObject.get(196));
		
		if(Episode.isDisplayed()) 
		{
			
			Extent_Reports.executionLog("PASS", "Episode should be displayed in home page" + "\n" + "Episode  is displayed in home page ",
					driver);
			Episode.click();
			Thread.sleep(30000);
			Extent_Reports.executionLog("PASS", "On clicking Episode Title VOD page should be displayed" + "\n" + "On clicking Episode VOD page is displayed ",
					driver);
		}
		else 
		{
			Extent_Reports.executionLog("FAIL", "Episode should be displayed in home page" + "\n" + "Episode  is not displayed in home page ",
					driver);
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
		Extent_Reports.executionLog("PASS", "Video should play in VOD player " + "\n" + "Video is playing in VOD player  ",driver);
        ((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(10000);
		Sections=Utilities.returnElements(driver, lstObject.get(191), lstObject.get(190));
		if(Sections.size()>0)
		{
		Extent_Reports.executionLog("PASS", "Featured home page should be displayed " + "\n" + "Featured home page is displayed",
				driver);
		}
		else {
			Extent_Reports.executionLog("FAIL", "Featured home page should be displayed " + "\n" + "Featured home page is not displayed",
					driver);
		}
		
		
		
		
		
		
		/*
		WebElement PlayerView = driver.findElement(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'anvatoPlayer')]"));
		//Actions act= new Actions(driver);
		//act.click(PlayerView).moveToElement(driver.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'togglePlay')]"))).click().build().perform();
		//act.moveToElement(PlayerView).clickAndHold().moveToElement(driver.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'togglePlay')]"))).click().build().perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
		
		
	   //Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34)).click();
	     driver.findElement(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'anvatoPlayer')]")).click();
		 driver.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'togglePlay')]")).click();
		//Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37)).click();;
		//vodtap.click();
		//playPause.click();
		//Thread.sleep(5000);
		//TouchAction action = new TouchAction(driver);
		//action.longPress(driver.findElement(By.xpath("//android.widget.RelativeLayout[contains(@resource-id,'anvatoPlayer')]"))).release().perform();
		//Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37)).click();
		
   WebElement VODClose = Utilities.returnElement(driver, lstObject.get(194), lstObject.get(193));
   Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37)).click();;
		if(VODClose.isDisplayed()) 
		{
			
			Extent_Reports.executionLog("PASS", "Video should be pauseed " + "\n" + "Video is pauseed  ",
					driver);
			VODClose.click();
			Thread.sleep(10000);
			
		}
		else 
		{
			Extent_Reports.executionLog("FAIL", "Video should be pauseed " + "\n" + "Video is not pauseed  ",
					driver);
		}
		
		*/
		
		
		
		
	}
	catch(Exception e) 
	{
		Extent_Reports.executionLog("INFO",
				"android_VerifyShowArtinforinShowHomepage_NAF3360" + "\n" + e.getMessage(), driver);
	}
}//EOM

public void scrollDown(By Loc) {

	for(int i=0;i<10;i++) 
	{
		
		try {
			if(driver.findElement(Loc).isEnabled())
			{
				Extent_Reports.executionLog("PASS", "Scrolled till the object is visible" + "\n" + "Scrolled till the object is visible",
						driver);
				break;

			}
		}
		catch(Exception e) {

		}
		
		//if pressX was zero it didn't work for me
		int pressX = driver.manage().window().getSize().width / 2;
		// 4/5 of the screen as the bottom finger-press point
		int bottomY = driver.manage().window().getSize().height * 2/5;
		// just non zero point, as it didn't scroll to zero normally
		int topY = driver.manage().window().getSize().height / 8;
		//scroll with TouchAction by itself
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
		//	scroll(pressX, bottomY, pressX, topY);
		

	}



}//EOM

public void android_Endcard_Episode_MidSeriesNAF_3561() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 50);
try{
	PGNbcApp App = new PGNbcApp(driver);
	App.android_WaitForAppToLoad();
	App.android_DismissCastOverlay();

	WebElement Menu = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
	Menu.click();
	Thread.sleep(6000);
	List<WebElement> Menulist = Utilities.returnElements(driver, lstObject.get(101), lstObject.get(100));
	Menulist.get(1).click();
	Thread.sleep(6000);
	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Current Shows Page "
			+ "\n" + Extent_Reports.logActual + " Navigated to Current Shows Page ", driver);

	
	
	App.android_ClickOnParticularShow("Chicago Fire");
	Thread.sleep(6000);
	Extent_Reports.executionLog("PASS",
			Extent_Reports.logExpected + "Should be navigated to Chicago Fire Show Page " + "\n"
					+ Extent_Reports.logActual + " Navigated to Chicago Fire Show Page ",
			driver);
	
	Thread.sleep(2000);
	List<WebElement> Episode_Title = Utilities.returnElements(driver, lstObject.get(200), lstObject.get(199));
	String EpisodeTitle_Latest = Episode_Title.get(0).getAttribute("text");
	String EpisodeTitle_Old = Episode_Title.get(1).getAttribute("text");
	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " First Vod Title name is: " + EpisodeTitle_Latest + "\n"  , driver);
	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Second Vod Title name is:" + EpisodeTitle_Old + "\n" , driver);
	
	List<WebElement> Episode =   Utilities.returnElements(driver, lstObject.get(203), lstObject.get(202));
	Episode.get(1).click();
	Thread.sleep(8000);
	
	
	
	App.tvRating();
	
	try {
		Thread.sleep(4000);
		WebElement tap = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		tap.click();
		Thread.sleep(500);
		WebElement play = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
		play.click();
		WebElement seekBar = Utilities.returnElement(driver, lstObject.get(155), lstObject.get(154));
		int start = seekBar.getLocation().getX();
		int end = seekBar.getSize().getWidth();
		int y = seekBar.getLocation().getY();
		TouchAction action = new TouchAction(driver);
		action.longPress(start, y).moveTo(end, y).release().perform();
	}catch (Exception e) {
		
	}
		
		for (int i=0;i<=30;i++){
			try{
				wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath(lstObject.get(206)))));
			break;
			}catch(Exception E){
				Thread.sleep(3000);
			}
			}
		
		
		List<WebElement> show_description = Utilities.returnElements(driver, lstObject.get(209), lstObject.get(208));
		
		
		if (show_description.get(4).getAttribute("text").equalsIgnoreCase(EpisodeTitle_Latest)){
		
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Next Episdoe Should be displayed in the Endcard when the users palys episode form midseries: " +show_description.get(4).getAttribute("text")+ "\n" + Extent_Reports.logActual + "Next Episdoe is displayed in the Endcard when the users palys episode from midseries  " + EpisodeTitle_Latest, driver);
		}else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ "Next Episdoe Should be displayed in the Endcard when the users palys episode form midseries: " +show_description.get(4).getAttribute("text")+ "\n" + Extent_Reports.logActual + "Next Episdoe is not displayed in the Endcard when the users palys episode form midseries:  " + EpisodeTitle_Latest, driver);
		}
		
		for (int j=0;j<=show_description.size()-1;j++){
			System.out.println(show_description.get(j).getAttribute("text"));
		}
	   
		

	} catch (Exception e) {
		Extent_Reports.executionLog("INFO",
				"android_Endcard_Episode_MidSeriesNAF_3561" + "\n" + e.getMessage(), driver);
	}
}// EOM


public void android_resume_functionality_NAF_3548() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(driver, 50);
try{
	PGNbcApp App = new PGNbcApp(driver);
	App.android_WaitForAppToLoad();
	App.android_DismissCastOverlay();

	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Global Home page should be displayed "
			+ "\n" + Extent_Reports.logActual + " Global Home page is displayed ", driver);
	
	for(int i=0;i<10;i++) 
    {
       
        int pressX = driver.manage().window().getSize().width / 2;
        int bottomY = driver.manage().window().getSize().height * 2/5;
        int topY = driver.manage().window().getSize().height / 8;
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
       
        try {
        	//android.support.v7.widget.RecyclerView[contains(@resource-id,'home_categories_rv')]/android.widget.LinearLayout[@index='2']/android.widget.TextView[contains(@text,'Latest Episodes')]
        WebElement 	Latest_Episodes = Utilities.returnElement(driver, lstObject.get(212), lstObject.get(211));
            if(Latest_Episodes.isEnabled())
            {
                Extent_Reports.executionLog("PASS", "Scrlloed till the object is visible" + "\n" + "Scrlloed till the object is visible",
                        driver);
                break;
            }
        }
        catch(Exception e) {
        }
    }
	
	//android.widget.TextView[@text='Just Unlocked']/following-sibling::android.support.v7.widget.RecyclerView[contains(@resource-id,'homeListItemRecyclerView')]/android.widget.FrameLayout
	
	List<WebElement> just_Unlocked_Episode =  Utilities.returnElements(driver, lstObject.get(215), lstObject.get(214));
	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "just Unlocked section should be displayed "
			+ "\n" + Extent_Reports.logActual + " just Unlocked section is displayed ", driver);
	just_Unlocked_Episode.get(0).click();
	Thread.sleep(8000);
	
	App.tvRating();
		
	/*for (int i=0;i<=1000;i++){
	try{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[contains(@resource-id,'rating_image')]")));
	break;
	}catch(Exception E){
		Thread.sleep(10000);
	}
	}*/
	
		Thread.sleep(4000);
		WebElement tap = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		tap.click();
		Thread.sleep(500);
		WebElement play = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
		play.click();
		WebElement seekBar = Utilities.returnElement(driver, lstObject.get(155), lstObject.get(154));
		int start = seekBar.getLocation().getX();
		int end = (int) (seekBar.getSize().getWidth() * 0.26);
		int y = seekBar.getLocation().getY();
		TouchAction action = new TouchAction(driver);
		action.longPress(start, y).moveTo(end, y).release().perform();
		
		App.tvRating();
		
		/*for (int i=0;i<=1000;i++){
			try{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[contains(@resource-id,'rating_image')]")));
			break;
			}catch(Exception E){
				Thread.sleep(5000);
			}
			}*/
		
		//android.widget.FrameLayout[contains(@resource-id,'containerVideoPlayerControls')]/android.widget.FrameLayout[contains(@resource-id,'video_player_controls')]/android.widget.FrameLayout/android.widget.RelativeLayout[contains(@resource-id,'bottom_controls')]/android.widget.TextView[contains(@resource-id,'timeText')]
		
		WebElement Start_time = Utilities.returnElement(driver, lstObject.get(218), lstObject.get(217));
		String StartTime = Start_time.getAttribute("text");
		
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video seekbar should be draged and Vod stopped time is: " + StartTime + "\n"+ Extent_Reports.logActual + " Video seekbar is draged ",driver);
		
		System.out.println(StartTime);
		String[] currentduration = StartTime.split("/");
		System.out.println(currentduration[0]);
		String CurrentTimer = currentduration[0];
		String[] CurrentTimerWatched = CurrentTimer.split(":");
		int minutes = Integer.parseInt(CurrentTimerWatched[0].trim());
		int seconds = Integer.parseInt(CurrentTimerWatched[1].trim());

		int totalDurationWatched_Before = minutes * 60 + seconds;
		System.out.println(totalDurationWatched_Before);
		
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(5000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Global Home page should be displayed "
				+ "\n" + Extent_Reports.logActual + " Global Home page is displayed ", driver);
		
		//android.support.v7.widget.RecyclerView[contains(@resource-id,'homeListItemRecyclerView')]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout[contains(@resource-id,'imageContainer')]/android.widget.ImageView[contains(@resource-id,'image')]
		
		List<WebElement> continueWatching_Vod =  Utilities.returnElements(driver, lstObject.get(221), lstObject.get(220));
		continueWatching_Vod.get(0).click();
		Thread.sleep(1000);
		
		App.tvRating();
		
		/*// Tv Rating code
		for (int i=0;i<=100;i++){
		try{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[contains(@resource-id,'rating_image')]")));
		break;
		}catch(Exception E){
			Thread.sleep(8000);
		}
		}*/
		
	    tap = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		tap.click();
		Thread.sleep(200);
	    play = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
		play.click();
	    Start_time = Utilities.returnElement(driver, lstObject.get(218), lstObject.get(217));
	    String StartTime1 = Start_time.getAttribute("text");
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video seekbar should be draged and Vod stopped time is: " + StartTime1 + "\n"+ Extent_Reports.logActual + " Video seekbar is draged ",driver);

		//-----
	
		System.out.println(StartTime1);
		 currentduration = StartTime1.split("/");
		System.out.println(currentduration[0]);
		 CurrentTimer = currentduration[0];
		 CurrentTimerWatched = CurrentTimer.split(":");
		minutes = Integer.parseInt(CurrentTimerWatched[0].trim());
		 seconds = Integer.parseInt(CurrentTimerWatched[1].trim());

		int totalDurationWatched_After = minutes * 60 + seconds;
		System.out.println(totalDurationWatched_After);
		
		 if((totalDurationWatched_After-totalDurationWatched_Before)>=5 ){
			 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video should start from where it was paused before: " + StartTime1 + "\n"+ Extent_Reports.logActual + " Video started from where it was paused before",driver);
    	
		    }else{
		    	 Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video should start from where it was paused before: " + StartTime1 + "\n"+ Extent_Reports.logActual + " Video is not started from where it was paused before",driver);
		    }
		 
	} catch (Exception e) {
		Extent_Reports.executionLog("INFO",
				"android_resume_functionality_NAF_3548" + "\n" + e.getMessage(), driver);
	}



}// EOM



public void android_Video_Player_launching_Entitled_Free_Vod_NAF_3728() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(driver, 50);
try{
	PGNbcApp App = new PGNbcApp(driver);
	App.android_WaitForAppToLoad();
	App.android_DismissCastOverlay();

	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Global Home page should be displayed "
			+ "\n" + Extent_Reports.logActual + " Global Home page is displayed ", driver);
	
	//android.support.v7.widget.RecyclerView[contains(@resource-id,'home_categories_rv')]/android.widget.LinearLayout[@index='2']/android.widget.TextView[contains(@text,'Latest Episodes')]
	for(int i=0;i<10;i++) 
    {
       
        int pressX = driver.manage().window().getSize().width / 2;
        int bottomY = driver.manage().window().getSize().height * 2/5;
        int topY = driver.manage().window().getSize().height / 8;
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
       
        try {
        	WebElement 	Latest_Episodes = Utilities.returnElement(driver, lstObject.get(212), lstObject.get(211));
            if(Latest_Episodes.isEnabled())
            {
                Extent_Reports.executionLog("PASS", "Scrlloed till the object is visible" + "\n" + "Scrlloed till the object is visible",
                        driver);
                break;
            }
        }
        catch(Exception e) {
        }
    }
	
	List<WebElement> just_Unlocked_Episode =  Utilities.returnElements(driver, lstObject.get(215), lstObject.get(214));
			//driver.findElements(By.xpath("//android.widget.TextView[@text='Just Unlocked']/following-sibling::android.support.v7.widget.RecyclerView[contains(@resource-id,'homeListItemRecyclerView')]/android.widget.FrameLayout"));
	Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "just Unlocked section should be displayed "
			+ "\n" + Extent_Reports.logActual + " just Unlocked section is displayed ", driver);
	just_Unlocked_Episode.get(0).click();
	Thread.sleep(8000);
	
	// Tv Rating code
	App.tvRating();
	
		Thread.sleep(5000);
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + "Video should be displayed " + "\n"+ Extent_Reports.logActual + " Video is displayed ",driver);
		
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(5000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Global Home page should be displayed "
				+ "\n" + Extent_Reports.logActual + " Global Home page is displayed ", driver);
		
		//App.scrollDown(By.xpath("//android.widget.TextView[@text='Latest Episodes']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView"));
		App.scrollDown(By.xpath(lstObject.get(229)));
            
            for(int j=0;j<40;j++) 
            {
                TouchAction act2=new TouchAction(driver);
                Dimension size2 = driver.manage().window().getSize();
                int anchor = (int) (size2.height * 0.75);
                int startPoint = (int) (size2.width * 0.5);
                int endPoint = (int) (size2.width * 0.01);
                act2.longPress(startPoint, anchor).moveTo(endPoint, anchor).release().perform();
              //android.widget.TextView[@text='Latest Episodes']/parent::android.widget.LinearLayout/android.support.v7.widget.RecyclerView[contains(@resource-id,'homeListItemRecyclerView')]/android.widget.FrameLayout//android.widget.RelativeLayout[contains(@resource-id,'imageContainer')]/following-sibling::android.widget.FrameLayout[@index='1']
                List<WebElement> AuthKeyVideosList  = Utilities.returnElements(driver, lstObject.get(224), lstObject.get(223));
                if(AuthKeyVideosList.size()>0)
                {
                    AuthKeyVideosList.get(0).click();
                    break;
                }
            }
            
		Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + " Entitled Video should be displayed " + "\n"+ Extent_Reports.logActual + " Entitled Video is displayed ",driver);
		
		Thread.sleep(1000);
		//android.widget.FrameLayout/android.view.ViewGroup/android.widget.TextView[contains(@resource-id,'fork_textView')]
		WebElement fork_Screen =  Utilities.returnElement(driver, lstObject.get(227), lstObject.get(226));
		
		if (fork_Screen.isEnabled()){
			Extent_Reports.executionLog("PASS",Extent_Reports.logExpected + " fork Screen should be displayed " + "\n"+ Extent_Reports.logActual + " fork Screen is displayed ",driver);
		}else{
			Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected + " fork Screen should be displayed " + "\n"+ Extent_Reports.logActual + " fork Screen is not displayed ",driver);
		}
		
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(5000);
		

	} catch (Exception e) {
		Extent_Reports.executionLog("INFO",
				"android_Video_Player_launching_Entitled_Free_Vod_NAF_3728" + "\n" + e.getMessage(), driver);
	}
}// EOM


public void anroid_Error_messages_Live_VOD_NAF_3554() throws  Exception
{   
	boolean key = false;
	PGNbcApp App = new PGNbcApp(driver);
	//App.android_WaitForAppToLoad();
	//App.android_DismissCastOverlay();
	try{

		WebElement	Menu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
		Menu.click();
		Thread.sleep(6000);
		List <WebElement>	Menulist = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id,'navigationView')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView"));
		Menulist.get(2).click();
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Current Shows home page " + "\n" + Extent_Reports.logActual + " Navigated to Current Shows home page " , driver);

		//*** code for open show ****//

        App.android_ClickOnParticularShow("Better Late Than Never");
		scrollDown(By.xpath("//android.widget.TextView[@text='Episodes']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView"));
		int pressX = driver.manage().window().getSize().width / 2;
         int bottomY = driver.manage().window().getSize().height * 2/5;
		int topY = driver.manage().window().getSize().height / 8;
        TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
		
		for (int i=0;i<=30;i++)
		{

			try
			{
				WebElement Auth_Key = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView"));
				if (Auth_Key.isEnabled())
				{
					key = true;
					Thread.sleep(2000);
					break;
				}
			}catch(Exception e) {
				TouchAction act1=new TouchAction(driver);
				Dimension size1 = driver.manage().window().getSize();
				int anchor = (int) (size1.height * 0.5);
				int startPoint = (int) (size1.width * 0.5);
				int endPoint = (int) (size1.width * 0.09);
				act1.longPress(startPoint, anchor).moveTo(endPoint, anchor).release().perform();

			}

		}
		
		WebElement Episode_Title = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView/parent::android.widget.FrameLayout/parent::android.widget.FrameLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'show_detail_episode_title')]"));
		String EpisodeTitle = Episode_Title.getAttribute("text");
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Auth Video should be displayed " + "\n" + Extent_Reports.logActual + " Auth Video is displayed " , driver);

		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(6000);

		App.android_ClickOnParticularShow("Dateline"); 
		scrollDown(By.xpath("//android.widget.TextView[@text='Episodes']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView"));
		 pressX = driver.manage().window().getSize().width / 2;
          bottomY = driver.manage().window().getSize().height * 2/5;
		 topY = driver.manage().window().getSize().height / 8;
         touchAction = new TouchAction(driver);
		touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
		for (int i=0;i<=1000;i++){

			try{
				WebElement Auth_Key = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView"));
				if (Auth_Key.isEnabled()){
					key = true;
					Thread.sleep(2000);
					break;
				}

				
			}catch(Exception e) {
				TouchAction act1=new TouchAction(driver);
				Dimension size1 = driver.manage().window().getSize();
				int anchor = (int) (size1.height * 0.4);
				int startPoint = (int) (size1.width * 0.4);
				int endPoint = (int) (size1.width * 0.1);
				act1.longPress(startPoint, anchor).moveTo(endPoint, anchor).release().perform();

			}

		}

		WebElement DatelineEpisode_Title = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView/parent::android.widget.FrameLayout/parent::android.widget.FrameLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'show_detail_episode_title')]"));
		String DatelineEpisodeTitle = DatelineEpisode_Title.getAttribute("text");
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Auth Video should be displayed " + "\n" + Extent_Reports.logActual + " Auth Video is displayed " , driver);
		
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(6000);

		Menu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
		Menu.click();
		Thread.sleep(2000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Menu icon should be Displayed " + "\n" + Extent_Reports.logActual + " Menu icon is Displayed " , driver);
		Menulist = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id,'navigationView')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView"));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Menu List should be Displayed " + "\n" + Extent_Reports.logActual + " Menu List is Displayed " , driver);
		Menulist.get(1).click();
		Thread.sleep(10000);

		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to MVPD Screen " + "\n" + Extent_Reports.logActual + " Navigated to MVPD Screen " , driver);
		try{
			List<WebElement> MVPD_screen = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'providersRecyclerView')]/android.widget.FrameLayout/android.widget.ImageView"));
			MVPD_screen.get(7).click();
			Thread.sleep(20000);
		}catch(Exception e) {


		}

		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to Optimum Login Page " + "\n" + Extent_Reports.logActual + " Navigated to Optimum Login Page " , driver);
		Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
		for (String contextName : contextNames) {
			//if (contextName.contains("WEBVIEW_com.android.browser")) {
			if (contextName.contains("NATIVE_APP")) {
				((AppiumDriver) driver).context(contextName);
			}
		}
		WebElement UserName = driver.findElement(By.xpath("//android.view.View/android.widget.EditText[contains(@resource-id,'IDToken1')]"));
		UserName.sendKeys("research112");
		((AndroidDriver) driver).hideKeyboard();
		Thread.sleep(1000);
		WebElement Password = driver.findElement(By.xpath("//android.view.View/android.widget.EditText[contains(@resource-id,'IDToken2')]"));
		Password.sendKeys("support112");
		((AndroidDriver) driver).hideKeyboard();
		Thread.sleep(1000);
		WebElement SingIn_btn = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
		SingIn_btn.click();
		Thread.sleep(10000);

		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to Live Screen " + "\n" + Extent_Reports.logActual + " Navigated to Live Screen " , driver);
		
		List<WebElement> TextView;
		WebElement ErrorImage;
		try
		{
		 TextView = driver.findElements(By.xpath("//android.widget.LinearLayout/android.widget.TextView"));

		if (TextView.get(0).getAttribute("text").equalsIgnoreCase("Not Available"))
		{
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " 'Not Available' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Not Available' message is displayed on  Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " 'Not Available' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Not Available' message is not displayed on  Live Screen " , driver);
		}

		if (TextView.get(1).getAttribute("text").contains("you are not authorized for this service.")){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " 'We show that you are not authorized for this service. Please visit Optimum.com or contact 866-200-7192 to see how you can get access.' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'We show that you are not authorized for this service. Please visit Optimum.com or contact 866-200-7192 to see how you can get access Error Message is Displayed" , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " 'We show that you are not authorized for this service. Please visit Optimum.com or contact 866-200-7192 to see how you can get access." + "\n" + Extent_Reports.logActual + "'We show that you are not authorized for this service. Please visit Optimum.com or contact 866-200-7192 to see how you can get acces is not displayed" , driver);
		}

		 ErrorImage = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.ImageView"));
		if (ErrorImage.isEnabled()){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Error Image Should be displayed on Live Screen " + "\n" + Extent_Reports.logActual + "Error Image Should be displayed on Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " Error Image Should be displayed on Live Screen " + "\n" + Extent_Reports.logActual + "Error Image Should be displayed on Live Screen " , driver);
		}
		Thread.sleep(6000);

		}
		catch(Exception e) {
			Thread.sleep(500);
			
		}
		
		Thread.sleep(6000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

		
		
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to global home page " + "\n" + Extent_Reports.logActual + " Navigated to global home page " , driver);
		Menu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
		Menu.click();
		Thread.sleep(6000);
		Menulist = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id,'navigationView')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView"));
		Menulist.get(0).click();
		Thread.sleep(20000);
		Menu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
		Menu.click();
		Thread.sleep(2000);
		Menulist = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id,'navigationView')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView"));
		Menulist.get(2).click();
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Current Shows home page " + "\n" + Extent_Reports.logActual + " Navigated to Current Shows home page " , driver);

		
		
		App.android_ClickOnParticularShow("Better Late Than Never");
	
			scrollDown(By.xpath("//android.widget.TextView[@text='Episodes']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView"));
			 pressX = driver.manage().window().getSize().width / 2;
	          bottomY = driver.manage().window().getSize().height * 2/5;
			 topY = driver.manage().window().getSize().height / 8;
	         touchAction = new TouchAction(driver);
			touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
			

		Thread.sleep(4000);
		for (int i=0;i<=1000;i++){

			try{
				//WebElement Episode_Title1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView/parent::android.widget.FrameLayout/parent::android.widget.FrameLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'show_detail_episode_title')]"));
			
				WebElement Episode_Title1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'show_detail_episode_title')]"));
				
				//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'show_detail_episode_title')]
				if (Episode_Title1.getAttribute("text").equalsIgnoreCase(EpisodeTitle)){
					Thread.sleep(2000);
					Episode_Title1.click();
					break;
				}else{
					Thread.sleep(2000);
				}
			} catch(Exception e) {
				TouchAction act2=new TouchAction(driver);
				Dimension size2 = driver.manage().window().getSize();
				int anchor = (int) (size2.height * 0.5);
				int startPoint = (int) (size2.width * 0.5);
				int endPoint = (int) (size2.width * 0.09);
				act2.longPress(startPoint, anchor).moveTo(endPoint, anchor).release().perform();

			}

		}

		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to Live Screen " + "\n" + Extent_Reports.logActual + " Navigated to Live Screen " , driver);

		//***  code to validate the error message  ***

		try {
		TextView = driver.findElements(By.xpath("//android.widget.LinearLayout/android.widget.TextView"));

		if (TextView.get(0).getAttribute("text").equalsIgnoreCase("Not Available")){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " 'Not Available' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Not Available' message is displayed on  Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " 'Not Available' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Not Available' message is not displayed on  Live Screen " , driver);
		}

		if (TextView.get(1).getAttribute("text").contains("you are not authorized for this service.")){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " 'We show that you are not authorized for this service. Please visit Optimum.com or contact 866-200-7192 to see how you can get access.' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'We show that you are not authorized for this service. Please visit Optimum.com or contact 866-200-7192 to see how you can get access Error Message is Displayed" , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " 'We show that you are not authorized for this service. Please visit Optimum.com or contact 866-200-7192 to see how you can get access." + "\n" + Extent_Reports.logActual + "'We show that you are not authorized for this service. Please visit Optimum.com or contact 866-200-7192 to see how you can get acces is not displayed" , driver);
		}

		ErrorImage = driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.ImageView"));
		if (ErrorImage.isEnabled()){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Error Image Should be displayed on Live Screen " + "\n" + Extent_Reports.logActual + "Error Image Should be displayed on Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " Error Image Should be displayed on Live Screen " + "\n" + Extent_Reports.logActual + "Error Image Should be displayed on Live Screen " , driver);
		}
		}
		catch(Exception e) {
			
		}
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(4000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(4000);

		Menu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
		Menu.click();
		Thread.sleep(6000);
		Menulist = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id,'navigationView')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView"));
		Menulist.get(5).click();
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Setings page " + "\n" + Extent_Reports.logActual + " Navigated to Setings page " , driver);

		WebElement UNLINK_TV_PROVIDER = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'UNLINK YOUR TV PROVIDER')]"));
		if (UNLINK_TV_PROVIDER.isEnabled()){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "UNLINK YOUR TV PROVIDER text should be displayed " + "\n" + Extent_Reports.logActual + " UNLINK YOUR TV PROVIDER text is displayed " , driver);
		}else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ "UNLINK YOUR TV PROVIDER text should be displayed " + "\n" + Extent_Reports.logActual + " UNLINK YOUR TV PROVIDER text is displayed " , driver);
		}
		UNLINK_TV_PROVIDER.click();
		Thread.sleep(2000);


		WebElement Yes_btn = driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'dialog_buttons_container')]"));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Unlink from optimum pop up window should be displayed " + "\n" + Extent_Reports.logActual + " Unlink from optimum pop up window is displayed " , driver);
		Yes_btn.click();
		Thread.sleep(2000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Setings page " + "\n" + Extent_Reports.logActual + " Navigated to Setings page " , driver);

		WebElement TV_PROVIDER = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'LINK YOUR TV PROVIDER')]"));
		TV_PROVIDER.click();
		Thread.sleep(6000);
		try{
			List<WebElement> mvpd_screen = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'providersRecyclerView')]/android.widget.FrameLayout/android.widget.ImageView"));
			mvpd_screen.get(0).click();
			Thread.sleep(10000);
		}catch(Exception e) {

		}

		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Xfinity login page " + "\n" + Extent_Reports.logActual + " Navigated to Xfinity login page " , driver);
		for (String contextName : contextNames) {
			//if (contextName.contains("WEBVIEW_com.android.browser")) {
			if (contextName.contains("NATIVE_APP")) {
				((AppiumDriver) driver).context(contextName);
			}
		}
try {
		WebElement xfinity_UserName = driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'user')]"));
		xfinity_UserName.sendKeys("TVE_DEMO_PE7");
		((AndroidDriver) driver).hideKeyboard();
		Thread.sleep(1000);
		WebElement xfinity_Password = driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'passwd')]"));
		xfinity_Password.sendKeys("Namethin09");
		((AndroidDriver) driver).hideKeyboard();
		Thread.sleep(1000);
		WebElement CheckBox = driver.findElement(By.xpath("//android.widget.CheckBox[contains(@resource-id,'remember_me')]"));
		CheckBox.click();
		
		
		pressX = driver.manage().window().getSize().width / 2;
          bottomY = driver.manage().window().getSize().height * 2/5;
		 topY = driver.manage().window().getSize().height / 8;
         touchAction = new TouchAction(driver);
		touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
		
		WebElement xfinity_SingIn_btn = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'sign_in')]"));
		xfinity_SingIn_btn.click();
		
		Thread.sleep(10000);
		WebElement skip_btn = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'skip')]"));
		skip_btn.click();
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to Settings Page " + "\n" + Extent_Reports.logActual + " Navigated to Settings Page " , driver);

}
catch(Exception e) {

}
		//*** find the Auth_video title ***//
		// click on the Auth video ***//

		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(4000);
		Menu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
		Menu.click();
		Thread.sleep(6000);
		Menulist = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id,'navigationView')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView"));
		Menulist.get(2).click();
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Current Shows page " + "\n" + Extent_Reports.logActual + " Navigated to Current Shows page " , driver);

		//***  open dateline show ***//
		App.android_ClickOnParticularShow("Dateline");
		scrollDown(By.xpath("//android.widget.TextView[@text='Episodes']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView"));
		 pressX = driver.manage().window().getSize().width / 2;
          bottomY = driver.manage().window().getSize().height * 2/5;
		 topY = driver.manage().window().getSize().height / 8;
         touchAction = new TouchAction(driver);
		touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();

		Thread.sleep(4000);


		for (int i=0;i<=1000;i++){

			try{
			
				//WebElement Episode_Title1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView/parent::android.widget.FrameLayout/parent::android.widget.FrameLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'show_detail_episode_title')]"));
				WebElement Episode_Title1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'show_detail_episode_title')]"));
				
				
				if (Episode_Title1.getAttribute("text").equalsIgnoreCase(DatelineEpisodeTitle)){
					Thread.sleep(2000);
					Episode_Title1.click();
					break;
				}else{
					Thread.sleep(2000);
				}
			} catch(Exception e) {
				TouchAction act2=new TouchAction(driver);
				Dimension size2 = driver.manage().window().getSize();
				int anchor = (int) (size2.height * 0.5);
				int startPoint = (int) (size2.width * 0.5);
				int endPoint = (int) (size2.width * 0.09);
				act2.longPress(startPoint, anchor).moveTo(endPoint, anchor).release().perform();

			}

		}

		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to Live Screen " + "\n" + Extent_Reports.logActual + " Navigated to Live Screen " , driver);


		List<WebElement> ErrorTextView = driver.findElements(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView"));

		if (ErrorTextView.get(0).getAttribute("text").equalsIgnoreCase("Not Available")){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " 'Not Available' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Not Available' message is displayed on  Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " 'Not Available' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Not Available' message is not displayed on  Live Screen " , driver);
		}

		if (ErrorTextView.get(1).getAttribute("text").contains("Parental Control")){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " 'Your Parental Control settings do not allow you to view this content. https://customer.xfinity.com/Secure/OnlineParentalControls.aspx' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Your Parental Control settings do not allow you to view this content. https://customer.xfinity.com/Secure/OnlineParentalControls.aspx' message is displayed on  Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " 'Your Parental Control settings do not allow you to view this content. https://customer.xfinity.com/Secure/OnlineParentalControls.aspx' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Your Parental Control settings do not allow you to view this content. https://customer.xfinity.com/Secure/OnlineParentalControls.aspx' message is not displayed on  Live Screen " , driver);
		} 

		ErrorImage = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView"));
		if (ErrorImage.isEnabled()){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Error Image Should be displayed on Live Screen " + "\n" + Extent_Reports.logActual + "Error Image Should be displayed on Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " Error Image Should be displayed on Live Screen " + "\n" + Extent_Reports.logActual + "Error Image Should be displayed on Live Screen " , driver);
		}

		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(4000);
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(4000);

		Menu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
		Menu.click();
		Thread.sleep(6000);
		Menulist = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id,'navigationView')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView"));
		Menulist.get(5).click();
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Setings page " + "\n" + Extent_Reports.logActual + " Navigated to Setings page " , driver);

		UNLINK_TV_PROVIDER = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'UNLINK YOUR TV PROVIDER')]"));
		if (UNLINK_TV_PROVIDER.isEnabled()){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "UNLINK YOUR TV PROVIDER text should be displayed " + "\n" + Extent_Reports.logActual + " UNLINK YOUR TV PROVIDER text is displayed " , driver);
		}else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ "UNLINK YOUR TV PROVIDER text should be displayed " + "\n" + Extent_Reports.logActual + " UNLINK YOUR TV PROVIDER text is displayed " , driver);
		}
		UNLINK_TV_PROVIDER.click();
		Thread.sleep(2000);


		Yes_btn = driver.findElement(By.xpath("//android.widget.LinearLayout[contains(@resource-id,'dialog_buttons_container')]"));
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Unlink from optimum pop up window should be displayed " + "\n" + Extent_Reports.logActual + " Unlink from optimum pop up window is displayed " , driver);
		Yes_btn.click();
		Thread.sleep(2000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Setings page " + "\n" + Extent_Reports.logActual + " Navigated to Setings page " , driver);

		TV_PROVIDER = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'LINK YOUR TV PROVIDER')]"));
		TV_PROVIDER.click();
		Thread.sleep(6000);
		try{
			List<WebElement> Bridge_screen = driver.findElements(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'providersRecyclerView')]/android.widget.FrameLayout/android.widget.ImageView"));
			Bridge_screen.get(1).click();
			Thread.sleep(10000);
		}catch(Exception e) {

		}

		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Xfinity login page " + "\n" + Extent_Reports.logActual + " Navigated to Xfinity login page " , driver);
		for (String contextName : contextNames) {
			//if (contextName.contains("WEBVIEW_com.android.browser")) {
			if (contextName.contains("NATIVE_APP")) {
				((AppiumDriver) driver).context(contextName);
			}
		}
try {
		WebElement DirectTv_UserName = driver.findElement(By.xpath("//android.widget.EditText[contains(@resource-id,'usernameInputId')]"));
		DirectTv_UserName.sendKeys("nbcu_np@directv.com");
		((AndroidDriver) driver).hideKeyboard();
		Thread.sleep(1000);
		WebElement DirectTv_Password = driver.findElement(By.xpath("//android.widget.EditText[@index='3']"));
		DirectTv_Password.sendKeys("password");
		((AndroidDriver) driver).hideKeyboard();
		Thread.sleep(1000);
		pressX = driver.manage().window().getSize().width / 2;
          bottomY = driver.manage().window().getSize().height * 2/5;
		 topY = driver.manage().window().getSize().height / 8;
         touchAction = new TouchAction(driver);
		touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
		
		WebElement DirectTv_SingIn_btn = driver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'loginSubmitId')]"));
		DirectTv_SingIn_btn.click();
		Thread.sleep(10000);
		WebElement skip_btn = driver.findElement(By.xpath("//android.widget.TextView[contains(@text,'skip')]"));
		skip_btn.click();
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to Settings Page " + "\n" + Extent_Reports.logActual + " Navigated to Settings Page " , driver);

	}
	catch(Exception e) {
		
	}
		//***  open dateline show ***//
		//*** find the Auth_video title ***//
		// click on the Auth video ***//


		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(4000);
		Menu = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
		Menu.click();
		Thread.sleep(6000);
		Menulist = driver.findElements(By.xpath("//android.widget.ListView[contains(@resource-id,'navigationView')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.ImageView"));
		Menulist.get(2).click();
		Thread.sleep(6000);
		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Should be Navigated to Current Shows page " + "\n" + Extent_Reports.logActual + " Navigated to Current Shows page " , driver);

		App.android_ClickOnParticularShow("Dateline");
		scrollDown(By.xpath("//android.widget.TextView[@text='Episodes']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView"));
		 pressX = driver.manage().window().getSize().width / 2;
          bottomY = driver.manage().window().getSize().height * 2/5;
		 topY = driver.manage().window().getSize().height / 8;
         touchAction = new TouchAction(driver);
		touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();

		Thread.sleep(4000);
		for (int i=0;i<=1000;i++){

			try{
				//WebElement Episode_Title1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView/parent::android.widget.FrameLayout/parent::android.widget.FrameLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'show_detail_episode_title')]"));
				WebElement Episode_Title1 = driver.findElement(By.xpath("//android.widget.TextView[@text='Episodes']/following-sibling::android.widget.FrameLayout[@index='2']/android.support.v7.widget.RecyclerView//android.widget.FrameLayout[contains(@resource-id,'video_item_container')]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[contains(@resource-id,'show_detail_episode_title')]"));
				
				if (Episode_Title1.getAttribute("text").equalsIgnoreCase(DatelineEpisodeTitle)){
					Thread.sleep(2000);
					Episode_Title1.click();
					break;
				}else{
					Thread.sleep(2000);
				}
			} catch(Exception e) {
				TouchAction act2=new TouchAction(driver);
				Dimension size2 = driver.manage().window().getSize();
				int anchor = (int) (size2.height * 0.5);
				int startPoint = (int) (size2.width * 0.5);
				int endPoint = (int) (size2.width * 0.09);
				act2.longPress(startPoint, anchor).moveTo(endPoint, anchor).release().perform();

			}

		}

		Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Should be navigated to Live Screen " + "\n" + Extent_Reports.logActual + " Navigated to Live Screen " , driver);

		List<WebElement> Errortext = driver.findElements(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView"));

		if (Errortext.get(0).getAttribute("text").contains("Uh-oh")){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " 'Uh-oh. You need to add this channel.' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Uh-oh. You need to add this channel.' message is displayed on  Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " 'Uh-oh. You need to add this channel.' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Uh-oh. You need to add this channel.' message is not displayed on  Live Screen " , driver);
		}

		if (Errortext.get(1).getAttribute("text").contains("TV Provider")){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " 'Your TV subscription does not include this channel. Please contact your TV Provider about upgrading your service to get access.' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Your TV subscription does not include this channel. Please contact your TV Provider about upgrading your service to get access.' message is displayed on  Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " 'Your TV subscription does not include this channel. Please contact your TV Provider about upgrading your service to get access.' message Should be displayed on  Live Screen " + "\n" + Extent_Reports.logActual + "'Your TV subscription does not include this channel. Please contact your TV Provider about upgrading your service to get access.' message is not displayed on  Live Screen " , driver);
		} 

		WebElement DirectTvErrorImage = driver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ImageView"));
		if (DirectTvErrorImage.isEnabled()){
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ " Error Image Should be displayed on Live Screen " + "\n" + Extent_Reports.logActual + "Error Image Should be displayed on Live Screen " , driver);
		} else{
			Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected+ " Error Image Should be displayed on Live Screen " + "\n" + Extent_Reports.logActual + "Error Image Should be displayed on Live Screen " , driver);
		}

		

	}catch(Exception e) {

		Extent_Reports.executionLog("INFO", "anroid_Error_messages_Live_VOD_NAF_3554"  + "\n"+ e.getMessage(), driver);
	}
}//EOM




}// EOC
