package pac;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.trent.basetestUtility.BaseClass;
import com.trent.generic.objectUtility.CreateContactPage;
import com.trent.generic.objectUtility.CreateOrganizationPage;
import com.trent.generic.objectUtility.CreatingNewContactPage;
import com.trent.generic.objectUtility.CreatingNewOrganizationPage;
import com.trent.generic.objectUtility.HomePage;

public class CreateContactTest extends BaseClass{

	@Test
	public void createContactTest() throws Throwable {
		//create organization
		String organizationName = eLib.getdatafromexcelsheet("Sheet1", 0, 3)+jLib.getRandonNumber();
		HomePage hp=new HomePage(driver);
		hp.getOrganization().click();
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.getClickOnOrganizationLookupIcon().click();
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.getOrganizationName().sendKeys(organizationName);
		cnop.getSaveBtn().click();
		
		Thread.sleep(2000);
		//create contact

		hp= new HomePage(driver);
		hp.getContacts().click();
		CreateContactPage ccp= new CreateContactPage(driver);
		ccp.getClickOnContactLookupIcon().click();
		String lName = eLib.getdatafromexcelsheet("Sheet1", 1, 0);
		//String orgName = eLib.getdatafromexcelsheet("Sheet1", 2, 3);
		CreatingNewContactPage cncp= new CreatingNewContactPage(driver);
		cncp.getLastName().sendKeys(lName);
		cncp.getOrganizationLookupIcon().click();
		wLib.switchToTabonUrl(driver, "module=Accounts&action=Popup&popuptype");
		cncp.getSearchArea().sendKeys(organizationName);
		cncp.getSearchNowBtn().click();
		driver.findElement(By.xpath("//a[text()='"+organizationName+"']")).click();
		wLib.switchToTabonUrl(driver, "module=Contacts&action=EditView&return_action=DetailView");
		cncp.getSaveBtn().click();
		
		
		
		
		
		
		
		
	}
}
