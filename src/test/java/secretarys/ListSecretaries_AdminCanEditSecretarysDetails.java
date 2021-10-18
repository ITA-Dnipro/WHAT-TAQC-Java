package secretarys;

import base.BaseTest;
import base.RandomStringsGenerator;
import base.Role;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.base.BasePage;
import page.secretarys.SecretarysDetailsPage;
import page.secretarys.SecretarysPage;



public class ListSecretaries_AdminCanEditSecretarysDetails extends BaseTest{

    SecretarysPage secretarys;
    BasePage basePage;
    RandomStringsGenerator randomStringsGenerator;

    @BeforeClass
    public void preconditions() throws Exception{
        driver.get(Endpoints.BASE_URL);
        secretarys = new SecretarysPage(driver);
    }

    @DataProvider(name = "log-in")
    public Object[][] provideCredentials(){
        return new Object[][]{{Role.ADMIN}};
    }

    @Test(dataProvider = "log-in")
    public void editSecretarys(Role role){

        helper.logInAs(role);

        driver.get(Endpoints.SECRETARYS);

//        SoftAssert softAssert = new SoftAssert();
//        editSecretarysPage.setSoftAssert(softAssert);

        SecretarysDetailsPage secretarysDetailsPage = secretarys.ClickEditButton();

    }


}
