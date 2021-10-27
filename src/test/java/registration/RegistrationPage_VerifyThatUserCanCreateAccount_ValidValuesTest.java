package registration;

import base.BaseTest;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.students.StudentsPage;
import page.unassigned.UnassignedUsersPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.UnassignedUser;

import java.io.IOException;

public class RegistrationPage_VerifyThatUserCanCreateAccount_ValidValuesTest extends BaseTest {

    private UnassignedUser user;

    @BeforeClass
    public void setUp() {
        user = UnassignedUser.getUnassignedUser();
    }

    @Test(description = "DP213-155")
    public void verifyCreateNewUserValidParameters() throws IOException {
        AuthPage.init(driver)
                .clickRegistrationLink()
                .verifyInputFieldsAreEmpty()
                .verifyErrorMessagesAreNotDisplayed()
                .verifySingInButtonIsEnabled()
                .verifyLogInLinkIsEnabled()

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
                .clickModalWindowBackButton()

                .logInAs(Role.ADMIN, StudentsPage.class)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isUserPresented(user.getEmail())
                .assertAll();
    }

}
