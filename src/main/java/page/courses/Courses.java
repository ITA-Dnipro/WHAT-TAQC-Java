package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import static constants.Locators.Courses.EDIT_BUTTON_ADMIN_SECRETARY_XPATH;


public class Courses extends Page {

    public Courses(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = EDIT_BUTTON_ADMIN_SECRETARY_XPATH)
    WebElement EditButton;

    private EditCourseDetails openEditCourseDetailsPage() {
        clickElement(EditButton);
        return new EditCourseDetails(driver);
    }
}
