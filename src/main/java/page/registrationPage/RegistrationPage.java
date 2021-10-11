package page.registrationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.BasePage;
import page.base.LogIn;

import static constants.Locators.RegistrationPage.*

public class RegistrationPage extends BasePage {

    @FindBy (xpath = FIRST_NAME_INPUT_FIELD_XPATH)
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

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public LogIn registerUser (UserRegistration user){
        fillField(firstNameInputField, user.getFirstName());
        fillField(lastNameInputField, user.getLastName());
        fillField(emailInputField, user.getEmail());
        fillField(passwordInputField, user.getPassword());
        fillField(confirmPasswordInputField, user.getPassword());
        clickElement(singUpButton);
        return new LogIn(driver);
    }

    public LogIn returnToLogIn(){
        clickElement(logInLinkedText);
        return new LogIn(driver);
    }
}
