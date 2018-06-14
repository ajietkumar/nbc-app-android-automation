

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class PGShowMeHow  {


	public static void main(String args[]) {

		try {
			String udid="LGH630Dc1a1d868";
			String osVersion="5.0";
			String appiumURL = "http://127.0.0.1:" + "4725" + "/wd/hub";
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", udid);
			capabilities.setCapability("udid", udid); //Give Device ID of your mobile phone
			capabilities.setCapability("platformVersion", osVersion);
			capabilities.setCapability("appPackage", "com.nbc.nbcapp");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appActivity", "com.nbc.commonui.activity.DeepLinkActivity");	 
			AppiumDriver appiumDriver = new AndroidDriver(new URL(appiumURL), capabilities);	
			appiumDriver.manage().timeouts().implicitlyWait(72, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(appiumDriver, 50);

			try 
			{
				wait.until( ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.ProgressBar")));
				WebElement objloading =  appiumDriver.findElement(By.xpath("//android.widget.ProgressBar"));
				objloading.click();


			} catch (Exception e) 
			{

				((AndroidDriver)appiumDriver).pressKeyCode(AndroidKeyCode.BACK);

				Thread.sleep(10000);
			}

			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@resource-id,'media_route_button')]")));
			WebElement CastIcon =  appiumDriver.findElement(By.xpath("//android.view.View[contains(@resource-id,'media_route_button')]"));

			CastIcon.click();


			try {
				Thread.sleep(5000);
				WebElement	CastPopUp = appiumDriver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.TextView[contains(@resource-id,'title')]"));

				if (CastPopUp.isDisplayed()) {


					System.out.println("cast pop up is displayed");
					((AndroidDriver)appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
					Thread.sleep(5000);
				} else {


					System.out.println("cast pop up not displayed");
				}
			} catch (Exception e) {
				Thread.sleep(10000);
				((AndroidDriver)appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(5000);

			}
			Thread.sleep(20000);
			wait.until( ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout//android.widget.ImageView[contains(@resource-id,'app_logo')]")));
			WebElement HambergerIcon =  appiumDriver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.ImageView[contains(@resource-id,'app_logo')]"));
			HambergerIcon.click();
			

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView//android.widget.TextView[@text='SETTINGS']")));
			WebElement SettingsMenu = appiumDriver.findElement(By.xpath("//android.widget.ListView//android.widget.TextView[@text='SETTINGS']"));
			

			Thread.sleep(10000);
			if (SettingsMenu.isDisplayed()) {
				
				SettingsMenu.click();
			} else {
			
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='LINK YOUR TV PROVIDER']")));
			WebElement LinkTvProvider = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='LINK YOUR TV PROVIDER']"));
			
			if (LinkTvProvider.isDisplayed()) {
				
				Thread.sleep(5000);
				LinkTvProvider.click();
			} else {
			
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Select your TV Provider']")));
			WebElement MVPDpickerPageTitle = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Select your TV Provider']"));
			
				
			if (MVPDpickerPageTitle.isDisplayed()) 
			{
				
			} else {
				
			}
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='SHOW ME HOW']")));
				WebElement	ShowMeHow = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='SHOW ME HOW']"));
				

				if (ShowMeHow.isDisplayed()) {
					
					Thread.sleep(5000);
					ShowMeHow.click();
				} else {
				}


				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='How to Link']")));
				WebElement selectProvider = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='How to Link']"));
				// Validating Title on How To Link Page
				if ("How to Link".equalsIgnoreCase(selectProvider.getAttribute("text"))) 
				{
					
				} else {
					
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='1. SELECT PROVIDER']")));
				selectProvider = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='1. SELECT PROVIDER']"));
				// Validating Select TV Provider Title on How To Link Page
				if ("1. SELECT PROVIDER".equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					
				} else {
					
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='3. START WATCHING']")));
				WebElement link = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='3. START WATCHING']"));
					
				// Validating Link Title on How To Link Page
				if ("3. START WATCHING".equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					
				} else {
					
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView//android.widget.TextView[@text='LIVE']")));
				WebElement startWatching = appiumDriver.findElement(By.xpath("//android.widget.ListView//android.widget.TextView[@text='LIVE']"));
				// Validating StartWatching Title on How To Link Page	

				if ("2. LINK".equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					
				} else {
					
				}



			} catch (Exception e) {
				System.out.println(e);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='Law & Order: SVU']")));
			WebElement LiveMenu = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='Law & Order: SVU']"));


			if (LiveMenu.isDisplayed()) {
				
				SettingsMenu.click();
			} else {
				
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='LINK YOUR TV PROVIDER']")));
			LinkTvProvider = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='LINK YOUR TV PROVIDER']"));

			if (LinkTvProvider.isDisplayed()) {
				
				Thread.sleep(5000);
				LinkTvProvider.click();
			} else {
				
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='LINK YOUR TV PROVIDER']")));
			MVPDpickerPageTitle = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='LINK YOUR TV PROVIDER']"));

			if (MVPDpickerPageTitle.isDisplayed()) {
				
			} else {
				
			}
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='SHOW ME HOW']")));
				WebElement ShowMeHow = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='SHOW ME HOW']"));

				if (ShowMeHow.isDisplayed()) {
					
					Thread.sleep(5000);
					ShowMeHow.click();
				} else {
					
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='How to Link']")));
				WebElement selectProvider = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='How to Link']"));
				// Validating Title on How To Link Page
				if ("How to Link".equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					
				} else {
					
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='1. SELECT PROVIDER']")));
				selectProvider = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='1. SELECT PROVIDER']"));
				// Validating Select TV Provider Title on How To Link Page
				if ("1. SELECT PROVIDER".equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					
				} else {
					
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='2. LINK']")));
				WebElement link = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='2. LINK']"));
				// Validating Link Title on How To Link Page
				if ("2. LINK".equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					
				} else {
					
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='3. START WATCHING']")));
				WebElement startWatching = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='3. START WATCHING']"));
				// Validating StartWatching Title on How To Link Page
				if ("3. START WATCHING".equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					
				} else {
					
				}




			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {

			System.out.println(e);
		
		}

	}// EOM

}// EOC
