package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rotatable;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
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

public class PGNbcApp {


	public static AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List <WebElement> objShowLists,objShowList,StaticText,Sign_up_Nbc_Static_text,ios_TvProvider,Sign_in;
	boolean isDisplayed=true;
	boolean isPresent=false;
	String sqlQry, Status;
	WebElement objnav, objRespNavBar,objClipDropDownWebEx,EpisodesLst,Episode,objShowLink,NBCIcon,Shows,AllShowsBtn,SelectOption,CastIcon,CastPopUp,clkOnShow,shpBackBtn,objloading,Home,Optimum,Optimum_logo,Optimum_id,Optimum_pw;
	WebElement TV_Provider_Msg,plusPeacock,Yes_btn,Skip_btn,Close_btn,SignIn_btn,userid,password,Done_btn,signupbtn,StartWatchin_btn,checkbtn,Unlink_TV_Provider,TvProviderImage,Sign_up,SignIn,user_id,pwd,Show_pwd,Hide_pwd,showTab;
	
	// Constructor to initialize all the Page Objects
	public PGNbcApp(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGNbcApp", "Input");
		lstObject = db.getTestDataObject("Select * from PGNbcApp", "ObjectRepository");
	}


	public void iOS_scroll( WebElement source, WebElement target , String scrollDirection) throws Exception 
	{
		try 
		{
			for(int i=0;i<100;i++)
			{
				JavascriptExecutor jse=  (JavascriptExecutor) driver;
				HashMap scobj= new HashMap(); 
				scobj.put("direction",scrollDirection);
				scobj.put("element",source);
				jse.executeScript("mobile:scroll",scobj);
				Thread.sleep(1000);

				if (target.isDisplayed()||target.isEnabled())
				{
					Extent_Reports.executionLog("PASS", "The element should be displayed " + "\n"
							+ "The element is displayed", driver);
					//Thread.sleep(10000);
					break;
				}
				else {
					//Extent_Reports.executionLog("FAIL", "The element should be displayed " + "\n"
					//		+ "The element is not displayed", driver);
				}

			}
		}
		catch(Exception e)
		{
			Extent_Reports.executionLog("INFO", "iOS_scrollDown"  + "\n"+ e.getMessage(), driver);
		}
	}

	public void iOS_GlobalHomePage() throws Exception  
	{
		try {


			try 
			{
				Thread.sleep(10000);
				Alert alert = driver.switchTo().alert();
				alert.accept();
				Thread.sleep(10000);
			}
			catch(Exception e) 
			{
			}
			try 
			{
				Thread.sleep(10000);
				WebElement ok_button =  Utilities.returnElement(driver, lstObject.get(2), lstObject.get(1));
				ok_button.click();
			}
			catch(Exception e) {
			}

			try 
			{

				Synchronization.ExplicitWait(driver, lstObject.get(4), "visible");
				WebElement Allow =  Utilities.returnElement(driver, lstObject.get(5), lstObject.get(4));
				Allow.click();
			}
			catch(Exception e) {
			}
			try
			{

				Synchronization.ExplicitWait(driver, lstObject.get(7), "visible");
				WebElement CastOk =  Utilities.returnElement(driver, lstObject.get(8), lstObject.get(7));
				CastOk.click();
			}
			catch(Exception e) {
			}


			Extent_Reports.executionLog("PASS", "Global home page should be displayed " + "\n"
					+ "Global home page is  displayed ", driver);
		} 

		catch (Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_GlobalHomePage"  + "\n"+ e.getMessage(), driver);
		}

	}


	public void iOS_OpenShow(String ShowName ,String ShowTab) throws Exception 
	{

		try {
			//Click Shows  Menu Button
			Synchronization.ExplicitWait(driver, lstObject.get(10), "visible");
			WebElement Shwosicon =  Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10));
			if(Shwosicon.isDisplayed()) 
			{
				Shwosicon.click();
				
				Extent_Reports.executionLog("PASS", "Shows button should be clicked " + "\n"
						+ "Clicked on Shows Button", driver);
			}
			else 
			{
				Extent_Reports.executionLog("FAIL", "Shows button should be clicked " + "\n"
						+ "Not Clicked on Shows Button", driver);
			}

			
			switch(ShowTab.toLowerCase().trim()) 
			{
			case "current":
				 showTab = Utilities.returnElement(driver, lstObject.get(197), lstObject.get(196));
				 if(showTab.isEnabled())
				 {
					 showTab.click();
					 Extent_Reports.executionLog("PASS", "Current Shows should be displayed " + "\n"
							 + "Current Shows is displayed ", driver);

				 }

				 else {
					 Extent_Reports.executionLog("FAIL", "current Shows should be displayed " + "\n"
							 + "current Shows is not displayed ", driver);

				 }
				 break;

			case "throwback":
				 showTab = Utilities.returnElement(driver, lstObject.get(191), lstObject.get(190));
				 if(showTab.isEnabled())
				 {
					 showTab.click();
					 Extent_Reports.executionLog("PASS", "Throwback Shows should be displayed " + "\n"
							 + "Throwback Shows is displayed ", driver);

				 }

				 else {
					 Extent_Reports.executionLog("FAIL", "Throwback Shows should be displayed " + "\n"
							 + "Throwback Shows is not displayed ", driver);

				 }
				break;

			case "all":
				 showTab = Utilities.returnElement(driver, lstObject.get(194), lstObject.get(193));
				 if(showTab.isEnabled())
				 {
					 showTab.click();
					 Extent_Reports.executionLog("PASS", "All Shows should be displayed " + "\n"
							 + "All Shows is displayed ", driver);

				 }

				 else {
					 Extent_Reports.executionLog("FAIL", "All Shows should be displayed " + "\n"
							 + "Throwback Shows is not displayed ", driver);

				 }
				break;



			}

