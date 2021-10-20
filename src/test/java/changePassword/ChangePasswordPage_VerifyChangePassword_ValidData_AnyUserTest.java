package changePassword;

import base.BaseTest;
import changePassword.dataPasswords.data.ChangePasswordValidData;
import constants.Endpoints;
import constants.PathsToFiles;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.changePassword.ChangePasswordPage;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.User;

import java.io.IOException;
import java.util.Map;

public class ChangePasswordPage_VerifyChangePassword_ValidData_AnyUserTest extends BaseTest {

    private ChangePasswordValidData[] passwordsData;
    private User user;
    private String currentPassword;
    private String newUserPassword;
    private Map<String, User> users;

    public ChangePasswordPage_VerifyChangePassword_ValidData_AnyUserTest() throws IOException {
        users = User.get(PathsToFiles.getPathToCredentials());
        passwordsData = ChangePasswordValidData.passwordsList(
                PathsToFiles.getPathToValidPasswords());
    }

    @BeforeClass
    public void setUp() {
        user = users.get(Role.MENTOR.getRoleName());
    }

    @DataProvider(name = "log_in")
    public Object[][] providePasswords() {
        Object[][] list = new Object[passwordsData.length][1];
        for (int i = 0; i < passwordsData.length; i++) {
            list[i][0] = passwordsData[i];
        }
        return list;
    }

    @Test(description = "DP213-27", dataProvider = "log_in")
    public void changePassword_ValidData_Test(ChangePasswordValidData newPassword) throws IOException, InterruptedException {
        newUserPassword = newPassword.getNewPassword();
        currentPassword = user.getPass();

        AuthPage.init(driver)
                .logInAs(Role.MENTOR, user, LessonsPage.class)
                .isAtPage(waitTime)
                .clickUserIcon()
                .isAtPage(waitTime)
                .redirectTo(Endpoints.CHANGE_PASSWORD, ChangePasswordPage.class)
                .isAtPage(waitTime)
                .fillCurrentPasswordField(currentPassword)
                .verifyCurrentPasswordFieldFielded(currentPassword)
                .fillNewPasswordField(newUserPassword)
                .verifyNewPasswordFieldFielded(newUserPassword)
                .fillConfirmPasswordField(newUserPassword)
                .verifyConfirmPasswordFieldFielded(newUserPassword)
                .assertChangePasswordPage()
                .saveChangePassword()
                .isAtPage(waitTime)
                .confirmChangedPassword()
                .isAtPage(waitTime)
                .logOut();
    }

    @AfterMethod
    public void afterMethod() {
        user.setPass(newUserPassword);
    }
}