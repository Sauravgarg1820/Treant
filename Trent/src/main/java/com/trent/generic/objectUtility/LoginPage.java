package com.trent.generic.objectUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.trent.generic.webdriverutility.WebdriverUtility;

public class LoginPage extends WebdriverUtility {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(name = "user_name")
	private WebElement usernamepom;

	@FindBy(name = "user_password")
	private WebElement passwordpom;

	@FindBy(id = "submitButton")
	private WebElement loginBtn;
	

	
	
	
	
	public WebElement getUsernamepom() {
		return usernamepom;
	}






	public WebElement getPasswordpom() {
		return passwordpom;
	}






	public WebElement getLoginBtn() {
		return loginBtn;
	}






	public void loginToApp(String url, String username, String password) {
		waitforpageload(driver);
		driver.manage().window().maximize();
		driver.get(url);
		usernamepom.sendKeys(username);
		passwordpom.sendKeys(password);
		loginBtn.click();

	}
}
