package page.unauthorizedUserPages;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.BaseElement;
import util.UnassignedUser;

import java.io.IOException;

import static constants.Locators.RegistrationPage.*;
import static org.awaitility.Awaitility.await;

public class RegistrationPage extends BaseElement {

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
    @FindBy(xpath = FIRST_NAME_ERROR_XPATH)
    WebElement firstNameError;
    @FindBy(xpath = LAST_NAME_ERROR_XPATH)
    WebElement lastNameError;
    @FindBy(xpath = EMAIL_ERROR_XPATH)
    WebElement emailError;
    @FindBy(xpath = PASSWORD_ERROR_XPATH)
    WebElement passwordError;
    @FindBy(xpath = CONFIRM_PASSWORD_ERROR_XPATH)
    WebElement confirmPasswordError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public AuthPage registerUser(UnassignedUser user) throws IOException {
        fillInputFirstName(user.getFirstName())
                .fillInputLastName(user.getLastName())
                .fillInputEmail(user.getEmail())
                .fillInputPassword(user.getPassword())
                .fillInputConfirmPassword(user.getPassword())
                .clickSingUpButton()
                .clickModalWindowBackButton();
        return new AuthPage(driver);
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

    public AuthPage clickModalWindowBackButton() throws IOException {
        clickElement(modalWindowBackButton);
        return new AuthPage(driver);
    }

    public AuthPage returnToLogInPage() throws IOException {
        clickElement(logInLinkedText);
        return new AuthPage(driver);
    }

    public RegistrationPage verifyFillingFirstNameInputField(String data) {
        softAssert.assertEquals(firstNameInputField.getAttribute("value"), data);
        return this;
    }

    public RegistrationPage verifyFillingLastNameInputField(String data) {
        softAssert.assertEquals(lastNameInputField.getAttribute("value"), data);
        return this;
    }

    public RegistrationPage verifyFillingEmailInputField(String data) {
        softAssert.assertEquals(emailInputField.getAttribute("value"), data);
        return this;
    }

    public RegistrationPage verifyFillingPasswordInputField(String data) {
        softAssert.assertEquals(passwordInputField.getAttribute("value"), data);
        return this;
    }

    // TODO verify confirmPasswordField is filled with asterisks
    public RegistrationPage verifyFillingConfirmPasswordInputField(String data) {
        softAssert.assertEquals(confirmPasswordInputField.getAttribute("value"), data);
        return this;
    }

    public RegistrationPage verifyFirstNameErrorIsDisplayed(boolean condition) {
        boolean result = !firstNameError.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyFirstNameErrorMessage(String expectedErrorMessage) {
        if (!firstNameError.getText().equals("")) {
            softAssert.assertEquals(firstNameError.getText(), expectedErrorMessage);
            return this;
        } else {
            return verifyFirstNameErrorIsDisplayed(true);
        }

    }

    public RegistrationPage verifyLastNameErrorIsDisplayed(boolean condition) {
        boolean result = !lastNameError.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyLastNameErrorMessage(String expectedErrorMessage) {
        if (!lastNameError.getText().equals("")) {
            softAssert.assertEquals(lastNameError.getText(), expectedErrorMessage);
            return this;
        } else {
            return verifyLastNameErrorIsDisplayed(true);
        }

    }

    public RegistrationPage verifyEmailErrorIsDisplayed(boolean condition) {
        boolean result = !emailError.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyEmailErrorMessage(String expectedErrorMessage) {
        if (!emailError.getText().equals("")) {
            softAssert.assertEquals(emailError.getText(), expectedErrorMessage);
            return this;
        } else {
            return verifyEmailErrorIsDisplayed(true);
        }
    }

    public RegistrationPage verifyPasswordErrorIsDisplayed(boolean condition) {
        boolean result = !passwordError.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyPasswordErrorMessage(String expectedErrorMessage) {
        if (!passwordError.getText().equals("")) {
            softAssert.assertEquals(passwordError.getText(), expectedErrorMessage);
            return this;
        } else {
            return verifyPasswordErrorIsDisplayed(true);
        }
    }

    public RegistrationPage verifyConfirmPasswordErrorIsDisplayed(boolean condition) {
        boolean result = !confirmPasswordError.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyConfirmPasswordErrorMessage(String expectedErrorMessage) {
        if (!confirmPasswordError.getText().equals("")) {
            softAssert.assertEquals(confirmPasswordError.getText(), expectedErrorMessage);
            return this;
        } else {
            return verifyConfirmPasswordErrorIsDisplayed(true);
        }
    }

    public RegistrationPage verifySingInButtonIsEnabled() {
        softAssert.assertTrue(singUpButton.isEnabled());
        return this;
    }

    public RegistrationPage verifyLogInLinkIsEnabled() {
        softAssert.assertTrue(logInLinkedText.isEnabled());
        return this;
    }

    public RegistrationPage verifyModalWindowIsOpened() {
        softAssert.assertTrue(modalWindow.isDisplayed());
        return this;
    }

    public RegistrationPage verifyInputFieldsAreEmpty() {
        this.verifyFillingFirstNameInputField("")
                .verifyFillingLastNameInputField("")
                .verifyFillingEmailInputField("")
                .verifyFillingPasswordInputField("")
                .verifyFillingConfirmPasswordInputField("");
        return this;
    }

    public RegistrationPage verifyErrorMessagesAreNotDisplayed() {
        this.verifyFirstNameErrorIsDisplayed(false)
                .verifyLastNameErrorIsDisplayed(false)
                .verifyEmailErrorIsDisplayed(false)
                .verifyPasswordErrorIsDisplayed(false)
                .verifyConfirmPasswordErrorIsDisplayed(false);
        return this;
    }

    public RegistrationPage isAt() {
        try {
            await().until(() -> driver.getCurrentUrl().equals(Endpoints.REGISTRATION));
            return this;
        } catch (Exception e) {
            return null;
        }
    }
}
