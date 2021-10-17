package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.CourseDetailsPage.*;

public class CourseDetailsTab extends Page<CourseDetailsTab> {

    public CourseDetailsTab(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = COURSE_DETAILS_TAB_TITLE_XPATH)
    private WebElement title;

    @FindBy(xpath = ARROW_BUTTON_XPATH)
    private WebElement arrowButton;

    @FindBy(xpath = EDIT_COURSE_DETAILS_TAB_XPATH)
    private WebElement editCourseTab;

    @Override
    public boolean isAt() {
        String courseDetailsTabTitle = "Course Details";
        return title.getText().contains(courseDetailsTabTitle);
    }

    public CoursesPage outFromCourseDetails() {
        clickElement(arrowButton);
        return new CoursesPage(driver);
    }

    public EditCourseDetailsTab redirectToEditCourseDetailsTab() {
        clickElement(editCourseTab);
        return new EditCourseDetailsTab(driver);
    }

    public EditCourseDetailsTab refreshPage() {
        driver.navigate().refresh();
        return new EditCourseDetailsTab(driver);
    }
}
