package com.nbcd.GenericLib;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;



public class Synchronization 
{   
	
	static WebDriverWait wait;
	static WebElement elements;	
	static boolean element;	
    private enum  Property 
    {
    	clickable, visible,invisible,display;
    }
    
 
 //==============================================================================================================================
  
    public static boolean  explicitWait(AppiumDriver driver,WebElement objectID,String objectProperty)
    {
        
        wait = new WebDriverWait(driver, 90);
        Property objProp = Property.valueOf(objectProperty.toLowerCase()); 
        switch(objProp)
        {
            case clickable:
                 elements = wait.until(ExpectedConditions.elementToBeClickable(objectID));
                 break;
                
            case visible:
                 elements = wait.until(ExpectedConditions.visibilityOf(objectID));
                 break;
            case display:
                 elements = wait.until(ExpectedConditions.visibilityOf(objectID));
                 break;
        }
        return elements != null;
        
    }
	
//==============================================================================================================================

	public static boolean ExplicitWait(AppiumDriver driver, String locatorPath, String objectProperty)
	{
		
		wait = new WebDriverWait(driver, 40);
		Property objProp = Property.valueOf(objectProperty.toLowerCase()); 
		switch (objProp) 
		{
		
			case clickable:
				 elements = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorPath)));
				 break;
				 
				 
			case visible:
				 elements = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorPath)));
				 break;
				 
			case invisible:
				 element = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locatorPath)));
				 break;
				 
			
		}
		return elements != null;		
	}
	
//================================================================================================================================	
	public static void implicitWait(AppiumDriver driver,int Secs)
	{

			driver.manage().timeouts().implicitlyWait(Secs, TimeUnit.SECONDS);
	}
	
//================================================================================================================================
	public static boolean waitForPageLoad(AppiumDriver driver) 
	{

		JavascriptExecutor je = (JavascriptExecutor) driver;
		int waitTime = 3 ;
		int counter =0;
		counter=0;
		Number ajaxCount=-1;
		boolean flag=false;
		do{
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			counter +=1;

			try 
			{
				flag=((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				//ajaxCount=(Number) ((je)).executeScript("return dwr.engine._batchesLength");
				Thread.sleep(1000);
			} catch (Exception e) {
				
			}



		}while(flag==false && counter <waitTime);

		return false;

		
	}

	public List<String> lstObject;

}
