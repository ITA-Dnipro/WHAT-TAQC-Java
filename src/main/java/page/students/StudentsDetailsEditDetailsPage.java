package page.students;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Locators.StudentsDetailsEditDetailsPage.*;
import static constants.Locators.StudentsDetailsEditDetailsPage.StudentDetailsTab.*;

public class StudentsDetailsEditDetailsPage extends Page {

    @FindBy(xpath = ARROW_BUTTON_XPATH)
    protected WebElement arrowButton;
    @FindBy(xpath = STUDENT_DETAILS_TAB_XPATH)
    protected WebElement studentDetails;
    @FindBy(xpath = STUDENT_EDIT_TAB_XPATH)
    protected WebElement studentEdit;

    public StudentsDetailsEditDetailsPage(WebDriver driver) {
        super(driver);
    }

    public class StudentDetailsTab extends Page {

        @FindBy(xpath = FIRST_NAME_XPATH)
        protected WebElement firstName;
        @FindBy(xpath = LAST_NAME_XPATH)
        protected WebElement lastName;
        @FindBy(xpath = EMAIL_XPATH)
        protected WebElement email;
        @FindBy(xpath = LIST_GROUPS_XPATH)
        protected List<WebElement> groups;
        @FindBy(xpath = LIST_LESSONS_XPATH)
        protected List<WebElement> lessons;

        private StudentDetailsTab(WebDriver driver) {
            super(driver);
        }

        public WebElement getFirstName() {
            return firstName;
        }

        public WebElement getLastName() {
            return lastName;
        }

        public WebElement getEmail() {
            return email;
        }

        public List<String> getGroupsHREFList() {
            System.out.println(groups.size());
            return groups.stream()
                    .map(elem -> elem.getAttribute("href"))
                    .collect(Collectors.toList());
        }

        @Override
        public String toString() {
            return "StudentDetailsTab{" +
                    "firstName=" + firstName.getText() +
                    ", lastName=" + lastName.getText() +
                    ", email=" + email.getText() +
                    '}' + "\n" +
                    "Groups: " + getGroupsHREFList().toString();
        }
    }
}
