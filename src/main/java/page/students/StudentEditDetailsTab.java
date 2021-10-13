package page.students;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.Locators.StudentEditDetailsTab.*;

public class StudentEditDetailsTab extends StudentsEditDetailsPage {
    @FindBy(xpath = FIRST_NAME_INPUT_FIELD_XPATH)
    protected WebElement firstNameInputField;
    @FindBy(xpath = LAST_NAME_INPUT_FIELD_XPATH)
    protected WebElement lastNameInputField;
    @FindBy(xpath = EMAIL_INPUT_FIELD_XPATH)
    protected WebElement emailInputField;
    @FindBy(xpath = GROUPS_INPUT_FIELD_XPATH)
    protected WebElement groupsInputField;
    @FindBy(xpath = GROUPS_PLUS_BUTTON_XPATH)
    protected WebElement groupsPlusButton;
    @FindBy(xpath = GROUPS_LIST_XPATH)
    protected List<WebElement> groupsList;
    @FindBy(xpath = EXCLUDE_BUTTON_XPATH)
    protected WebElement excludeButton;
    @FindBy(xpath = CLEAR_BUTTON_XPATH)
    protected WebElement clearButton;
    @FindBy(xpath = SAVE_BUTTON_XPATH)
    protected WebElement saveButton;

    public StudentEditDetailsTab(WebDriver driver) {
        super(driver);
    }

}
