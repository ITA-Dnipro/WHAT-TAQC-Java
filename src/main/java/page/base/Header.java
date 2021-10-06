package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static constants.Locators.Header.*;

public class Header extends BaseObject {
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

    public enum HeaderItem {
        MY_PROFILE("My profile"),
        CHANGE_PASSWORD("Change password"),
        LOG_OUT("Log Out");

        private final String itemName;

        HeaderItem(String itemName) {
            this.itemName = itemName;
        }

        public String getItemName() {
            return itemName;
        }
    }

    public void openDropDownMenu() {
        fullName = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(fullName));
        clickElement(fullName);
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfAllElements(
                dropDownMenuMyProfile, dropDownMenuChangePassword, dropDownMenuLogOut));
    }

    public void openMyprofileByDropdownMenu() {
        openDropDownMenu();
        clickElement(dropDownMenuMyProfile);
    }

    public void openMyprofileByIcon() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(icon));
        clickElement(icon);
    }

    public void changePassword() {
        openDropDownMenu();
        clickElement(dropDownMenuChangePassword);
    }

    public void logOut() {
        openDropDownMenu();
        clickElement(dropDownMenuLogOut);
    }
}
