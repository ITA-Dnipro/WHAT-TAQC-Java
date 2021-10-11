package registration;

import base.BaseTest;
import base.RandomStringsGenerator;
import constants.Endpoints;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.base.LogIn;
import page.registrationPage.RegistrationPage;
import page.registrationPage.UserRegistration;
import page.unassignedUsers.UnassignedUsers;

import java.time.Duration;

public class RegistrationPage_VerifyRegisterUser_ValidData extends BaseTest {

    WebDriverWait waiter;
    private RegistrationPage registrationPage;
    private UserRegistration user;
    private UnassignedUsers unassignedUsers;

    @BeforeClass
    public void preconditions() {
        waiter = new WebDriverWait(driver, Duration.ofSeconds(5));
        RandomStringsGenerator random = new RandomStringsGenerator();
        String firstName = "Test";
        String lastName = "Automation";
        String email = random.getAlphabeticStringLowerCase(5) + "@what.com.ua";
        String password = "What_12!";
        user = new UserRegistration(firstName, lastName, email, password);
    }

    @Test
    public void registerUserWithValidParams(){
        driver.get(Endpoints.REGISTRATION);
        registrationPage = new RegistrationPage(driver);
        waiter.until(ExpectedConditions.visibilityOfAllElements(registrationPage.getAllElements()));
        registrationPage.registerUser(user, waiter);
        LogIn logIn = new LogIn(driver);
                logIn.fillMail("james.smith@example.com")
                .fillPass("_JkcG9dB")
                .clickLogInButton();
        waiter.until(ExpectedConditions.not((redirect)->driver.getCurrentUrl().equals(Endpoints.AUTH)));
        driver.get(Endpoints.UNASSIGNED_USERS);
        unassignedUsers = new UnassignedUsers(driver);
        WebElement userRow = unassignedUsers.findUserByEmail(user.getEmail());
        Assert.assertNotEquals(null,userRow);
    }


}
