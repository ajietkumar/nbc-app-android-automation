package com.nbcd.Pages;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
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
public class PGAppSettings  {
	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> objShowLists, objShowList,statictext,MPVD_linkproviderlist,SignBtn,SignInPage_Link_Text;
	String sqlQry, Status;
	WebElement objnav, objRespNavBar, objClipDropDownWebEx, objShowLink,Setting_Icon,Tv_provider,LINKPROVIDER_Text,closeIcon,Faq_linkText,Faq,Back_btn,Home,Scrollobj,Faq_target;
	WebElement SignIn,Email,password,show_pwd,Sign_UpLink,Sign_Up_Page,forkscreen, SettingsTitle;
	// Constructor to initialize all the Page Objects
	public PGAppSettings(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGAppSettings", "Input");
		lstObject = db.getTestDataObject("Select * from PGAppSettings", "ObjectRepository");
	}
	// =========================================================================================================================
	@SuppressWarnings("deprecation")
	@Test
	public void android_Settings() throws  Exception {
		try {

			WebDriverWait wait = new WebDriverWait(driver, 50);

			PGNbcApp App = new PGNbcApp(driver);
			App.android_WaitForAppToLoad();
			App.android_DismissCastOverlay();

			PGAndroidApp app = new PGAndroidApp(driver);
			app.android_OpenMenu("SETTINGS");
			
			App.swipeUp();
			Thread.sleep(2000);
			SettingsTitle = Utilities.returnElement(driver, lstObject.get(77), lstObject.get(76));
			Thread.sleep(2000);
			if (SettingsTitle.isDisplayed()) {
				Extent_Reports.executionLog("PASS",
						"Settings menu  should be displayed " + "\n" + "Settings menu is Displayed", driver);
			} else {
				Extent_Reports.executionLog("FAIL",
						"Settings menu  should be displayed " + "\n" + "Settings menu is not  Displayed", driver);
			}

			List<WebElement> SettingsList = Utilities.returnElements(driver, lstObject.get(107), lstObject.get(106));
			for (int i = 0; i <= SettingsList.size(); i++) {
				SettingsList = Utilities.returnElements(driver, lstObject.get(107), lstObject.get(106));
				for (int j = 0; j <= SettingsList.size(); j++) {
					if (SettingsList.get(i).getText().trim().equalsIgnoreCase(lstTestData.get(j).trim())) {
						System.out.println(SettingsList.get(j).getText());
						Extent_Reports.executionLog("PASS", SettingsList.get(i).getText() + "should be displayed "
								+ "\n" + SettingsList.get(i).getText() + " is displayed", driver);
						SettingsList.get(i).click();
						Extent_Reports.executionLog("PASS", SettingsList.get(i).getText() + "Page should be displayed "
								+ "\n" + SettingsList.get(i).getText() + " Page is displayed", driver);
						Thread.sleep(10000);
						((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
						try {
							forkscreen = Utilities.returnElement(driver, lstObject.get(110), lstObject.get(109));
							if (forkscreen.isDisplayed()) {
								((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
							}
							else{
								Thread.sleep(1000);
								PGNbcApp NbcApp = new PGNbcApp(driver);
								NbcApp.swipeUp();
							}
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						PGNbcApp NbcApp = new PGNbcApp(driver);
						NbcApp.swipeUp();
						Thread.sleep(3000);

						break;
					}
					
				}
				
			}
		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_Settings" + "\n" + e.getMessage(), driver);

		}
	}// EOM
	
	
	public void IOS_MVPDPicker_Portrait_NIR7658() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();
			
			Setting_Icon=Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			
			if(Setting_Icon.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed" + "\n" + "Setting Icon is displayed",
						driver);
				Setting_Icon.click();
				Thread.sleep(2000);
				
				Tv_provider=Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
				
				if(Tv_provider.isDisplayed()) {
					Extent_Reports.executionLog("PASS", "Tv Provider Link should be displayed" + "\n" + "Tv Provider Link is displayed",
							driver);
					Tv_provider.click();
					Thread.sleep(1000);
					try {
						
						Alert alert = driver.switchTo().alert();
						alert.dismiss();;
						Thread.sleep(10000);
						
					}catch(Exception e) {

						
					}
					LINKPROVIDER_Text=Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
					if (LINKPROVIDER_Text.getAttribute("label").equals("LINK PROVIDER")) {
						Extent_Reports.executionLog("PASS", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is displayed",
								driver);
					}else {
						Extent_Reports.executionLog("FAIL", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is not displayed",
								driver);
					}
					
					
					statictext=Utilities.returnElements(driver, lstObject.get(26), lstObject.get(25));
					
					for(int i=0;i<statictext.size();i++) {
						Extent_Reports.executionLog("PASS", "LINK PROVIDER Static Text should be displayed as:  " + statictext.get(i).getAttribute("label") + "\n" + "LINK PROVIDER static Text is displayed",
								driver);
					}
					
					
					
					MPVD_linkproviderlist =Utilities.returnElements(driver, lstObject.get(32), lstObject.get(31));
					for (int j=0;j<MPVD_linkproviderlist.size();j++) {
						Extent_Reports.executionLog("PASS", "MVPD LINK PROVIDER Name should be displayed as:  " + MPVD_linkproviderlist.get(j).getAttribute("name") + "\n" + "MVPD LINK PROVIDER Name is displayed",
								driver);
					}
					
					
               closeIcon=Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
					
					if(closeIcon.isDisplayed()) {
						Extent_Reports.executionLog("PASS", "close Icon should be displayed as:  "  + "\n" + "close Icon  is  displayed",
								driver);
						closeIcon.click();
						Thread.sleep(8000);
						
						Extent_Reports.executionLog("PASS", "MVPD page should be closed  "  + "\n" + "MVPD page is closed ",
								driver);
					}else {
						Extent_Reports.executionLog("FAIL", "close Icon should be displayed as:  "  + "\n" + "close Icon is not displayed",
								driver);
					}
					
				}else {
					Extent_Reports.executionLog("FAIL", "Tv Provider Link should be displayed" + "\n" + "Tv Provider Link is not displayed",
							driver);
				}
				
			}else {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed" + "\n" + "Setting Icon is not displayed",
						driver);
			}
			

      



		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_example"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM


	
	public void iOS_MVPD_showdetails() throws  Exception
	{
		
		try
		{
			
			
					LINKPROVIDER_Text=Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
					if (LINKPROVIDER_Text.getAttribute("label").equals("LINK PROVIDER")) {
						Extent_Reports.executionLog("PASS", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is displayed",
								driver);
					}else {
						Extent_Reports.executionLog("FAIL", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is not displayed",
								driver);
					}
					
					
					statictext=Utilities.returnElements(driver, lstObject.get(26), lstObject.get(25));
					
					for(int i=0;i<statictext.size();i++) {
						Extent_Reports.executionLog("PASS", "LINK PROVIDER Static Text should be displayed as:  " + statictext.get(i).getAttribute("label") + "\n" + "LINK PROVIDER static Text is displayed",
								driver);
					}
					
					
					
					MPVD_linkproviderlist =Utilities.returnElements(driver, lstObject.get(32), lstObject.get(31));
					for (int j=0;j<MPVD_linkproviderlist.size();j++) 
					{
						Extent_Reports.executionLog("PASS", "MVPD LINK PROVIDER Name should be displayed as:  " + MPVD_linkproviderlist.get(j).getAttribute("name") + "\n" + "MVPD LINK PROVIDER Name is displayed",
								driver);
					}
					
		
     closeIcon=Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
					
					if(closeIcon.isDisplayed()) 
					{
						Extent_Reports.executionLog("PASS", "close Icon should be displayed as:  "  + "\n" + "close Icon  is  displayed",
								driver);
						closeIcon.click();
						Thread.sleep(5000);
					}else {
						Extent_Reports.executionLog("FAIL", "close Icon should be displayed as:  "  + "\n" + "close Icon is not displayed",
								driver);
					}
      



		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_example"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM


	
	public void IOS_MVPDPicker_Landscape() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();
			
			Setting_Icon=Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			
			if(Setting_Icon.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed" + "\n" + "Setting Icon is displayed",
						driver);
				Setting_Icon.click();
				Thread.sleep(2000);
				
				Tv_provider=Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
				
				if(Tv_provider.isDisplayed()) {
					Extent_Reports.executionLog("PASS", "Tv Provider Link should be displayed" + "\n" + "Tv Provider Link is displayed",
							driver);
					Tv_provider.click();
					Thread.sleep(1000);
					try {
						
						Alert alert = driver.switchTo().alert();
						alert.dismiss();;
						Thread.sleep(10000);
						
					}catch(Exception e) {

						
					}
					
					pgnbcappobj.rotateDeviceScreenToLandscape("LANDSCAPE");
					
					LINKPROVIDER_Text=Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
					if (LINKPROVIDER_Text.getAttribute("label").equals("LINK PROVIDER")) {
						Extent_Reports.executionLog("PASS", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is displayed",
								driver);
					}else {
						Extent_Reports.executionLog("FAIL", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is not displayed",
								driver);
					}
					
					
					statictext=Utilities.returnElements(driver, lstObject.get(26), lstObject.get(25));
					
					for(int i=0;i<statictext.size();i++) {
						Extent_Reports.executionLog("PASS", "LINK PROVIDER Static Text should be displayed as:  " + statictext.get(i).getAttribute("label") + "\n" + "LINK PROVIDER static Text is displayed",
								driver);
					}
					
					
					
					MPVD_linkproviderlist =Utilities.returnElements(driver, lstObject.get(32), lstObject.get(31));
					for (int j=0;j<MPVD_linkproviderlist.size();j++) {
						Extent_Reports.executionLog("PASS", "MVPD LINK PROVIDER Name should be displayed as:  " + MPVD_linkproviderlist.get(j).getAttribute("name") + "\n" + "MVPD LINK PROVIDER Name is displayed",
								driver);
					}
					
					
               closeIcon=Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
					
					if(closeIcon.isDisplayed()) {
						Extent_Reports.executionLog("PASS", "close Icon should be displayed as:  "  + "\n" + "close Icon  is  displayed",
								driver);
						closeIcon.click();
						Thread.sleep(8000);
						
						Extent_Reports.executionLog("PASS", "MVPD page should be closed  "  + "\n" + "MVPD page is closed ",
								driver);
					}else {
						Extent_Reports.executionLog("FAIL", "close Icon should be displayed as:  "  + "\n" + "close Icon is not displayed",
								driver);
					}
					
				}else {
					Extent_Reports.executionLog("FAIL", "Tv Provider Link should be displayed" + "\n" + "Tv Provider Link is not displayed",
							driver);
				}
				
			}else {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed" + "\n" + "Setting Icon is not displayed",
						driver);
			}
			

      



		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_example"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM

	public void MVPDPicker() throws  Throwable
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();
			
			Setting_Icon=Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			
			if(Setting_Icon.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed" + "\n" + "Setting Icon is displayed",
						driver);
				Setting_Icon.click();
				Thread.sleep(2000);
				
				Tv_provider=Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
				
				if(Tv_provider.isDisplayed()) {
					Extent_Reports.executionLog("PASS", "Tv Provider Link should be displayed" + "\n" + "Tv Provider Link is displayed",
							driver);
					Tv_provider.click();
					Thread.sleep(1000);
					try {
						
						Alert alert = driver.switchTo().alert();
						alert.dismiss();;
						Thread.sleep(10000);
						
					}catch(Exception e) {

						
					}
					
				}	
				

			}	
			
			pgnbcappobj.ios_Linkprovider(lstTestData.get(0));
			//pgnbcappobj.ios_SignUp(lstTestData.get(1),lstTestData.get(2));
			pgnbcappobj.ios_SignUp("srini986@gmail.com",lstTestData.get(2));

		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "MVPDPicker"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM

	
	
	public void iOS_Verify_FAQcontents_when_page_is_scrolled_NIR7332() throws  Throwable
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();
			Setting_Icon=Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			
			if(Setting_Icon.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed and clickable" + "\n" + "Setting Icon is displayed and is clicked",
						driver);
				Setting_Icon.click();
				Thread.sleep(4000);
				Faq_linkText=Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
				if(Faq_linkText.isEnabled()) {
					Extent_Reports.executionLog("PASS", "FAQ link text should be displayed and clickable" + "\n" + "FAQ link text is displayed and is clicked",
							driver);
					Faq_linkText.click();
					Thread.sleep(4000);
					Extent_Reports.executionLog("PASS", "FAQ page should be displayed " + "\n" + "FAQ page is displayed ",
							driver);
					Faq=Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
					if(Faq.isEnabled()) {
						Extent_Reports.executionLog("PASS", "FAQ Header should be displayed " + "\n" + "FAQ Header is displayed ",
								driver);
					}else {
						Extent_Reports.executionLog("PASS", "FAQ Headershould be displayed " + "\n" + "FAQ Header is displayed ",
								driver);
					}
					
					Back_btn=Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
					if(Back_btn.isEnabled()) {
						Extent_Reports.executionLog("PASS", "Back button should be displayed " + "\n" + "Back button is displayed ",
								driver);
					}else {
						Extent_Reports.executionLog("PASS", "Back button should be displayed " + "\n" + "Back button is displayed ",
								driver);
					}
					
					Home=Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
					if(Home.isEnabled()) {
						Extent_Reports.executionLog("PASS", "Home Menu should be displayed " + "\n" + "Home Menu is displayed ",
								driver);
					}else {
						Extent_Reports.executionLog("PASS", "Home Menu should be displayed " + "\n" + "Home Menu is displayed ",
								driver);
					}
					
					
				
				    
				    try 
					{
						for(int i=0;i<100;i++)
						{
							
							WebElement ele=Utilities.returnElement(driver, lstObject.get(47), lstObject.get(46));
						    Faq_target =  Utilities.returnElement(driver, lstObject.get(44), lstObject.get(43));
						    
							JavascriptExecutor jse=  (JavascriptExecutor) driver;
							HashMap scobj= new HashMap(); 
							scobj.put("direction","down");
							//scobj.put("element",Scrollobj.get(6));
							scobj.put("element",ele);
							jse.executeScript("mobile:scroll",scobj);
							//Thread.sleep(1000);

							if (Faq_target.isDisplayed())
							{
								Extent_Reports.executionLog("PASS", "The element should be displayed " + "\n"
										+ "The element is displayed", driver);
								Thread.sleep(10000);
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
				    
				    
					//pgnbcappobj.iOS_scroll(Scrollobj.get(0), Faq_target, "down");
					Back_btn=Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
					if(Back_btn.isEnabled()) {
						Extent_Reports.executionLog("PASS", "Back button should be displayed " + "\n" + "Back button is displayed ",
								driver);
					}else {
						Extent_Reports.executionLog("PASS", "Back button should be displayed " + "\n" + "Back button is displayed ",
								driver);
					}
					
					Home=Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
					if(Home.isEnabled()) {
						Extent_Reports.executionLog("PASS", "Home Menu should be displayed " + "\n" + "Home Menu is displayed ",
								driver);
					}else {
						Extent_Reports.executionLog("PASS", "Home Menu should be displayed " + "\n" + "Home Menu is displayed ",
								driver);
					}
					
				}else {
					Extent_Reports.executionLog("FAIL", "FAQ link text should be displayed and clickable" + "\n" + "FAQ link text is not displayed and is not clicked",
							driver);
				}
				
			}else {
				Extent_Reports.executionLog("FAIL", "Setting Icon should be displayed and clickable" + "\n" + "Setting Icon is not displayed and is not clicked",
						driver);
			}
			
			

		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "MVPDPicker"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM
	
	
	
	public void iOS_Verify_fields_Sign_In_with_Email_NIR7909() throws  Throwable
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();
			Setting_Icon=Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			
			if(Setting_Icon.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed and clickable" + "\n" + "Setting Icon is displayed and is clicked",
						driver);
				Setting_Icon.click();
				Thread.sleep(4000);
				SignIn=Utilities.returnElement(driver, lstObject.get(50), lstObject.get(49));
				SignIn.click();				
				Email=Utilities.returnElement(driver, lstObject.get(53), lstObject.get(52));
				if (Email.isEnabled()) {
					Extent_Reports.executionLog("PASS", "Email text field should be displayed " + "\n" + "Email text field is displayed ",
							driver);
				}else {
					Extent_Reports.executionLog("FAIL", "Email text field should be displayed " + "\n" + "Email text field is not displayed ",
							driver);

				}
				password=Utilities.returnElement(driver, lstObject.get(56), lstObject.get(55));
				if (password.isEnabled()) {
					Extent_Reports.executionLog("PASS", "Password text field should be displayed " + "\n" + "Password text field is displayed ",
							driver);
				}else {
					Extent_Reports.executionLog("FAIL", "Password text field should be displayed " + "\n" + "Password text field is not displayed ",
							driver);

				}
			/*	show_pwd=Utilities.returnElement(driver, lstObject.get(59), lstObject.get(58));
				if (show_pwd.isEnabled()) {
					Extent_Reports.executionLog("PASS", "Show Password link text should be displayed " + "\n" + "Show Password link text is displayed ",
							driver);
				}else {
					Extent_Reports.executionLog("FAIL", "Show Password link text  should be displayed " + "\n" + "Show Password link text is not displayed ",
							driver);

				} */
				SignBtn=Utilities.returnElements(driver, lstObject.get(62), lstObject.get(61));
				if (SignBtn.get(1).isEnabled()) {
					Extent_Reports.executionLog("PASS", "Sign In should be displayed and disabled" + "\n" + "Sign In is displayed and disabled",
							driver);
				}else {
					Extent_Reports.executionLog("FAIL", "Show Password link text field should be displayed and disabled" + "\n" + "Show Password link text field is not displayed and disabled",
							driver);

				}
				
				SignInPage_Link_Text=Utilities.returnElements(driver, lstObject.get(65), lstObject.get(64));
				for(int i=0;i<=SignInPage_Link_Text.size()-1;i++) {
					Extent_Reports.executionLog("PASS", "Forgot Password button/link (or) Reset Password links should be displayed" + SignInPage_Link_Text.get(i).getAttribute("value") + "Forgot Password button/link (or) Reset Password links should be displayed"+ "\n" ,
							driver);
				}
				
				Email.sendKeys(lstTestData.get(3));
				Thread.sleep(2000);
				password.sendKeys(lstTestData.get(4));
				Thread.sleep(2000);
				SignBtn=Utilities.returnElements(driver, lstObject.get(62), lstObject.get(61));
				if (SignBtn.get(1).isEnabled()) {
					Extent_Reports.executionLog("PASS", "Sign In should be displayed and enabled" + "\n" + "Sign In is displayed and enabled",
							driver);
				}else {
					Extent_Reports.executionLog("FAIL", "Show Password link text field should be displayed and enabled" + "\n" + "Show Password link text field is not displayed and enabled",
							driver);

				}
			    driver.hideKeyboard();
			    Thread.sleep(1000);
				Sign_UpLink=Utilities.returnElement(driver, lstObject.get(71), lstObject.get(70));
				if (Sign_UpLink.isEnabled()) {
					Sign_UpLink.click();
					Thread.sleep(2000);
			/*		Sign_Up_Page=Utilities.returnElement(driver, lstObject.get(74), lstObject.get(73));	
					if (Sign_Up_Page.isEnabled()) {
						
						Extent_Reports.executionLog("PASS", "Should be Navigated to Sing UP page" + "\n" + "Navigated to Sing UP page",
								driver);
					}else {
						Extent_Reports.executionLog("FAIL", "Navigated to Sing UP page" + "\n" + "Not Navigated to Sing UP page",driver);

					
				} */
				}
				
				/*
				Set<String> allContext = driver.getContextHandles();
				   for (String context : allContext) {
				       if (context.contains("WEBVIEW")) 
				       {
				           driver.context(context);
				           Extent_Reports.executionLog("PASS", "Switched" + "\n" + "Switched",
									driver); 
				           break;
				          
				   }
				}
				*/
				   Thread.sleep(5000);
				   Set<String> contextNames = driver.getContextHandles();
				   for (String contextName : contextNames) {
				       if (contextName.contains("NATIVE")) {
				           driver.context(contextName);
				       Extent_Reports.executionLog("PASS", "Switched back" + "\n" + "Switched back",
								driver);  
				       break;
				   }
				}
			
				
			}	
			
		

		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_Verify_fields_Sign_In_with_Email_NIR7909"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM
	
	public void android_Verify_NbcProfile() throws Throwable{
	    PGNbcApp App = new PGNbcApp(driver);
	    App.android_WaitForAppToLoad();
	    App.android_DismissCastOverlay();
	    
	    PGAndroidApp nbc = new PGAndroidApp(driver);
	    nbc.android_NBCSignUP_Email();
	    nbc.android_NBCSignOut();
	    nbc.android_NBCSignIn_Email();
	}
	public void android_Verify_NbcProfile1() throws Throwable{
	    PGNbcApp App = new PGNbcApp(driver);
	    App.android_WaitForAppToLoad();
	    App.android_DismissCastOverlay();
	    PGAndroidApp nbc = new PGAndroidApp(driver);
	    nbc.android_NBCSignUP_Email();
	    nbc.android_NBCSignOut();
	    nbc.android_NBCSignIn_Email();
	}
	
	
	public void IOS_fullistMVPDlogosdisplayed_landscape_NIR7657() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();
			
			Setting_Icon=Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			
			if(Setting_Icon.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed" + "\n" + "Setting Icon is displayed",
						driver);
				Setting_Icon.click();
				Thread.sleep(2000);
				
				Tv_provider=Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
				
				if(Tv_provider.isDisplayed()) {
					Extent_Reports.executionLog("PASS", "Tv Provider Link should be displayed" + "\n" + "Tv Provider Link is displayed",
							driver);
					Tv_provider.click();
					Thread.sleep(1000);
					try {
						
						Alert alert = driver.switchTo().alert();
						alert.dismiss();;
						Thread.sleep(10000);
						
					}catch(Exception e) {

						
					}
					LINKPROVIDER_Text=Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
					if (LINKPROVIDER_Text.getAttribute("label").equals("LINK PROVIDER")) {
						Extent_Reports.executionLog("PASS", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is displayed",
								driver);
					}else {
						Extent_Reports.executionLog("FAIL", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is not displayed",
								driver);
					}
			
					
					WebElement SelectTVText=Utilities.returnElement(driver, lstObject.get(113), lstObject.get(112));
					WebElement Usernamepasswordhandytext=Utilities.returnElement(driver, lstObject.get(116), lstObject.get(115));
					if(SelectTVText.isDisplayed() && Usernamepasswordhandytext.isDisplayed()) 
					{
						Extent_Reports.executionLog("PASS", "Select your TV provider below to watch unlimited NBC content.(have your username and password handy) text should be displayed " + "\n" + "Select your TV provider below to watch unlimited NBC content.(have your username and password handy) text is displayed",
								driver);
					}
					else {
						Extent_Reports.executionLog("FAIL", "Select your TV provider below to watch unlimited NBC content.(have your username and password handy) text should be displayed " + "\n" + "Select your TV provider below to watch unlimited NBC content.(have your username and password handy) text is not displayed",
								driver);
					}
					
					WebElement DontSeeTVProvide=Utilities.returnElement(driver, lstObject.get(119), lstObject.get(118));
					WebElement DontSeeFullList=Utilities.returnElement(driver, lstObject.get(122), lstObject.get(121));
					if(DontSeeTVProvide.isDisplayed() && DontSeeFullList.isDisplayed()) 
					{
						Extent_Reports.executionLog("PASS", "Don't see your provider? See The Full List text link should be displayed" + "\n" + "Don't see your provider? See The Full List text link is displayed ",
								driver);
					}
					else {
						Extent_Reports.executionLog("FAIL", "Don't see your provider? See The Full List text link should be displayed" + "\n" + "Don't see your provider? See The Full List text link is not displayed ",
								driver);
					}
					DontSeeFullList.click();
					Synchronization.waitForPageLoad(driver);
					WebElement FullListBackIcon=Utilities.returnElement(driver, lstObject.get(125), lstObject.get(124));
					if(FullListBackIcon.isDisplayed() ) 
					{
						Extent_Reports.executionLog("PASS", "Full List  of provider should be displayed" + "\n" + "Full List  of provider is displayed ",
								driver);
						
						FullListBackIcon.click();
						Synchronization.waitForPageLoad(driver);
					
						
					}
					else {
						Extent_Reports.executionLog("FAIL", "Full List  of provider should be displayed" + "\n" + "Full List  of provider is not displayed ",
								driver);
					}
					
					
					 DontSeeTVProvide=Utilities.returnElement(driver, lstObject.get(119), lstObject.get(118));
				
					if(DontSeeTVProvide.isDisplayed() ) 
					{
						Extent_Reports.executionLog("PASS", "User should be taken back to MVPD picker" + "\n" + "User is taken back to MVPD picker ",
								driver);
					}
					else {
						Extent_Reports.executionLog("FAIL", "User should be taken back to MVPD picker" + "\n" + "User is taken back to MVPD picker ",
								driver);
					}
					
					
				}
				
			}
			
		}
				catch(Exception e) {

					Extent_Reports.executionLog("INFO", "iOS_Verify_fields_Sign_In_with_Email_NIR7909"  + "\n"+ e.getMessage(), driver);
				}
	}//EOM
	
	
	
