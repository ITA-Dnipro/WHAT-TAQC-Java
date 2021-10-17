package changePassword;

import base.BaseTest;
import changePassword.dataPasswords.data.ChangePasswordValidData;
import constants.Endpoints;
import constants.PathsToFiles;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.changePassword.ChangePasswordPage;
import page.lessons.LessonsPage;
import page.myProfile.MyProfilePage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;
import util.User;

import java.io.IOException;
import java.util.Map;

public class ChangePasswordPage_VerifyChangePassword_ValidData_AnyUser extends BaseTest {

    private ChangePasswordValidData[] passwordsData;
    private ChangePasswordPage changePasswordPage;
    private MyProfilePage myProfilePage;
    private String currentPassword;
    private User user;
    private String basePassword;
    private Map<String, User> users;

    public ChangePasswordPage_VerifyChangePassword_ValidData_AnyUser() throws IOException {
        users = User.get(PathsToFiles.CREDENTIALS);
        passwordsData = ChangePasswordValidData.passwordsList(
                PathsToFiles.ChangePassword.CHANGE_PASSWORD_VALID_DATA);
    }

    @BeforeClass
    public void preconditions() throws IOException {

        changePasswordPage = AuthPage.init(driver)
                .logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.CHANGE_PASSWORD, ChangePasswordPage.class)
                .isAtPage(waitTime);


        user = users.get(Role.MENTOR.getRoleName());
        basePassword = user.getPass();
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
    public void changePassword_ValidData_Test(ChangePasswordValidData newPassword) throws IOException {
        currentPassword = user.getPass();

        changePasswordPage
                .fillCurrentPasswordField(currentPassword)
                .fillNewPasswordField(newPassword.getNewPassword())
                .fillConfirmPasswordField(newPassword.getNewPassword())
                .saveChangePassword()
                .confirmChangedPassword()
                .updateCurrentPassword(newPassword.getNewPassword())
                .logOut()
                .fillMail(user.getMail())
                .fillPass(currentPassword)
                .clickSignIn()
                .isAtPage(waitTime);

        Assert.assertEquals(driver.getCurrentUrl(), Endpoints.LESSONS);
        users.put(Role.MENTOR.getRoleName(), user);
    }

    @AfterMethod
    protected void restorePassword() {

        myProfilePage = LessonsPage.init(driver)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.CHANGE_PASSWORD, ChangePasswordPage.class)
                .isAtPage(waitTime)
                .checkEmailField()
                .fillCurrentPasswordField(currentPassword)
                .fillNewPasswordField(basePassword)
                .fillConfirmPasswordField(basePassword)
                .saveChangePassword()
                .confirmChangedPassword();
    }
}