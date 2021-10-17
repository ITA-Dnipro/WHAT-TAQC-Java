package registration;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.students.StudentsPage;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import page.unauthorizedUserPages.RegistrationPage;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;

public class RegistrationPage_VerifyRegistrationUser_ValidParameters extends BaseTest {

    private RegistrationPage registrationPage;
    private SoftAssert softAsserts;
    private UnassignedUser user;

    @BeforeClass
    public void precondition() throws IOException {
        user = UnassignedUser.getUnassignedUser();
        registrationPage = AuthPage.init(driver)
                .clickRegistrationLink();
    }

    @Test
    public void verifyInputFieldsAreEmpty() {
        softAsserts =
                registrationPage.verifyFillingFirstNameInputField("")
                        .verifyFillingLastNameInputField("")
                        .verifyFillingEmailInputField("")
                        .verifyFillingPasswordInputField("")
                        .verifyFillingConfirmPasswordInputField("")
                        .getSoftAssert();
        softAsserts.assertAll();
    }

    @Test
    public void verifyErrorMessagesAreNotDisplayed() {
        softAsserts =
                registrationPage.verifyFirstNameErrorIsDisplayed(false)
                        .verifyLastNameErrorIsDisplayed(false)
                        .verifyEmailErrorIsDisplayed(false)
                        .verifyPasswordErrorIsDisplayed(false)
                        .verifyConfirmPasswordErrorIsDisplayed(false)
                        .getSoftAssert();
        softAsserts.assertAll();
    }

    @Test
    public void verifyCreateNewUserValidParameters() throws IOException {

        softAsserts = registrationPage
                .fillInputFirstName(user.getFirstName())
                .verifyFillingFirstNameInputField(user.getFirstName())
                .fillInputLastName(user.getLastName())
                .verifyFillingLastNameInputField(user.getLastName())
                .fillInputEmail(user.getEmail())
                .verifyFillingEmailInputField(user.getEmail())
                .fillInputPassword(user.getPassword())
                .verifyFillingPasswordInputField(user.getEmail())
                .fillInputConfirmPassword(user.getPassword())
                .verifyFillingConfirmPasswordInputField(user.getPassword())
                .clickSingUpButton()
                .verifyModalWindowIsOpened()
                .getSoftAssert();

        boolean actualResult = registrationPage
                .clickModalWindowBackButton()
                .logInAs(Role.ADMIN, StudentsPage.class)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isUserPresented(user.getEmail());
        softAsserts.assertAll();

        Assert.assertTrue(actualResult);
    }

}
