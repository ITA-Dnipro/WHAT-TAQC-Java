package constants;

public class Locators {

    private Locators() {
    }

    public interface Auth {
        String EMAIL_INPUT_FIELD_NAME = "email";
        String PASSWORD_INPUT_FIELD_NAME = "password";
        String SIGN_IN_BUTTON_XPATH = "//button[@type='submit']";
        String REGISTRATION_LINK_XPATH="//a[text()='Registration']";

    }

    public interface CommonElements {
        String SIDE_BAR_XPATH = "//span[@class='sidebar__menu-item___1MMsk']";
    }

    public interface HomePageUrl {
        String ADMIN_HOME_PAGE = "http://localhost:8080/students";

    }

    public interface Header {
        String LOGO_XPATH = "//*[contains(@class,'logo')]";
        String ICON_XPATH = "//*[contains(@class,'icon')]";
        String FULL_NAME_XPATH = "//*[contains(@class,'fullname')]";
        String DROP_DOWN_MENU_MY_PROFILE_XPATH = "//li[a[contains(., 'My profile')]]";
        String DROP_DOWN_MENU_CHANGE_PASSWORD_XPATH = "//li[a[contains(., 'Change password')]]";
        String DROP_DOWN_MENU_LOG_OUT_XPATH = "//li[a[contains(., 'Log Out')]]";
        String TRIANGLE_ICON_XPATH = "//*[contains(@class,'toggler')]";
    }

    public interface AuthMax {
        String EMAIL_INPUT_FIELD_ID = "email";
        String PASSWORD_INPUT_FIELD_ID = "password";
        String SIGN_IN_BUTTON_XPATH = "//button[@type='submit']";
        String FORGOT_PASSWORD_LINK_XPATH = "//a[text()='Fogot Password?']";
        String REGISTRATION_LINK_XPATH = "//a[text()='Registration']";
    }

    public interface Lessons {
        String ADD_LESSON_BUTTON_XPATH = "//button[contains(.,'Add a lesson')]";
        String ADD_THEME_BUTTON_CSS_SELECTOR = ".btn-warning";
        String FILTER_BUTTON_XPATH = "//button[contains(.,'Filter')]";
        String SEARCH_INPUT_FIELD_CSS_SELECTOR = ".search__searchInput___34nMl";
        String LIST_VIEW_BUTTON_XPATH = "//button[@class='btn btn-secondary']//*[contains(@href, 'List')]";
        String CARD_VIEW_BUTTON_XPATH = "//button[@class='btn btn-secondary']//*[contains(@href, 'Card')]";
        String TABLE_HEAD_THEME_NAME_XPATH = "//span[text()='themeName']";
        String TABLE_HEAD_LESSON_DATE_XPATH = "//span[text()='lessonDate']";
        String TABLE_HEAD_LESSON_TIME_XPATH = "//span[text()='lessonTime']";
        String EDIT_LESSON_PENCIL_ICON_XPATH = "//td[@class = 'text-center']";
        String PAGE_TITLE_XPATH = "//h2[text()='Lessons']";
        String TABLE_ROWS_XPATH = "//tbody//tr";
        String ALERT_XPATH = "//div[@role = 'alert']";
    }

    public interface Secretaries {
        String ADD_SECRETARY_BUTTON_XPATH = "//span[contains(text(),'Add a secretary')]";
        String SWITCH_VIEW_DISABLED_SECRETARIES_XPATH = "//label[contains(@class, 'custom-control-label list-of-secretaries')]";
        String SEARCH_WINDOW_SECRETARIES_NAME_XPATH = "//div[@class ='search__search___13vn_']";
        String SECRETARY_TABLE_HEAD_NAME_XPATH = "//span[contains(text(),'Name')]";
        String SECRETARY_TABLE_HEAD_SURNAME_XPATH = "//span[contains(text(),'Surname')]";
        String SECRETARY_TABLE_HEAD_EMAIL_XPATH = "//span[contains(text(),'Email')]";
        String SECRETARY_PAGE_TITLE_XPATH = "//h2[text()='Secretaries']";
        String SECRETARY_EDIT_ICON_XPATH = "//td[@class='text-center']";
        String SECRETARY_PAGE_TABLE_XPATH = "//table[@class='table table-hover']";
    }

