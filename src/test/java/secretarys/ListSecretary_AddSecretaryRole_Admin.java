package secretarys;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.secretarys.SecretarysPage;
import page.unassigned.UnassignedRole;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ListSecretary_AddSecretaryRole_Admin extends BaseTest {
    UnassignedUser secretary;
    SecretarysPage secretarysPage;

    public ListSecretary_AddSecretaryRole_Admin(){ secretary = UnassignedUser.getUnassignedUser();}

    @BeforeClass
    public void setUp() throws IOException{
        secretarysPage = AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(secretary)
                .logInAs(Role.SECRETARY, SecretarysPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.SECRETARY,SecretarysPage.class)
                .isAtPage(waitTime);
            }

            @Test(description = "1")
    public void AddSecretaryRole_Admin(){
                List<String> exceptData= Arrays.asList(secretary.getFirstName(),secretary.getLastName(),secretary.getEmail());
               secretarysPage
                       .addSecretary()
                       .isAtPage(waitTime)
                       .addRole(secretary.getEmail(), UnassignedRole.SECRETARY)
                       .redirectTo(Endpoints.SECRETARY, SecretarysPage.class)
                       .isAtPage(waitTime)
                       .inputSearchSecretary(secretary.getFirstName()+" "+ secretary.getLastName())
                       .verifyInputSearchSecretary(secretary.getFirstName()+ "" + secretary.getLastName())
                       .verifySecretarysDataInTheTable(exceptData)
                       .assertAll();


            }
}

