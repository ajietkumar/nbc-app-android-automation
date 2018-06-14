package com.nbcd.Pages;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

//import io.appium.java_client.driver;
import com.codoid.products.exception.FilloException;
import com.nbcd.GenericLib.DatabaseFunction;
import com.nbcd.GenericLib.Extent_Reports;
import com.nbcd.GenericLib.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class PGShowMeHow  {




	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> objShowLists, objShowList;
	String sqlQry, Status;
	WebElement objnav, objRespNavBar, objloading, objClipDropDownWebEx, objShowLink, SettingsMenu, CastIcon, CastPopUp,
	ShowsMenu, current, HambergerIcon, throwback, ShowsTitle, all, LinkTvProvider, LiveMenu, EntVod,
	MVPDpickerPageTitle, ShowMeHow, selectProvider, Continue,link, startWatching,LinkTvProviderForkScreen;
	List<WebElement> EpisodeCountAll, EpisodeCountCurrent, EpisodeCountThrowback;

	private AppiumDriver driver;



	public PGShowMeHow(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGShowMeHow", "Input");
		lstObject = db.getTestDataObject("Select * from PGShowMeHow", "ObjectRepository");

	}

	// =========================================================================================================================

	@Test
	public void android_VerifyHowCanWeHelp_NAF_4728() throws  Exception {

		try {

			WebDriverWait wait = new WebDriverWait(driver, 50);

			try {
				//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("android.widget.ProgressBar")));
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(4))));
				objloading = Utilities.returnElement(driver, lstObject.get(5), lstObject.get(4));
				objloading.click();

				//Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",driver);
			} catch (Exception e) {

				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				//Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
				//	driver);
				Thread.sleep(10000);
			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(7))));
			CastIcon = Utilities.returnElement(driver, lstObject.get(8), lstObject.get(7));

			CastIcon.click();
			//Extent_Reports.executionLog("PASS", "Cast icon should be clicked " + "\n" + "Click on cast icon",
			//		driver);

			try {
				Thread.sleep(5000);
				CastPopUp = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10)); 
				driver.findElement(By
						.xpath("//android.widget.FrameLayout/android.widget.TextView[contains(@resource-id,'title')]"));
				if (CastPopUp.isDisplayed()) {
					//Extent_Reports.executionLog("PASS",
					//		"Cast pop up  should be displayed " + "\n" + "Cast pop up  is  displayed", driver);

					System.out.println("cast pop up is displayed");
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
					Thread.sleep(5000);
				} else {
					//	Extent_Reports.executionLog("FAIL",
					//			"Cast pop up  should be displayed " + "\n" + "Cast pop up  is  displayed", driver);

					System.out.println("cast pop up not displayed");
				}
			} catch (Exception e) {
				Thread.sleep(10000);
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(5000);

			}
			Thread.sleep(20000);
			/*	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(13))));
HambergerIcon = Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));

HambergerIcon.click();
Extent_Reports.executionLog("PASS",
		"Hamberger menu  should be displayed " + "\n" + "Hamberger menu  is displayed", driver);

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(16))));
SettingsMenu = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));

Thread.sleep(10000);
if (SettingsMenu.isDisplayed()) {
	Extent_Reports.executionLog("PASS",
			"Settings menu  should be displayed " + "\n" + "Settings menu is displayed", driver);
	SettingsMenu.click();
} else {
	Extent_Reports.executionLog("PASS",
			"Settings menu  should be displayed " + "\n" + "Settings menu is not displayed", driver);
}

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(19))));
LinkTvProvider = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));

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
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(22))));
MVPDpickerPageTitle = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
if (MVPDpickerPageTitle.isDisplayed()) {
	Extent_Reports.executionLog("PASS",
			"Select Tv Provider should be displayed " + "\n" + "Select Tv Provider is displayed",
			driver);
} else {
	Extent_Reports.executionLog("PASS",
			"Select Tv Provider should be displayed " + "\n" + "Select Tv Provider is not displayed",
			driver);
}
try {
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(25))));
	ShowMeHow = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
	if (ShowMeHow.isDisplayed()) {
		Extent_Reports.executionLog("PASS",
				"ShowMeHow Hyperlink should be displayed " + "\n" + "ShowMeHow Hyperlink  Tab is displayed",
				driver);
		Thread.sleep(5000);
		ShowMeHow.click();
	} else {
		Extent_Reports.executionLog("PASS",
				"ShowMeHow Hyperlink should be displayed " + "\n" + "ShowMeHow Hyperlink  is not displayed",
				driver);
	}


	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(31))));
	selectProvider = Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
	// Validating Title on How To Link Page
	if (lstTestData.get(3).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
		Extent_Reports.executionLog("PASS",
				"How To Link Title  should be displayed " + "\n" + "How To Link title is displayed",
				driver);
	} else {
		Extent_Reports.executionLog("FAIL",
				"How To Link title  should be displayed " + "\n" + "How To Link title is not displayed",
				driver);
	}

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
	selectProvider = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
	// Validating Select TV Provider Title on How To Link Page
	if (lstTestData.get(0).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
		Extent_Reports.executionLog("PASS", "Select TV Provider title  should be displayed " + "\n"
				+ "Select TV Provider title is displayed", driver);
	} else {
		Extent_Reports.executionLog("FAIL", "Select TV Provider title  should be displayed " + "\n"
				+ "Select TV Provider title is not displayed", driver);
	}

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(37))));
	link = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
	// Validating Link Title on How To Link Page
	if (lstTestData.get(1).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
		Extent_Reports.executionLog("PASS",
				"Link Title  should be displayed " + "\n" + "Link Title  is displayed", driver);
	} else {
		Extent_Reports.executionLog("FAIL",
				"Link Title  should be displayed " + "\n" + "Link Title is not displayed", driver);
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(40))));
	startWatching = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40)); 
	// Validating StartWatching Title on How To Link Page	

	if (lstTestData.get(2).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
		Extent_Reports.executionLog("PASS",
				"startWatching title  should be displayed " + "\n" + "startWatching title is displayed",
				driver);
	} else {
		Extent_Reports.executionLog("FAIL",
				"startWatching title  should be displayed " + "\n" + "startWatching title is not displayed",
				driver);
	}



} catch (Exception e) {
	System.out.println(e);
}
for(int i=0;i<=3;i++){
	((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);

}
HambergerIcon.click();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(43))));
LiveMenu = Utilities.returnElement(driver, lstObject.get(44), lstObject.get(43));

if (LiveMenu.isDisplayed()) {
	Extent_Reports.executionLog("PASS",
			"Settings menu  should be displayed " + "\n" + "Settings menu is displayed", driver);
	LiveMenu.click();
} else {
	Extent_Reports.executionLog("PASS",
			"Settings menu  should be displayed " + "\n" + "Settings menu is not displayed", driver);
}


wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(22))));
MVPDpickerPageTitle = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
if (MVPDpickerPageTitle.isDisplayed()) {
	Extent_Reports.executionLog("PASS",
			"Select Tv Provider should be displayed " + "\n" + "Select Tv Provider is displayed",
			driver);
} else {
	Extent_Reports.executionLog("PASS",
			"Select Tv Provider should be displayed " + "\n" + "Select Tv Provider is not displayed",
			driver);
}

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(25))));
	ShowMeHow = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
	if (ShowMeHow.isDisplayed()) {
		Extent_Reports.executionLog("PASS",
				"ShowMeHow Hyperlink should be displayed " + "\n" + "ShowMeHow Hyperlink  Tab is displayed",
				driver);
		Thread.sleep(5000);
		ShowMeHow.click();
	} else {
		Extent_Reports.executionLog("PASS",
				"ShowMeHow Hyperlink should be displayed " + "\n" + "ShowMeHow Hyperlink  is not displayed",
				driver);
	}

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(31))));
	selectProvider = Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
	// Validating Title on How To Link Page
	if (lstTestData.get(4).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
		Extent_Reports.executionLog("PASS",
				"How To Link Title  should be displayed " + "\n" + "How To Link title is displayed",
				driver);
	} else {
		Extent_Reports.executionLog("FAIL",
				"How To Link title  should be displayed " + "\n" + "How To Link title is not displayed",
				driver);
	}

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
	selectProvider = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
	// Validating Select TV Provider Title on How To Link Page
	if (lstTestData.get(0).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
		Extent_Reports.executionLog("PASS", "Select TV Provider title  should be displayed " + "\n"
				+ "Select TV Provider title is displayed", driver);
	} else {
		Extent_Reports.executionLog("FAIL", "Select TV Provider title  should be displayed " + "\n"
				+ "Select TV Provider title is not displayed", driver);
	}

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(37))));
	link = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
	// Validating Link Title on How To Link Page
	if (lstTestData.get(1).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
		Extent_Reports.executionLog("PASS",
				"Link Title  should be displayed " + "\n" + "Link Title  is displayed", driver);
	} else {
		Extent_Reports.executionLog("FAIL",
				"Link Title  should be displayed " + "\n" + "Link Title is not displayed", driver);
	}
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(40))));
	startWatching = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
	// Validating StartWatching Title on How To Link Page
	if (lstTestData.get(2).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
		Extent_Reports.executionLog("PASS",
				"startWatching title  should be displayed " + "\n" + "startWatching title is displayed",
				driver);
	} else {
		Extent_Reports.executionLog("FAIL",
				"startWatching title  should be displayed " + "\n" + "startWatching title is not displayed",
				driver);
	}

for(int j=0;j<=2;j++)
{
	((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
}*/
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(13))));
			HambergerIcon.click();
			Thread.sleep(3000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(52))));
			ShowsMenu = Utilities.returnElement(driver, lstObject.get(53), lstObject.get(52));
			ShowsMenu.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(58))));
			EntVod = Utilities.returnElement(driver, lstObject.get(59), lstObject.get(58));
			EntVod.click();


			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(61))));
			Continue = Utilities.returnElement(driver, lstObject.get(62), lstObject.get(61));

			if(Continue.isDisplayed()){
				Dimension size = driver.manage().window().getSize();
				int starty = (int) (size.height * 0.80);
				int endy = (int) (size.height * 0.20);
				int startx = size.width / 2;
				System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

				//driver.swipe(startx, starty, startx, endy, 3000);
				Thread.sleep(2000);
				//driver.swipe(startx, endy, startx, starty, 3000);
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(64))));
				LinkTvProviderForkScreen = Utilities.returnElement(driver, lstObject.get(65), lstObject.get(64));
				LinkTvProviderForkScreen.click();


			}

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(22))));
			MVPDpickerPageTitle = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
			if (MVPDpickerPageTitle.isDisplayed()) {
				//Extent_Reports.executionLog("PASS",
				//		"Select Tv Provider should be displayed " + "\n" + "Select Tv Provider is displayed",
				//		driver);
			} else {
				//Extent_Reports.executionLog("PASS",
				//		"Select Tv Provider should be displayed " + "\n" + "Select Tv Provider is not displayed",
				//		driver);
			}
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(25))));
				ShowMeHow = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
				if (ShowMeHow.isDisplayed()) {
					//	Extent_Reports.executionLog("PASS",
					//			"ShowMeHow Hyperlink should be displayed " + "\n" + "ShowMeHow Hyperlink  Tab is displayed",
					//			driver);
					Thread.sleep(5000);
					ShowMeHow.click();
				} else {
					//	Extent_Reports.executionLog("PASS",
					//			"ShowMeHow Hyperlink should be displayed " + "\n" + "ShowMeHow Hyperlink  is not displayed",
					//			driver);
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(31))));
				selectProvider = Utilities.returnElement(driver, lstObject.get(32), lstObject.get(31));
				// Validating Title on How To Link Page
				if (lstTestData.get(4).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					//Extent_Reports.executionLog("PASS",
					//		"How To Link Title  should be displayed " + "\n" + "How To Link title is displayed",
					//		driver);
				} else {
					//Extent_Reports.executionLog("FAIL",
					//		"How To Link title  should be displayed " + "\n" + "How To Link title is not displayed",
					//		driver);
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(34))));
				selectProvider = Utilities.returnElement(driver, lstObject.get(35), lstObject.get(34));
				// Validating Select TV Provider Title on How To Link Page
				if (lstTestData.get(0).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					//Extent_Reports.executionLog("PASS", "Select TV Provider title  should be displayed " + "\n"
					//		+ "Select TV Provider title is displayed", driver);
				} else {
					//Extent_Reports.executionLog("FAIL", "Select TV Provider title  should be displayed " + "\n"
					//		+ "Select TV Provider title is not displayed", driver);
				}

				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(37))));
				link = Utilities.returnElement(driver, lstObject.get(38), lstObject.get(37));
				// Validating Link Title on How To Link Page
				if (lstTestData.get(1).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					Extent_Reports.executionLog("PASS",
							"Link Title  should be displayed " + "\n" + "Link Title  is displayed", driver);
				} else {
					Extent_Reports.executionLog("FAIL",
							"Link Title  should be displayed " + "\n" + "Link Title is not displayed", driver);
				}
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(40))));
				startWatching = Utilities.returnElement(driver, lstObject.get(41), lstObject.get(40));
				// Validating StartWatching Title on How To Link Page
				if (lstTestData.get(2).equalsIgnoreCase(selectProvider.getAttribute("text"))) {
					//	Extent_Reports.executionLog("PASS",
					//			"startWatching title  should be displayed " + "\n" + "startWatching title is displayed",
					//driver);
				} else {
					//	Extent_Reports.executionLog("FAIL",
					//			"startWatching title  should be displayed " + "\n" + "startWatching title is not displayed",
					//			driver);
				}




			} catch (Exception e) {
				System.out.println(e);
			}

		} catch (Exception e) {

			Extent_Reports.executionLog("INFO", "android_VerifyHowCanWeHelp_NAF_4728"  + "\n"+ e.getMessage(), driver);
		}

	}// EOM

}// EOC