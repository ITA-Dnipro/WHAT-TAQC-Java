package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static constants.Locators.CommonElements.*;

public class SideBar extends BasePage{

    @FindBy(xpath = SIDE_BAR_XPATH)
    private List<WebElement> sideBarItems;

    public SideBar(WebDriver driver) {
        super(driver);
    }

    public WebElement getSideBarItem(String name){
        return getItemFromMenu(sideBarItems, name);
    }

    public List<WebElement> getSideBarItems() {
        return sideBarItems;
    }
}
