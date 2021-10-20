package registration;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.unauthorizedUserPages.AuthPage;
import page.unauthorizedUserPages.RegistrationPage;
import registration.data.RegistrationInvalidData;

import java.io.IOException;

import static constants.PathsToFiles.Registration.*;

public class RegistrationPage_VerifyThatUserCantCreateAccount_InvalidValues extends BaseTest {

    private RegistrationInvalidData[] invalidData;
    private RegistrationPage registrationPage;

    RegistrationPage_VerifyThatUserCantCreateAccount_InvalidValues() throws IOException {
        invalidData = RegistrationInvalidData.getData(REGISTRATION_INVALID_DATA);

    }

    @DataProvider(name = "invalidData")
    public Object[][] provide() {
        Object[][] list = new Object[invalidData.length][1];
        for (int i = 0; i < invalidData.length; i++) {
            list[i][0] = invalidData[i];
        }
        return list;
    }

    @Test(description = "DP213-161", dataProvider = "invalidData")
    public void verifyUserCantCreateAccount(RegistrationInvalidData data) throws IOException {
        AuthPage.init(driver)
                .clickRegistrationLink()
                .verifyInputFieldsAreEmpty()
                .verifyErrorMessagesAreNotDisplayed()
                .verifySingInButtonIsEnabled()
                .verifyLogInLinkIsEnabled()
                .fillInputFirstName(data.getFirstName())
                .verifyFirstNameErrorMessage(data.getFirstNameError())
                .fillInputFirstName(data.getLastName())
                .verifyFirstNameErrorMessage(data.getLastNameError())
                .assertAll();
    }
}