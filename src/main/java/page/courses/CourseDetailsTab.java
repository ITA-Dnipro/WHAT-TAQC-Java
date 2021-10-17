package page.courses;

import constants.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.CourseDetailsPage.ARROW_BUTTON_XPATH;
import static constants.Locators.CourseDetailsPage.EDIT_COURSE_DETAILS_TAB_XPATH;

public class CourseDetailsTab extends Page<CourseDetailsTab> {

    public CourseDetailsTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        String courseDetailsTabTitle = "Course Details";
        return driver.findElement(By.xpath(
                Locators.CourseDetailsPage.COURSE_DETAILS_TAB_TITLE_XPATH)).getText()
                    .contains(courseDetailsTabTitle);
    }

    @FindBy (xpath = ARROW_BUTTON_XPATH)
    private WebElement arrowButton;

     @FindBy (xpath = EDIT_COURSE_DETAILS_TAB_XPATH)
     private WebElement editCourseTab;

    public CoursesPage outFromCourseDetails() {
        clickElement(arrowButton);
        return new CoursesPage(driver);
    }

    public EditCourseDetailsTab redirectToEditCourseDetailsTab() {
        clickElement(editCourseTab);
        return new EditCourseDetailsTab(driver);
    }
}
