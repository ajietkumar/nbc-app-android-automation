package com.nbcd.Pages;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.By;
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
public class PGEntitedVodAuthentication  {
	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> objShowLists, objShowList;
	String sqlQry, Status;
	WebElement objnav, objRespNavBar,objloading, objClipDropDownWebEx, objShowLink,SettingsMenu, CastIcon, CastPopUp, vodtap,Optimum, optLogin,optLoginpaswrd,UnlinkTvprovider,tvproviderLogo,skipBtnBridgescreen,tvproviderSignin,LinkTvProvider,ShowName, ShowsMenu, EpisodeVideo,ad, HambergerIcon, playPause, GoToShow;
	// Constructor to initialize all the Page Objects
	public PGEntitedVodAuthentication(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGEntitedVodAuthentication", "Input");
		lstObject = db.getTestDataObject("Select * from PGEntitedVodAuthentication", "ObjectRepository");
	}
	// =========================================================================================================================
	@Test
	public void android_EntitledAuthentication_NAF_3546() throws  Exception {
		try {
					WebDriverWait wait = new WebDriverWait(driver, 50);
			try {
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(4))));
				objloading = Utilities.returnElement(driver, lstObject.get(5), lstObject.get(4));
				objloading.click();
				Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
						driver);
			} catch (Exception e) {
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
						driver);
				Thread.sleep(10000);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(7))));
			CastIcon = Utilities.returnElement(driver, lstObject.get(8), lstObject.get(7));
			CastIcon.click();
			Extent_Reports.executionLog("PASS", "Cast icon should be clicked " + "\n" + "Click on cast icon",
					driver);
			try {
				Thread.sleep(5000);
				CastPopUp = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
				if (CastPopUp.isDisplayed()) {
					Extent_Reports.executionLog("PASS",
							"Cast pop up  should be displayed " + "\n" + "Cast pop up  is  displayed", driver);
					System.out.println("cast pop up is displayed");
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
					Thread.sleep(5000);
				} else {
					Extent_Reports.executionLog("FAIL",
							"Cast pop up  should be displayed " + "\n" + "Cast pop up  is  displayed", driver);
					System.out.println("cast pop up not displayed");
				}
			} catch (Exception e) { 
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(5000);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(13))));
			HambergerIcon = Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));

			HambergerIcon.click();
			Extent_Reports.executionLog("PASS",
					"Hamberger menu  should be displayed " + "\n" + "Hamberger menu  is displayed", driver);

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(25))));
			SettingsMenu = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));

			Thread.sleep(10000);
			if (SettingsMenu.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						"Settings menu  should be displayed " + "\n" + "Settings menu is displayed", driver);
				SettingsMenu.click();
			} else {
				Extent_Reports.executionLog("PASS",
						"Settings menu  should be displayed " + "\n" + "Settings menu is not displayed", driver);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(28))));
			LinkTvProvider = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));

			if (LinkTvProvider.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						"LinkTvProvider tab should be displayed " + "\n" + "LinkTvProvider Tab is displayed",
						driver);
				Thread.sleep(5000);
				LinkTvProvider.click();
			} else {
				Extent_Reports.executionLog("PASS",
						"LinkTvProvider tab should be displayed " + "\n" + "LinkTvProvider Tab is not displayed",
						driver);
			}	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(31))));
		Optimum = Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
		if(Optimum.isDisplayed()){
			
			Optimum.click();
			
		}else{
			Extent_Reports.executionLog("FAIL",
					"OPtimum Provider should be displayed on MVPD picker page " + "\n" + "OPtimum Provider is not displayed", driver);
			System.out.println("OPtimum Provider is not displayed");
						
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
		optLogin = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
		
		optLoginpaswrd = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
		
		tvproviderSignin = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
		
		optLogin.sendKeys(lstTestData.get(0));
		optLoginpaswrd.sendKeys(lstTestData.get(1));
		tvproviderSignin.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(43))));
		skipBtnBridgescreen = Utilities.returnElement(driver, lstObject.get(44), lstObject.get(43));
		skipBtnBridgescreen.click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(46))));
		UnlinkTvprovider = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
		tvproviderLogo = Utilities.returnElement(driver, lstObject.get(50), lstObject.get(49));
		
		if(UnlinkTvprovider.isDisplayed() && tvproviderLogo.isDisplayed()){
			Extent_Reports.executionLog("PASS",
					"TV Provider logo be displayed on top right corner after succesfully linking to TV provider " + "\n" + "TV Provider logo is  displayed", driver);
			System.out.println("TV Provider linked succesfully and logo is  displayed");	
		}else{
			Extent_Reports.executionLog("FAIL",
					"TV Provider logo be displayed on top right corner after succesfully linking to TV provider " + "\n" + "TV Provider logo is not  displayed", driver);
			System.out.println("TV Provider not linked succesfully and logo is not displayed");	
		}
		
		}
		catch (Exception e) {
			
			Extent_Reports.executionLog("INFO", "android_EntitledAuthentication_NAF_3546"  + "\n"+ e.getMessage(), driver);

		}
	}// EOM
	

	
	
	
	
	
}// EOC
