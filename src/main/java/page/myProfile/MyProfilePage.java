package page.myProfile;

import constants.Endpoints;
import constants.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.changePassword.ChangePasswordPage;

import static constants.Locators.MyProfile.CHANGE_PASSWORD_BUTTON;

public class MyProfilePage extends Page<MyProfilePage> {
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = CHANGE_PASSWORD_BUTTON)
    private WebElement changePasswordButton;

    @Override
    public boolean isAt() {
        return changePasswordButton.isEnabled();
    }

    public interface UpdateCurrentPassword {
        String change(String currentPassword, String newPassword);
    }

    public MyProfilePage updateCurrentPassword(String newPassword) {
        UpdateCurrentPassword change = (currentPassword, newPasswords) -> currentPassword = newPassword;
        return this;
    }

    public ChangePasswordPage clickChangePasswordButton() {
        log.info(changePasswordButton.getText());
        clickElement(changePasswordButton);

        return new ChangePasswordPage(driver);
    }
}
