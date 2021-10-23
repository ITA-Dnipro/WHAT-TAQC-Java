package page.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import static constants.Locators.CommonElements.*;

public class SideBar extends BaseElement {

    @FindBy(xpath = SIDE_BAR_XPATH)
    private List<WebElement> sideBarItems;

    public SideBar(WebDriver driver) {
        super(driver);
    }

    public WebElement getSideBarItem(SideMenuItem item){
        return getItemFromMenu(sideBarItems, item.itemName);
    }

    public List<WebElement> getSideBarItems() {
        return sideBarItems;
    }

    public <T> T clickSideBarItem(SideMenuItem item, T page){
        getItemFromMenu(sideBarItems, item.itemName).click();
        return page;
    }
    public enum SideMenuItem {
        STUDENTS("Students"),
        MENTORS("Mentors"),
        SECRETARIES("Secretaries"),
        LESSONS("Lessons"),
        GROUPS("Groups"),
        COURSES("Courses"),
        SCHEDULE("Schedule"),
        ASSIGNMENT("Assignment");

        private final String itemName;

        SideMenuItem(String itemName) {
            this.itemName = itemName;
        }

        public String getItemName() {
            return itemName;
        }
    }
}
