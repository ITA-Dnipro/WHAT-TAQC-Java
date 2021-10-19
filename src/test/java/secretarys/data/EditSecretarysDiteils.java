package secretarys.data;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.secretarys.SecretariesPage;
import page.secretarys.SecretarysEditDetailsTab;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;

public class EditSecretarysDiteils extends BaseTest {
    String nameSecretary ;
    String surNameSecretary ;
    String passwordSecretary ;
    String emailSecretary ;
    String newNameOfSecretary;
    String newSurNameOfSecretary;
    String newEmailOfSecretary;
    UnassignedUser secretary;
    SecretarysEditDetailsTab editSecretary;
    String editSecretaryURL;

    public EditSecretarysDiteils () {
        nameSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        surNameSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        passwordSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        emailSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(7) + "@gmail.com";
        newNameOfSecretary=nameSecretary+"new";
        newSurNameOfSecretary=surNameSecretary+"new";
        newEmailOfSecretary=emailSecretary+"new";
        secretary= UnassignedUser.getUnassignedUser(nameSecretary,surNameSecretary,emailSecretary,passwordSecretary);
    }
    @BeforeClass
    public void setUp() throws IOException {
        editSecretary = AuthPage.init(driver)
                .clickRegistrationLink()
                .registerUser(secretary)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(waitTime)
                .addRole(secretary.getEmail(), UnassignedRole.SECRETARY)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.SECRETARIES, SecretariesPage.class)
                .inputSearchSecretaries("a")
                .inputSearchSecretaries(secretary.getFirstName()+" "+secretary.getLastName())
                .editSecretarys(0).isAtPage(waitTime);
        editSecretaryURL=driver.getCurrentUrl();
                    }
    @Test
    public void verifyInputFields(){
        SoftAssert softAssert = new SoftAssert();
        editSecretary.editName(newNameOfSecretary)
                .editSurname(newSurNameOfSecretary)
                .editEmail(newEmailOfSecretary)
                .saveSecretary();
        softAssert.assertAll();
    }
}

