package page.students;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static constants.Locators.StudentDetailsTab.*;

public class StudentDetailsTab extends StudentsEditDetailsPage {
    @FindBy(tagName = PAGE_TITLE_TAG_NAME)
    protected WebElement pageTitle;
    @FindBy(xpath = FIRST_NAME_XPATH)
    protected WebElement firstName;
    @FindBy(xpath = LAST_NAME_XPATH)
    protected WebElement lastName;
    @FindBy(xpath = EMAIL_XPATH)
    protected WebElement email;
    @FindBy(xpath = LIST_GROUPS_XPATH)
    protected List<WebElement> groups;

    public StudentDetailsTab(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return pageTitle.getText().equals("Student Details");
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

}