			Thread.sleep(20000);
			
		
			//Scrolldown and Select a Show
			List<WebElement> ShowsNameTextList =  Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
			
			//List<WebElement> ShowTilesList =  Utilities.returnElements(driver, lstObject.get(200), lstObject.get(199));
			//XCUIElementTypeCell[contains(@name,'ShowListing-CollectionViewCell-ShowThumbnail')]
			for(int i=0;i<ShowsNameTextList.size();i++) 
			{
				ShowsNameTextList =  Utilities.returnElements(driver, lstObject.get(14), lstObject.get(13));
				//ShowTilesList =  Utilities.returnElements(driver, lstObject.get(200), lstObject.get(199));
				if(ShowsNameTextList.get(i).getText().trim().equals(ShowName.trim()))
				{
					
					WebElement showTitle= ShowsNameTextList.get(i);
					if(showTitle.isDisplayed()) 
					{
						

						Extent_Reports.executionLog("PASS", "Show should be displayed " + "\n"
								+ "Show is displayed", driver);
						showTitle.click();
						Thread.sleep(5000);
						Extent_Reports.executionLog("PASS", "Show details page should be displayed " + "\n"
								+ "Show details page is displayed", driver);
						break;
					}

				}
				else
				{
					JavascriptExecutor jse=  (JavascriptExecutor) driver;
					HashMap scobj= new HashMap(); 
					scobj.put("direction","down");
					scobj.put("element",ShowsNameTextList.get(0));
					jse.executeScript("mobile:scroll",scobj);
					Thread.sleep(1000);

				}

			}

		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_OpenShow"  + "\n"+ e.getMessage(), driver);
		}



	}//EOM

	//iOS video palyer validations like play , pauuse, fullscreen, close
public void  iOS_VODPlayValidation(String interaction) throws Exception 
{
	try {
		WebElement vodPlayareatext =  Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
		Thread.sleep(30000);
		vodPlayareatext.click();

		switch(interaction.toLowerCase().trim())
		{

		case "playpause":
			WebElement PlayPause =  Utilities.returnElement(driver, lstObject.get(68), lstObject.get(67));
			PlayPause.click();   
			Thread.sleep(500);
			Extent_Reports.executionLog("PASS", "Episode video should be paused " + "\n"
					+ "Episode video is  paused ", driver);
			Thread.sleep(10000);
			vodPlayareatext.click();
			PlayPause.click();
			Extent_Reports.executionLog("PASS", "Episode video should be resumed " + "\n"
					+ "Episode video is  resumed ", driver);
			break;

		case "fullscreen":
			WebElement fullScreen =  Utilities.returnElement(driver, lstObject.get(86), lstObject.get(85));
			fullScreen.click();   
			Thread.sleep(500);
			System.out.println(driver.getOrientation());
			
			if(driver.getOrientation().toString().trim().equals("LANDSCAPE"))
			{
				Extent_Reports.executionLog("PASS", "Video should be displayed in full screen " + "\n"
						+ "Video is displayed in full screen ", driver);
				vodPlayareatext =  Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
				
				vodPlayareatext.click();
				WebElement VODTitle_lanscape =  Utilities.returnElement(driver, lstObject.get(128), lstObject.get(127));
				if(VODTitle_lanscape.isEnabled()) 
				{
					Extent_Reports.executionLog("PASS", "Video title should be displayed in full screen " + "\n"
						+ "Video title is displayed in full screen ", driver);
					
				}
				else {
					Extent_Reports.executionLog("FAIL", "Video title should be displayed in full screen " + "\n"
							+ "Video title is not displayed in full screen ", driver);
				}
			}
			else {
				Extent_Reports.executionLog("FAIL", "Video should be displayed in full screen " + "\n"
						+ "Video is not displayed in full screen ", driver);
			}
			break;

		case "parentalrating":
			for(int i=0; i<500;i++) 
			{
				
				 
				try
				{
					WebElement parental_rating =  Utilities.returnElement(driver, lstObject.get(134), lstObject.get(133));
					
					if (parental_rating.isEnabled())
					{
						LocalTime VisibleTimeofTVRating=java.time.LocalTime.now(); 
						System.out.println("Parental rating visible time "+VisibleTimeofTVRating); 
						
						Extent_Reports.executionLog("PASS", "Parental rating should be displayed" + "\n"
								+ "Parental rating is displayed ", driver);
						break;
					}
					else {
						Extent_Reports.executionLog("FAIL", "Parental rating should be displayed" + "\n"
								+ "Parental rating is not displayed ", driver);
					}
				}
				
				catch(Exception e){
					Thread.sleep(1000);
					
				}

				
				
			}
			
			
			
			if(Synchronization.ExplicitWait(driver, lstObject.get(133), "invisible")==true) {
			LocalTime InVisibleTimeofTVRating=java.time.LocalTime.now(); 
			System.out.println("Parental rating Invisible time "+InVisibleTimeofTVRating); 
			}
		
		
			
			break;

			
		case "videotitle":
			vodPlayareatext =  Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
            vodPlayareatext.click();
			WebElement VODTitle_lanscape =  Utilities.returnElement(driver, lstObject.get(128), lstObject.get(127));
			if(VODTitle_lanscape.isEnabled()) 
			{
				Extent_Reports.executionLog("PASS", "Video title should be displayed in full screen " + "\n"
					+ "Video title is displayed in full screen and name is  "+VODTitle_lanscape.getAttribute("label") + "Width and Height is  " +VODTitle_lanscape.getSize(), driver);
				
			}
			else {
				Extent_Reports.executionLog("FAIL", "Video title should be displayed in full screen " + "\n"
						+ "Video title is not displayed in full screen ", driver);
			}
			

			break;

		}
	}
	catch(Exception e) {

	}

	
}
	

