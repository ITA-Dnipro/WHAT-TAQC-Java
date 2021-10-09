package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;
import org.testng.Assert;

import java.util.List;

import static constants.Locators.Courses.*;

public class CoursesPage extends Page {

    @FindBy(xpath = EDIT_BUTTON_ADMIN_SECRETARY_XPATH)
    private List<WebElement> editButton;

    @FindBy(xpath = COURSES_TABLE_LIST_ADMIN_SECRETARY_XPATH)
    private List<WebElement> courseRow;

    @FindBy(xpath = ADD_COURSE_BUTTON_XPATH)
    private WebElement addCourseButton;

    @FindBy(xpath = SEARCH_FIELD_XPATH)
    private WebElement searchField;

    @FindBy(xpath = SORT_TITLE_BUTTON_XPATH)
    private WebElement titleSort;

    @FindBy(id = CHANGE_ROWS_NUMBER_BUTTON_ID)
    private WebElement displayRowsValue;

    @FindBy(xpath = LIST_OF_VISIBLE_ROWS_NUMBERS_XPATH)
    private List<WebElement> numberOfVisibleUsersList;

    @FindBy(xpath = COURSES_PAGINATION_XPATH)
    private List<WebElement> paginationList;

    @FindBy(xpath = VIEW_TABLE_CARD_XPATH)
    private WebElement switcherCoursesTable;

    @FindBy(xpath = TABLE_ROWS_LIST_XPATH)
    private List<WebElement> rowsList;

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    public EditCourseDetailsTab editCourseDetailsTab(int numberRow) {
        clickElement(editButton.get(numberRow));
        return new EditCourseDetailsTab(driver);
    }

    public CourseDetailsTab courseDetailsTab(int numberRow) {
        clickElement(courseRow.get(numberRow));
        return new CourseDetailsTab(driver);
    }

    public AddCoursePage addCoursePage() {
        clickElement(addCourseButton);
        return new AddCoursePage(driver);
    }

    public CoursesPage fillCourseSearchField(String courseName) {
        fillField(searchField, courseName);
        return this;
    }

    public CoursesPage titleSortResult() {
        clickElement(titleSort);
        return this;
    }

    public CoursesPage changeDisplayRowsNumber(String rowsNumber) {
        clickElement(displayRowsValue);
        getItemFromMenu(numberOfVisibleUsersList, rowsNumber).click();
        return this;
    }

    public CoursesPage switchingCoursesPage(int indexCoursePage) {
        clickElement(paginationList.get(indexCoursePage));
        return this;
    }

    public CoursesPage switchingCoursesLook() {
        clickElement(switcherCoursesTable);
        return this;
    }

    public List<WebElement> getCoursesRowsList() {
        return rowsList;
    }

}
