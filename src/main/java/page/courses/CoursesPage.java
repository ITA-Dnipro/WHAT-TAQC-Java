package page.courses;

import constants.Endpoints;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import page.base.Page;

import java.util.List;

import static constants.Locators.Courses.*;

public class CoursesPage extends Page<CoursesPage> {

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

    @FindBy(xpath = COURSE_TITLE_XPATH)
    private WebElement loseFocus;

    @FindBy(xpath = ALERT_ADD_COURSE_XPATH)
    private WebElement alertAddCourse;

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return driver.getCurrentUrl().equals(Endpoints.COURSES);
    }

    //region Actions
    public EditCourseDetailsTab clickEditCourseDetailsTab(int numberRow) {
        clickElement(editButton.get(numberRow));
        return new EditCourseDetailsTab(driver);
    }

    public CourseDetailsTab clickCourseDetailsTab(int numberRow) {
        clickElement(courseRow.get(numberRow));
        return new CourseDetailsTab(driver);
    }

    public AddCoursePage redirectToAddCoursePage() {
        clickElement(addCourseButton);
        return new AddCoursePage(driver);
    }

    public CoursesPage fillCourseSearchField(String courseName) {
        fillField(searchField, " ");
        fillField(searchField, courseName);
        return this;
    }

    public List<WebElement> getCoursesRowsList() {
        return rowsList;
    }

    public void loseFocus() {
        loseFocus.click();
    }

    public WebElement getAlertAddCourse() {
        return alertAddCourse;
    }


    public CoursesPage fillCourseSearchFields(String courseName) {
        fillField(searchField, courseName);
        return this;
    }
    //endregion

    //region Verifies
    public CoursesPage verifySearchCourseFieldFilled(String data) {
        softAssert.assertEquals(searchField.getText(), data);
        return this;
    }

    public CoursesPage verifyOldCourseNameExist(String oldName) {
        softAssert.assertTrue(getCoursesRowsList().get(0).isDisplayed(), oldName);
        return this;
    }

    public CoursesPage verifyAddCourseAlertExist(String data) {
        softAssert.assertEquals(getAlertAddCourse().getText(), data);
        return this;
    }

    public CoursesPage verifyCourseExists(String courseName) {
        Assert.assertEquals(getCoursesRowsList().get(0).getText(), courseName);
        return this;
    }

    public CoursesPage assertAllCoursePages() {
        assertAll();
        return this;
    }

    public CoursesPage verifyCourseNameEdited(String newName) {
        Assert.assertEquals(getCoursesRowsList().get(0).getText(), newName);
        return this;
    }
    //endregion
}
