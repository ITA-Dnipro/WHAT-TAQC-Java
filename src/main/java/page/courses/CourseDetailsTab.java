package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.CourseDetailsPage.*;

public class CourseDetailsTab extends Page {

    public CourseDetailsTab(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = ARROW_BUTTON_XPATH)
    private WebElement arrowButton;

     @FindBy (xpath = EDIT_COURSE_DETAILS_TAB_XPATH)
     private WebElement editCourseTab;

    public Courses outFromCourseDetails() {
        clickElement(arrowButton);
        return new Courses(driver);
    }

    public EditCourseDetailsTab redirectToEditCourseDetailsTab() {
        clickElement(editCourseTab);
        return new EditCourseDetailsTab(driver);
    }
}
