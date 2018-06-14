package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
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

public class PGNbcProfile {
	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> objShowLists, objShowList, statictext, MPVD_linkproviderlist, SignBtn, SignInPage_Link_Text;
	String sqlQry, Status;
	WebElement objnav, objRespNavBar, objClipDropDownWebEx, MenuIcon, objShowLink, Setting_Icon, Tv_provider,
			LINKPROVIDER_Text, closeIcon, Faq_linkText, Faq, Back_btn, Home, Scrollobj, Faq_target;
	WebElement SignIn, Email, password, show_pwd, Sign_UpLink, Sign_Up_Page, forkscreen, bridge_screen, skip,
			Email_SignIn, SignIn_btn, nbcSignupsuccess, SignoutFrmNbc, View_Schedule, toggle, link_Tv_provider, close,
			Vod_Player, stationLogo, Tvproviderlogo, startwatch_btn, closedcaption, invalidPaswrd_Error, passwrd,
			CCtoggle, Email_Signup, SignUp, chkBox, SettingsTitle, SignUp_btn;

	// Constructor to initialize all the Page Objects
	public PGNbcProfile(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGNbcProfile", "Input");
		lstObject = db.getTestDataObject("Select * from PGNbcProfile", "ObjectRepository");
	}

	public void android_Verify_NbcProfile() throws Throwable {
		PGNbcApp App = new PGNbcApp(driver);
		App.android_WaitForAppToLoad();
		App.android_DismissCastOverlay();
		Thread.sleep(2000);
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("SETTINGS");
		SignUp_btn = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		SignUp_btn.click();

		Thread.sleep(6000);
		PGAndroidApp nbc = new PGAndroidApp(driver);
		nbc.android_NBCSignUP_Email();
		nbc.android_startwatching_forkscreen();
		nbc.android_signoutfromNBC();
		nbc.android_NBCSignOut();
		AndApp.android_OpenMenu("SETTINGS");
		SignIn_btn = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
		SignIn_btn.click();
		nbc.android_NBCSignIn_Email();
	}
	public void android_Verify_Acptance() throws Throwable {
		PGNbcApp App = new PGNbcApp(driver);
		App.android_WaitForAppToLoad();
		App.android_DismissCastOverlay();
		Thread.sleep(2000);
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("SETTINGS");
	}
	public void android_Verify_NbcSignInFails() throws Throwable {
		PGNbcApp App = new PGNbcApp(driver);
		// App.android_WaitForAppToLoad();
		// App.android_DismissCastOverlay();
		Thread.sleep(2000);
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("SETTINGS");
		SignIn_btn = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
		SignIn_btn.click();
		PGAndroidApp nbc = new PGAndroidApp(driver);

		nbc.android_NBCSignIn_IncorrectPasswrd();
		Thread.sleep(6000);

		invalidPaswrd_Error = Utilities.returnElement(driver, lstObject.get(182), lstObject.get(181));

		if (invalidPaswrd_Error.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					"invalidPaswrd Error Should be Displayed" + "\n" + "invalidPaswrd Error is Displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					"invalidPaswrd Error Should be Displayed" + "\n" + "invalidPaswrd Error is not Displayed", driver);
		}

	}

	public void android_Verify_LinkTvProviderbridgeScreen() throws Exception {

		PGNbcApp App = new PGNbcApp(driver);
		// App.android_WaitForAppToLoad();
		// App.android_DismissCastOverlay();

		Thread.sleep(6000);
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();

		PGAndroidApp nbc = new PGAndroidApp(driver);
		nbc.android_OpenMenu("SETTINGS");

		SignUp_btn = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		SignUp_btn.click();

		Thread.sleep(2000);
		nbc.android_NBCSignUP_Email();
		// nbc.android_startwatching_forkscreen();
		link_Tv_provider = Utilities.returnElement(driver, lstObject.get(155), lstObject.get(154));
		if (link_Tv_provider.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					"Start watching and Link TV provider should be after SgnUp/SignIn to NBC: " + "\n"
							+ "Start watching and Link TV provider  displayed",
					driver);
			link_Tv_provider.click();
		} else {
			Extent_Reports.executionLog("FAIL",
					"Start watching and Link TV provider should be after SgnUp/SignIn to NBC: " + "\n"
							+ "Start watching and Link TV provider not displayed",
					driver);
		}

		nbc.anroid_MVPDPicker("optimum");
		Thread.sleep(5000);
		nbc.android_UnlinkTvProvider();

