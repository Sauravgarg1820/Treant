package com.trent.generic.objectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	
	public CreateContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement clickOnContactLookupIcon;

	public WebElement getClickOnContactLookupIcon() {
		return clickOnContactLookupIcon;
	}
	
	

}
