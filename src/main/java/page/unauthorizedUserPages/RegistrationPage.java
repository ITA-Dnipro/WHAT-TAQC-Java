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
        if (firstName != null) {
            fillField(firstNameInputField, firstName);
        }
        return this;
    }

    public RegistrationPage fillInputLastName(String lastName) {
        if (lastName != null) {
            fillField(lastNameInputField, lastName);
        }
        return this;
    }

    public RegistrationPage fillInputEmail(String email) {
        if (email != null) {
            fillField(emailInputField, email);
        }
        return this;
    }

    public RegistrationPage fillInputPassword(String password) {
        if (password != null) {
            fillField(passwordInputField, password);
        }
        return this;
    }

    public RegistrationPage fillInputConfirmPassword(String password) {
        if (password != null) {
            fillField(confirmPasswordInputField, password);
        }
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
        if (data != null) {
            softAssert.assertEquals(firstNameInputField.getAttribute("value"), data);
        }
        return this;
    }

    public RegistrationPage verifyFillingLastNameInputField(String data) {
        softAssert.assertEquals(lastNameInputField.getAttribute("value"), data);
        return this;
    }

    public RegistrationPage verifyFillingEmailInputField(String data) {
        if (data != null) {
            softAssert.assertEquals(emailInputField.getAttribute("value"), data);
        }
        return this;
    }

    public RegistrationPage verifyFillingPasswordInputField(String data) {
        if (data != null) {
            softAssert.assertEquals(passwordInputField.getAttribute("value"), data);
        }
        return this;
    }

    // TODO verify confirmPasswordField is filled with asterisks
    public RegistrationPage verifyFillingConfirmPasswordInputField(String data) {
        if (data != null) {
            softAssert.assertEquals(confirmPasswordInputField.getAttribute("value"), data);
        }
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
        }
        return this;
    }

    public RegistrationPage verifyLastNameErrorIsDisplayed(boolean condition) {
        boolean result = !lastNameError.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyLastNameErrorMessage(String expectedErrorMessage) {
        if (expectedErrorMessage != null) {
            softAssert.assertEquals(lastNameError.getText(), expectedErrorMessage);
        }
        return this;
    }

    public RegistrationPage verifyEmailErrorIsDisplayed(boolean condition) {
        boolean result = !emailError.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyEmailErrorMessage(String expectedErrorMessage) {
        if (expectedErrorMessage != null) {
            softAssert.assertEquals(emailError.getText(), expectedErrorMessage);
        }
        return this;
    }

    public RegistrationPage verifyPasswordErrorIsDisplayed(boolean condition) {
        boolean result = !passwordError.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyPasswordErrorMessage(String expectedErrorMessage) {
        if (expectedErrorMessage != null) {
            String actualResult = passwordError.getText();
            softAssert.assertEquals(actualResult, expectedErrorMessage, "Password message is wrong" + confirmPasswordError.getText());
        }
        return this;
    }

    public RegistrationPage verifyConfirmPasswordErrorIsDisplayed(boolean condition) {
        boolean result = !confirmPasswordError.getText().equals("");
        softAssert.assertEquals(result, condition);
        return this;
    }

    public RegistrationPage verifyConfirmPasswordErrorMessage(String expectedErrorMessage) {
        if (expectedErrorMessage != null) {
            softAssert.assertEquals(confirmPasswordError.getText(), expectedErrorMessage, "ConfirmPassword message is wrong" + confirmPasswordError.getText());
        }
        return this;
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

    public RegistrationPage loseFocus() {
        clickElement(pageTitleName);
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
