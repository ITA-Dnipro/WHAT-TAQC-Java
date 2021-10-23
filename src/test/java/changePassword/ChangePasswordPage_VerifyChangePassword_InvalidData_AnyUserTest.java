package changePassword;

import base.BaseTest;
import changePassword.dataPasswords.data.ChangePasswordInvalidData;
import constants.Endpoints;
import constants.PathsToFiles;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.changePassword.ChangePasswordPage;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ChangePasswordPage_VerifyChangePassword_InvalidData_AnyUserTest extends BaseTest {

    private ChangePasswordInvalidData[] passwordsData;
    private ChangePasswordPage changePasswordPage;
    private Object[][] list;

    public ChangePasswordPage_VerifyChangePassword_InvalidData_AnyUserTest() throws IOException {
        passwordsData = ChangePasswordInvalidData.getPasswordsList(
                PathsToFiles.ChangePassword.CHANGE_PASSWORD_INVALID_DATA);
    }

    @BeforeClass
    public void setUp() throws IOException {

        AuthPage.init(driver).logInAs(Role.MENTOR, LessonsPage.class)
                .isAtPage(waitTime)
                .redirectTo(Endpoints.CHANGE_PASSWORD, ChangePasswordPage.class)
                .isAtPage(waitTime);
    }

    @DataProvider(name = "change-password")
    public Object[][] providePasswords() {
        list = new Object[passwordsData.length][1];
        for (int i = 0; i < passwordsData.length; i++) {
            list[i][0] = passwordsData[i];
        }
        return list;
    }

    @Test(description = "DP213-29", dataProvider = "change-password")
    public void changePasswordInvalidDataTest(ChangePasswordInvalidData password) throws InterruptedException {
        changePasswordPage = new ChangePasswordPage(driver);

        changePasswordPage
                .checkEmailField()
                .fillCurrentPasswordField(password.getCurrantPassword())
                .loseFocus()
                .isAtPage(waitTime)
                .verifyCurrentPasswordError(password.getCurrantPasswordResult(), changePasswordPage.getCurrentPasswordError())
                .fillNewPasswordField(password.getNewPassword())
                .loseFocus()
                .isAtPage(waitTime)
                .verifyNewPasswordError(password.getNewPasswordResult(), changePasswordPage.getNewPasswordError())
                .fillConfirmPasswordField(password.getConfirmPassword())
                .loseFocus()
                .isAtPage(waitTime)
                .verifyConfirmPasswordError(password.getConfirmPasswordResult(), changePasswordPage.getConfirmPasswordError())
                .assertAll();
    }
}