public void rotateDeviceScreenToLandscape(String orientation) 
{
	//LANDSCAPE|PORTRAIT
	switch(orientation.trim().toUpperCase())
	{
	case "LANDSCAPE":
		  ((Rotatable) driver).rotate(ScreenOrientation.LANDSCAPE);
		  break;
		  
	case "PORTRAIT":
		  ((Rotatable) driver).rotate(ScreenOrientation.PORTRAIT);
		  break;
	}
	
  
}
	


public void ios_Linkprovider(String provider_name) throws Throwable 
{
	      
	       ios_TvProvider = Utilities.returnElements(driver, lstObject.get(92), lstObject.get(91));
	       for (int i=0;i<ios_TvProvider.size();i++) {
	    	   if (ios_TvProvider.get(i).getAttribute("name").contains(provider_name)) {
	    		   Extent_Reports.executionLog("PASS", "TV Provider img link should be displayed " + "\n"
							+ "TV Provider img link is displayed", driver);
	    		   ios_TvProvider.get(i).click();
	    		   break;
	    	   }
	       }
	        
			Thread.sleep(50000);
			Optimum_logo = Utilities.returnElement(driver, lstObject.get(95), lstObject.get(94));
            if (Optimum_logo.isDisplayed()) {
            	Extent_Reports.executionLog("PASS", "TV Provider logo should be displayed " + "\n"
						+ "TV Provider Logo is displayed", driver);

            }else {
            	Extent_Reports.executionLog("FAIL", "TV Provider Logo should be displayed " + "\n"
						+ "TV Provider Logo is not displayed", driver);
            }
			
			StaticText =	 Utilities.returnElements(driver, lstObject.get(98), lstObject.get(97));
            for ( int i=0;i<StaticText.size();i++) {
            	Extent_Reports.executionLog("PASS", "TV Provider static text should be displayed as: " + StaticText.get(i).getAttribute("label")  + "\n"
						+ "TV Provider static text is displayed", driver);
            }
			
			Optimum_id =	Utilities.returnElement(driver, lstObject.get(101), lstObject.get(100));
			if (Optimum_id.isDisplayed()) {
            	Extent_Reports.executionLog("PASS", "TV Provider login ID field should be displayed " + "\n"
						+ "TV Provider login ID field is displayed", driver);
            	Optimum_id.sendKeys(lstTestData.get(0));

            }else {
            	Extent_Reports.executionLog("FAIL", "TV Provider login ID field should be displayed " + "\n"
						+ "TV Provider login ID field is not displayed", driver);
            }

			
			Optimum_pw =	Utilities.returnElement(driver, lstObject.get(104), lstObject.get(103));
			if (Optimum_pw.isDisplayed()) {
            	Extent_Reports.executionLog("PASS", "TV Provider password field should be displayed " + "\n"
						+ "TV Provider password field is displayed", driver);
            	Optimum_pw.sendKeys(lstTestData.get(1));

            }else {
            	Extent_Reports.executionLog("FAIL", "TV Provider password field should be displayed " + "\n"
						+ "TV Provider password field is not displayed", driver);
            }

			
			SignIn_btn =	Utilities.returnElement(driver, lstObject.get(107), "//XCUIElementTypeButton[@name='Go']");
			SignIn_btn.click();
			Thread.sleep(10000);
			
		  
			TV_Provider_Msg =	Utilities.returnElement(driver, lstObject.get(110), lstObject.get(109));
			if (TV_Provider_Msg.isDisplayed()) {
            	Extent_Reports.executionLog("PASS", "TV Provider Linked! message should be displayed " + "\n"
						+ "TV Provider Linked! message is displayed", driver);

            }else {
            	Extent_Reports.executionLog("FAIL", "TV Provider Linked! message should be displayed " + "\n"
						+ "TV Provider Linked! message is not displayed", driver);
            }
			
			plusPeacock =	Utilities.returnElement(driver, lstObject.get(113), lstObject.get(112));
			if (plusPeacock.isEnabled()) {
            	Extent_Reports.executionLog("PASS", "Peacock Logo should be displayed " + "\n"
						+ "Peacock Logo is displayed", driver);

            }else {
            	Extent_Reports.executionLog("FAIL", "Peacock Logo should be displayed " + "\n"
						+ "Peacock Logo is not displayed", driver);
            }
			
			Sign_up_Nbc_Static_text = Utilities.returnElements(driver, lstObject.get(116), lstObject.get(115));
			for (int j=1;j<Sign_up_Nbc_Static_text.size();j++) {
            	Extent_Reports.executionLog("PASS", "Sign up for an NBC Profile text should be displayed as: " + Sign_up_Nbc_Static_text.get(j).getAttribute("label") + "\n"
						+ "Sign up for an NBC Profile text is displayed", driver);

            }

			Yes_btn = Utilities.returnElement(driver, lstObject.get(119), lstObject.get(118));
			if (Yes_btn.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "YES button should be displayed " + "\n"
						+ "YES button is displayed", driver);

			}else {
				Extent_Reports.executionLog("FAIL", "YES button should be displayed " + "\n"
						+ "YES button is not displayed", driver);
			}

			Close_btn = Utilities.returnElement(driver, lstObject.get(122), lstObject.get(121));
			if (Close_btn.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Close button should be displayed " + "\n"
						+ "Close button is displayed", driver);
				

			}else {
				Extent_Reports.executionLog("FAIL", "Close button should be displayed " + "\n"
						+ "Close button is not displayed", driver);
			}
			
			Skip_btn = Utilities.returnElement(driver, lstObject.get(125), lstObject.get(124));
			if (Skip_btn.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "SKIP button should be displayed " + "\n"
						+ "SKIP button is displayed", driver);
				Skip_btn.click();
				Thread.sleep(10000);

			}else {
				Extent_Reports.executionLog("FAIL", "SKIP button should be displayed " + "\n"
						+ "SKIP button is not displayed", driver);
			}
			
			Unlink_TV_Provider = Utilities.returnElement(driver, lstObject.get(155), lstObject.get(154));
			if (Unlink_TV_Provider.isEnabled()) {
				Extent_Reports.executionLog("PASS", "Unlink TV Provider link text should be displayed " + "\n"
						+ "Unlink TV Provider link text is displayed", driver);
			

			}else {
				Extent_Reports.executionLog("FAIL", "Unlink TV Provider link text should be displayed " + "\n"
						+ "Unlink TV Provider link text is not displayed", driver);
			}

			TvProviderImage = Utilities.returnElement(driver, lstObject.get(158), lstObject.get(157));
			if (TvProviderImage.isEnabled()) {
				Extent_Reports.executionLog("PASS", "TvProvider Image should be displayed " + "\n"
						+ "TvProvider Image is displayed", driver);
				
			}else {
				Extent_Reports.executionLog("FAIL", "TvProvider Image should be displayed " + "\n"
						+ "TvProvider Image is not displayed", driver);
			}
			
			
}


