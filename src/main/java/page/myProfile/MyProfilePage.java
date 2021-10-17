package page.myProfile;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import page.base.Page;

public class MyProfilePage extends Page<MyProfilePage> {
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.MY_PROFILE);
    }

    public interface UpdateCurrentPassword {
        String change(String currentPassword, String newPassword);
    }

    public MyProfilePage updateCurrentPassword(String newPassword) {
        UpdateCurrentPassword change = (currentPassword, newPasswords) -> currentPassword = newPassword;
        return this;
    }
}
