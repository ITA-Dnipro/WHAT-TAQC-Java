package changePassword.dataPasswords.data;

import base.BaseTest;
import base.Role;
import base.TestHelper;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.User;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import page.auth.AuthPage;
import page.courses.CoursesPage;

import java.io.File;
import java.io.IOException;

public class ChangePasswordPage_VerifyChangePassword_ValidData_AnyUser222 extends BaseTest {

    private ChangePasswordValidData[] passwordsList;
    private TestHelper testHelper;
    private CoursesPage coursesPage;
    Object[][] list;
    User mentor;
    private String currentPassword;
    private String basePassword;

    @BeforeClass
    public void preconditions() throws IOException {
        driver.get(Endpoints.BASE_URL);
        passwordsList = helper.getMapper().readValue(
                new File(PathsToFiles.ChangePassword.CHANGE_PASSWORD_VALID_DATA),
                ChangePasswordValidData[].class);
        list = new Object[passwordsList.length][1];
        helper.logInAs(Role.MENTOR);
        basePassword = helper.getUserByRole(Role.MENTOR).getPass();
        currentPassword = helper.getUserByRole(Role.MENTOR).getPass();
    }

    @DataProvider(name = "log_in")
    public Object[][] provideCredentials() {

        for (int i = 0; i < passwordsList.length; i++) {
            list[i][0] = passwordsList[i];
        }
        return list;
    }

    @Test(dataProvider = "log_in")
    public void changePassword_ValidData_Test(ChangePasswordValidData newPassword) {
        mentor = new User();
        helper.waitForRedirectFrom(Endpoints.AUTH);
        SoftAssert softAssert = new SoftAssert();
        coursesPage = new CoursesPage(driver);
        AuthPage authPage = new AuthPage(driver);
        testHelper = new TestHelper(driver);

        driver.get(Endpoints.COURSES);
        coursesPage
                .getHeader()
                .changePassword()
                .fillCurrentPasswordField(currentPassword, null)
                .fillNewPasswordField(newPassword.getNewPassword(), null)
                .fillConfirmPasswordField(newPassword.getNewPassword(), null)
                .saveChangePassword()
                .confirmChangedPassword();
        currentPassword = newPassword.getNewPassword();
        coursesPage
                .getHeader()
                .logOut();
        helper.waitDownloadPage(Endpoints.AUTH);
        authPage
                .fillEmailInput(helper.getUserByRole(Role.MENTOR).getMail())
                .fillPasswordInput(currentPassword)
                .clickSignIn();
        helper.waitForRedirectFrom(Endpoints.AUTH);
        softAssert.assertAll();

    }
    @AfterClass
    protected void restorePassword() {
        driver.get(Endpoints.COURSES);
        helper.waitDownloadPage(Endpoints.COURSES);
        coursesPage
                .getHeader()
                .changePassword()
                .fillCurrentPasswordField(currentPassword, null)
                .fillNewPasswordField(basePassword, null)
                .fillConfirmPasswordField(basePassword, null)
                .saveChangePassword()
                .confirmChangedPassword();
        helper.waitDownloadPage(Endpoints.COURSES);
    }
}