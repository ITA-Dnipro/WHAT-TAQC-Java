package page.students;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.unassignedUsers.UnassignedUsersPage;

import java.util.List;
import java.util.stream.Collectors;

import static constants.Locators.StudentsPage.*;

public class StudentsPage extends Page {

    @FindBy(tagName = PAGE_TITLE_TAG_NAME)
    protected WebElement pageName;
    @FindBy(className = SEARCH_INPUT_BOX_CLASSNAME)
    protected WebElement searchInputFieldBox;
    @FindBy(id = SHOW_DISABLED_SWITCHER_ID)
    protected WebElement showDisabledSwitcher;
    @FindBy(xpath = ADD_STUDENT_BUTTON_XPATH)
    protected WebElement addStudentButton;
    @FindBy(xpath = TABLE_STUDENTS_XPATH)
    protected WebElement tableStudents;
    @FindBy(xpath = TABLE_HEAD_FIRST_NAME_XPATH)
    protected WebElement tableHeadFirstName;
    @FindBy(xpath = TABLE_HEAD_LAST_NAME_XPATH)
    protected WebElement tableHeadLastName;
    @FindBy(xpath = TABLE_HEAD_EMAIL_XPATH)
    protected WebElement tableHeadEmail;
    @FindBy(tagName = TABLE_ROW_TAG_NAME)
    protected List<WebElement> tableStudentsRows;

    public StudentsPage(WebDriver driver) {
        super(driver);
    }

    public UnassignedUsersPage addStudent() {
        clickElement(addStudentButton);
        return new UnassignedUsersPage(driver);
    }

    // TODO
    public void verifySortingByName() {
        clickElement(tableHeadFirstName);
    }

    private List<WebElement> getSuitableRows(String value) {
        List<WebElement> suitableList = tableStudentsRows.stream()
                .filter(row -> {
                    List<WebElement> listCells = row.findElements(By.tagName(TABLE_CELL_TAG_NAME))
                            .stream()
                            .limit(3)
                            .filter(cellValue -> cellValue.getText().equals(value))
                            .collect(Collectors.toList());
                    return !listCells.isEmpty();
                })
                .collect(Collectors.toList());
        return suitableList;
    }
}
