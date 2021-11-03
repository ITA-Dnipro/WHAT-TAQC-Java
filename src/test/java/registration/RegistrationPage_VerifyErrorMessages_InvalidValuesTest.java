package registration;

import base.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.unauthorizedUserPages.AuthPage;
import page.unauthorizedUserPages.RegistrationPage;
import registration.data.RegistrationInvalidData;

import java.io.IOException;

import static constants.PathsToFiles.Registration.REGISTRATION_INVALID_DATA;

public class RegistrationPage_VerifyErrorMessages_InvalidValuesTest extends BaseTest {

    private RegistrationInvalidData[] invalidData;
    private RegistrationPage registrationPage;

    @BeforeClass
    public void setUp() throws IOException {
        invalidData = RegistrationInvalidData.getData(REGISTRATION_INVALID_DATA);
        registrationPage = AuthPage.init(driver)
                .clickRegistrationLink();
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
    public void verifyErrorMessages(RegistrationInvalidData data) {
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