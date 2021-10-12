package page.registrationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.BasePage;
import page.base.LogIn;

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

    public LogIn registerUser(User user) {
        fillField(firstNameInputField, user.getFirstName());
        fillField(lastNameInputField, user.getLastName());
        fillField(emailInputField, user.getEmail());
        fillField(passwordInputField, user.getPassword());
        fillField(confirmPasswordInputField, user.getPassword());
        clickElement(singUpButton);
        return clickModalWindowBackButton();
    }
    public RegistrationPage fillInputField (WebElement inputField, String data){
        fillField(inputField,data);
        return this;
    }
    public WebElement clickSingUpButton(){
        clickElement(singUpButton);
        return modalWindow;
    }
    public LogIn clickModalWindowBackButton(){
        clickElement(modalWindowBackButton);
        return new LogIn(driver);
    }
    public LogIn returnToLogInPage() {
        clickElement(logInLinkedText);
        return new LogIn(driver);
    }
}