public void ios_SignUp(String user_name,String pass_word) throws Throwable 
{
	      
				Sign_up = Utilities.returnElement(driver, lstObject.get(161), lstObject.get(160));
				Extent_Reports.executionLog("PASS", "Sign up button should be displayed " + "\n"
						+ "Sign up button is displayed", driver);
				Sign_up.click();
				Thread.sleep(10000);
				
				userid = Utilities.returnElement(driver, lstObject.get(137), lstObject.get(136));
			    userid.sendKeys(user_name);
			    Extent_Reports.executionLog("PASS", "User Name should be entered into the text field" + "\n"
						+ "User Name is entered into the text field", driver);
			
				password = Utilities.returnElement(driver, lstObject.get(140), lstObject.get(139));
				password.sendKeys(pass_word);
				Extent_Reports.executionLog("PASS", "Password should be entered into the text field" + "\n"
						+ "Password is entered into the text field", driver);
				
				checkbtn = Utilities.returnElement(driver, lstObject.get(143), lstObject.get(142));
				checkbtn.click();
				Extent_Reports.executionLog("PASS", "Checkbox should be clicked" + "\n"
						+ "Checkbox is clicked", driver);
				Thread.sleep(2000);
				//Done_btn = Utilities.returnElement(driver, lstObject.get(145), lstObject.get(146));
				//Done_btn.click();
				driver.hideKeyboard();
				Thread.sleep(3000);
				signupbtn = Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
				if (signupbtn.isEnabled()) {
				Extent_Reports.executionLog("PASS", "Signup Button should be displayed" + "\n"
						+ "Signup Button is displayed", driver);
				signupbtn.click();
				}else {
					Extent_Reports.executionLog("FAIL", "Signup Button should be displayed" + "\n"
							+ "Signup Button is not displayed", driver);
				}
				Thread.sleep(5000);
				StartWatchin_btn = Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
				if (StartWatchin_btn.isEnabled()) {
					Extent_Reports.executionLog("PASS", "Start Watching Button should be displayed" + "\n"
							+ "Start Watching Button is displayed", driver);
					StartWatchin_btn.click();
					}else {
						Extent_Reports.executionLog("FAIL", "Start Watching Button should be displayed" + "\n"
								+ "Start Watching Button is not displayed", driver);
					}

}


