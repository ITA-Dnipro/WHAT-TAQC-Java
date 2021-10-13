package page.auth;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.AuthMax.*;

public class AuthPage extends Page {

    public AuthPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = EMAIL_INPUT_FIELD_ID)
    private WebElement emailWebElement;

    @FindBy(id = PASSWORD_INPUT_FIELD_ID)
    private WebElement passwordInput;

    @FindBy(xpath = SIGN_IN_BUTTON_XPATH)
    private WebElement signInButton;

    @FindBy(xpath = FORGOT_PASSWORD_LINK_XPATH)
    private WebElement forgotPasswordLink;

    @FindBy(xpath = REGISTRATION_LINK_XPATH)
    private WebElement registrationLink;

    public AuthPage fillEmailInput(String email) {
        fillField(emailWebElement, email);
        return this;
    }

    public AuthPage fillPasswordInput(String password) {
        fillField(passwordInput, password);
        return this;
    }

    public Page clickSignIn() {
        clickElement(signInButton);
        return this;
    }

    public ForgotPasswordPage redirectToForgotPasswordPage() {
        clickElement(forgotPasswordLink);
        return new ForgotPasswordPage(driver);
    }

    public RegistrationPage redirectToRegistrationPage() {
        clickElement(registrationLink);
        return new RegistrationPage(driver);
    }
}