    public interface AddLesson {
        String PAGE_TITLE_XPATH = "//h3[text()='Add a Lesson']";
        String CANCEL_BUTTON_XPATH = "//button[@lessons.data-testid='cancelBtn']";
        String CLASS_REGISTER_BUTTON_ID = "class-register-btn";
        String LESSON_THEME_INPUT_FIELD_ID = "inputLessonTheme";
        String GROUP_NAME_INPUT_FIELD_ID = "inputGroupName";
        String LESSON_TIME_INPUT_FIELD_ID = "choose-date-time";
        String MENTOR_EMAIL_INPUT_FIELD_ID = "mentorEmail";
        String LIST_OF_GROUPS_XPATH = "//datalist[@id='group-list']/option";
        String LIST_OF_MENTORS_XPATH = "//datalist[@id='mentor-list']/option";
        String LESSON_THEME_ERROR_CLASS = "add-lesson__error___2dTXe";
        String GROUP_NAME_ERROR_ID = "group-error";
        String MENTOR_MAIL_ERROR_ID = "mentor-error";
    }

    public interface EditLesson {
        String PAGE_TITLE_XPATH = "//h3[text()='Edit a Lesson']";
        String CANCEL_BUTTON_XPATH = "//button[@lessons.data-testid='cancelBtn']";
        String LESSON_THEME_INPUT_FIELD_ID = "inputLessonTheme";
        String LESSON_TIME_INPUT_FIELD_ID = "choose-date/time";
        String EDIT_LESSON_THEME_ERROR_CLASS = "edit-lesson__error___3MZKw";
    }

    public interface ClassBook {
        String LIST_OF_STUDENTS_XPATH = "//p[@class='edit-lesson__link___Hgvq4']";
        String LIST_OF_MARKS_XPATH = "//input[@class='form-control edit-lesson__mode___3T2Dn']";
        String LIST_OF_PRESENCE_TIP_XPATH = "//input[@class='edit-lesson__mode___3T2Dn']";
        String SAVE_BUTTON_XPATH = "//button[@type='submit']";
    }

    public interface LessonDetails {
        String CANCEL_BUTTON_XPATH = "//button[@type='button']";
        String MENTOR_NAME_LINK_XPATH = "//a[@class='text-decoration-none text-white' and contains(@href, 'mentors')]";
        String GROUP_NAME_LINK_XPATH = "//a[@class='text-decoration-none text-white' and contains(@href, 'groups')]";
        String LIST_OF_STUDENTS_CLASS = "lesson-details__link___1nOLw";
        String TITLE_XPATH = "//h3[text()='Lesson details']";
    }

    public interface EditSecretary {
        String ARROW_BUTTON_XPATH = "//*[@class ='bi bi-arrow-left']";
        String SECRETARY_DETAILS_TAB_XPATH = "//a [contains (@class,'nav-item nav-link tab__tab___1xEn9 tab__active___3e65x')] ";
        String EDIT_SECRETARY_TAB_XPATH = "//a [contains (@class,'nav-item nav-link tab__tab___1xEn9 tab__active___3e65x')]";
        String SECRETARIES_FIRST_NAME_WINDOW_XPATH = "//input[@name='firstName']";
        String SECRETARIES_LAST_NAME_WINDOW_XPATH = "//input[@name='lastName']";
        String SECRETARIES_EMAIL_WINDOW_XPATH = "//input[@name='email']";
        String SECRETARIES_LAY_OFF_BUTTON_XPATH = "//button[contains(text (), 'Lay off')]";
        String SECRETARIES_CLEAR_BUTTON_XPATH = "//button[contains(text (), 'Clear')]";
        String SECRETARIES_SAVE_BUTTON_XPATH = "//button[contains(text (), 'Save')]";


    }
    public interface UnassignedUsers {
        String SEARCH_INPUT_FIELD_XPATH = "//input";
        String TABLE_HEAD_NAME_XPATH = "//span[contains(text(),'Name')]";
        String TABLE_HEAD_SURNAME_XPATH = "//span[contains(text(),'Surname')]";
        String TABLE_HEAD_EMAIL_XPATH = "//span[contains(text(),'Email')]";
        String TABLE_UNASSIGNED_USERS_XPATH = "//tbody";
        String TABLE_ROW_TAG_NAME = "tr";
        String TABLE_CELL_TAG_NAME = "td";
        String TABLE_ROLES_DROPDOWN_MENU_TAG_NAME = "select";
        String TABLE_ROLE_DROPDOWN_MENU_OPTIONS_TAG_NAME = "option";
        String TABLE_ADD_ROLE_BUTTON_TAG_NAME = "button";
    }

