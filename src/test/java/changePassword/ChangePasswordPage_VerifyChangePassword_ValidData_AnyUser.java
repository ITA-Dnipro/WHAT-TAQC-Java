package changePassword;

import base.BaseTest;
import base.Role;
import base.TestHelper;
import changePassword.dataPasswords.data.ChangePasswordValidData;
import constants.Endpoints;
import constants.PathsToFiles;
import lessons.data.User;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import page.auth.AuthPage;
import page.courses.CoursesPage;

import java.io.File;
import java.io.IOException;

public class ChangePasswordPage_VerifyChangePassword_ValidData_AnyUser extends BaseTest {

    private ChangePasswordValidData[] passwordsList;
    private TestHelper testHelper;
    private CoursesPage coursesPage;
    Object[][] list;
    User mentor;
    private String currentPassword;

    @BeforeClass
    public void preconditions() throws IOException {
        driver.get(Endpoints.BASE_URL);
        mentor = new User();
        passwordsList = helper.getMapper().readValue(
                new File(PathsToFiles.ChangePassword.CHANGE_PASSWORD_VALID_DATA),
                ChangePasswordValidData[].class);
        list = new Object[passwordsList.length][1];
        helper.logInAs(Role.MENTOR);
        currentPassword = helper.getUserByRole(Role.MENTOR).getPass();
    }

    @DataProvider(name = "log_in")
    public Object[][] provideCredentials() {

        for (int i = 0; i < passwordsList.length; i++) {
            list[i][0] = passwordsList[i];
        }
        return list;
    }

//    @Test(dataProvider = "log_in")
//    public void changePassword_ValidData_Test(ChangePasswordValidData newPassword) {
//        mentor = new User();
//
//        helper.waitForRedirectFrom(Endpoints.AUTH);
//        SoftAssert softAssert = new SoftAssert();
//        coursesPage = new CoursesPage(driver);
//        AuthPage authPage = new AuthPage(driver);
//        testHelper = new TestHelper(driver);
//
//        driver.get(Endpoints.COURSES);
//        coursesPage
//                .getHeader()
//                .changePassword()
//                .fillCurrentPasswordField(currentPassword, null)
//                .fillNewPasswordField(newPassword.getNewPassword(), null)
//                .fillConfirmPasswordField(newPassword.getConfirmPassword(), null)
//                .saveChangePassword()
//                .confirmChangedPassword()
//                .getHeader()
//                .logOut();
////        currentPassword = newPassword.getNewPassword();
//        helper.waitDownloadPage("http://localhost:8080/auth");
//
//        authPage
//                .fillEmailInput(testHelper.getUserByRole(Role.MENTOR).getMail())
//                .fillPasswordInput(currentPassword)
//                .clickSignIn();
//        softAssert.assertAll();
//        helper.waitForRedirectFrom("http://localhost:8080/auth");
//        coursesPage
//                .getHeader()
//                .logOut();
//    }
//    @AfterMethod
//            .getHeader()
//                .changePassword()
//                .fillCurrentPasswordField(newPassword.getNewPassword(), null)
//            .fillNewPasswordField(currentPassword, null)
//            .fillConfirmPasswordField(currentPassword, null)
//            .saveChangePassword()
//                .confirmChangedPassword()
//                .getHeader()
//                .logOut();
//    logout


    public void changePassword() {
        String Vasya;
    }
}


