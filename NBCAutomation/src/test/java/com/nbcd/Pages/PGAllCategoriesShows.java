package com.nbcd.Pages;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
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
public class PGAllCategoriesShows {
	public AppiumDriver driver;
	String sql;
	protected static String showDetails;
	DatabaseFunction db = new DatabaseFunction();
	static String screenshotExtension;
	public List<String> lstTestData, lstObject;
	List<WebElement> objShowLists, objShowList;
	String sqlQry, Status;
	WebElement objnav, objRespNavBar, objloading, objClipDropDownWebEx, objShowLink, CastIcon, CastPopUp, ShowsMenu,
			current, HambergerIcon, throwback, ShowsTitle, all;
	List<WebElement> EpisodeCountAll, EpisodeCountCurrent, EpisodeCountThrowback;
	// Constructor to initialize all the Page Objects
	public PGAllCategoriesShows(AppiumDriver driver) throws MalformedURLException {
		this.driver = driver;
		lstTestData = db.getTestDataObject("Select * from PGAllCategoriesShows", "Input");
		lstObject = db.getTestDataObject("Select * from PGAllCategoriesShows", "ObjectRepository");
	}
	// =========================================================================================================================
	@Test
	public void android_VerifyAllCategoriesOfShows_NAF_114() throws  Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			try {
				
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(lstObject.get(4))));
				objloading = Utilities.returnElement(driver, lstObject.get(5), lstObject.get(4));
				objloading.click();
				Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
						driver);
			} catch (Exception e) {
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				Extent_Reports.executionLog("PASS", "Waiting for app to load" + "\n" + "Waiting for app to load",
						driver);
				Thread.sleep(10000);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(7))));
			CastIcon = Utilities.returnElement(driver, lstObject.get(8), lstObject.get(7));
			CastIcon.click();
			Extent_Reports.executionLog("PASS", "Cast icon should be clicked " + "\n" + "Click on cast icon",
					driver);
			try {
				Thread.sleep(5000);
				CastPopUp = Utilities.returnElement(driver, lstObject.get(11), lstObject.get(10)); // WebElement
																											// //
				CastPopUp = driver.findElement(By
						.xpath("//android.widget.FrameLayout/android.widget.TextView[contains(@resource-id,'title')]"));
				if (CastPopUp.isDisplayed()) {
					Extent_Reports.executionLog("PASS",
							"Cast pop up  should be displayed " + "\n" + "Cast pop up  is  displayed", driver);
					System.out.println("cast pop up is displayed");
					((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
					Thread.sleep(5000);
				} else {
					Extent_Reports.executionLog("FAIL",
							"Cast pop up  should be displayed " + "\n" + "Cast pop up  is  displayed", driver);
					System.out.println("cast pop up not displayed");
				}
			} catch (Exception e) {
				Thread.sleep(10000);
				((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
				Thread.sleep(5000);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(13))));
			HambergerIcon = Utilities.returnElement(driver, lstObject.get(14), lstObject.get(13));
			HambergerIcon.click();
			Extent_Reports.executionLog("PASS",
					"Hamberger menu  should be displayed " + "\n" + "Hamberger menu  is displayed", driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(16))));
			ShowsMenu = Utilities.returnElement(driver, lstObject.get(17), lstObject.get(16));
		ShowsMenu.click();
			Thread.sleep(10000);
			Extent_Reports.executionLog("PASS", "Shows menu  should be clicked " + "\n" + "Shows menu is clicked",
					driver);
			try {
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(19))));
				ShowsTitle = Utilities.returnElement(driver, lstObject.get(20), lstObject.get(19));
				if (ShowsTitle.isDisplayed()) {
					Extent_Reports.executionLog("PASS",
							"Shows Title should be displayed " + "\n" + "Shows Title is displayed", driver);
					// break;
				} else {
					Extent_Reports.executionLog("FAIL",
							"Shows Title should be displayed " + "\n" + "Shows Title is not displayed", driver);
				}
			} catch (Exception e) {
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(25))));
			throwback = Utilities.returnElement(driver, lstObject.get(26), lstObject.get(25));
			if (throwback.isDisplayed()) {
				throwback.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS", "Throwback Shows category should be displayed " + "\n"
						+ "Throwback Shows category is displayed", driver);
			} else {
				Extent_Reports.executionLog("FAIL", "Throwback Shows category should be displayed " + "\n"
						+ "Throwback Shows category is not displayed", driver);
			}
			EpisodeCountThrowback = Utilities.returnElements(driver, lstObject.get(32), lstObject.get(31));
			EpisodeCountThrowback.size();
			ArrayList<String> EpisodesListThrowback = new ArrayList<String>();
			for (int i = 0; i < EpisodeCountThrowback.size(); i++) {
				EpisodesListThrowback.add(EpisodeCountThrowback.get(i).getAttribute("text"));
				System.out.println(EpisodesListThrowback);
			}
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(22))));
			current = Utilities.returnElement(driver, lstObject.get(23), lstObject.get(22));
			Thread.sleep(10000);
			if (current.isDisplayed()) {
				current.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS",
						"current Shows category should be displayed " + "\n" + "current Shows category is displayed",
						driver);
			} else {
				Extent_Reports.executionLog("FAIL",
						"current Shows category should be displayed " + "\n" + "current Shows category is displayed",
						driver);
			}
			EpisodeCountCurrent = Utilities.returnElements(driver, lstObject.get(32), lstObject.get(31));
			EpisodeCountCurrent.size();
			ArrayList<String> EpisodesListCurrent = new ArrayList<String>();
			for (int j = 0; j < EpisodeCountCurrent.size(); j++) {
				EpisodesListCurrent.add(EpisodeCountCurrent.get(j).getAttribute("text"));
			}
			Thread.sleep(10000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(lstObject.get(28))));
			all = Utilities.returnElement(driver, lstObject.get(29), lstObject.get(28));
			if (all.isDisplayed()) {
				all.click();
				Thread.sleep(5000);
				Extent_Reports.executionLog("PASS",
						"All Shows category should be displayed " + "\n" + "All Shows category is displayed",
						driver);
				Thread.sleep(10000);
			}
			else {
				Extent_Reports.executionLog("FAIL",
						"All Shows category should be displayed " + "\n" + "All Shows category is not displayed",
						driver);
			}
			EpisodeCountAll = Utilities.returnElements(driver, lstObject.get(32), lstObject.get(31));
			EpisodeCountAll.size();
			ArrayList<String> EpisodesListAll = new ArrayList<String>();
			for (int k = 0; k < EpisodeCountAll.size(); k++) {
				EpisodesListAll.add(EpisodeCountAll.get(k).getAttribute("text"));
			}
			// Checking the availability of current shows in All Shows category
			for (int l = 0; l < EpisodesListAll.size(); l++) {
				if ((EpisodeCountCurrent.get(0).getAttribute("text"))
						.equalsIgnoreCase(EpisodeCountAll.get(l).getAttribute("text"))) {
					System.out.println(EpisodeCountCurrent.get(0).getAttribute("text"));
					System.out.println(EpisodeCountAll.get(0).getAttribute("text"));
					Extent_Reports.executionLog("PASS", "All Shows category should have shows of current category"
							+ "\n" + "All Shows category contains shows of current category", driver);
					break;
				}
				else {
					Extent_Reports.executionLog("FAIL", "All Shows category should contain shows of current category"
							+ "\n" + "All Shows category doesn't have shows from current category", driver);
				}
			}
			// Checking the availability of Throwback shows in All Shows
			// category
			for (int m = 0; m < EpisodesListAll.size(); m++) {
				if (EpisodesListThrowback.get(0).equalsIgnoreCase(EpisodesListAll.get(m))) {
					System.out.println("All Shows validation " + EpisodesListAll.get(m));
					Extent_Reports.executionLog("PASS", "All Shows category should have shows of throwback category"
							+ "\n" + "All Shows category contains shows of throwback category", driver);
					break;
				} else {
					Extent_Reports.executionLog("FAIL", "All Shows category should contain shows of throwback category"
							+ "\n" + "All Shows category doesn't have shows from throwback category", driver);
				}
			}
		} catch (Exception exc) {
			Extent_Reports.executionLog("INFO",
					"android_VerifyAllCategoriesOfShows_NAF_114"  + "\n"+ exc.getMessage(), driver);
			
		}
	}// EOM
}// EOC