    public interface Courses {
        String COURSE_TITLE_XPATH = "//h2[.='Courses']";
        String VIEW_TABLE_CARD_XPATH = "//button[@class='btn btn-secondary']";
        String SEARCH_FIELD_XPATH = "//input[@type='text']";
        String ADD_COURSE_BUTTON_XPATH = "//span[.='Add a course']";
        String SORT_TITLE_BUTTON_XPATH = "//span[@lessons.data-sorting-param='name']";
        String COURSES_TABLE_LIST_ADMIN_SECRETARY_XPATH = "//td[not(contains(@class,'text-center'))]";
        String EDIT_BUTTON_ADMIN_SECRETARY_XPATH = "//td[@class='text-center']";
        String COURSES_PAGINATION_XPATH = "//li[@class='page-item']";
        String CHANGE_ROWS_NUMBER_BUTTON_ID = "change-visible-people";
        String LIST_OF_VISIBLE_ROWS_NUMBERS_XPATH = "//*[@id='change-visible-people']/option";
        String TABLE_ROWS_LIST_XPATH = "//tbody//tr";
        String ALERT_ADD_COURSE_XPATH = "//div[@role='alert']";
    }

    public interface CourseDetailsPage {
        String ARROW_BUTTON_XPATH = "//a[contains(@class,'align-items-center')]";
        String COURSE_DETAILS_TAB_XPATH = "//a[contains(.,'Course details')]";
        String EDIT_COURSE_DETAILS_TAB_XPATH = "//a[contains(.,'Edit')]";
        String COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
        String DELETE_BUTTON_XPATH = "//button[contains(text(),'Delete')]";
        String CLEAR_BUTTON_XPATH = "//button[@type='reset']";
        String SAVE_BUTTON_XPATH = "//button[@type='submit']";
        String CANCEL_BUTTON_CONFIRM_ACTION_XPATH = "//button[@type='button'and contains(.,'Cancel')]";
        String DELETE_BUTTON_CONFIRM_ACTION_XPATH = "//button[@type='submit'and contains(.,'Delete')]";
        String CLOSE_BUTTON_CONFIRM_ACTION_XPATH = "//button[@class='close']";
        String COURSE_DETAILS_TAB_TITLE_XPATH = "//h3[.='Course Details']";
        String EDIT_COURSE_DETAILS_TAB_TITLE_XPATH = "//h3[.='Course Editing']";
    }

    public interface AddCoursePage {
        String COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
        String CANCEL_BUTTON_ADD_COURSE_XPATH = "//a[@lessons.data-testid='cancelBtn']";
        String SAVE_BUTTON_XPATH = "//button[@id='addCourseSubmit']";
    }

    public interface ChangePasswordPage {
        String PAGE_TITLE_XPATH = "//h3[.='Change Password']";
        String EMAIL_INPUT_FIELD_ID = "email";
        String CURRENT_PASSWORD_INPUT_FIELD_XPATH = "//*[@id='currentPassword']";
        String NEW_PASSWORD_INPUT_FIELD_ID = "newPassword";
        String CONFIRM_PASSWORD_INPUT_FIELD_ID = "confirmNewPassword";
        String CANCEL_BUTTON_CHANGE_PASSWORD_XPATH = "//button[contains(text(),'Cancel')]";
        String SAVE_BUTTON_CHANGE_PASSWORD_XPATH = "//button[contains(text(),'Save')]";
        String CANCEL_BUTTON_CONFIRM_ACTION_XPATH = "//button[contains(@class,'bRf5m')and contains(text(),'Cancel')]";
        String CONFIRM_BUTTON_CONFIRM_ACTION_XPATH = "//button[@type='submit'and contains(text(),'Confirm')]";
        String CLOSE_CONFIRM_ACTION_XPATH = "//button[@class='close']";
    }

