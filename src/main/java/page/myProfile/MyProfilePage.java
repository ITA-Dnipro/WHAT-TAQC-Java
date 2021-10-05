package page.myProfile;

import constants.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

public class MyProfilePage extends Page implements Locators.MyProfile {
    public MyProfilePage(WebDriver driver) {
        super(driver);
    }

    protected @FindBy(xpath = CHANGE_PASSWORD_BUTTON)
    WebElement changePasswordButton;
}
