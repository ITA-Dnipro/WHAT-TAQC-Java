package page.students;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import static constants.Locators.StudentsDetailsEditDetailsPage.*;

public class StudentsEditDetailsPage extends Page {

    @FindBy(xpath = ARROW_BUTTON_XPATH)
    protected WebElement arrowButton;
    @FindBy(xpath = STUDENT_DETAILS_TAB_XPATH)
    protected WebElement studentDetailsTab;
    @FindBy(xpath = STUDENT_EDIT_TAB_XPATH)
    protected WebElement studentEditDetailsTab;

    public StudentsEditDetailsPage(WebDriver driver) {
        super(driver);
    }

    public StudentsPage returnToStudentsPage() {
        clickElement(arrowButton);
        return new StudentsPage(driver);
    }

    public StudentDetailsTab openStudentDetailsTab() {
        clickElement(studentDetailsTab);
        return new StudentDetailsTab(driver);
    }

    public StudentEditDetailsTab openStudentEditDetailsTab() {
        clickElement(studentEditDetailsTab);
        return new StudentEditDetailsTab(driver);
    }

}