    public interface MentorsTablePage {
        String ADD_MENTOR_BUTTON_XPATH = "//span[text()='Add a mentor']";
        String DISABLE_MENTORS_SWITCH_XPATH = "//input[@id='disabledMentors']";
        String SEARCH_INPUT_FIELD_XPATH = "//input[@class='search__searchInput___34nMl']";
        String SORT_NAME_ARROW_XPATH = "//span[text()='Name']";
        String SORT_SURNAME_ARROW_XPATH = "//span[text()='Surname']";
        String SORT_EMAIL_ARROW_XPATH = "//span[text()='Email']";
        String EDIT_BUTTON_XPATH = "//td[@class='text-center']";
        String MENTORS_ROW_XPATH = "//td[not(contains(@class,'text-center'))]";
        String SWITCH_VIEW_BUTTONS_XPATH = "//button[@class = 'btn btn-secondary']";
        String MENTORS_CARD_XPATH = "//div[@class='card']";
    }

    public interface ListOfMentorsPage {
        String ADD_MENTOR_BUTTON_XPATH = "//span[text()='Add a mentor']";
        String DISABLE_MENTORS_SWITCH_XPATH = "//input[@id='disabledMentors']";
        String SEARCH_INPUT_FIELD_XPATH = "//input[@class='search__searchInput___34nMl']";
        String SWITCH_VIEW_BUTTONS_XPATH = "//button[@class = 'btn btn-secondary']";
        String MENTORS_CARD_XPATH = "//div[@class='card']";
        String EDIT_BUTTON_XPATH = "//*[@class='blocks__scale___2EfN8']";
    }

    public interface MentorsDetailsPage {
        String MENTORS_DETAILS_TAB_XPATH = "//a[text()='Mentor details']";
        String EDIT_MENTOR_TAB_XPATH = "//a[text()='Edit a mentor']";
        String ARROW_BUTTON_XPATH = "//a[contains(@class,'align-items-center')]";
    }

    public interface EditMentorsDetailsPage {
        String MENTORS_DETAILS_TAB_XPATH = "//a[text()='Mentor details']";
        String EDIT_MENTOR_TAB_XPATH = "//a[text()='Edit a mentor']";
        String ARROW_BUTTON_XPATH = "//a[contains(@class,'align-items-center')]";
        String FIRST_NAME_INPUT_FIELD_XPATH = "//input[@id='firstName']";
        String SECOND_NAME_INPUT_FIELD_XPATH = "//input[@id='lastName']";
        String EMAIL_INPUT_FIELD_XPATH = "//input[@id='email']";
        String GROUPS_INPUT_FIELD_XPATH = "//input[@id='groupsInput']";
        String LIST_GROUPS_XPATH = "//datalist[@id='group-list']";
        String DELETE_GROUP_BUTTON_XPATH = "//button[contains(@class,'delGroup')]";
        String ADD_GROUP_BUTTON_XPATH = "//button[@id='addGroup']";
        String COURSE_INPUT_FIELD_XPATH = "//input[@id='coursesInput']";
        String LIST_COURSES_XPATH = "//datalist[@id='course-list']";
        String DELETE_COURSE_BUTTON_XPATH = "//button[contains(@class,'delCourse')]";
        String ADD_COURSE_BUTTON_XPATH = "//button[@id='addCourse']";
        String DISABLE_BUTTON_XPATH = "//button[text()='Disable']";
        String CLEAR_BUTTON_XPATH = "//button[text()='Clear']";
        String SAVE_BUTTON_XPATH = "//button[text()='Save']";
        String ERROR_MASSAGE_XPATH = "//div[@class='edit-mentor__error___20Eyn']";
        String TITLE_XPATH = "//h3[text()='Mentor Editing']";
        String FIRST_NAME_ERROR = "//input[@id='firstName']/parent::div/div";
        String LAST_NAME_ERROR = "//input[@id='lastName']/parent::div/div";
        String EMAIL_ERROR = "//input[@id='email']/parent::div/div";


    }

