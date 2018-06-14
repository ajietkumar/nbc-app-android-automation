package com.nbcd.Pages;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
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

public class PGAppShowVideoDetails  {

	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List <WebElement> objShowLists,objShowList;
	String sqlQry, Status;
	WebElement objnav, objRespNavBar,objClipDropDownWebEx,objShowLink;
	public static int count=0;
	// Constructor to initialize all the Page Objects
	public PGAppShowVideoDetails(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGAppShowVideoDetails", "Input");
		lstObject = db.getTestDataObject("Select * from PGAppShowVideoDetails", "ObjectRepository");
	}
	// =========================================================================================================================
	@Test
	public void iOS_Verifytogglereflectaction_NIR7655() throws  Exception
	{
		try
		{

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			pgncapp.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(10000);

			/*
				WebElement Scrollobj =  Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
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

				WebElement Scrollobj =  Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
				WebElement EpisodeVideo =  Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
				pgncapp.iOS_scroll(Scrollobj, EpisodeVideo, "down");

				Synchronization.ExplicitWait(driver, lstObject.get(37), "visible");
				EpisodeVideo =  Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
				EpisodeVideo.click();
			 */



			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

			List<WebElement> EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
			boolean flag= false;
			for(int i=0;i<20;i++)
			{
				EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","right");
				scobj.put("element",EpisodedList.get(1));
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);
				try 
				{

					List<WebElement> showImages =  Utilities.returnElements(driver, lstObject.get(170), lstObject.get(169));
					for(int j=0;j<showImages.size();j++)
					{
						try 
						{
							if(showImages.get(j).getAttribute("name").length()>0) 
							{

							}
							else
							{
								flag=true;
								showImages.get(j).click();

								break;
							}
						}
						catch(Exception e)
						{
							flag=true;
							showImages.get(j).click();
							break;
						}


					}



				}
				catch(Exception e){
					break;
				}

				if(flag==true) 
				{
					break;
				}

			}



			Thread.sleep(50000);

			Extent_Reports.executionLog("PASS", "Episode video should be played " + "\n"
					+ "Episode video is  played ", driver);
			WebElement vodPlayareatext =  Utilities.returnElement(driver, lstObject.get(68), lstObject.get(67));
			Thread.sleep(30000);
			vodPlayareatext.click();
			Thread.sleep(500);
			//close button
			WebElement PlayPause =  Utilities.returnElement(driver, lstObject.get(71), lstObject.get(70));
			PlayPause.click();
			Extent_Reports.executionLog("PASS", "Episode video should be paused " + "\n"
					+ "Episode video is  paused ", driver);
			Thread.sleep(10000);
			vodPlayareatext.click();
			PlayPause.click();
			Extent_Reports.executionLog("PASS", "Episode video should be resumed " + "\n"
					+ "Episode video is  resumed ", driver);


		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verifytogglereflectaction_NIR7655"  + "\n"+ e.getMessage(), driver);

		}
	}
	@Test
	public void iOS_Verifytheupdatedmetadata_NIR7620() throws  Exception
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
			//Shows  Menu
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(31))));
			WebElement Shwosicon =  Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
			if(Shwosicon.isDisplayed()) {
				Shwosicon.click();
				Thread.sleep(30000);
				Extent_Reports.executionLog("PASS", "Shows button should be clicked " + "\n"
						+ "Clicked on Shows Button", driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Shows button should be clicked " + "\n"
						+ "Not Clicked on Shows Button", driver);
			}
			//Access Show
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(73))));
			WebElement AccessShow =  Utilities.returnElement(driver, lstObject.get(74), lstObject.get(73));
			if(AccessShow.isDisplayed())
			{
				AccessShow.click();
				Extent_Reports.executionLog("PASS", "AP Bio show should be clicked " + "\n"
						+ "Clicked on AP Bio Show", driver);
				Thread.sleep(30000);
			}
			else {
				Extent_Reports.executionLog("FAIL", "AP Bio show should be clicked " + "\n"
						+ "Not Clicked on AP Bio Show", driver);
			}
			//Click Heart Icon
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(76))));
			WebElement HeartIcon =  Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
			if(HeartIcon.isDisplayed())
			{
				HeartIcon.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS", "Heart Icon should be clicked " + "\n"
						+ "Clicked on Heart Icon", driver);
				try {
					WebElement FavSignupclose =  Utilities.returnElement(driver, lstObject.get(95), lstObject.get(94));
					FavSignupclose.click();
					Thread.sleep(2000);
					Thread.sleep(10000);
				}
				catch(Exception e) {
				}
			}
			else {
				Extent_Reports.executionLog("FAIL", "Heart Icon should be clicked " + "\n"
						+ "Not Clicked on Heart Icon", driver);
			}
			//Show Meta Data 
			List<WebElement> MetadataList= Utilities.returnElements(driver, lstObject.get(80), lstObject.get(79));
			ArrayList<String> MetadataText=new ArrayList<String>();
			for(int i=0;i<MetadataList.size();i++) 
			{
				MetadataText.add(MetadataList.get(i).getText().trim());
			}
			if(MetadataText.size()>0)
			{
				String MetdataValue;
				for(int i=0;i<MetadataText.size();i++) 
				{
					MetdataValue= MetadataText.get(i).trim();
					System.out.println(MetdataValue);
					Extent_Reports.executionLog("PASS", "The MetaData Shoud be displayed " +"\n"
							+ "he MetaData is displayed as" + MetdataValue, driver);
				}
			}
			//Click on Favorite menu
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(85))));
			WebElement FavMenu =  Utilities.returnElement(driver, lstObject.get(86), lstObject.get(85));
			if(FavMenu.isDisplayed())
			{
				FavMenu.click();
				Actions act= new Actions(driver);
				act.moveToElement(FavMenu).doubleClick();
				Extent_Reports.executionLog("PASS", "Favorites Menu should be clicked " + "\n"
						+ "Clicked on Favorites Menu", driver);
				Thread.sleep(10000);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Favorites Menu should be clicked " + "\n"
						+ "Not Clicked on Favorites Menu", driver);
			}
			//Very the meta data in favorite section
			for(int i=0;i<MetadataText.size();i++) 
			{
				WebElement Metadat =  Utilities.returnElement(driver, lstObject.get(86), "//*[@name='"+MetadataText.get(i)+"']");
				if(Metadat.isDisplayed())
				{
					Extent_Reports.executionLog("PASS", "The MetaData Shoud be displayed " +"\n"
							+ "he MetaData is displayed " + MetadataText.get(i), driver);
				}
				else {
					Extent_Reports.executionLog("FAIL", "The MetaData Shoud be displayed " +"\n"
							+ "The MetaData is not displayed " + MetadataText.get(i), driver);
				}
			}
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verifytheupdatedmetadata_NIR7620"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM


	@Test
	public void iOS_VerifyupdatedmetadataClipShowdetailpage_NIR7616() throws  Exception
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
			//Shows  Menu
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(31))));
			WebElement Shwosicon =  Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
			if(Shwosicon.isDisplayed()) {
				Shwosicon.click();
				Thread.sleep(30000);
				Extent_Reports.executionLog("PASS", "Shows button should be clicked " + "\n"
						+ "Clicked on Shows Button", driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Shows button should be clicked " + "\n"
						+ "Not Clicked on Shows Button", driver);
			}
			//Access Show
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(100))));
			WebElement AccessShow =  Utilities.returnElement(driver, lstObject.get(101), lstObject.get(100));
			if(AccessShow.isDisplayed())
			{
				AccessShow.click();
				Extent_Reports.executionLog("PASS", "America's Got Talent show should be clicked " + "\n"
						+ "Clicked on America's Got Talent Show", driver);
				Thread.sleep(30000);
			}
			else {
				Extent_Reports.executionLog("FAIL", "America's Got Talent show should be clicked " + "\n"
						+ "Not Clicked on America's Got Talent Show", driver);
			}

			//Clip Meta Data 

			try
			{
				WebElement Scrollobj =  Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));

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
						WebElement ClipsSection =  Utilities.returnElement(driver, lstObject.get(104), lstObject.get(103));
						if(ClipsSection.isDisplayed()) {
							Extent_Reports.executionLog("PASS", "Clips section should be displayed " + "\n"
									+ "Clips section is displayed", driver);
							break;
						}
					}
					catch(Exception n){
						Thread.sleep(1000);
					}
				}

				Thread.sleep(5000);
			}
			catch(Exception e) 
			{
				Thread.sleep(1000);
			}


			//Verify meta data
			List<WebElement> MetadataList= Utilities.returnElements(driver, lstObject.get(107), lstObject.get(106));
			ArrayList<String> MetadataText=new ArrayList<String>();
			for(int i=0;i<MetadataList.size();i++) 
			{
				MetadataText.add(MetadataList.get(i).getText().trim());
			}
			if(MetadataText.size()>0)
			{
				String MetdataValue;
				for(int i=0;i<MetadataText.size();i++) 
				{
					MetdataValue= MetadataText.get(i).trim();
					System.out.println(MetdataValue);
					Extent_Reports.executionLog("PASS", "The MetaData Shoud be displayed " +"\n"
							+ "he MetaData is displayed as" + MetdataValue, driver);
				}
			}

		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_VerifyupdatedmetadataClipShowdetailpage_NIR7616"  + "\n"+ e.getMessage(), driver);
		}

	}//EOM

	public void iOS_Verifytheupdatedmetadata_NIR7619() throws  Exception
	{
		try
		{

			try 
			{
				Thread.sleep(5000);
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


			try
			{

				WebElement Scrollobj =  Utilities.returnElement(driver, lstObject.get(110), lstObject.get(109));

				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","down");
				scobj.put("element",Scrollobj);

				for(int i=0;i<20;i++)
				{
					jse.executeScript("mobile:scroll",scobj);
					Thread.sleep(5000);

					try 
					{
						Thread.sleep(5000);

						WebElement JustUnlocked =  Utilities.returnElement(driver, lstObject.get(113), lstObject.get(112));
						if(JustUnlocked.isDisplayed()) {
							Extent_Reports.executionLog("PASS", "Just now unlocked  section should be displayed " + "\n"
									+ "Just now unlocked section is displayed", driver);
							jse.executeScript("mobile:scroll",scobj);
							break;
						}
					}
					catch(Exception n){
						Thread.sleep(1000);
					}
				}

				Thread.sleep(5000);
			}
			catch(Exception e) 
			{
				Thread.sleep(1000);
			}

			String Justnowunlockedepisodename="";
			List<WebElement> JustUnlocked= Utilities.returnElements(driver, lstObject.get(113), lstObject.get(112));
			if(JustUnlocked.size()>0) 
			{
				for(int i=0;i<JustUnlocked.size();i++) 
				{
					if(JustUnlocked.get(i).getText().startsWith("S1")) 
					{	
						Justnowunlockedepisodename=JustUnlocked.get(i).getText().trim();

						JustUnlocked.get(i).click();
						Thread.sleep(5000);
						Extent_Reports.executionLog("PASS", "Just now unlocked episode should be cliked " + "\n"
								+ "Just now unlocked episode is cliked and episode name is " +Justnowunlockedepisodename, driver);

						Thread.sleep(30000);
						break;
					}
				}
			}


			try 
			{
				Extent_Reports.executionLog("PASS", "Episode video should be played " + "\n"
						+ "Episode video is  played ", driver);
				Thread.sleep(30000);
				WebElement vodPlayareatext =  Utilities.returnElement(driver, lstObject.get(116), lstObject.get(115));
				vodPlayareatext.click();
				Thread.sleep(500);
				//close button
				WebElement Close =  Utilities.returnElement(driver, lstObject.get(119), lstObject.get(118));
				Close.click();
				Thread.sleep(10000);
			}
			catch(Exception e) 
			{
				WebElement vodPlayareatext =  Utilities.returnElement(driver, lstObject.get(116), lstObject.get(115));
				vodPlayareatext.click();
				//close button
				WebElement Close =  Utilities.returnElement(driver, lstObject.get(119), lstObject.get(118));
				Close.click();
				Thread.sleep(10000);
			}
			Extent_Reports.executionLog("PASS", "Video should be closed " + "\n"
					+ "Video is closed", driver);


			List<WebElement> ContinueWatchSectionVideoList= Utilities.returnElements(driver, lstObject.get(122), lstObject.get(121));
			if(ContinueWatchSectionVideoList.size()>0) 
			{
				for(int i=0;i<JustUnlocked.size();i++) 
				{
					if(ContinueWatchSectionVideoList.get(i).getText().trim().equalsIgnoreCase(Justnowunlockedepisodename)) 
					{	

						Extent_Reports.executionLog("PASS", Justnowunlockedepisodename+ "Episode should be displayed under continue watching section " + "\n"
								+ Justnowunlockedepisodename+ "Episode is displayed under continue watching section ", driver);

						//Thread.sleep(1000);
						break;
					}
				}
			}




			//Click on Favorite menu

			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(85))));
			WebElement FavMenu =  Utilities.returnElement(driver, lstObject.get(86), lstObject.get(85));
			if(FavMenu.isDisplayed())
			{
				FavMenu.click();
				Actions act= new Actions(driver);
				act.moveToElement(FavMenu).doubleClick();
				Extent_Reports.executionLog("PASS", "Favorites Menu should be clicked " + "\n"
						+ "Clicked on Favorites Menu", driver);
				Thread.sleep(10000);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Favorites Menu should be clicked " + "\n"
						+ "Not Clicked on Favorites Menu", driver);
			}


			ContinueWatchSectionVideoList= Utilities.returnElements(driver, lstObject.get(125), lstObject.get(124));
			if(ContinueWatchSectionVideoList.size()>0) 
			{
				for(int i=0;i<JustUnlocked.size();i++) 
				{
					if(ContinueWatchSectionVideoList.get(i).getText().trim().equalsIgnoreCase(Justnowunlockedepisodename)) 
					{	

						Extent_Reports.executionLog("PASS", Justnowunlockedepisodename+ "Episode should be displayed under continue watching section " + "\n"
								+ Justnowunlockedepisodename+ "Episode is displayed under continue watching section ", driver);

						Thread.sleep(30000);
						break;
					}
				}
			}

		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verifytheupdatedmetadata_NIR7619"  + "\n"+ e.getMessage(), driver);
		}


	}//EOM


	public void iOS_Verifymodalcloses_NIR_7231() throws  Exception
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

			Extent_Reports.executionLog("PASS", "Global home page should be displayed " + "\n"
					+ "Global home page is  displayed ", driver);

			//Shows  Menu
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(31))));
			WebElement Shwosicon =  Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
			if(Shwosicon.isDisplayed()) {
				Shwosicon.click();
				Thread.sleep(30000);
				Extent_Reports.executionLog("PASS", "Shows button should be clicked " + "\n"
						+ "Clicked on Shows Button", driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Shows button should be clicked " + "\n"
						+ "Not Clicked on Shows Button", driver);
			}
			//Access Show
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(73))));
			WebElement AccessShow =  Utilities.returnElement(driver, lstObject.get(74), lstObject.get(73));

			AccessShow.click();
			Thread.sleep(5000);
			WebElement infobtn = Utilities.returnElement(driver, lstObject.get(128), lstObject.get(127));
			//driver.findElement(By.xpath("//XCUIElementTypeButton[@label='InfoIconOutline']"));

			if(infobtn.isDisplayed())
			{
				infobtn.click();
				Extent_Reports.executionLog("PASS", "More info button should be displayed and has been clicked  " + "\n"
						+ "More info button is displayed and is clicked", driver);
				Thread.sleep(30000);
			}
			else {
				Extent_Reports.executionLog("FAIL", "More info button should be displayed and has been clicked " + "\n"
						+ "More info button is not displayed ", driver);
			}

			WebElement About_the_Show_Text = Utilities.returnElement(driver, lstObject.get(131), lstObject.get(130));
			//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='About the Show']"));
			if(About_the_Show_Text.isDisplayed())
			{

				Extent_Reports.executionLog("PASS", "About the Show Header should be displayed  " + "\n"
						+ "About the Show Header is displayed ", driver);
				Thread.sleep(30000);
			}
			else {
				Extent_Reports.executionLog("FAIL", "About the Show Header should be displayed  " + "\n"
						+ "About the Show Header is not displayed  ", driver);
			}

			WebElement About_the_Show_content = Utilities.returnElement(driver, lstObject.get(134), lstObject.get(133));
			//driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='NBC Enterprise']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView"));
			if(About_the_Show_content.isDisplayed())
			{

				Extent_Reports.executionLog("PASS", "Show description should be displayed  " + "\n"
						+ "Show description is displayed ", driver);
				Thread.sleep(10000);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Show description should be displayed  " + "\n"
						+ "Show description is not displayed  ", driver);
			}

			WebElement Scrollobj =  Utilities.returnElement(driver, lstObject.get(134), lstObject.get(133));
			//driver.findElement(By.xpath("//XCUIElementTypeApplication[@name='NBC Enterprise']/XCUIElementTypeWindow[1]/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTextView"));
			//XCUIElementTypeStaticText[@name='Season']
			JavascriptExecutor jse=  (JavascriptExecutor) driver;
			HashMap scobj= new HashMap(); 
			scobj.put("direction","down");
			scobj.put("element",Scrollobj);
			for(int i=0;i<4;i++)
			{
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);
				try 
				{
					Extent_Reports.executionLog("PASS", "End of the page should be displayed " + "\n"
							+ "End of the page is displayed ", driver);
				}
				catch(Exception n)
				{

				}

			}


			WebElement X_icon = Utilities.returnElement(driver, lstObject.get(137), lstObject.get(136));
			//driver.findElement(By.xpath("//XCUIElementTypeButton[@name='CloseIconSmall']"));
			if(X_icon.isDisplayed())
			{

				Extent_Reports.executionLog("PASS", "X icon should be displayed on top right of the page " + "\n"
						+ "X icon is displayed on top right of the page ", driver);
				X_icon.click();
				Thread.sleep(200);
				WebElement peacockimg = Utilities.returnElement(driver, lstObject.get(140), lstObject.get(139));
				//driver.findElement(By.xpath("//XCUIElementTypeButton[@label='Home Screen']"));

				if(peacockimg.isDisplayed()) {
					Extent_Reports.executionLog("PASS", "On Clicking the 'X' icon , Show home page should be displayed " + "\n"
							+ "On Clicking the 'X' icon , Show home page is displayed ", driver);
				}else {
					Extent_Reports.executionLog("FAIL", "On Clicking the 'X' icon , Show home page should be displayed " + "\n"
							+ "On Clicking the 'X' icon , Show home page is not displayed ", driver);
				}


				Thread.sleep(2000);
			}
			else {
				Extent_Reports.executionLog("FAIL", "X icon should be displayed on top right of the page  " + "\n"
						+ "X icon is not displayed on top right of the page  ", driver);
			}





		}
		catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_example"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM


	public void iOS_Verify_Key_Icon_NIR_6499() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();

			//Select a show
			pgnbcappobj.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(20000);
			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));

			pgnbcappobj.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgnbcappobj.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

			//EpisodedList //XCUIElementTypeStaticText[@label='Episodes']/parent::XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell
			List<WebElement> EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
			for(int i=0;i<10;i++)
			{
				EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","right");
				scobj.put("element",EpisodedList.get(1));
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);
				try 
				{
					List<WebElement> AuthKeyEpisodesList =  Utilities.returnElements(driver, lstObject.get(152), lstObject.get(151));
					/*
				if(AuthKeyEpisodesList.size()>=0)
				{

					Extent_Reports.executionLog("PASS", "Auth key Epidode should be displayed " + "\n"
    						+ "Auth key Epidode is displayed", driver);
					AuthKeyEpisodesList =  Utilities.returnElements(driver, lstObject.get(152), lstObject.get(151));
					AuthKeyEpisodesList.get(0).click();
					break;
				}
					 */
					/*
				if(AuthKeyEpisodesList.size()>=0)
				{
					Extent_Reports.executionLog("PASS", "Auth key Epidode should be displayed " + "\n"
    						+ "Auth key Epidode is displayed", driver);
    				Thread.sleep(10000);
				}
					 */

					for(int j=0;j<AuthKeyEpisodesList.size();j++)
					{
						if (AuthKeyEpisodesList.get(j).isEnabled())
						{
							Extent_Reports.executionLog("PASS", "Auth key Epidode should be displayed " + "\n"
									+ "Auth key Epidode is displayed", driver);
							AuthKeyEpisodesList.get(j).click();
							Thread.sleep(10000);
							break;
						}
					}


				}
				catch(Exception e){

				}


			}



			//if (Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151)).isEnabled()) 
			//{

			Extent_Reports.executionLog("PASS", "Auth key should be displayed " + "\n"
					+ "Auth key is displayed", driver);
			//Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151)).click();




			WebElement Forkscreen =  //Utilities.returnElement(driver, lstObject.get(134), lstObject.get(133));
					driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Watch now with an NBC Profile']"));

			WebElement Continue_btn =  //Utilities.returnElement(driver, lstObject.get(134), lstObject.get(133));
					driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"CONTINUE\"]"));

			WebElement LINK_PROVIDER_btn =  //Utilities.returnElement(driver, lstObject.get(134), lstObject.get(133));
					driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LINK PROVIDER\"]"));

			if(Forkscreen.isDisplayed() && Continue_btn.isDisplayed() && LINK_PROVIDER_btn.isDisplayed()) {

				Extent_Reports.executionLog("PASS", "Forks creen should be displayed " + "\n"
						+ "Fork screen is displayed", driver);
			} else {
				Extent_Reports.executionLog("FAIL", "Fork screen should be displayed " + "\n"
						+ "Fork screen is not displayed", driver);

				//	}

				//	}else {
				//	Extent_Reports.executionLog("FAIL", "Auth key should be displayed " + "\n"
				//			+ "Auth key is not displayed", driver);

			}


		}
		catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_example"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM




	public void iOS_Verify_MVPD_fromshow_MVP_NIR8685() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();

			//Select a show
			pgnbcappobj.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(20000);
			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgnbcappobj.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgnbcappobj.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);
			boolean flag=false;
			List<WebElement> EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
			for(int i=0;i<10;i++)
			{
				EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","right");
				scobj.put("element",EpisodedList.get(1));
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);
				try 
				{
					List<WebElement> AuthKeyEpisodesList =  Utilities.returnElements(driver, lstObject.get(152), lstObject.get(151));


					for(int j=0;j<AuthKeyEpisodesList.size();j++)
					{
						if (AuthKeyEpisodesList.get(j).isEnabled())
						{
							Extent_Reports.executionLog("PASS", "Auth key Epidode should be displayed " + "\n"
									+ "Auth key Epidode is displayed", driver);
							AuthKeyEpisodesList.get(j).click();
							Thread.sleep(10000);
							flag=true;
							break;
						}
					}


				}


				catch(Exception e)
				{
					if(flag==true)
						break;

				}

				if(flag==true)
					break;


			}



			Extent_Reports.executionLog("PASS", "Auth key should be displayed " + "\n"
					+ "Auth key is displayed", driver);

			WebElement Forkscreen =  Utilities.returnElement(driver, lstObject.get(161), lstObject.get(160));
			//driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Watch now with an NBC Profile']"));

			WebElement Continue_btn =  Utilities.returnElement(driver, lstObject.get(164), lstObject.get(163));
			//driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"CONTINUE\"]"));

			WebElement LINK_PROVIDER_btn =  Utilities.returnElement(driver, lstObject.get(167), lstObject.get(166));
			//driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"LINK PROVIDER\"]"));

			if(Forkscreen.isDisplayed() && Continue_btn.isDisplayed() && LINK_PROVIDER_btn.isDisplayed()) 
			{

				Extent_Reports.executionLog("PASS", "Forks creen should be displayed " + "\n"
						+ "Fork screen is displayed", driver);
				Continue_btn.click();
				Thread.sleep(10000);
				List<WebElement> ios_statictextList =Utilities.returnElements(driver, lstObject.get(173), lstObject.get(172));
				for (int j=0;j<ios_statictextList.size();j++) {
					Extent_Reports.executionLog("PASS", "NBC profile page content should be displayed as:  " + ios_statictextList.get(j).getAttribute("name") + "\n" + "NBC profile page content is  displayed",
							driver);
				}
				/*
					WebElement Signupbutton =  Utilities.returnElement(driver, lstObject.get(176), lstObject.get(175));
					if(Signupbutton.isDisplayed()) {
						Extent_Reports.executionLog("PASS", "FB signup button should be displayed " + "\n"
								+ "FB signup button is displayed", driver);
					}
					else {
						Extent_Reports.executionLog("FAIL", "FB signup button should be displayed " + "\n"
								+ "FB signup button is not displayed", driver);
					}
				 */
			} else {
				Extent_Reports.executionLog("FAIL", "Fork screen should be displayed " + "\n"
						+ "Fork screen is not displayed", driver);
			}


			WebElement close =  Utilities.returnElement(driver, lstObject.get(137), lstObject.get(136));
			if(close.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "FB close button should be displayed " + "\n"
						+ "FB close button is displayed", driver);
				close.click();
				Thread.sleep(10000);
				flag=false;
				EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
				for(int i=0;i<10;i++)
				{
					EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
					JavascriptExecutor jse=  (JavascriptExecutor) driver;
					HashMap scobj= new HashMap(); 
					scobj.put("direction","right");
					scobj.put("element",EpisodedList.get(1));
					jse.executeScript("mobile:scroll",scobj);
					Thread.sleep(1000);
					try 
					{
						List<WebElement> AuthKeyEpisodesList =  Utilities.returnElements(driver, lstObject.get(152), lstObject.get(151));


						for(int j=0;j<AuthKeyEpisodesList.size();j++)
						{
							if (AuthKeyEpisodesList.get(j).isEnabled())
							{
								Extent_Reports.executionLog("PASS", "Auth key Epidode should be displayed " + "\n"
										+ "Auth key Epidode is displayed", driver);
								AuthKeyEpisodesList.get(j).click();
								Thread.sleep(10000);
								flag=true;
								break;
							}
						}


					}
					catch(Exception e){
						if(flag==true)
							break;
					}

					if(flag==true)
						break;


				}
			}
			else {
				Extent_Reports.executionLog("FAIL", "FB signup button should be displayed " + "\n"
						+ "FB signup button is not displayed", driver);
			}


			LINK_PROVIDER_btn =  Utilities.returnElement(driver, lstObject.get(167), lstObject.get(166));
			LINK_PROVIDER_btn.click();
			Thread.sleep(10000);

			Alert alert = driver.switchTo().alert();
			alert.dismiss();;
			Thread.sleep(10000);




			PGAppSettings pgappsetting= new PGAppSettings(driver);



			pgappsetting.iOS_MVPD_showdetails();





		}
		catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_example"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM


	public void iOS_VerifytapsFullScreenbuttonPortrait_NIR7208() throws  Exception
	{
		try
		{
			//XCUIElementTypeStaticText[@name='Player-Header-Label-VideoTitle']

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			pgncapp.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(10000);

			/*
				WebElement Scrollobj =  Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
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
			 */
			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

			List<WebElement> EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
			boolean flag= false;
			for(int i=0;i<20;i++)
			{
				EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","right");
				scobj.put("element",EpisodedList.get(1));
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);
				try 
				{

					List<WebElement> showImages =  Utilities.returnElements(driver, lstObject.get(170), lstObject.get(169));
					for(int j=0;j<showImages.size();j++)
					{
						try 
						{
							if(showImages.get(j).getAttribute("name").length()>0) 
							{

							}
							else
							{
								flag=true;
								showImages.get(j).click();

								break;
							}
						}
						catch(Exception e)
						{
							flag=true;
							showImages.get(j).click();
							break;
						}


					}



				}
				catch(Exception e){
					break;
				}

				if(flag==true) 
				{
					break;
				}

			}


			Extent_Reports.executionLog("PASS", "Episode video should be played " + "\n"
					+ "Episode video is  played ", driver);
			pgncapp.iOS_VODPlayValidation("playpause");
			pgncapp.iOS_VODPlayValidation("fullscreen");






		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_VerifytapsFullScreenbuttonPortrait_NIR7208"  + "\n"+ e.getMessage(), driver);

		}
	}//EOM


	public void iOS_Verify_Videotitleheader_videoplayer_Landscape_NIR7313() throws  Exception
	{
		try
		{
			//XCUIElementTypeStaticText[@name='Player-Header-Label-VideoTitle']

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			pgncapp.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(10000);


			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

			List<WebElement> EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
			boolean flag= false;
			for(int i=0;i<20;i++)
			{
				EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","right");
				scobj.put("element",EpisodedList.get(1));
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);
				try 
				{

					List<WebElement> showImages =  Utilities.returnElements(driver, lstObject.get(170), lstObject.get(169));
					for(int j=0;j<showImages.size();j++)
					{
						try 
						{
							if(showImages.get(j).getAttribute("name").length()>0) 
							{

							}
							else
							{
								flag=true;
								showImages.get(j).click();

								break;
							}
						}
						catch(Exception e)
						{
							flag=true;
							showImages.get(j).click();
							break;
						}


					}



				}
				catch(Exception e){
					break;
				}

				if(flag==true) 
				{
					break;
				}

			}


			Extent_Reports.executionLog("PASS", "Episode video should be played " + "\n"
					+ "Episode video is  played ", driver);
			pgncapp.iOS_VODPlayValidation("playpause");
			pgncapp.iOS_VODPlayValidation("fullscreen");






		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_VerifytapsFullScreenbuttonPortrait_NIR7208"  + "\n"+ e.getMessage(), driver);

		}
	}//EOM


	public void iOS_Verify_parental_ratings_NIR7226() throws  Exception
	{
		try
		{
			//XCUIElementTypeStaticText[@name='Player-Header-Label-VideoTitle']

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			pgncapp.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(10000);


			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

			List<WebElement> EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
			boolean flag= false;
			for(int i=0;i<20;i++)
			{
				EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","right");
				scobj.put("element",EpisodedList.get(1));
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);
				try 
				{

					List<WebElement> showImages =  Utilities.returnElements(driver, lstObject.get(170), lstObject.get(169));
					for(int j=0;j<showImages.size();j++)
					{
						try 
						{
							if(showImages.get(j).getAttribute("name").length()>0) 
							{

							}
							else
							{
								flag=true;
								showImages.get(j).click();

								break;
							}
						}
						catch(Exception e)
						{
							flag=true;
							showImages.get(j).click();
							break;
						}


					}



				}
				catch(Exception e){
					break;
				}

				if(flag==true) 
				{
					break;
				}

			}


			Extent_Reports.executionLog("PASS", "Episode video should be played " + "\n"
					+ "Episode video is  played ", driver);
			//Wait for loading video- Do not delete
			Thread.sleep(5000);

			pgncapp.iOS_VODPlayValidation("parentalrating");



		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verify_parental_ratings_NIR7226"  + "\n"+ e.getMessage(), driver);

		}
	}//EOM


	public void iOS_Verify_keyartShowdetail_Portrait_NIR_7201() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();

			//Select a show
			pgnbcappobj.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(20000);
			List<WebElement> ShowImages =  Utilities.returnElements(driver, lstObject.get(179), lstObject.get(178));
			//List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));
			if(ShowImages.get(0).getLocation().getX()!=0) 
			{
				Extent_Reports.executionLog("PASS", "Keyart in show detail page should be displayed" + "\n"
						+ "Keyart in show detail page is displayed ", driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Keyart in show detail page should be displayed" + "\n"
						+ "Keyart in show detail page is not displayed ", driver);

			}
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verify_keyartShowdetail_Portrait_NIR_7201"  + "\n"+ e.getMessage(), driver);

		}

	}


	public void iOS_Verify_Tapsonshowthumbnail_NIR7199() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();

			//Select a show
			pgnbcappobj.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));
		}
		catch(Exception e)
		{
			Extent_Reports.executionLog("INFO", "iOS_Verify_Tapsonshowthumbnail_NIR7199"  + "\n"+ e.getMessage(), driver);

		}

	}

	public void iOS_Verify_MVPD_test() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();

			((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
			Thread.sleep(2000);
			//Select a show
			//pgnbcappobj.iOS_OpenShow(lstTestData.get(0));

			//Thread.sleep(20000);
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verify_MVPD_test"  + "\n"+ e.getMessage(), driver);

		}
	}//EOM



	public void iOS_VerifytotalshowscountCurrenttab_NIR7523() throws Exception 
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();


			//Go to shows

			WebElement Shwosicon =  Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
			if(Shwosicon.isDisplayed()) 
			{
				Shwosicon.click();
				Thread.sleep(30000);
				Extent_Reports.executionLog("PASS", "Shows button should be clicked " + "\n"
						+ "Clicked on Shows Button", driver);
			}
			else 
			{
				Extent_Reports.executionLog("FAIL", "Shows button should be clicked " + "\n"
						+ "Not Clicked on Shows Button", driver);
			}

			//XCUIElementTypeCollectionView[@name='ShowListingThumbnailCollectionView']//XCUIElementTypeStaticText
			Set<String> showNamesSet= new HashSet<String>();
			try 
			{

				List<WebElement> currentShowList= Utilities.returnElements(driver, lstObject.get(185), lstObject.get(184));
				//count=currentShowList.size();
				for(int i=0;i<20;i++)
				{

					currentShowList= Utilities.returnElements(driver, lstObject.get(185), lstObject.get(184));
					if(currentShowList.size()>0) 
					{
						List<WebElement> ShowsFrameList= Utilities.returnElements(driver, lstObject.get(188), lstObject.get(187));
						JavascriptExecutor jse=  (JavascriptExecutor) driver;
						HashMap scobj= new HashMap(); 
						scobj.put("direction","down");
						scobj.put("element",ShowsFrameList.get(3));
						jse.executeScript("mobile:scroll",scobj);

						try 
						{
							if (currentShowList.get(currentShowList.size()-1).isDisplayed())
							{
								Extent_Reports.executionLog("PASS", "The element should be displayed " + "\n"
										+ "The element is displayed", driver);
								//Thread.sleep(10000);

							}
						}
						catch(Exception e) {

						}

						try 
						{
							showNamesSet.add(currentShowList.get(i).getAttribute("label"));

							Extent_Reports.executionLog("INFO", "The show name displayed as "  + "\n"+ currentShowList.get(i).getAttribute("label"), driver);

						}
						catch(Exception e) {

						}



					}
				}
			}
			catch(Exception e)
			{
				Extent_Reports.executionLog("INFO", "iOS_VerifytotalshowscountCurrenttab_NIR7523"  + "\n"+ e.getMessage(), driver);
			}

			Extent_Reports.executionLog("PASS", "The current shows should be displayed " + "\n"
					+ "The current shows count is "+showNamesSet.size(), driver);
			//Thread.sleep(20000);
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_VerifytotalshowscountCurrenttab_NIR7523"  + "\n"+ e.getMessage(), driver);

		}
	}

	@Test
	public void iOS_Verifytogglereflectwhenplaypausepressed_Portrait_NIR7484() throws  Exception
	{
		try
		{

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			pgncapp.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(10000);


			//WebElement Scrollobj =  Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
			//WebElement EpisodeVideo =  Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
			//pgncapp.iOS_scroll(Scrollobj, EpisodeVideo, "down");

			//Synchronization.ExplicitWait(driver, lstObject.get(37), "visible");
			//EpisodeVideo =  Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
			//EpisodeVideo.click();

			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

			List<WebElement> EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
			boolean flag= false;
			for(int i=0;i<20;i++)
			{
				EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","right");
				scobj.put("element",EpisodedList.get(1));
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);
				try 
				{

					List<WebElement> showImages =  Utilities.returnElements(driver, lstObject.get(170), lstObject.get(169));
					for(int j=0;j<showImages.size();j++)
					{
						try 
						{
							if(showImages.get(j).getAttribute("name").length()>0) 
							{

							}
							else
							{
								flag=true;
								showImages.get(j).click();

								break;
							}
						}
						catch(Exception e)
						{
							flag=true;
							showImages.get(j).click();
							break;
						}


					}



				}
				catch(Exception e){
					break;
				}

				if(flag==true) 
				{
					break;
				}

			}









			Thread.sleep(50000);

			Extent_Reports.executionLog("PASS", "Episode video should be played " + "\n"
					+ "Episode video is  played ", driver);
			WebElement vodPlayareatext =  Utilities.returnElement(driver, lstObject.get(68), lstObject.get(67));
			Thread.sleep(30000);
			vodPlayareatext.click();
			Extent_Reports.executionLog("PASS", "Play/pause toggle should be displayed  " + "\n"
					+ "Play/pause toggle is displayed  ", driver);
			Extent_Reports.executionLog("PASS", "Pause icon should display when the video is in play mode  " + "\n"
					+ "Pause icon is displayed when the video is in play mode  ", driver);
			vodPlayareatext.click();
			//close button
			WebElement PlayPause =  Utilities.returnElement(driver, lstObject.get(71), lstObject.get(70));
			PlayPause.click();
			Extent_Reports.executionLog("PASS", "Play icon should display when the video is in pause mode  " + "\n"
					+ "Play icon is displayed when the video is in pause mode  ", driver);
			Thread.sleep(10000);

			vodPlayareatext.click();
			PlayPause.click();
			Extent_Reports.executionLog("PASS", "Episode video should be resumed " + "\n"
					+ "Episode video is  resumed ", driver);


		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verifytogglereflectwhenplaypausepressed_Portrait_NIR7484"  + "\n"+ e.getMessage(), driver);

		}
	}





	@Test
	public void iOS_Verifyepisodesorclipsarentavailable_selectedseason_Portrait_NIR7652() throws  Exception
	{
		try
		{

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			pgncapp.iOS_OpenShow(lstTestData.get(4),lstTestData.get(6));

			Thread.sleep(10000);



			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);
			List<WebElement> SesobNumberList =  Utilities.returnElements(driver, lstObject.get(191), lstObject.get(190));
			if(SesobNumberList.size()>0)
			{

				for(int i=0;i<SesobNumberList.size();i++) 
				{
					try 
					{
						SesobNumberList.get(i).click();
						WebElement NoEpisodesClipsmsg =  Utilities.returnElement(driver, lstObject.get(194), lstObject.get(193));
						if(NoEpisodesClipsmsg.isDisplayed()) 
						{
							Extent_Reports.executionLog("PASS", "Episodes are currently unavailable. In the meantime, favorite this show to stay up to date message should be displayed " + "\n"
									+ "Episodes are currently unavailable. In the meantime, favorite this show to stay up to date message is displayed " , driver);

							break;
						}

					}
					catch(Exception e) {

					}
				}


			}

		}

		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verifyepisodesorclipsarentavailable_selectedseason_Portrait_NIR7652"  + "\n"+ e.getMessage(), driver);

		}
	}


	public void iOS_VerifySmarttileAirOrder1_NIR7991() throws  Exception
	{
		try
		{


			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();


			pgncapp.iOS_OpenShow(lstTestData.get(5),lstTestData.get(7));

			Thread.sleep(5000);

			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

			List<WebElement> FirstSectionText =  Utilities.returnElements(driver, lstObject.get(203), lstObject.get(202));
			List<WebElement> EpisodeSectionText =  Utilities.returnElements(driver, lstObject.get(206), lstObject.get(205));
			if(FirstSectionText.get(1).getText().trim().equalsIgnoreCase(EpisodeSectionText.get(0).getText().trim())) {
				Extent_Reports.executionLog("PASS", "Smart tile section should display the episode with the lowest season number available " + "\n"
						+ "Smart tile section is displayed the episode with the lowest season number available  and smart tile episode name is " + FirstSectionText.get(1).getText() , driver);
			}
			else {

				Extent_Reports.executionLog("FAIL", "Smart tile section should display the episode with the lowest season number available " + "\n"
						+ "Smart tile section is not displayed the episode with the lowest season number available " , driver);
			}
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_VerifySmarttileAirOrder1_NIR7991"  + "\n"+ e.getMessage(), driver);

		}
	}//EOM



	public void iOS_VerifySmarttileAirOrder1not_NIR7990() throws  Exception
	{

		try
		{


			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();


			pgncapp.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(5000);

			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

			List<WebElement> FirstSectionText =  Utilities.returnElements(driver, lstObject.get(203), lstObject.get(202));
			List<WebElement> EpisodeSectionText =  Utilities.returnElements(driver, lstObject.get(206), lstObject.get(205));
			if(FirstSectionText.get(1).getText().trim().equalsIgnoreCase(EpisodeSectionText.get(0).getText().trim())) {
				Extent_Reports.executionLog("FAIL", "Smart tile section should be displayed with the most recent episode available." + "\n"
						+ "Smart tile section is not displayed with the most recent episode available. and smart tile episode name is " + FirstSectionText.get(1).getText() , driver);
			}
			else {

				Extent_Reports.executionLog("PASS", "Smart tile section should be displayed with the most recent episode available." + "\n"
						+ "Smart tile section is displayed with the most recent episode available. and smart tile episode name is " + FirstSectionText.get(1).getText() , driver);
			}
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_VerifySmarttileAirOrder1not_NIR7990"  + "\n"+ e.getMessage(), driver);

		}
	}//EOM


	public void iOS_Verifytimetakentoviewshow_NIR7664() throws  Exception
	{
		try
		{


			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			WebElement Shwosicon =  Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
			if(Shwosicon.isDisplayed()) {
				Shwosicon.click();
				Thread.sleep(30000);
				Extent_Reports.executionLog("PASS", "Shows button should be clicked " + "\n"
						+ "Clicked on Shows Button", driver);
			}
			else {
				Extent_Reports.executionLog("FAIL", "Shows button should be clicked " + "\n"
						+ "Not Clicked on Shows Button", driver);
			}

			//Access Show

			Synchronization.ExplicitWait(driver, lstObject.get(73), "visible");
			WebElement AccessShow =  Utilities.returnElement(driver, lstObject.get(74), lstObject.get(73));
			if(AccessShow.isDisplayed())
			{
				long start = System.currentTimeMillis();
				AccessShow.click();
				Thread.sleep(1000);

				long end = System.currentTimeMillis();	
				if(	((end - start) / 1000)<3)
				{		


					Extent_Reports.executionLog("PASS", "App should take less than 2 seconds on a normal broadband connection to display the portion that's visible on the Shows page " + "\n"
							+ "App is take less than 2 seconds on a normal broadband connection to display the portion that's visible on the Shows page " +(end - start) / 1000, driver);

				}
				else {

					Extent_Reports.executionLog("FAIL", "App should take less than 2 seconds on a normal broadband connection to display the portion that's visible on the Shows page " + "\n"
							+ "App is not take less than 2 seconds on a normal broadband connection to display the portion that's visible on the Shows page", driver);

				}

				Extent_Reports.executionLog("PASS", "AP Bio show should be clicked " + "\n"
						+ "Clicked on AP Bio Show", driver);

			}
			else {
				Extent_Reports.executionLog("FAIL", "AP Bio show should be clicked " + "\n"
						+ "Not Clicked on AP Bio Show", driver);
			}

		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_VerifySmarttileAirOrder1not_NIR7990"  + "\n"+ e.getMessage(), driver);

		}
	}//EOM
	
	
	public void iOS_VerifythereversechronologicalorderoTCons_NIR7250() throws  Exception
	{

		try
		{


			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();


			pgncapp.iOS_OpenShow(lstTestData.get(0),lstTestData.get(6));

			Thread.sleep(5000);

			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

			List<WebElement> FirstSectionText =  Utilities.returnElements(driver, lstObject.get(203), lstObject.get(202));
			List<WebElement> EpisodeSectionText =  Utilities.returnElements(driver, lstObject.get(206), lstObject.get(205));
			
			
			List<WebElement> SesobNumberList =  Utilities.returnElements(driver, lstObject.get(191), lstObject.get(190));
			
			if(SesobNumberList.size()>0)
			{
				int[] arr = new int[SesobNumberList.size()];
				for(int i=0;i<SesobNumberList.size();i++) 
				{
					try 
					{
						arr[i]=Integer.parseInt(SesobNumberList.get(i).getText().trim());
					
						if(i>=1) 
						{
							if(arr[i-1]>arr[i]) 
							{
								Extent_Reports.executionLog("PASS", "The seTCons should be in reverse chronological order, i.e latest seTCon at the top " + "\n"
										+ "The seTCons is in reverse chronological order, i.e latest seTCon at the top ", driver);
							}
							else {
								Extent_Reports.executionLog("FAIL", "The seTCons should be in reverse chronological order, i.e latest seTCon at the top " + "\n"
										+ "The seTCons is not in reverse chronological order, i.e latest seTCon at the top ", driver);
							}
						}

					}
					catch(Exception e) {

						System.out.println(e);
					}
				}

			

			}
			
			

		
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_VerifySmarttileAirOrder1not_NIR7990"  + "\n"+ e.getMessage(), driver);

		}
	}//EOM
	
	
	public void iOS_Verifythedisplayvideotitle_NIR7312() throws  Exception
	{

		try
		{


			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();


			pgncapp.iOS_OpenShow(lstTestData.get(9),lstTestData.get(6));

			Thread.sleep(5000);

			WebElement sourceScrollobj =  Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
			List<WebElement> TargetsourceScrollobj =  Utilities.returnElements(driver, lstObject.get(158), lstObject.get(157));


			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");
			pgncapp.iOS_scroll(sourceScrollobj, TargetsourceScrollobj.get(3),"down");;
			Extent_Reports.executionLog("PASS", "Show Episodes section should be displayed " + "\n"
					+ "Show Episodes section is displayed ", driver);

		
			List<WebElement> EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
			for(int i=0;i<10;i++)
			{
				EpisodedList =  Utilities.returnElements(driver, lstObject.get(155), lstObject.get(154));
				 if(EpisodedList.get(i).getAttribute("label").trim().equalsIgnoreCase(lstTestData.get(10).trim())) 
					{
	                	
	                	Extent_Reports.executionLog("PASS", "Episode should be clicked." + "\n"
								+ "Episode is clicked and episode name is " + EpisodedList.get(i).getAttribute("label").trim() , driver);
						EpisodedList.get(i).click();
						
						Thread.sleep(20000);
						break;
					}
				 
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction","right");
				scobj.put("element",EpisodedList.get(1));
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);
               
				
				
			}
			
			
			Extent_Reports.executionLog("PASS", "Episode video should be played " + "\n"
					+ "Episode video is  played ", driver);
			
			pgncapp.iOS_VODPlayValidation("videotitle");
			//pgncapp.iOS_VODPlayValidation("fullscreen");
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_VerifySmarttileAirOrder1not_NIR7990"  + "\n"+ e.getMessage(), driver);

		}
	}//EOM

}//EOC
