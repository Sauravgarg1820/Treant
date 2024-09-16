package com.trent.generic.objectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	WebDriver driver;

	public CreateCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement createCamapignlookupicon;

	public WebElement getCreateCamapignlookupicon() {
		return createCamapignlookupicon;
	}
	
	

}
