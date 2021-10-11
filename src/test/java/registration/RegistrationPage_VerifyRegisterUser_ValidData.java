package registration;

import base.BaseTest;
import base.RandomStringsGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.base.LogIn;
import page.base.User;
import page.registrationPage.RegistrationPage;
import page.registrationPage.UserRegistration;

public class RegistrationPage_VerifyRegisterUser_ValidParams extends BaseTest {

    LogIn logIn;
    


    @BeforeClass
    public void preconditions() {
        RandomStringsGenerator random = new RandomStringsGenerator();
        String firstName = "Test";
        String lastName = "Automation";
        String email = random.getAlphabeticStringLowerCase(5) + "@what.com.ua";
        String password = "What_12!";
        User user = new UserRegistration(firstName, lastName, email, password);
    }

    @Test
    public void registerUserWithValidParams(){

    }
}
