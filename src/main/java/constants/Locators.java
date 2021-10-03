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

    public interface Secretaries{
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

    public interface EditSecretary{
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
    public interface UnassignedUsers{
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

//
}
