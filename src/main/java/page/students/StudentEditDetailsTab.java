package page.students;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static constants.Locators.EditSecretary.SECRETARIES_LAY_OFF_BUTTON_XPATH;
import static constants.Locators.StudentEditDetailsTab.*;

public class StudentEditDetailsTab extends StudentsEditDetailsPage<StudentEditDetailsTab> {
    @FindBy(tagName = PAGE_TITLE_TAG_NAME)
    protected WebElement pageTitle;
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


    private SoftAssert softAssert = new SoftAssert();

    public StudentEditDetailsTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return pageTitle.getText().equals("Student Editing");
    }

    public StudentEditDetailsTab fillInputFirstName(String firstName) {
        fillField(firstNameInputField, firstName);
        return this;
    }

    public StudentEditDetailsTab fillInputLastName(String lastName) {
        fillField(lastNameInputField, lastName);
        return this;
    }

    public StudentEditDetailsTab fillInputEmail(String email) {
        fillField(emailInputField, email);
        return this;
    }

    public StudentsPage clickSaveButton() {
        clickElement(saveButton);
        return new StudentsPage(driver);
    }

    public StudentEditDetailsTab clickClearButton() {
        clickElement(clearButton);
        return this;
    }

    public StudentsPage clickExcludeButton() {
        clickElement(excludeButton);
        return new StudentsPage(driver);
    }

    public StudentEditDetailsTab verifyFillingFirstNameInputField(String data) {
        softAssert.assertEquals(firstNameInputField.getText(), data);
        return this;
    }

    public StudentEditDetailsTab verifyFillingLastNameInputField(String data) {
        softAssert.assertEquals(lastNameInputField.getText(), data);
        return this;
    }

    public StudentEditDetailsTab verifyFillingEmailInputField(String data) {
        softAssert.assertEquals(emailInputField.getText(), data);
        return this;
    }

    public StudentEditDetailsTab verifyClearButtonIsEnabled(boolean condition) {
        softAssert.assertEquals(clearButton.isEnabled(), condition);
        return this;
    }

    public StudentEditDetailsTab verifyExcludeButtonIsEnabled(boolean condition) {
        softAssert.assertEquals(excludeButton.isEnabled(), condition);
        return this;
    }

    public StudentEditDetailsTab verifySaveButtonIsEnabled(boolean condition) {
        softAssert.assertEquals(saveButton.isEnabled(), condition);
        return this;
    }



    public SoftAssert getSoftAssert() {
        return softAssert;
    }
}
