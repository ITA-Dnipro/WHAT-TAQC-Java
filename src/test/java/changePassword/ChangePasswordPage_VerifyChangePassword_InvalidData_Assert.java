package changePassword;

import base.BaseTest;
import changePassword.dataPasswords.data.ChangePasswordInvalidData;
import constants.Endpoints;
import constants.PathsToFiles;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.changePassword.ChangePasswordPage;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ChangePasswordPage_VerifyChangePassword_InvalidData_Assert extends BaseTest {

    private ChangePasswordInvalidData[] passwordsData;
    private ChangePasswordPage changePasswordPage;

    public ChangePasswordPage_VerifyChangePassword_InvalidData_Assert() throws IOException {
        passwordsData = ChangePasswordInvalidData.getPasswordsList(
                PathsToFiles.ChangePassword.CHANGE_PASSWORD_INVALID_DATA);
    }

    @BeforeClass
    public void preconditions() throws IOException {
        changePasswordPage =
                AuthPage.init(driver)
                        .logInAs(Role.MENTOR, LessonsPage.class)
                        .isAtPage(waitTime)
                        .redirectTo(Endpoints.CHANGE_PASSWORD, ChangePasswordPage.class)
                        .isAtPage(waitTime);
    }

    @DataProvider(name = "change-password")
    public Object[][] providePasswords() {
        Object[][] list = new Object[passwordsData.length][1];
        for (int i = 0; i < passwordsData.length; i++) {
            list[i][0] = passwordsData[i];
        }
        return list;
    }

    @Test(description = "DP213-29", dataProvider = "change-password")
    public void changePassword_CurrentPasswordInputField(ChangePasswordInvalidData password) {
        String expectedResult = password.getCurrantPasswordResult();

        String actualResult = changePasswordPage
                .fillCurrentPasswordField(password.getCurrantPassword())
                .loseFocus()
                .getCurrentPasswordError();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "DP213-29", dataProvider = "change-password")
    public void changePassword_NewPasswordInputField(ChangePasswordInvalidData password) {
        String expectedResult = password.getNewPasswordResult();

        String actualResult = changePasswordPage
                .fillNewPasswordField(password.getNewPassword())
                .loseFocus()
                .getNewPasswordError();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test(description = "DP213-29", dataProvider = "change-password")
    public void changePassword_ConfirmPasswordInputField(ChangePasswordInvalidData password) {
        String expectedResult = password.getConfirmPasswordResult();

        String actualResult = changePasswordPage
                .fillConfirmPasswordField(password.getConfirmPassword())
                .loseFocus()
                .getConfirmPasswordError();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
