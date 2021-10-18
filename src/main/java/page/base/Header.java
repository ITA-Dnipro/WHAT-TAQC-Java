package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.myProfile.MyProfilePage;
import page.unauthorizedUserPages.AuthPage;

import java.io.IOException;

import static constants.Locators.Header.*;

public class Header extends BaseElement {
    @FindBy(xpath = LOGO_XPATH)
    private WebElement logo;
    @FindBy(xpath = ICON_XPATH)
    private WebElement icon;
    @FindBy(xpath = FULL_NAME_XPATH)
    private WebElement fullName;
    @FindBy(xpath = DROP_DOWN_MENU_MY_PROFILE_XPATH)
    private WebElement dropDownMenuMyProfile;
    @FindBy(xpath = DROP_DOWN_MENU_CHANGE_PASSWORD_XPATH)
    private WebElement dropDownMenuChangePassword;
    @FindBy(xpath = DROP_DOWN_MENU_LOG_OUT_XPATH)
    private WebElement dropDownMenuLogOut;
    @FindBy(xpath = TRIANGLE_ICON_XPATH)
    private WebElement triangleIcon;

    public Header(WebDriver driver) {
        super(driver);
    }

    public AuthPage logOut() throws IOException {
        clickElement(triangleIcon);
        clickElement(dropDownMenuLogOut);
        return new AuthPage(driver);
    }

    public MyProfilePage clickUserIcon() {
        clickElement(icon);
        return new MyProfilePage(driver);
    }
}
