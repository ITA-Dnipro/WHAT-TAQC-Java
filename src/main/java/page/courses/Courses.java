package page.courses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.base.Page;

import java.util.List;

import static constants.Locators.Courses.*;

public class Courses extends Page {

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

    @FindBy(xpath = LIST_OF_ROWS_NUMBERS_XPATH)
    private List<WebElement> rowsNumberList;

    @FindBy(xpath = COURSES_PAGINATION_XPATH)
    private List<WebElement> paginationList;

    @FindBy(xpath = VIEW_TABLE_CARD_XPATH)
    private WebElement switcherCoursesTable;

    public Courses(WebDriver driver) {
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

    public Courses fillCourseSearchField(String courseName) {
        fillField(searchField, courseName);
        return this;
    }

    public Courses titleSortResult() {
        clickElement(titleSort);
        return this;
    }

    public Courses changeDisplayRowsNumber(String rowsNumber) {
        clickElement(displayRowsValue);
        getItemFromMenu(rowsNumberList, rowsNumber).click();
        return this;
    }

    public Courses switchingCoursesPage(int indexCoursePage) {
        clickElement(paginationList.get(indexCoursePage));
        return this;
    }

    public Courses switchingCoursesLook() {
        clickElement(switcherCoursesTable);
        return this;
    }
}
