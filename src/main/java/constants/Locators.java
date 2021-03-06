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
        String SECRETARY_ROW_XPATH = "//td[not(contains(@class,'text-center'))]";
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
        String SECRETARY_DETAILS_ARROW_BUTTON_XPATH = "//*[@class ='bi bi-arrow-left']";
        String SECRETARY_DETAILS_TAB_XPATH = "//a [contains (@class,'nav-item nav-link tab__tab___1xEn9 tab__active___3e65x')] ";
        String EDIT_SECRETARY_TAB_XPATH = "//a [contains (@class,'nav-item nav-link tab__tab___1xEn9 tab__active___3e65x')]";
        String SECRETARIES_FIRST_NAME_WINDOW_XPATH = "//input[@name='firstName']";
        String SECRETARIES_LAST_NAME_WINDOW_XPATH = "//input[@name='lastName']";
        String SECRETARIES_EMAIL_WINDOW_XPATH = "//input[@name='email']";
        String SECRETARIES_LAY_OFF_BUTTON_XPATH = "//button[contains(text (), 'Lay off')]";
        String SECRETARIES_SAVE_BUTTON_XPATH = "//button[contains(text (), 'Save')]";
        String SECRETARIES_DETAILS_TITLE = "//h3[contains(text (),'details')]";
        String SECRETARIES_DETAILS_FNAME= "//div[text()= 'First Name:']";
        String SECRETARIES_DETAILS_LNAME= "//div[text()= 'Last Name:']";
        String SECRETARIES_DETAILS_EMAIL= "//div[text()= 'Email address:']";
        String REMOVE_SECRETARY_BUTTON="//button[text()='Delete']";

    }

    public interface UnassignedUsers {
        String SEARCH_INPUT_FIELD_XPATH = "//input";
        String TABLE_HEAD_NAME_XPATH = "//span[contains(text(),'Name')]";
        String TABLE_HEAD_SURNAME_XPATH = "//span[contains(text(),'Surname')]";
        String TABLE_HEAD_EMAIL_XPATH = "//span[contains(text(),'Email')]";
        String TABLE_UNASSIGNED_USERS_XPATH = "//tbody";
        String TABLE_ROW_TAG_NAME = "tr";
        String TABLE_ROW_UNASSIGNED ="//td[not(contains(@class,'text-center'))]";
        String TABLE_CELL_TAG_NAME = "td";
        String TABLE_ROLES_DROPDOWN_MENU_TAG_NAME = "select";
        String TABLE_ROLE_DROPDOWN_MENU_OPTIONS_TAG_NAME = "option";
        String TABLE_ADD_ROLE_BUTTON_TAG_NAME = "button";
        String TITLE_XPATH="//th[text()='Choose role']";
    }

    public interface Courses {
        String COURSE_TITLE_XPATH = "//h2[text()='Courses']";
        String VIEW_TABLE_CARD_XPATH = "//button[@class='btn btn-secondary']";
        String SEARCH_FIELD_XPATH = "//input[@type='text']";
        String ADD_COURSE_BUTTON_XPATH = "//span[text()='Add a course']";
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
        String COURSE_DETAILS_TAB_XPATH = "//a[contains(@class,'1xEn9')and contains(text(),'Course details')]";
        String EDIT_COURSE_DETAILS_TAB_XPATH = "//a[contains(text(),'Edit course details')]";
        String COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
        String DELETE_BUTTON_XPATH = "//button[contains(text(),'Delete')]";
        String CLEAR_BUTTON_XPATH = "//button[@type='reset']";
        String SAVE_BUTTON_XPATH = "//button[@type='submit']";
        String CANCEL_BUTTON_CONFIRM_ACTION_XPATH = "//button[@type='button'and contains(text(),'Cancel')]";
        String DELETE_BUTTON_CONFIRM_ACTION_XPATH = "//button[@type='submit'and contains(text(),'Delete')]";
        String CLOSE_BUTTON_CONFIRM_ACTION_XPATH = "//button[@class='close']";
        String COURSE_DETAILS_TAB_TITLE_XPATH = "//h3[text()='Course Details']";
        String EDIT_COURSE_DETAILS_TAB_TITLE_XPATH = "//h3[text()='Course Editing']";
        String COURSE_NAME_ERROR_MESSAGE_XPATH = "//p[contains(@class,'text-danger')]";
    }

    public interface AddCoursePage {
        String ADD_COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
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
        String CURRENT_PASSWORD_ERROR_XPATH = "//input[@id='currentPassword']/following-sibling::div";
        String NEW_PASSWORD_ERROR_PROVIDE_XPATH = "//input[@id='newPassword']/following-sibling::div";
        String CONFIRM_PASSWORD_ERROR_XPATH = "//input[@id='confirmNewPassword']/following-sibling::div";
        String ALERT_CHANGE_PASSWORD_XPATH = "//div[contains(@class,'alert-dismissible show')]";
    }

    public interface MentorsTablePage {
        String ADD_MENTOR_BUTTON_XPATH = "//span[text()='Add a mentor']";
        String DISABLE_MENTORS_SWITCH_XPATH = "//label[text()='Disabled Mentors']";
        String SEARCH_INPUT_FIELD_XPATH = "//input[@class='search__searchInput___34nMl']";
        String SORT_NAME_ARROW_XPATH = "//span[text()='Name']";
        String SORT_SURNAME_ARROW_XPATH = "//span[text()='Surname']";
        String SORT_EMAIL_ARROW_XPATH = "//span[text()='Email']";
        String EDIT_BUTTON_XPATH = "//td[@class='text-center']";
        String MENTORS_ROW_XPATH = "//td[not(contains(@class,'text-center'))]";
        String SWITCH_VIEW_BUTTONS_XPATH = "//button[@class = 'btn btn-secondary']";
        String MENTORS_CARD_XPATH = "//div[@class='card']";
        String MENTORS_NOT_FOUND_MESSAGE_SEARS ="//td[text()='Mentor is not found']";
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
        String MENTORS_FIRST_NAME_XPATH="//span[@data-testid='firstName']";
        String MENTORS_LAST_NAME_XPATH="//span[@data-testid='lastName']";
        String MENTOR_EMAIL_NAME_XPATH="//span[@data-testid='email']";
        String LIST_OF_GROUP_LINK="//a[@data-testid='groupLink']";
        String LIST_OF_COURSE_LINK="//a[@data-testid='courseLink']";
    }

    public interface EditMentorsDetailsPage {
        String MENTORS_DETAILS_TAB_XPATH = "//a[text()='Mentor details']";
        String EDIT_MENTOR_TAB_XPATH = "//a[text()='Edit a mentor']";
        String ARROW_BUTTON_XPATH = "//a[contains(@class,'align-items-center')]";
        String FIRST_NAME_INPUT_FIELD_XPATH = "//input[@id='firstName']";
        String SECOND_NAME_INPUT_FIELD_XPATH = "//input[@id='lastName']";
        String EMAIL_INPUT_FIELD_XPATH = "//input[@id='email']";
        String GROUPS_INPUT_FIELD_XPATH = "//input[@id='groupsInput']";
        String LIST_GROUPS_XPATH = "//datalist[@id='group-list']/option";
        String DELETE_GROUP_BUTTON_XPATH = "//button[contains(@class,'delGroup')]";
        String ADD_GROUP_BUTTON_XPATH = "//button[@id='addGroup']";
        String COURSE_INPUT_FIELD_XPATH = "//input[@id='coursesInput']";
        String LIST_COURSES_XPATH = "//datalist[@id='course-list']/option";
        String DELETE_COURSE_BUTTON_XPATH = "//button[contains(@class,'delCourse')]";
        String ADD_COURSE_BUTTON_XPATH = "//button[@id='addCourse']";
        String DISABLE_BUTTON_XPATH = "//span[text()='Lay off']";
        String CLEAR_BUTTON_XPATH = "//button[text()='Reset']";
        String SAVE_BUTTON_XPATH = "//button[text()='Save']";
        String TITLE_XPATH = "//h3[text()='Mentor Editing']";
        String FIRST_NAME_ERROR = "//input[@id='firstName']/parent::div/div";
        String LAST_NAME_ERROR = "//input[@id='lastName']/parent::div/div";
        String EMAIL_ERROR = "//input[@id='email']/parent::div/div";
        String REMOVE_MENTOR_BUTTON="//button[text()='Lay off']";
        String LIST_OF_GROUPS_CARDS="//ul[@data-testid='li-groups']/li";
        String LIST_OF_COURSE_CARDS="//ul[@data-testid='li-courses']/li";
    }

    public interface StudentsPage {
        String PAGE_TITLE_TAG_NAME = "h2";
        String SEARCH_INPUT_BOX_CLASSNAME = "search__searchInput___34nMl";
        String SHOW_DISABLED_SWITCHER_ID = "show-disabled-check";
        String ADD_STUDENT_BUTTON_XPATH = "//*[contains(text(), 'Add a student')]";
        String TABLE_STUDENTS_XPATH = "//tbody";
        String TABLE_HEAD_FIRST_NAME_XPATH = "//span[@lessons.data-sorting-param='firstName']";
        String TABLE_HEAD_LAST_NAME_XPATH = "//span[@lessons.data-sorting-param='lastName']";
        String TABLE_HEAD_EMAIL_XPATH = "//span[@lessons.data-sorting-param='email']";
        String TABLE_ROW_TAG_NAME = "tr";
        String PENCIL_ICON_XPATH = "//td[@class='text-center']";
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
        String CLEAR_BUTTON_XPATH = "//button[text()= 'Reset']";
        String SAVE_BUTTON_XPATH = "//button[text()= 'Save']";
        String FIRST_NAME_ERROR_XPATH = "//input[@name='firstName']/parent::div/div";
        String LAST_NAME_ERROR_XPATH = "//input[@name='lastName']/parent::div/div";
        String EMAIL_ERROR_XPATH = "//input[@name='email']/parent::div/div";
        String GROUPS_ERROR_XPATH = "//div[@class='d-flex flex-column col-md-8']/child::div[2]";

    }

    public interface MyProfile {
        String CHANGE_PASSWORD_BUTTON = "//button";
        String LIST_OF_USER_DATA_XPATH="//div[@class='col-sm-8']";
    }

    public interface RegistrationPage {
        String PAGE_TITLE_TAG_NAME = "h3";
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
        String MODAL_WINDOW_XPATH = "//*[contains(@class,'modal-content')]";
        String MODAL_WINDOW_BUTTON_XPATH = "//button[text()='Back']";
    }
    public interface Pagination{
        String PAGES_XPATH = "//div[contains(@class,'col')]//child::ul[2]//child::button";
        String NEXT_PAGE_ARROW_BUTTON_XPATH = "//div[contains(@class,'col')]//child::ul[3]";
        String FIRST_PAGE = "(//button[contains(.,'1')])[1]";
        String SECOND_PAGE = "(//button[contains(.,'2')])[1]";
        String THIRD_PAGE = "(//button[contains(.,'3')])[1]";
        String FOURTH_PAGE = "(//button[contains(.,'4')])[1]";
        String BACK_ARROW = "(//button[@class='page-link pagination__link___2AEaH'][contains(.,'<')])[1]";
    }
}