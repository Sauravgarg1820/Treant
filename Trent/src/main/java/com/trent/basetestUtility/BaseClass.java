package com.trent.basetestUtility;

import org.testng.annotations.AfterClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.trent.databaseUtility.DataBaseUtility;
import com.trent.generic.fileutility.ExcelUtility;
import com.trent.generic.fileutility.Fileutility;
import com.trent.generic.objectUtility.HomePage;
import com.trent.generic.objectUtility.LoginPage;
import com.trent.generic.webdriverutility.JavaUtility;
import com.trent.generic.webdriverutility.UtilityClassObject;
import com.trent.generic.webdriverutility.WebdriverUtility;

public class BaseClass {

	public static WebDriver driver;
	// object creation
	public DataBaseUtility dLib = new DataBaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public Fileutility fLib = new Fileutility();
	public JavaUtility jLib = new JavaUtility();
	public WebdriverUtility wLib = new WebdriverUtility();
	public static WebDriver sdriver=null;

	@BeforeSuite
	public void configBS() throws Throwable {

		System.out.println("Connect To DB");
		dLib.getDBConnection();

	}

	@BeforeClass
	public void configBC() throws Throwable {
		String BROWSER = System.getProperty("browsser", fLib.getdatafrompropertyfile("browser"));         
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();

		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		
	}

	@BeforeMethod
	public void configBM() throws Throwable {
		String URL = System.getProperty("url", fLib.getdatafrompropertyfile("url"));
		String USERNAME = System.getProperty("username", fLib.getdatafrompropertyfile("username"));
		String PASSWORD = System.getProperty("password", fLib.getdatafrompropertyfile("password"));
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod
	public void configAM() {
		HomePage hp = new HomePage(driver);
		// hp.logout();
	}

	@AfterClass
	public void configAC() {
		driver.quit();
	}

	@AfterSuite
	public void configAS() throws Throwable {
		dLib.closeDBConnection();
	}

}