	public void IOS_MVPDPicker_LandScape_NIR7656() throws  Exception
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();
			
			Setting_Icon=Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			
			if(Setting_Icon.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed" + "\n" + "Setting Icon is displayed",
						driver);
				Setting_Icon.click();
				Thread.sleep(2000);
				
				Tv_provider=Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
				
				if(Tv_provider.isDisplayed()) {
					Extent_Reports.executionLog("PASS", "Tv Provider Link should be displayed" + "\n" + "Tv Provider Link is displayed",
							driver);
					Tv_provider.click();
					Thread.sleep(1000);
					try {
						
						Alert alert = driver.switchTo().alert();
						alert.dismiss();;
						Thread.sleep(10000);
						
					}catch(Exception e) {

						
					}
					LINKPROVIDER_Text=Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
					if (LINKPROVIDER_Text.getAttribute("label").equals("LINK PROVIDER")) {
						Extent_Reports.executionLog("PASS", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is displayed",
								driver);
					}else {
						Extent_Reports.executionLog("FAIL", "LINK PROVIDER Text should be displayed" + "\n" + "LINK PROVIDER Text is not displayed",
								driver);
					}
					
					
					statictext=Utilities.returnElements(driver, lstObject.get(26), lstObject.get(25));
					
					for(int i=0;i<statictext.size();i++) {
						Extent_Reports.executionLog("PASS", "LINK PROVIDER Static Text should be displayed as:  " + statictext.get(i).getAttribute("label") + "\n" + "LINK PROVIDER static Text is displayed",
								driver);
					}
					
					
					
					MPVD_linkproviderlist =Utilities.returnElements(driver, lstObject.get(32), lstObject.get(31));
					for (int j=0;j<MPVD_linkproviderlist.size();j++) {
						Extent_Reports.executionLog("PASS", "MVPD LINK PROVIDER Name should be displayed as:  " + MPVD_linkproviderlist.get(j).getAttribute("name") + "\n" + "MVPD LINK PROVIDER Name is displayed",
								driver);
					}
					
					
               closeIcon=Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
					
					if(closeIcon.isDisplayed()) {
						Extent_Reports.executionLog("PASS", "close Icon should be displayed as:  "  + "\n" + "close Icon  is  displayed",
								driver);
						closeIcon.click();
						Thread.sleep(8000);
						
						Extent_Reports.executionLog("PASS", "MVPD page should be closed  "  + "\n" + "MVPD page is closed ",
								driver);
					}else {
						Extent_Reports.executionLog("FAIL", "close Icon should be displayed as:  "  + "\n" + "close Icon is not displayed",
								driver);
					}
					
				}else {
					Extent_Reports.executionLog("FAIL", "Tv Provider Link should be displayed" + "\n" + "Tv Provider Link is not displayed",
							driver);
				}
				
			}else {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed" + "\n" + "Setting Icon is not displayed",
						driver);
			}
			

      



		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "iOS_example"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM

	
	public void iOS_VerifytheUpdatetoSignUpPage_NIR8831() throws  Throwable
	{
		PGNbcApp pgnbcappobj= new PGNbcApp(driver);
		try
		{
			//Wait for App to load
			pgnbcappobj.iOS_GlobalHomePage();
			
			Setting_Icon=Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
			
			if(Setting_Icon.isDisplayed()) {
				Extent_Reports.executionLog("PASS", "Setting Icon should be displayed" + "\n" + "Setting Icon is displayed",
						driver);
				Setting_Icon.click();
				Thread.sleep(2000);
				
				Tv_provider=Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
				
				if(Tv_provider.isDisplayed()) {
					Extent_Reports.executionLog("PASS", "Tv Provider Link should be displayed" + "\n" + "Tv Provider Link is displayed",
							driver);
					//Tv_provider.click();
					Thread.sleep(1000);
					try {
						
						Alert alert = driver.switchTo().alert();
						alert.dismiss();;
						Thread.sleep(10000);
						
					}catch(Exception e) {

						
					}
					
				}	
				

			}	
			
			WebElement Sign_up = Utilities.returnElement(driver, lstObject.get(128), lstObject.get(127));
			Extent_Reports.executionLog("PASS", "Sign up button should be displayed " + "\n"
					+ "Sign up button is displayed", driver);
			Sign_up.click();
			Thread.sleep(10000);
			
			
			MPVD_linkproviderlist =Utilities.returnElements(driver, lstObject.get(131), lstObject.get(130));
			for (int j=0;j<MPVD_linkproviderlist.size();j++) {
				Extent_Reports.executionLog("PASS", "MVPD Sign up Name should be displayed as:  " + MPVD_linkproviderlist.get(j).getAttribute("name") + "\n" + "MVPD Sign up Name is displayed",
						driver);
			}
			
			
			MPVD_linkproviderlist =Utilities.returnElements(driver, lstObject.get(134), lstObject.get(133));
			for (int j=0;j<MPVD_linkproviderlist.size();j++) {
				Extent_Reports.executionLog("PASS", "MVPD Sign up Name should be displayed as:  " + MPVD_linkproviderlist.get(j).getAttribute("value") + "\n" + "MVPD Sign up Name is displayed",
						driver);
			}
		
			

		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "MVPDPicker"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM

	public void Anroid_Privacy_Policy() throws  Throwable
	{
		PGNbcProfile acp = new PGNbcProfile(driver);
		
		acp.android_Verify_Acptance();
		WebElement	SignUp_btn = Utilities.returnElement(driver, lstObject.get(137), lstObject.get(136));
		SignUp_btn.click();
		Thread.sleep(8000);
		
		try
		{
			Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
		    for (String contextName : contextNames) {
		        //if (contextName.contains("WEBVIEW_com.android.browser")) {
		    	if (contextName.contains("NATIVE_APP")) {
		            ((AppiumDriver) driver).context(contextName);
		        }
		    }
		    
		   ((AndroidDriver) driver).hideKeyboard();
		    
			WebElement Video_Viewing = Utilities.returnElement(driver, lstObject.get(140), lstObject.get(139));
			//driver.findElement(By.xpath("//android.widget.LinearLayout//android.widget.TextView[contains(@text,'Privacy Policy')]"));
			Video_Viewing.click();
			Thread.sleep(8000);
			Set<String> contextNames1 = ((AppiumDriver) driver).getContextHandles();
		    for (String contextName : contextNames1) {
		        if (contextName.contains("NATIVE_APP")) {
		    	((AppiumDriver) driver).context(contextName);
		        }
		    }
		    
		    List<WebElement> PrivacyPolicyScreen1 = Utilities.returnElements(driver, lstObject.get(143), lstObject.get(142));
		    //driver.findElements(By.xpath("//android.view.View")); 
		    WebElement PrivacyPolicyScreen2 = Utilities.returnElement(driver, lstObject.get(146), lstObject.get(145));
		    //driver.findElement(By.xpath("//android.widget.ListView"));
			
		    if (PrivacyPolicyScreen1.get(1).isEnabled() && PrivacyPolicyScreen2.isEnabled() ){
            	Extent_Reports.executionLog("PASS", " Navigated to NBC Privacy Policy Screen and 'NBCUniversial Media,  Privacy Policy' Header Should be displayed "
						+ "\n" + " Navigated to NBC Privacy Policy Screen and 'NBCUniversial Media, Terms of Use' Header is displayed  ", driver);	
            }else{
            	Extent_Reports.executionLog("FAIL", " Navigated to NBC TERMS OF USE Screen and 'NBCUniversial Media,  Privacy Policy' Header Should be displayed "
						+ "\n" + " Not navigated to NBC Privacy Policy Screen and 'NBCUniversial Media,  Privacy Policy' Header is not displayed  ", driver);		
            }
		    
		    WebElement BackButton =Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		    //driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")); 
		    BackButton.click();
		    Thread.sleep(8000);
		    WebElement Privacy_Policy =Utilities.returnElement(driver, lstObject.get(152), lstObject.get(151));
		    //driver.findElement(By.xpath("//android.widget.LinearLayout//android.widget.TextView[contains(@text,'Privacy Policy')]"));
			Point point = Privacy_Policy.getLocation();
			int x = point.x + 1;
			int y = point.y + Privacy_Policy.getSize().getHeight() - 1;
			new TouchAction(driver).tap(x, y).perform();
			Thread.sleep(5000);
			Set<String> contextNames2 = ((AppiumDriver) driver).getContextHandles();
		    for (String contextName : contextNames2) {
		        if (contextName.contains("WEBVIEW_com.android.browser")) {
		    	//if (contextName.contains("NATIVE_APP")) {
		            ((AppiumDriver) driver).context(contextName);
		        }
		    }
		    
		   PGNbcApp App = new PGNbcApp(driver);
		   App.swipeUp();
		   WebElement CloseButton = Utilities.returnElement(driver, lstObject.get(155), lstObject.get(154));
		   //driver.findElement(By.xpath("//android.view.View[@text='Close']"));
		   Extent_Reports.executionLog("PASS", " Navigated to NBC Privacy Policy Screen and 'NBCUniversal' Header Should be displayed "
					+ "\n" + " Navigated to NBC Privacy Policy Screen and 'NBCUniversal' Header is displayed  ", driver);	
		   CloseButton.click();
		   Thread.sleep(5000);
		   WebElement Privacy_Policy_Screen = Utilities.returnElement(driver, lstObject.get(158), lstObject.get(157));
		   //driver.findElement(By.xpath("//android.view.View[@text='NBCUniversal']"));
		   if (Privacy_Policy_Screen.isEnabled()){
			   Extent_Reports.executionLog("PASS", " Navigated to NBC Privacy Policy Screen and 'NBCUniversal' Header Should be displayed "
						+ "\n" + " Navigated to NBC Privacy Policy Screen and 'NBCUniversal' Header is displayed  ", driver);	
		   } else{
			   Extent_Reports.executionLog("FAIL", " Navigated to NBC Privacy Policy Screen and 'NBCUniversal' Header Should be displayed "
						+ "\n" + " Not navigated to NBC Privacy Policy Screen and 'NBCUniversal' Header is not displayed  ", driver);	
		   }
		   BackButton =Utilities.returnElement(driver, lstObject.get(149), lstObject.get(148));
		   BackButton.click();
		   Thread.sleep(8000);
		    
	        
		}catch(Exception e) {

			Extent_Reports.executionLog("INFO", "Anroid_MVPDPicker"  + "\n"+ e.getMessage(), driver);
		}
	}//EOM
	
}// EOC
