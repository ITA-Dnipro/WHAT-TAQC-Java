package page.students;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Locators.StudentsDetailsEditPage.StudentDetailsTab.*;
public class StudentDetailsTab extends Page {

    @FindBy (xpath = FIRST_NAME_XPATH)
    protected WebElement firstName;
    @FindBy (xpath = LAST_NAME_XPATH)
    protected WebElement lastName;
    @FindBy (xpath = EMAIL_XPATH)
    protected WebElement email;
    @FindBy (xpath = LIST_GROUPS_XPATH)
    protected List<WebElement> groups;
    @FindBy (xpath = LIST_LESSONS_XPATH)
    protected List<WebElement> lessons;

    public StudentDetailsTab (WebDriver driver){
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

    public List<String> getGroupsList(){
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
                "Groups: " + getGroupsList().toString();
    }
}
