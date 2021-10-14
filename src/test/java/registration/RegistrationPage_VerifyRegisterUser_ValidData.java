package registration;

import base.BaseTest;
import base.RandomStringsGenerator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.registrationPage.RegistrationPage;
import page.registrationPage.User;
import page.unassignedUsers.UnassignedUsersPage;

import static util.Role.ADMIN;
import static constants.Endpoints.*;

public class RegistrationPage_VerifyRegisterUser_ValidData extends BaseTest {

    private WebDriverWait waiter;
    private RegistrationPage registrationPage;
    private User user;
    private UnassignedUsersPage unassignedUsersPage;

    @BeforeClass
    public void preconditions() {
        registrationPage = new RegistrationPage(driver);
        unassignedUsersPage = new UnassignedUsersPage(driver);

        String firstName = "Test";
        String lastName = "Automation";
        String email = RandomStringsGenerator
                .getAlphabeticStringLowerCaseCharacters(5) + "@what.com.ua";
        String password = "What_12!";
        user = new User(firstName, lastName, email, password);
    }

    @Test
    public void registerUserWithValidParams() {
        driver.get(REGISTRATION);
        registrationPage.registerUser(user);

        helper.logInAs(ADMIN);
        helper.waitForRedirectFrom(AUTH);
        driver.get(UNASSIGNED_USERS);
        WebElement userRow = unassignedUsersPage.findUserRowByEmail(user.getEmail());

        Assert.assertNotEquals(null, userRow);
    }

}
