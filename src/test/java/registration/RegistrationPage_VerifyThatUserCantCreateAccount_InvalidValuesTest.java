package registration;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.unauthorizedUserPages.AuthPage;
import page.unauthorizedUserPages.RegistrationPage;
import registration.data.RegistrationInvalidData;

import java.io.IOException;

import static constants.PathsToFiles.Registration.REGISTRATION_INVALID_DATA;

public class RegistrationPage_VerifyThatUserCantCreateAccount_InvalidValuesTest extends BaseTest {

    private RegistrationInvalidData[] invalidData;
    private RegistrationPage registrationPage;

    RegistrationPage_VerifyThatUserCantCreateAccount_InvalidValuesTest() throws IOException {
        invalidData = RegistrationInvalidData.getData(REGISTRATION_INVALID_DATA);
    }

    @BeforeClass
    public void setUp() throws IOException {
        registrationPage = AuthPage.init(driver)
                .clickRegistrationLink()
                .verifyInputFieldsAreEmpty()
                .verifyErrorMessagesAreNotDisplayed()
                .verifySingInButtonIsEnabled()
                .verifyLogInLinkIsEnabled();
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
    public void verifyUserCantCreateAccount(RegistrationInvalidData data) throws InterruptedException {
        registrationPage
                .fillInputFirstName(data.getFirstName())
                .loseFocus()
                .verifyFillingFirstNameInputField(data.getFirstName())
                .verifyFirstNameErrorMessage(data.getFirstNameError())

                .fillInputLastName(data.getLastName())
                .loseFocus()
                .verifyLastNameErrorMessage(data.getLastNameError())

                .fillInputPassword(data.getPassword())
                .loseFocus()
                .verifyPasswordErrorMessage(data.getPasswordError())

                .fillInputEmail(data.getEmail())
                .loseFocus()
                .verifyEmailErrorMessage(data.getEmailError())

                .assertAll();
    }
}