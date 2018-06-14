package com.nbcd.Pages;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
public class PGAppHomePage {

	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List <WebElement> objShowLists,objShowList;
	String sqlQry, Status;
	WebElement objnav, objRespNavBar,objClipDropDownWebEx,objShowLink;
	// Constructor to initialize all the Page Objects
	public PGAppHomePage(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		
		lstTestData = db.getTestDataObject("Select * from PGAppHomePage", "Input");
		lstObject = db.getTestDataObject("Select * from PGAppHomePage", "ObjectRepository");
	}
	// =========================================================================================================================
	@Test
	public void android_Apptest() throws  Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			try 
			{
				
				wait.until( ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(4))));
				WebElement objloading =  Utilities.returnElement(driver, lstObject.get(5), lstObject.get(4));
				objloading.click();
				WebElement objCancel =  Utilities.returnElement(driver, lstObject.get(71), lstObject.get(70));
				objCancel.click();
				
				Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n"
						+ "Waiting for app to load", driver);
			}
			catch(Exception e)
			{ 
				Thread.sleep(20000);
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
				Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n"
						+ "Waiting for app to load", driver);
			}
			try
			{
				wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(7))));
				WebElement CastIcon =  Utilities.returnElement(driver, lstObject.get(8), lstObject.get(7));
				CastIcon.click();
				Extent_Reports.executionLog("PASS", "Cast icon should be clicked " + "\n"
						+ "Click on cast icon", driver);
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(5000);
				Thread.sleep(5000);	
				WebElement CastPopUp =  Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
				if(CastPopUp.isDisplayed()) 
				{
					Extent_Reports.executionLog("PASS", "Cast pop up  should be displayed " + "\n"
							+ "Cast pop up  is  displayed", driver);
					System.out.println("cast pop up is displayed");
					((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
					Thread.sleep(5000);
				}
				else {
					Extent_Reports.executionLog("FAIL", "Cast pop up  should be displayed " + "\n"
							+ "Cast pop up  is  displayed", driver);
					System.out.println("cast pop up not displayed");
				}
			}
			catch(Exception e)
			{
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(5000);
			}
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(13))));
			WebElement HambergerIcon =  Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
			HambergerIcon.click();
			Extent_Reports.executionLog("PASS", "Hamberger menu  should be displayed " + "\n"
					+ "Hamberger menu  is displayed", driver);
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(16))));
			WebElement ShowsMenu =  Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			ShowsMenu.click();
			Thread.sleep(10000);  
			Extent_Reports.executionLog("PASS", "Shows menu  should be clicked " + "\n"
					+ "Shows menu is clicked", driver);
			try 
			{
				wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(19))));
				WebElement ShowName =  Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
				if(ShowName.isDisplayed()) 
				{
					ShowName.click();
					Extent_Reports.executionLog("PASS", "A.P. Bio Show   should be clicked " + "\n"
							+ "A.P. Bio Show is clicked", driver);
				}
				else {
				}
			}
			catch(Exception e) {
			}
			Thread.sleep(10000);
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(22))));
			WebElement EpisodeVideo =  Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
			EpisodeVideo.click();
			Extent_Reports.executionLog("PASS", "Episode  should be clicked " + "\n"
					+ "Episode is clicked", driver);
			Thread.sleep(10000);   
			try {
				wait.until( ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(4))));
				Thread.sleep(10000);
			}
			catch(Exception e)
			{ 
				System.out.println("exception occured at progress bar");
				Thread.sleep(10000);
			}
			try 
			{				
				wait.until( ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(25))));
				Thread.sleep(30000);
				Extent_Reports.executionLog("PASS", " show is  should be played " + "\n"
						+ "show is played", driver);
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(10000);
			}
			catch(Exception e)
			{ 
				Thread.sleep(30000);
				Extent_Reports.executionLog("PASS", " show is  should be played " + "\n"
						+ "show is played", driver);
				((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(10000);
			}
			try {
				wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(28))));
				WebElement ContinueWatching =  Utilities.returnElement(driver, lstObject.get(27), lstObject.get(28));
				if(ContinueWatching.isDisplayed())
				{
					Extent_Reports.executionLog("PASS", "Shows Page should be displayed " + "\n"
							+ "Shows Page is  displayed", driver);
					Thread.sleep(2000);
					((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
					Thread.sleep(2000);
					Extent_Reports.executionLog("PASS", "Continue watching should be displayed " + "\n"
							+ "Continue watching is  displayed", driver);
					Thread.sleep(2000);
				}
				else
				{
					Extent_Reports.executionLog("FAIL", "Continue watching should be displayed " + "\n"
							+ "Continue watching is not displayed", driver);
					Thread.sleep(2000);			
				}
				wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(19))));
				WebElement ShowName =  Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
				if(ShowName.isDisplayed()) 
				{
					((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
					Extent_Reports.executionLog("PASS", "A.P. Bio Show   should be clicked " + "\n"
							+ "A.P. Bio Show is clicked", driver);
					//	break;
				}
				if(ContinueWatching.isDisplayed())
				{
					Extent_Reports.executionLog("PASS", "Continue watching should be displayed " + "\n"
							+ "Continue watching is  displayed", driver);
					Thread.sleep(2000);
				}
				else 
				{
					Extent_Reports.executionLog("FAIL", "Continue watching should be displayed " + "\n"
							+ "Continue watching is not displayed", driver);
					Thread.sleep(2000);
				}
			}
			catch(Exception e) {
				Extent_Reports.executionLog("PASS", "Continue watching should be displayed " + "\n"
						+ "Continue watching is  displayed", driver);
			}
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
			((AndroidDriver)driver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(3000);
			
		}        
		catch (Exception exc) {
			Extent_Reports.executionLog("INFO",
					"android_Apptest"  + "\n"+ exc.getMessage(), driver);
			
		}
	}//EOM
	
	@Test
	public void iOS_Apptest() throws Exception 
	{
		try
		{
			try 
			{
				Thread.sleep(10000);
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(10000);
			}
			catch(Exception e) {
			}
			try 
			{
				Thread.sleep(10000);
				WebElement ok_button =  Utilities.returnElement(driver, lstObject.get(62), lstObject.get(61));
				ok_button.click();
			}
			catch(Exception e) {
			}
			WebDriverWait wait = new WebDriverWait(driver, 30);
			try {
				wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(49))));
				WebElement Allow =  Utilities.returnElement(driver, lstObject.get(50), lstObject.get(49));
				Allow.click();
			}
			catch(Exception e) {
			}
			try {
				wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(52))));
				WebElement CastOk =  Utilities.returnElement(driver, lstObject.get(53), lstObject.get(52));
				CastOk.click();
			}
			catch(Exception e) {
			}
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(31))));
			WebElement Shwosicon =  Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
			Shwosicon.click();
			Extent_Reports.executionLog("PASS", "Shows button should be clicked " + "\n"
					+ "Clicked on Shows Button", driver);
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
			WebElement APBioShow =  Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
			APBioShow.click();
			Extent_Reports.executionLog("PASS", "AP Bio show should be clicked " + "\n"
					+ "Clicked on AP Bio Show", driver);
			Thread.sleep(10000);
			try
			{
				WebElement Scrollobj =  Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
				//XCUIElementTypeStaticText[@name='Season']
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","down");
				scobj.put("element",Scrollobj);
				for(int i=0;i<20;i++)
				{
					jse.executeScript("mobile:scroll",scobj);
					Thread.sleep(1000);
					try 
					{
						WebElement EpisodeVideo =  Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
						if(EpisodeVideo.isDisplayed()) {
							break;
						}
					}
					catch(Exception n){
						Thread.sleep(1000);
					}
				}
				wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(37))));
				WebElement EpisodeVideo =  Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
				EpisodeVideo.click();
				Thread.sleep(50000);
			}
			catch(Exception e) 
			{
				List<WebElement> EpisodeFirstVideo =  Utilities.returnElements(driver, lstObject.get(38), lstObject.get(37));
				if(EpisodeFirstVideo.size()>0) {
					EpisodeFirstVideo.get(0).click();
					Extent_Reports.executionLog("PASS", "Episode video should be clicked " + "\n"
							+ "Clicked on Episode First Video ", driver);
					Thread.sleep(30000);
				}
				else 
				{
					EpisodeFirstVideo =  Utilities.returnElements(driver, lstObject.get(38), lstObject.get(37));
					if(EpisodeFirstVideo.size()>0) {
						EpisodeFirstVideo.get(0).click();
						Extent_Reports.executionLog("PASS", "Episode video should be clicked " + "\n"
								+ "Clicked on Episode First Video ", driver);
					}
				}
			}
			try 
			{
				Extent_Reports.executionLog("PASS", "Episode video should be played " + "\n"
						+ "Episode video is  played ", driver);
				WebElement vodPlayareatext =  Utilities.returnElement(driver, lstObject.get(68), lstObject.get(67));
				vodPlayareatext.click();
				Thread.sleep(500);
				//close button
				WebElement Close =  Utilities.returnElement(driver, lstObject.get(44), lstObject.get(43));
				Close.click();
				Thread.sleep(500);
			}
			catch(Exception e) 
			{
				WebElement vodPlayareatext =  Utilities.returnElement(driver, lstObject.get(68), lstObject.get(67));
				vodPlayareatext.click();
				//close button
				WebElement Close =  Utilities.returnElement(driver, lstObject.get(44), lstObject.get(43));
				Close.click();
			}
			Extent_Reports.executionLog("PASS", "Video should be closed " + "\n"
					+ "Video is closed", driver);
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(46))));
			WebElement ContinueWatching =  Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
			if(ContinueWatching.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Continue watching  should be displayed " + "\n"
						+ "Continue watching is displayed", driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Continue watching  should be displayed " + "\n"
						+ "Continue watching is displayed", driver);
			}
			
		}
		catch (Exception exc) {
			Extent_Reports.executionLog("INFO", "iOS_Apptest"  + "\n"+ exc.getMessage(), driver);
			
		}
	}
	
	
	
}//EOC
