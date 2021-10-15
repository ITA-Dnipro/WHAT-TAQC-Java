package util;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import page.StudentsPage;
import unauthorizedPages.Auth;
import page.unassigned.UnassignedRole;
import page.unassigned.UnassignedUsersPage;

import java.io.IOException;

public class CreatedUser {
    private CreatedUser() {
    }

    public static Auth registeredUser(UnassignedUser user, UnassignedRole role, WebDriver driver) throws IOException {
        Auth.init(driver)
                .logInAs(Role.ADMIN, StudentsPage.class)
                .isAtPage(5)
                .redirectTo(Endpoints.UNASSIGNED_USERS, UnassignedUsersPage.class)
                .isAtPage(5)
                .addRole(user.getEmail(), role)
                .logOut();
        return new Auth(driver);
    }
}
