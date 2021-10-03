package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.AddCoursePage.*;

public class AddCoursePage extends Page {

    public AddCoursePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = COURSE_NAME_INPUT_FIELD_XPATH)
    private WebElement courseNameInput;

    @FindBy (xpath = SAVE_BUTTON_XPATH)
    private WebElement addCourseSaveButton;

    @FindBy (xpath = CANCEL_BUTTON_ADD_COURSE_XPATH)
    WebElement cancelFromAddCoursePage;

    public AddCoursePage inputAddCourseName(String courseName) {
        fillField(courseNameInput, courseName);
        return this;
    }

    public Courses saveNewCourse() {
        clickElement(addCourseSaveButton);
        return new Courses(driver);
    }

    public Courses cancelAddCoursePage () {
        clickElement(cancelFromAddCoursePage);
        return new Courses(driver);
    }
}
