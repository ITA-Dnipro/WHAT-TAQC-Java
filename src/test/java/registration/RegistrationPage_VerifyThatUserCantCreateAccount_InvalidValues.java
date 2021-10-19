package registration;

import base.BaseTest;
import org.testng.annotations.Test;
import page.unauthorizedUserPages.AuthPage;
import page.unauthorizedUserPages.RegistrationPage;
import registration.data.RegistrationInvalidEmail;
import registration.data.RegistrationInvalidFirstName;
import registration.data.RegistrationInvalidLastName;

import java.io.IOException;

import static constants.PathsToFiles.Registration.*;

public class RegistrationPage_VerifyThatUserCantCreateAccount_InvalidValues extends BaseTest {

    RegistrationInvalidFirstName[] dataInvalidFirstName;
    RegistrationInvalidLastName[] dataInvalidLastName;
    RegistrationInvalidEmail[] dataInvalidEmail;
    RegistrationPage registrationPage;

    RegistrationPage_VerifyThatUserCantCreateAccount_InvalidValues() throws IOException {
        dataInvalidFirstName = RegistrationInvalidFirstName.getData(REGISTRATION_INVALID_FIRST_NAME);
        dataInvalidLastName = RegistrationInvalidLastName.getData(REGISTRATION_INVALID_LAST_NAME);
        dataInvalidEmail = RegistrationInvalidEmail.getData(REGISTRATION_INVALID_EMAIL);
    }

    @Test(description = "DP213-161")
    public void verifyCreateNewUserValidParameters() throws IOException {
        registrationPage = AuthPage.init(driver)
                .clickRegistrationLink()
                .verifyInputFieldsAreEmpty()
                .verifyErrorMessagesAreNotDisplayed()
                .verifySingInButtonIsEnabled()
                .verifyLogInLinkIsEnabled()
    }
}