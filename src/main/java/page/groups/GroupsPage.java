package page.groups;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import java.util.List;

import static constants.Locators.Groups.*;

public class GroupsPage extends Page<GroupsPage> {

    @FindBy(xpath = ADD_GROUP_BUTTON_XPATH)
    WebElement addGroupButton;

    @FindBy(xpath = TABLE_ROWS_XPATH)
    List<WebElement> rows;

    @FindBy(xpath = EDIT_LESSON_PENCIL_ICON_XPATH)
    List<WebElement> edit;

    @FindBy(xpath = ALERT_XPATH)
    WebElement alert;

    public GroupsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.GROUPS);
    }

    public static GroupsPage init(WebDriver driver){
        return new GroupsPage(driver);
    }

    public AddGroupPage clickAddGroupButton(){
        clickElement(addGroupButton);
        return new AddGroupPage(driver);
    }

    public String getAlertText(){
        return alert.getText();
    }

    public EditGroupPage clickTableItem(int id){
        rows.get(id).click();
        return new EditGroupPage(driver);
    }

    public EditGroupPage clickEditIcon(int id){
        edit.get(id).click();
        return new EditGroupPage(driver);
    }

    public boolean isGroups(){
        return rows.size() != 0;
    }

    public List<WebElement> getEdit() {
        return edit;
    }
}
