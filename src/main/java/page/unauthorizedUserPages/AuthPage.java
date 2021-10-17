package page.unauthorizedUserPages;

import constants.Endpoints;
import constants.PathsToFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.students.StudentsPage;
import page.base.BasePage;
import page.base.Page;
import page.lessons.LessonsPage;
import util.Role;
import util.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static constants.Locators.Auth.*;

public class AuthPage extends BasePage {

    @FindBy(name = EMAIL_INPUT_FIELD_NAME)
    WebElement mailInput;

    @FindBy(name = PASSWORD_INPUT_FIELD_NAME)
    WebElement passInput;

    @FindBy(xpath = SIGN_IN_BUTTON_XPATH)
    WebElement signInButton;
    @FindBy(xpath = REGISTRATION_LINK_XPATH)
    WebElement registrationLink;

    Map<String, Page> defaultPages;
    Map<String, User> users;


    public AuthPage(WebDriver driver) throws IOException {
        super(driver);
        users = User.get(PathsToFiles.CREDENTIALS);
        defaultPages = new HashMap<>();
        initDefaultPages();
    }

    public AuthPage fillMail(String mail) {
        fillField(mailInput, mail);
        return this;
    }

    public AuthPage fillPass(String pass) {
        fillField(passInput, pass);
        return this;
    }

    public RegistrationPage clickRegistrationLink() {
        clickElement(registrationLink);
        return new RegistrationPage(driver);
    }

    public static AuthPage init(WebDriver driver) throws IOException {
        return new AuthPage(driver);
    }


    public <T extends Page> T logInAs(Role role, Class<T> type) {
        fillMail(users.get(role.getRoleName()).getMail())
                .fillPass(users.get(role.getRoleName()).getPass())
                .clickLogInButton();
        return type.cast(defaultPages.get(role.getRoleName()));
    }

    private void initDefaultPages() {
        defaultPages.put(Role.ADMIN.getRoleName(), new StudentsPage(driver));
        defaultPages.put(Role.MENTOR.getRoleName(), new LessonsPage(driver));
    }

    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.AUTH);
    }

    private void clickLogInButton() {
        clickElement(signInButton);
    }

    public Page clickSignIn() {
        clickElement(signInButton);
        return new LessonsPage(driver);
    }
}
