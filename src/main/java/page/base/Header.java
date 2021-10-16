package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.changePassword.ChangePasswordPage;
import page.myProfile.MyProfilePage;

import static constants.Locators.Header.*;

public class Header extends BasePage {
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

    public void openDropDownMenu() {
        clickElement(triangleIcon);
    }

    public void openMyProfileByDropdownMenu() {
        openDropDownMenu();
        clickElement(dropDownMenuMyProfile);
    }

    public MyProfilePage openMyProfileByIcon() {
        clickElement(icon);
        return new MyProfilePage(driver);
    }

    public ChangePasswordPage changePassword() {
        openDropDownMenu();
        clickElement(dropDownMenuChangePassword);
        return new ChangePasswordPage(driver);
    }

    public LogIn logOut() {
        openDropDownMenu();
        clickElement(dropDownMenuLogOut);
        return new LogIn(driver);
    }
}
