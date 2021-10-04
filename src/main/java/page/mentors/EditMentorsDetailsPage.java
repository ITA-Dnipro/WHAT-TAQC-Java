package page.mentors;

import constants.Locators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

public class EditMentorsDetailsPage extends Page implements Locators.EditMentorsDetailsPage {
    public EditMentorsDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = MENTORS_DETAILS_TAB_XPATH)
    WebElement mentorsDetailsTab;
    @FindBy(xpath = EDIT_MENTOR_TAB_XPATH)
    WebElement editMentorsTab;
    @FindBy(xpath = ARROW_BUTTON_XPATH)
    WebElement arrowButton;
    @FindBy(xpath = FIRSTNAME_INPUT_FIELD_XPATH)
    WebElement firstNameInputField;
    @FindBy(xpath = SECONDNAME_INPUT_FIELD_XPATH)
    WebElement secondNameInputField;
    @FindBy(xpath = EMAIL_INPUT_FIELD_XPATH)
    WebElement emailInputField;
    @FindBy(xpath = GROUPS_INPUT_FIELD_XPATH)
    WebElement groupsInputField;
    @FindBy(xpath = DELETE_GROUP_BUTTON_XPATH)
    WebElement deleteGroupButton;
    @FindBy(xpath = ADD_GROUP_BUTTON_XPATH)
    WebElement addGroupButton;
    @FindBy(xpath = COURSE_INPUT_FIELD_XPATH)
    WebElement courseInputField;
    @FindBy(xpath = DELETE_COURSE_BUTTON_XPATH)
    WebElement deleteCourseButton;
    @FindBy(xpath = ADD_COURSE_BUTTON_XPATH)
    WebElement addCourseButton;
    @FindBy(xpath = DISABLE_BUTTON_XPATH)
    WebElement disableButton;
    @FindBy(xpath = CLEAR_BUTTON_XPATH)
    WebElement clearButton;
    @FindBy(xpath = SAVE_BUTTON_XPATH)
    WebElement saveButton;

    public MentorsTablePage backToMentorsTable() {
        clickElement(arrowButton);
        return new MentorsTablePage(driver);
    }

    public MentorsDetailsPage viewMentorsDetailTab() {
        clickElement(mentorsDetailsTab);
        return new MentorsDetailsPage(driver);
    }

    public EditMentorsDetailsPage viewEditMentorsTab() {
        clickElement(editMentorsTab);
        return this;
    }

    public EditMentorsDetailsPage editName(String name) {
        fillField(firstNameInputField, name);
        return this;
    }

    public EditMentorsDetailsPage editSurname(String surname) {
        fillField(secondNameInputField, surname);
        return this;
    }

    public EditMentorsDetailsPage editEmail(String email) {
        fillField(emailInputField, email);
        return this;
    }

    public EditMentorsDetailsPage editGroup(String group) {
        fillField(groupsInputField, group);
        return this;
    }

    public EditMentorsDetailsPage deleteGroup() {
        clickElement(deleteGroupButton);
        return this;
    }

    public EditMentorsDetailsPage addGroup() {
        clickElement(addGroupButton);
        return this;
    }

    public EditMentorsDetailsPage editCourse(String group) {
        fillField(courseInputField, group);
        return this;
    }

    public EditMentorsDetailsPage deleteCourse() {
        clickElement(deleteCourseButton);
        return this;
    }

    public EditMentorsDetailsPage addCourse() {
        clickElement(addCourseButton);
        return this;
    }

    public MentorsDetailsPage removeMentor() {
        clickElement(disableButton);
        return new MentorsDetailsPage(driver);
    }

    public EditMentorsDetailsPage clearFields() {
        clickElement(clearButton);
        return this;
    }

    public MentorsDetailsPage saveMentor() {
        clickElement(saveButton);
        return new MentorsDetailsPage(driver);
    }
}
