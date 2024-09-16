package pac;
import org.testng.annotations.Test;

import com.trent.basetestUtility.BaseClass;
import com.trent.generic.objectUtility.CreateOrganizationPage;
import com.trent.generic.objectUtility.CreatingNewOrganizationPage;
import com.trent.generic.objectUtility.HomePage;

public class CreateOrganizationTest extends BaseClass{
	
	@Test(groups = "smoke")
	public void createOrganizationTest() throws Throwable {
		String organizationName = eLib.getdatafromexcelsheet("Sheet1", 0, 3)+jLib.getRandonNumber();
		HomePage hp=new HomePage(driver);
		hp.getOrganization().click();
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.getClickOnOrganizationLookupIcon().click();
		CreatingNewOrganizationPage cnop= new CreatingNewOrganizationPage(driver);
		cnop.getOrganizationName().sendKeys(organizationName);
		cnop.getSaveBtn().click();
	}

}
