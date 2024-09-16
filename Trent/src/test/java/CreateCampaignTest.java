import org.testng.annotations.Test;

import com.trent.basetestUtility.BaseClass;
import com.trent.generic.objectUtility.CreateCampaignPage;
import com.trent.generic.objectUtility.CreatingNewCampaignPage;
import com.trent.generic.objectUtility.HomePage;

public class CreateCampaignTest extends BaseClass {

	@Test
	public void createCampaignTest() throws Throwable {

		String campaignName = eLib.getdatafromexcelsheet("Sheet1", 2, 2) + jLib.getRandonNumber();
		String assignedToMarketingGroup = eLib.getdatafromexcelsheet("Sheet1", 0, 1);
		String assignedToSupportGroup = eLib.getdatafromexcelsheet("Sheet1", 1, 1);
		String assignedToTeamSelling = eLib.getdatafromexcelsheet("Sheet1", 2, 1);

		HomePage hp = new HomePage(driver);
		hp.clickOnCampaign(); 	
		CreateCampaignPage ccp = new CreateCampaignPage(driver);
		ccp.getCreateCamapignlookupicon().click();
		CreatingNewCampaignPage cncp = new CreatingNewCampaignPage(driver);
		cncp.createNewCampaignWithGroup(campaignName, assignedToMarketingGroup);
		//cncp.createNewCampaignWithUser(campaignName);
	}

}
