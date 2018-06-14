
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
import com.nbcd.GenericLib.GetWebDriverInstance;
import com.nbcd.GenericLib.Utilities;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class PGAllCategoriesShows {

	public static void main(String args[]) 
	{
		
	
			try {
				
				String udid="LGH630Dc1a1d868";
				String appPackage="com.nbc.nbcapp";
			    String osVersion="5.0";
				String appActivity="com.nbc.commonui.activity.DeepLinkActivity";

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
	
		
		
			try {
				wait.until( ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.ProgressBar")));
				WebElement objloading =  appiumDriver.findElement(By.xpath("//android.widget.ProgressBar"));
				
				objloading.click();
				
			} catch (Exception e) {
				((AndroidDriver) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
				
				Thread.sleep(10000);
			}
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[contains(@resource-id,'media_route_button')]")));
			WebElement CastIcon =  appiumDriver.findElement(By.xpath("//android.view.View[contains(@resource-id,'media_route_button')]"));
			
			CastIcon.click();
			
			try {
				Thread.sleep(5000);
				WebElement	CastPopUp = appiumDriver.findElement(By.xpath("//android.widget.FrameLayout/android.widget.TextView[contains(@resource-id,'title')]"));
				if (CastPopUp.isDisplayed()) {
					
					System.out.println("cast pop up is displayed");
					((AndroidDriver) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
					Thread.sleep(5000);
				} else {
					
					System.out.println("cast pop up not displayed");
				}
			} catch (Exception e) { 
				((AndroidDriver) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(5000);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.FrameLayout//android.widget.ImageView[contains(@resource-id,'app_logo')]")));
			WebElement HambergerIcon = appiumDriver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.ImageView[contains(@resource-id,'app_logo')]"));
			HambergerIcon.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.ListView//android.widget.TextView[@text='SHOWS']")));
			WebElement	ShowsMenu = appiumDriver.findElement(By.xpath("//android.widget.ListView//android.widget.TextView[@text='SHOWS']"));
			ShowsMenu.click();
			Thread.sleep(10000);
		
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='American Ninja Warrior']")));
				WebElement	ShowName = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='American Ninja Warrior']"));
				if (ShowName.isDisplayed()) {
					ShowName.click();
				
				} else {
				}
			} catch (Exception e) {
			}
			// }
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'showDetailListItemRecyclerView')]/android.widget.FrameLayout[@index='0']")));
			WebElement EpisodeVideo = appiumDriver.findElement(By.xpath("//android.support.v7.widget.RecyclerView[contains(@resource-id,'showDetailListItemRecyclerView')]/android.widget.FrameLayout[@index='0']"));
			EpisodeVideo.click();
			
			Thread.sleep(30000);
			TouchAction action = new TouchAction((AndroidDriver) appiumDriver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.RelativeLayout")));
			
			WebElement	vodtap = appiumDriver.findElement(By.xpath("//android.widget.RelativeLayout"));
			
			vodtap.click();
			
			WebElement playPause = appiumDriver.findElement(By.xpath("//android.widget.ToggleButton[contains(@resource-id,'com.nbc.nbcapp:id/togglePlay')]"));
		
			playPause.click();
			Thread.sleep(10000);
			try {
				WebElement	ad = appiumDriver.findElement(By.xpath("//android.widget.TextView[contains(@text,'PLAYING AD')]"));
				
				Thread.sleep(10000);
				if (ad.isDisplayed()) {
					playPause.click();
					Thread.sleep(80000);
				} else {
					Extent_Reports.executionLog("PASS",
							"No Ad is displayed  " + "\n" + "No Ad is displayed ",
							appiumDriver);
				}
			} catch (Exception e) {
				System.out.println("exception occured at progress bar");
				Thread.sleep(10000);
			}
			vodtap.click();
			WebElement GoToShow = appiumDriver.findElement(By.xpath("//android.widget.Button[contains(@text,'GO TO SHOW PAGE')]"));
			if (GoToShow.isDisplayed()) {
				
				Thread.sleep(10000);
			} else {
				
				Thread.sleep(2000);
			}
			// Validating Go to Show Page button on VOD Player
			GoToShow.click();
			try {
				
				WebElement ShowName = appiumDriver.findElement(By.xpath("//android.widget.TextView[@text='American Ninja Warrior']"));
				Thread.sleep(10000);
				if (ShowName.isDisplayed()) {
					Thread.sleep(10000);
				} else {
					Thread.sleep(2000);
				}
			} catch (Exception e) {
				System.out.println("exception occured at progress bar");
				Thread.sleep(10000);
			}
			((AndroidDriver) appiumDriver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(3000);
			appiumDriver.quit();
		
		
		}
		catch (Exception e) {
			
			System.out.println(e);
		}
	
			}//EOM
	
	
	
}// EOC