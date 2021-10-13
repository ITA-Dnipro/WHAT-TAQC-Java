package page.changePassword;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import page.base.Page;
import page.myProfile.MyProfilePage;

import static constants.ErrorMessages.GetChangePasswordErrorMessage.*;
import static constants.Locators.ChangePasswordPage.*;

public class ChangePasswordPage extends Page {

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

    SoftAssert softAssert = new SoftAssert();

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public ChangePasswordPage checkEmailField() {
        clickElement(emailInput);
        return this;
    }

    public ChangePasswordPage fillCurrentPasswordField(String currentPassword, String errorMessage) {
        fillField(currentPasswordField, currentPassword);
//        verifyErrors(errorMessage, errMessageCurrPassword);
        return this;
    }

    public ChangePasswordPage fillNewPasswordField(String newPassword, String errorMessage) {
        fillField(newPasswordField, newPassword);
//        verifyErrors(errorMessage, errMessageNewPassword);
        return this;
    }

    public ChangePasswordPage fillConfirmPasswordField(String confirmPassword, String errorMessage) {
        fillField(confirmPasswordField, confirmPassword);
//        verifyErrors(errorMessage, errMessageConfirmPassword);
        return this;
    }

    public MyProfilePage cancelChangePassword() {
        clickElement(cancelButton);
        return new MyProfilePage(driver);
    }

    public ChangePasswordPage saveChangePassword() {
        clickElement(saveButton);
        return this;
    }

    public ChangePasswordPage cancelConfirmAction() {
        clickElement(cancelConfirmAction);
        return this;
    }

    public MyProfilePage confirmChangedPassword() {
        clickElement(confirmButton);
        return new MyProfilePage(driver) {
        };
    }

    public ChangePasswordPage closeConfirmAction() {
        clickElement(closeConfirmAction);
        return this;
    }

    public String getCurrentPasswordError() {
        return errMessageCurrPassword.getText();
    }

    public String getNewPasswordError() {
        return errMessageNewPassword.getText();
    }

    public String getConfirmPasswordError() {
        return errMessageConfirmPassword.getText();
    }

    private void verifyErrors( String errorMessage, WebElement error) {
        loseFocus();
        try {
            softAssert.assertEquals(error.getText(), errorMessage);
        }
        catch (NotFoundException e){
            //TODO Logger!
        }
    }

    public void loseFocus() {
        loseFocus.click();
    }
}
