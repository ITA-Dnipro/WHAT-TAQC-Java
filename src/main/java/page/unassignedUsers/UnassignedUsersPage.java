package page.unassignedUsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Locators.UnassignedUsers.*;

public class UnassignedUsersPage extends BasePage {
    @FindBy(xpath = SEARCH_INPUT_FIELD_XPATH)
    protected WebElement searchInputField;
    @FindBy(xpath = TABLE_HEAD_NAME_XPATH)
    protected WebElement tableHeadFirstName;
    @FindBy(xpath = TABLE_HEAD_SURNAME_XPATH)
    protected WebElement tableHeadLastName;
    @FindBy(xpath = TABLE_HEAD_EMAIL_XPATH)
    protected WebElement tableHeadEmail;
    @FindBy(xpath = TABLE_UNASSIGNED_USERS_XPATH)
    protected WebElement table;
    @FindBy(tagName = TABLE_ROW_TAG_NAME)
    protected List<WebElement> tableRows;

    public UnassignedUsersPage(WebDriver driver) {
        super(driver);
    }

    public UnassignedUsersPage addRole(String email, Role role) {
        WebElement row = findUserRowByEmail(email);
        clickElement(row
                .findElement(By.tagName(TABLE_ROLES_DROPDOWN_MENU_TAG_NAME)));

        List<WebElement> options = row
                .findElements(By.tagName(TABLE_ROLE_DROPDOWN_MENU_OPTIONS_TAG_NAME));
        for (WebElement option : options) {
            if (role.getOption().equals(option.getText()))
                clickElement(option);
        }
        clickElement(row.findElement(By.tagName(TABLE_ADD_ROLE_BUTTON_TAG_NAME)));
        return this;
    }

    public WebElement findUserRowByEmail(String email) {
        WebElement rowUser = tableRows.stream()
                .filter(row -> {
                    List<WebElement> listCells = row.findElements(By.tagName(TABLE_CELL_TAG_NAME))
                            .stream()
                            .limit(3)
                            .filter(cellValue -> cellValue.getText().equals(email))
                            .collect(Collectors.toList());
                    return !listCells.isEmpty();
                })
                .findFirst().orElse(null);
        return rowUser;
    }

}
