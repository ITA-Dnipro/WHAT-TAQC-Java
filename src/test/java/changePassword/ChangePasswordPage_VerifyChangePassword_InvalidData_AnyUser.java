package changePassword;

import base.BaseTest;
import changePassword.dataPasswords.data.ChangePasswordInvalidData;
import constants.Endpoints;
import constants.PathsToFiles;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.changePassword.ChangePasswordPage;
import page.courses.CoursesPage;
import page.lessons.LessonsPage;
import page.unauthorizedUserPages.AuthPage;
import util.Role;

import java.io.IOException;

public class ChangePasswordPage_VerifyChangePassword_InvalidData_AnyUser extends BaseTest {

    private ChangePasswordInvalidData[] passwordsData;
    private CoursesPage coursesPage;
    private ChangePasswordPage changePasswordPage;
    private Object[][] list;

    public ChangePasswordPage_VerifyChangePassword_InvalidData_AnyUser() throws IOException {
        passwordsData = ChangePasswordInvalidData.getPasswordsList(
                PathsToFiles.ChangePassword.CHANGE_PASSWORD_INVALID_DATA);
    }

    @BeforeClass
    public void preconditions() throws IOException {

        changePasswordPage =
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
    public void changePassword_InvalidData_Test(ChangePasswordInvalidData password) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        coursesPage = new CoursesPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);

        changePasswordPage
                .fillCurrentPasswordField(password.getCurrantPassword())
                .isAtPage(waitTime)
                .verifyCurrentPasswordError(password.getCurrantPasswordResult(), changePasswordPage.getCurrentPasswordError())
                .fillNewPasswordField(password.getNewPassword())
                .isAtPage(waitTime)
                .verifyNewPasswordError(password.getNewPasswordResult(), changePasswordPage.getNewPasswordError())
                .fillConfirmPasswordField(password.getConfirmPassword())
                .isAtPage(waitTime)
                .verifyConfirmPassword(password.getConfirmPasswordResult(), changePasswordPage.getConfirmPasswordError())
                .cancelChangePassword()
                .isAtPage(waitTime);
        softAssert.assertAll();
}
}
