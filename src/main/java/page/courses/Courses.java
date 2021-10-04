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
    private List<WebElement> displayRowsValue;

    @FindBy(xpath = COURSES_PAGINATION_XPATH)
    private List<WebElement> paginationList;

    public Courses(WebDriver driver) {
        super(driver);
    }

    private EditCourseDetailsTab editCourseDetailsTab(int numberRow) {
        clickElement(editButton.get(numberRow));
        return new EditCourseDetailsTab(driver);
    }

    private CourseDetailsTab courseDetailsTab(int numberRow) {
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

    public Courses changeDisplayRowsNumber(RowsNumbers rowsNumber) {
        getItemFromMenu(displayRowsValue, String.valueOf(rowsNumber));
        clickElement(displayRowsValue.get(Integer.parseInt(String.valueOf(rowsNumber))));
        return this;
    }

    public enum RowsNumbers {
        NINE("9"),
        TWENTY_SEVEN("27"),
        FORTY_FIVE("45"),
        SEVENTY_TWO("72"),
        NINETY_NINE("99");

        private final String rowsNumber;

        RowsNumbers(String rowsNumber) {
            this.rowsNumber = rowsNumber;
        }

        public String getRowsNumber() {
            return rowsNumber;
        }
    }

    public Courses switchingCoursesPage(int indexCoursePage) {
        clickElement(paginationList.get(indexCoursePage));
        return this;
    }
}
