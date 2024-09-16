package com.trent.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {
	
	/** Implicit & Explicit Wait**/

	public void waitforpageload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/** Switch to tab via title or current Url **/

	public void switchToTabonTitle(WebDriver driver, String Partialtxt) {
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while (it.hasNext()) {
			String windowId = it.next();
			driver.switchTo().window(windowId);
			String title = driver.getTitle();
			if (title.contains(Partialtxt)) {
				break;
			}
		}
	}

	public void switchToTabonUrl(WebDriver driver, String url) {
		Set<String> allid = driver.getWindowHandles();
		Iterator<String> it = allid.iterator();
		while (it.hasNext()) {
			String windowid = it.next();
			driver.switchTo().window(windowid);
			String curl = driver.getCurrentUrl();
			if (curl.contains(url)) {
				break;
			}

		}
	}

	/** Dropdown method and using action class**/
	
	public void selectByVisibleText(WebElement element, String VisibleText) {
		Select select = new Select(element);
		select.selectByVisibleText(VisibleText);
	}

	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void moveOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

	public void contextClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}

	/** Switching Frame & Accept/dismiss**/
	
	public void switchToalertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToalertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);

	}

	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
}