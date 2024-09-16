package com.trent.generic.objectUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trent.generic.webdriverutility.WebdriverUtility;

public class CreatingNewContactPage extends WebdriverUtility {

	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@name=\"lastname\"]")
	private WebElement lastName;

	@FindBy(xpath = "(//img[@src=\"themes/softed/images/select.gif\"])[1]")
	private WebElement organizationLookupIcon;

	@FindBy(xpath = "//input[@name=\"search_text\"]")
	private WebElement searchArea;

	@FindBy(xpath = "//input[@class=\"crmbutton small create\"]")
	private WebElement searchNowBtn;

	@FindBy(xpath = "//a[@href=\"javascript:window.close();\"]")
	private WebElement searchedOrganizationName;

	@FindBy(xpath = "//input[@class=\"crmButton small save\"]")
	private WebElement saveBtn;

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrganizationLookupIcon() {
		return organizationLookupIcon;
	}

	public WebElement getSearchArea() {
		return searchArea;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getSearchedOrganizationName() {
		return searchedOrganizationName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}



}