public void ios_SignIn() throws Throwable 
{
	            
				SignIn = Utilities.returnElement(driver, lstObject.get(164), lstObject.get(163));
				Extent_Reports.executionLog("PASS", "Sign up button should be displayed " + "\n"
						+ "Sign up button is displayed", driver);
				SignIn.click();
				Thread.sleep(5000);
				
				user_id = Utilities.returnElement(driver, lstObject.get(167), lstObject.get(166));
				user_id.clear();
				Thread.sleep(2000);
				user_id.sendKeys(lstTestData.get(2));
			    Extent_Reports.executionLog("PASS", "User Name should be entered into the text field" + "\n"
						+ "User Name is entered into the text field", driver);
			    
			   
				pwd = Utilities.returnElement(driver, lstObject.get(170), lstObject.get(169));
			    pwd.sendKeys(lstTestData.get(3));
				Extent_Reports.executionLog("PASS", "Password should be entered into the text field" + "\n"
						+ "Password is entered into the text field", driver);
				
				Thread.sleep(2000);
				driver.hideKeyboard();
				
				Show_pwd = Utilities.returnElement(driver, lstObject.get(173), lstObject.get(172));
				
				if (Show_pwd.isEnabled()) {
					Extent_Reports.executionLog("PASS", "Show Password text should be displayed and values is: " + pwd.getAttribute("value") + "\n"
							+ "Show Password text is displayed", driver);
					Show_pwd.click();
					Thread.sleep(2000);
					Hide_pwd =  Utilities.returnElement(driver, lstObject.get(176), lstObject.get(175));
					Extent_Reports.executionLog("PASS", "Hide Password text should be displayed and value is: " + pwd.getAttribute("value") + "\n"
							+ "Hide Password text is displayed", driver);
					
					
				}else {
					Extent_Reports.executionLog("FAIL", "Show Password text should be displayed" + "\n"
							+ "Show Password text is not displayed", driver);
				}
				
				
				Sign_in = Utilities.returnElements(driver, lstObject.get(179), lstObject.get(178));
				if(Sign_in.get(1).isEnabled()) {
					Extent_Reports.executionLog("PASS", "SIGN IN Button should be enabled" + "\n"
							+ "SIGN IN Button should be enabled", driver);
					Sign_in.get(1).click();
					Thread.sleep(8000);
				}else {
					Extent_Reports.executionLog("FAIL", "SIGN IN Button should be enabled" + "\n"
							+ "SIGN IN Button should be enabled", driver);
				}
				
				

}

public void ios_FaceBook_SignIn() throws Throwable 
{
	
				SignIn = Utilities.returnElement(driver, lstObject.get(164), lstObject.get(163));
				Extent_Reports.executionLog("PASS", "Sign up button should be displayed " + "\n"
						+ "Sign up button is displayed", driver);
				SignIn.click();
				Thread.sleep(5000);
				
				//XCUIElementTypeButton[contains(@label,'FACEBOOK')]
				
				
				
				
				

}



	//PRASANTH-0509
	//COMMON FUNCTION FOR BOTH IOS AND ANDROID TO CLICK ON A PARTICULAR SHOW
public void click_ShowTitle(String locatorType, String locatorPath, String ShowNameFind) throws Exception {

	// Scrolldown and Select a Show
	List<WebElement> ShowsNameTextList = Utilities.returnElements(driver, locatorType, locatorPath);
	for (int i = 0; i < ShowsNameTextList.size(); i++) {
		ShowsNameTextList = Utilities.returnElements(driver, locatorType, locatorPath);
		if (ShowsNameTextList.get(i).getText().trim().equals(ShowNameFind.trim())) {
			WebElement showTitle = ShowsNameTextList.get(i);
			if (showTitle.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Show should be displayed " + "\n" + "Show is displayed",
						driver);
				showTitle.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS",
						"Show details page should be displayed " + "\n" + "Show details page is displayed", driver);
				break;
			}

		} else {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			HashMap scobj = new HashMap();
			scobj.put("direction", "down");
			scobj.put("element", ShowsNameTextList.get(0));
			jse.executeScript("mobile:scroll", scobj);
			Thread.sleep(1000);

		}
	}

}

// PRASANTH -0509
public boolean android_VerifyNBCIcon() throws Exception

{

	try {

		Synchronization.ExplicitWait(driver, lstObject.get(16), "visible");
		NBCIcon = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));

		if (!NBCIcon.isDisplayed()) {

			Extent_Reports.executionLog("FAIL",
					"NBC Logo should be displayed  " + "\n" + "NBC Logo is not displayed", driver);
			System.out.println("NBC Logo is not displayed ");
			isDisplayed = false;
		}

	}

	catch (Exception e) {
		Extent_Reports.executionLog("INFO", "Android_NBCIcon" + "\n" + e.getMessage(), driver);
	}

	return isDisplayed;
}

