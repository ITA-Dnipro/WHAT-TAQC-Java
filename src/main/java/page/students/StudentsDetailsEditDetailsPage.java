package page.students;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Locators.StudentsDetailsEditDetailsPage.*;
import static constants.Locators.StudentsDetailsEditDetailsPage.StudentDetailsTab.*;
import static constants.Locators.StudentsDetailsEditDetailsPage.StudentEditDetailsTab.*;

public class StudentsDetailsEditDetailsPage extends Page {

    @FindBy(xpath = ARROW_BUTTON_XPATH)
    protected WebElement arrowButton;
    @FindBy(xpath = STUDENT_DETAILS_TAB_XPATH)
    protected WebElement studentDetailsTab;
    @FindBy(xpath = STUDENT_EDIT_TAB_XPATH)
    protected WebElement studentEditDetailsTab;

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

    public class StudentEditDetailsTab extends Page {

        @FindBy(xpath = FIRST_NAME_INPUT_FIELD_XPATH)
        WebElement firstNameInputField;
        @FindBy(xpath = LAST_NAME_INPUT_FIELD_XPATH)
        WebElement lastNameInputField;
        @FindBy(xpath = EMAIL_INPUT_FIELD_XPATH)
        WebElement emailInputField;
        @FindBy(xpath = GROUPS_INPUT_FIELD_XPATH)
        WebElement groupsInputField;
        @FindBy(xpath = GROUPS_PLUS_BUTTON_XPATH)
        WebElement groupsPlusButton;
        @FindBy(xpath = GROUPS_LIST_XPATH)
        List<WebElement> groupsList;
        @FindBy(xpath = EXCLUDE_BUTTON_XPATH)
        WebElement excludeButton;
        @FindBy(xpath = CLEAR_BUTTON_XPATH)
        WebElement clearButton;
        @FindBy(xpath = SAVE_BUTTON_XPATH)
        WebElement saveButton;

        public StudentEditDetailsTab(WebDriver driver) {
            super(driver);
        }

        public StudentsPage editStudentFirstNameLastNameEmail(Student student) {
            fillUserFirstNameLastNameEmailFields(student, firstNameInputField,
                    lastNameInputField, emailInputField);
            clickElement(saveButton);
            return new StudentsPage(super.driver);
        }
    }

    public StudentsPage returnToStudentsPage() {
        clickElement(arrowButton);
        return new StudentsPage(super.driver);
    }

    public StudentDetailsTab openStudentDetailsTab() {
        clickElement(studentDetailsTab);
        return new StudentDetailsTab(super.driver);
    }

    public StudentEditDetailsTab openStudentEditDetailsTab() {
        clickElement(studentEditDetailsTab);
        return new StudentEditDetailsTab(super.driver);
    }

}
