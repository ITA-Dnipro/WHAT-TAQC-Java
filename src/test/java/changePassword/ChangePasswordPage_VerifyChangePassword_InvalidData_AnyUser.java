package changePassword;

import base.BaseTest;
import changePassword.dataPasswords.data.ChangePasswordInvalidData;
import changePassword.dataPasswords.data.ChangePasswordValidData;
import changePassword.dataPasswords.data.UserChangePassword;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.Endpoints;
import constants.ErrorMessages;
import constants.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.base.Header;
import page.base.LogIn;
import page.base.LoseFocus;
import page.changePassword.ChangePasswordPage;
import page.courses.CoursesPage;

import java.io.File;
import java.io.IOException;

public class ChangePasswordPage_VerifyChangePassword_InvalidData_AnyUser extends BaseTest {

    private ObjectMapper mapper = new ObjectMapper();
    private ChangePasswordInvalidData[] passwordsList;
    private UserChangePassword user;
    private LogIn login;
    private CoursesPage coursesPage;
    private Header header;
    LoseFocus loseFocus;
    ChangePasswordPage changePasswordPage;


    @BeforeClass
    public void preconditions () throws IOException {
        driver.get(Endpoints.BASE_URL);
        login = new LogIn(driver);
        passwordsList = mapper.readValue(
                new File("./src/main/resources/changePassword/ChangePassword_InvalidData.json"),
                    ChangePasswordInvalidData[].class);
        user = new UserChangePassword("umnik@gmail.com", "Umnik_123");
        login.fillMail(user.getMail())
                .fillPass(user.getPass())
                .clickLogInButton();
        wait.until(url -> !(driver.getCurrentUrl().equals(Endpoints.AUTH)));
    }

    @DataProvider(name = "change-password")
    public Object[][] providerCredentials() {
        return new Object[][]{
                {user, passwordsList[0]}, {user, passwordsList[1]},
//                {user, passwordsList[2]}, {user, passwordsList[3]},
//                {user, passwordsList[4]}, {user, passwordsList[5]},
//                {user, passwordsList[6]}, {user, passwordsList[7]},
//                {user, passwordsList[8]}, {user, passwordsList[9]},
//                {user, passwordsList[10]}, {user, passwordsList[11]},
        };
    }

    @Test(dataProvider = "change-password")
    public void changePassword_InvalidData_Test(UserChangePassword user,
                                                  ChangePasswordInvalidData password) throws InterruptedException {
        coursesPage = new CoursesPage(driver);
        header = new Header(driver);
        loseFocus = new LoseFocus(driver);
        changePasswordPage = new ChangePasswordPage(driver);
//        user = new UserChangePassword("umnik@gmail.com", "Umnik_123");
        driver.get(Endpoints.COURSES);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Locators.Header.FULL_NAME_XPATH)));
            this.coursesPage
                    .getHeader()
                    .changePassword()
                    .fillCurrentPasswordField(password.getCurrantPassword());
            loseFocus.loseFocus();
            Thread.sleep(3000);
        Assert.assertEquals(changePasswordPage.getCurrentPasswordError(), "This field is required");



//        fillNewPasswordField(newPassword.getNewPassword())
//                    .fillConfirmPasswordField(confirmPassword.getConfirmPassword())
//                    .saveChangePassword()
//                    .confirmChangedPassword()
//                    .getHeader().logOut().fillEmailInput(user.getMail())
//                    .fillPasswordInput(user.getPass()).clickSignIn();

    }
}