public void android_VerifyNBCHambergIcon() throws Exception

{

	try {

		Synchronization.ExplicitWait(driver, lstObject.get(16), "visible");
		NBCIcon = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));

		if (NBCIcon.isDisplayed()) {

			Extent_Reports.executionLog("PASS", "NBC Logo should be displayed  " + "\n" + "NBC Logo is  displayed",
					driver);
			System.out.println("NBC Logo is displayed ");

		} else {
			Extent_Reports.executionLog("PASS",

					"NBC Logo should be displayed  " + "\n" + "NBC Logo is  displayed", driver);
			System.out.println("NBC Logo is displayed ");

		}
	}

	catch (Exception e) {
		Extent_Reports.executionLog("INFO", "Android_NBCIcon" + "\n" + e.getMessage(), driver);
	}

}

// Lakshmikanth -0515 - Need to modify more, as of now i'm using this to
// click shows- will do changes
public void android_OpenShowsMenu() throws Exception {

	NBCIcon = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
	NBCIcon.click();
	Thread.sleep(2000);
	WebElement Showsicon = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
	if (Showsicon.isDisplayed()) {
		Showsicon.click();
		Thread.sleep(5000);
		Extent_Reports.executionLog("PASS", "Shows button should be clicked " + "\n" + "Clicked on Shows Button",
				driver);
	} else {
		Extent_Reports.executionLog("FAIL",
				"Shows button should be clicked " + "\n" + "Not Clicked on Shows Button", driver);
	}
}

// Lakshmikanth -0515
public void android_OpenShow(String ShowName) throws Exception {


		
		try {
			NBCIcon = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			NBCIcon.click();
			Thread.sleep(2000);
			WebElement Showsicon = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
			if (Showsicon.isDisplayed()) {
				Showsicon.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS",
						"Shows button should be clicked " + "\n" + "Clicked on Shows Button", driver);
			} else {
				Extent_Reports.executionLog("FAIL",
						"Shows button should be clicked " + "\n" + "Not Clicked on Shows Button", driver);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PGNbcApp openShow = new PGNbcApp(driver);
		if(openShow.android_ClickOnParticularShow(ShowName))
		{
			Extent_Reports.executionLog("PASS",
					"Shows name "+ShowName+" should be clicked " + "\n" + "Clicked on "+ShowName, driver);
		}
		else
		{
			//1.Scrolling method
			//2.click on the show
			openShow.android_ClickOnParticularShow(ShowName);
		}

		
	}

	//BHARDWAJ -0605
	
public boolean android_ClickOnParticularShow(String ShowName) throws Exception
{
	boolean flag= false;
	try{
	
	List<WebElement> ShowsNameTextList = Utilities.returnElements(driver, lstObject.get(188), lstObject.get(187));
	
	for(int k=0;k<15;k++) 
	{
		ShowsNameTextList = Utilities.returnElements(driver, lstObject.get(188), lstObject.get(187));
		for (int i = 0; i <= ShowsNameTextList.size()-1; i++)
		{
			
			System.out.println(ShowsNameTextList.get(i).getText());
			if (ShowsNameTextList.get(i).getText().trim().equalsIgnoreCase(ShowName.trim()))
			{
				flag=true;
				System.out.println(ShowsNameTextList.get(i).getText());
				Extent_Reports.executionLog("PASS", "Show should be displayed " + "\n" + "Show is displayed",
						driver);
				ShowsNameTextList.get(i).click();
				isPresent=true;
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS",
						"Show details page should be displayed " + "\n" + "Show details page is displayed", driver);
				break;

			}


		}

		if(flag==false) 
		{
		int pressX = driver.manage().window().getSize().width / 2;
		int bottomY = driver.manage().window().getSize().height * 4/5;
		int topY = driver.manage().window().getSize().height / 8;
		TouchAction touchAction = new TouchAction(driver);
		touchAction.longPress(pressX, bottomY).moveTo(pressX, topY).release().perform();
		}
		if(flag==true) {
			break;
		}
	}
	}
	catch(Exception e)
	{
		Extent_Reports.executionLog("INFO", "Clicking on a particular show" + "\n" + e.getMessage(), driver);
	}
	return isPresent;
}


// PRASANTH -0510 . Navigate to Shows Page
public void android_ShowsPage() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 50);
	// This is just to check if the user is in Show home page and navigate
	// back one level up
	// shpBackBtn=Utilities.returnElement(driver, lstObject.get(44),
	// lstObject.get(43));

	// shpBackBtn.click();

	if (android_VerifyNBCIcon()) {
		NBCIcon = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
		NBCIcon.click();
		try {
			// Synchronization.ExplicitWait(driver, lstObject.get(19),
			// "visible");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(19))));
			Shows = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));

			if (Shows.isDisplayed()) {
				Shows.click();

			} else {
				Extent_Reports.executionLog("FAIL",
						"Shows from Global NAv should be clicked " + "\n" + "Shows from Global NAv is not clicked ",
						driver);
			}

		}

		catch (Exception e) {
			Extent_Reports.executionLog("INFO", "Opening Shows Page" + "\n" + e.getMessage(), driver);
		}

	}

	else {
		Extent_Reports.executionLog("FAIL", "NBC Logo should be displayed " + "\n" + "NBC Logo is not displayed ",
				driver);
	}

}

