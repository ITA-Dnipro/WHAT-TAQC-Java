package secretarys.UIsecretaryTest;

import base.BaseTest;
import page.secretarys.SecretarysEditDetailsPage;
import page.secretarys.SecretarysPage;
import page.students.StudentsPage;
import util.RandomStringsGenerator;
import util.UnassignedUser;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import java.io.IOException;



public class ListSecretaries_AdminCanEditSecretarysDetails extends BaseTest{

    String nameSecretary;
    String surNameSecretary;
    String passwordSecretary;
    String emailSecretary;
    String newNameOfSecretary;
    String newSurNameOfSecretary;
    String newEmailOfSecretary;
    UnassignedUser secretary;
    SecretarysEditDetailsPage editSecretary;
    String editSecretaryURL;

    public ListSecretaries_AdminCanEditSecretarysDetails(){
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
        public void precondition() throws IOException {
            editSecretary= AuthPage.init(driver)
                    .clickRegistrationLink()
                    .registerUser(secretary)
                    .logInAs(Role.ADMIN, StudentsPage.class)
                    .isAtPage(waitTime)
                    .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                    .isAtPage(waitTime)
                    .addRole(secretary.getEmail(), UnassignedRole.SECRETARY)
                    .isAtPage(waitTime)
                    .redirectTo(Endpoints.SECRETARY, SecretarysPage.class)
                    .inputSearchSecretary("a")
                    .inputSearchSecretary(secretary.getFirstName()+" "+secretary.getLastName())
                    .openSecretaryEditDetailsTab(0)
                    .isAtPage(waitTime);
            editSecretaryURL=driver.getCurrentUrl();

        }
}

