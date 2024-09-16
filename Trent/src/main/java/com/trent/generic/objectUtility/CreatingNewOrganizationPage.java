package com.trent.generic.objectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrganizationPage {

	public CreatingNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@name=\"accountname\"]")
	private WebElement organizationName;
	
	@FindBy(xpath = "(//input[@class=\"crmbutton small save\"])[1]")
	private WebElement saveBtn;

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	

}
