package page.ChangePassword;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.mentors.MentorsTablePage;
import page.myProfile.MyProfilePage;

import static constants.Locators.ChangePasswordPage.*;

public class ChangePasswordPage extends Page {

    @FindBy(id = EMAIL_INPUT_FIELD_ID)
    private WebElement emailInput;

    @FindBy(xpath = CURRENT_PASSWORD_INPUT_FIELD_XPATH)
    private WebElement currentPasswordField;

    @FindBy(xpath = NEW_PASSWORD_INPUT_FIELD_ID)
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

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    public ChangePasswordPage checkEmailField() {
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

    public MentorsTablePage saveChangedPassword() {
        clickElement(confirmButton);
        return new MentorsTablePage(driver);
    }

    public ChangePasswordPage closeConfirmAction() {
        clickElement(closeConfirmAction);
        return this;
    }
}