		nbc.android_NBCSignOut();
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		nbc.android_OpenMenu("SETTINGS");
		SignIn_btn = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
		SignIn_btn.click();
		nbc.android_NBCSignIn_Email();
		nbc.android_LinkTvproviderBridge_Yes();
		nbc.anroid_MVPDPicker("optimum");
		nbc.android_UnlinkTvProvider();

	}

	public void android_NBCSignUP_EmailValidation() throws Throwable {
		PGNbcApp App = new PGNbcApp(driver);
		// App.android_WaitForAppToLoad();
		// App.android_DismissCastOverlay();
		Thread.sleep(2000);
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("SETTINGS");
		Thread.sleep(4000);
		SignUp_btn = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		SignUp_btn.click();

		Thread.sleep(6000);
		PGAndroidApp nbc = new PGAndroidApp(driver);
		nbc.android_EmailValidation();
	}

	public void android_Verify_Authentication_Live() throws Throwable {

		PGNbcApp App = new PGNbcApp(driver);
		// App.android_WaitForAppToLoad();
		// App.android_DismissCastOverlay();
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		Thread.sleep(4000);
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("LIVE");
		AndApp.anroid_MVPDPicker("optimum");

		Thread.sleep(5000);
		Vod_Player = Utilities.returnElement(driver, lstObject.get(158), lstObject.get(157));

		toggle = Utilities.returnElement(driver, lstObject.get(161), lstObject.get(160));

		Vod_Player.click();
		toggle.click();

		stationLogo = Utilities.returnElement(driver, lstObject.get(164), lstObject.get(163));

		if (stationLogo.isEnabled()) {
			Extent_Reports.executionLog("PASS", " Connected TV Station Logo  should be displayed " + "\n"
					+ " Connected TV Station Logo is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", " Connected TV Station Logo  should be displayed " + "\n"
					+ " Connected TV Station Logo is not displayed", driver);
		}

		Tvproviderlogo = Utilities.returnElement(driver, lstObject.get(167), lstObject.get(166));

		if (Tvproviderlogo.isEnabled()) {
			Extent_Reports.executionLog("PASS", "  TV Provider Logo  should be displayed on live Player Page" + "\n"
					+ " TV Provider Logo is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", "  TV Provider Logo  should be displayed on live Player Page" + "\n"
					+ " TV Provider Logo is not displayed", driver);
		}
		View_Schedule = Utilities.returnElement(driver, lstObject.get(170), lstObject.get(69));

		if (View_Schedule.isEnabled()) {
			Extent_Reports.executionLog("PASS", " View Schedule Button should be displayed on live Player Page" + "\n"
					+ " View Schedule Button  is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", " View Schedule Button should be displayed on live Player Page" + "\n"
					+ " View Schedule Button  is not displayed", driver);
		}

		CCtoggle = Utilities.returnElement(driver, lstObject.get(173), lstObject.get(172));

		if (CCtoggle.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					" CC Button should be displayed on live Player Page" + "\n" + " CC Button  is displayed", driver);
			CCtoggle.click();

		} else {
			Extent_Reports.executionLog("FAIL",
					" CC Button should be displayed on live Player Page" + "\n" + " CC Button  is not displayed",
					driver);
		}
		closedcaption = Utilities.returnElement(driver, lstObject.get(176), lstObject.get(175));

		if (closedcaption.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					" CC notifier should be displayed on live Player Page" + "\n" + " CC notifier is displayed",
					driver);
		} else {
			Extent_Reports.executionLog("PASS",
					" CC notifier should be displayed on live Player Page" + "\n" + " CC notifier is not displayed",
					driver);
		}
		close = Utilities.returnElement(driver, lstObject.get(179), lstObject.get(178));

		if (close.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					" close Button should be displayed on live Player Page" + "\n" + " close Button  is displayed",
					driver);
			close.click();
		} else {
			Extent_Reports.executionLog("FAIL",
					" close Button should be displayed on live Player Page" + "\n" + " close Button  is not displayed",
					driver);
		}
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		AndApp.android_OpenMenu("LIVE");

	}// EOM

	public void android_NBC_Profile_With_Facebook_NAF_4684() throws Exception {
		PGNbcApp pgnbcappobj = new PGNbcApp(driver);
		try {
			PGNbcApp App = new PGNbcApp(driver);
			// App.android_WaitForAppToLoad();
			// App.android_DismissCastOverlay();

			/*
			 * PGAndroidApp app = new PGAndroidApp(driver);
			 * app.android_OpenMenu("SEARCH");
			 */

			MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
			MenuIcon.click();
			Thread.sleep(6000);
			PGAndroidApp app = new PGAndroidApp(driver);
			app.android_OpenMenu("SETTINGS");
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Settings Page "
					+ "\n" + Extent_Reports.logActual + " Navigated to Settings Page ", driver);
			WebElement Sign_up = Utilities.returnElement(driver, lstObject.get(185), lstObject.get(184));
			Sign_up.click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Sing up page. "
					+ Extent_Reports.logActual + "Navigated to Sing up page. ", driver);

			WebElement Signup_Facebook = Utilities.returnElement(driver, lstObject.get(188), lstObject.get(187));
			Signup_Facebook.click();
			Thread.sleep(10000);

			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
				if (contextName.contains("WEBVIEW")) {
					driver.context(contextName);
					Extent_Reports
							.executionLog("PASS",
									Extent_Reports.logExpected + "Should be navigated to facebook singin webpage. "
											+ Extent_Reports.logActual + "Navigated to facebook sing in webpage. ",
									driver);
				}
			}

			WebElement Facbook_User = Utilities.returnElement(driver, lstObject.get(191), lstObject.get(190));
			if (Facbook_User.isEnabled()) {
				Facbook_User.sendKeys(lstTestData.get(20));
				Thread.sleep(1000);
			}
			WebElement Facbook_Pw = Utilities.returnElement(driver, lstObject.get(194), lstObject.get(193));
			if (Facbook_Pw.isEnabled()) {
				Facbook_Pw.sendKeys(lstTestData.get(21));
				Thread.sleep(1000);
			}

			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Facebook Sing in Page"
					+ Extent_Reports.logActual + "Facebook Sing in Page", driver);
			WebElement Facebook_btn = Utilities.returnElement(driver, lstObject.get(197), lstObject.get(196));
			if (Facebook_btn.isEnabled()) {
				Facebook_btn.click();
			}

			Thread.sleep(30000);
			try {
				WebElement Facebook_Edit_this = Utilities.returnElement(driver, lstObject.get(200), lstObject.get(199));
				Extent_Reports
						.executionLog("PASS",
								Extent_Reports.logExpected + "Facebook Edit this text link should be displayed"
										+ Extent_Reports.logActual + "Facebook Edit this text link is displayed",
								driver);

			} catch (Exception e) {
				Extent_Reports
						.executionLog("FAIL",
								Extent_Reports.logExpected + "Facebook Edit this text link should be displayed"
										+ Extent_Reports.logActual + "Facebook Edit this text link is not displayed",
								driver);

			}

			WebElement Continue_as_Sample = Utilities.returnElement(driver, lstObject.get(203), lstObject.get(202));
			if (Continue_as_Sample.isEnabled()) {
				Extent_Reports.executionLog("PASS",
						Extent_Reports.logExpected + "Continue as Sample button should be displayed"
								+ Extent_Reports.logActual + "Continue as Sample button is displayed",
						driver);
				Continue_as_Sample.click();
			} else {
				Extent_Reports
						.executionLog("FAIL",
								Extent_Reports.logExpected + "Continue as Sample button should be displayed"
										+ Extent_Reports.logActual + "Continue as Sample button is not displayed",
								driver);
			}
			Thread.sleep(6000);
			/*
			 * WebElement App_Signup = Utilities.returnElement(driver,
			 * lstObject.get(206), lstObject.get(205)); if
			 * (App_Signup.isEnabled()){
			 * Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +
			 * "Should be navigated back to Native NBC app" +
			 * Extent_Reports.logActual + "navigated back to Native NBC app",
			 * driver);
			 * 
			 * }else{
			 * Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +
			 * "Should be navigated back to Native NBC app" +
			 * Extent_Reports.logActual +
			 * "Not navigated back to Native NBC app", driver); }
			 */

			Set<String> contextNames2 = driver.getContextHandles();
			for (String contextName2 : contextNames2) {
				if (contextName2.contains("NATIVE")) {
					driver.context(contextName2);
					Extent_Reports.executionLog("PASS",
							Extent_Reports.logExpected + "Should be navigated to singup page. "
									+ Extent_Reports.logActual + "Navigated to singup page. ",
							driver);
				}
			}

			WebElement Nbc_Checkbox = Utilities.returnElement(driver, lstObject.get(209), lstObject.get(208));
			if (Nbc_Checkbox.isEnabled()) {
				Nbc_Checkbox.click();
				Thread.sleep(1000);
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Check box should be displayed"
						+ Extent_Reports.logActual + "Check box is displayed", driver);

			} else {
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Check box should be displayed"
						+ Extent_Reports.logActual + "Check box is not displayed", driver);
			}

			WebElement Continue_btn = Utilities.returnElement(driver, lstObject.get(212), lstObject.get(211));
			TouchAction touchAction = new TouchAction(driver);
			if (Continue_btn.isEnabled()) {
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Continue button should be displayed"
						+ Extent_Reports.logActual + "Continue button is displayed", driver);
				Continue_btn.click();

				Thread.sleep(10000);

			} else {
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Continue button should be displayed"
						+ Extent_Reports.logActual + "Continue button is not displayed", driver);
			}

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_NBC_Profile_With_Facebook_NIR_4684" + "\n" + e.getMessage(),
					driver);
		}
	}// EOM
	public void android_NBC_Profile_With_Facebook_NAF_4606() throws Exception {
		PGNbcApp pgnbcappobj = new PGNbcApp(driver);
		try {
			PGNbcApp App = new PGNbcApp(driver);
			// App.android_WaitForAppToLoad();
			// App.android_DismissCastOverlay();

			
			MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
			MenuIcon.click();
			Thread.sleep(6000);
			PGAndroidApp app = new PGAndroidApp(driver);
			app.android_OpenMenu("SETTINGS");
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Settings Page "
					+ "\n" + Extent_Reports.logActual + " Navigated to Settings Page ", driver);
			WebElement Sign_up = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
			Sign_up.click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Sing up page. "
					+ Extent_Reports.logActual + "Navigated to Sing up page. ", driver);

			WebElement Signup_Facebook = Utilities.returnElement(driver, lstObject.get(188), lstObject.get(187));
			Signup_Facebook.click();
			Thread.sleep(10000);

			Set<String> contextNames = driver.getContextHandles();
			for (String contextName : contextNames) {
				if (contextName.contains("WEBVIEW")) {
					driver.context(contextName);
					Extent_Reports
							.executionLog("PASS",
									Extent_Reports.logExpected + "Should be navigated to facebook singin webpage. "
											+ Extent_Reports.logActual + "Navigated to facebook sing in webpage. ",
									driver);
				}
			}

			WebElement Facbook_User = Utilities.returnElement(driver, lstObject.get(191), lstObject.get(190));
			if (Facbook_User.isEnabled()) {
				Facbook_User.sendKeys(lstTestData.get(24));
				Thread.sleep(1000);
			}
			WebElement Facbook_Pw = Utilities.returnElement(driver, lstObject.get(194), lstObject.get(193));
			if (Facbook_Pw.isEnabled()) {
				Facbook_Pw.sendKeys(lstTestData.get(25));
				Thread.sleep(1000);
			}

			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Facebook Sing in Page"
					+ Extent_Reports.logActual + "Facebook Sing in Page", driver);
			WebElement Facebook_btn = Utilities.returnElement(driver, lstObject.get(197), lstObject.get(196));
			if (Facebook_btn.isEnabled()) {
				Facebook_btn.click();
			}

			Thread.sleep(30000);
			try {
				WebElement Facebook_Edit_this = Utilities.returnElement(driver, lstObject.get(200), lstObject.get(199));
				Extent_Reports
						.executionLog("PASS",
								Extent_Reports.logExpected + "Facebook Edit this text link should be displayed"
										+ Extent_Reports.logActual + "Facebook Edit this text link is displayed",
								driver);

			} catch (Exception e) {
				Extent_Reports
						.executionLog("FAIL",
								Extent_Reports.logExpected + "Facebook Edit this text link should be displayed"
										+ Extent_Reports.logActual + "Facebook Edit this text link is not displayed",
								driver);

			}

			WebElement Continue_as_Sample = Utilities.returnElement(driver, lstObject.get(203), lstObject.get(202));
			if (Continue_as_Sample.isEnabled()) {
				Extent_Reports.executionLog("PASS",
						Extent_Reports.logExpected + "Continue as Sample button should be displayed"
								+ Extent_Reports.logActual + "Continue as Sample button is displayed",
						driver);
				Continue_as_Sample.click();
			} else {
				Extent_Reports
						.executionLog("FAIL",
								Extent_Reports.logExpected + "Continue as Sample button should be displayed"
										+ Extent_Reports.logActual + "Continue as Sample button is not displayed",
								driver);
			}
			Thread.sleep(6000);
			/*
			 * WebElement App_Signup = Utilities.returnElement(driver,
			 * lstObject.get(206), lstObject.get(205)); if
			 * (App_Signup.isEnabled()){
			 * Extent_Reports.executionLog("PASS",Extent_Reports.logExpected +
			 * "Should be navigated back to Native NBC app" +
			 * Extent_Reports.logActual + "navigated back to Native NBC app",
			 * driver);
			 * 
			 * }else{
			 * Extent_Reports.executionLog("FAIL",Extent_Reports.logExpected +
			 * "Should be navigated back to Native NBC app" +
			 * Extent_Reports.logActual +
			 * "Not navigated back to Native NBC app", driver); }
			 */

			Set<String> contextNames2 = driver.getContextHandles();
			for (String contextName2 : contextNames2) {
				if (contextName2.contains("NATIVE")) {
					driver.context(contextName2);
					Extent_Reports.executionLog("PASS",
							Extent_Reports.logExpected + "Should be navigated to singup page. "
									+ Extent_Reports.logActual + "Navigated to singup page. ",
							driver);
				}
			}

			WebElement Nbc_Checkbox = Utilities.returnElement(driver, lstObject.get(209), lstObject.get(208));
			if (Nbc_Checkbox.isEnabled()) {
				Nbc_Checkbox.click();
				Thread.sleep(1000);
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Check box should be displayed"
						+ Extent_Reports.logActual + "Check box is displayed", driver);

			} else {
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Check box should be displayed"
						+ Extent_Reports.logActual + "Check box is not displayed", driver);
			}

			WebElement Continue_btn = Utilities.returnElement(driver, lstObject.get(212), lstObject.get(211));
			TouchAction touchAction = new TouchAction(driver);
			if (Continue_btn.isEnabled()) {
				Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Continue button should be displayed"
						+ Extent_Reports.logActual + "Continue button is displayed", driver);
				Continue_btn.click();

				Thread.sleep(10000);

			} else {
				Extent_Reports.executionLog("FAIL", Extent_Reports.logExpected + "Continue button should be displayed"
						+ Extent_Reports.logActual + "Continue button is not displayed", driver);
			}

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_NBC_Profile_With_Facebook_NIR_4684" + "\n" + e.getMessage(),
					driver);
		}
	}// EOM

	
	public void android_Verify_ContinueWatching_AfterNbcSignout() throws Exception {

		PGNbcApp pgnbcappobj = new PGNbcApp(driver);

		try {
			PGNbcApp App = new PGNbcApp(driver);
			String val = "";
			String lastShow = "";
			// App.android_WaitForAppToLoad();
			// App.android_DismissCastOverlay();

			Thread.sleep(6000);
			MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
			MenuIcon.click();
			Thread.sleep(6000);
			PGAndroidApp app = new PGAndroidApp(driver);
			app.android_OpenMenu("SETTINGS");
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Settings Page "
					+ "\n" + Extent_Reports.logActual + " Navigated to Settings Page ", driver);

			SignIn_btn = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
			SignIn_btn.click();

			PGAndroidApp SignIn = new PGAndroidApp(driver);
			SignIn.android_NBCSignIn_Email();
			Thread.sleep(3000);

			SignIn.android_LinkTvproviderBridge_Skip();
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
			MenuIcon.click();
			Thread.sleep(1000);
			app.android_OpenMenu("SHOWS");
			Thread.sleep(3000);
			PGNbcApp nbc1 = new PGNbcApp(driver);
			nbc1.android_ClickOnParticularShow(lstTestData.get(23));

			List<WebElement> Epsde = Utilities.returnElements(driver, lstObject.get(284), lstObject.get(283));
			// driver.findElementsByXPath("//android.widget.TextView[@index='0']");

			String Episode_Title = Epsde.get(2).getAttribute("text");

			Epsde.get(2).click();
			Thread.sleep(10000);
			WebElement loadng = Utilities.returnElement(driver, lstObject.get(287), lstObject.get(286));
			// driver.findElementByXPath("//android.widget.TextView[@text='LOADING']");
			if (loadng.isEnabled()) {
				Thread.sleep(10000);
			} else {
				Thread.sleep(10000);
			}
			Thread.sleep(15000);
			WebElement vodplayer = Utilities.returnElement(driver, lstObject.get(290), lstObject.get(289));
			// driver.findElementByXPath("//android.widget.RelativeLayout");
			vodplayer.click();

			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

			Thread.sleep(5000);
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

			SignIn.android_NBCSignOut();
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

			ArrayList<String> Arraylist = new ArrayList<String>();
			ArrayList<String> aList = new ArrayList<String>();

			// String Episode_Title = "S53 E158 | 05/07/18";
			for (int i = 0; i <= 5; i++) {
				List<WebElement> ContinueWatching_ShowTiteName = Utilities.returnElements(driver, lstObject.get(293),
						lstObject.get(292));// driver.findElements(By.xpath("//android.widget.TextView[@text='Continue
											// Watching']/following-sibling::android.support.v7.widget.RecyclerView[contains(@resource-id,'homeListItemRecyclerView')]/android.widget.FrameLayout//android.widget.TextView"));
				// driver.findElements(By.xpath("//android.widget.TextView[@text='Continue
				// Watching']/following-sibling::android.support.v7.widget.RecyclerView[contains(@resource-id,'homeListItemRecyclerView')]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[@index='0']"));
				for (int k = 0; k < ContinueWatching_ShowTiteName.size(); k++) {
					val = ContinueWatching_ShowTiteName.get(k).getText().trim();
					if (val.contains(" | ")) {
						System.out.println(val);
						Extent_Reports.executionLog("FAIL",
								Extent_Reports.logExpected
										+ "Episodes watched with NBC Profile should not displsy in contnue watching after signout  "
										+ val + "\n" + Extent_Reports.logActual
										+ " Episodes watched with NBC Profile displayed in contnue watching after signout  ",
								driver);

						aList.add(val);
						lastShow = val;
					} else {

					}
				}

				if (lastShow.equalsIgnoreCase(Episode_Title)) {
					break;

				} else {

					if (i == 0) {
						nbc1.scrollDown(By.xpath(
								"//android.widget.TextView[@text='Continue Watching']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.TextView"));
					}

					TouchAction act = new TouchAction(driver);
					Dimension size = driver.manage().window().getSize();
					int anchor = (int) (size.height * 0.5);
					int startPoint = (int) (size.width * 0.5);
					int endPoint = (int) (size.width * 0.09);
					act.longPress(startPoint, anchor).moveTo(endPoint, anchor).release().perform();
					Thread.sleep(2000);

				}

			}

			for (int i = 0; i < aList.size(); i++) {
				if (aList.get(i).equalsIgnoreCase(Episode_Title)) {
					// FAIL
					Extent_Reports.executionLog("FAIL",
							Extent_Reports.logExpected
									+ "Episodes watched with NBC Profile should not displsy in contnue watching after signout  "
									+ Episode_Title + "\n" + Extent_Reports.logActual
									+ " Episodes watched with NBC Profile displayed in contnue watching after signout  ",
							driver);

				} else {
					// PASS
					Extent_Reports.executionLog("PASS",
							Extent_Reports.logExpected
									+ "Episodes watched with NBC Profile should not displsy in contnue watching after signout  "
									+ "\n" + Extent_Reports.logActual
									+ " Episodes watched with NBC Profile not displayed in contnue watching after signout  ",
							driver);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void android_NBC_Profile_bridge_screen() throws Exception {
		PGNbcApp pgnbcappobj = new PGNbcApp(driver);
		try {
			PGNbcApp App = new PGNbcApp(driver);
			// App.android_WaitForAppToLoad();
			// App.android_DismissCastOverlay();

			/*
			 * PGAndroidApp app = new PGAndroidApp(driver);
			 * app.android_OpenMenu("SEARCH");
			 */
			Thread.sleep(6000);
			MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
			MenuIcon.click();
			Thread.sleep(6000);
			PGAndroidApp app = new PGAndroidApp(driver);
			app.android_OpenMenu("SETTINGS");
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Settings Page "
					+ "\n" + Extent_Reports.logActual + " Navigated to Settings Page ", driver);

			WebElement TV_PROVIDER = Utilities.returnElement(driver, lstObject.get(215), lstObject.get(214));
			TV_PROVIDER.click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Bridge Screeen. "
					+ Extent_Reports.logActual + "Navigated to Bridge Screeen. ", driver);

			List<WebElement> optimum = Utilities.returnElements(driver, lstObject.get(218), lstObject.get(217));
			optimum.get(7).click();
			Thread.sleep(10000);
			// WEBVIEW
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Should be navigated to Optimum Login Page. "
							+ Extent_Reports.logActual + "Navigated to Optimum Login Page. ",
					driver);

			WebElement Optimum_ID = Utilities.returnElement(driver, lstObject.get(221), lstObject.get(220));
			Optimum_ID.sendKeys(lstTestData.get(22));
			((AndroidDriver) driver).hideKeyboard();
			Thread.sleep(1000);

			// android.widget.EditText[contains(@resource-id,'IDToken2')]
			WebElement Optimum_PW = Utilities.returnElement(driver, lstObject.get(224), lstObject.get(223));
			Optimum_PW.sendKeys(lstTestData.get(23));
			((AndroidDriver) driver).hideKeyboard();
			Thread.sleep(1000);

			WebElement Optimum_SignIn = Utilities.returnElement(driver, lstObject.get(227), lstObject.get(226));
			Optimum_SignIn.click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Bridge Screeen. "
					+ Extent_Reports.logActual + "Navigated to Bridge Screeen. ", driver);

			WebElement NBC_Bridge_Screen = Utilities.returnElement(driver, lstObject.get(251), lstObject.get(250));
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

			WebElement Yes_btn = Utilities.returnElement(driver, lstObject.get(230), lstObject.get(229));
			Yes_btn.click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Should be navigated to NBC Registration Screeen. "
							+ Extent_Reports.logActual + "Navigated to NBC Registration Screeen. ",
					driver);

			WebElement Nbc_UserId = Utilities.returnElement(driver, lstObject.get(233), lstObject.get(232));
			Nbc_UserId.sendKeys(lstTestData.get(24));
			((AndroidDriver) driver).hideKeyboard();
			Thread.sleep(1000);

			WebElement Nbc_Pwd = Utilities.returnElement(driver, lstObject.get(236), lstObject.get(235));
			Nbc_Pwd.sendKeys(lstTestData.get(25));
			Thread.sleep(1000);
			((AndroidDriver) driver).hideKeyboard();

			WebElement Nbc_CheckBox = Utilities.returnElement(driver, lstObject.get(239), lstObject.get(238));
			Nbc_CheckBox.click();
			Thread.sleep(1000);

			WebElement Nbc_sign_up = Utilities.returnElement(driver, lstObject.get(242), lstObject.get(241));
			Nbc_sign_up.click();
			Thread.sleep(6000);
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

			WebElement Nbc_SIGN_OUT = Utilities.returnElement(driver, lstObject.get(245), lstObject.get(244));
			if (!Nbc_SIGN_OUT.isDisplayed()) {
				Extent_Reports.executionLog("FAIL",
						"Signout from NBC should be Displayed in settings after SgnUp/SignIn to NBC: " + "\n"
								+ "Signout from NBC is not displayed",
						driver);
			}

			PGAndroidApp Sout = new PGAndroidApp(driver);
			Sout.android_signoutfromNBC();
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
			MenuIcon.click();
			Sout.android_UnlinkTvProvider();
			Thread.sleep(6000);
			PGAndroidApp App1 = new PGAndroidApp(driver);
			App1.android_OpenMenu("SETTINGS");
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Settings Page "
					+ "\n" + Extent_Reports.logActual + " Navigated to Settings Page ", driver);

			TV_PROVIDER = Utilities.returnElement(driver, lstObject.get(215), lstObject.get(214));
			TV_PROVIDER.click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Bridge Screeen. "
					+ Extent_Reports.logActual + "Navigated to Bridge Screeen. ", driver);

			optimum = Utilities.returnElements(driver, lstObject.get(218), lstObject.get(217));
			optimum.get(7).click();
			Thread.sleep(10000);
			// WEBVIEW
			Extent_Reports.executionLog("PASS",
					Extent_Reports.logExpected + "Should be navigated to Optimum Login Page. "
							+ Extent_Reports.logActual + "Navigated to Optimum Login Page. ",
					driver);

			Optimum_ID = Utilities.returnElement(driver, lstObject.get(221), lstObject.get(220));
			Optimum_ID.sendKeys(lstTestData.get(22));
			((AndroidDriver) driver).hideKeyboard();
			Thread.sleep(1000);

			// android.widget.EditText[contains(@resource-id,'IDToken2')]
			Optimum_PW = Utilities.returnElement(driver, lstObject.get(224), lstObject.get(223));
			Optimum_PW.sendKeys(lstTestData.get(23));
			((AndroidDriver) driver).hideKeyboard();
			Thread.sleep(1000);

			Optimum_SignIn = Utilities.returnElement(driver, lstObject.get(227), lstObject.get(226));
			Optimum_SignIn.click();
			Thread.sleep(6000);
			Extent_Reports.executionLog("PASS", Extent_Reports.logExpected + "Should be navigated to Bridge Screeen. "
					+ Extent_Reports.logActual + "Navigated to Bridge Screeen. ", driver);

			NBC_Bridge_Screen = Utilities.returnElement(driver, lstObject.get(251), lstObject.get(250));
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
			WebElement Skip_btn = Utilities.returnElement(driver, lstObject.get(248), lstObject.get(247));
			Skip_btn.click();
			Thread.sleep(5000);
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
			MenuIcon.click();
			Sout.android_UnlinkTvProvider();

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_NBC_Profile_With_Facebook_NAF_4684" + "\n" + e.getMessage(),
					driver);
		}
	}

	public void android_Verify_SignIn_Email_Screen() throws Throwable {
		PGNbcApp App = new PGNbcApp(driver);
		App.android_WaitForAppToLoad();
		// App.android_DismissCastOverlay();
		Thread.sleep(2000);
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("SETTINGS");
		Thread.sleep(4000);
		SignUp_btn = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		SignUp_btn.click();

		Thread.sleep(4000);
		((AndroidDriver) driver).hideKeyboard();
		WebElement SignIn_Link = Utilities.returnElement(driver, lstObject.get(254), lstObject.get(253));
		if (SignIn_Link.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					" SignIn Link  should be displayed on Registration " + "\n" + " SignIn Link is displayed", driver);
			SignIn_Link.click();
		} else {
			Extent_Reports.executionLog("FAIL",
					" SignIn Link  should be displayed on Registration " + "\n" + " SignIn Link is not displayed",
					driver);
		}

		WebElement SignIn_with_Email_Title = Utilities.returnElement(driver, lstObject.get(257), lstObject.get(256));
		if (SignIn_with_Email_Title.isEnabled()) {
			Extent_Reports.executionLog("PASS", " SignIn with Email title  should be displayed on Registration " + "\n"
					+ "SignIn with Email title is displayed", driver);

		} else {
			Extent_Reports.executionLog("FAIL", " SignIn with Email title should be displayed on Registration " + "\n"
					+ "SignIn with Email titleis not displayed", driver);
		}
		WebElement SignIn_with_FB_Title = Utilities.returnElement(driver, lstObject.get(260), lstObject.get(259));
		if (SignIn_with_FB_Title.isEnabled()) {
			Extent_Reports.executionLog("PASS", " SignIn with FB title should be displayed on Registration " + "\n"
					+ "SignIn with FB title is displayed", driver);

		} else {
			Extent_Reports.executionLog("FAIL", "SignIn with FB title should be displayed on Registration " + "\n"
					+ "SignIn with FB title is not displayed", driver);
		}

		try {
			WebElement Show_passwrd = Utilities.returnElement(driver, lstObject.get(266), lstObject.get(265));

			if (Show_passwrd.isEnabled()) {
				Extent_Reports.executionLog("PASS", " Show password Toggle should be displayed on Registration " + "\n"
						+ "  Show password Toggle is displayed", driver);
				Show_passwrd.click();

			} else {
				Extent_Reports.executionLog("FAIL", "  Show password Toggle should be displayed on Registration " + "\n"
						+ "  Show password Toggle is not displayed", driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement Reset_link = Utilities.returnElement(driver, lstObject.get(263), lstObject.get(262));
		if (Reset_link.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					" SignIn Link  should be displayed on Registration " + "\n" + " SignIn Link is displayed", driver);
			Reset_link.click();
			Thread.sleep(5000);
		} else {
			Extent_Reports.executionLog("FAIL",
					" SignIn Link  should be displayed on Registration " + "\n" + " SignIn Link is not displayed",
					driver);
		}
		Thread.sleep(5000);
		WebElement need_new_password = Utilities.returnElement(driver, lstObject.get(269), lstObject.get(268));
		if (need_new_password.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					" Need New Password message should be displayed on Forgot password screen " + "\n"
							+ " Need New Password message  is displayed",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					" Need New Password message should be displayed on Forgot password screen " + "\n"
							+ " Need New Password message is not displayed",
					driver);
		}

		WebElement Email_Address = Utilities.returnElement(driver, lstObject.get(272), lstObject.get(271));
		if (Email_Address.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					" Email filed should be displayed on Forgot password screen " + "\n" + " Email filed  is displayed",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL", "  Email filed  should be displayed on Forgot password screen " + "\n"
					+ "  Email filed  is not displayed", driver);
		}
		WebElement CONTINUE_btn = Utilities.returnElement(driver, lstObject.get(275), lstObject.get(274));
		if (CONTINUE_btn.isEnabled()) {
			Extent_Reports.executionLog("PASS", " Continue Button   should be displayed on  Forgot password screen "
					+ "\n" + " Continue Button is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", " Continue Button   should be displayed on  Forgot password screen "
					+ "\n" + "  Continue Button is not displayed", driver);

		}
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

		WebElement SignUp_Link = Utilities.returnElement(driver, lstObject.get(278), lstObject.get(277));
		if (SignUp_Link.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					" SignUp Link  should be displayed on SignIn Screen " + "\n" + " SignUp Link is displayed", driver);
			SignUp_Link.click();
		} else {
			Extent_Reports.executionLog("FAIL",
					" SignUp Link  should be displayed on SignIn Screen " + "\n" + " SignUp Link is not displayed",
					driver);
		}

		WebElement registration_screen = Utilities.returnElement(driver, lstObject.get(281), lstObject.get(280));
		if (registration_screen.getAttribute("text").equalsIgnoreCase("SIGN UP")) {
			Extent_Reports.executionLog("PASS", " Registartion Page should be displayed on clcking Signup Link " + "\n"
					+ " Registartion Page is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", " Registartion Page should be displayed on clcking Signup Link " + "\n"
					+ " Registartion Page is not displayed", driver);
		}

	}

	public void android_Verify_Email_SignIn() throws Throwable {
		PGNbcApp App = new PGNbcApp(driver);
		App.android_WaitForAppToLoad();
		// App.android_DismissCastOverlay();
		Thread.sleep(2000);
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("SETTINGS");
		Thread.sleep(4000);
		SignIn_btn = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
		SignIn_btn.click();
		Thread.sleep(3000);
		PGAndroidApp email = new PGAndroidApp(driver);
		email.android_EmailValidation();
	}

}// EOC