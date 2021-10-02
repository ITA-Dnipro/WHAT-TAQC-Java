package constants;

public class Locators {

    private Locators(){}

    public interface CommonElements{
        String SIDE_BAR_XPATH = "//span[@class='sidebar__menu-item___1MMsk']";
    }

    public interface Lessons{
        String ADD_LESSON_BUTTON_XPATH = "//button[contains(.,'Add a lesson')]";
        String ADD_THEME_BUTTON_CSS_SELECTOR = ".btn-warning";
        String FILTER_BUTTON_XPATH = "//button[contains(.,'Filter')]";
        String SWITCH_VIEW_BUTTONS_XPATH = "//button[@class = 'btn btn-secondary']";
        String TABLE_HEAD_THEME_NAME_XPATH = "//span[text()='themeName']";
        String TABLE_HEAD_LESSON_DATE_XPATH = "//span[text()='lessonDate']";
        String TABLE_HEAD_LESSON_TIME_XPATH = "//span[text()='lessonTime']";
        String PAGE_TITLE_XPATH = "//h2[text()='Lessons']";
    }

    public interface Courses {
        String VIEW_TABLE_CARD_XPATH = "//button[@class='btn btn-secondary']";
        String SEARCH_FIELD_XPATH = "//input[@type='text']";
        String ADD_COURSE_BUTTON_XPATH = "//span[.='Add a course']";
        String SORT_TITLE_BUTTON_XPATH = "//span[@data-sorting-param='name']";
        String COURSES_TABLE_LIST_MENTOR_STUDENT_XPATH = "//td";
        String COURSES_TABLE_LIST_ADMIN_SECRETAR_XPATH = "//td[not(contains(@class,'text-center'))]";
        String EDIT_BUTTON_ADMIN_SECRETARY_XPATH = "//td[@class='text-center']";
        String COURSES_PAGINATION_XPATH = "//li[@class='page-item']";
        String CHANGE_ROWS_NUMBER_XPATH = "//*[@id='change-visible-people']";
    }

    public interface CourseDetailsPage {
        String ARROW_BUTTON_XPATH = "//a[contains(@class,'align-items-center')]";
        String COURSE_DETAILS_TAB_XPATH = "//a[contains(@class,'1xEn9')and contains(text(),'Course details')]";
        String EDIT_COURSE_DETAILS_TAB_XPATH = "//a[contains(@class,'1xEn9')and contains(text(),'Edit course details')]";
        String COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
        String DELETE_BUTTON_XPATH = "//button[contains(text(),'Delete')]";
        String CLEAR_BUTTON_XPATH = "//button[@type='reset']";
        String SAVE_BUTTON_XPATH = "//button[@type='submit']";
    }

    public interface AddCoursePage{
        String COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
        String CANCEL_BUTTON_ADD_COURSE_XPATH = "//a[@data-testid='cancelBtn']";
        String SAVE_BUTTON_XPATH = "//button[@id='addCourseSubmit']";
    }

    public interface ChangePasswordPage{
        String EMAIL_INPUT_FIELD_XPATH = "//*[@id='email']";
        String CURRENT_PASSWORD_INPUT_FIELD_XPATH = "//*[@id='currentPassword']";
        String NEW_PASSWORD_INPUT_FIELD_XPATH = "//*[@id='newPassword']";
        String CONFIRM_PASSWORD_INPUT_FIELD_XPATH = "//*[@id='confirmNewPassword']";
        String CANCEL_BUTTON_CHANGE_PASSWORD_XPATH = "//button[contains(text(),'Cancel')]";
        String SAVE_BUTTON_CHANGE_PASSWORD_XPATH = "//button[contains(text(),'Save')]";
    }
    public interface StudentsPage {
        String TABLE_STUDENTS_XPATH = "//tbody";
        String PAGE_TITLE_TAG_NAME = "h2";
        String TABLE_HEAD_FIRST_NAME_XPATH = "//span[@data-sorting-param='firstName']";
        String TABLE_HEAD_LAST_NAME_XPATH = "//span[@data-sorting-param='lastName']";
        String TABLE_HEAD_EMAIL_XPATH = "//span[@data-sorting-param='email']";
        String TABLE_ROW_TAG_NAME = "tr";
        String SEARCH_INPUT_BOX_CLASSNAME = "search__searchInput";
    }
    public interface Header {
        String LOGO_XPATH = "//*[contains(@class,'logo')]";
        String ICON_XPATH = "//*[contains(@class,'icon')]";
        String FULL_NAME_XPATH = "//*[contains(@class,'fullname')]";
        String DROP_DOWN_MENU_MY_PROFILE_XPATH = "//li[a[contains(text(), 'My profile')]]";
        String DROP_DOWN_MENU_CHANGE_PASSWORD_XPATH = "//li[a[contains(text(), 'Change password')]]";
        String DROP_DOWN_MENU_LOG_OUT_XPATH = "//li[a[contains(text(), 'Log Out')]]";
        String TRIANGLE_ICON_XPATH = "//*[contains(@class,'toggler')]";


    }
}