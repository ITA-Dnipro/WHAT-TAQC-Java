package page.unassignedUsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.base.BasePage;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Locators.UnassignedUsers.*;

public class UnassignedUsers extends BasePage {
    @FindBy (xpath = UNASSIGNED_USERS_SEARCH_INPUT_FIELD_XPATH)
    protected WebElement searchInputField;
    @FindBy (xpath = UNASSIGNED_USERS_TABLE_HEAD_NAME_XPATH )
    protected WebElement tableHeadFirstName;
    @FindBy (xpath = UNASSIGNED_USERS_TABLE_HEAD_SURNAME_XPATH)
    protected WebElement tableHeadLastName;
    @FindBy (xpath = UNASSIGNED_USERS_TABLE_HEAD_EMAIL_XPATH)
    protected WebElement tableHeadEmail;
    @FindBy (xpath = UNASSIGNED_USERS_ROLE_DROPDOWN_MENU_XPATH)
    protected WebElement roleDropDownMenu;
    @FindBy (xpath = UNASSIGNED_USERS_STUDENT_ROLE_XPATH)
    protected WebElement studentRole;
    @FindBy (xpath = UNASSIGNED_USERS_MENTOR_ROLE_XPATH)
    protected WebElement mentorRole;
    @FindBy (xpath = UNASSIGNED_USERS_SECRETARY_ROLE_XPATH)
    protected WebElement secretaryRole;
    @FindBy (xpath = UNASSIGNED_USERS_ADD_ROLE_BUTTON_XPATH)
    protected WebElement addRoleButton;
    @FindBy(xpath = TABLE_UNASSIGNED_USERS_XPATH)
    protected WebElement tableUnassignedUsers;
    @FindBy (tagName = TABLE_ROW_TAG_NAME)
    protected List <WebElement> tableUnassignedUsersRows;


    public UnassignedUsers(WebDriver driver) {
        super(driver);
    }

    public UnassignedUsers addStudentRole (String email, WebDriverWait waiter){
        waiter.until(ExpectedConditions
                .visibilityOfNestedElementsLocatedBy(tableUnassignedUsers, By.tagName(TABLE_ROW_TAG_NAME)));
        WebElement row = findUserByEmail(email);
        clickElement(row.findElement(By.xpath(UNASSIGNED_USERS_ROLE_DROPDOWN_MENU_XPATH)));
        waiter.until(ExpectedConditions.visibilityOf(studentRole));
        clickElement(studentRole);
        clickElement(row.findElement(By.xpath(UNASSIGNED_USERS_ADD_ROLE_BUTTON_XPATH)));
        return this;
    }
    public UnassignedUsers addMentorRole (){
        clickElement(roleDropDownMenu);
        clickElement(mentorRole);
        clickElement(addRoleButton);
        return this;
    }
    public UnassignedUsers addSecretaryRole (){
        clickElement(roleDropDownMenu);
        clickElement(mentorRole);
        clickElement(addRoleButton);
        return this;
    }

    public WebElement findUserByEmail(String email){
        WebElement rowUser = tableUnassignedUsersRows.stream()
                .filter(row -> {
                    List<WebElement> listCells = row.findElements(By.tagName(TABLE_CELL_TAG_NAME))
                            .stream()
                            .limit(3)
                            .filter(cellValue-> cellValue.getText().equals(email))
                            .collect(Collectors.toList());
                    return !listCells.isEmpty();
                })
                .findFirst().orElse(null);
        return rowUser;
    }
}
