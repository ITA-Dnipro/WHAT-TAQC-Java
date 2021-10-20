package page.courses;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.AddCoursePage.*;

public class AddCoursePage extends Page<AddCoursePage> {

    public AddCoursePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.ADD_COURSE);
    }

    @FindBy(xpath = ADD_COURSE_NAME_INPUT_FIELD_XPATH)
    private WebElement addCourseNameInput;

    @FindBy(xpath = SAVE_BUTTON_XPATH)
    private WebElement addCourseSaveButton;

    @FindBy(xpath = CANCEL_BUTTON_ADD_COURSE_XPATH)
    private WebElement cancelFromAddCoursePage;

    public AddCoursePage fillInputAddCourseName(String courseName) {
        fillField(addCourseNameInput, courseName);
        return this;
    }

    public CoursesPage saveNewCourse() {
        clickElement(addCourseSaveButton);
        return new CoursesPage(driver);
    }

    public CoursesPage cancelAddCoursePage() {
        clickElement(cancelFromAddCoursePage);
        return new CoursesPage(driver);
    }

    public AddCoursePage verifyAddCourseFieldFilled(String data) {
        softAssert.assertEquals(addCourseNameInput.getText(), data);
        return this;
    }
}
