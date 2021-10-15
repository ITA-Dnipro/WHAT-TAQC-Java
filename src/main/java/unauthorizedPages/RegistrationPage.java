package unauthorizedPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.BasePage;
import util.UnassignedUser;

import java.io.IOException;

import static constants.Locators.RegistrationPage.*;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = FIRST_NAME_INPUT_FIELD_XPATH)
    WebElement firstNameInputField;
    @FindBy(xpath = LAST_NAME_INPUT_FIELD_XPATH)
    WebElement lastNameInputField;
    @FindBy(xpath = EMAIL_INPUT_FIELD_XPATH)
    WebElement emailInputField;
    @FindBy(xpath = PASSWORD_INPUT_FIELD_XPATH)
    WebElement passwordInputField;
    @FindBy(xpath = CONFIRM_PASSWORD_INPUT_FIELD_XPATH)
    WebElement confirmPasswordInputField;
    @FindBy(xpath = SIGN_UP_BUTTON_XPATH)
    WebElement singUpButton;
    @FindBy(xpath = LOG_IN_XPATH)
    WebElement logInLinkedText;
    @FindBy(xpath = MODAL_WINDOW)
    WebElement modalWindow;
    @FindBy(xpath = MODAL_WINDOW_BUTTON)
    WebElement modalWindowBackButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public Auth registerUser(UnassignedUser user) throws IOException {

        fillInputFirstName(user.getFirstName())
                .fillInputLastName(user.getLastName())
                .fillInputEmail(user.getEmail())
                .fillInputPassword(user.getPassword())
                .fillInputConfirmPassword(user.getPassword())
                .clickSingUpButton()
                .clickModalWindowBackButton();
        return new Auth(driver);
    }

    public RegistrationPage fillInputFirstName(String firstName) {
        fillField(firstNameInputField, firstName);
        return this;
    }

    public RegistrationPage fillInputLastName(String lastName) {
        fillField(lastNameInputField, lastName);
        return this;
    }

    public RegistrationPage fillInputEmail(String email) {
        fillField(emailInputField, email);
        return this;
    }

    public RegistrationPage fillInputPassword(String password) {
        fillField(passwordInputField, password);
        return this;
    }

    public RegistrationPage fillInputConfirmPassword(String password) {
        fillField(confirmPasswordInputField, password);
        return this;
    }

    public RegistrationPage clickSingUpButton() {
        clickElement(singUpButton);
        return this;
    }

    public Auth clickModalWindowBackButton() throws IOException {
        clickElement(modalWindowBackButton);
        return new Auth(driver);
    }

    public Auth returnToLogInPage() throws IOException {
        clickElement(logInLinkedText);
        return new Auth(driver);
    }

}
