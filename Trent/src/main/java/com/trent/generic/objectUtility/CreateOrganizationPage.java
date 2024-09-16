package com.trent.generic.objectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {
	WebDriver driver;

	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement clickOnOrganizationLookupIcon;

	public WebElement getClickOnOrganizationLookupIcon() {
		return clickOnOrganizationLookupIcon;
	}
	
	

}