    public interface StudentsPage {
        String PAGE_TITLE_TAG_NAME = "h2";
        String SEARCH_INPUT_BOX_CLASSNAME = "search__searchInput";
        String SHOW_DISABLED_SWITCHER_ID = "show-disabled-check";
        String ADD_STUDENT_BUTTON_XPATH = "//*[contains(text(), 'Add a student')]";
        String TABLE_STUDENTS_XPATH = "//tbody";
        String TABLE_HEAD_FIRST_NAME_XPATH = "//span[@lessons.data-sorting-param='firstName']";
        String TABLE_HEAD_LAST_NAME_XPATH = "//span[@lessons.data-sorting-param='lastName']";
        String TABLE_HEAD_EMAIL_XPATH = "//span[@lessons.data-sorting-param='email']";
        String TABLE_ROW_TAG_NAME = "tr";
        String TABLE_CELL_TAG_NAME = "td";
    }

    public interface StudentsEditDetailsPage {
        String PAGE_TITLE_TAG_NAME = "h3";
        String ARROW_BUTTON_XPATH = "//*[@class='nav nav-tabs']//*[@href='/students']";
        String STUDENT_DETAILS_TAB_XPATH = "//*[text()='Student details']";
        String STUDENT_EDIT_TAB_XPATH = "//*[text()='Edit student details']";
    }

    public interface StudentDetailsTab {
        String PAGE_TITLE_TAG_NAME = "h3";
        String FIRST_NAME_XPATH = "//*[text()='First name: ']//following::span[1]";
        String LAST_NAME_XPATH = "//*[text()='Last name: ']//following::span[1]";
        String EMAIL_XPATH = "//*[text()='Email: ']//following::span[1]";
        String LIST_GROUPS_XPATH = "//*[text()='Group(s): ']//following::div[1]//child::span//a";
    }

    public interface StudentEditDetailsTab {
        String PAGE_TITLE_TAG_NAME = "h3";
        String FIRST_NAME_INPUT_FIELD_XPATH = "//input[@name='firstName']";
        String LAST_NAME_INPUT_FIELD_XPATH = "//input[@name='lastName']";
        String EMAIL_INPUT_FIELD_XPATH = "//input[@name='email']";
        String GROUPS_INPUT_FIELD_XPATH = "//input[@name='groupsInput']";
        String GROUPS_PLUS_BUTTON_XPATH = "//button[text()= '+']";
        String GROUPS_LIST_XPATH = "//ul[@class='d-flex flex-wrap justify-content-between p-0']//child::li";
        String EXCLUDE_BUTTON_XPATH = "//button[text()= 'Exclude']";
        String CLEAR_BUTTON_XPATH = "//button[text()= 'Clear']";
        String SAVE_BUTTON_XPATH = "//button[text()= 'Save']";
    }

    public interface MyProfile {
        String CHANGE_PASSWORD_BUTTON = "//button";
    }

    public interface RegistrationPage {
        String FIRST_NAME_INPUT_FIELD_XPATH = "//input[@name='firstName']";
        String LAST_NAME_INPUT_FIELD_XPATH = "//input[@name='lastName']";
        String EMAIL_INPUT_FIELD_XPATH = "//input[@name='email']";
        String PASSWORD_INPUT_FIELD_XPATH = "//input[@name='password']";
        String CONFIRM_PASSWORD_INPUT_FIELD_XPATH = "//input[@name='confirmPassword']";
        String FIRST_NAME_ERROR_XPATH = "//input[@name='firstName']//following-sibling::p";
        String LAST_NAME_ERROR_XPATH = "//input[@name='lastName']//following-sibling::p";
        String EMAIL_ERROR_XPATH = "//input[@name='email']//following-sibling::p";
        String PASSWORD_ERROR_XPATH = "//input[@name='password']//following-sibling::p";
        String CONFIRM_PASSWORD_ERROR_XPATH = "//input[@name='confirmPassword']//following-sibling::p";
        String SIGN_UP_BUTTON_XPATH = "//button[text()= 'Sign up']";
        String LOG_IN_XPATH = "//a[@href='/auth']";
        String MODAL_WINDOW = "//*[contains(@class,'modal-content')]";
        String MODAL_WINDOW_BUTTON = "//button[.='Back']";
    }
}