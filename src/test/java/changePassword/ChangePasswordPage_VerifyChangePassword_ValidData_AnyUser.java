package changePassword;

import base.BaseTest;
import changePassword.dataPasswords.data.ChangePasswordValidData;
import changePassword.dataPasswords.data.UserChangePassword;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.auth.AuthPage;
import page.base.Header;
import page.base.LogIn;
import page.courses.CoursesPage;

import java.io.File;
import java.io.IOException;

public class ChangePasswordPage_VerifyChangePassword_ValidData_AnyUser extends BaseTest {

    private ObjectMapper mapper = new ObjectMapper();
    private ChangePasswordValidData[] passwordsList;
    private UserChangePassword user;
    private LogIn login;
    private CoursesPage coursesPage;
    private Header header;


    @BeforeClass
    public void preconditions() throws IOException, InterruptedException {
        driver.get(Endpoints.BASE_URL);
        login = new LogIn(driver);
        passwordsList = mapper.readValue(
                new File("./src/main/resources/changePassword/ChangePasswordWithPasswords.json"),
                ChangePasswordValidData[].class);
        user = new UserChangePassword("umnik@gmail.com", "Umnik_123");
        login.fillMail(user.getMail())
                .fillPass(user.getPass())
                .clickLogInButton();
        Thread.sleep(2000);
    }

    @DataProvider(name = "log_in")
    public Object[][] providerCredantials() {
        return new Object[][]{
                {passwordsList[0], passwordsList[0]},
                {passwordsList[1], passwordsList[1]},
                {passwordsList[2], passwordsList[2]},
                {passwordsList[3], passwordsList[3]},
                {passwordsList[4], passwordsList[4]},
        };
    }

    @Test(dataProvider = "log_in")
    public void changePassword_ValidData_Test(ChangePasswordValidData newPassword,
                                              ChangePasswordValidData confirmPassword) {
        coursesPage = new CoursesPage(driver);
        header = new Header(driver);
        user = new UserChangePassword("umnik@gmail.com", "Umnik_123");
        driver.get(Endpoints.COURSES);
        AuthPage authPage = new AuthPage(driver);

        this.coursesPage
                .getHeader()
                .changePassword()
                .fillCurrentPasswordField(user.getPass())
                .fillNewPasswordField(newPassword.getNewPassword())
                .fillConfirmPasswordField(confirmPassword.getConfirmPassword())
                .saveChangePassword()
                .confirmChangedPassword()
                .getHeader()
                .logOut();

        helper.waitDownloadPage("http://localhost:8080/auth");

        authPage
                .fillEmailInput(user.getMail())
                .fillPasswordInput(newPassword.getNewPassword()).clickSignIn();

        helper.waitForRedirectFrom("http://localhost:8080/auth");

    }
}
