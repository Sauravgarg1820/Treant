package com.trent.generic.objectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(linkText = "Leads")
	private WebElement leads;

	@FindBy(linkText = "Organizations")
	private WebElement organization;

	@FindBy(linkText = "Contacts")
	private WebElement contacts;

	@FindBy(linkText = "More")
	private WebElement more;

	@FindBy(linkText = "Campaigns")
	private WebElement campaign;

	@FindBy(xpath = "//img[@src=\"themes/softed/images/user.PNG\"]")
	private WebElement administrator;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutBtn;

	public WebElement getLeads() {
		return leads;
	}

	public void setLeads(WebElement leads) {
		this.leads = leads;
	}

	public WebElement getOrganization() {
		return organization;
	}

	public void setOrganization(WebElement organization) {
		this.organization = organization;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public void setContacts(WebElement contacts) {
		this.contacts = contacts;
	}

	public WebElement getMore() {
		return more;
	}

	public void setMore(WebElement more) {
		this.more = more;
	}

	public WebElement getCampaign() {
		return campaign;
	}

	public void setCampaign(WebElement campaign) {
		this.campaign = campaign;
	}

	public WebElement getAdministrator() {
		return administrator;
	}

	public void setAdministrator(WebElement administrator) {
		this.administrator = administrator;
	}

	public WebElement getSignoutBtn() {
		return signoutBtn;
	}

	public void setSignoutBtn(WebElement signoutBtn) {
		this.signoutBtn = signoutBtn;
	}

	public void clickOnCampaign() {
		Actions action = new Actions(driver);
		action.moveToElement(more).perform();
		campaign.click();
	}

	public void logout() {
		Actions action = new Actions(driver);
		action.moveToElement(administrator).perform();;
		signoutBtn.click();

	}

}
