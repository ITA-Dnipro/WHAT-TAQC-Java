package page.changePassword;

import constants.Endpoints;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import page.base.Page;
import page.myProfile.MyProfilePage;

import static constants.Locators.ChangePasswordPage.*;

public class ChangePasswordPage extends Page<ChangePasswordPage> {

    private final String VALUE = "value";
    private SoftAssert softAssert = new SoftAssert();

    @FindBy(id = EMAIL_INPUT_FIELD_ID)
    private WebElement emailInput;

    @FindBy(xpath = CURRENT_PASSWORD_INPUT_FIELD_XPATH)
    private WebElement currentPasswordField;

    @FindBy(id = NEW_PASSWORD_INPUT_FIELD_ID)
    private WebElement newPasswordField;

    @FindBy(id = CONFIRM_PASSWORD_INPUT_FIELD_ID)
    private WebElement confirmPasswordField;

    @FindBy(xpath = CANCEL_BUTTON_CHANGE_PASSWORD_XPATH)
    private WebElement cancelButton;

    @FindBy(xpath = SAVE_BUTTON_CHANGE_PASSWORD_XPATH)
    private WebElement saveButton;

    @FindBy(xpath = CANCEL_BUTTON_CONFIRM_ACTION_XPATH)
    private WebElement cancelConfirmAction;

    @FindBy(xpath = CONFIRM_BUTTON_CONFIRM_ACTION_XPATH)
    private WebElement confirmButton;

    @FindBy(xpath = CLOSE_CONFIRM_ACTION_XPATH)
    private WebElement closeConfirmAction;

    @FindBy(xpath = CURRENT_PASSWORD_ERROR_XPATH)
    private WebElement errMessageCurrPassword;

    @FindBy(xpath = NEW_PASSWORD_ERROR_PROVIDE_XPATH)
    private WebElement errMessageNewPassword;

    @FindBy(xpath = CONFIRM_PASSWORD_ERROR_XPATH)
    private WebElement errMessageConfirmPassword;

    @FindBy(xpath = PAGE_TITLE_XPATH)
    WebElement loseFocus;

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.CHANGE_PASSWORD);
    }

    //region Actions
    public ChangePasswordPage checkEmailField() {
        if (emailInput.isDisplayed() && !emailInput.isEnabled())
            clickElement(emailInput);
        return this;
    }

    public ChangePasswordPage fillCurrentPasswordField(String currentPassword) {
        fillField(currentPasswordField, currentPassword);
        return this;
    }

    public ChangePasswordPage fillNewPasswordField(String newPassword) {
        fillField(newPasswordField, newPassword);
        return this;
    }

    public ChangePasswordPage fillConfirmPasswordField(String confirmPassword) {
        fillField(confirmPasswordField, confirmPassword);
        return this;
    }
    public String getCurrentPasswordError() {
        try {
            return errMessageCurrPassword.getText();
        } catch (NotFoundException e) {
            return "";
        }
    }

    public String getNewPasswordError() {
        try {
            return errMessageNewPassword.getText();
        } catch (NotFoundException e) {
            return "";
        }
    }

    public String getConfirmPasswordError() {
        return errMessageConfirmPassword.getText();
    }

    public ChangePasswordPage saveChangePassword() {
        clickElement(saveButton);
        return this;
    }

    public MyProfilePage confirmChangedPassword() {
        clickElement(confirmButton);
        return new MyProfilePage(driver);
    }

    public ChangePasswordPage loseFocus() {
        loseFocus.click();
        return this;
    }
    //endregion

    //region Verifies
    public ChangePasswordPage verifyCurrentPasswordFieldFielded(String data) {
        softAssert.assertEquals(currentPasswordField.getAttribute(VALUE), data);
        return this;
    }

    public ChangePasswordPage verifyNewPasswordFieldFielded(String data) {
        softAssert.assertEquals(newPasswordField.getAttribute(VALUE), data);
        return this;
    }

    public ChangePasswordPage verifyConfirmPasswordFieldFielded(String data) {
        softAssert.assertEquals(confirmPasswordField.getAttribute(VALUE), data);
        return this;
    }

    public ChangePasswordPage verifyCurrentPasswordError(String expectedErrorMessage, String currentPasswordError) {
        softAssert.assertEquals(expectedErrorMessage, currentPasswordError);
        return this;
    }

    public ChangePasswordPage verifyNewPasswordError(String expectedErrorMessage, String newPasswordError) {
        softAssert.assertEquals(newPasswordError, expectedErrorMessage);
        return this;
    }

    public ChangePasswordPage verifyConfirmPasswordError(String expectedErrorMessage, String confirmPasswordError) {
        softAssert.assertEquals(confirmPasswordError, expectedErrorMessage);
        return this;
    }

    public ChangePasswordPage assertChangePasswordPage() {
        assertAll();
        return this;
    }
    //endregion
}
