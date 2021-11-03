package page.students;

import constants.Endpoints;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import page.unassigned.UnassignedUsersPage;
import util.UnassignedUser;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static constants.Locators.StudentsPage.*;
import static constants.Locators.UnassignedUsers.TABLE_CELL_TAG_NAME;

public class StudentsPage extends Page<StudentsPage> {

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

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.STUDENTS);
    }

    public UnassignedUsersPage addStudent() {
        clickElement(addStudentButton);
        return new UnassignedUsersPage(driver);
    }

    public WebElement findStudentsOnThePage(String value) {
        WebElement tableRow = tableStudentsRows.stream()
                .filter(row -> {
                    List<WebElement> listCells = row.findElements(By.tagName(TABLE_CELL_TAG_NAME))
                            .stream()
                            .limit(3)
                            .filter(cellValue -> cellValue.getText().equals(value))
                            .collect(Collectors.toList());
                    return !listCells.isEmpty();
                })
                .findFirst().orElse(null);
        return tableRow;
    }

    public WebElement findStudentRow(String value) {
        WebElement tableRow;
        pagination.openLastPage(this);
        tableRow = findStudentsOnThePage(value);
        if (tableRow != null) {
            return tableRow;
        }
        pagination.openFirstPage(this);
        do {
            tableRow = findStudentsOnThePage(value);
            if (pagination.isCurrentPageLast()) {
                return tableRow;
            }
            if (tableRow == null) {
                pagination.openNextPage(this);
            }
        } while (tableRow == null);
        return tableRow;
    }

    public StudentsPage verifyAddStudentButtonIsDisplayed(boolean isDisplayed) {
        try{
        softAssert.assertEquals(addStudentButton.isDisplayed(), isDisplayed);
        } catch (NoSuchElementException e){
            softAssert.assertFalse(isDisplayed);
        }
        return this;
    }

    public StudentDetailsTab openStudentDetailsTab(UnassignedUser user) {
        WebElement row = findStudentRow(user.getEmail());
        clickElement(row);
        return new StudentDetailsTab(driver);
    }

    public StudentEditDetailsTab openStudentEditDetailsTab(UnassignedUser user) {
        WebElement row = findStudentRow(user.getEmail());
        WebElement pencilButton = row.findElement(By.xpath(PENCIL_ICON_XPATH));
        clickElement(pencilButton);
        return new StudentEditDetailsTab(driver);
    }

    public StudentsPage isStudentPresented(String value) {
        softAssert.assertNotNull(findStudentRow(value));
        return this;
    }

}