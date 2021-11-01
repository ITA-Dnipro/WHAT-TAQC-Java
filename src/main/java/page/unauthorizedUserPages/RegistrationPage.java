package page.unauthorizedUserPages;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.BaseElement;
import util.UnassignedUser;

import java.io.IOException;
import java.time.Duration;

import static constants.Locators.RegistrationPage.*;
import static org.awaitility.Awaitility.await;

public class RegistrationPage extends BaseElement implements Waiter{

    @FindBy(tagName = PAGE_TITLE_TAG_NAME)
    WebElement pageTitleName;
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
    @FindBy(xpath = MODAL_WINDOW_XPATH)
    WebElement modalWindow;
    @FindBy(xpath = MODAL_WINDOW_BUTTON_XPATH)
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

    private final String EMPTY_STRING = "";

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage isAt() {
        try {
            await().until(() -> driver.getCurrentUrl().equals(Endpoints.REGISTRATION));
            return this;
        } catch (Exception e) {
            return null;
        }
    }
    public RegistrationPage waitUntilModalWindowVisible(){
        waitUntilElementVisibility(driver,modalWindow, Duration.ofSeconds(3));
        return this;
    }

    public AuthPage registerUser(UnassignedUser user) throws IOException {
        fillInputFirstName(user.getFirstName())
                .fillInputLastName(user.getLastName())
                .fillInputEmail(user.getEmail())
                .fillInputPassword(user.getPassword())
                .fillInputConfirmPassword(user.getPassword())
                .clickSingUpButton()
                .clickConfirmRegistrationModalWindowBackButton();
        return new AuthPage(driver);
    }

    //    region Actions on the Page
    public RegistrationPage loseFocus() {
        clickElement(pageTitleName);
        return this;
    }

    public RegistrationPage clickSingUpButton() {
        clickElement(singUpButton);
        return this;
    }

    public AuthPage clickConfirmRegistrationModalWindowBackButton() throws IOException {
        clickElement(modalWindowBackButton);
        return new AuthPage(driver);
    }

    // region Fill Inputs
    private RegistrationPage fillInputField(WebElement inputField, String data) {
        if (data != null) {
            fillField(inputField, data);
        }
        return this;
    }

    public RegistrationPage fillInputFirstName(String firstName) {
        return fillInputField(firstNameInputField, firstName);
    }

    public RegistrationPage fillInputLastName(String lastName) {
        return fillInputField(lastNameInputField, lastName);
    }

    public RegistrationPage fillInputEmail(String email) {
        return fillInputField(emailInputField, email);
    }

    public RegistrationPage fillInputPassword(String password) {
        return fillInputField(passwordInputField, password);
    }

    public RegistrationPage fillInputConfirmPassword(String password) {
        return fillInputField(confirmPasswordInputField, password);
    }
    // endregion
    // endregion

    //    region Verify Input fields filling by data
    public RegistrationPage verifyInputFieldsAreEmpty() {

        verifyFillingFirstNameInputField(EMPTY_STRING)
                .verifyFillingLastNameInputField(EMPTY_STRING)
                .verifyFillingEmailInputField(EMPTY_STRING)
                .verifyFillingPasswordInputField(EMPTY_STRING)
                .verifyFillingConfirmPasswordInputField(EMPTY_STRING);
        return this;
    }

    private RegistrationPage verifyFillingInputField(WebElement inputField, String data) {
        if (data != null) {
            softAssert.assertEquals(inputField.getAttribute("value"), data);
        }
        return this;
    }

    public RegistrationPage verifyFillingFirstNameInputField(String data) {
        return verifyFillingInputField(firstNameInputField, data);
    }

    public RegistrationPage verifyFillingLastNameInputField(String data) {
        return verifyFillingInputField(lastNameInputField, data);
    }

    public RegistrationPage verifyFillingEmailInputField(String data) {
        return verifyFillingInputField(emailInputField, data);
    }

    public RegistrationPage verifyFillingPasswordInputField(String data) {
        return verifyFillingInputField(passwordInputField, data);
    }

    public RegistrationPage verifyFillingConfirmPasswordInputField(String data) {
        return verifyFillingInputField(confirmPasswordInputField, data);
    }

    //    endregion
    // region Verify errors displayed
    public RegistrationPage verifyErrorMessagesAreNotDisplayed() {
        verifyFirstNameErrorIsDisplayed(false)
                .verifyLastNameErrorIsDisplayed(false)
                .verifyEmailErrorIsDisplayed(false)
                .verifyPasswordErrorIsDisplayed(false)
                .verifyConfirmPasswordErrorIsDisplayed(false);
        return this;
    }

    private RegistrationPage verifyErrorIsDisplayed(WebElement errorField, boolean condition) {
        boolean result = !errorField.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyFirstNameErrorIsDisplayed(boolean condition) {
        return verifyErrorIsDisplayed(firstNameError, condition);
    }

    public RegistrationPage verifyLastNameErrorIsDisplayed(boolean condition) {
        return verifyErrorIsDisplayed(lastNameError, condition);
    }

    public RegistrationPage verifyEmailErrorIsDisplayed(boolean condition) {
        return verifyErrorIsDisplayed(emailError, condition);
    }

    public RegistrationPage verifyPasswordErrorIsDisplayed(boolean condition) {
        return verifyErrorIsDisplayed(passwordError, condition);
    }

    public RegistrationPage verifyConfirmPasswordErrorIsDisplayed(boolean condition) {
        return verifyErrorIsDisplayed(confirmPasswordError, condition);
    }
    //    endregion

    //  region  Verify errors' messages
    public RegistrationPage verifyErrorMessage(WebElement element, String expectedErrorMessage) {
        if (expectedErrorMessage != null) {
            softAssert.assertEquals(element.getText(), expectedErrorMessage);
        }
        return this;
    }

    public RegistrationPage verifyFirstNameErrorMessage(String expectedErrorMessage) {
        return verifyErrorMessage(firstNameError, expectedErrorMessage);
    }

    public RegistrationPage verifyLastNameErrorMessage(String expectedErrorMessage) {
        return verifyErrorMessage(lastNameError, expectedErrorMessage);
    }

    public RegistrationPage verifyEmailErrorMessage(String expectedErrorMessage) {
        return verifyErrorMessage(emailError, expectedErrorMessage);
    }

    public RegistrationPage verifyPasswordErrorMessage(String expectedErrorMessage) {
        return verifyErrorMessage(passwordError, expectedErrorMessage);
    }

    public RegistrationPage verifyConfirmPasswordErrorMessage(String expectedErrorMessage) {
        return verifyErrorMessage(confirmPasswordError, expectedErrorMessage);
    }
    //endregion

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


}
