package page.registrationPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.base.BasePage;
import page.base.LogIn;

import java.util.ArrayList;
import java.util.List;

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

    public LogIn registerUser(UserRegistration user, WebDriverWait waiter) {
        fillField(firstNameInputField, user.getFirstName());
        fillField(lastNameInputField, user.getLastName());
        fillField(emailInputField, user.getEmail());
        fillField(passwordInputField, user.getPassword());
        fillField(confirmPasswordInputField, user.getPassword());
        clickElement(singUpButton);
        waiter.until(ExpectedConditions.visibilityOf(modalWindow));
        clickElement(modalWindowBackButton);
        return new LogIn(driver);
    }

    public LogIn returnToLogInPage() {
        clickElement(logInLinkedText);
        return new LogIn(driver);
    }

    public List<WebElement> getAllElements(){
        List <WebElement> listElements = new ArrayList<>();
        listElements.add(firstNameInputField);
        listElements.add(lastNameInputField);
        listElements.add(emailInputField);
        listElements.add(passwordInputField);
        listElements.add(confirmPasswordInputField);
        listElements.add(singUpButton);
        return listElements;
    }
}
