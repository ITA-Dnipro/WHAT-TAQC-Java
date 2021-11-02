package page.unauthorizedUserPages;

import constants.Endpoints;
import constants.PathsToFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.BaseElement;
import page.base.Page;
import page.lessons.LessonsPage;
import page.mentors.MentorsTablePage;
import page.students.StudentsPage;
import util.Role;
import util.User;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static constants.Locators.Auth.*;
import static org.awaitility.Awaitility.await;

public class AuthPage extends BaseElement {

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
    User user = new User();


    public AuthPage(WebDriver driver) throws IOException {
        super(driver);
        users = User.get(PathsToFiles.getCreds());
        defaultPages = new HashMap<>();
        initDefaultPages();
    }

   //region Action
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
//endregion

    public <T extends Page> T logInAs(Role role, Class<T> type) {
        fillMail(users.get(role.getRoleName()).getMail())
                .fillPass(users.get(role.getRoleName()).getPass())
                .clickLogInButton();
        return type.cast(defaultPages.get(role.getRoleName()));
    }

    public <T extends Page> T logInAs(Role role, User user, Class<T> type) {
        fillMail(user.getMail())
                .fillPass(user.getPass())
                .clickLogInButton();
        return type.cast(defaultPages.get(role.getRoleName()));
    }

    private void initDefaultPages() {
        defaultPages.put(Role.ADMIN.getRoleName(), new StudentsPage(driver));
        defaultPages.put(Role.MENTOR.getRoleName(), new LessonsPage(driver));
        defaultPages.put(Role.SECRETARY.getRoleName(), new MentorsTablePage(driver));
    }

    public AuthPage isAt() {
        try {
            await().until(() -> driver.getCurrentUrl().equals(Endpoints.AUTH));
            return this;
        } catch (Exception e) {
            return null;
        }
    }

    private void clickLogInButton() {
        clickElement(signInButton);
    }
}
