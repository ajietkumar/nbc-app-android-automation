package com.nbcd.Pages;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
public class PGGotoShowPage  {
	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> objShowLists, objShowList;
	String sqlQry, Status,ShowNameActual;
	PGNbcApp NApp=new PGNbcApp(driver);
	PGAndroidApp Aapp=new PGAndroidApp(driver);
	WebElement FavoritesSection,Favpopup,objnav, objRespNavBar,objloading, objClipDropDownWebEx, objShowLink,MenuIcon, CastIcon, CastPopUp, vodtap, ShowName, ShowsMenu, EpisodeVideo,ad, HambergerIcon, playPause, GoToShow;
	// Constructor to initialize all the Page Objects
	public PGGotoShowPage(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGGotoShowPage", "Input");
		lstObject = db.getTestDataObject("Select * from PGGotoShowPage", "ObjectRepository");
	}
	// =========================================================================================================================

	@Test
	public void android_VerifyGoToShowBtn() throws Exception {


		NApp.android_WaitForAppToLoad();

		NApp.android_DismissCastOverlay();

		//NApp.android_GotoAnyShowHomePage();


		Thread.sleep(10000);

		NApp.android_ClickEpisode("A.P.Bio", "Pilot: Catfish");

		/*//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(22))));
			EpisodeVideo = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
			EpisodeVideo.click();
			Extent_Reports.executionLog("PASS", "Episode  should be clicked " + "\n" + "Episode is clicked",
					driver);
			Thread.sleep(30000);*/
		TouchAction action = new TouchAction((AndroidDriver) driver);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
		vodtap = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
		vodtap.click();
		playPause = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
		playPause.click();
		Thread.sleep(10000);
		try {
			ad = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
			Thread.sleep(10000);
			if (ad.isDisplayed()) {
				playPause.click();
				Thread.sleep(80000);
			} else {
				Extent_Reports.executionLog("PASS",
						"No Ad is displayed  " + "\n" + "No Ad is displayed ",
						driver);
			}
		} catch (Exception e) {
			System.out.println("exception occured at progress bar");
			Thread.sleep(10000);
		}
		vodtap.click();
		GoToShow = Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
		if (GoToShow.isDisplayed()) {
			Extent_Reports.executionLog("PASS",
					"GoToShow Button should be displayed on VOD " + "\n" + "GoToShow Button is displayed on VOD",
					driver);
			Thread.sleep(10000);
		} else {
			Extent_Reports.executionLog("FAIL",
					"Show Home page should be displayed " + "\n" + "Show Home page is not displayed", driver);
			Thread.sleep(2000);
		}
		// Validating Go to Show Page button on VOD Player
		GoToShow.click();
		try {
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(19))));
			WebElement ShowName = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
			Thread.sleep(10000);
			if (ShowName.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						"GoToShow Button should be clicked " + "\n"
								+ "GoToShow Button is clicked and App is navigated to Show Home Page",
								driver);
				Thread.sleep(10000);
			} else {
				Extent_Reports.executionLog("FAIL",
						"Show Home page should be displayed " + "\n" + "Show Home page is not displayed",
						driver);
				Thread.sleep(2000);
			}
		} catch (Exception e) {
			System.out.println("exception occured at progress bar");
			Thread.sleep(10000);
		}
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(3000);



	}// EOM

	@Test
	public void android_VerifyFavoritesSectionHomePage() throws Exception
	{
		try{
			PGAndroidApp App2 = new PGAndroidApp(driver);
			PGNbcApp App1 = new PGNbcApp(driver);
			App1.android_WaitForAppToLoad();
			App1.android_DismissCastOverlay();
		

			//WebDriverWait wait = new WebDriverWait(driver, 50);

			App1.android_OpenShow("A.P. Bio"); 
			
			ShowNameActual=App2.android_getShowNamefromShowHomePage();
			
			App2.android_AddToFavorites();
			Thread.sleep(3000);

			Favpopup = Utilities.returnElement(driver, lstObject.get(56), lstObject.get(55));
			if(Favpopup.isDisplayed()) {
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			}
			App2.android_OpenMenus("HOME");



			FavoritesSection = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
			if (FavoritesSection.isDisplayed()) 
				{
					Extent_Reports.executionLog("PASS",
							"Favorites Section should be displayed " + "\n" + "FavoritesSection is  displayed", driver);
					//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(43))));
					
				}
			
			
			
				
			else {
					Extent_Reports.executionLog("PASS",
							"No shows are marked as Favorite " + "\n" + "No shows are marked as Favorite ", driver);

				}
				
				
				Synchronization.ExplicitWait(driver, lstObject.get(43), "visible");
				List<WebElement> FavShows=Utilities.returnElements(driver, lstObject.get(44), lstObject.get(43));
				//System.out.println(FavShows.size());
				if(FavShows.size()>0) 
				{
					
					
					for(int i=0;i<FavShows.size();i++)
					{
						if(ShowNameActual.equals(FavShows.get(i).getText())){
							Extent_Reports.executionLog("PASS",
									"User Favorited show should be displayed :  " + "\n" + "User Favorited show should is displayed :  "+FavShows.get(i).getText(), driver);	
						break;
						}
						else
						{
							Extent_Reports.executionLog("FAIL ",
									"User Favorited show should be displayed :  " + "\n" + "User Favorited show should is not displayed :  "+FavShows.get(i).getText(), driver);	
						
						}
						
					}
					
					
						
						
						
						
					
					}

				
				Thread.sleep(10000);
			
				
				
			}
			


		catch (Exception e)
		{
			Extent_Reports.executionLog("INFO",
					"android_VerifyFavoritesSectionHomePage_NAF3544 " + "\n" + e.getMessage(), driver);
		}	


	}
	public void android_VerifyClipsortorderShowhomepage_NAF3357() throws Exception {
        PGNbcApp App1 = new PGNbcApp(driver);
        String val="";
        String lastShow="";
        try 
        {
            //Date date3 = new SimpleDateFormat("MM/dd/yyyy").parse("06/12/18");
            //System.out.println(date3);
            PGNbcApp App = new PGNbcApp(driver);
            WebDriverWait wait = new WebDriverWait(driver, 50);
            App1.android_WaitForAppToLoad();
            App1.android_DismissCastOverlay();

            App.android_OpenShow(lstTestData.get(4));

            int pressX = driver.manage().window().getSize().width / 2;
            int bottomY = driver.manage().window().getSize().height * 2/5;
            int topY = driver.manage().window().getSize().height / 8;
            TouchAction touchAction = new TouchAction(driver);
            touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
            ArrayList<String> Arraylist = new ArrayList<String>();
            List<WebElement> ClipsPostedDateList  = Utilities.returnElements(driver, lstObject.get(59), lstObject.get(58)); 
            String DateText = ClipsPostedDateList.get(0).getAttribute("text");
            System.out.println(DateText);
            Arraylist.add(DateText);

            for (int i=0;i<=5;i++)
            {

                TouchAction act2=new TouchAction(driver);
                Dimension size2 = driver.manage().window().getSize();
                int anchor = (int) (size2.height * 0.75);
                int startPoint = (int) (size2.width * 0.5);
                int endPoint = (int) (size2.width * 0.01);
                act2.longPress(startPoint, anchor).moveTo(endPoint, anchor).release().perform();

                ClipsPostedDateList  = Utilities.returnElements(driver, lstObject.get(59), lstObject.get(58)); 
                DateText = ClipsPostedDateList.get(0).getAttribute("text");
                System.out.println(DateText);
                Arraylist.add(DateText);


                if(i<Arraylist.size())
                {

                    Date date1 = new SimpleDateFormat("MM/dd/yyyy").parse(Arraylist.get(i).toString());
                    Date date2 = new SimpleDateFormat("MM/dd/yyyy").parse(Arraylist.get(i+1).toString());

                    if (date1.compareTo(date2) >= 0) 
                    {
                        Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "Clips should be sorted by the published date " + "\n" + Extent_Reports.logActual + "Clips are sorted by the published date " , driver);
                        Extent_Reports.executionLog("PASS", Extent_Reports.logExpected+ "The current clip data "+ date1 +"  should be greated or equal date with the next clip date "+ date2 + "\n" + Extent_Reports.logActual + "The current clip data "+ date1 +"  is  greated or equal date with the next clip date "+ date2  , driver);

                    }
                }

            }


        }
        catch(Exception e) {

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
            //    scroll(pressX, bottomY, pressX, topY);


        }



    }//EOM

	/* public void android_Verifytheupdatedmetadata_NAF3544() throws  Exception
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 50);
			PGNbcApp NApp=new PGNbcApp(driver);

			NApp.android_WaitForAppToLoad();

			//NApp.android_DismissCastOverlay();

			//Thread.sleep(10000);
			//Validate Favorites Section
			try {

				WebElement	FavoritesSection = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
				if (FavoritesSection.isDisplayed()) 
				{
					Extent_Reports.executionLog("PASS",
							"Favorites Section should be displayed " + "\n" + "FavoritesSection is  displayed", driver);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(43))));

					List<WebElement> FavShows=Utilities.returnElements(driver, lstObject.get(44), lstObject.get(43));
					if(FavShows.size()>0) 
					{
						for(Object obj:FavShows) 
						{
							Extent_Reports.executionLog("PASS",
									"Favorite show should be displayed " + "\n" + "The displayed favorite show is "+obj, driver);	
						}

					}
					Thread.sleep(10000);
				} else {
					Extent_Reports.executionLog("PASS",
							"No shows are marked as Favorite " + "\n" + "No shows are marked as Favorite ", driver);

				}
			}
			catch(Exception e)
			{
				Extent_Reports.executionLog("INFO", "Validation of Favorites Section In HomePage"  + "\n"+ e.getMessage(), driver);
			}

			NApp.android_GotoAnyShowHomePage();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(49))));
			WebElement showName = Utilities.returnElement(driver, lstObject.get(50), lstObject.get(49));
			String ShowName=showName.getText().trim();
			System.out.println(ShowName);

			Aapp.android_AddToFavorites();
			WebElement Favpopup = Utilities.returnElement(driver, lstObject.get(56), lstObject.get(55));
			if(Favpopup.isDisplayed()) {
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			}


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(46))));
			WebElement heartIcon = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
			if (heartIcon.isDisplayed()) 
			{
				heartIcon.click();
				Thread.sleep(10000);
				Extent_Reports.executionLog("PASS", "American Ninja Warrior should be marked as favorite " + "\n"
						+ "American Ninja Warrior Show is marked as favorite", driver);
				try {
				WebElement Favpopup = Utilities.returnElement(driver, lstObject.get(56), lstObject.get(55));
				if(Favpopup.isDisplayed()) {
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				}
				}
				catch(Exception e) {
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				}

			}
			else
			{
				Extent_Reports.executionLog("FAIL", "American Ninja Warrior should be marked as favorite " + "\n"
						+ "American Ninja Warrior Show is not marked as favorite", driver);
			}


			NApp.android_GotHomePage();

			Thread.sleep(10000);
			//Validate Favorites Section
			try {

				WebElement	FavoritesSection = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
				if (FavoritesSection.isDisplayed()) 
				{
					Extent_Reports.executionLog("PASS",
							"Favorites Section should be displayed " + "\n" + "FavoritesSection is  displayed", driver);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(43))));

					List<WebElement> FavShows=Utilities.returnElements(driver, lstObject.get(44), lstObject.get(43));
					if(FavShows.size()>0) 
					{
						for(int i=0;i<FavShows.size();i++) 
						{
							if(FavShows.get(i).getText().trim().equalsIgnoreCase(ShowName))
							{
							  Extent_Reports.executionLog("PASS",
									  ShowName+ " should be displayed under favorite section " + "\n" + ShowName+" is displayed under favorite section ", driver);	
							}
						}

					}
					Thread.sleep(10000);
				} else {
					Extent_Reports.executionLog("FAIL",
							"No shows are marked as Favorite " + "\n" + "No shows are marked as Favorite ", driver);

				}
			}
			catch(Exception e)
			{

			}


			// }
			Thread.sleep(10000);


		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "android_Verifytheupdatedmetadata_NAF3544"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM	
	 */


}// EOC
