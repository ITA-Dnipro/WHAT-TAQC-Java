package changePassword;

import base.BaseTest;
import base.Role;
import changePassword.dataPasswords.data.ChangePasswordInvalidData;
import constants.Endpoints;
import constants.PathsToFiles;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import page.changePassword.ChangePasswordPage;
import page.courses.CoursesPage;

import java.io.File;
import java.io.IOException;

public class ChangePasswordPage_VerifyChangePassword_InvalidData_AnyUser extends BaseTest {

    private ChangePasswordInvalidData[] passwordsList;
    private CoursesPage coursesPage;
    ChangePasswordPage changePasswordPage;
    Object[][] list;


    @BeforeClass
    public void preconditions() throws IOException {
        driver.get(Endpoints.BASE_URL);
        passwordsList = helper.getMapper().readValue(
                new File(PathsToFiles.ChangePassword.CHANGE_PASSWORD_INVALID_DATA),
                ChangePasswordInvalidData[].class);
        list = new Object[passwordsList.length][1];
        helper.logInAs(Role.MENTOR);
        helper.waitForRedirectFrom(Endpoints.AUTH);
    }

    @DataProvider(name = "change-password")
    public Object[][] providerCredentials() {
        for (int i = 0; i < list.length; i++) {
            list[i][0] = passwordsList[i];
        }
        return list;
    }

    @Test(dataProvider = "change-password")
    public void changePassword_InvalidData_Test(ChangePasswordInvalidData password) {
        SoftAssert softAssert = new SoftAssert();
        coursesPage = new CoursesPage(driver);
        changePasswordPage = new ChangePasswordPage(driver);

        driver.get(Endpoints.COURSES);

        coursesPage
                .getHeader()
                .changePassword()
                .fillCurrentPasswordField(password.getCurrantPassword(), password.getCurrantPasswordResult())
                .fillNewPasswordField(password.getNewPassword(), password.getNewPasswordResult())
                .fillConfirmPasswordField(password.getConfirmPassword(), password.getConfirmPasswordResult())
                .cancelChangePassword();
        softAssert.assertAll();
    }
}
