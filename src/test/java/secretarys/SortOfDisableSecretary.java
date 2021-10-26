package secretarys;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.secretarys.SecretarysPage;
import page.students.StudentsPage;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.RandomStringsGenerator;
import util.Role;
import util.UnassignedUser;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class SortOfDisableSecretary extends BaseTest {
    String nameSecretary;
    String surNameSecretary;
    String passwordSecretary;
    String emailSecretary;
    UnassignedUser secretary;
    SecretarysPage secretarysPage;

    public SortOfDisableSecretary() throws IOException {
        nameSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        surNameSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        passwordSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        emailSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(7) + "@gmail.com";
        secretary = UnassignedUser.getUnassignedUser(nameSecretary, surNameSecretary, emailSecretary, passwordSecretary);
    }

    @BeforeClass
    public void setUp() throws IOException {
        secretarysPage = AuthPage
                .init(driver)
                .clickRegistrationLink()
                .registerUser(secretary)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(10)
                .addRole(secretary.getEmail(), UnassignedRole.SECRETARY)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.SECRETARY, SecretarysPage.class)
                .inputSearchSecretary(secretary.getFirstName() + " " + secretary.getLastName())
                .openSecretaryEditDetailsTab(0)
                .isAtPage(waitTime)
                .deleteSecretary()
                .acceptDeleteSecretary()
                .isAtPage(waitTime)
                .returnToSecretaryPage();
    }

    @Test(description = "")
    public void SortOfDisableSecretary() {
        List<String> expectData = Arrays.asList(nameSecretary, surNameSecretary, emailSecretary);
        secretarysPage
                .showDisableSecretarys()
                .inputSearchSecretary("a")
                .inputSearchSecretary(nameSecretary + " " + surNameSecretary)
                .verifySecretaryDataInTheTable(expectData);

    }
}