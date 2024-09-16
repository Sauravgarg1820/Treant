package com.trent.generic.objectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.trent.generic.webdriverutility.WebdriverUtility;

public class CreatingNewCampaignPage extends WebdriverUtility{
	WebDriver driver;

	public CreatingNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@name=\"campaignname\"]")
	private WebElement campaignnametf;

	@FindBy(xpath = "(//input[@name=\"assigntype\"])[1]")
	private WebElement userRadioBtn;

	@FindBy(xpath = "(//input[@name=\"assigntype\"])[2]")
	private WebElement groupRadioBtn;

	@FindBy(xpath = "//select[@name=\"assigned_group_id\"]")
	private WebElement multipledropdown;

	@FindBy(xpath = "(//input[@class=\"crmbutton small save\"])[1]")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCampaignnametf() {
		return campaignnametf;
	}

	public WebElement getUserdropdown() {
		return userRadioBtn;
	}

	public WebElement getGroupdropdown() {
		return groupRadioBtn;
	}

	public WebElement getMultipledropdown() {
		return multipledropdown;
	}
    
	public void createNewCampaignWithGroup(String CampaignName, String groupName) {
		campaignnametf.sendKeys(CampaignName);
		groupRadioBtn.click();
		selectByVisibleText(multipledropdown, groupName);
		saveButton.click();
	}
	public void createNewCampaignWithUser(String CampaignName) {
		campaignnametf.sendKeys(CampaignName);
		userRadioBtn.click();
		saveButton.click();
	}
	
}
