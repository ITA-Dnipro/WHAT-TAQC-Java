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

    public interface AddLesson{
        String PAGE_TITLE_XPATH = "//h3[text()='Add a Lesson']";
        String CANCEL_BUTTON_XPATH = "//button[@data-testid='cancelBtn']";
        String CLASS_REGISTER_BUTTON_ID = "class-register-btn";
        String LESSON_THEME_INPUT_FIELD_ID = "inputLessonTheme";
        String GROUP_NAME_INPUT_FIELD_ID = "inputGroupName";
        String LESSON_TIME_INPUT_FIELD_ID = "choose-date-time";
        String MENTOR_EMAIL_INPUT_FIELD_ID = "mentorEmail";
        String LIST_OF_GROUPS_XPATH = "//datalist[@id='group-list']/option";
        String LIST_OF_MENTORS_XPATH = "//datalist[@id='mentor-list']/option";
    }

    public interface EditLesson{
        String PAGE_TITLE_XPATH = "//h3[text()='Edit a Lesson']";
        String CANCEL_BUTTON_XPATH = "//button[@data-testid='cancelBtn']";
    }

    public interface ClassBook{
        String LIST_OF_STUDENTS_XPATH = "//p[@class='edit-lesson__link___Hgvq4']";
        String LIST_OF_MARKS_XPATH = "//input[@class='form-control edit-lesson__mode___3T2Dn']";
        String LIST_OF_PRESENCE_TIP_XPATH = "//input[@class='edit-lesson__mode___3T2Dn']";
        String SAVE_BUTTON_XPATH = "//button[@type='submit']";
    }

    public interface LessonDetails{
        String CANCEL_BUTTON_XPATH = "//button[@type='button']";
    }

    public interface Courses {
        String VIEW_TABLE_CARD_XPATH = "//button[@class='btn btn-secondary']";
        String SEARCH_FIELD_XPATH = "//input[@type='text']";
        String ADD_COURSE_BUTTON_XPATH = "//span[.='Add a course']";
        String SORT_TITLE_BUTTON_XPATH = "//span[@data-sorting-param='name']";
        String COURSES_TABLE_LIST_MENTOR_STUDENT_XPATH = "//td";
        String COURSES_TABLE_LIST_ADMIN_SECRETARY_XPATH = "//td[not(contains(@class,'text-center'))]";
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

}