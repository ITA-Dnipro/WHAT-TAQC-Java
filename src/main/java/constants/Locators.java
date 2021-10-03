package constants;

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
    
    public interface Secretaries {
        String ADD_SECRETARY_BUTTON_XPATH = "//span[contains(text(),'Add a secretary')]";
        String SWITCH_VIEW_DISABLED_SECRETARIES_XPATH = "//label[contains(@class, 'custom-control-label list-of-secretaries')]";
        String SEARCH_WINDOW_SECRETARIES_NAME_XPATH ="//div[@class ='search__search___13vn_']";
        String SECRETARY_TABLE_HEAD_NAME_XPATH = "//span[contains(text(),'Name')]";
        String SECRETARY_TABLE_HEAD_SURNAME_XPATH = "//span[contains(text(),'Surname')]";
        String SECRETARY_TABLE_HEAD_EMAIL_XPATH = "//span[contains(text(),'Email')]";
        String SECRETARY_PAGE_TITLE_XPATH = "//h2[text()='Secretaries']";
        String SECRETARY_EDIT_ICON_XPATH = "//td[@class='text-center']";
        String SECRETARY_PAGE_TABLE_XPATH = "//table[@class='table table-hover']";
    }

    public interface EditSecretary {
        String ARROW_BUTTON_XPATH = "//*[@class ='bi bi-arrow-left']";
        String SECRETARY_DETAILS_TAB_XPATH = "//a [contains (@class,'nav-item nav-link tab__tab___1xEn9 tab__active___3e65x')] ";
        String EDIT_SECRETARY_TAB_XPATH = "//a [contains (@class,'nav-item nav-link tab__tab___1xEn9 tab__active___3e65x')]";
        String SECRETARIES_FIRST_NAME_WINDOW_XPATH ="//input[@name='firstName']";
        String SECRETARIES_LAST_NAME_WINDOW_XPATH ="//input[@name='lastName']";
        String SECRETARIES_EMAIL_WINDOW_XPATH ="//input[@name='email']";
        String SECRETARIES_LAY_OFF_BUTTON_XPATH = "//button[contains(text (), 'Lay off')]";
        String SECRETARIES_CLEAR_BUTTON_XPATH = "//button[contains(text (), 'Clear')]";
        String SECRETARIES_SAVE_BUTTON_XPATH = "//button[contains(text (), 'Save')]";


    }
    public interface UnassignedUsers {
        String UNASSIGNED_USERS_SEARCH_WINDOW_PERSONS_NAME_XPATH ="//input[@class='search__searchInput___34nMl']";
        String UNASSIGNED_USERS_PAGINATION_XPATH = "//li[@class='page-item']";
        String UNASSIGNED_USERS_TABLE_HEAD_NAME_XPATH = "//span[contains(text(),'Name')]";
        String UNASSIGNED_USERS_TABLE_HEAD_SURNAME_XPATH = "//span[contains(text(),'Surname')]";
        String UNASSIGNED_USERS_TABLE_HEAD_EMAIL_XPATH = "//span[contains(text(),'Email')]";
        String UNASSIGNED_USERS_CHOOSE_ROLE_XPATH = "//select[@class='unassigned-list__select___UNLgl']";
        String UNASSIGNED_USERS_CHOOSE_STUDENT_ROLE_XPATH = "////option [contains (@value, '1')]";
        String UNASSIGNED_USERS_CHOOSE_MENTOR_ROLE_XPATH = "////option [contains (@value, '2')]";
        String UNASSIGNED_USERS_CHOOSE_SECRETARY_ROLE_XPATH = "////option [contains (@value, '3')]";
        String UNASSIGNED_USERS_ADD_ROLE_BUTTON_XPATH = "//button[contains(text (), 'Add role')]";
    }

    public interface Courses {
        String VIEW_TABLE_CARD_XPATH = "//button[@class='btn btn-secondary']//";
        String SEARCH_FIELD_XPATH = "//input[@type='text']";
        String ADD_COURSE_BUTTON_XPATH = "//span[.='Add a course']";
        String SORT_TITLE_BUTTON_XPATH = "//span[@data-sorting-param='name']";
        String COURSES_TABLE_LIST_ADMIN_SECRETAR_XPATH = "//td[not(contains(@class,'text-center'))]";
        String EDIT_BUTTON_ADMIN_SECRETARY_XPATH = "//td[@class='text-center']";
        String COURSES_PAGINATION_XPATH = "//li[@class='page-item']";
        String CHANGE_ROWS_NUMBER_BUTTON_ID = "change-visible-people";
//
    }

    public interface CourseDetailsPage {
        String ARROW_BUTTON_XPATH = "//a[contains(@class,'align-items-center')]";
        String COURSE_DETAILS_TAB_XPATH = "//a[contains(@class,'1xEn9')and contains(text(),'Course details')]";
        String EDIT_COURSE_DETAILS_TAB_XPATH = "//a[contains(@class,'1xEn9')and contains(text(),'Edit course details')]";
        String COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
        String DELETE_BUTTON_XPATH = "//button[contains(text(),'Delete')]";
        String CLEAR_BUTTON_XPATH = "//button[@type='reset']";
        String SAVE_BUTTON_XPATH = "//button[@type='submit']";
        String CANCEL_BUTTON_CONFIRM_ACTION_XPATH = "//button[@type='button'and contains(text(),'Cancel')]";
        String DELETE_BUTTON_CONFIRM_ACTION_XPATH = "//button[@type='submit'and contains(text(),'Delete')]";
        String CLOSE_BUTTON_CONFIRM_ACTION_XPATH = "//button[@class='close']";
    }

    public interface AddCoursePage {
        String COURSE_NAME_INPUT_FIELD_XPATH = "//input[@name='name']";
        String CANCEL_BUTTON_ADD_COURSE_XPATH = "//a[@data-testid='cancelBtn']";
        String SAVE_BUTTON_XPATH = "//button[@id='addCourseSubmit']";
    }

    public interface ChangePasswordPage {
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
    }
    public interface ListOfMentorsPage{
        String ADD_MENTOR_BUTTON_XPATH = "//span[text()='Add a mentor']";
        String DISABLE_MENTORS_SWITCH_XPATH = "//input[@id='disabledMentors']";
        String SEARCH_INPUT_FIELD_XPATH = "//input[@class='search__searchInput___34nMl']";
        String SWITCH_VIEW_BUTTONS_XPATH = "//button[@class = 'btn btn-secondary']";
        String MENTORS_CARD_XPATH="//div[@class='card']";
        String EDIT_BUTTON_XPATH="//*[@class='blocks__scale___2EfN8']";
    }
    public interface MentorsDetailsPage{
        String MENTORS_DETAILS_TAB_XPATH="//a[text()='Mentor details']";
        String EDIT_MENTOR_TAB_XPATH="//a[text()='Edit a mentor']";
        String ARROW_BUTTON_XPATH = "//a[contains(@class,'align-items-center')]";
    }
    public interface EditMentorsDetailsPage{
        String MENTORS_DETAILS_TAB_XPATH="//a[text()='Mentor details']";
        String EDIT_MENTOR_TAB_XPATH="//a[text()='Edit a mentor']";
        String ARROW_BUTTON_XPATH = "//a[contains(@class,'align-items-center')]";
        String FIRSTNAME_INPUT_FIELD_XPATH="//input[@id='firstName']";
        String SECONDNAME_INPUT_FIELD_XPATH="//input[@id='lastName']";
        String EMAIL_INPUT_FIELD_XPATH="//input[@id='email']";
        String GROUPS_INPUT_FIELD_XPATH="//input[@id='groupsInput']";
        String LIST_GROUPS_XPATH="//datalist[@id='group-list']";
        String DELETE_GROUP_BUTTON_XPATH="//button[contains(@class,'delGroup')]";
        String ADD_GROUP_BUTTON_XPATH="//button[@id='addGroup']";
        String COURSE_INPUT_FIELD_XPATH= "//input[@id='coursesInput']";
        String LIST_COURSES_XPATH="//datalist[@id='course-list']";
        String DELETE_COURSE_BUTTON_XPATH= "//button[contains(@class,'delCourse')]";
        String ADD_COURSE_BUTTON_XPATH="//button[@id='addCourse']";
        String DISABLE_BUTTON_XPATH="//button[text()='Disable']";
        String CLEAR_BUTTON_XPATH="//button[text()='Clear']";
        String SAVE_BUTTON_XPATH= "//button[text()='Save']";
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