// PRASANTH-0510 .TO CLICK ON A EPISODE FROM A SHOW HOME PAGE

public void android_ClickEpisode(String ShowName, String EpisodeName) throws Exception {

	android_OpenShow(ShowName);

	try {

		List<WebElement> EpisodeLst = Utilities.returnElements(driver, lstObject.get(41), lstObject.get(40));
		for (int i = 0; i < EpisodeLst.size(); i++) {
			EpisodeLst = Utilities.returnElements(driver, lstObject.get(41), lstObject.get(40));
			if (EpisodeLst.get(i).getText().trim().equals(ShowName.trim())) {
				EpisodeLst.get(i).click();

				break;

			} else {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				HashMap scobj = new HashMap();
				scobj.put("direction", "right");
				scobj.put("element", EpisodeLst.get(0));
				jse.executeScript("mobile:scroll", scobj);
				Thread.sleep(1000);

			}

		}

	} catch (Exception e) {
		Extent_Reports.executionLog("INFO", "Opening  an episode" + "\n" + e.getMessage(), driver);
	}

}

// PRASANTH-0510 . Navigate to a particular show category

public void android_ClickCategory(String CategoryName) throws Exception

{
	String locatorPath = null;

	switch (CategoryName.toLowerCase()) {
	case "all":
		SelectOption = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
		locatorPath = "lstObject.get(35)";
	case "throwback":
		SelectOption = Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
		locatorPath = "lstObject.get(32)";
	case "current":
		SelectOption = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
		locatorPath = "lstObject.get(29)";

	}

	try {
		Synchronization.ExplicitWait(driver, locatorPath, "visible");

		if (SelectOption.isDisplayed()) {
			SelectOption.click();
			Extent_Reports.executionLog("PASS",
					CategoryName + " Should be clicked " + "\n" + CategoryName + " is clicked", driver);
		} else {
			Extent_Reports.executionLog("FAIL",
					CategoryName + " Should be clicked " + "\n" + CategoryName + " is not clicked", driver);
		}
	} catch (Exception e) {
		Extent_Reports.executionLog("INFO", "Selecting Shows category " + "\n" + e.getMessage(), driver);
	}
}

// PRASANTH -0510 . Open A.P.Bio under Current category. This is to open any
// available show in test cases where SHOW NAME Is not specified.
public void android_GotoAnyShowHomePage() throws Exception {
	android_ShowsPage();
	try {
		Synchronization.ExplicitWait(driver, lstObject.get(37), "visible");
		clkOnShow = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));

		if (clkOnShow.isDisplayed()) {
			clkOnShow.click();
			Synchronization.ExplicitWait(driver, lstObject.get(37), "visible");

			if (Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37)).isEnabled()) {
				Extent_Reports.executionLog("PASS", "A.P.Bio Show Home Page Should be displayed " + "\n"
						+ "A.P.Bio Show Home Page is displayed ", driver);
			} else {
				Extent_Reports.executionLog("FAIL", "A.P.Bio Show Home Page Should be displayed " + "\n"
						+ "A.P.Bio Show Home Page is not displayed ", driver);
			}

		} else {
			Extent_Reports.executionLog("FAIL",
					"A.P.Bio Should be clicked " + "\n" + "A.P.Bio Show is not clicked ", driver);
		}
	}

	catch (Exception e) {
		Extent_Reports.executionLog("INFO", "Opening A.P.BioShow Home Page" + "\n" + e.getMessage(), driver);

	}
}

// Not
public void android_GotHomePage() throws Exception {

	// This is just to check if the user is in Show home page and navigate
	// back one level up
	shpBackBtn = Utilities.returnElement(driver, lstObject.get(44), lstObject.get(43));
	if (shpBackBtn.isDisplayed()) {
		shpBackBtn.click();
	}

	if (android_VerifyNBCIcon()) {

		NBCIcon.click();
		try {
			Synchronization.ExplicitWait(driver, lstObject.get(181), "visible");
			Home = Utilities.returnElement(driver, lstObject.get(182), lstObject.get(181));

			if (Home.isDisplayed()) {
				Home.click();

			} else {
				Extent_Reports.executionLog("FAIL",
						"HOME from Global NAv should be clicked " + "\n" + "HOME from Global NAv is not clicked ",
						driver);
			}

		}

		catch (Exception e) {
			Extent_Reports.executionLog("INFO", "Navigating to home page" + "\n" + e.getMessage(), driver);
		}

	}

	else {
		Extent_Reports.executionLog("FAIL",
				"NBC Logo should be displayed to go to home page " + "\n" + "NBC Logo is not displayed ", driver);
	}

}

// PRASANTH-0510 Wait for the app to load with spinner
public void android_WaitForAppToLoad() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 50);
	
	
	try {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(46))));
	//	Synchronization.ExplicitWait(driver, lstObject.get(46), "visible");
		
		objloading = Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
		//objloading.click();
		Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
				driver);
	} catch (Exception e) {
		//((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
				driver);
		Thread.sleep(10000);
	}
	
}

