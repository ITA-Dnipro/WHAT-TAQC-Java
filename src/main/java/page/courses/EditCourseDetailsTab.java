package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.CourseDetailsPage.*;

public class EditCourseDetailsTab extends Page {

    public EditCourseDetailsTab(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ARROW_BUTTON_XPATH)
    private WebElement arrowButton;

    @FindBy(xpath = COURSE_DETAILS_TAB_XPATH)
    private WebElement courseDetailsTab;

    @FindBy(xpath = COURSE_NAME_INPUT_FIELD_XPATH)
    private WebElement courseNameInput;

    @FindBy(xpath = DELETE_BUTTON_XPATH)
    private WebElement deleteButtonEditCourseTab;

    @FindBy(xpath = CANCEL_BUTTON_CONFIRM_ACTION_XPATH)
    private WebElement cancelButton;

    @FindBy(xpath = CLOSE_BUTTON_CONFIRM_ACTION_XPATH)
    private WebElement closeButton;

    @FindBy(xpath = DELETE_BUTTON_CONFIRM_ACTION_XPATH)
    private WebElement deleteButton;

    @FindBy(xpath = CLEAR_BUTTON_XPATH)
    private WebElement clearButton;

    @FindBy(xpath = SAVE_BUTTON_XPATH)
    private WebElement saveButton;

    public Courses outFromEditCourseDetails() {
        clickElement(arrowButton);
        return new Courses(driver);
    }

    public CourseDetailsTab redirectToCourseDetailsTab() {
        clickElement(courseDetailsTab);
        return new CourseDetailsTab(driver);
    }

    public EditCourseDetailsTab fillCourseName(String courseName) {
        fillField(courseNameInput, courseName);
        return this;
    }

    public EditCourseDetailsTab deleteCourse() {
        clickElement(deleteButtonEditCourseTab);
        return this;
    }

    public EditCourseDetailsTab cancelDeleteAction() {
        clickElement(cancelButton);
        return this;
    }

    public EditCourseDetailsTab closeConfirmAction() {
        clickElement(closeButton);
        return this;
    }

    public Courses confirmDeleteCourse() {
        clickElement(deleteButtonEditCourseTab);
        return new Courses(driver);
    }

    public EditCourseDetailsTab clearChanges() {
        clickElement(clearButton);
        return this;
    }

    public Courses saveChangeCurseName() {
        clickElement(saveButton);
        return new Courses(driver);
    }
}