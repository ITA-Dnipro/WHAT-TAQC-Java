package secretarys.UIsecretaryTest;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
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

public class ListSecreteries_VerifyCorrectlyWorkDisabledSecretaries extends BaseTest {
    String nameSecretary;
    String surNameSecretary;
    String passwordSecretary;
    String emailSecretary;
    UnassignedUser secretary;
    SecretarysPage secretarysPage;

    public ListSecreteries_VerifyCorrectlyWorkDisabledSecretaries() throws IOException {
        nameSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        surNameSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(5);
        passwordSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(9) + "1_";
        emailSecretary = RandomStringsGenerator.getAlphabeticStringFirstUppercaseCharacters(7) + "@gmail.com";
        secretary= UnassignedUser.getUnassignedUser(nameSecretary,surNameSecretary,emailSecretary,passwordSecretary);
    }

//    @BeforeClass
//    public void precondition() throws IOException {
//        secretarysPage = AuthPage.init(driver)
//                .clickRegistrationLink()
//                .registerUser(secretary)
//                .logInAs(Role.ADMIN, StudentsPage.class)
//                .isAtPage(waitTime)
//                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
//                .isAtPage(waitTime)
//                .addRole(secretary.getEmail(), UnassignedRole.SECRETARY)
//                .isAtPage(waitTime)
//                .redirectTo(Endpoints.SECRETARY, SecretarysPage.class)
//                .inputSearchSecretary("a")
//                .inputSearchSecretary(secretary.getFirstName() + " " + secretary.getLastName())
//                .openSecretaryEditDetailsTab(0)
//                .isAtPage(waitTime)
//                .removeSecretary()
//                .deleteSecretary()
//                .isAtPage(waitTime);
//    }
    @Test
    public void VerifyCorrectlyWorkDisabledSecretaries(){
        List<String> actualData=secretarysPage
                .showDisableSecretarys()
                .inputSearchSecretary("a")
                .inputSearchSecretary(nameSecretary+" "+ surNameSecretary)
                .getSecretaryData();
        List<String>expectData= Arrays.asList(nameSecretary,surNameSecretary,emailSecretary);
        Assert.assertEquals(actualData,expectData);
    }
}

