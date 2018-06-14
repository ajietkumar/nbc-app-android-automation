package com.nbcd.Pages;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
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
public class PGAppSchedule  {
	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> Schedule_DateList;
	String sqlQry, Status;
	WebElement Schedule_icon,Schedule_Text;
	// Constructor to initialize all the Page Objects
	public PGAppSchedule(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		//lstTestData = db.getTestDataObject("Select * from PGAppSchedule", "Input");
		lstObject = db.getTestDataObject("Select * from PGAppSchedule", "ObjectRepository");
	}
	// =========================================================================================================================
	@SuppressWarnings("deprecation")
	@Test
	public void iOS_Verify_Day_Selector_Scrolling_NIR7670() throws  Exception {
		try
		{

			PGNbcApp pgncapp= new PGNbcApp(driver);
			pgncapp.iOS_GlobalHomePage();
			
			Schedule_icon  =  Utilities.returnElement(driver, lstObject.get(2), lstObject.get(1));
			Schedule_icon.click();
			Thread.sleep(5000);
			Extent_Reports.executionLog("PASS", "Navigated to Schedule page and Schedule header should be Displayed " + "\n"
					+ "Navigated to Schedule page and Schedule header is Displayed", driver);
			
			Schedule_Text  =  Utilities.returnElement(driver, lstObject.get(5), lstObject.get(4));
			if (Schedule_Text.isEnabled()) {
				
				Extent_Reports.executionLog("PASS", "Navigated to Schedule page and Schedule header should be Displayed " + "\n"
						+ "Navigated to Schedule page and Schedule header is Displayed", driver);
			}
			else 
			{
				Extent_Reports.executionLog("FAIL", "Navigated to Schedule page and Schedule header should be Displayed " + "\n"
						+ "Not Navigated to Schedule page and Schedule header is not Displayed", driver);
			}
			
			
		
			  try 
				{
					List<WebElement> Schedule_ProgramList  =  Utilities.returnElements(driver, lstObject.get(11), lstObject.get(10));
					for(int i=0;i<Schedule_ProgramList.size();i++)
					{
					   //Schedule_ProgramList  =  Utilities.returnElements(driver, lstObject.get(11), lstObject.get(10));
						JavascriptExecutor jse=  (JavascriptExecutor) driver;
						HashMap scobj= new HashMap(); 
						scobj.put("direction","down");
						scobj.put("element",Schedule_ProgramList.get(4));
						jse.executeScript("mobile:scroll",scobj);
						//Thread.sleep(1000);
						
						Extent_Reports.executionLog("PASS", "The user should able to scroll vertically " + "\n"
								+ "The user is able to scroll vertically ", driver);
						if (i==Schedule_ProgramList.size())
						{
		                  	break;
						}

					}
				}
				catch(Exception e)
				{
					Extent_Reports.executionLog("INFO", "iOS_scrollDown"  + "\n"+ e.getMessage(), driver);
				}
			
			
			//XCUIElementTypeStaticText[@name='Schedule-Label-DateCellDayOfWeek']
			
			
			try 
			{
				Schedule_DateList  =  Utilities.returnElements(driver, lstObject.get(8), lstObject.get(7));
				for(int i=0;i<5;i++)
				{
					JavascriptExecutor jse=  (JavascriptExecutor) driver;
					HashMap scobj= new HashMap(); 
					scobj.put("direction","right");
					scobj.put("element",Schedule_DateList.get(2));
					jse.executeScript("mobile:scroll",scobj);
					//Thread.sleep(1000);
					Extent_Reports.executionLog("PASS", "The day selector scroll should move to next day with highliting the day in blue color  " + "\n"
							+ "The day selector scroll is moved to next day with highliting the day in blue color ", driver);
					if (i==4)
					{
	                  	break;
					}
					

				}
			}
			catch(Exception e)
			{
				Extent_Reports.executionLog("INFO", "iOS_scrollDown"  + "\n"+ e.getMessage(), driver);
			}
			
			//pgncapp.iOS_scroll(Schedule_DateList.get(2), Schedule_DateList.get(4),"right");
			
			
			
		}
		catch(Exception e) {
			Extent_Reports.executionLog("INFO", "iOS_Verifythe_text_in_Favorites_page_NIR7667"  + "\n"+ e.getMessage(), driver);
			
		}
		
	}// EOM
	
		
	
	
}// EOC
