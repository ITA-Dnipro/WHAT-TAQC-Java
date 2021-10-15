package registration;

import base.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.unauthorizedUserPages.AuthPage;
import page.unauthorizedUserPages.RegistrationPage;

import java.io.IOException;

public class RegistrationPage_VerifyRegistrationUser_ValidParameters extends BaseTest {

    private RegistrationPage registrationPage;
    private SoftAssert softAsserts;

    @BeforeClass
    public void precondition() throws IOException {
    registrationPage = AuthPage.init(driver)
            .clickRegistrationLink();
    }

    @Test
    public void verifyRegistrationUserValidParameters(){
        softAsserts = registrationPage.verifyFillingFirstNameInputField("")
        .verifyFillingLastNameInputField("")
        .verifyFillingEmailInputField("")
        .verifyPasswordErrorMessage("")
        .verifyConfirmPasswordErrorMessage("")
        .verifyFirstNameErrorIsDisplayed(false)
        .verifyLastNameErrorIsDisplayed(false)
        .verifyEmailErrorIsDisplayed(false)
        .verifyPasswordErrorIsDisplayed(false)
        .verifyConfirmPasswordErrorIsDisplayed(false)
        .getSoftAssert();
    }


}