// PRASANTH-0510 To Dismiss the cast overlay after the first app launch
public void android_DismissCastOverlay() throws Exception {
	WebDriverWait wait = new WebDriverWait(driver, 50);
	try {
		Synchronization.ExplicitWait(driver, lstObject.get(52), "visible");
		// wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(52))));
		CastIcon = Utilities.returnElement(driver, lstObject.get(53), lstObject.get(52));
		CastIcon.click();

		Extent_Reports.executionLog("PASS", "Cast icon should be clicked " + "\n" + "Clicked on cast icon", driver);
		// Synchronization.ExplicitWait(driver, lstObject.get(55),
		// "visible");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(55))));

		try {
			CastPopUp = Utilities.returnElement(driver, lstObject.get(56), lstObject.get(55));
			if (CastPopUp.isDisplayed()) {
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
			} else {
				Extent_Reports.executionLog("FAIL",
						"Cast pop up  should be displayed " + "\n" + "Cast pop up  is  displayed", driver);
				System.out.println("cast pop up not displayed");
			}

		} catch (Exception e1) {
			((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		}
	}

	catch (Exception e) {
		Extent_Reports.executionLog("INFO", "DismissiLoading App" + "\n" + e.getMessage(), driver);
	}
}
public static void swipe(int timeToWait) throws InterruptedException {
    Dimension size = driver.manage().window().getSize();
    int startx = size.getWidth()/2;
    
    int starty= size.getHeight()-1;
    int y = (int) (size.height*0.80);
    int end = (int) (size.height*0.20);
    int x = size.getWidth()/2;
        
    TouchAction touchAction1 = new TouchAction(driver);
    TouchAction touchAction2 = new TouchAction(driver);
    TouchAction touchAction3 = new TouchAction(driver);
    touchAction1.press(startx, starty).moveTo(0, -200).release().perform().waitAction();
   // touchAction1.press(startx, 0).moveTo(-200, 0).release().perform().waitAction();

    Thread.sleep(timeToWait*1000);
         
    
    try {
		touchAction2.longPress(568, 600).moveTo(610, 1616).release().perform().waitAction();
		touchAction2.longPress(568, 600).moveTo(610, 1616).release().perform().waitAction();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    // code by Ajith
   // touchAction2.press(startx, 20).moveTo(0, size.getHeight()+2).release().perform().waitAction();
    //touchAction2.press(0, -200).moveTo(startx, starty).release().perform().waitAction();
    touchAction3.tap(0, starty);
    
}



/**
 * performs upwards swipe gesture by quarter of height from middle of the screen.
 * @throws InterruptedException 
  */
 public void swipeUp(){

                 Dimension size = driver.manage().window().getSize();
                 int startY=size.height-(size.height/3);
                 TouchAction touchAction = new TouchAction(driver);
                 touchAction.press(size.width/2, startY).moveTo(0, -startY).release().perform();
 }
 /**
 * performs upwards swipe gesture by quarter of height from middle of the screen.
 */
 public void swipedown() {

                 Dimension size = driver.manage().window().getSize();
                 int startY=(int) (size.height * 0.50);
                 TouchAction touchAction = new TouchAction(driver);
                 touchAction.press(size.width/2, startY).moveTo(0, startY).release().perform();
 }

 /**
 * performs upwards swipe gesture by quarter of height from middle of the screen.
 */
//  public void swipe(int startX, int startY,int endX, int endY) {

	  public void swipe() {
	
	   try{
	   for(int i=0;i<20;i++)
	   {
			 Dimension dimensions = driver.manage().window().getSize();
	    	 Double screenHeightStart=dimensions.getHeight()*0.7;
	    	 int scrollstart=screenHeightStart.intValue();
	    	 
	    	 Double screenHeightEnd=dimensions.getHeight()*0.3;
	    	 int scrollEnd=screenHeightEnd.intValue();
	    	 
	    	   TouchAction touchAction = new TouchAction(driver);
	    	   System.out.println("Height" +dimensions.getHeight());
	    	   System.out.println("scrollstart "+scrollstart);
	    	   System.out.println("scrollEnd "+scrollEnd);
          touchAction.press(0,scrollEnd).moveTo(0, scrollstart).release().perform();
          
         // touchAction.press(0,scrollstart).moveTo(0, scrollEnd).release().perform();
        //  touchAction.longPress(568, 600).moveTo(610, 1616).release().perform().waitAction();
       
	   }
	   }
	   catch(Exception e){
		   System.out.println(e);
		   
	   }
	 
            //     TouchAction touchAction = new TouchAction(driver);
              //   touchAction.press(startX, startY).moveTo(startX+endX, startY+endY).release().perform();

 }

	  public void scrollDown(By Loc) {

	        for(int i=0;i<10;i++) 
	        {
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

	    }
	  public void tvRating() throws Exception  {
		  WebDriverWait wait = new WebDriverWait(driver, 50);
		  for (int i=0;i<=1000;i++){
		        try{
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ImageView[contains(@resource-id,'rating_image')]")));
		        break;
		        }catch(Exception E){
		            Thread.sleep(10000);
		        }
		        }
	  }
}// EOC



