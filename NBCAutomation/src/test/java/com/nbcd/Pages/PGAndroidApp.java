package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Synchronization;
import com.nbcd.GenericLib.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class PGAndroidApp {
	public static AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> objShowLists, objShowList;
	boolean isDisplayed = false;
	String sqlQry, Status;
	public String ShowName,EpisodeName,EpisodeNameVODPlayer;
	WebElement smartTile,objnav, objRespNavBar, objClipDropDownWebEx, EpisodesLst, Episode, objShowLink, NBCIcon, Shows,
			AllShowsBtn, SelectOption, CastIcon, CastPopUp, clkOnShow, Signout_popup, MenuIcon, shpBackBtn, objloading,
			Home, SignIn, Email, password, show_pwd, Sign_UpLink, Sign_Up_Page, yes, forkscreen, bridge_screen, skip,
			Email_SignIn, SignIn_btn, nbcSignupsuccess,Email_Error, SignoutFrmNbc, startwatch_btn, Email_Validation,
			Unlinktv_prov_popUp, passwrd, Vod_Player,stationlogo,StationNavigator,scheduleTiltle,castIcon,close,toggle,stationLogo,Tvproviderlogo,View_Schedule,CCtoggle,closedcaption,Unlinktv_prov,AddToFavoritesButton, Email_Signup, SignUp, chkBox, Email_Error_AlreadyUsed,
			SettingsTitle,  SignUp_btn;

	// Constructor to initialize all the Page Objects
	public PGAndroidApp(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGAndroidApp", "Input");
		lstObject = db.getTestDataObject("Select * from PGAndroidApp", "ObjectRepository");

	}

	public void android_OpenMenus(String Menu) throws Exception {

		NBCIcon = Utilities.returnElement(driver, lstObject.get(2), lstObject.get(1));
		NBCIcon.click();
		Thread.sleep(2000);

		List<WebElement> MenuList = Utilities.returnElements(driver, lstObject.get(5), lstObject.get(4));

		for (int i = 0; i <= MenuList.size(); i++) {

			if (MenuList.get(i).getText().trim().equals(Menu.trim())) {
				System.out.println(MenuList.get(i).getText());
				/*
				 * Extent_Reports.executionLog("PASS", MenuList.get(i).getText()
				 * + "should be displayed " + "\n" + MenuList.get(i).getText() +
				 * " is displayed", driver);
				 */
				MenuList.get(i).click();
				Thread.sleep(5000);

				break;
			}

		}
	}

	public void android_OpenMenu(String Menu) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);

			Thread.sleep(6000);

			switch (Menu) {

			case "HOME":
				try {
					List<WebElement> li = Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
					li.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" HOME Page should be displayed " + "\n" + " HOME Page is displayed", driver);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "LIVE":
				try {
					List<WebElement> li = Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
					li.get(1).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" LIVE Page should be displayed " + "\n" + " HOME Page is displayed", driver);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "SHOWS":
				try {
					List<WebElement> li = Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
					li.get(2).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" SHOWS Page should be displayed " + "\n" + " SHOWS Page is displayed", driver);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "SCHEDULE":
				try {
					List<WebElement> li = Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
					li.get(3).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" SCHEDULE Page should be displayed " + "\n" + " SCHEDULE Page is displayed", driver);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "SEARCH":
				try {
					List<WebElement> li = Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
					li.get(4).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" SEARCH Page should be displayed " + "\n" + " SEARCH Page is displayed", driver);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "SETTINGS":
				try {
					List<WebElement> li = Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
					li.get(4).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" SETTING Page should be displayed " + "\n" + " SETTING Page is displayed", driver);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			}

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_Settings" + "\n" + e.getMessage(), driver);

		}
	}

	public int android_watchedDuration() throws Exception {
		WebElement Timer = Utilities.returnElement(driver, lstObject.get(9), lstObject.get(8));
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
		return totalDurationWatched;

	}

	public void android_NBCSignUP_Email() throws Exception {

		Thread.sleep(8000);
		Email_Signup = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
		if (Email_Signup.isEnabled()) {
			Email_Signup.sendKeys(lstTestData.get(14));

			((AndroidDriver) driver).hideKeyboard();

			Extent_Reports.executionLog("PASS",
					"Email text field should be displayed " + "\n" + "Email text field is displayed ", driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					"Email text field should be displayed " + "\n" + "Email text field is not displayed ", driver);

		}

		passwrd = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
		if (passwrd.isEnabled()) {

			passwrd.sendKeys(lstTestData.get(4));

			((AndroidDriver) driver).hideKeyboard();
			Extent_Reports.executionLog("PASS",
					"Password text field should be displayed " + "\n" + "Password text field is displayed ", driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					"Password text field should be displayed " + "\n" + "Password text field is not displayed ",
					driver);
		}

		Thread.sleep(5000);
		chkBox = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
		chkBox.click();
		Thread.sleep(2000);

		SignUp = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
		if (SignUp.isEnabled()) {
			SignUp.click();
		}
		Thread.sleep(5000);

		nbcSignupsuccess = Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));

		if (nbcSignupsuccess.isDisplayed()) {
			Extent_Reports.executionLog("PASS", "Sucess message should be Displayed when the user Signed Up to NBC: "
					+ "\n" + "Sucess message is Displayed", driver);

		} else {
			Extent_Reports.executionLog("FAIL", "Sucess message should be Displayed when the user Signed Up to NBC: "
					+ "\n" + "Sucess message is not displayed", driver);
		}

	}

	public void android_signoutfromNBC() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);

		try {
			SignoutFrmNbc = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (!SignoutFrmNbc.isDisplayed()) {
			Extent_Reports.executionLog("FAIL",
					"Signout from NBC should be Displayed in settings after SgnUp/SignIn to NBC: " + "\n"
							+ "Signout from NBC is not displayed",
					driver);
		}
	}

	public void android_NBCSignIn_Email() throws Exception {

		Thread.sleep(8000);
		Email_SignIn = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
		if (Email_SignIn.isEnabled()) {
			Email_SignIn.clear();
			Email_SignIn.sendKeys(lstTestData.get(17));

			((AndroidDriver) driver).hideKeyboard();

			Extent_Reports.executionLog("PASS",
					"Email text field should be displayed " + "\n" + "Email text field is displayed ", driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					"Email text field should be displayed " + "\n" + "Email text field is not displayed ", driver);

		}

		passwrd = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
		if (passwrd.isEnabled()) {

			passwrd.sendKeys(lstTestData.get(4));

			((AndroidDriver) driver).hideKeyboard();
			Extent_Reports.executionLog("PASS",
					"Password text field should be displayed " + "\n" + "Password text field is displayed ", driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					"Password text field should be displayed " + "\n" + "Password text field is not displayed ",
					driver);
		}

		SignIn = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
		if (SignIn.isEnabled()) {

			Extent_Reports.executionLog("PASS",
					"SignIn button should be displayed " + "\n" + "SignIn button is displayed ", driver);
			SignIn.click();
		} else {
			Extent_Reports.executionLog("FAIL",
					"SignIn button should be displayed " + "\n" + "SignIn button is not displayed ", driver);

		}
		Thread.sleep(5000);
	}
	public void android_NBCSignIn_IncorrectPasswrd() throws Exception {

		Thread.sleep(8000);
		Email_SignIn = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
		if (Email_SignIn.isEnabled()) {
			Email_SignIn.clear();
			Email_SignIn.sendKeys(lstTestData.get(17));

			((AndroidDriver) driver).hideKeyboard();

			Extent_Reports.executionLog("PASS",
					"Email text field should be displayed " + "\n" + "Email text field is displayed ", driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					"Email text field should be displayed " + "\n" + "Email text field is not displayed ", driver);

		}

		passwrd = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
		if (passwrd.isEnabled()) {

			passwrd.sendKeys(lstTestData.get(25));

			((AndroidDriver) driver).hideKeyboard();
			Extent_Reports.executionLog("PASS",
					"Password text field should be displayed " + "\n" + "Password text field is displayed ", driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					"Password text field should be displayed " + "\n" + "Password text field is not displayed ",
					driver);
		}

		SignIn = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
		if (SignIn.isEnabled()) {

			Extent_Reports.executionLog("PASS",
					"SignIn button should be displayed " + "\n" + "SignIn button is displayed ", driver);
			SignIn.click();
		} else {
			Extent_Reports.executionLog("FAIL",
					"SignIn button should be displayed " + "\n" + "SignIn button is not displayed ", driver);

		}
		Thread.sleep(5000);
	}

	
	public String android_getShowNamefromShowHomePage() throws Exception
	{
		
		
		try{
		Synchronization.ExplicitWait(driver, lstObject.get(106), "visible");
		
		WebElement showName = Utilities.returnElement(driver, lstObject.get(107), lstObject.get(106));
		ShowName=showName.getText().trim();
		}
		catch(Exception e)
		{
			Extent_Reports.executionLog("INFO",
					"android_getShowNamefromShowHomePage  " + "\n" + e.getMessage(), driver);
		}
		
		
		return ShowName;
	}
	
	public void android_NBCSignOut() throws Exception {
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("SETTINGS");
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			SignoutFrmNbc = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
			SignoutFrmNbc.click();
			Thread.sleep(2000);
			Signout_popup = Utilities.returnElement(driver, lstObject.get(53), lstObject.get(52));
			Signout_popup.click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SignIn_btn = Utilities.returnElement(driver, lstObject.get(44), lstObject.get(43));
		if (SignIn_btn.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					"SignIn/SignUP  should be Displayed in settings after Sing out from NBC: " + "\n"
							+ "SignIn/SignUP is  displayed",
					driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					"SignIn/SignUP  should be Displayed in settings after Sing out from NBC: " + "\n"
							+ "SignIn/SignUP is not displayed",
					driver);

		}
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public void android_UnlinkTvProvider() throws Exception {
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("SETTINGS");
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			Unlinktv_prov = Utilities.returnElement(driver, lstObject.get(56), lstObject.get(55));
			Unlinktv_prov.click();
			Thread.sleep(2000);
			Unlinktv_prov_popUp = Utilities.returnElement(driver, lstObject.get(59), lstObject.get(58));
			Unlinktv_prov_popUp.click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void android_LinkTvproviderBridge_Yes() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try {
			bridge_screen = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (bridge_screen.isEnabled()) {
			Extent_Reports.executionLog("PASS",
					"Link TV provider Bridge Screen should be Displayed when the user Signed In to NBC: " + "\n"
							+ "Bridge Screen is Displayed",
					driver);
			yes = driver.findElement(By.xpath("//android.widget.Button[@text='yes']"));
			yes.click();

		} else {
			Extent_Reports.executionLog("FAIL",
					"Link TV provider Bridge Screen should be Displayed when the user Signed In to NBC: " + "\n"
							+ "Bridge Screen is not displayed",
					driver);
		}
	}

	public void android_LinkTvproviderBridge_Skip() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try {
			bridge_screen = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (bridge_screen.isEnabled()) {
			Extent_Reports.executionLog("PASS", "Bridge Screen should be Displayed when the user Signed In to NBC: "
					+ "\n" + "Bridge Screen is Displayed", driver);
			skip = Utilities.returnElement(driver, lstObject.get(50), lstObject.get(49));
			skip.click();

		} else {
			Extent_Reports.executionLog("FAIL", "Bridge Screen should be Displayed when the user Signed In to NBC: "
					+ "\n" + "Bridge Screen is not displayed", driver);
		}

		SignoutFrmNbc = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
		if (!SignoutFrmNbc.isDisplayed()) {
			Extent_Reports.executionLog("FAIL",
					"Signout from NBC should be Displayed in settings after SgnUp/SignIn to NBC: " + "\n"
							+ "Signout from NBC is not displayed",
					driver);
		} else {
			Extent_Reports.executionLog("PASS",
					"Signout from NBC should be Displayed in settings after SgnUp/SignIn to NBC: " + "\n"
							+ "Signout from NBC is  displayed",
					driver);
		}
	}

	public void android_startwatching_forkscreen() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		try {
			startwatch_btn = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
			startwatch_btn.click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub

	}

	public void anroid_MVPDPicker(String Linkprovider) throws Exception {

		try {
			Thread.sleep(5000);
			Extent_Reports.executionLog("PASS",
					"Tv provider screen should be displayed" + "\n" + "Tv provider screen is displayed", driver);
			switch (Linkprovider) {

			case "xfinity":
				try {
					List<WebElement> xfinity = driver.findElements(By
							.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='0']"));
					xfinity.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" xfinity Login Page should be displayed " + "\n" + " xfinity Login Page is displayed",
							driver);
					Thread.sleep(8000);
					Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
					for (String contextName : contextNames) {
						// if
						// (contextName.contains("WEBVIEW_com.android.browser"))
						// {
						if (contextName.contains("NATIVE_APP")) {
							((AppiumDriver) driver).context(contextName);
						}
					}
					WebElement user_ID = driver.findElement(By.xpath("//android.widget.EditText[@text='Optimum ID']"));
					user_ID.sendKeys("research1000");
					WebElement user_Password = driver
							.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
					user_Password.sendKeys("support1000");
					Thread.sleep(500);
					// ((AndroidDriver) driver).hideKeyboard();
					WebElement Signin = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
					Signin.click();
					Thread.sleep(8000);
					WebElement NBC_Bridge_Screen = driver
							.findElement(By.xpath("//android.widget.TextView[@text='TV Provider Linked!']"));
					if (NBC_Bridge_Screen.getAttribute("text").contains("TV Provider Linked!")) {
						Extent_Reports.executionLog("PASS",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Navigated to NBC Bridge Screen and 'TV Provider Linked!' text is displayed ",
								driver);
					} else {
						Extent_Reports.executionLog("FAIL",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Not navigated to NBC Bridge Screen and 'TV Provider Linked!' text is not displayed ",
								driver);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "DIRECTV":
				try {
					List<WebElement> DIRECTV = driver.findElements(By
							.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='1']"));
					DIRECTV.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" DIRECTV Login Page should be displayed " + "\n" + " DIRECTV Login Page is displayed",
							driver);
					Thread.sleep(8000);
					Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
					for (String contextName : contextNames) {
						// if
						// (contextName.contains("WEBVIEW_com.android.browser"))
						// {
						if (contextName.contains("NATIVE_APP")) {
							((AppiumDriver) driver).context(contextName);
						}
					}
					WebElement user_ID = driver.findElement(By.xpath("//android.widget.EditText[@text='Optimum ID']"));
					user_ID.sendKeys("research1000");
					WebElement user_Password = driver
							.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
					user_Password.sendKeys("support1000");
					Thread.sleep(500);
					// ((AndroidDriver) driver).hideKeyboard();
					WebElement Signin = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
					Signin.click();
					Thread.sleep(8000);
					WebElement NBC_Bridge_Screen = driver
							.findElement(By.xpath("//android.widget.TextView[@text='TV Provider Linked!']"));
					if (NBC_Bridge_Screen.getAttribute("text").contains("TV Provider Linked!")) {
						Extent_Reports.executionLog("PASS",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Navigated to NBC Bridge Screen and 'TV Provider Linked!' text is displayed ",
								driver);
					} else {
						Extent_Reports.executionLog("FAIL",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Not navigated to NBC Bridge Screen and 'TV Provider Linked!' text is not displayed ",
								driver);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "dish":
				try {
					List<WebElement> dish = driver.findElements(By
							.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='2']"));
					dish.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" Optimum Login Page should be displayed " + "\n" + " Optimum Login Page is displayed",
							driver);
					Thread.sleep(8000);
					Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
					for (String contextName : contextNames) {
						// if
						// (contextName.contains("WEBVIEW_com.android.browser"))
						// {
						if (contextName.contains("NATIVE_APP")) {
							((AppiumDriver) driver).context(contextName);
						}
					}
					WebElement user_ID = driver.findElement(By.xpath("//android.widget.EditText[@text='Optimum ID']"));
					user_ID.sendKeys("research1000");
					WebElement user_Password = driver
							.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
					user_Password.sendKeys("support1000");
					Thread.sleep(500);
					// ((AndroidDriver) driver).hideKeyboard();
					WebElement Signin = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
					Signin.click();
					Thread.sleep(8000);
					WebElement NBC_Bridge_Screen = driver
							.findElement(By.xpath("//android.widget.TextView[@text='TV Provider Linked!']"));
					if (NBC_Bridge_Screen.getAttribute("text").contains("TV Provider Linked!")) {
						Extent_Reports.executionLog("PASS",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Navigated to NBC Bridge Screen and 'TV Provider Linked!' text is displayed ",
								driver);
					} else {
						Extent_Reports.executionLog("FAIL",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Not navigated to NBC Bridge Screen and 'TV Provider Linked!' text is not displayed ",
								driver);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "verizon":
				try {
					List<WebElement> verizon = driver.findElements(By
							.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='3']"));
					verizon.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" Optimum Login Page should be displayed " + "\n" + " Optimum Login Page is displayed",
							driver);
					Thread.sleep(8000);
					Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
					for (String contextName : contextNames) {
						// if
						// (contextName.contains("WEBVIEW_com.android.browser"))
						// {
						if (contextName.contains("NATIVE_APP")) {
							((AppiumDriver) driver).context(contextName);
						}
					}
					WebElement user_ID = driver.findElement(By.xpath("//android.widget.EditText[@text='Optimum ID']"));
					user_ID.sendKeys("research1000");
					WebElement user_Password = driver
							.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
					user_Password.sendKeys("support1000");
					Thread.sleep(500);
					// ((AndroidDriver) driver).hideKeyboard();
					WebElement Signin = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
					Signin.click();
					Thread.sleep(8000);
					WebElement NBC_Bridge_Screen = driver
							.findElement(By.xpath("//android.widget.TextView[@text='TV Provider Linked!']"));
					if (NBC_Bridge_Screen.getAttribute("text").contains("TV Provider Linked!")) {
						Extent_Reports.executionLog("PASS",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Navigated to NBC Bridge Screen and 'TV Provider Linked!' text is displayed ",
								driver);
					} else {
						Extent_Reports.executionLog("FAIL",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Not navigated to NBC Bridge Screen and 'TV Provider Linked!' text is not displayed ",
								driver);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "ATT":
				try {
					List<WebElement> ATT = driver.findElements(By
							.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='4']"));
					ATT.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS", " AT&T u-verse Login Page should be displayed " + "\n"
							+ " AT&T u-verse Login Page is displayed", driver);
					Thread.sleep(8000);
					Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
					for (String contextName : contextNames) {
						// if
						// (contextName.contains("WEBVIEW_com.android.browser"))
						// {
						if (contextName.contains("NATIVE_APP")) {
							((AppiumDriver) driver).context(contextName);
						}
					}
					WebElement user_ID = driver.findElement(By.xpath("//android.widget.EditText[@text='Optimum ID']"));
					user_ID.sendKeys("research1000");
					WebElement user_Password = driver
							.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
					user_Password.sendKeys("support1000");
					Thread.sleep(500);
					// ((AndroidDriver) driver).hideKeyboard();
					WebElement Signin = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
					Signin.click();
					Thread.sleep(8000);
					WebElement NBC_Bridge_Screen = driver
							.findElement(By.xpath("//android.widget.TextView[@text='TV Provider Linked!']"));
					if (NBC_Bridge_Screen.getAttribute("text").contains("TV Provider Linked!")) {
						Extent_Reports.executionLog("PASS",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Navigated to NBC Bridge Screen and 'TV Provider Linked!' text is displayed ",
								driver);
					} else {
						Extent_Reports.executionLog("FAIL",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Not navigated to NBC Bridge Screen and 'TV Provider Linked!' text is not displayed ",
								driver);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "cox":
				try {
					List<WebElement> cox = driver.findElements(By
							.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='5']"));
					cox.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" cox Login Page should be displayed " + "\n" + " cox Login Page is displayed", driver);
					Thread.sleep(8000);
					Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
					for (String contextName : contextNames) {
						// if
						// (contextName.contains("WEBVIEW_com.android.browser"))
						// {
						if (contextName.contains("NATIVE_APP")) {
							((AppiumDriver) driver).context(contextName);
						}
					}
					WebElement user_ID = driver.findElement(By.xpath("//android.widget.EditText[@text='Optimum ID']"));
					user_ID.sendKeys("research1000");
					WebElement user_Password = driver
							.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
					user_Password.sendKeys("support1000");
					Thread.sleep(500);
					// ((AndroidDriver) driver).hideKeyboard();
					WebElement Signin = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
					Signin.click();
					Thread.sleep(8000);
					WebElement NBC_Bridge_Screen = driver
							.findElement(By.xpath("//android.widget.TextView[@text='TV Provider Linked!']"));
					if (NBC_Bridge_Screen.getAttribute("text").contains("TV Provider Linked!")) {
						Extent_Reports.executionLog("PASS",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Navigated to NBC Bridge Screen and 'TV Provider Linked!' text is displayed ",
								driver);
					} else {
						Extent_Reports.executionLog("FAIL",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Not navigated to NBC Bridge Screen and 'TV Provider Linked!' text is not displayed ",
								driver);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "Spectrum":
				try {
					List<WebElement> Spectrum = driver.findElements(By
							.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='6']"));
					Spectrum.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS",
							" Spectrum Login Page should be displayed " + "\n" + " Spectrum Login Page is displayed",
							driver);
					Thread.sleep(8000);
					Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
					for (String contextName : contextNames) {
						// if
						// (contextName.contains("WEBVIEW_com.android.browser"))
						// {
						if (contextName.contains("NATIVE_APP")) {
							((AppiumDriver) driver).context(contextName);
						}
					}
					WebElement user_ID = driver.findElement(By.xpath("//android.widget.EditText[@text='Optimum ID']"));
					user_ID.sendKeys("research1000");
					WebElement user_Password = driver
							.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
					user_Password.sendKeys("support1000");
					Thread.sleep(500);
					// ((AndroidDriver) driver).hideKeyboard();
					WebElement Signin = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
					Signin.click();
					Thread.sleep(8000);
					WebElement NBC_Bridge_Screen = driver
							.findElement(By.xpath("//android.widget.TextView[@text='TV Provider Linked!']"));
					if (NBC_Bridge_Screen.getAttribute("text").contains("TV Provider Linked!")) {
						Extent_Reports.executionLog("PASS",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Navigated to NBC Bridge Screen and 'TV Provider Linked!' text is displayed ",
								driver);
					} else {
						Extent_Reports.executionLog("FAIL",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Not navigated to NBC Bridge Screen and 'TV Provider Linked!' text is not displayed ",
								driver);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "optimum":
				try {
					WebElement optimum = Utilities.returnElement(driver, lstObject.get(83), lstObject.get(82));
					optimum.click();
					Thread.sleep(10000);
					Extent_Reports.executionLog("PASS",
							" Optimum Login Page should be displayed " + "\n" + " Optimum Login Page is displayed",
							driver);

					Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
					for (String contextName : contextNames) {
						// if
						// (contextName.contains("WEBVIEW_com.android.browser"))
						// {
						if (contextName.contains("NATIVE_APP")) {
							((AppiumDriver) driver).context(contextName);
						}
					}
					WebElement user_ID = Utilities.returnElement(driver, lstObject.get(89), lstObject.get(88));
					user_ID.sendKeys(lstTestData.get(18));
					((AndroidDriver) driver).hideKeyboard();
					WebElement user_Password = Utilities.returnElement(driver, lstObject.get(92), lstObject.get(91));
					user_Password.sendKeys(lstTestData.get(19));
					((AndroidDriver) driver).hideKeyboard();
					Thread.sleep(5000);

					WebElement Signin = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
					Signin.click();
					Thread.sleep(8000);

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case "suddenlink":
				try {
					List<WebElement> suddenlink = driver.findElements(By
							.xpath("//android.support.v7.widget.RecyclerView/android.widget.FrameLayout[@index='8']"));
					suddenlink.get(0).click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS", " suddenlink Login Page should be displayed " + "\n"
							+ " suddenlink Login Page is displayed", driver);
					Thread.sleep(8000);
					Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
					for (String contextName : contextNames) {
						// if
						// (contextName.contains("WEBVIEW_com.android.browser"))
						// {
						if (contextName.contains("NATIVE_APP")) {
							((AppiumDriver) driver).context(contextName);
						}
					}
					WebElement user_ID = driver.findElement(By.xpath("//android.widget.EditText[@text='Optimum ID']"));
					user_ID.sendKeys("research1000");
					WebElement user_Password = driver
							.findElement(By.xpath("//android.widget.EditText[@text='Password']"));
					user_Password.sendKeys("support1000");
					Thread.sleep(500);
					// ((AndroidDriver) driver).hideKeyboard();
					WebElement Signin = driver.findElement(By.xpath("//android.widget.Image[@text='sign-in']"));
					Signin.click();
					Thread.sleep(8000);
					WebElement NBC_Bridge_Screen = driver
							.findElement(By.xpath("//android.widget.TextView[@text='TV Provider Linked!']"));
					if (NBC_Bridge_Screen.getAttribute("text").contains("TV Provider Linked!")) {
						Extent_Reports.executionLog("PASS",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Navigated to NBC Bridge Screen and 'TV Provider Linked!' text is displayed ",
								driver);
					} else {
						Extent_Reports.executionLog("FAIL",
								" Navigated to NBC Bridge Screen and 'TV Provider Linked!' text Should be displayed "
										+ "\n"
										+ " Not navigated to NBC Bridge Screen and 'TV Provider Linked!' text is not displayed ",
								driver);
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			}

			Thread.sleep(7000);

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "Anroid_MVPDPicker" + "\n" + e.getMessage(), driver);
		}

	}// EOC

	public void android_EmailValidation() throws Exception {

		Email_Validation = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
		if (Email_Validation.isEnabled()) {
			Email_Validation.sendKeys(lstTestData.get(20));
			((AndroidDriver) driver).hideKeyboard();
			passwrd = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
			passwrd.click();
			((AndroidDriver) driver).hideKeyboard();
			Thread.sleep(5000);
			 Email_Error = Utilities.returnElement(driver, lstObject.get(95),lstObject.get(94));
			
			
			//validating error message when the user enter an email which doesn't meet the brite verify crieteria
			if (Email_Error.getAttribute("text").contains(lstTestData.get(21))) {
				Extent_Reports.executionLog("PASS",
						"Email cannot be verified error message be displayed when the user enters an email which doesn't meet brite verify criteria "
								+ "\n" + "Email cannot be verified error message is displayed ",
						driver);
			} else {
				Extent_Reports.executionLog("PASS",
						"Email cannot be verified error message be displayed when the user enters an email which doesn't meet brite verify criteria "
								+ "\n" + "Email cannot be verified error message is not displayed ",
						driver);
			}
			Email_Validation.clear();
			Email_Validation.sendKeys(lstTestData.get(22));
			((AndroidDriver) driver).hideKeyboard();
			passwrd = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
			passwrd.click();
			((AndroidDriver) driver).hideKeyboard();
			Email_Error = Utilities.returnElement(driver, lstObject.get(101), lstObject.get(100));
			 
			//validating error message when the user enter an Invalid email while signing up to NBC Profile
			if (Email_Error.getText().contains(lstTestData.get(23))) {
				Extent_Reports.executionLog("PASS",
						"Invalid Email error message Should be displayed when the user enters an Invalid email " + "\n"
								+ "Invalid Email Error message is  displayed ",
						driver);

			} else {
				Extent_Reports.executionLog("FAIL",
						"Invalid Email error message Should be displayed when the user enters an Invalid email " + "\n"
								+ "Invalid Email Error message is  not displayed ",
						driver);

			}
			// Validating the Email which is already having an account in NBC
			Email_Validation.sendKeys(lstTestData.get(17));
			((AndroidDriver) driver).hideKeyboard();

			passwrd = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
			passwrd.sendKeys(lstTestData.get(4));
			((AndroidDriver) driver).hideKeyboard();
			chkBox = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
			chkBox.click();
			Thread.sleep(2000);
			SignUp = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
			SignUp.click();
			Thread.sleep(5000);
			Email_Error_AlreadyUsed = Utilities.returnElement(driver, lstObject.get(98), lstObject.get(97));
			if (Email_Error_AlreadyUsed.getText().contains(lstTestData.get(24))) {
				Extent_Reports.executionLog("PASS", " Email Already Used error message Should be displayed " + "\n"
						+ "Email Already Used Error message is displayed ", driver);
			} else {
				Extent_Reports.executionLog("FAIL", " Email Already Used error message Should be displayed " + "\n"
						+ "Email Already Used Error message is not displayed ", driver);
			}

			Extent_Reports.executionLog("PASS",
					"Email text field should be displayed " + "\n" + "Email text field is displayed ", driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					"Email text field should be displayed " + "\n" + "Email text field is not displayed ", driver);

		}
	}

	public void android_Verify_Authentication_Live() throws Exception{


		PGNbcApp App = new PGNbcApp(driver);
		//App.android_WaitForAppToLoad();
		// App.android_DismissCastOverlay();
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		Thread.sleep(4000);
		PGAndroidApp AndApp = new PGAndroidApp(driver);
		AndApp.android_OpenMenu("LIVE");
		Thread.sleep(5000);
		AndApp.anroid_MVPDPicker("optimum");
		
		Thread.sleep(5000);
		Vod_Player = driver.findElementByXPath("//android.widget.FrameLayout)");
		toggle = driver.findElementByXPath("//android.widget.ToggleButton[contains(@resource-id,'togglePlay')]");
		Vod_Player.click();
		toggle.click();

		stationLogo = driver.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'stationLogo')])");
		if (stationLogo.isEnabled()) {
			Extent_Reports.executionLog("PASS", " Connected TV Station Logo  should be displayed " + "\n"
					+ " Connected TV Station Logo is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", " Connected TV Station Logo  should be displayed " + "\n"
					+ " Connected TV Station Logo is not displayed", driver);
		}

		Tvproviderlogo = driver
				.findElementByXPath("//android.widget.ImageView[contains(@resource-id,'providerLogo')])");
		if (Tvproviderlogo.isEnabled()) {
			Extent_Reports.executionLog("PASS", "  TV Provider Logo  should be displayed on live Player Page" + "\n"
					+ " TV Provider Logo is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", "  TV Provider Logo  should be displayed on live Player Page" + "\n"
					+ " TV Provider Logo is not displayed", driver);
		}
		View_Schedule = driver.findElementByXPath("//android.widget.Button[@text='VIEW SCHEDULE'])");
		if (View_Schedule.isEnabled()) {
			Extent_Reports.executionLog("PASS", " View Schedule Button should be displayed on live Player Page" + "\n"
					+ " View Schedule Button  is displayed", driver);
		} else {
			Extent_Reports.executionLog("FAIL", " View Schedule Button should be displayed on live Player Page" + "\n"
					+ " View Schedule Button  is not displayed", driver);
		}

		CCtoggle = driver.findElementByXPath("//android.widget.ToggleButton[contains(@resource-id,'toggleCaption')]");
		if (CCtoggle.isEnabled()) {
			Extent_Reports.executionLog("PASS", " CC Button should be displayed on live Player Page" + "\n"
					+ " CC Button  is displayed", driver);
			CCtoggle.click();
		closedcaption=	driver.findElementByXPath("//android.widget.TextView[contains(@text,'CLOSED CAPTIONING')]");
			
		} else {
			Extent_Reports.executionLog("FAIL", " CC Button should be displayed on live Player Page" + "\n"
					+ " CC Button  is not displayed", driver);
		}
		if(closedcaption.isEnabled()){
			Extent_Reports.executionLog("PASS", " CC notifier should be displayed on live Player Page" + "\n"
					+ " CC notifier is displayed", driver);
		}else{
			Extent_Reports.executionLog("PASS", " CC notifier should be displayed on live Player Page" + "\n"
					+ " CC notifier is not displayed", driver);
		}
		close = driver.findElementByXPath("//android.widget.Button[@index='9'])");

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



		
		
	}
public void android_AddToFavorites() throws Exception{
		
		try {
			Synchronization.ExplicitWait(driver, lstObject.get(103), "visible");
			AddToFavoritesButton = Utilities.returnElement(driver, lstObject.get(104), lstObject.get(103));
			if(AddToFavoritesButton.isDisplayed()){
			
			AddToFavoritesButton.click();
			Thread.sleep(2000);
			Extent_Reports.executionLog("PASS","Add to Favorites button should be clicked " + "\n"
							+ "Add to Favorites button is clicked",driver);
			}
			else
			{
				Extent_Reports.executionLog("FAIL","Add to Favorites button should be clicked " + "\n"
						+ "Add to Favorites button is not clicked",driver);
			}
						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Extent_Reports.executionLog("INFO", "Clicking on ADD to Favorites Button" + "\n" + e.getMessage(), driver);
		}
	}


public String android_getEpisodeNameVideoDetailsPageVODPlayer () throws Exception
{
	
	//Only for Tablet
	try{
	Synchronization.ExplicitWait(driver, lstObject.get(118), "visible");
	
	WebElement showName = Utilities.returnElement(driver, lstObject.get(119), lstObject.get(118));
	EpisodeNameVODPlayer=showName.getText().trim();
	}
	catch(Exception e)
	{
		Extent_Reports.executionLog("INFO",
				"android_getEpisodeNameVideoDetailsPageVODPlayer  " + "\n" + e.getMessage(), driver);
	}
	
	
	return EpisodeNameVODPlayer;
}



public String android_getEpisodeNameSmartTile () throws Exception
{
	
	
	try{
	Synchronization.ExplicitWait(driver, lstObject.get(115), "visible");
	
	WebElement showName = Utilities.returnElement(driver, lstObject.get(116), lstObject.get(115));
	EpisodeName=showName.getText().trim();
	}
	catch(Exception e)
	{
		Extent_Reports.executionLog("INFO",
				"android_getEpisodeNameSmartTile  " + "\n" + e.getMessage(), driver);
	}
	
	
	return EpisodeName;
}


public void android_clickOnSmartTile() throws Exception{
	
	try {
		Synchronization.ExplicitWait(driver, lstObject.get(109), "visible");
		smartTile = Utilities.returnElement(driver, lstObject.get(110), lstObject.get(109));
		if(smartTile.isDisplayed())
		{
		
			smartTile.click();
		Thread.sleep(2000);
		Extent_Reports.executionLog("PASS"," SmartTile should be available  " + "\n"
				+ "  SmartTile is  available  ",driver);
		
		Synchronization.ExplicitWait(driver, lstObject.get(112), "visible");
		Vod_Player= Utilities.returnElement(driver, lstObject.get(113), lstObject.get(112));
			
		
		if(Vod_Player.isEnabled())
				{
		
				Extent_Reports.executionLog("PASS","Clicking on Smart Tile the VOD should start playing " + "\n"
						+ " VOD playback initated from Smart Tile ",driver);
				}
			else
				{
				Extent_Reports.executionLog("FAIL"," Clicking on Smart Tile the VOD should start playing " + "\n"
					+ " VOD playback is not initated from Smart Tile ",driver);
				}
					
		}
		else
		{
			Extent_Reports.executionLog("FAIL"," SmartTile should be available  " + "\n"
					+ "  SmartTile is not available  ",driver);
		}
	}
	
		catch (Exception e) {
		// TODO Auto-generated catch block
		Extent_Reports.executionLog("INFO", "Clicking on ADD to Favorites Button" + "\n" + e.getMessage(), driver);
	}

}

public void android_Verify_Schedule() throws Exception {
		PGNbcApp App = new PGNbcApp(driver);
		// App.android_WaitForAppToLoad();
		// App.android_DismissCastOverlay();
		MenuIcon = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
		MenuIcon.click();
		PGAndroidApp Sch = new PGAndroidApp(driver);
		Sch.android_OpenMenu("SCHEDULE");
		
		 /* stationlogo = driver.findElement(By.xpath("//android.widget.ImageView[contains(@resource-id,'stationLogo')]")); 
		  if (stationlogo.isEnabled()) {
			  Extent_Reports.executionLog("PASS","station logo should be Displayed " + "\n" + "station logo  is Displayed", driver); 
		  stationlogo.click();
		  StationNavigator = driver.findElement(By.xpath( "//android.view.View[@text='OTS_MOBILE_NY']")); 
		  if (StationNavigator.isEnabled()) { Extent_Reports.executionLog("PASS", "It shopuld be navigated to respective station Page  " + "\n" +"Navigated to respective station page", driver);
		  } 
		  else 
		  {
		  Extent_Reports.executionLog("FAIL","It shopuld be navigated to respective station Page  " + "\n" + "It is not Navigated to respective station page", driver);
		  } 
		  } 
		  else {
		  Extent_Reports.executionLog("FAIL","station logo should be Displayed " + "\n" +"station logo  is not Displayed", driver); 
		  }
		  
		  scheduleTiltle = driver.findElement(By.xpath("//android.widget.TextView[@text='SCHEDULE']"));
		  if (scheduleTiltle.isEnabled()){ 
			  Extent_Reports.executionLog("PASS","Schedule Title should be displayed  " + "\n" + "Schedule Title is displayed", driver); 
		  }
		  else 
		  {
		  Extent_Reports.executionLog("FAIL","Schedule Title should be displayed  " + "\n" + "Schedule Title is not displayed", driver);
		  
		  castIcon = driver .findElement(By.xpath("//android.view.View.[contains(@resource-id,'media_route_button')]")); 
		  if (castIcon.isEnabled())
		  { Extent_Reports.executionLog("PASS", "cast Icon  should be displayed  " + "\n" +  "cast Icon  is displayed", driver);
		  }
		  else {
		  }
		  Extent_Reports.executionLog("FAIL", "cast Icon  should be displayed  " + "\n" +
		  "cast Icon  is not displayed", driver);
		  }
		  */
	
		 
		Thread.sleep(5000);
		List<WebElement> Day = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'titleText')]"));
		Day.get(0).click();
		for (int i = 0; i < 14; i++) {
			List<WebElement> Days = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'titleText')]"));
			Days.get(0).click();
			if (Days.get(0).getAttribute("text").equals("Sun")) {
				break;
			}

		}
		WebElement Sun = driver.findElement(By.xpath("//android.widget.TextView[contains(@resource-id,'titleText') and @text='Sun']"));
		Sun.click();
		for(int k=0;k<=14;k++){
						
		for (int j = 0; j <=3; j++) {
			List<WebElement> Days2 = driver.findElements(By.xpath("//android.widget.TextView[contains(@resource-id,'titleText')]"));
			Days2.get(j).click();
		}

		}
	}

public void android_Verify_Episode_Metadata() throws Exception {
	PGNbcApp App = new PGNbcApp(driver);
	 App.android_WaitForAppToLoad();
	 App.android_DismissCastOverlay();
	App.android_OpenShow(lstTestData.get(26));
	
	
	WebElement	Metadata_Episode_Date = Utilities.returnElement(driver, lstObject.get(122), lstObject.get(121));
	
	List<WebElement> Metadata_episode_title = Utilities.returnElements(driver, lstObject.get(125), lstObject.get(124));
	
	if(Metadata_episode_title.get(2).isEnabled()){
		Extent_Reports.executionLog("PASS","Episode Title should be displayed in Show Home Page " + "\n" + "Episode Title is  displayed in Show Home Page", driver);
	}else{
		Extent_Reports.executionLog("FAIL","Episode Title should be displayed in Show Home Page " + "\n" + "Episode Title is not displayed in Show Home Page", driver);
	}
	String details = Metadata_Episode_Date.getText();
	String[] Episodedetails = details.split(" ");
	String EpisodeSeasonNumber = Episodedetails[0];
	String Episode_Number = Episodedetails[1];
	String Episode_Airdate = Episodedetails[3];
	if(EpisodeSeasonNumber.startsWith("S")){
		Extent_Reports.executionLog("PASS","Season Number should be displayed on episode tile in Show Home Page " + "\n" + "Season  Number is  displayed on episode tile in Show Home Page", driver);
	}else{
		Extent_Reports.executionLog("FAIL","Season Number should be displayed on episode tile in Show Home Page " + "\n" + "Season Number is  not displayed on episode tile in Show Home Page", driver);
	}
	if(Episode_Number.startsWith("E"))	{
		Extent_Reports.executionLog("PASS","Episode Number should be displayed on episode tile in Show Home Page " + "\n" + "Episode Number is  displayed on episode tile in Show Home Page", driver);
	}else{
		Extent_Reports.executionLog("FAIL","Episode Number should be displayed on episode tile in Show Home Page " + "\n" + "Episode Number is not  displayed on episode tile in Show Home Page", driver);
	}
	
	Date dateFormatEpisode = new SimpleDateFormat("MM/dd/yyyy").parse(Episode_Airdate);
	if(dateFormatEpisode!=null){
		Extent_Reports.executionLog("PASS","Episode Air date should be displayed on episode tile in Show Home Page " + "\n" + "Episode Air date displayed on episode tile in ShowHome Page", driver);
	}else{
		Extent_Reports.executionLog("FAIL","Episode Air date should be displayed on episode tile in Show Home Page " + "\n" + "Episode Air date is not displayed on episode tile in Show Home Page", driver);
	}
	
	WebElement Episode_ShowHomepage = driver.findElementByXPath("//android.widget.FrameLayout[contains(@resource-id,'video_item_container') and @index='1']");
	Episode_ShowHomepage.click();
	Thread.sleep(10000);
	
		
	((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);	
	Thread.sleep(2000);
	((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
	
	WebElement continue_Watching = Utilities.returnElement(driver, lstObject.get(128), lstObject.get(127));
	
	if (continue_Watching.isDisplayed()){
		Extent_Reports.executionLog("PASS","Continue watching shelf should be displayed  " + "\n" + "Continue watching shelf is displayed", driver);
		  
		
		
	}else{
		Extent_Reports.executionLog("FAIL","Continue watching shelf should be displayed  " + "\n" + "Continue watching shelf is notdisplayed", driver);
	}
	
	
	List<WebElement> Episode_Homepage_continueWatchignShelf = Utilities.returnElements(driver, lstObject.get(131), lstObject.get(130));
	if(Episode_Homepage_continueWatchignShelf.get(0).getText().equalsIgnoreCase(lstTestData.get(26))){
		Extent_Reports.executionLog("PASS","Show Title  should be displayed on episode tile in Home Page " + "\n" + "Show Title is  displayed on episode tile in Home Page", driver);
	}else{
		Extent_Reports.executionLog("FAIL","Show Title  should be displayed on episode tile in Home Page " + "\n" + "Show Title is not displayed on episode tile in Home Page", driver);
	}
	
	String seasondetails = Episode_Homepage_continueWatchignShelf.get(1).getText();
	String[] SeasonNumber = seasondetails.split(" ");
	String Season = SeasonNumber[0];
	String Episode = SeasonNumber[1];
	String Date = SeasonNumber[3];
	
	
	
	
	if(Season.startsWith("S")){
		Extent_Reports.executionLog("PASS","Season Number should be displayed on episode tile in Home Page " + "\n" + "Season  Number is  displayed on episode tile in Home Page", driver);
	}else{
		Extent_Reports.executionLog("FAIL","Season Number should be displayed on episode tile in Home Page " + "\n" + "Season Number is  not displayed on episode tile in Home Page", driver);
	}
	if(Episode.startsWith("E"))	{
		Extent_Reports.executionLog("PASS","Episode Number should be displayed on episode tile in Home Page " + "\n" + "Episode Number is  displayed on episode tile in Home Page", driver);
	}else{
		Extent_Reports.executionLog("FAIL","Episode Number should be displayed on episode tile in Home Page " + "\n" + "Episode Number is not  displayed on episode tile in Home Page", driver);
	}
	
Date dateFormat = new SimpleDateFormat("MM/dd/yyyy").parse(Date);
if(dateFormat!=null){
	Extent_Reports.executionLog("PASS","Episode Air date should be displayed on episode tile in Home Page " + "\n" + "Episode Air date displayed on episode tile in Home Page", driver);
}else{
	Extent_Reports.executionLog("FAIL","Episode Air date should be displayed on episode tile in Home Page " + "\n" + "Episode Air date is not displayed on episode tile in Home Page", driver);
}
}
	
	
	



}



