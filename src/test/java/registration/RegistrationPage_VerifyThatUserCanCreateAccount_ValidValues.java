package registration;

import base.BaseTest;
import constants.Endpoints;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.students.StudentsPage;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import page.unauthorizedUserPages.RegistrationPage;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;

public class RegistrationPage_VerifyRegistrationUser_ValidParameters extends BaseTest {

    private RegistrationPage registrationPage;
    private UnassignedUser user;

    @BeforeClass
    public void precondition() throws IOException {
        user = UnassignedUser.getUnassignedUser();
        registrationPage = AuthPage.init(driver)
                .clickRegistrationLink();
    }

    @Test(description = "")
    public void verifyCreateNewUserValidParameters() throws IOException {
        registrationPage
                .verifyInputFieldsAreEmpty()
                .verifyErrorMessagesAreNotDisplayed()

                .fillInputFirstName(user.getFirstName())
                .verifyFillingFirstNameInputField(user.getFirstName())
                .fillInputLastName(user.getLastName())
                .verifyFillingLastNameInputField(user.getLastName())
                .fillInputEmail(user.getEmail())
                .verifyFillingEmailInputField(user.getEmail())
                .fillInputPassword(user.getPassword())
                .verifyFillingPasswordInputField(user.getPassword())
                .fillInputConfirmPassword(user.getPassword())
                .verifyFillingConfirmPasswordInputField(user.getPassword())

                .clickSingUpButton()
                .verifyModalWindowIsOpened()
                .assertAll();

        boolean actualResult = registrationPage
                .clickModalWindowBackButton()
                .logInAs(Role.ADMIN, StudentsPage.class)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isUserPresented(user.getEmail());

        Assert.assertTrue(actualResult);
    }

}
