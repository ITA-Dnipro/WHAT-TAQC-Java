package unassignedUsers;

import base.BaseTest;
import base.RandomStringsGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.registrationPage.RegistrationPage;
import page.registrationPage.User;
import page.unassignedUsers.Role;
import page.unassignedUsers.UnassignedUsersPage;

import static base.Role.ADMIN;
import static constants.Endpoints.*;

public class UnassignedUsers_AddUsersRole extends BaseTest {

    private User user;
    private UnassignedUsersPage unassignedUsersPage;
    private RegistrationPage registrationPage;

    @BeforeClass
    public void preconditions() {
        unassignedUsersPage = new UnassignedUsersPage(driver);

        String firstName = "Test";
        String lastName = "Automation";
        String email = RandomStringsGenerator
                .getAlphabeticStringLowerCaseCharacters(3) + "@what.com.ua";
        String password = "What_12!";
        user = new User(firstName, lastName, email, password);

        driver.get(REGISTRATION);
        registrationPage = new RegistrationPage(driver);
        registrationPage.registerUser(user);
    }

    @Test
    public void addStudentRole() {
        driver.get(BASE_URL);
        helper.logInAs(ADMIN);
        helper.waitForRedirectFrom(AUTH);
        driver.get(UNASSIGNED_USERS);
        unassignedUsersPage.addRole(user.getEmail(), Role.STUDENT);

//        TODO ADD ASSERT!!!!
    }

}
