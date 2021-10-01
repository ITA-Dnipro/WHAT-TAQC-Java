package constants;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Locators {

    private Locators() {
    }

    public interface CommonElements {
        String SIDE_BAR_XPATH = "//span[@class='sidebar__menu-item___1MMsk']";
    }

    public interface Lessons {
        String ADD_LESSON_BUTTON_XPATH = "//button[contains(.,'Add a lesson')]";
        String ADD_THEME_BUTTON_CSS_SELECTOR = ".btn-warning";
        String FILTER_BUTTON_XPATH = "//button[contains(.,'Filter')]";
        String SWITCH_VIEW_BUTTONS_XPATH = "//button[@class = 'btn btn-secondary']";
        String TABLE_HEAD_THEME_NAME_XPATH = "//span[text()='themeName']";
        String TABLE_HEAD_LESSON_DATE_XPATH = "//span[text()='lessonDate']";
        String TABLE_HEAD_LESSON_TIME_XPATH = "//span[text()='lessonTime']";
        String PAGE_TITLE_XPATH = "//h2[text()='Lessons']";
    }

    interface Courses {
        String VIEW_TABLE_CARD_XPATH = "//button[@class='btn btn-secondary']";
        String SEARCH_FIELD_XPATH = "//input[@type='text']";
        String ADD_COURSE_BUTTON_XPATH = "//span[.='Add a course']";
        String SORT_TITLE_BUTTON_XPATH = "//span[@data-sorting-param='name']";
        String COURSES_TABLE_LIST_MENTOR_STUDENT_XPATH = "//td";
        String COURSES_TABLE_LIST_ADMIN_SECRETAR_XPATH = "//td[not(contains(@class,'text-center'))]";
        String EDIT_BUTTON_ADMIN_SECRETARY_XPATH = "//td[@class='text-center']";
        String COURSES_PAGINATION_XPATH = "//li[@class='page-item']"; $x("//div[@class='row mr-0']//button[text()='<']");
        String CHANGE_ROWS_NUMBER_XPATH = "//*[@id='change-visible-people']";
    }

    interface CourseDetailsPage {
        String ARROW_BUTTON_XPATH = "//a[contains(@class,'align-items-center')]";
        String COURSE_DETAILS_TAB_XPATH = "//a[contains(@class,'1xEn9')and contains(text(),'Course details')]";
        String EDIT_COURSE_DETAILS_TAB_XPATH = "//a[contains(@class,'1xEn9')and contains(text(),'Edit course details')]";
        String COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
        String DELETE_BUTTON_XPATH = "//button[contains(text(),'Delete')]";
        String CLEAR_BUTTON_XPATH = "//button[@type='reset']";
        String SAVE_BUTTON_XPATH = "//button[@type='submit']";
    }

    interface AddCoursePage{
        String COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
        String CANCEL_BUTTON_ADD_COURSE_XPATH = "//a[@data-testid='cancelBtn']";
        String SAVE_BUTTON_XPATH = "//button[@id='addCourseSubmit']";
    }

    interface ChangePasswordPage{
        String EMAIL_INPUT_FIELD_XPATH = "//*[@id='email']";
        String CURRENT_PASSWORD_INPUT_FIELD_XPATH = "//*[@id='currentPassword']";
        String NEW_PASSWORD_INPUT_FIELD_XPATH = "//*[@id='newPassword']";
        String CONFIRM_PASSWORD_INPUT_FIELD = "//*[@id='confirmNewPassword']";
        String CANCEL_BUTTON_CHANGE_PASSWORD_XPATH = "//button[contains(text(),'Cancel')]";
        String SAVE_BUTTON_CHANGE_PASSWORD_XPATH = "//button[contains(text(),'Save')]";
    }
}